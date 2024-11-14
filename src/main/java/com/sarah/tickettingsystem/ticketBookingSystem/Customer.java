package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer {
    private String name;
    TicketPool ticket;

    public Customer (String name){
        this.name = name;
    }
    public void removeTicket(TicketPool ticket){
        int currentNoOfTickets = ticket.getNoOfTickets();
        currentNoOfTickets -= 1;
        ticket.setNoOfTickets(currentNoOfTickets);
    }
}
