package com.hanker.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.NoticeBoardVO;

@Repository
public class HkGroupMainDAO {
	
	@Inject
	private SqlSession sql;

	public List<NoticeBoardVO> listAll() throws Exception{
		return sql.selectList("hkGroupMainMapper.listAll", null);
	} 
}
