package com.story.blogger.service.user;

import com.story.blogger.model.user.dto.UserDTO;

public interface UserService {

	public void join(UserDTO userDtO);
	public boolean idCheck(String id);
	public UserDTO login(UserDTO userDto);
	public void update(UserDTO userDto);

}
