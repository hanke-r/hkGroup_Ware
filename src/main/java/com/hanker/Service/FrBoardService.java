package com.hanker.Service;

import java.util.List;

import com.hanker.DTO.FrBoardVO;

public interface FrBoardService {

	public List<FrBoardVO> frList() throws Exception;

	public void frbWrt(FrBoardVO frBoardVO) throws Exception;

	public FrBoardVO frBoardView(int frno) throws Exception;

	public void frbUpdate(FrBoardVO frBoardVO) throws Exception;

}
