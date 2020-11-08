package com.hanker.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanker.DTO.NoticeBoardVO;
import com.hanker.DTO.RepleVO;

@Repository
public class HkGroupMainDAO {
	
	@Inject
	private SqlSession sql;

	public List<NoticeBoardVO> listAll() throws Exception{
		return sql.selectList("hkGroupMainMapper.listAll", null);
	}

	public String getWriter(String username) throws Exception{
		return sql.selectOne("hkGroupMainMapper.getWriter", username);
	}
	
	public int getUserNum(String username) {
		return sql.selectOne("hkGroupMainMapper.getUserNum", username);
	}

	public void noticeBoardWrite(NoticeBoardVO noticeBoardVO) {
		sql.insert("hkGroupMainMapper.noticeBoardWrite", noticeBoardVO);
	}

	public NoticeBoardVO noticeBoardView(int nbno) {
		return sql.selectOne("hkGroupMainMapper.noticeBoardView", nbno);
	}

	public void insReple(RepleVO repleVO) {
		sql.insert("hkGroupMainMapper.insReple", repleVO);
	}

	public List<RepleVO> viewReple(int nbno) throws Exception{
		return sql.selectList("hkGroupMainMapper.viewReple", nbno);
	}

	

}
