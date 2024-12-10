package com.sarah.tickettingsystem.ticketBookingSystem;

public class Customer extends Person{
    private static int ticketsBought;
    private static int customerRetrievalRate;

    public Customer(int ticketsBought, int customerRetrievalRate, TicketPool ticketPool) {
        super(ticketPool);
        Customer.ticketsBought = ticketsBought;
        Customer.customerRetrievalRate = customerRetrievalRate;

    }

    public static int getTicketsBought() {
        return ticketsBought;
    }

    public static void setTicketsBought(int ticketsBought) {
        Customer.ticketsBought = ticketsBought;
    }

    public static int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public static void setCustomerRetrievalRate(int customerRetrievalRate) {
        Customer.customerRetrievalRate = customerRetrievalRate;
    }

    //this method will be called when the start method is called in the Main method of the Main class
    @Override
    public void run() {

        synchronized (getTicketPool()) {
            while(super.getTicketPool().getSizeOfPool() <= 0 ){
                try {
                    getTicketPool().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            getTicketPool().notifyAll();
            Ticket ticket = getTicketPool().buyTicket();
            System.out.println(Thread.currentThread().getName() + " purchased Ticket " + ticket.toString());
            System.out.println("Current size of the ticket pool : " + getTicketPool().getSizeOfPool());

            try {
                Thread.sleep(customerRetrievalRate * 1000L);//time between each purchase
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }

        }
    }

}
