package com.hanker.Service;

import com.hanker.DTO.MemberVO;

public interface LoginService {

	public void memRegister(MemberVO memberVO) throws Exception;

	public void memGradeInsert(MemberVO memberVO) throws Exception;


}
