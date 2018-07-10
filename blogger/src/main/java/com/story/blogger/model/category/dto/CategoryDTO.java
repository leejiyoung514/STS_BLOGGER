package com.story.blogger.model.category.dto;

import java.util.Date;

public class CategoryDTO {

	private int cateno;
	private String userid;
	private String catename;
	private String description;
	private Date regdate;
	private int cnt;

	public CategoryDTO() {

	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "CategoryDTO [cateno=" + cateno + ", userid=" + userid + ", catename=" + catename + ", description="
				+ description + ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}

}
