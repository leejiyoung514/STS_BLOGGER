package com.story.blogger.controller.user;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.story.blogger.model.user.dto.UserDTO;
import com.story.blogger.service.user.UserService;



@Controller
@RequestMapping(value = "/user")
public class UserController {
	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService userService;
	
	/*회원가입폼 출력*/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "user/join";
	}
	
	/*회원가입*/
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserDTO userDTO) {
		userService.join(userDTO);
		return "main";
	}
	
	/*아이디체크 : 회원가입시 사용중인 아이디인지 검사*/
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public boolean idCheck(String userid) {
		System.out.println(userid+"넘어오는지확인");
		return userService.idCheck(userid);
	}

	/* 로그인폼 출력 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	/*로그인*/  
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login_check(UserDTO userDto, HttpSession session) {
		// 로그인 성공 true, 실패 false
		UserDTO authUser = userService.login(userDto);
	
		if (authUser !=null) { // 로그인 성공
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else { // 로그인 실패
		   return "redirect:/user/login?message=error";
		}
	}

	/*로그아웃*/
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/user/login?message=logout";
	}
	
	
}
