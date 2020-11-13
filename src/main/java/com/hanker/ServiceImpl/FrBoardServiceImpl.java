package com.hanker.ServiceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.FrBoardDAO;
import com.hanker.DTO.FrBoardVO;
import com.hanker.DTO.RepleFrVO;
import com.hanker.Service.FrBoardService;

@Service
public class FrBoardServiceImpl implements FrBoardService{
	
	@Inject
	private FrBoardDAO frBoardDAO;

	@Override
	public List<FrBoardVO> frList() throws Exception {
		return frBoardDAO.frList();
	}

	@Override
	public void frbWrt(FrBoardVO frBoardVO) throws Exception {
		frBoardDAO.frbWrt(frBoardVO);
	}

	@Override
	public FrBoardVO frBoardView(int frno) throws Exception {
		return frBoardDAO.frBoardView(frno);
	}

	@Override
	public void frbUpdate(FrBoardVO frBoardVO) throws Exception {
		frBoardDAO.frbUpdate(frBoardVO);
	}

	@Override
	public void frbViewCnt(int frno) throws Exception {
		frBoardDAO.frbViewCnt(frno);
	}

	@Override
	public String getWriter(String username) throws Exception {
		return frBoardDAO.getWriter(username);
	}

	@Override
	public int getUserNum(String username) throws Exception {
		return frBoardDAO.getUserNum(username);
	}

	@Override
	public void insReple(RepleFrVO repleFrVO) throws Exception {
		frBoardDAO.insReple(repleFrVO);
	}

	@Override
	public List<RepleFrVO> viewReple(int frno) throws Exception {
		// TODO Auto-generated method stub
		return frBoardDAO.viewReple(frno);
	}
}
