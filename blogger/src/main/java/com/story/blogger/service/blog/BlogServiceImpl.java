package com.story.blogger.service.blog;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.story.blogger.model.blog.dao.BlogDAO;
import com.story.blogger.model.blog.dto.BlogDTO;


@Service
public class BlogServiceImpl implements BlogService {
	@Inject
	private BlogDAO blogDao;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@Override
	public BlogDTO getBlog(String userid) {
		return blogDao.selectBlog(userid);
	}
	
	@Override
	public int blogUpdate(BlogDTO blogDto) throws IOException, Exception {
		MultipartFile file = blogDto.getFile();
		
		//첨부파일이 있으면 첨부파일 관련 정보 추출
		if ( !file.isEmpty() ) {
			String savename=file.getOriginalFilename();
			savename=uploadFile(savename, file.getBytes());
			//수정될 개인블로그logo파일 정보를  blogVo에 저장
			blogDto.setLogofile(savename);
		}
               //블로그 기본설정내용 수정
		return blogDao.updateBlog(blogDto);
	}
	
	String uploadFile(String originalName, byte[] fileData)
			throws Exception {
			// Universal Unique IDentifier, 범용고유식별자
			UUID uid=UUID.randomUUID();
			String savename=uid.toString()+"_"+originalName;
			// new File(디렉토리, 파일이름)
			File target=new File(uploadPath, savename);
			//첨부파일을 임시디렉토리에서 우리가 지정한 디렉토리로 복사
			FileCopyUtils.copy(fileData, target);
			return savename;
	}
	
}


