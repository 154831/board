package com.ktdsuniversity.edu.bbs.service;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.bbs.vo.BoardVO;

public interface BoardService {
	
	public BoardListVO getAllBoard();
	
	/**
	 * 새 게시글 등록 처리
	 * @param boardVO 사용자가 입력한 게시글 정보 (내용)
	 * @param file 사용자가 업로드한 파일의 정보 ()
	 * @return 정상 등록 여부 (t/f) 
	 */
	public boolean createNewBoard(BoardVO boardVO, MultipartFile file);
	
	/**
	* 파라미터로 전달받은 id로 게시글을 조회한다.
	* 게시글 조회시 조회수도 1 증가한다.
	* @param id 조회할 게시글의 ID
	* @param isIncrease 값이 true 면 조회수를 증가시킨다
	* @return 게시글 정보
	*/
	public BoardVO getOneBoard(int id, boolean isIncrease);
	
	
	/**
	 * BoardVO 의 id 값에 수정할 게시글의 id값이 있어야한다. 
	 * @param boardVO 사용자가 수정한 게시글의 정보
	 * @param file 사용자가 업로드한 파일(기존파일 존재시 삭제 후 신규등록)
	 * @return
	 */
	public boolean updateOneBoard(BoardVO boardVO, MultipartFile file);
	
	/**
	 * 파라미터로 전달받은 게시글 id의 게시글을 삭제한다.
	 * @param 게시글 id
	 * @return 정상적으로 삭제되었는지 여부
	 */
	public boolean deleteOneBoard(int id);
	
}
