package com.story.blogger.model.admin;

import com.story.blogger.model.user.dto.UserDTO;

public interface AdminDAO {
	public String loginCheck(UserDTO dto);
}
