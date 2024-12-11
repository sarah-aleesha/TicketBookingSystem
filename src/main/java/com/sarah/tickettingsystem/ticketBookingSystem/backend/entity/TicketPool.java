package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.*;

@Entity
@Table(name = "parameters")//specifies the name of the table
public class TicketPool {
    @Id// to specify the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generated the Primary Key
    private int id;
    @Column(name = "maximum_number_of_tickets", nullable = false)
    private int maximumNoOfTickets;
    @Transient
    private final ConcurrentLinkedQueue<Ticket> ticketQueue = new ConcurrentLinkedQueue<>();
    @Column(name = "number_of_tickets_released", nullable = false)
    private AtomicInteger ticketsReleased;
    /*even though int is also atomic, Atomic Integer is safer to use compared to int since it contains methods that are not available in int
    is i a better option in multi-threading environments*/
    @Column(name = "number_of_tickets_purchased", nullable = false)
    private AtomicInteger ticketsPurchased;
//Methods begin here onwards
    public void configureTicketPool(int maxNoTickets){
        maximumNoOfTickets = maxNoTickets;
    }
    public boolean addedTicket(Ticket ticket){
        if(ticketQueue.size()< maximumNoOfTickets){
            ticketQueue.offer(ticket);
            ticketsReleased.incrementAndGet();//method in the class AtomicInteger
            return true;
        }
        return false;
    }
    public Ticket boughtTicket(){
        Ticket ticket = ticketQueue.poll();
        if(ticket != null){
            ticketsPurchased.incrementAndGet();
        }
        return ticket;
    }
/*the number of tickets bought, only have readability access, maintaining integrity*/
    public int getTicketsReleased() {
        return ticketsReleased.get();
    }

    public int getTicketsPurchased() {
        return ticketsPurchased.get();
    }

    public int getId() {
        return id;
    }
    public int getPoolSize(){
        return ticketQueue.size();
    }
}
