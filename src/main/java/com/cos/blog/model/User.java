package com.cos.blog.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//유저클래스가 자동으로 MySql에 테이블 생성
public class User {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 전략을 따라간다.
	private int id; //시퀀스
	
	@Column(nullable = false, length = 20)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role;//Enum을 쓰는게 좋다. admin or user or manager 권한 부여.

//	@CreationTimestamp//시간 자동입력
//	private Timestamp createDate;
//	
}
