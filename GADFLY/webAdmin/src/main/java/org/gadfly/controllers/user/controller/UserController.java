package org.gadfly.controllers.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.gadfly.controllers.user.dto.UserDTO;
import org.gadfly.core.api.service.UserService;
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
		model.addAttribute("userList", findUsers());
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
	
	
	private List<UserDTO> findUsers(){
		List<UserDTO> result = new ArrayList<UserDTO>();
		for(int i=0 ; i<15;i++){
			UserDTO userDTO = new UserDTO();
			userDTO.setUserID("userId"+i);
			userDTO.setTitle("Mr");
			userDTO.setUserName("UserName"+i);
			userDTO.setFirstName("F"+i);
			userDTO.setLastName("L"+i);
			userDTO.setEmail("Tets@gmail"+i);
			if(i<5){
				userDTO.setStatus("ACT");
				userDTO.setRole("Role One");
			}else{
				userDTO.setStatus("INA");
				userDTO.setRole("Role Two");
			}
			userDTO.setPassword("password");
			userDTO.setPhoneNumber("PhoneNumber"+i);	
			userDTO.setPassword("password");
			result.add(userDTO);
		}
		return result;
	}
	
	
}
