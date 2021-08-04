package com.cos.blog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Board {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 전략을 따라간다.
	private int id; //시퀀스
	
	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량 데이터
	private String content; //섬머노트 라이브러리

	@ColumnDefault("0")
	private int count; //조회수
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)//mappedBy 연관관계의 주인이 아니다.(FK가 아니므로 DB에 칼럼을 만들지 말라는 뜻)
//	@JoinColumn(name="replyId")
	private List<Reply> reply;

	
	@ManyToOne(fetch = FetchType.EAGER) // Many=board User=one, manytoone 이므로 eager타입. onetomany는 기본전략이 lazy전략 그러나 이번케이스는 예외
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할수는 없다.
	
//	@CreationTimestamp//시간 자동입력
//	private Timestamp createDate;
	
}
