package com.edanrh.ApiVizyon.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edanrh.ApiVizyon.repository.RepositoryUser;

import lombok.AllArgsConstructor;

import java.util.Collections;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

    private final RepositoryUser repositoryUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repositoryUser.findByEmail(username)
                .map(user -> {
                    final var authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
                    System.out.println(authorities);
                    return new User(user.getEmail(), user.getPassword(), authorities);
                }).orElseThrow(() -> new UsernameNotFoundException("User not exist"));
    }

}