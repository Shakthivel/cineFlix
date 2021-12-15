package com.cineFlix.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cineFlix.model.Ticket;

@Component
public interface TicketDAO extends JpaRepository<Ticket,Integer>{

}
