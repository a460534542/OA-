package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String show(HttpSession session,ModelMap modelMap){
		List<AffairModule>allAffairModules=affairModuleService.getAll();
		modelMap.addAttribute("allAffairModules", allAffairModules);
		User current=(User)session.getAttribute("user");
		//我发起的
		List<Affair>affairByMe=affairService.getAffairByMe(current);
		modelMap.addAttribute("affairByMe", affairByMe);
		//我审批的
		List<Affair>affairToBePropose=affairService.getAffairToBePropose(current);
		modelMap.addAttribute("affairToBePropose", affairToBePropose);
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
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Integer id,ModelMap modelMap){
	
		Affair affair=affairService.getAffairDetailByAffairId(id);
		System.out.println(affair.getAffairChains().get(0).getApprover().getNickname());
		modelMap.addAttribute("affair", affair);
		return "affair/detail";
	}
	@GetMapping("propose/{id}")
	public String propose(@PathVariable Integer id,ModelMap modelMap){
		Affair affair=affairService.getAffairDetailByAffairId(id);
		System.out.println(affair.getAffairChains().get(0).getApprover().getNickname());
		modelMap.addAttribute("affair", affair);
		return "affair/propose";
	}
	
	
}
