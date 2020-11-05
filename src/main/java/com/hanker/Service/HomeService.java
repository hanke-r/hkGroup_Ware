package com.hanker.Service;

import java.util.List;

import com.hanker.DTO.MemberVO;

public interface HomeService {

	public List<MemberVO> memNewList() throws Exception;
	
	//사용자 권한 가져오기
	public String userAuth(String name) throws Exception;
}
