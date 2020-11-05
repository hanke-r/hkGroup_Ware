package com.hanker.ServiceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.HkGroupMainDAO;
import com.hanker.DTO.NoticeBoardVO;
import com.hanker.Service.HkGroupMainService;

@Service
public class HkGroupMainServiceImpl implements HkGroupMainService{
	
	@Inject
	private HkGroupMainDAO hkGroupMainDAO;

	@Override
	public List<NoticeBoardVO> listAll() throws Exception {
		return hkGroupMainDAO.listAll();
	} 
}
