package com.story.blogger.model.user.dao;

import com.story.blogger.model.user.dto.UserDTO;

public interface UserDAO {
	
	/*회원정보 저장: 회원가입시*/
	public void join(UserDTO userDTO);
	
	public UserDTO selectUser(String id);
	/*로그인*/
	public UserDTO selecteLoginUser(UserDTO userDto);

	public void update(UserDTO userDto);

}
