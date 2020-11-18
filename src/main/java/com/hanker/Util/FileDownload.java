package com.hanker.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownload {

	public void eFileDownLoad(HttpServletRequest req, HttpServletResponse rep) throws Exception{
		
		String fileName = req.getParameter("FILENAME");
		String Path = req.getParameter("PATH");
		String fullPath = Path + "/" + fileName;
		
		File file = new File(fullPath);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			sos = rep.getOutputStream();
			
			String reFilename = "";
			boolean isMSIE = req.getHeader("user-agent").indexOf("MSIE") != -1 || req.getHeader("user-agent").indexOf("Trident") != -1 || req.getHeader("user-agent").indexOf("Chrome") != -1;
			
			if(isMSIE) {
				reFilename = URLEncoder.encode(fileName, "utf-8");
				reFilename = reFilename.replaceAll("\\+", "%20");
			} else {
				reFilename = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
			}
			
			rep.setContentType("application/octet-stream;charset=utf-8");
			rep.addHeader("Content-Disposition", "attachment;filename=\""+reFilename+"\"");
			rep.setContentLength((int)file.length());
			
			int read = 0;
			while((read = bis.read()) != -1) {
				sos.write(read);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.close();
				bis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
