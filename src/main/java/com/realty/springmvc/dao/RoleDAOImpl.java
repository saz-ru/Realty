package com.realty.springmvc.dao;

import com.realty.springmvc.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public Role getRole(int id) {
    Role role = getCurrentSession().load(Role.class, id);
    return role;
  }

}
