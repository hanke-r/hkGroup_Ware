package com.hanker.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.InqueryVO;

@Repository
public class QuestDAO {

	@Inject
	private SqlSession sql;

	public HashMap<String, Object> userInfo(String username) throws Exception{
		return sql.selectOne("questMapper.userInfo", username);
	}

	public void inqWrite(InqueryVO inqVO) throws Exception {
		sql.insert("questMapper.inqWrite", inqVO);
	}

	public List<InqueryVO> inqList() throws Exception{
		return sql.selectList("questMapper.inqList");
	}

	public InqueryVO inqView(int inq_no) throws Exception{
		return sql.selectOne("questMapper.inqView", inq_no);
	}
	
	
}
