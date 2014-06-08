package org.gadfly.controllers.dashboard.controler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author HasankaMac
 *
 */
@Controller
@RequestMapping("/dashboard")
public class DashBoardController {

	@RequestMapping(value="/showView",method=RequestMethod.GET)
	public ModelAndView showView(){
		ModelAndView mv = new ModelAndView("/private/dashboard/ui/dashboard.jsp");
		mv.addObject("user", getLoggedUser());
		return mv;
	}

	private String getLoggedUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
	
}
