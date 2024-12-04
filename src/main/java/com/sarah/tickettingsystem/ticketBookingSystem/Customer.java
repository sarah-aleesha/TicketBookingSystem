package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer extends Person implements Runnable{
    private int ticketsBought;
    private int customerRetrievalRate;

    public Customer(int ticketsBought, int customerRetrievalRate, TicketPool ticketPool) {
        super(ticketPool);
        this.ticketsBought = ticketsBought;
        this.customerRetrievalRate = customerRetrievalRate;

    }

    @Override
    public void run() {
        for (int i = 0; i <= ticketsBought; i++) {
            Ticket ticket = getTicketPool().buyTicket();
            System.out.println(getF_name() + " purchased Ticket " + ticket.toString());

            try{
                Thread.sleep(customerRetrievalRate * 1000);//time between each purchase
            } catch(InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
