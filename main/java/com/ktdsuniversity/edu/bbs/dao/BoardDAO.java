package com.ktdsuniversity.edu.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.bbs.vo.BoardVO;


public interface BoardDAO {

	public int getBoardAllCount();
	
	public List<BoardVO> getAllBoard();
	
	/**
	 * 
	 *  DB에 새글을 등록한다.
	 * @param boardVO 사용자가 입력한 게시글 정보
	 * @return db에 insert 한 개수
	 */
	public int createNewBoard(BoardVO boardVO);
	
	/**
	 * 파라미터로 전달받은 게시글의 id 의 조회수를 1증가시킨다.
	 * @param id 조회할 게시글의 id (번호)
	 * @return db 업데이트 개수
	 */
	public int increaseViewCount(int id);
	
	/**
	 * 파라미터로 전달받은 게시글의 id 게시글 정보를 조회한다.
	 * @param id 조회할 게시글의 id (번호)
	 * @return 조회된 게시글의 정보(내용)
	 */
	public BoardVO getOneBoard(int id);
	
	/**
	 * DB 게시글의 정보를 수정한다
	 * BoardVO의 ID값에 수정할 게시글의 id 값이 있어야한다. 
	 * @param boardVO 사용자가 수정한 게시글의 정보
	 * @return DB에 update 한 게시글의 수
	 */
	public int updateOneBoard(BoardVO boardVO);
	
	/**
	 * 파라미터로 전달받은 게시글 ID 의 게시글을 삭제한다.
	 * @param 게시글 ID (번호)
	 * @return DB에 Delete한 게시글의 수
	 */
	public int deleteOneBoard (int id);
	
}
