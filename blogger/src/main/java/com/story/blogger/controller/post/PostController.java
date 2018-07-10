package com.story.blogger.controller.post;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.story.blogger.model.blog.dto.BlogDTO;
import com.story.blogger.model.category.dto.CategoryDTO;
import com.story.blogger.model.post.dto.PostDTO;
import com.story.blogger.model.user.dto.UserDTO;
import com.story.blogger.service.blog.BlogService;
import com.story.blogger.service.category.CategoryService;
import com.story.blogger.service.post.PostService;
import com.story.blogger.util.Pager;


@Controller
public class PostController {

	@Inject
	BlogService blogService;
	@Inject
	CategoryService categoryService;
	@Inject
	PostService postService;
	
	//첨부파일 목록을 리턴
	//ArrayList를 json 배열로 변환하여 리턴
	@RequestMapping("getAttach/{postno}")
	@ResponseBody // view가 아닌 데이터 자체를 리턴 
	public List<String> getAttach(@PathVariable int postno){
		return postService.getAttach(postno);
	}
	
	//게시물 내용 삭제
	@RequestMapping(value="/{userid}/post/delete")
	public String delete(int postno, @PathVariable("userid") String userid, HttpSession session, Model model) throws Exception {
		// 로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO) session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		// 로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			postService.delete(postno); //삭제 처리
			model.addAttribute("blogDto", blogDto);
			return "redirect:/"+userid+"/post"; //목록으로 이동
		}else {
			return "redirect:/";
		}
	}
	
	//게시물 내용 수정	
	@RequestMapping(value="/{userid}/post/update")
	public String update(@PathVariable("userid") String userid, HttpSession session, Model model, PostDTO postDto) throws Exception {
		// 로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO) session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		// 로그인했고 자신의 블로그이면 진행
		if (authUser != null && userid.equals(loginId)) {
			if (postDto != null) {
				postService.update(postDto); // 레코드 수정
			}
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			model.addAttribute("blogDto", blogDto);
			return "redirect:/" + userid + "/post/view?postno=" + postDto.getPostno();
		} else {// 타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
	}
	
	
	/*글 목록페이지*/
	@RequestMapping(value="/{userid}/post", method=RequestMethod.GET)
	public String post(@PathVariable("userid") String userid, HttpSession session, Model model,
			@RequestParam(defaultValue="name") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			//레코드 갯수 계산
			int count=postService.countArticle(search_option,keyword);
			//페이지 관련 설정
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			//게시물 목록
			List<PostDTO> list=postService.listAll(search_option, keyword, start, end);
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			//카테고리정보 가져오기
			List<CategoryDTO> cateList = categoryService.getCateList(loginId);
			
			HashMap<String,Object> map=new HashMap<>();
			map.put("list", list); //map에 자료 저장
			map.put("count", count);
			map.put("pager", pager); //페이지 네비게이션을 위한 변수
			map.put("search_option", search_option);
			map.put("keyword",keyword); 
			model.addAttribute("map",map);
			model.addAttribute("blogDto", blogDto);
			model.addAttribute("cateList", cateList);
			return "post/blog-post";
			
		}else {//타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
	}
	

	@RequestMapping(value="/{userid}/post/view", method=RequestMethod.GET)
	public String postView(int postno, @PathVariable("userid") String userid, HttpSession session, Model model) throws Exception {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			//카테고리정보 가져오기
			List<CategoryDTO> cateList = categoryService.getCateList(loginId);
			//조회수 증가 처리
			postService.increateViewcnt(postno, session);
			//글보기
			model.addAttribute("blogDto", blogDto);
			model.addAttribute("cateList", cateList);
			model.addAttribute("postDto", postService.read(postno));
			return "post/blog-post-view";
			
		}else {//타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/{userid}/post/write", method=RequestMethod.GET)
	public String postWriteForm(@PathVariable("userid") String userid, HttpSession session, Model model) {
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
			return "post/blog-post-write";
			
		}else {//타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
	}
	
	//개인블로그 글쓰기설정페이지 저장
	@RequestMapping(value="/{userid}/post/write", method=RequestMethod.POST)
	public String postWrite(@PathVariable("userid") String userid, HttpSession session, Model model,
			@ModelAttribute PostDTO postDto) throws Exception {
		//로그인한 사용자 아이디(세션에서 가져오기)
		UserDTO authUser = (UserDTO)session.getAttribute("authUser");
		String loginId = authUser.getUserid();
		//세션에서 가져온 사용자아이디를 레코드에 저장
		postDto.setWriter(loginId);
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && userid.equals(loginId)) {
			
			postService.postWrite(postDto);
	/*		//블로그 기본정보 가져오기
			BlogDTO blogDto = blogService.getBlog(userid);
			//카테고리정보 가져오기
			List<CategoryDTO> cateList = categoryService.getCateList(loginId);
			
			model.addAttribute("blogDto", blogDto);
			model.addAttribute("cateList", cateList);*/
			
			return "redirect:/"+userid+"/post";
			
		}else {//타인의 블로그 설정페이지로 진입 시도한 경우
			return "redirect:/";
		}
	}
	
	
	

}


