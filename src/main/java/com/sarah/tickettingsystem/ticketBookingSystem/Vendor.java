package com.sarah.tickettingsystem.ticketBookingSystem;

public class Vendor {
    private String id;
    private int ticketsSold;

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
}
