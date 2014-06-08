package org.gadfly.controllers.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.service.UserService;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author HasankaMac
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/showView",method=RequestMethod.GET)
	public ModelAndView showView(){
		ModelAndView mv = new ModelAndView("/private/user/ui/user.jsp");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/searchUsers",method=RequestMethod.GET)
	public ModelMap searchUsers(@ModelAttribute UserDTO userDTO){
		ModelMap model = new ModelMap();
		try {
			logger.info("Saving user initialized");
			List<User> result = userService.searchUsers(userDTO);
			model.addAttribute("userList", findUsers( result ) );
			model.addAttribute("sucess", true );
			logger.info("Saving user ended");
		} catch (GadfyException ge) {
			model.addAttribute("sucess", false );
			model.addAttribute("error", ge.getMessage());
			logger.info("Saving user has error");
		}
		return model; 
	}
	
	@ResponseBody
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelMap addNewUser(@ModelAttribute UserDTO userDTO){
		ModelMap model = new ModelMap();
		try {
			userService.saveUser(userDTO.transformToUser());
			model.addAttribute("sucess", true );
		} catch (GadfyException ge) {
			model.addAttribute("sucess", false );
			model.addAttribute("error", ge.getMessage());
		}
		return model;
	}
	
	
	private List<UserDTO> findUsers( List<User> list){
		List<UserDTO> result = new ArrayList<UserDTO>();
		if(list != null && list.size() > 0){
			for (User user : list) {
				UserDTO dto = new UserDTO(user);
				result.add(dto);
			}
		}
		return result;
	}
	
	
}
