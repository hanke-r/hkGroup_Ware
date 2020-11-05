package com.hanker.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.Service.HkGroupMainService;

@Controller
public class HkGroupMainController {
	
	@Inject
	private HkGroupMainService hkGroupMainService;

	@RequestMapping(value="/hkGroup/board", method=RequestMethod.GET)
	public String hkMain(Model model) throws Exception{
		
		List<NoticeBoardVO> list = hkGroupMainService.listAll();
		
		System.out.println("list = " + list);
		
		model.addAttribute("list", list);
		return "jsonView";
	}
}
