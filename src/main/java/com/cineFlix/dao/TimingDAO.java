package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineFlix.model.Timings;


@Repository
public interface TimingDAO extends JpaRepository<Timings,Integer> {

}
