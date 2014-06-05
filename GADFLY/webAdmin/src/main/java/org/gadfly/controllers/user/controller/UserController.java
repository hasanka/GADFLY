package org.gadfly.controllers.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.service.UserService;
import org.gadfly.core.api.to.UserDTO;
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
		List<User> result = userService.searchUsers(userDTO);
		model.addAttribute("userList", findUsers( result ) );
		return model; 
	}
	
	@ResponseBody
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public void addNewUser(@ModelAttribute UserDTO userDTO){
		try {
			userService.saveUser(userDTO.transformToUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
