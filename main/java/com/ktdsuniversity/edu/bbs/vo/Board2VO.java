package com.ktdsuniversity.edu.bbs.vo;

public class Board2VO {
	// boardVO는 데이터를 저장하는 공간
	private int id                ;
	private String subject        ;
	private String content        ;
	private String email          ;
	private int viewCnt           ;
	private String crtDt          ;
	private String mdfyDt         ;
	private String fileName       ;
	private String originFileName ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getMdfyDt() {
		return mdfyDt;
	}
	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getoriginFileName() {
		return originFileName;
	}
	public void setoriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	
	

}
