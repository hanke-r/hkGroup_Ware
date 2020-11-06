package com.hanker.Service;

import java.util.List;

import com.hanker.DTO.NoticeBoardVO;

public interface HkGroupMainService {

	public List<NoticeBoardVO> listAll() throws Exception;

	// 작성자 불러오기
	public String getWriter(String username) throws Exception;

	public void noticeBoardWrite(NoticeBoardVO noticeBoardVO) throws Exception;

	public NoticeBoardVO noticeBoardView(int nbno) throws Exception;

}
