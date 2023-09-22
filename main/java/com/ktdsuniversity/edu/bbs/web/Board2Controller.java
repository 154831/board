package com.ktdsuniversity.edu.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.bbs.service.Board2Service;
import com.ktdsuniversity.edu.bbs.vo.Board2VO;
import com.ktdsuniversity.edu.bbs.vo.BoardList2VO;

@Controller
public class Board2Controller {
	
	@Autowired
	private Board2Service board2Service;
	
	@GetMapping("/board2/list")
	public ModelAndView viewBoardList() {
		BoardList2VO boardList2VO = board2Service.getAllBoard2();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board/boardlist");
		modelAndView.addObject("boardList", "BoardList2VO");
	
		return modelAndView;
	}
	
	@GetMapping("/board2/write")
	public ModelAndView viewWritePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board2/write");
		
		return modelAndView ;
	}
	
	@PostMapping ("/board2/write")
	public ModelAndView doNewPost(@ModelAttribute Board2VO board2VO) {
		
		ModelAndView modelAndView = new ModelAndView();
		boolean isSuccess = board2Service.createNewBoard2(board2VO);
		if (isSuccess) {
			modelAndView.setViewName("redirect:board2/list");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:board2/write");
			modelAndView.addObject("boardVO", board2VO);
			return modelAndView;
		}
		
		
		
		
 }	
		
	}

