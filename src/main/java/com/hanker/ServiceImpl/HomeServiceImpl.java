package com.hanker.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.HomeDAO;
import com.hanker.DTO.HkVisitVO;
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

	@Override
	public void visitorIns(HkVisitVO hkVisitVO) throws Exception {
		homeDAO.visitorIns(hkVisitVO);
	}

	@Override
	public int totalVisitCount() throws Exception {
		// TODO Auto-generated method stub
		return homeDAO.totalVisitCount();
	}

	@Override
	public int monthVisitCount() throws Exception {
		return homeDAO.monthVisitCount();
	}

	@Override
	public int todayVisitCount() throws Exception {
		return homeDAO.todayVisitCount();
	}

	@Override
	public String dateVisitNum(String time1) throws Exception{
		
		return homeDAO.dateVisitNum(time1);
	}

	@Override
	public HkVisitVO monMaxVistMem() throws Exception {
		return homeDAO.monMaxVistMem();
	}

}
