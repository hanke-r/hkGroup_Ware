package com.hanker.Controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.MemberVO;
import com.hanker.Service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Principal principal, Model model) throws Exception{
		
		MemberVO memberVO = new MemberVO();
		
		List<MemberVO> newMemList = homeService.memNewList();
		
		model.addAttribute("newMemList", newMemList);
		
		return "home";
	}
}
