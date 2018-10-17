package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Affair;
import com.bwf.entity.AffairModule;
import com.bwf.entity.User;
import com.bwf.service.IAffairModuleService;

@Controller
@RequestMapping("affair")
public class AffairController {
	
	@Autowired
	IAffairModuleService affairModuleService;
	
	@Autowired
	com.bwf.service.IModuleOptionService moduleOptionService;

	@Autowired
	com.bwf.service.IAffairService affairService;

	@GetMapping("show")
	public String show(ModelMap modelMap){
		List<AffairModule>allAffairModules=affairModuleService.getAll();
		modelMap.addAttribute("allAffairModules", allAffairModules);
		
		return "affair/show";
	}
	
	@GetMapping("add")
	public String add(Integer affairModuleId , ModelMap modelMap){

		modelMap.addAttribute("moduleOptions", moduleOptionService.getModuleOptionsByAffairModuleId(affairModuleId)) ;
		modelMap.addAttribute("affairModuleId", affairModuleId);
		
		return "affair/add";
	}
	
	@PostMapping("doAdd")
	public String doAdd( Integer affairModuleId ,  String html , HttpSession session ){
		Affair affair = new Affair();
		AffairModule affairModule = new AffairModule();
		affairModule.setAffairModuleId(affairModuleId);
		affair.setAffairModule(affairModule);
		affair.setAffairData(html);
		affair.setProposer(  (User)session.getAttribute("user") );
		affair.setAffairStatus(0);
		
		
		affairService.add( affair );
		return "redirect:/affair/show";
	}
}
