package com.hanker.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.Service.FrBoardService;

@Controller
public class FrBoardController {

	@Inject
	private FrBoardService frBoardService;
	
	@RequestMapping(value="/frBoard/frBoardMain", method=RequestMethod.GET)
	public String hkMain(Model model) throws Exception{
		
		return "frBoard/frBoardMain";
	}
}
