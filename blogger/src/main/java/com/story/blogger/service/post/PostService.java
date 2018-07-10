package com.story.blogger.service.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.story.blogger.model.post.dto.PostDTO;



public interface PostService {

	public void deleteFile(String fullname);//첨부파일 삭제
	public List<String> getAttach(int postno); //첨부파일 정보

	public void postWrite(PostDTO postDto) throws Exception;//글쓰기
	public void update(PostDTO postDto) throws Exception; //글수정
	public void delete(int bno) throws Exception; //글삭제
	//목록
	public List<PostDTO> listAll(
			String search_option, String keyword, int start, int end) 
				throws Exception;
	//조회수 증가 처리
	public void increateViewcnt(int postno, HttpSession session) throws Exception;
	//레코드 갯수 계산 
	public int countArticle(
			String search_option, String keyword) throws Exception;
	//레코드 조회
	public PostDTO read(int bno) throws Exception;

}
