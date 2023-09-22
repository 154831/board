package com.ktdsuniversity.edu.bbs.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.bbs.vo.Board2VO;

@Repository
public class Board2DAOImpl  extends SqlSessionDaoSupport
							implements Board2DAO {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getBoardAllCount2() {
		return getSqlSession().selectOne("com.ktdsuniversity.edu.bbs.dao.Board2DAO.getBoardAllCount");
	}
	
	@Override
	public List<Board2VO> getAllBoard2() {
		return getSqlSession().selectList("com.ktdsuniversity.edu.bbs.dao.Board2DAO.getAllBoard");
	}

	@Override
	public int createNewBoard2(Board2VO board2VO) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("createNewBoard", board2VO);
	}
	

}
