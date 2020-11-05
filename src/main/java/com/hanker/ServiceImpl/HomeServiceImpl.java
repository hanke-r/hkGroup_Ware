package com.hanker.ServiceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.HomeDAO;
import com.hanker.DTO.MemberVO;
import com.hanker.Service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	@Inject
	private HomeDAO homeDAO;
	
	@Override
	public List<MemberVO> memNewList() throws Exception {
		
		return homeDAO.memNewList();
	}

	@Override
	public String userAuth(String name) throws Exception {
		return homeDAO.userAuth(name);
	}

}
