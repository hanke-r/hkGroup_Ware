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
import com.hanker.DTO.RepleVO;
import com.hanker.Service.HkGroupMainService;

@Controller
public class HkGroupMainController {
	
	@Inject
	private HkGroupMainService hkGroupMainService;
	
	@RequestMapping(value="/hkGroup/board", method=RequestMethod.GET)
	public String hkMain(Model model) throws Exception{
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
	
	@RequestMapping(value="/hkGroup/doReple", method=RequestMethod.POST)
	public String doReple(Model model, Principal principal, @RequestParam("NBNO") int nbno, @RequestParam("RETITLE") String recontent) throws Exception{
		String username = principal.getName();
		String name = hkGroupMainService.getWriter(username);
		int userNumber = hkGroupMainService.getUserNum(username);
		
		RepleVO repleVO = new RepleVO();
		repleVO.setNbno(nbno);
		repleVO.setRewriter(name);
		repleVO.setRecontent(recontent);
		repleVO.setUno(userNumber);
		hkGroupMainService.insReple(repleVO);
		
		model.addAttribute("SC", repleVO);
		
		return "jsonView";
	}
	
	@RequestMapping(value="/hkGroup/viewReple", method=RequestMethod.POST)
	public String viewReple(Model model, @RequestParam("NBNO") int nbno) throws Exception{
		
		List<RepleVO> listRe = hkGroupMainService.viewReple(nbno);
		
		model.addAttribute("SC", listRe);
		
		return "jsonView";
	}
}
