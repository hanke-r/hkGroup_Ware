package com.hanker.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.QuestDAO;
import com.hanker.DTO.InqueryVO;
import com.hanker.Service.QuestService;

@Service
public class QuestServiceImpl implements QuestService{
	
	@Inject
	private QuestDAO questDAO;

	@Override
	public HashMap<String, Object> userInfo(String username) throws Exception {
		return questDAO.userInfo(username);
	}

	@Override
	public void inqWrite(InqueryVO inqVO) throws Exception {
		questDAO.inqWrite(inqVO);
	}

	@Override
	public List<InqueryVO> inqList() throws Exception {
		return questDAO.inqList();
	}

	@Override
	public InqueryVO inqView(int inq_no) throws Exception {
		return questDAO.inqView(inq_no);
	}

	@Override
	public void inqReply(InqueryVO inqVO) throws Exception {
		questDAO.inqReply(inqVO);
	}

}
	