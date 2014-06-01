package org.gadfly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class Test {
	
	
	@RequestMapping(method=RequestMethod.GET,value="/show")
	public String showView(){
		return "/private/dashboard/ui/dashboard.jsp";
	}

}
