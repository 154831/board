package com.ktdsuniversity.edu.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.bbs.vo.Board2VO;

public interface Board2DAO {
	// BoardDAO interface는  DB에게 요청사항을 전달 
	
	public int getBoardAllCount2();
	
	public List<Board2VO> getAllBoard2();
	
	public int createNewBoard2(Board2VO board2VO);
	
	
	
	

}
