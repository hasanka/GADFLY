package org.gadfly.controllers.dashboard.controler;

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
		return mv;
	}
	
}
