package com.hanker.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
	
}
