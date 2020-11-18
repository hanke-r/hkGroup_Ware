package com.hanker.Controller;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.DTO.NoticeFileVO;
import com.hanker.DTO.RepleVO;
import com.hanker.Service.HkGroupMainService;
import com.hanker.Util.FileDownload;
import com.hanker.Util.FilePrepareDel;

@Controller
public class HkGroupMainController {
	
	@Inject
	private HkGroupMainService hkGroupMainService;
	// orgfilename, file Size 
	List<HashMap> FILEINFO = new ArrayList<HashMap>();
	private int INDEX;
	private String FSIZE;
	
	@RequestMapping(value="/hkGroup/board", method=RequestMethod.GET)
	public String hkMain(Model model, HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		List<NoticeBoardVO> list = hkGroupMainService.listAll();
		
		model.addAttribute("list", list);
		
		return "hkGroup/board";
	}
	
	@RequestMapping(value="/hkGroup/boardWrite", method=RequestMethod.GET)
	public void boardWrite(Model model, Principal principal) throws Exception{
		FILEINFO = new ArrayList<HashMap>();
		
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
		
		int noticeBoardNo = hkGroupMainService.getNbno();
		
		NoticeFileVO nfVO = new NoticeFileVO();
		try {
			for(int i = 0 ; i < FILEINFO.size() ; i++) {
				nfVO.setNf_filename(FILEINFO.get(i).get("filename").toString());
				nfVO.setNf_path(FILEINFO.get(i).get("path").toString());
				nfVO.setNf_size(FILEINFO.get(i).get("size").toString());
				nfVO.setNf_fullpath(nfVO.getNf_path() + nfVO.getNf_filename());
				nfVO.setNbno(noticeBoardNo);
				
				hkGroupMainService.fileUpload(nfVO);
			}
			// 파일 첨부 시 nb_fstat 0 → 1 변경
			if(FILEINFO.size() >= 1) {
				hkGroupMainService.updNoBoard(noticeBoardNo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "jsonView";
	}
	
	@RequestMapping(value="/hkGroup/boardView", method=RequestMethod.GET)
	public String BoardView(Model model, @RequestParam("nbno") int nbno, Principal principal) throws Exception{
		
		// 조회수
		hkGroupMainService.boardViewCnt(nbno);
		
		// nb (Title, Content, Writer, ViewCnt, Regdate)
		String username = principal.getName();
		String name = hkGroupMainService.getWriter(username);
		
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		noticeBoardVO = hkGroupMainService.noticeBoardView(nbno);
		
		// nbFile
		List<NoticeFileVO> nfVO = hkGroupMainService.nbFileList(nbno);
		
		model.addAttribute("NBVIEW", noticeBoardVO);
		model.addAttribute("NBFILE", nfVO);
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
	
	@RequestMapping(value = "/fileUpload/post") //ajax에서 호출하는 부분
    @ResponseBody
    public String upload(MultipartHttpServletRequest multipartRequest) throws Exception{ //Multipart로 받는다.
        HashMap<String, Object> map = new HashMap<String, Object>();
		
        Iterator<String> itr =  multipartRequest.getFileNames();
        
        String filePath = "D:/Han/95.프로젝트/HkGroupWare/19.EX"; //설정파일로 뺀다.
        
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
            
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            
            String fileSize = String.valueOf(mpf.getSize());
            
            String originalFilename = new String(mpf.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //파일명
            
            map.put("filename", originalFilename);
            map.put("size", fileSize);
            map.put("path", filePath);
            FILEINFO.add(map);
            String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
            try {
                //파일 저장
                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
     
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
       }
        
       return "success";
    }
	
	// 작성 전 Drag & Drop 파일리스트 삭제 처리
	@RequestMapping(value="/hkGroup/fsDel", method=RequestMethod.POST)
	public String fileServerDel(@RequestParam("ORGFN") String orgFileName) throws Exception{
		String filePath = "D:\\Han\\95.프로젝트\\HkGroupWare\\19.EX\\";
		
		for(int i = 0 ; i < FILEINFO.size(); i++) {
			if(FILEINFO.get(i).get("filename").equals(orgFileName)) {
				FILEINFO.remove(i);
			}
		}
		FilePrepareDel filePrepareDel = new FilePrepareDel();
		filePrepareDel.FileServerDel(orgFileName, filePath);
		
		return "jsonView";
	}
	
	//파일 다운로드 처리
	@ResponseBody
	@RequestMapping(value="/hkGroup/fileDown", method=RequestMethod.GET)
	public String fileDown(HttpServletRequest req, HttpServletResponse rep, Model model) throws Exception{

		FileDownload fd = new FileDownload();
		fd.eFileDownLoad(req, rep);
		
		
		return "jsonView";
	}
}
