package com.hanker.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SecurityUtil {
	
	public String encryptSHA256(String str) {
		
		String sha = "";
		
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i = 0 ; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			
			sha = sb.toString();
		} catch(NoSuchAlgorithmException e) {
			System.out.println("Encrypt Error : NoSuchAlgorithmException");
			sha = null;
		}
		
		return sha;
	}
	
	// 임시 비밀번호
	public String tmpPassword() throws Exception{
		String tmpPassword = "";
		int length = 8;
		char[] tmpWord = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'0','1','2','3','4','5','6','7','8','9'};
		
		StringBuilder sb = new StringBuilder("");
		Random rn = new Random();
		for(int i = 0 ; i < length ; i++) {
			sb.append(tmpWord[rn.nextInt(tmpWord.length)]);
		}
		
		tmpPassword = sb.toString();
		return tmpPassword;
	}
}
