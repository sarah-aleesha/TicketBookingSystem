package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer {
    private String name;
    TicketPool ticket;

    public Customer (String name){
        this.name = name;
    }
    public void removeTicket(TicketPool ticket){
        int currentNoOfTickets = ticket.getMaximumNoOfTickets();
        currentNoOfTickets -= 1;
        ticket.setMaximumNoOfTickets(currentNoOfTickets);
    }
}
