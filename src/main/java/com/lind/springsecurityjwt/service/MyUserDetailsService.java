package com.lind.springsecurityjwt.service;

import java.util.Arrays;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    return new User("zzl", "zzl", Arrays.asList(
        new SimpleGrantedAuthority("首页"),
        new SimpleGrantedAuthority("用户列表"),
        new SimpleGrantedAuthority("用户添加")));
  }
}
