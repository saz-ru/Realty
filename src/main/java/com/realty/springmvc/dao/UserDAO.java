package com.realty.springmvc.dao;

import com.realty.springmvc.model.User;

public interface UserDAO {

  public User getUser(String login);

}
