package com.story.blogger.model.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.story.blogger.model.user.dto.UserDTO;



@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	SqlSession sqlSession;

	/*회원정보 저장: 회원가입시*/
	@Override
	public void join(UserDTO userDTO) {
		sqlSession.insert("user.insert", userDTO); 
	}
	
	/*아이디로 회원정보 가져오기*/
	@Override
	public UserDTO selectUser(String id) {
		return sqlSession.selectOne("user.selectUserById", id);
	}

	/*로그인*/
	@Override
	public UserDTO selecteLoginUser(UserDTO userDto) {
		return sqlSession.selectOne("user.selectUserForLogin", userDto);
	}

	@Override
	public void update(UserDTO userDto) {
		 sqlSession.update("user.update", userDto);
	}
	

	

}
