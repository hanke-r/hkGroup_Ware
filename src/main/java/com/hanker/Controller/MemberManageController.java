package com.hanker.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

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
}
