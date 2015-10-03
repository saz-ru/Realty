package com.realty.springmvc.dao;

import com.realty.springmvc.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private Session openSession() {
    return sessionFactory.getCurrentSession();
  }

  public User getUser(String login) {
    Query query = openSession().createQuery("from User u where u.login = :login");
    query.setParameter("login", login);
    List<User> userList = query.list();
    if (userList.size() > 0)
      return userList.get(0);
    else
      return null;
  }

}
