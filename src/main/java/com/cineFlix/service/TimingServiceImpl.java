package com.cineFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.TimingDAO;
import com.cineFlix.model.Timings;

@Service
public class TimingServiceImpl implements TimingService {
	
	@Autowired
	TimingDAO timingDAO;

	@Override
	public Timings addTimings(Timings timing) {
		return timingDAO.save(timing);
	}

}
