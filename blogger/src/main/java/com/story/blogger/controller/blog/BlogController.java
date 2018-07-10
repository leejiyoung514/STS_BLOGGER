package com.story.blogger.controller.blog;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.story.blogger.model.blog.dto.BlogDTO;
import com.story.blogger.model.category.dto.CategoryDTO;
import com.story.blogger.model.user.dto.UserDTO;
import com.story.blogger.service.blog.BlogService;
import com.story.blogger.service.category.CategoryService;
import com.story.blogger.service.user.UserService;

@Controller
public class BlogController {
	@Inject
	private UserService userService;
	@Inject
	private BlogService blogService;
	@Inject
	private CategoryService categoryService;
	
	//private PostService postService;
	/*개인블로그 메인페이지*/
	@RequestMapping(value="/{userid}", method=RequestMethod.GET)
	public String blogmain(@PathVariable("userid") String userid,
			HttpSession session, Model model) {
		UserDTO authUser=(UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		//방문한 블로그정보
		BlogDTO blogDto=blogService.getBlog(userid);
		//카테고리정보 가져오기
		List<CategoryDTO> cateList = categoryService.getCateList(loginId);
		
		model.addAttribute("blogDto", blogDto);	
		model.addAttribute("cateList", cateList);
		model.addAttribute("newLine", "\r\n"); //줄바꾸기용
		return "blog/blog-main";
	}
	
	/*개인블로그 자기소개리스트출력*/
	@RequestMapping(value="/{userid}/about", method=RequestMethod.GET)
	public String about(@PathVariable("userid") String userid, HttpSession session, Model model) {
		//방문한 블로그정보
		BlogDTO blogDto = blogService.getBlog(userid);
		model.addAttribute("blogDto", blogDto);	
		return "blog/blog-about";
	}
	
	/*자기소개업데이트*/
	@RequestMapping(value="/{userid}/about/update", method=RequestMethod.GET)
	public String aboutUpdateForm(@PathVariable("userid") String userid, HttpSession session, Model model) {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser=(UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
				
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(loginId);
			model.addAttribute("blogDto", blogDto);
			return "blog/blog-about-write";
			
		} else { //타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}

	}
	
	/*자기소개업데이트*/
	@RequestMapping(value="/{userid}/about/update", method=RequestMethod.POST)
	public String aboutUadate(@PathVariable("userid")String userid, @ModelAttribute BlogDTO blogDto, HttpSession session, Model model) throws IOException, Exception {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
				
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			blogDto.setUserid(loginId);
			//기본설정 수정
			blogService.blogUpdate(blogDto);
			return "redirect:/" + blogDto.getUserid() + "/about/update";
				
		} else { //타인의 블로그 설정페이지 수정을 시도한 경우
			return "redirect:/";
		}
	}
	
    /* 회원정보 수정폼*/
	@RequestMapping(value = "/{userid}/account/update", method = RequestMethod.GET)
	public String userUpdateform(@PathVariable("userid") String userid, HttpSession session, Model model) {
		// 로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO) session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		// 로그인했고 자신의 블로그이면 진행
		if (authUser != null && userid.equals(loginId)) {
			// 블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(loginId);
			model.addAttribute("blogDto", blogDto);
			return "blog/blog-account";

		} else { // 타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
		
	}
	
	/* 회원정보 수정하기*/
	@RequestMapping(value="/{userid}/account/update", method = RequestMethod.POST)
	public String userUpdate(@PathVariable("userid") String userid, @ModelAttribute UserDTO userDto,@ModelAttribute BlogDTO blogDto, HttpSession session, Model model) {
						
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
						
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
		
		    //기본설정 수정
			userService.update(userDto);
			return "redirect:/" + blogDto.getUserid() + "/account/update";
						
		} else { //타인의 블로그 설정페이지 수정을 시도한 경우
					return "redirect:/";
				}
	}
		
	/*개인블로그 카테고리설정 페이지 출력  
	등록 수정은 ajax로 api 컨트롤러 참고*/
	@RequestMapping(value="/{userid}/blog/cate", method=RequestMethod.GET)
	public String cate(@PathVariable("userid") String userid, HttpSession session, Model model) {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			
			//카테고리정보 가져오기
			List<CategoryDTO> cateList = categoryService.getCateList(loginId);
			
			model.addAttribute("blogDto", blogDto);
			model.addAttribute("cateList", cateList);
			return "blog/blog-cate";
			
		}else { //타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
		
	}
	
}
