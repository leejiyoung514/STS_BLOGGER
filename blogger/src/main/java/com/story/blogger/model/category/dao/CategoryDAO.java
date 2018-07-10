package com.story.blogger.model.category.dao;

import java.util.List;

import com.story.blogger.model.category.dto.CategoryDTO;



public interface CategoryDAO {
	
	public List<CategoryDTO> selectList(String userid);

	public int insertCate(CategoryDTO categoryDto);
	
	public CategoryDTO selectCate(int cateno);

	public int deleteCate(int cateno);

}
