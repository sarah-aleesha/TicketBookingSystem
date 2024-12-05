package com.sarah.tickettingsystem.ticketBookingSystem;

public class Vendor extends Person{
    private static int noOfTicketsToAdd;//the amount of tickets wished to be sold by the vendor
    private static int ticketReleaseRate;
    //amount of time between addition of tickets to the ticket pool


    public Vendor(int id, TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        super(id, ticketPool);
        Vendor.ticketReleaseRate = ticketReleaseRate;
        noOfTicketsToAdd = totalTickets;
    }

    public static int getNoOfTicketsToAdd() {
        return noOfTicketsToAdd;
    }

    public static void setNoOfTicketsToAdd(int noOfTicketsToAdd) {
        Vendor.noOfTicketsToAdd = noOfTicketsToAdd;
    }

    public static int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public static void setTicketReleaseRate(int ticketReleaseRate) {
        Vendor.ticketReleaseRate = ticketReleaseRate;
    }

    //this is the body of a Vendor thread
    @Override
    public void run() {
        synchronized (Vendor.class) {
            while (super.getTicketPool().getSizeOfPool() > TicketPool.getMaximumNoOfTickets()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 1; i <= noOfTicketsToAdd; i++) {
                Ticket ticket = new Ticket(i,
                        "Movie",
                        3.50,
                        "Scope Cinema");
                getTicketPool().addTicket(ticket);
                System.out.println(Thread.currentThread().getName() + " ( " + getId() + " ) released a Ticket : " + ticket.toString());
                try {
                    Thread.sleep(ticketReleaseRate * 1000L);// the thread that executes the code will sleep for 2 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }

            }
        }
    }
}
