package com.story.blogger.service.post;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.story.blogger.model.post.dao.PostDAO;
import com.story.blogger.model.post.dto.PostDTO;



@Service
public class PostServiceImpl implements PostService {

	@Inject
	PostDAO postDao;
	
	//첨부파일 레코드 삭제
	@Override
	public void deleteFile(String fullName) {
		postDao.deleteFile(fullName);
	}
	
	// 1.글쓰기 - 게시물 번호 생성
	// 2.첨부파일 등록-게시물 번호 사용	
	@Transactional
	@Override
	public void postWrite(PostDTO postDto) {
		//board 테이블에 레코드 추가
		postDao.insertPost(postDto);
		//attach 테이블에 레코드 추가
		String[] files=postDto.getFiles(); //첨부파일 이름 배열
		if(files==null) return; //첨부파일이 없으면 skip
		for(String name: files) {
			postDao.addAttach(name); //attach 테이블에 insert
		}
	}
	
	@Override
	public List<String> getAttach(int postno) {
		return postDao.getAttach(postno);
	}

	@Override
	public void delete(int bno) throws Exception {
		//comment 레코드 삭제
		//attach 레코드 삭제
		//첨부파일 삭제
		//board 레코드 삭제
		postDao.delete(bno); 
	}

	@Override
	public List<PostDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return postDao.listAll(search_option, keyword, start, end);
	}

	@Override
	public void increateViewcnt(int postno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+postno)!=null) {
			//최근에 조회수를 올린 시간
			update_time=
					(long)session.getAttribute("update_time_"+postno);
		}
		long current_time=System.currentTimeMillis();
		//일정 시간이 경과한 후 조회수 증가 처리
		if(current_time - update_time > 5*1000) {
			//조회수 증가 처리
			postDao.increateViewcnt(postno);
			//조회수를 올린 시간 저장
			session.setAttribute("update_time_"+postno, current_time);
		}
		
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return postDao.countArticle(search_option, keyword); 
	}

	@Override
	public PostDTO read(int bno) throws Exception {
		return postDao.read(bno);
	}
	
	@Transactional
	@Override
	public void update(PostDTO postDto) throws Exception {
		postDao.update(postDto); //board 테이블 수정
		//attach 테이블 수정
		String[] files=postDto.getFiles();
		if(files==null) return;
		for(String name : files) {
			System.out.println("첨부파일 이름:"+name);
			postDao.updateAttach(name, postDto.getPostno()); 
		}
		
	}
	

}
