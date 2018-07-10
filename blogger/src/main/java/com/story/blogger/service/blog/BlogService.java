package com.story.blogger.service.blog;

import java.io.IOException;

import com.story.blogger.model.blog.dto.BlogDTO;



public interface BlogService {

	public BlogDTO getBlog(String userid);

	public int blogUpdate(BlogDTO blogDto)throws IOException, Exception;

}
