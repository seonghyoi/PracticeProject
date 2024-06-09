package com.spring.practice.board.model.dto;

public class BoardDTO {
	
	private int rownum; 
	private int boardNo;
	private String title;
	private String content;
	private String imgName;
	private String writer;
	private int views;
	private String createdDate;
	private String modifiedDate;
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	@Override
	public String toString() {
		return "BoardDTO [rownum=" + rownum + ", boardNo=" + boardNo + ", title=" + title + ", content=" + content
				+ ", imgName=" + imgName + ", writer=" + writer + ", views=" + views + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	
}
