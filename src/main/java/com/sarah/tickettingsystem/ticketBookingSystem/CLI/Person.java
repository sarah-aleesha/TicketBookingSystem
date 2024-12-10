package com.sarah.tickettingsystem.ticketBookingSystem.CLI;

public class Person implements Runnable{
    private int id;
    private TicketPool ticketPool;

    public Person(int id, TicketPool ticketPool) {
        this.id = id;
        this.ticketPool = ticketPool;
    }
    public Person(TicketPool ticketPool){
        this.ticketPool = ticketPool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run(){
        //main implementations are available in the run methods of the Customer and the Vendor
    }
}
