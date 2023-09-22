package com.ktdsuniversity.edu.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
//working on server 
public class HelloBootController {
	
	// 작동하려는 url 
	@GetMapping("/hello1")
	public ResponseEntity<String> hello1() {
		// 스트링(문자열) 데이터를 클라이언트에 보내주겠다
		return new ResponseEntity<>("Hello Spring Boot Controller", HttpStatus.OK);
	}
	
	@GetMapping("/hello2")
	public ResponseEntity<String> hello2() {
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html>                             ");
		html.append("<html>                                      ");
		html.append("<head><title>Hello, Boot!</title></head>    ");
		html.append("<body>                                      ");
		html.append("<div>수업 20분 남았어요</div>                         ");
		html.append("<div>사실은 21분</div>     ");
		html.append("</body>                                     ");
		html.append("</html>                                     ");
		return new ResponseEntity<>(html.toString(), HttpStatus.OK);
	
	}
	
	@GetMapping("/hello3")
	public String hello() {
		return "helloboot";
	}
	
	@GetMapping("/hello4")
	public ModelAndView helloModelAndView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("helloboot");
		view.addObject("myname", "jeff");//(변수값,입력값)
		return view;
	}
	
	@GetMapping("/hello5")
	public String helloModel(org.springframework.ui.Model model) {
		model.addAttribute("myname", "Cafe Demo");
		return "helloboot";
	}
		
	}


