package com.hanker.Service;

import java.util.HashMap;
import java.util.List;

import com.hanker.DTO.HkVisitVO;
import com.hanker.DTO.MemberVO;

public interface HomeService {

	public List<MemberVO> memNewList() throws Exception;
	
	//사용자 권한 가져오기
	public String userAuth(String name) throws Exception;

	public void visitorIns(HkVisitVO hkVisitVO) throws Exception;

	public int totalVisitCount() throws Exception;

	public int monthVisitCount() throws Exception;

	public int todayVisitCount() throws Exception;

	public String dateVisitNum(String time1) throws Exception;
}
