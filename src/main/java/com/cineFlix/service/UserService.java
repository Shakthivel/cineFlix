package com.cineFlix.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.UserDAO;
import com.cineFlix.model.User;

@Component("userService")
public interface UserService {

	public User login(String name,String password);
	public User register(User user);
	
}
