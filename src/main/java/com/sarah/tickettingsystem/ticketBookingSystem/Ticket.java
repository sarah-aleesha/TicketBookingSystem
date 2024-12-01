package com.sarah.tickettingsystem.ticketBookingSystem;

import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String nameOEvent;
    private BigDecimal price;
    // all attributed are encapsulated by being made private

    public Ticket(int ticketId, String nameOEvent, BigDecimal price) {
        this.ticketId = ticketId;
        this.nameOEvent = nameOEvent;
        this.price = price;
    }
//if an attribute is made private, it can only be accessed in other classs through its getter and setter
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

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", nameOEvent='" + nameOEvent + '\'' +
                ", price=" + price +
                '}';
    }
}
