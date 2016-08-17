package com.project.finalandproject.board;

public class BoardDTO {
	private String gathering_bd_num; // 게시물 번호 : 시퀀스 이용해서 DB에 넣을 거
	private String gathering_bd_content; // 게시물 내용 
	private String member_id; //  작성 회원 아이디
	private String gathering_num; // 모임 번호
	private String gathering_bd_date; // 게시물 작성일
	
	public BoardDTO(){}

	public BoardDTO(String gathering_bd_num, String gathering_bd_content, String member_id, String gathering_num,
			String gathering_bd_date) {
		this.gathering_bd_num = gathering_bd_num;
		this.gathering_bd_content = gathering_bd_content;
		this.member_id = member_id;
		this.gathering_num = gathering_num;
		this.gathering_bd_date = gathering_bd_date;
	}

	@Override
	public String toString() {
		return "BoardDTO [gathering_bd_num=" + gathering_bd_num + ", gathering_bd_content=" + gathering_bd_content
				+ ", member_id=" + member_id + ", gathering_num=" + gathering_num + ", gathering_bd_date="
				+ gathering_bd_date + "]";
	}

	public String getGathering_bd_num() {
		return gathering_bd_num;
	}

	public void setGathering_bd_num(String gathering_bd_num) {
		this.gathering_bd_num = gathering_bd_num;
	}

	public String getGathering_bd_content() {
		return gathering_bd_content;
	}

	public void setGathering_bd_content(String gathering_bd_content) {
		this.gathering_bd_content = gathering_bd_content;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getGathering_num() {
		return gathering_num;
	}

	public void setGathering_num(String gathering_num) {
		this.gathering_num = gathering_num;
	}

	public String getGathering_bd_date() {
		return gathering_bd_date;
	}

	public void setGathering_bd_date(String gathering_bd_date) {
		this.gathering_bd_date = gathering_bd_date;
	}
	
	
}