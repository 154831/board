package com.ktdsuniversity.edu.bbs.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.bbs.vo.BoardVO;

@Repository
public class BoardDAOImpl extends SqlSessionDaoSupport
							implements BoardDAO{
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getBoardAllCount () {
		return getSqlSession().selectOne("com.ktdsuniversity.edu.bbs.dao.BoardDAO.getBoardAllCount");
	}
	
	@Override
	public List<BoardVO> getAllBoard( ) {
		return getSqlSession().selectList("com.ktdsuniversity.edu.bbs.dao.BoardDAO.getAllBoard");

	}

	@Override
	public int createNewBoard(BoardVO boardVO) {
		// getSqlSession().insert() 는 insert 한 row 의 갯수를 반환한다.
		return getSqlSession().insert("createNewBoard", boardVO);
	}

	@Override
	public int increaseViewCount(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().update("increaseViewCount", id);
	}

	@Override
	public BoardVO getOneBoard(int id) {
		return getSqlSession().selectOne("getOneBoard", id);
	}

	@Override
	public int updateOneBoard(BoardVO boardVO) {
		// query 에게 전달할 수 있는 파라미터의 수는 1개다.
		// 2개 이상 전달 불가
		return getSqlSession().update("updateOneBoard",boardVO);
	}

	@Override
	public int deleteOneBoard(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().delete("deleteOneBoard", id);
	}
}
