package com.hanker.Util;

import java.io.File;

public class FilePrepareDel {

	
	public void FileServerDel(String orgFileName, String filePath) throws Exception{
		
		File file = new File(filePath+orgFileName);
		
		try {
			file.exists();
			file.delete();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
