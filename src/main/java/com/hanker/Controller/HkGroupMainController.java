package com.hanker.Controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.Service.HkGroupMainService;

@Controller
public class HkGroupMainController {
	
	@Inject
	private HkGroupMainService hkGroupMainService;
	
	@RequestMapping(value="/hkGroup/board", method=RequestMethod.GET)
	public String hkMain(Model model) throws Exception{
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		List<NoticeBoardVO> list = hkGroupMainService.listAll();
		
		
		model.addAttribute("list", list);
		
		return "hkGroup/board";
	}
	
	@RequestMapping(value="/hkGroup/boardWrite", method=RequestMethod.GET)
	public void boardWrite(Model model, Principal principal) throws Exception{

		String username = principal.getName();
		
		String name = hkGroupMainService.getWriter(username);
		
		model.addAttribute("WRITER", name);
	}
	
	@RequestMapping(value="/hkGroup/ajaxGetWrite", method=RequestMethod.POST)
	public String ajaxGetWrite(Model model, HttpServletRequest req) throws Exception{
		
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		noticeBoardVO.setNbtitle(req.getParameter("TITLE"));
		noticeBoardVO.setNbwriter(req.getParameter("WRITER"));
		noticeBoardVO.setNbcontent(req.getParameter("CONTENT"));
		
		hkGroupMainService.noticeBoardWrite(noticeBoardVO);
		
		return "jsonView";
	}
	
	@RequestMapping(value="/hkGroup/boardView", method=RequestMethod.GET)
	public String BoardView(Model model, @RequestParam("nbno") int nbno) throws Exception{
		
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		noticeBoardVO = hkGroupMainService.noticeBoardView(nbno);
		
		model.addAttribute("NBVIEW", noticeBoardVO);
		
		return "hkGroup/boardView";
	}
}
