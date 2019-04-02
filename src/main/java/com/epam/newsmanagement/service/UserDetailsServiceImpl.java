package com.epam.newsmanagement.service;

import com.epam.newsmanagement.entity.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.newsmanagement.dao.UserDAO;
import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) {
      User user = userDAO.findUserByUsername(username);

      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getAuthorities().getAuthority());

      Set<GrantedAuthority> authorities = new HashSet<>();
      authorities.add(grantedAuthority);

      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }
}
