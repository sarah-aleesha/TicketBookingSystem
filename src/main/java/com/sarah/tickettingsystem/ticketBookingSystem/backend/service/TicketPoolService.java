package com.sarah.tickettingsystem.ticketBookingSystem.backend.service;

import com.sarah.tickettingsystem.ticketBookingSystem.backend.entity.TicketPool;
import com.sarah.tickettingsystem.ticketBookingSystem.backend.repository.TicketPoolRepository;
import com.sarah.tickettingsystem.ticketBookingSystem.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketPoolService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketPoolRepository ticketPoolRepository;
/*this method add a ticket to the pool
* it takes the ticket pool id of type int and a ticket of type Ticket as its arguments
* finally it returns a boolean to specify if a ticket has been added*/
    public void addedTicketToPool(int tickPoolId){
        TicketPool ticketPool ;
    }
}
