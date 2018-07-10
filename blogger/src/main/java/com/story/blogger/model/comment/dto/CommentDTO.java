package com.story.blogger.model.comment.dto;

import java.util.Date;

public class CommentDTO {

	private int cmtno;
	private int postno;
	private String userid;
	private String cmtcontent;
	private String replyer;
	private Date regDate;

	public CommentDTO() {

	}

	public int getCmtno() {
		return cmtno;
	}

	public void setCmtno(int cmtno) {
		this.cmtno = cmtno;
	}

	public int getPostno() {
		return postno;
	}

	public void setPostno(int postno) {
		this.postno = postno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCmtcontent() {
		return cmtcontent;
	}

	public void setCmtcontent(String cmtcontent) {
		this.cmtcontent = cmtcontent;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [cmtno=" + cmtno + ", postno=" + postno + ", userid=" + userid + ", cmtcontent=" + cmtcontent
				+ ", replyer=" + replyer + "]";
	}

}
