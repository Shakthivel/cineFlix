package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

	public Admin findByIdAndPassword(int id,String password);
}
