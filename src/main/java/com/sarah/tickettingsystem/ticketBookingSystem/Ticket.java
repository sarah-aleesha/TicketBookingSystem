package com.sarah.tickettingsystem.ticketBookingSystem;

public class Ticket {
    private int ticketId;
    private String nameOfEvent;
    private Double price;
    private String location;

    // all attributes are encapsulated by being made private to limit accessibility


    public Ticket(int ticketId, String nameOfEvent, Double price, String location) {
        this.ticketId = ticketId;
        this.nameOfEvent = nameOfEvent;
        this.price = price;
        this.location = location;

    }

    //if an attribute is made private, it can only be accessed in other classes through its getters and setters


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", nameOfEvent='" + nameOfEvent + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                '}';
    }
}
