package com.sarah.tickettingsystem.ticketBookingSystem;

public class Vendor extends Person implements Runnable{
    private int totalTickets;//the amount of tickets wished to be sold by the vendor
    private int ticketReleaseRate;//amount of time between addition of tickets to the ticket pool

    public Vendor(int id, String f_name, TicketPool ticketPool){
        super(id, f_name, ticketPool);

    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
//this is the body of a thread
    @Override
    public void run() {

    }
}
