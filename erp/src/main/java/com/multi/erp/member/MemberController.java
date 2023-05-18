package com.multi.erp.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.erp.dept.DeptDTO;
import kr.multi.erp.dept.DeptService;


@Controller
@RequestMapping("/emp")
public class MemberController {
	MemberService service;
	DeptService deptservice;

	public MemberController() {
	}
	@Autowired
	public MemberController(MemberService service, DeptService deptservice) {
		super();
		this.service = service;
		this.deptservice = deptservice;
	}

	@RequestMapping(value = "/insert", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String insertPage(Model model) {
		//DeptService를 등록하고 부서명을 register.jsp에서 사용할 수 있도록 attribute로 추가하기
		List<DeptDTO> deptlist = deptservice.select();
		model.addAttribute("deptlist", deptlist);
		return "member/insertPage";
	}
	@RequestMapping(value = "/login.do", method= RequestMethod.GET )
	  public String loginPage() {
		  return "login";
	  }
	
	@RequestMapping( value = "/login.do", method= RequestMethod.POST)
	public ModelAndView login(MemberDTO loginUserInfo, HttpServletRequest request) {
		System.out.println(loginUserInfo);
		ModelAndView mav = new ModelAndView();
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if (user != null) {
			HttpSession session = request.getSession(); // 세션만들기
			session.setAttribute("user", user);
			//서비스에서 가공한 뷰의 이름 - 로그인한 사용자가 어떤 job이냐에 따라 작업할 수 있는 메뉴가 달라질 수 있도록
			view = user.getMenupath();
		} else {
			// 로그인 실패
			view = "redirect:/emp/login.do";
		}
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {

		if (session != null) {
			// 사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/emp/login.do";
	}
	@RequestMapping("/mypage")
	public String myPage(HttpSession session) {
		//나중에는 제일 복잡한 컨트롤러가 될 수 있다.
		//결재에 대한 진행상황
		//스케줄표 - 업무스케줄,미팅일정,휴가일정
		//진행중인 메인업무에 대한 내용
		MemberDTO user =  (MemberDTO) session.getAttribute("user");
		return user.getMenupath();
	}
}
