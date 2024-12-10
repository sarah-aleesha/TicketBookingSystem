package com.sarah.tickettingsystem.ticketBookingSystem.CLI;

//* represents all the annotations. * is used so that each annotation does not need to be explicitly imported
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final ConcurrentLinkedQueue<TicketPool> ticketPools = new ConcurrentLinkedQueue<>();

    @RequestMapping("/release")
    public String releaseTicket(@RequestBody TicketPool ticket){
        ticketPools.add(ticket);
        return "tickets released: " + ticket;
    }
}
