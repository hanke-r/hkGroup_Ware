package com.hanker.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.MemberVO;
import com.hanker.Service.MemberService;

@Controller
public class MemberManageController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="/admin/adminPage", method=RequestMethod.GET)
	public String GetMemManage(Model model) throws Exception{
		MemberVO memberVO = new MemberVO();
		
		List<MemberVO> list = memberService.memList(memberVO);
		
		model.addAttribute("list", list);
		
		System.out.println("list = " + list);
		
		return "admin/adminPage";
	}
	
	@RequestMapping(value="/admin/memChck", method=RequestMethod.POST)
	public String memberCheck(Model model ,HttpServletRequest req) throws Exception{
		
		String userId = req.getParameter("userId");

		memberService.memGradeChg(userId);
		memberService.memCheck(userId);
		
		model.addAttribute("sc", "sc");
		
		return "jsonView";
	}
	
	@RequestMapping(value="/admin/memExpire", method=RequestMethod.POST)
	public String memExpire(Model model, HttpServletRequest req) throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(req.getParameter("userId"));
		
		memberService.memExpire(memberVO);
		
		model.addAttribute("SC","SUCCESS");
		return "jsonView";
	}
}
