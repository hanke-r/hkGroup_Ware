package com.hanker.Controller;

import java.security.Principal;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hanker.DTO.HkVisitVO;
import com.hanker.Service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/loginScsHandler", method=RequestMethod.GET)
	public String loginScsHandler(Principal principal, HkVisitVO hkVisitVO) throws Exception{
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if(ip == null) {
			ip = req.getRemoteAddr();
		}
		String name = principal.getName();
		
		hkVisitVO.setVisit_ip(ip);
		hkVisitVO.setVisit_id(name);
		
		homeService.visitorIns(hkVisitVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		
		HashMap<String, Object> map = new HashMap<>();
		
		int totalVisitCount = homeService.totalVisitCount();
		int monthVisitCount = homeService.monthVisitCount();
		int todayVisitCount = homeService.todayVisitCount();
		
		map.put("total", totalVisitCount);
		map.put("month", monthVisitCount);
		map.put("today", todayVisitCount);
		
		model.addAttribute("RS", map);
		return "home";
	}
}
