package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemControllerTest {

	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resource/static
		return "/home.html";

	}
	//http://localhost:8000/blog/temp/img
	@GetMapping("/temp/img")
	public String tempImg() {
		//파일리턴 기본경로 : src/main/resource/static
		return "/jisoo.jpg";

	}
	
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/jsp")
	public String temJsp() {
		//파일리턴 기본경로 : src/webapp/WEB-INF/views
		return "test";

	}
}
