package com.story.blogger.model.blog.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BlogDTO {
	private int blogno;
	private String userid;
	private String blogtitle;
	private String blogcontent;
	private String logofile;
	private Date regdate;
	private MultipartFile file;

	public BlogDTO() {

	}

	public int getBlogno() {
		return blogno;
	}

	public void setBlogno(int blogno) {
		this.blogno = blogno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getBlogcontent() {
		return blogcontent;
	}

	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}

	public String getLogofile() {
		return logofile;
	}

	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "BlogDTO [blogno=" + blogno + ", userid=" + userid + ", blogtitle=" + blogtitle + ", blogcontent="
				+ blogcontent + ", logofile=" + logofile + ", regdate=" + regdate + ", file=" + file + "]";
	}


}
