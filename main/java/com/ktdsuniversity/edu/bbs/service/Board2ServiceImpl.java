package com.ktdsuniversity.edu.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.bbs.dao.Board2DAO;
import com.ktdsuniversity.edu.bbs.vo.Board2VO;
import com.ktdsuniversity.edu.bbs.vo.BoardList2VO;

@Service
public class Board2ServiceImpl implements Board2Service {
	
	@Autowired
	public Board2DAO boardDAO;
	
	@Override
	public BoardList2VO getAllBoard2() {
		System.out.println(boardDAO);
		System.out.println(boardDAO.getClass().getSimpleName());
		
		BoardList2VO boardList2VO = new BoardList2VO();
		
		boardList2VO.setBoardCnt(boardDAO.getBoardAllCount2());
		boardList2VO.setBoardList(boardDAO.getAllBoard2());
		return boardList2VO;
	}

	@Override
	public boolean createNewBoard2(Board2VO boardVO) {
		// 성공적으로 등록했다면, 
		// sql 이 전달해준 boardcount = db가 저장 성공한 수 (!= 0)임. 
		int createCount = (boardDAO.createNewBoard2(boardVO));
		return createCount > 0;
	}

}
