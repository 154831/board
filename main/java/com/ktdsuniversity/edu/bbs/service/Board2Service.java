package com.ktdsuniversity.edu.bbs.service;

import com.ktdsuniversity.edu.bbs.vo.Board2VO;
import com.ktdsuniversity.edu.bbs.vo.BoardList2VO;

public interface Board2Service {
	
	public BoardList2VO getAllBoard2();
	
	public boolean createNewBoard2(Board2VO boardVO);

}
