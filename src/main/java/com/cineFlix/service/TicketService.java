package com.cineFlix.service;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Ticket;


public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
}
