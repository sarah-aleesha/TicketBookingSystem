package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer extends Person implements Runnable{
    private int ticketsBought;
    private int customerRetrievalRate;

    public Customer(int id, String f_name, TicketPool ticketPool) {
        super(id, f_name, ticketPool);
    }


    @Override
    public void run() {
        for (int i = 0; i <= ticketsBought; i++) {
            Ticket ticket = getTicketPool().buyTicket();

            try{
                Thread.sleep(customerRetrievalRate * 1000);
            } catch(InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
