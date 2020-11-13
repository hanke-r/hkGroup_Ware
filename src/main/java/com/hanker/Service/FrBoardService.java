package com.hanker.Service;

import java.util.List;

import com.hanker.DTO.FrBoardVO;
import com.hanker.DTO.RepleFrVO;

public interface FrBoardService {

	public List<FrBoardVO> frList() throws Exception;

	public void frbWrt(FrBoardVO frBoardVO) throws Exception;

	public FrBoardVO frBoardView(int frno) throws Exception;

	public void frbUpdate(FrBoardVO frBoardVO) throws Exception;

	public void frbViewCnt(int frno) throws Exception;

	public String getWriter(String username) throws Exception;

	public int getUserNum(String username) throws Exception;

	public void insReple(RepleFrVO repleFrVO) throws Exception;

	public List<RepleFrVO> viewReple(int frno) throws Exception;

}
