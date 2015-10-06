package com.realty.springmvc.service;

import com.realty.springmvc.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private UserDAO userDAO;

  public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }

  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    com.realty.springmvc.model.User domainUser = userDAO.getUser(login);
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    return new User(domainUser.getLogin(), domainUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(domainUser.getRole().getId()));
  }

  public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
    List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
    return authList;
  }

  public List<String> getRoles(Integer role) {
    List<String> roles = new ArrayList<String>();
    switch (role.intValue()) {
      case 5:
        roles.add("ROLE_MODERATOR");
        roles.add("ROLE_ADMIN");
        break;
      case 6:
        roles.add("ROLE_MODERATOR");
        break;
      default:
        logger.debug("Authorisation Error", new Exception("Role unknown"));
    }
    logger.debug("Roles autorized: " + roles.toString());
    return roles;
  }

}
