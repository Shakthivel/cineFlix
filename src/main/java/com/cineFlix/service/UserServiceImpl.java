package com.cineFlix.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.UserDAO;
import com.cineFlix.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User register(User user) {
		try {
			return userDAO.save(user);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			Throwable t;
			for (t = e.getCause(); t.getCause() != null; t = t.getCause()) {
			}
			System.out.println(t.getMessage());
		}
		return null;
	}

	public User login(String name,String password) {
		
		return userDAO.findByNameAndPassword(name, password);
	}
}
