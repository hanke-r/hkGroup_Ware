package com.hanker.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.MemberVO;

@Repository
public class LoginDAO {
	
	private SqlSession sql; 
	
	public void memRegister(MemberVO memberVO) throws Exception{
		sql.insert("loginMapper.memRegister", memberVO);
	}

	public void memGradeInsert(MemberVO memberVO) {
		sql.insert("loginMapper.memGradeInsert", memberVO);
	}


}
