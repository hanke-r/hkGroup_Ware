package com.hanker.Controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanker.DTO.MemberVO;
import com.hanker.DTO.TmpTokenVO;
import com.hanker.Service.LoginService;
import com.hanker.Util.EmailToken;
import com.hanker.Util.SecurityUtil;
import com.hanker.Util.Validation;

@Controller
public class LoginController {
	
	@Inject
	private LoginService loginService;
	
	@Inject
	private EmailToken eToken;

	@RequestMapping(value="/login/loginForm", method=RequestMethod.GET)
	public void getLoginForm() throws Exception{
		
	}
	
	@RequestMapping(value="/login/loginForm", method=RequestMethod.POST)
	public String postLoginForm() throws Exception{
		
		
		return "login/loginForm";
	}
	@RequestMapping(value="/login/register", method=RequestMethod.GET)
	public void getRegister() throws Exception{
	}
	
	@RequestMapping(value="/login/ajaxRegister", method=RequestMethod.POST)
	public String regiChck(Model model, HttpServletRequest req) throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(req.getParameter("ID"));
		memberVO.setPassword(req.getParameter("PW"));
		memberVO.setEmail(req.getParameter("EMAIL"));
		memberVO.setUname(req.getParameter("NAME"));
		memberVO.setPhnumber(req.getParameter("PHONE"));
		memberVO.setEnabled("0");
		
		String pwd = memberVO.getPassword();
		
		String validChck = Validation.register(memberVO.getEmail(), memberVO.getPhnumber());
		
		String result = "SUCCESS";
		
		if(validChck == "SUCCESS") {
			SecurityUtil sec = new SecurityUtil();
			String encPwd = sec.encryptSHA256(pwd);
			memberVO.setPassword(encPwd);
			
			result = "SUCCESS";
		} else if(validChck == "phError") {
			result = "phError";
		} else if(validChck == "emailError") {
			result = "emailError";
		}
		
		TmpTokenVO tmpTokenVO = new TmpTokenVO();
		tmpTokenVO.setEmail(req.getParameter("EMAIL"));
		// email 인증여부 확인
		String emailCertChck = loginService.emailCertChck(tmpTokenVO);
		System.out.println("이메일 인증여부 = " + emailCertChck);
		if(Integer.parseInt(emailCertChck) == 0) {
			result = "emailCertError";
		} else {
			result = "SUCCESS";
		}
		
		if(result == "SUCCESS") {
			loginService.memRegister(memberVO);
			loginService.memGradeInsert(memberVO);
		}
		model.addAttribute("SC", result);
		
		
		return "jsonView";
	}
	
	@RequestMapping(value="/login/dupliChck", method=RequestMethod.POST)
	public String dupliChck(Model model, HttpServletRequest req) throws Exception{
		
		String userName = req.getParameter("duId");
		
		boolean dupliId = loginService.dupliChck(userName);
		
		String result = "";
		
		if(!dupliId) {
			result = "SUCCESS";
		} else {
			result = "DUPLICATION";
		}
		
		model.addAttribute("SC", result);
		
		return "jsonView";
	}
	
	// email token 발송
	@RequestMapping(value="/login/emailToken", method=RequestMethod.POST)
	public String emailToken(Model model, HttpServletRequest req) throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(req.getParameter("EMAIL"));
		
		TmpTokenVO tmpTokenVO = new TmpTokenVO();
		
		// 이미 가입된 email여부 확인
		boolean newNOldChck = loginService.indiEmailChck(tmpTokenVO);
		
		
		// 이미 가입된 이메일인지 확인
		boolean joinEmailChck = loginService.joinEmailChck(memberVO.getEmail()); 
		
		if(joinEmailChck) {
			model.addAttribute("SC", "OVERLAP");
			
			return "jsonView";
		}
		// join = 0, idSearch = 1, pwSearch = 2
		int flag = eToken.EmailTokenSending(memberVO.getEmail(), 0);
		
		if(flag == 0) {
			model.addAttribute("SC", flag);
			
			return "jsonView";
		} else {
			String str = "SUCCESS";
			
			tmpTokenVO.setEmail(memberVO.getEmail());
			tmpTokenVO.setToken(flag);
			
			// 이메일이 있으면 true OR 없으면 false
			if(newNOldChck) {
				// 인증 후 인증을 다시 누르면 인증정보 초기화
				loginService.tmpTokenUpd(tmpTokenVO);
			} else {
				loginService.tmpTokenIns(tmpTokenVO);
			}
			
			
			model.addAttribute("SC", str);
			return "jsonView";
		}
	}
	
	// Email Token Check
	@RequestMapping(value="/login/tokenChck", method=RequestMethod.POST)
	public String tokenCheck(Model model, HttpServletRequest req) throws Exception{
		String result = "";
		
		TmpTokenVO tmpTokenVO = new TmpTokenVO();
		tmpTokenVO.setEmail(req.getParameter("EMAIL"));
		int inpToken = Integer.parseInt(req.getParameter("TOKEN"));

		int tbToken = loginService.tbToken(tmpTokenVO);
		
		// 인증 SUCCESS
		if(tbToken == inpToken) {
			loginService.emCertChange(tmpTokenVO);
			result = "SUCCESS";
		// 인증 FAILED
		} else {
			result = "FALSE";
		}
		
		model.addAttribute("SC", result);
		return "jsonView";
	}
	
	// ID, PW찾기
	@RequestMapping(value="/login/userInfoSer", method=RequestMethod.GET)
	public void userInfoSer() throws Exception{
		
	}
	
	//ID찾기 이메일 인증
	@RequestMapping(value="/login/idSearch", method=RequestMethod.POST)
	public String idSearch(Model model, HttpServletRequest req) throws Exception{
		
		TmpTokenVO tmpTokenVO = new TmpTokenVO();
		tmpTokenVO.setEmail(req.getParameter("EMAIL"));
		
		boolean emailYN = loginService.joinEmailChck(tmpTokenVO.getEmail());
		
		if(!emailYN) {
			model.addAttribute("SC", "FAILED");
		} else {
			
			// join = 0, idSearch = 1, pwSearch = 2
			int flag = eToken.EmailTokenSending(tmpTokenVO.getEmail(), 1);
			tmpTokenVO.setToken(flag);
			loginService.tmpTokenUpd(tmpTokenVO);
			
			model.addAttribute("SC", "SUCCESS");
		}
		
		return "jsonView";
	}

	/*
	 * ID 찾기
	 * Email 인증 토큰 확인
	 * */  
	@RequestMapping(value="/login/ajaxETokenChck", method=RequestMethod.POST)
	public String ajaxETokenChck(Model model, @RequestParam("ETOKEN") int token, @RequestParam("EMAIL") String email) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		
		TmpTokenVO tmpTokenVO = new TmpTokenVO();
		tmpTokenVO.setEmail(email);
		tmpTokenVO.setToken(token);
		
		int tmpToken = loginService.tbToken(tmpTokenVO);
		
		String result = "";
		// 인증 SUCCESS
		if (tmpToken == tmpTokenVO.getToken()) {
			loginService.emCertChange(tmpTokenVO);
			map = loginService.idSearch(tmpTokenVO.getEmail());
			
			result = "SUCCESS";
		// 인증 FAILED
		} else {
			result = "FALSE";
		}
		
		map.put("result", result);
		
		System.out.println("map = " + map);
		
		model.addAttribute("SC", map);
		return "jsonView";
	}
}
