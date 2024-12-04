package com.sarah.tickettingsystem.ticketBookingSystem;

import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String nameOfEvent;
    private ticketType type;
    private Double price;
    private String location;
    private String time;
    private String date;
    // all attributes are encapsulated by being made private to limit accessibility


    public Ticket(int ticketId, ticketType type,String nameOfEvent, Double price, String location, String time, String date) {
        this.ticketId = ticketId;
        this.type = type;
        this.nameOfEvent = nameOfEvent;
        this.price = price;
        this.location = location;
        this.time = time;
        this.date = date;
    }

    //if an attribute is made private, it can only be accessed in other classes through its getters and setters

    public ticketType getType() {
        return type;
    }

    public void setType(ticketType type) {
        this.type = type;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "\nticketId=" + ticketId +
                ", \nnameOEvent='" + nameOfEvent + '\'' +
                ", \nprice=" + price +
                ", \nlocation='" + location + '\'' +
                ", \ntime='" + time + '\'' +
                ", \ndate='" + date + '\'' +
                '}';
    }
}
