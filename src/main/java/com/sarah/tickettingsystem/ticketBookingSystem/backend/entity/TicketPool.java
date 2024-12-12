package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import jakarta.persistence.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "TicketPool")
public class TicketPool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maximum_number_of_tickets", nullable = false)
    private int maximumNoOfTickets;

    @Transient
    private final ConcurrentLinkedQueue<Ticket> ticketQueue = new ConcurrentLinkedQueue<>();

    @Column(name = "number_of_tickets_released", nullable = false)
    private AtomicInteger ticketsReleased = new AtomicInteger(0);

    @Column(name = "number_of_tickets_purchased", nullable = false)
    private AtomicInteger ticketsPurchased = new AtomicInteger(0);

    // Constructors

    public TicketPool() {
        // Default constructor required by JPA
    }

    public TicketPool(int maxNoTickets) {
        if (maxNoTickets <= 0) {
            throw new IllegalArgumentException("Maximum number of tickets must be greater than zero.");
        }
        this.maximumNoOfTickets = maxNoTickets;
    }

    // Methods to add the tickets

    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maximumNoOfTickets) {
            try {
                System.out.println("Ticket pool is full. Waiting for space...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                throw new IllegalStateException("Thread was interrupted while adding a ticket.", e);
            }
        }
        ticketQueue.offer(ticket);
        ticketsReleased.incrementAndGet();
        System.out.println("Ticket added: " + ticket);
        notifyAll(); // Notify threads waiting to buy tickets
    }

    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                System.out.println("No tickets available. Waiting for a ticket...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                throw new IllegalStateException("Thread was interrupted while buying a ticket.", e);
            }
        }
        Ticket ticket = ticketQueue.poll();
        if (ticket != null) {
            ticketsPurchased.incrementAndGet();
            System.out.println("Ticket purchased: " + ticket);
        }
        notifyAll(); // Notify threads waiting to add tickets
        return ticket;
    }

    // Getter Methods

    public int getTicketsReleased() {
        return ticketsReleased.get();
    }

    public int getTicketsPurchased() {
        return ticketsPurchased.get();
    }

    public int getPoolSize() {
        return ticketQueue.size();
    }

    public int getId() {
        return id;
    }

    public int getMaximumNoOfTickets() {
        return maximumNoOfTickets;
    }


    @Override
    public String toString() {
        return "TicketPool{" +
                "id=" + id +
                ", maximumNoOfTickets=" + maximumNoOfTickets +
                ", ticketsReleased=" + ticketsReleased +
                ", ticketsPurchased=" + ticketsPurchased +
                ", currentPoolSize=" + ticketQueue.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPool that = (TicketPool) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
