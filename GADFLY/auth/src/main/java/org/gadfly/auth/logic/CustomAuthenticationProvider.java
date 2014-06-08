package org.gadfly.auth.logic;

import java.util.ArrayList;
import java.util.List;

import org.gadfly.auth.api.service.UserAuthenticateService;
import org.gadfly.core.api.to.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserAuthenticateService userAuthenticateService;
	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDTO dto = getUserDto(userName, password);
        if (userAuthenticateService.authenticateUser(dto)) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private UserDTO getUserDto(String userName,String password){
		UserDTO  dto = new UserDTO();
		dto.setUserName(userName);
		dto.setPassword(password);
		return dto;
	}
	
}
