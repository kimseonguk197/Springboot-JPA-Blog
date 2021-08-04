package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired // 더미클래스가 메모리에 뜰때 repo도 같이 메모리에 뜬다.
	private UserRepository userRepository;
	
	//http://localhost:8080/blog/dummy/join 요청
	@PostMapping("/dummy/join")
//	public String join(String username,  String password, String email) {
	public String join(User user) {
		
		
		System.out.println("username :"+user.getUsername());
		System.out.println("password :"+user.getPassword());
		System.out.println("email :"+user.getEmail());
		return "회원가입완료";
	}
	
}
