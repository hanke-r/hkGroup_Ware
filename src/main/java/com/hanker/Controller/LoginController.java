package com.hanker.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.MemberVO;
import com.hanker.Service.LoginService;
import com.hanker.Util.SecurityUtil;

@Controller
public class LoginController {
	
	@Inject
	private LoginService loginService;
	
	@RequestMapping(value="/login/loginForm", method=RequestMethod.GET)
	public void getLoginForm() throws Exception{
		
	}
	
	@RequestMapping(value="/login/loginForm", method=RequestMethod.POST)
	public String postLoginForm() throws Exception{
		
		System.out.println("123");
		
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
		memberVO.setEnabled("0");
		
		String pwd = memberVO.getPassword();
		
		SecurityUtil sec = new SecurityUtil();
		String encPwd = sec.encryptSHA256(pwd);
		
		memberVO.setPassword(encPwd);
		
		loginService.memRegister(memberVO);
		loginService.memGradeInsert(memberVO);
		
		model.addAttribute("SC", "SUCCESS");
		
		return "jsonView";
	}
	

}
