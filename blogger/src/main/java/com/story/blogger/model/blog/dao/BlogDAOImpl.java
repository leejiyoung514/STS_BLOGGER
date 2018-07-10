package com.story.blogger.model.blog.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.story.blogger.model.blog.dto.BlogDTO;



@Repository
public class BlogDAOImpl implements BlogDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertBlog(BlogDTO blogDto) {
		return sqlSession.insert("blog.insertBlog", blogDto);
	}

	@Override
	public BlogDTO selectBlog(String userid) {
		return sqlSession.selectOne("blog.selectBlogById", userid);
	}

	@Override
	public int updateBlog(BlogDTO blogDto) {
		return sqlSession.update("blog.updateBlog", blogDto);
	}

}
