package com.epam.newsmanagement.service;

import com.epam.newsmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.newsmanagement.dao.UserDetailsDAO;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDetailsDAO userDetailsDAO;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userDetailsDAO.findUserByUsername(username);
    UserBuilder builder = null;

    if (user != null) {
      builder = org.springframework
              .security
              .core
              .userdetails
              .User.withUsername(username);
      builder.disabled(!user.isEnabled());
      builder.password(user.getPassword());

      String[] authorities = user.getAuthorities()
          .stream().map(a -> a.getAuthority()).toArray(String[]::new);

      builder.authorities(authorities);
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
  }
}
