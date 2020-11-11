package com.hanker.ServiceImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanker.DAO.FrBoardDAO;
import com.hanker.Service.FrBoardService;

@Service
public class FrBoardServiceImpl implements FrBoardService{
	
	@Inject
	private FrBoardDAO frBoardDAO;
}
