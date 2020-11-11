package com.hanker.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.FrBoardVO;

@Repository
public class FrBoardDAO {

	@Inject
	private SqlSession sql;

	public List<FrBoardVO> frList() throws Exception{
		return sql.selectList("frBoardMapper.frList");
	}

	public void frbWrt(FrBoardVO frBoardVO) {
		sql.insert("frBoardMapper.frbWrt", frBoardVO);
	}

	public FrBoardVO frBoardView(int frno) throws Exception {
		return sql.selectOne("frBoardMapper.frBoardView", frno);
	}

	public void frbUpdate(FrBoardVO frBoardVO) throws Exception{
		sql.update("frBoardMapper.frbUpdate", frBoardVO);
	}
}
