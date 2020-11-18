package com.hanker.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.HkVisitVO;
import com.hanker.DTO.MemberVO;

@Repository
public class HomeDAO {

	@Inject
	private SqlSession sql;

	public List<MemberVO> memNewList() throws Exception{
		return sql.selectList("homeMapper.memNewList", null);
	}

	public String userAuth(String name) {
		return sql.selectOne("homeMapper.userAuth", name);
	}

	public void visitorIns(HkVisitVO hkVisitVO) throws Exception {
		sql.insert("homeMapper.visitorIns", hkVisitVO);
	}

	public int totalVisitCount() throws Exception{
		// TODO Auto-generated method stub
		return sql.selectOne("homeMapper.totalVisitCount");
	}

	public int monthVisitCount() throws Exception{
		return sql.selectOne("homeMapper.monthVisitCount");
	}

	public int todayVisitCount() throws Exception{
		return sql.selectOne("homeMapper.todayVisitCount");
	}

	public String dateVisitNum(String time1) throws Exception {
		return sql.selectOne("homeMapper.dateVisitNum", time1);
	}

	public HkVisitVO monMaxVistMem() throws Exception {
		return sql.selectOne("homeMapper.monMaxVistMem");
	}
	
	
}
