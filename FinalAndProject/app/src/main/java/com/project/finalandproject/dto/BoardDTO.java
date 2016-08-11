package com.project.finalandproject.dto;

public class BoardDTO {
	private int board_num; // 게시물 번호 : 시퀀스 이용해서 DB에 넣을 거
	private String board_title; // 게시물 제목
	private String board_content; // 게시물 내용 
	private String board_category; // 게시물 분류
	private String member_id; //  작성 회원 아이디
	private int gathering_num; // 모임 번호 
	private String board_date; // 게시물 작성일
	private String board_picture; // 그림 저장된 URL 주소
	
	public BoardDTO(){}

	public BoardDTO(int board_num, String board_title, String board_content, String board_category, String member_id,
			int gathering_num, String board_date, String board_picture) {
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_category = board_category;
		this.member_id = member_id;
		this.gathering_num = gathering_num;
		this.board_date = board_date;
		this.board_picture = board_picture;
	}



	@Override
	public String toString() {
		return "BoardDTO [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_state=" + board_category + ", member_id=" + member_id + ", gathering_num=" + gathering_num
				+ ", board_date=" + board_date + ", board_picture=" + board_picture + "]";
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getGathering_num() {
		return gathering_num;
	}

	public void setGathering_num(int gathering_num) {
		this.gathering_num = gathering_num;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_picture() {
		return board_picture;
	}

	public void setBoard_picture(String board_picture) {
		this.board_picture = board_picture;
	};
	
}
