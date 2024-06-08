package com.spring.practice.member.model.dto;

public class MemberDTO {

	private int userId;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String createdDate;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
}
