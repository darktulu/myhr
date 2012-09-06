package com.wadia.authentification;

import org.springframework.security.core.AuthenticationException;

public interface AuthenticationService {

    public void login(String login, String password) throws AuthenticationException;

    public void logout();

}
