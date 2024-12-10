package com.sarah.tickettingsystem.ticketBookingSystem.CLI;

public class Person implements Runnable{
    private int id;
    private TicketPool ticketPool;

    /*
    polymorphism is shown in the below 2 constructors
    if an object is initialized by giving the id and the ticket pool, the 1st constructor is called
    on the other hand, if only the ticket pool is given, the second constructor will be called,
    making the Person class include constructor polymorphism in its implementation
    */
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
