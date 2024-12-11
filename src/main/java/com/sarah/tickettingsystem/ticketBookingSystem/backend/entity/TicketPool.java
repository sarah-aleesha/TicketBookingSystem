package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import java.util.concurrent.ConcurrentLinkedQueue;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;


@Component
public class TicketPool {
    private int maximumNoOfTickets;
    private final ConcurrentLinkedQueue<Ticket> ticketQueue = new ConcurrentLinkedQueue<>();
    private int ticketsReleased;
    private int ticketsPurchased;

    public void configureTicketPool(int maxNoTickets){
        maximumNoOfTickets = maxNoTickets;
    }
    public boolean addedTicket(Ticket ticket){
        if(ticketQueue.size()< maximumNoOfTickets){
            ticketQueue.offer(ticket);
            ticketsReleased += 1;
            return true;
        }
        return false;
    }
    public Ticket boughtTicket(){
        Ticket ticket = ticketQueue.poll();
        if(ticket != null){
            ticketsPurchased += 1;
        }
        return ticket;
    }
/*the number of tickets bought, only have readability access, maintaining integrity*/
    public int getTicketsReleased() {
        return ticketsReleased;
    }

    public int getTicketsPurchased() {
        return ticketsPurchased;
    }
}
