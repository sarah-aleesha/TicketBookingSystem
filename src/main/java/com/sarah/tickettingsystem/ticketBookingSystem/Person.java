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
}
