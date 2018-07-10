package com.story.blogger.model.category.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.story.blogger.model.category.dto.CategoryDTO;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override/*회원번호로 카테고리리스트 가져오기*/
	public List<CategoryDTO> selectList(String userid) {
		return sqlSession.selectList("cate.selectList", userid);
	}
	
	@Override/*카테고리 기본값 저장 :회원가입시, 카테고리 추가시*/
	public int insertCate(CategoryDTO categoryDto) {
		sqlSession.insert("cate.insert", categoryDto);
		return categoryDto.getCateno();
	}

	@Override/*특정카테고리 정보를 가져온다*/
	public CategoryDTO selectCate(int cateno) {
		return sqlSession.selectOne("cate.selectCate", cateno);
	}

	@Override/*카테고리삭제*/
	public int deleteCate(int cateno) {
		return sqlSession.delete("cate.deleteCate", cateno);
	}
	

}
