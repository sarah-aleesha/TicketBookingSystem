package com.sarah.tickettingsystem.ticketBookingSystem;

public class Vendor implements Runnable{
    private String id;
    private int ticketsSold;
    private TicketPool tickets;

    public Vendor(String id, int ticketsSold){
        this.id = id;
        this.ticketsSold = ticketsSold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
    public void addTickets(TicketPool tickets){
    }

    @Override
    public void run() {

    }
}
