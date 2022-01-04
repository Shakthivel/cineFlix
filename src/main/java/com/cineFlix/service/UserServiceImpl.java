package com.cineFlix.service;

import javax.persistence.PersistenceException;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

	public User register(User user) {
		String encryptedPassword = encrypt(user.getNumber(),user.getPassword());
		user.setPassword(encryptedPassword);
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

	public User login(String name, String password) {
		User user = userDAO.findByNumber(name);
		String decryptedText = decrypt(user.getNumber(),user.getPassword());
		if (password.equals(decryptedText)) {
			return user;
		}
		return null;
	}

	public String encrypt(String key,String password) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);
		String encryptedText = textEncryptor.encrypt(password);
		return encryptedText;
	}
	
	public String decrypt(String key,String password)
	{
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);
		String decryptedText = textEncryptor.decrypt(password);
		return decryptedText;
	}

}
