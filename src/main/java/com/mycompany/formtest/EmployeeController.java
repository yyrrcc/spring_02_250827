package com.mycompany.formtest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	
	@RequestMapping (value = "/employeeInput")
	public String employeeInput( ) {
		return "employeeInput";
	}
	@RequestMapping (value = "/employeeCheck")
	// 1. response.sendRedirect("employeeOk"); 하게 되면 하단에 
	// @RequestMapping (value = "/employeeOk"), @RequestMapping (value = "/employeeNo") 만들어줘야 함
	
	// 2. return "redirect:employeeOk"; 와 return "employeeNo"; 차이점
	// "redirect:employeeOk"; 는 @RequestMapping (value = "/employeeOk") 로 이동해서 sid 값 가져올 수 있음 (.do 요청 이라고 생각하면 됨)
	// return "employeeNo"; 는 바로 .jsp로 이동하기 때문에 sid 값이 나오지 않는다 
	public String employeeOk(@RequestParam("eid") String eid, Model model, HttpServletResponse response) {
		if (eid.equals("tiger")) {
//			try {
//				response.sendRedirect("employeeOk");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			return "redirect:employeeOk";
			//return "employeeOk";
		} else {
//			try {
//				response.sendRedirect("employeeNo");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			return "redirect:employeeNo";
			//return "employeeNo";
		}
	}
	@RequestMapping (value = "/employeeOk")
	public String employeeOk(Model model) {
		//model.addAttribute("eid", "tiger");
		return "employeeOk";
	}
	@RequestMapping (value = "/employeeNo")
	public String employeeNo(Model model) {
		//model.addAttribute("eid", "tiger");
		return "employeeNo";
	}

}
