package com.sarah.tickettingsystem.ticketBookingSystem;

import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String nameOEvent;
    private ticketType type;
    private BigDecimal price;
    private String location;
    private String time;
    private String date;
    // all attributes are encapsulated by being made private to limit accessibility


    public Ticket(int ticketId, ticketType type,String nameOEvent, BigDecimal price, String location, String time, String date) {
        this.ticketId = ticketId;
        this.type = type;
        this.price = price;
        this.location = location;
        this.time = time;
        this.date = date;
    }

    //if an attribute is made private, it can only be accessed in other classes through its getter and setter

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

    public String getNameOEvent() {
        return nameOEvent;
    }

    public void setNameOEvent(String nameOEvent) {
        this.nameOEvent = nameOEvent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
                "ticketId=" + ticketId +
                ", nameOEvent='" + nameOEvent + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
