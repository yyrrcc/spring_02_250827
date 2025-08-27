package com.mycompany.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping (value = "/login")
	public String login(HttpServletRequest request, Model model) {
		return "login";
	}
	@RequestMapping (value = "/login2")
	public String login2(HttpServletRequest request, Model model) {
		return "login2";
	}
	@RequestMapping (value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		// 기존 방법 : request.getParameter 이용해서 값 가져오기
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		model.addAttribute("mid", mid);
		if (mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			return "loginOk";
		} else {
			return "loginFail";
		}
	}
	@RequestMapping (value = "/loginOk2")
	public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpSession session, HttpServletResponse response) {
		// 매개변수에 @RequestParam 이용해서 값 받아오기
		// 매개변수가 길어진다는 단점이 있어서, form에서 값 1~2개만 넘어왔을 때 보통 사용
		model.addAttribute("mid", mid);
		if (mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			return "loginOk";
		} else {
			return "loginFail";
		}
	}
	@RequestMapping (value = "/boardlist/{bnum}")
	// 만약 url../boardlist/값 이런식으로 파라미터 이름없이 값이 전달 될 때
	public String boardlist(@PathVariable String bnum, Model model) {
		model.addAttribute("bnum", bnum);
		return "boardlist";
		
	}
	@RequestMapping (value = "/join")
	public String join() {
		return "join";
	}
	@RequestMapping (value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		// 기존 방법
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mage = request.getParameter("mage");
		MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
		model.addAttribute("memberDto", memberDto);
		return "joinOk";
	}
	@RequestMapping (value = "/join2")
	public String join2() {
		return "join2";
	}
	@RequestMapping (value = "/joinOk2")
	public String joinOk2(MemberDto memberDto, Model model) {
		// 매개변수로 Dto 자체를 받기(조건 : Dto 매개변수의 값과 넘어오는 파라미터의 name이 동일해야 함)
		model.addAttribute("memberDto", memberDto);
		return "joinOk";
	}
	@RequestMapping (value = "/join3") // jsp에서 method 설정(get, post)에 따른 테스트
	public String join3() {
		return "join3";
	}
	// 동일한 value값이지만 method가 다르기 때문에 사용 가능, 하지만 메서드 이름은 다르게 해줘야 함
	@RequestMapping (value = "/joinOk3", method = RequestMethod.GET)
	public String joinOk3get(MemberDto memberDto, Model model) {
		model.addAttribute("memberDto", memberDto);
		return "joinOk";
	}
	// 동일한 value값이지만 method가 다르기 때문에 사용 가능, 하지만 메서드 이름은 다르게 해줘야 함	
	@RequestMapping (value = "/joinOk3", method = RequestMethod.POST)
	public String joinOk3post(MemberDto memberDto, Model model) {
		model.addAttribute("memberDto", memberDto);
		return "joinOk";
	}
	
	@RequestMapping (value = "/studentOk")
	public String studentinfo(@ModelAttribute("sInfo") StudentInfomationDto studentInfomationDto, Model model) {
		//model.addAttribute("studentInfomationDto", studentInfomationDto);
		return "studentOk";
	}

}
