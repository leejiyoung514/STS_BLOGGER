package com.story.blogger.model.post.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.story.blogger.model.post.dto.PostDTO;



@Repository
public class PostDAOImpl implements PostDAO {

	@Inject
	SqlSession sqlSession;
	
	//첨부파일 레코드 삭제
	@Override
	public void deleteFile(String fullname) {
		sqlSession.delete("post.deleteFile", fullname); 	
	}
	
	//첨부파일 리스트 
	@Override
	public List<String> getAttach(int postno) {
		return sqlSession.selectList("post.getAttach", postno);
	}
	
	@Override
	public void insertPost(PostDTO postDto) {
		sqlSession.insert("post.insertPost" , postDto);
	}
	
	@Override
	public void addAttach(String fullname) {
		sqlSession.insert("post.addAttach", fullname); 
	}
	//첨부파일 정보 수정
	@Override
	public void updateAttach(String fullname, int postno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullname", fullname); //첨부파일 이름
		map.put("postno", postno); //게시물 번호
		sqlSession.insert("post.updateAttach", map); 
	}

	@Override
	public void delete(int postno) throws Exception {
		sqlSession.delete("post.delete", postno);
	}
	//게시물 목록 리턴
	@Override
	public List<PostDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start); //맵에 자료 저장
		map.put("end", end);
// mapper에는 2개 이상의 값을 전달할 수 없음(dto 또는 map 사용)		
		return sqlSession.selectList("post.listAll",map); 
	}
	//조회수 증가처리
	@Override
	public void increateViewcnt(int postno) throws Exception {
		sqlSession.update("post.increaseViewcnt", postno);
	}
	//레코드 갯수 계산
	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("post.countArticle",map);
	}
    //게시물 내용보기
	@Override
	public PostDTO read(int postno) throws Exception {
		return sqlSession.selectOne("post.read", postno); 
	}

	@Override
	public void update(PostDTO dto) throws Exception {
		sqlSession.update("post.update", dto); 
	}

}
