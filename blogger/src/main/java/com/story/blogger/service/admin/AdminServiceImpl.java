package com.story.blogger.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.story.blogger.model.admin.AdminDAO;
import com.story.blogger.model.user.dto.UserDTO;



@Service //service bean으로 등록
public class AdminServiceImpl implements AdminService {

	@Inject //의존관계 주입(DI)
	AdminDAO adminDao;
	
	@Override
	public String loginCheck(UserDTO dto) {
		return adminDao.loginCheck(dto);
	}

}




