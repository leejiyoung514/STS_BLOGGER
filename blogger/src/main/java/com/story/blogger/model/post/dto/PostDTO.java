package com.story.blogger.model.post.dto;

import java.util.Arrays;
import java.util.Date;

public class PostDTO {

	private int postno;
	private int cateno;
	private String title;
	private String postcontent;
	private Date regdate;
	private int viewcnt;
	private String writer; //작성자 id
//추가 작성한 필드
	private String name; //작성자 이름
	private int cnt; //댓글 갯수
	private String show; //화면 표시 여부
	private String[] files; //첨부파일 이름 배열
	private String catename;
	
	public PostDTO() {

	}

	public int getPostno() {
		return postno;
	}

	public void setPostno(int postno) {
		this.postno = postno;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}
	

	@Override
	public String toString() {
		return "PostDTO [postno=" + postno + ", cateno=" + cateno + ", title=" + title + ", postcontent=" + postcontent
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", writer=" + writer + ", name=" + name + ", cnt="
				+ cnt + ", show=" + show + ", files=" + Arrays.toString(files) + "]";
	}

}
