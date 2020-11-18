package com.hanker.Service;

import java.util.List;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.DTO.NoticeFileVO;
import com.hanker.DTO.RepleVO;

public interface HkGroupMainService {

	public List<NoticeBoardVO> listAll() throws Exception;

	// 작성자 불러오기
	public String getWriter(String username) throws Exception;
	
	public int getUserNum(String username) throws Exception;

	public void noticeBoardWrite(NoticeBoardVO noticeBoardVO) throws Exception;

	public NoticeBoardVO noticeBoardView(int nbno) throws Exception;

	public void insReple(RepleVO repleVO) throws Exception;

	public List<RepleVO> viewReple(int nbno) throws Exception;

	public void boardViewCnt(int nbno) throws Exception;

	public void nbUpdate(NoticeBoardVO nbVO) throws Exception;

	public void fileUpload(NoticeFileVO nfVO) throws Exception;

	public int getNbno() throws Exception;

	public List<NoticeFileVO> nbFileList(int nbno) throws Exception;

	public void updNoBoard(int nbno) throws Exception;

	


}
