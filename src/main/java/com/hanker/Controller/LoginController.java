package com.hanker.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.MemberVO;
import com.hanker.Service.LoginService;
import com.hanker.Util.SecurityUtil;
import com.hanker.Util.Validation;

@Controller
public class LoginController {
	
	@Inject
	private LoginService loginService;
	
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
		
		String result = "";
		
		if(validChck == "SUCCESS") {
			SecurityUtil sec = new SecurityUtil();
			String encPwd = sec.encryptSHA256(pwd);
			
			memberVO.setPassword(encPwd);
			
			loginService.memRegister(memberVO);
			loginService.memGradeInsert(memberVO);
			
			result = "SUCCESS";
		} else if(validChck == "phError") {
			
			result = "phError";
		} else if(validChck == "emailError") {
			result = "emailError";
		}
		
		model.addAttribute("SC", result);
		
		return "jsonView";
	}
	

}
