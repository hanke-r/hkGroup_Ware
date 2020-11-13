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

import com.hanker.DTO.FrBoardVO;
import com.hanker.DTO.RepleFrVO;
import com.hanker.DTO.RepleVO;
import com.hanker.Service.FrBoardService;
import com.hanker.Service.HkGroupMainService;

@Controller
public class FrBoardController {

	@Inject
	private FrBoardService frBoardService;
	
	@Inject
	private HkGroupMainService hkGroupMainService;
	
	//자유게시판 list
	@RequestMapping(value="/frBoard/frBoardMain", method=RequestMethod.GET)
	public String hkMain(Model model) throws Exception{
		
		List<FrBoardVO> list = frBoardService.frList();
		
		model.addAttribute("list", list);
		
		return "frBoard/frBoardMain";
	}
	
	// 자유게시판 글 작성
	@RequestMapping(value="/frBoard/frbWrite", method=RequestMethod.GET)
	public String frBoardWriteView(Principal principal, Model model) throws Exception{
		
		String username = principal.getName();
		String name = hkGroupMainService.getWriter(username);
		
		model.addAttribute("WRITER", name);
		
		return "/frBoard/frbWrite";
	}
	
	// 자유게시판 글 insert
	@RequestMapping(value="/frBoard/frbWrt", method=RequestMethod.POST)
	public String frbWrt(Model model, HttpServletRequest req, FrBoardVO frBoardVO) throws Exception{
		frBoardVO.setFrtitle(req.getParameter("TITLE"));
		frBoardVO.setFrwriter(req.getParameter("WRITER"));
		frBoardVO.setFrcontent(req.getParameter("CONTENT"));
		
		frBoardService.frbWrt(frBoardVO);
		
		return "jsonView";
	}
	
	// 자유게시판 글 상세보기
	@RequestMapping(value="/frBoard/frBoardView", method=RequestMethod.GET)
	public String frBoardView(Model model, @RequestParam("frno") int frno, FrBoardVO frBoardVO, Principal principal) throws Exception{
		String username = principal.getName();
		String name = hkGroupMainService.getWriter(username);
		
		// 조회수		
		frBoardService.frbViewCnt(frno);
		
		frBoardVO = frBoardService.frBoardView(frno);
		model.addAttribute("FRVIEW", frBoardVO);
		
		if(name.equals(frBoardVO.getFrwriter())) {
			model.addAttribute("SC", "SUCCESS");
		} else {
			model.addAttribute("SC","FAIL");
		}
		
		
		return "frBoard/frbView";
	}
	
	// 자유게시판 글 수정
	@RequestMapping(value="/frBoard/frbUpdate", method=RequestMethod.POST)
	public String frbUpdate(HttpServletRequest req, FrBoardVO frBoardVO) throws Exception{
		
		frBoardVO.setFrno(Integer.parseInt(req.getParameter("FRNO")));
		frBoardVO.setFrtitle(req.getParameter("TITLE"));
		frBoardVO.setFrcontent(req.getParameter("CONTENT"));
		
		frBoardService.frbUpdate(frBoardVO);
		
		return "jsonView";
	}
	
	// 댓글
	@RequestMapping(value="/frBoard/doReple", method=RequestMethod.POST)
	public String doReple(Model model, Principal principal, @RequestParam("FRNO") int frno, @RequestParam("RETITLE") String recontent) throws Exception{
		
		String username = principal.getName();
		String name = frBoardService.getWriter(username);
		int userNumber = frBoardService.getUserNum(username);
		
		RepleFrVO repleFrVO = new RepleFrVO();
		repleFrVO.setFrno(frno);
		repleFrVO.setRef_writer(name);
		repleFrVO.setRef_content(recontent);
		repleFrVO.setUno(userNumber);
		
		frBoardService.insReple(repleFrVO);
		
		model.addAttribute("SC", repleFrVO);
		return "jsonView";
	}
	
	@RequestMapping(value="/frBoard/viewReple", method=RequestMethod.POST)
	public String viewReple(Model model, @RequestParam("FRNO") int frno) throws Exception{
		
		List<RepleFrVO> listRe = frBoardService.viewReple(frno);
		
		model.addAttribute("SC", listRe);
		
		return "jsonView";
	}
}
