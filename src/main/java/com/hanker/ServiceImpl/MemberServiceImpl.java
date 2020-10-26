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


}
