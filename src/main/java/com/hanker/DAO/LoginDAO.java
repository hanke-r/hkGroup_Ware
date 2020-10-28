package com.hanker.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.MemberVO;

@Repository
public class LoginDAO {
	
	@Inject
	private SqlSession sql; 
	
	public void memRegister(MemberVO memberVO) throws Exception{
		try {
			sql.insert("loginMapper.memRegister", memberVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void memGradeInsert(MemberVO memberVO) {
		sql.insert("loginMapper.memGradeInsert", memberVO);
	}


}
