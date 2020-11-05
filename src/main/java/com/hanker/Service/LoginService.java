package com.hanker.Service;

import java.util.HashMap;

import com.hanker.DTO.MemberVO;
import com.hanker.DTO.TmpTokenVO;

public interface LoginService {

	public void memRegister(MemberVO memberVO) throws Exception;

	public void memGradeInsert(MemberVO memberVO) throws Exception;

	public boolean dupliChck(String userName) throws Exception;

	public void tmpTokenIns(TmpTokenVO tmpTokenVO) throws Exception;

	public boolean indiEmailChck(TmpTokenVO tmpTokenVO) throws Exception;

	public void tmpTokenUpd(TmpTokenVO tmpTokenVO) throws Exception;

	public int tbToken(TmpTokenVO tmpTokenVO) throws Exception;

	public String emailCertChck(TmpTokenVO tmpTokenVO) throws Exception;

	public void emCertChange(TmpTokenVO tmpTokenVO) throws Exception;

	public boolean joinEmailChck(String Email) throws Exception;

	// Email로 ID찾기
	public HashMap<String, Object> idSearch(String email) throws Exception;

	public boolean pwCheck(MemberVO memberVO) throws Exception;

	public void pwIssue(HashMap<String, Object> map) throws Exception;



}
