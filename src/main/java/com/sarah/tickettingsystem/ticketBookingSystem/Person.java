package com.sarah.tickettingsystem.ticketBookingSystem;

public class Person{
    private int id;
    private String f_name;
    private TicketPool ticketPool;

    public Person(int id, String f_name, TicketPool ticketPool) {
        this.id = id;
        this.f_name = f_name;
        this.ticketPool = ticketPool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }
}
