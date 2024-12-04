package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer extends Person implements Runnable{
    private int ticketsBought;

    public Customer(int id, String f_name, TicketPool ticketPool) {
        super(id, f_name, ticketPool);
    }


    @Override
    public void run() {
        //something
    }
}
