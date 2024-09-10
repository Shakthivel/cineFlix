package com.cineFlix.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.UserDAO;
import com.cineFlix.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// Register a user without encryption
	public User register(User user) {
		String plainPassword = user.getPassword();
		user.setPassword(plainPassword);  // Directly setting the plain password
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

	// Login a user without decryption
	public User login(String name, String password) {
		User user = userDAO.findByNumber(name);
		System.out.println(user);
		if (user != null && password.equals(user.getPassword())) {  // Directly comparing plain password
			return user;
		}
		return null;
	}

	// Remove the encrypt and decrypt methods entirely as they are no longer needed
}
