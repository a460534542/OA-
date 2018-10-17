package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

// 考勤管理
@Controller
@RequestMapping("roster")
public class RosterController {

	@GetMapping("show")
	public String show(RedirectAttributesModelMap r){
	
		return "roster/show";
	}
}
