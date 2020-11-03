package com.hanker.Util;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailToken {
	
	@Inject
	private JavaMailSender mailSender;
	
	public Integer EmailTokenSending(String e_mail) throws Exception{
		
		int flag = 0;
		
		Random r = new Random();
		int dice = r.nextInt(4589368) + 49311;
		
		String setfrom = "hanker0804@gmail.com";
		String tomail = e_mail;
		String title = "회원가입 인증 메일 입니다.";
		String content = 
				System.getProperty("line.separator")+
				System.getProperty("line.separator")+
				"안녕하세요 회원님 HGroupWare 홈페이지를 찾아주셔서 감사합니다." +
				System.getProperty("line.separator")+
				System.getProperty("line.separator")+
				" 인증번호는 " + dice + "입니다. " +
				System.getProperty("line.separator")+
				System.getProperty("line.separator");
		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			
			mailSender.send(message);
			flag = 1;
		} catch (Exception e) {
			flag = 0;
			System.out.println("오류 ? = " + e);
			e.printStackTrace();
		}
		
		if(flag == 1) {
			return dice;
		} else {
			return 0;
		}
		
		
	}
}
