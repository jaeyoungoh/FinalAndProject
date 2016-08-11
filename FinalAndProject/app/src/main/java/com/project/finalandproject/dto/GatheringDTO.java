package com.project.finalandproject.dto;

public class GatheringDTO {
	private int gathering_num;
	private String gathering_title;
	private String gathering_content;
	private String gathering_category;
	private String gathering_location;
	private int gathering_max_cnt;
	private String gathering_max_age;
	private String gathering_max_sex;
	private String gathering_type;
	private String gathering_hashtag;
	private int gathering_rating;
	private String gathering_photo;
	private String gathering_gallery;
	
	
	public GatheringDTO(){};
	public GatheringDTO(int gathering_num, String gathering_title, String gathering_content, String gathering_category,
			String gathering_location, int gathering_max_cnt, String gathering_max_age, String gathering_max_sex,
			String gathering_type, String gathering_hashtag, int gathering_rating, String gathering_photo,
			String gathering_gallery) {
		this.gathering_num = gathering_num;
		this.gathering_title = gathering_title;
		this.gathering_content = gathering_content;
		this.gathering_category = gathering_category;
		this.gathering_location = gathering_location;
		this.gathering_max_cnt = gathering_max_cnt;
		this.gathering_max_age = gathering_max_age;
		this.gathering_max_sex = gathering_max_sex;
		this.gathering_type = gathering_type;
		this.gathering_hashtag = gathering_hashtag;
		this.gathering_rating = gathering_rating;
		this.gathering_photo = gathering_photo;
		this.gathering_gallery = gathering_gallery;
	}
	public int getGathering_num() {
		return gathering_num;
	}
	public void setGathering_num(int gathering_num) {
		this.gathering_num = gathering_num;
	}
	public String getGathering_title() {
		return gathering_title;
	}
	public void setGathering_title(String gathering_title) {
		this.gathering_title = gathering_title;
	}
	public String getGathering_content() {
		return gathering_content;
	}
	public void setGathering_content(String gathering_content) {
		this.gathering_content = gathering_content;
	}
	public String getGathering_category() {
		return gathering_category;
	}
	public void setGathering_category(String gathering_category) {
		this.gathering_category = gathering_category;
	}
	public String getGathering_location() {
		return gathering_location;
	}
	public void setGathering_location(String gathering_location) {
		this.gathering_location = gathering_location;
	}
	public int getGathering_max_cnt() {
		return gathering_max_cnt;
	}
	public void setGathering_max_cnt(int gathering_max_cnt) {
		this.gathering_max_cnt = gathering_max_cnt;
	}
	public String getGathering_max_age() {
		return gathering_max_age;
	}
	public void setGathering_max_age(String gathering_max_age) {
		this.gathering_max_age = gathering_max_age;
	}
	public String getGathering_max_sex() {
		return gathering_max_sex;
	}
	public void setGathering_max_sex(String gathering_max_sex) {
		this.gathering_max_sex = gathering_max_sex;
	}
	public String getGathering_type() {
		return gathering_type;
	}
	public void setGathering_type(String gathering_type) {
		this.gathering_type = gathering_type;
	}
	public String getGathering_hashtag() {
		return gathering_hashtag;
	}
	public void setGathering_hashtag(String gathering_hashtag) {
		this.gathering_hashtag = gathering_hashtag;
	}
	public int getGathering_rating() {
		return gathering_rating;
	}
	public void setGathering_rating(int gathering_rating) {
		this.gathering_rating = gathering_rating;
	}
	public String getGathering_photo() {
		return gathering_photo;
	}
	public void setGathering_photo(String gathering_photo) {
		this.gathering_photo = gathering_photo;
	}
	public String getGathering_gallery() {
		return gathering_gallery;
	}
	public void setGathering_gallery(String gathering_gallery) {
		this.gathering_gallery = gathering_gallery;
	}
	@Override
	public String toString() {
		return "GatheringDTO [gathering_num=" + gathering_num + ", gathering_title=" + gathering_title
				+ ", gathering_content=" + gathering_content + ", gathering_category=" + gathering_category
				+ ", gathering_location=" + gathering_location + ", gathering_max_cnt=" + gathering_max_cnt
				+ ", gathering_max_age=" + gathering_max_age + ", gathering_max_sex=" + gathering_max_sex
				+ ", gathering_type=" + gathering_type + ", gathering_hashtag=" + gathering_hashtag
				+ ", gathering_rating=" + gathering_rating + ", gathering_photo=" + gathering_photo
				+ ", gathering_gallery=" + gathering_gallery + "]";
	}
	
	
	
	
	
}
