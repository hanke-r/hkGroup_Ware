package com.hanker.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hanker.DTO.MemberVO;

public class Validation {

	
	public static String register(String email, String phnumber) {
		String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
		
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		
		// 핸드폰번호 체크 정규식
		if(!phnumber.matches(regExp)) {
			return "phError";
		}
		
		// email 체크 정규식
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if(!m.matches()) {
			return "emailError";
		}
		
		return "SUCCESS";
	}
}
