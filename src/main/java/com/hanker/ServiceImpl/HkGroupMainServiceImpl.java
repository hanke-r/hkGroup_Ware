package com.hanker.ServiceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.HkGroupMainDAO;
import com.hanker.DTO.NoticeBoardVO;
import com.hanker.DTO.NoticeFileVO;
import com.hanker.DTO.RepleVO;
import com.hanker.Service.HkGroupMainService;

@Service
public class HkGroupMainServiceImpl implements HkGroupMainService{
	
	@Inject
	private HkGroupMainDAO hkGroupMainDAO;

	@Override
	public List<NoticeBoardVO> listAll() throws Exception {
		return hkGroupMainDAO.listAll();
	}

	@Override
	public String getWriter(String username) throws Exception {
		return hkGroupMainDAO.getWriter(username);
	}
	
	@Override
	public int getUserNum(String username) throws Exception {
		return hkGroupMainDAO.getUserNum(username);
	}

	@Override
	public void noticeBoardWrite(NoticeBoardVO noticeBoardVO) throws Exception {
		hkGroupMainDAO.noticeBoardWrite(noticeBoardVO);
	}

	@Override
	public NoticeBoardVO noticeBoardView(int nbno) throws Exception {
		return hkGroupMainDAO.noticeBoardView(nbno);
	}

	@Override
	public void insReple(RepleVO repleVO) throws Exception {
		hkGroupMainDAO.insReple(repleVO);
	}

	@Override
	public List<RepleVO> viewReple(int nbno) throws Exception {
		return hkGroupMainDAO.viewReple(nbno);
	}

	@Override
	public void boardViewCnt(int nbno) throws Exception {
		hkGroupMainDAO.boardViewCnt(nbno);
	}

	@Override
	public void nbUpdate(NoticeBoardVO nbVO) throws Exception {
		hkGroupMainDAO.nbUpdate(nbVO);
	}

	@Override
	public void fileUpload(NoticeFileVO nfVO) throws Exception {
		hkGroupMainDAO.fileIns(nfVO);
	}

	@Override
	public int getNbno() throws Exception {
		// TODO Auto-generated method stub
		return hkGroupMainDAO.getNbno();
	}

	
}
