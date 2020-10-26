package com.hanker.ServiceImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.LoginDAO;
import com.hanker.DTO.MemberVO;
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


}
