package com.cineFlix.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.model.User;

@Component("userService")
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void service() {
		User user = new User();
		user.setUserId(2);
		user.setName("ModifyTest");
		user.setAddress("Chennai");
		user.setEmail("shakthibala1884@gmail.com");
		user.setNumber("7904017458");
		user.setPassword("secret");
		try {
			userDAO.save(user);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			Throwable t;
			for (t = e.getCause(); t.getCause() != null; t = t.getCause()) {
			}
			System.out.println(t.getMessage());
		}
	}

}
