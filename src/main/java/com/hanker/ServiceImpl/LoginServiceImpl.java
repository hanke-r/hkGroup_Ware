package com.hanker.ServiceImpl;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.LoginDAO;
import com.hanker.DTO.MemberVO;
import com.hanker.DTO.TmpTokenVO;
import com.hanker.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Inject
	private LoginDAO loginDAO;
	
	@Override
	public void memRegister(MemberVO memberVO) throws Exception {
		loginDAO.memRegister(memberVO);
	}

	@Override
	public void memGradeInsert(MemberVO memberVO) throws Exception {
		loginDAO.memGradeInsert(memberVO);
		
	}

	@Override
	public boolean dupliChck(String userName) throws Exception {
		
		return loginDAO.dupliChck(userName);
	}

	@Override
	public void tmpTokenIns(TmpTokenVO tmpTokenVO) throws Exception {
		loginDAO.tmpTokenIns(tmpTokenVO);
	}

	@Override
	public boolean indiEmailChck(TmpTokenVO tmpTokenVO) throws Exception {
		
		return loginDAO.indiEmailChck(tmpTokenVO);
	}

	@Override
	public void tmpTokenUpd(TmpTokenVO tmpTokenVO) throws Exception {
		loginDAO.tmpTokenUpd(tmpTokenVO);
	}

	@Override
	public int tbToken(TmpTokenVO tmpTokenVO) throws Exception {
		return loginDAO.tbToken(tmpTokenVO);
	}

	@Override
	public String emailCertChck(TmpTokenVO tmpTokenVO) throws Exception {
		return loginDAO.emailCertChck(tmpTokenVO);
	}

	@Override
	public void emCertChange(TmpTokenVO tmpTokenVO) throws Exception {
		loginDAO.emCertChange(tmpTokenVO);
	}

	@Override
	public boolean joinEmailChck(String email) throws Exception {
		return loginDAO.joinEmailChck(email);
	}

	@Override
	public HashMap<String, Object> idSearch(String email) throws Exception {
		return loginDAO.idSearch(email);
	}

	@Override
	public boolean pwCheck(MemberVO memberVO) throws Exception {
		return loginDAO.pwCheck(memberVO);
	}

	@Override
	public void pwIssue(HashMap<String, Object> map) throws Exception {
		loginDAO.pwIssue(map);
	}



}
