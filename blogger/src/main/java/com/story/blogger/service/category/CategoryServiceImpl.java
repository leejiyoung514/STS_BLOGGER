package com.story.blogger.service.category;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.story.blogger.model.category.dao.CategoryDAO;
import com.story.blogger.model.category.dto.CategoryDTO;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	CategoryDAO categoryDao;
	
	@Override/*회원ID로 가테고리 가져오기*/
	public List<CategoryDTO> getCateList(String userid) {
		return categoryDao.selectList(userid);
	}

	@Override/*카테고리 추가*/
	public CategoryDTO addCate(CategoryDTO categoryDto) {
		//카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
		int cateno = categoryDao.insertCate(categoryDto);
		return categoryDao.selectCate(cateno);
	}

	@Override/*카테고리 삭제*/
	public int removeCate(int cateno) {
		return categoryDao.deleteCate(cateno);
	}

}
