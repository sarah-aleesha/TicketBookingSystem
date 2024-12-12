package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Customer implements Runnable{
    private int ticketsBought;
    private int customerRetrievalRate;
    @ManyToOne
    @JoinColumn(name = "ticket_pool_id", nullable = false)
    private TicketPool ticketPool;

    public Customer(int ticketsBought, int customerRetrievalRate, TicketPool ticketPool) {
        this.ticketsBought = ticketsBought;
        this.customerRetrievalRate = customerRetrievalRate;

    }

    public int getTicketsBought() {
        return this.ticketsBought;
    }

    public static void setTicketsBought(int ticketsBought) {
        ticketsBought = ticketsBought;
    }

    public int getCustomerRetrievalRate() {
        return this.customerRetrievalRate;
    }

    public static void setCustomerRetrievalRate(int customerRetrievalRate) {
        customerRetrievalRate = customerRetrievalRate;
    }

    //this method will be called when the start method is called in the Main method of the Main class
    @Override
    public void run() {

        synchronized (ticketPool) {
            while(ticketPool.getPoolSize() <= 0 ){
                try {
                    ticketPool.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            ticketPool.notifyAll();
            Ticket ticket = ticketPool.buyTicket();
            System.out.println(Thread.currentThread().getName() + " purchased Ticket " + ticket.toString());
            System.out.println("Current size of the ticket pool : " + ticketPool.getPoolSize());

            try {
                Thread.sleep(customerRetrievalRate * 1000L);//time between each purchase
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }

        }
    }

}
