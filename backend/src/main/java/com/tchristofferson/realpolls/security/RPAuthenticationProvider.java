package com.tchristofferson.realpolls.security;

import com.tchristofferson.realpolls.service.RPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class RPAuthenticationProvider implements AuthenticationProvider {

    private final RPUserService rpUserService;

    @Autowired
    public RPAuthenticationProvider(RPUserService rpUserService) {
        this.rpUserService = rpUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails user = rpUserService.loadUserByUsername(authentication.getName());
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
