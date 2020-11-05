package com.hanker.DAO;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.MemberVO;
import com.hanker.DTO.TmpTokenVO;

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

	public boolean dupliChck(String userName) {
		return sql.selectOne("loginMapper.dupliChck", userName);
	}

	public void tmpTokenIns(TmpTokenVO tmpTokenVO) {
		// TODO Auto-generated method stub
		sql.insert("loginMapper.tmpTokenIns", tmpTokenVO);
	}

	public boolean indiEmailChck(TmpTokenVO tmpTokenVO) throws Exception{
		return sql.selectOne("loginMapper.indiEmailChck", tmpTokenVO);
	}

	public void tmpTokenUpd(TmpTokenVO tmpTokenVO) {
		sql.update("loginMapper.tmpTokenUpd", tmpTokenVO);
	}

	public int tbToken(TmpTokenVO tmpTokenVO) throws Exception {
		return sql.selectOne("loginMapper.tbToken", tmpTokenVO);
	}

	public String emailCertChck(TmpTokenVO tmpTokenVO) {
		return sql.selectOne("loginMapper.emailCertChck", tmpTokenVO);
	}

	public void emCertChange(TmpTokenVO tmpTokenVO) throws Exception {
		sql.update("loginMapper.emCertChange", tmpTokenVO);
	}

	public boolean joinEmailChck(String email) throws Exception{
		return sql.selectOne("loginMapper.joinEmailChck", email);
	}

	public HashMap<String, Object> idSearch(String email) throws Exception {
		return sql.selectOne("loginMapper.idSearch", email);
	}


}
