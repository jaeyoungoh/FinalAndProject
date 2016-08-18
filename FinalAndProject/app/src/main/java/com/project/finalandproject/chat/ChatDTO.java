package com.project.finalandproject.chat;

import java.io.Serializable;

public class ChatDTO implements Serializable{

	private static final long serialVersionUID = 3000L;

	private String id;
	private int gathering_num;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGathering_num() {
		return gathering_num;
	}
	public void setGathering_num(int gathering_num) {
		this.gathering_num = gathering_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "infoMember [id=" + id + ", gathering_num=" + gathering_num + ", content=" + content + "]";
	}
	public ChatDTO(String id, int gathering_num, String content) {
		this.id = id;
		this.gathering_num = gathering_num;
		this.content = content;
	}
	public ChatDTO() {
	}





}
