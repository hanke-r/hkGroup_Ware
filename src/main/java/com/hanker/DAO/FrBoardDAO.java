package com.hanker.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FrBoardDAO {

	@Inject
	private SqlSession sql;
}
