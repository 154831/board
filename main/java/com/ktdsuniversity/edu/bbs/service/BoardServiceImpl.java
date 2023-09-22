package com.ktdsuniversity.edu.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.bbs.dao.BoardDAO;
import com.ktdsuniversity.edu.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.beans.FileHandler;
import com.ktdsuniversity.edu.beans.FileHandler.StoredFile;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private FileHandler fileHandler; 
	
	@Autowired
	private BoardDAO boardDAO;
	@Override
	public BoardListVO getAllBoard() {
		System.out.println(boardDAO);
		System.out.println(boardDAO.getClass().getSimpleName());
		BoardListVO boardListVO = new BoardListVO();
		
		boardListVO.setBoardCnt(boardDAO.getBoardAllCount() );
		
		boardListVO.setBoardList(boardDAO.getAllBoard());
		return boardListVO;
	}
	@Override
	public boolean createNewBoard(BoardVO boardVO, MultipartFile file) {
		
		// 파일 임포트한 결과 
		StoredFile storedFile = fileHandler.storeFile(file);
		System.out.println(storedFile.getFileName());
		System.out.println(storedFile.getFileSize());
		System.out.println(storedFile.getRealFileName());
		System.out.println(storedFile.getRealFilePath());
		
		// 업로드 성공했다면
		if (storedFile != null) {
			// 사용자가 입력한 정보에 파일 정보를 할당한다.
			boardVO.setFileName(storedFile.getRealFileName());
			boardVO.setOriginFileName(storedFile.getFileName());
		}
		// DB에 게시글을 등록한다. 
		// createCount에는 db에 등록한 게시글의 개수를 반환.
		int createCount = boardDAO.createNewBoard(boardVO);
		return createCount > 0;
	}
	@Override
	public BoardVO getOneBoard(int id, boolean isIncrease) {
		
		if (isIncrease) {
		// TODO Auto-generated method stub
			int updateCount = boardDAO.increaseViewCount(id);
			if (updateCount == 0) {
	//			update Count 가 0 이라는 것은 파라미터로 전달받은 id의 값이
	//			db에 존재하지 않는다는 의미.
				// 이럴 때, 잘못된 접근이라고 사용자에게 표시
				throw new IllegalArgumentException ("잘못된 접근입니다.");
			}	
		}
		
			BoardVO boardVO = boardDAO.getOneBoard(id);
			if (boardVO == null) {
				throw new IllegalArgumentException ("잘못된 접근입니다.");
			}
			return boardVO;
		

	}
	
	@Override
	public boolean updateOneBoard(BoardVO boardVO) {
		// 파라미터로 전달받은 수정된 게시글의 정보로 db를 수정.
		// updatecount에는 db에 업데이트한 게시글의 수를 반환한다.
		int updateCount = boardDAO.updateOneBoard(boardVO);
		
		return updateCount > 0;
	}
	@Override
	public boolean deleteOneBoard(int id) {
		int deleteCount = boardDAO.deleteOneBoard(id);
		
		return deleteCount > 0;
	}
	
	
	
	
}
