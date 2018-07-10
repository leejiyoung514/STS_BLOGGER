package com.story.blogger.model.admin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.story.blogger.model.user.dto.UserDTO;



@Repository //dao bean
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public String loginCheck(UserDTO dto) {
		return sqlSession.selectOne("admin.login_check", dto); 
	}

}





