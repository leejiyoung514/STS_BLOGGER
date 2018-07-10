package com.story.blogger.model.blog.dao;

import com.story.blogger.model.blog.dto.BlogDTO;

public interface BlogDAO {

	public int insertBlog(BlogDTO blogDto);

	public BlogDTO selectBlog(String userid);

	public int updateBlog(BlogDTO blogDto);


	
}
