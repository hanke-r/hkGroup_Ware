package com.hanker.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.MemberDAO;
import com.hanker.DTO.MemberVO;
import com.hanker.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberVO> memList(MemberVO memberVO) throws Exception {
		return memberDAO.memList(memberVO);
	}

	@Override
	public void memCheck(String userId) throws Exception {
		memberDAO.memCheck(userId);
	}

	@Override
	public void memGradeChg(String userId) throws Exception {
		memberDAO.memGradeChg(userId);
	}

	@Override
	public void memExpire(MemberVO memberVO) throws Exception {
		memberDAO.memExpire(memberVO);
	}


}
