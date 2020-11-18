package com.hanker.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanker.DTO.InqueryVO;
import com.hanker.Service.QuestService;

@Controller
public class QuestionController {
	
	@Inject
	private QuestService questService;
	
	
	@RequestMapping(value="/question/qsBoardMain", method=RequestMethod.GET)
	public String qsBoardMain(Model model, Principal principal) throws Exception{
		//현재 로그인한 아이디
		String loginId = principal.getName();
		
		HashMap<String,Object> map = new HashMap<>();
		
		map = questService.userInfo(loginId);
		
		List<InqueryVO> list = questService.inqList();
		
		model.addAttribute("list", list);
		model.addAttribute("id", map);
		return "/question/qsBoardMain";
	}
	
	@RequestMapping(value="/question/inqWriteView", method=RequestMethod.GET)
	public String inqWriteView(Model model, Principal principal, InqueryVO inqVO) throws Exception{
		
		HashMap<String, Object> map = new HashMap<>();
		
		String username = principal.getName();
		map = questService.userInfo(username);
		
		inqVO.setInq_writer(map.get("uname").toString());
		inqVO.setInq_email(map.get("email").toString());
		
		model.addAttribute("IQ", inqVO);
		
		return "question/inqWriteView";
	}
	
	@RequestMapping(value="/question/inqWrite", method=RequestMethod.POST)
	public String inqWrite(InqueryVO inqVO, HttpServletRequest req, Principal principal) throws Exception{
		
		HashMap<String, Object> map = new HashMap<>();
		String username = principal.getName();
		map = questService.userInfo(username);
		
		inqVO.setUno((Integer) map.get("uno"));
		inqVO.setInq_writer(req.getParameter("WRITER"));
		inqVO.setInq_email(req.getParameter("EMAIL"));
		inqVO.setInq_title(req.getParameter("TITLE"));
		inqVO.setInq_content(req.getParameter("CONTENT"));
		
		questService.inqWrite(inqVO);
		
		
		return "jsonView";
	}
	
	@RequestMapping(value="/question/inqView", method=RequestMethod.GET)
	public String inqView(Model model, InqueryVO inqVO, @RequestParam("inq_no") int inq_no) throws Exception{
		
		inqVO = questService.inqView(inq_no);
		
		model.addAttribute("INQ", inqVO);
		
		return "question/inqView";
	}
	
	@RequestMapping(value="/question/inqReply", method=RequestMethod.POST)
	public String inqReply(Model model, @RequestParam("INQ_NO") int inq_no, @RequestParam("RECONTENT") String inq_reply) throws Exception{
		
		InqueryVO inqVO = new InqueryVO();
		inqVO.setInq_no(inq_no);
		inqVO.setInq_reply(inq_reply);
		
		questService.inqReply(inqVO);
		
		return "jsonView";
	}
}
