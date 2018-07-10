package com.story.blogger.controller.category;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.story.blogger.model.category.dto.CategoryDTO;
import com.story.blogger.model.user.dto.UserDTO;
import com.story.blogger.service.category.CategoryService;

@Controller
public class CategoryController {

	// 회원별(블로그별) 카테고리 리스트 가져오기
	@Inject
	CategoryService categoryService;

	@ResponseBody
	@RequestMapping(value = "/api/cate/list", method = RequestMethod.POST)
	public List<CategoryDTO> cateList(HttpSession session) {

		// 로그인한 사용자의 카테고리 리스트를 가져옴
		UserDTO authUser = (UserDTO) session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		List<CategoryDTO> cateList = categoryService.getCateList(loginId);
		return cateList;
	}

	/*카테고리 추가*/
	@ResponseBody
	@RequestMapping(value = "/api/cate/add", method = RequestMethod.POST)
	public CategoryDTO cateAdd(@ModelAttribute CategoryDTO categoryDto) {
		//카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
		return categoryService.addCate(categoryDto);
	}
	
	/*카테고리 삭제*/
	@ResponseBody
	@RequestMapping(value = "/api/cate/remove", method = RequestMethod.POST)
	public int cateAdd(@RequestParam("cateno") int cateno) {
		return categoryService.removeCate(cateno);
	}	
}
