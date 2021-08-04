package com.cos.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//유저클래스가 자동으로 MySql에 테이블 생성
public class Reply {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 전략을 따라간다.
	private int id; //시퀀스
	
	@Column(nullable = false, length = 200)
	private String content;

	@ManyToOne
	@JoinColumn(name = "boardId")
	private Board Board;

	@ManyToOne // Many=board User=one
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할수는 없다.
	

}
