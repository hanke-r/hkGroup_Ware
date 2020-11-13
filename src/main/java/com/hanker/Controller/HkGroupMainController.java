package com.hanker.Controller;

import java.io.File;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.DTO.RepleVO;
import com.hanker.Service.HkGroupMainService;

@Controller
public class HkGroupMainController {
	
	@Inject
	private HkGroupMainService hkGroupMainService;
	
	@RequestMapping(value="/hkGroup/board", method=RequestMethod.GET)
	public String hkMain(Model model, HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		
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
	public String BoardView(Model model, @RequestParam("nbno") int nbno, Principal principal) throws Exception{
		
		// 조회수
		hkGroupMainService.boardViewCnt(nbno);
		
		String username = principal.getName();
		String name = hkGroupMainService.getWriter(username);
		
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		noticeBoardVO = hkGroupMainService.noticeBoardView(nbno);
		
		model.addAttribute("NBVIEW", noticeBoardVO);
		
		if(name.equals(noticeBoardVO.getNbwriter())) {
			model.addAttribute("SC", "SUCCESS");
		} else {
			model.addAttribute("SC","FAIL");
		}
		
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
	
	@RequestMapping(value="/hkGroup/nbUpdate", method=RequestMethod.POST)
	public String nbUpdate(Model model, HttpServletRequest req, NoticeBoardVO nbVO) throws Exception{
		
		nbVO.setNbno(Integer.parseInt(req.getParameter("NBNO")));
		nbVO.setNbtitle(req.getParameter("TITLE"));
		nbVO.setNbcontent(req.getParameter("CONTENT"));
		
		hkGroupMainService.nbUpdate(nbVO);
		
		return "jsonView";
	}
	
	@RequestMapping(value="/fileUpload/post", method=RequestMethod.POST)
	public String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		
		Iterator<String> itr =  multipartRequest.getFileNames();
        
        String filePath = "D:\\Han\\95.프로젝트\\HkGroupWare\\19.EX\\1.데이터"; //설정파일로 뺀다.
        
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
            
            /* 기존 주석처리
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            String originFileName = mpf.getOriginalFilename();
            System.out.println("FILE_INFO: "+originFileName); //받은 파일 리스트 출력'
            */
            
            MultipartFile mpf = multipartRequest.getFile(itr.next());
     
            String originalFilename = mpf.getOriginalFilename(); //파일명
            originalFilename = new String(originalFilename.getBytes("8859_1"), "utf-8");
            
            String fileFullPath = filePath+"\\"+originalFilename; //파일 전체 경로
     
            try {
                //파일 저장
                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
                
                System.out.println("originalFilename => "+originalFilename);
                System.out.println("fileFullPath => "+fileFullPath);
     
            } catch (Exception e) {
                System.out.println("postTempFile_ERROR======>"+fileFullPath);
                e.printStackTrace();
            }
                         
       }
		
		return "success";
	}
}
