package com.story.blogger.service.category;

import java.util.List;

import com.story.blogger.model.category.dto.CategoryDTO;



public interface CategoryService {

	public List<CategoryDTO> getCateList(String loginId);

	public CategoryDTO addCate(CategoryDTO categoryDto);

	public int removeCate(int cateno);

}
