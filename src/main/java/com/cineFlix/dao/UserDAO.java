package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cineFlix.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

}
