package com.hanker.Service;

import java.util.HashMap;
import java.util.List;

import com.hanker.DTO.InqueryVO;

public interface QuestService {

	public HashMap<String, Object> userInfo(String username) throws Exception;

	public void inqWrite(InqueryVO inqVO) throws Exception;

	public List<InqueryVO> inqList() throws Exception;

	public InqueryVO inqView(int inq_no) throws Exception;

}
