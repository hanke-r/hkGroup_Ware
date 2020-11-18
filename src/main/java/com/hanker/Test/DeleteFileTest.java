package com.hanker.Test;

import java.io.File;

public class DeleteFileTest {
	
	public static void main(String[] ar) {
		String filePath = "E:/DATA/";
		String orgName = "Home.PNG";
		File file = new File(filePath+orgName);
		
		if( file.exists() ){ 
			if(file.delete()){ 
				System.out.println("파일삭제 성공"); 
			}else{ 
				System.out.println("파일삭제 실패"); } 
		}else{ 
			System.out.println("파일이 존재하지 않습니다.");
		}

	}
}
