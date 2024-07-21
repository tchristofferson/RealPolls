package com.tchristofferson.realpolls.service;

import com.tchristofferson.realpolls.repository.RPUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RPUserService implements UserDetailsService {

    private final RPUserRepository rpUserRepository;

    @Autowired
    public RPUserService(RPUserRepository rpUserRepository) {
        this.rpUserRepository = rpUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return rpUserRepository.findByEmail(username.toLowerCase())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
