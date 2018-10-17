package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping( value={"" , "index" , "index/index" } )
	public String index (){
		return "index/index";
	}
	
	@GetMapping( value="home" )
	public String home(){
		return "index/home";
	}
	
}
