package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import java.util.concurrent.ConcurrentLinkedQueue;
import jakarta.persistence.Entity;


@Entity
public class TicketPool {
    private static int maximumNoOfTickets;
    private static final ConcurrentLinkedQueue<Ticket> ticketQueue = new ConcurrentLinkedQueue<>();

    public static void addTicket(Ticket ticket){
        boolean offer = ticketQueue.offer(ticket);
        if(offer){
            System.out.println("added successfully");
        } else {
            System.out.println("could not add ticket to the ticket pool");
        }
    }
}
