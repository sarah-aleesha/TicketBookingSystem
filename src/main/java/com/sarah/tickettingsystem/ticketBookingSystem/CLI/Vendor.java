package com.sarah.tickettingsystem.ticketBookingSystem.CLI;

public class Vendor extends Person{
    private static int ticketReleaseRate;
    private static int ticketCount;
    //amount of time between addition of tickets to the ticket pool


    public Vendor(int id, TicketPool ticketPool, int ticketReleaseRate) {
        super(id, ticketPool);
        Vendor.ticketReleaseRate = ticketReleaseRate;
    }

    public static int getTicketCount() {
        return ticketCount;
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

        synchronized (getTicketPool()) {
            while (super.getTicketPool().getSizeOfPool() > TicketPool.getMaximumNoOfTickets()) {
                try {
                    getTicketPool().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            getTicketPool().notifyAll();
            Ticket ticket = new Ticket(getTicketCount(),
                    "Movie",
                    3.50,
                    "Scope Cinema");
            getTicketPool().addTicket(ticket);
            Vendor.ticketCount += 1;
            System.out.println(Thread.currentThread().getName() + " ( " + ticketCount + " ) released a Ticket : " + ticket.toString());
            try {
                Thread.sleep(ticketReleaseRate * 1000L);// the thread that executes the code will sleep for 2 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }


        }
    }
}
