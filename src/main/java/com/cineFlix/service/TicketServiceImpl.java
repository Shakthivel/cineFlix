package com.cineFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.TicketDAO;
import com.cineFlix.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketDAO ticketDAO;

	@Override
	public Ticket addTicket(Ticket ticket) {

		return ticketDAO.save(ticket);
	}

}
