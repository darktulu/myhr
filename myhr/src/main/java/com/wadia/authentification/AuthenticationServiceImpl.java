package com.wadia.authentification;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public void login(String login, String password) throws AuthenticationException {
	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,
		password));
	if (authenticate.isAuthenticated()) {
	    SecurityContextHolder.getContext().setAuthentication(authenticate);
	}
    }

    @Override
    public void logout() {
	SecurityContextHolder.getContext().setAuthentication(null);
    }

}
