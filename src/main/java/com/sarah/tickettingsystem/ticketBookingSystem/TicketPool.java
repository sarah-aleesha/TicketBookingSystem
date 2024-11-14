package com.sarah.tickettingsystem.ticketBookingSystem;

public class TicketPool {
    private int noOfTickets;

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public void addTicket(){
        this.noOfTickets += 1;
    }
}
