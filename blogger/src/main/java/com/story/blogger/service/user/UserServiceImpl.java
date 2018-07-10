package com.story.blogger.service.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.story.blogger.model.blog.dao.BlogDAO;
import com.story.blogger.model.blog.dto.BlogDTO;
import com.story.blogger.model.category.dao.CategoryDAO;
import com.story.blogger.model.category.dto.CategoryDTO;
import com.story.blogger.model.user.dao.UserDAO;
import com.story.blogger.model.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDao;
	@Inject
	private BlogDAO blogDao;
	@Inject
	private CategoryDAO categoryDao;
	
	@Transactional
	@Override
	public void join(UserDTO userDto) {
		// 회원정보 저장
		userDao.join(userDto);

		// 블로그 초기값 저장(개설)
		BlogDTO blogDto=new BlogDTO();
		blogDto.setUserid(userDto.getUserid());
		blogDto.setBlogtitle(userDto.getName()+"의 블로그입니다.");
		blogDto.setBlogcontent("자기소개를 입력해주세요.");
		blogDto.setLogofile("default");

		blogDao.insertBlog(blogDto);

		// 카테고리 초기값 저장
		CategoryDTO categoryDto = new CategoryDTO();
		categoryDto.setUserid(userDto.getUserid());
		categoryDto.setCatename("미분류");
		categoryDto.setDescription("기본으로 만들어지는 카테고리 입니다.");
		categoryDto.setUserid(userDto.getUserid());

		categoryDao.insertCate(categoryDto);

	}

	@Override
	public boolean idCheck(String id) {
		boolean isExist;
		UserDTO dto = userDao.selectUser(id);
		if(dto == null) {
			isExist = false; //존재하니-->아니요: 사용할 수 있음
		} else {
			isExist = true;  //존재하니-->예: 사용할 수 없음
		}
		return isExist;
	}
	
	@Override
	public UserDTO login(UserDTO userDto) {
		//회원정보 가져오기
		UserDTO authUser = userDao.selecteLoginUser(userDto);
		return authUser;
	}

	@Override
	public void update(UserDTO userDto) {
		userDao.update(userDto);
	}


}
