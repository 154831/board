package com.ktdsuniversity.edu.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.bbs.service.BoardService;
import com.ktdsuniversity.edu.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.bbs.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public ModelAndView viewBoardList() {
		BoardListVO boardListVO = boardService.getAllBoard();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardlist");
		modelAndView.addObject("boardList", boardListVO );
	
		return modelAndView;
	}
	
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write")
	public ModelAndView doBoardWrite(@ModelAttribute BoardVO boardVO
									,@RequestParam MultipartFile file) {
		System.out.println("제목: " + boardVO.getSubject());
		System.out.println("이메일: " + boardVO.getEmail());
		System.out.println("내용: " + boardVO.getContent());
		System.out.println("등록일: " + boardVO.getCrtDt());
		System.out.println("수정일: " + boardVO.getMdfyDt());
		System.out.println("파일명: " + boardVO.getFileName());
		System.out.println("원본 파일명: " + boardVO.getOriginFileName());
		
		ModelAndView modelAndView = new ModelAndView();
		boolean isSuccess = boardService.createNewBoard(boardVO, file);
		if (isSuccess) {
			// 게시글의 등록 결과가 성공이라면 
			// board list url 이동
			// redirect: 는 화면을 이동시키는 view.
			// redirect 로 홤ㄴ을 전환 시킬 때에는addObject를 사용할 수 없다.
			modelAndView.setViewName("redirect:/board/list");
			return modelAndView;
		}
		else {
			// 게시글 등록 결과가 싪라면
			// 게시글 등록(작성) 화면으로 데이터를 보내준다.
			// 게시글 등록(작성)화면에서 boardVO 값으로 등록  값을 설정해야 한다.
			modelAndView.setViewName("board/boardwrite");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
		
	}
	
	//RequestParam int id
//	• URL로 전달한 파라미터를 받아올 수 있는 방법
//	• http://localhost:8080/board/view?id=1

		@GetMapping("/board/view")
		public ModelAndView viewOneBoard(@RequestParam int id) {
			BoardVO boardVO= boardService.getOneBoard(id, true);
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("board/boardview");
			modelAndView.addObject("boardVO", boardVO);
			
			return modelAndView;
		
		}
		@GetMapping("/board/modify/{id}")
		//http://localhost:8080/board/modify/1
		public String viewBoardModifyPage (@PathVariable int id, Model model) {
			
			// 수정할 게시글을 조회
			BoardVO boardVO = boardService.getOneBoard(id, false);
			
			//View에게 boardVO라는 이름으로 BoardVO를 전달한다.
			model.addAttribute("boardVO", boardVO);
			
			return "board/boardmodify";
		}
		
		@PostMapping("/board/modify")
		public String doBoardUpdate(@ModelAttribute BoardVO boardVO, Model model) {
			System.out.println("제목: " + boardVO.getSubject());
			System.out.println("이메일: " + boardVO.getEmail());
			System.out.println("내용: " + boardVO.getContent());
			System.out.println("등록일: " + boardVO.getCrtDt());
			System.out.println("수정일: " + boardVO.getMdfyDt());
			System.out.println("파일명: " + boardVO.getFileName());
			System.out.println("원본 파일명: " + boardVO.getOriginFileName());
			
			boolean isSuccess = boardService.updateOneBoard(boardVO);
			
			if (isSuccess) {
				// 게시글 수정 결과가 성공이라면
				// board/view?id=1 URL 로 이동한다.
				return "redirect:/board/view?id=" + boardVO.getId();
			}
			else {
				// 게시글 수정 결과가 실패라면
				// 게시글 수정 화면으로 데이터를 보내준다.
				model.addAttribute("board", boardVO);
				return "board/boardmodify";
			}
		}
		
		@GetMapping ("/board/delete/{id}")
		public String doDeleteBoard (@PathVariable int id) {
			boolean isSuccess = boardService.deleteOneBoard(id);
			if(isSuccess) {
				return "redirect:/board/list";
			}
			else {
				return "redirect:/board/view?id=" + id;
			}
		}
	}
