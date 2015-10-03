package com.realty.springmvc.service;

import com.realty.springmvc.dao.UserDAO;
import com.realty.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;

  public User getUser(String login) {
    return userDAO.getUser(login);
  }

}
