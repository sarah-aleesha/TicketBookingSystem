package com.sarah.tickettingsystem.ticketBookingSystem;

public class Vendor extends Person{
    private int totalTickets;//the amount of tickets wished to be sold by the vendor
    private int ticketReleaseRate;//amount of time between addition of tickets to the ticket pool

    public Vendor(int id, TicketPool ticketPool) {
        super(id, ticketPool);
    }
    public Vendor(TicketPool ticketPool,int totalTickets, int ticketReleaseRate){
        super(ticketPool);
        super.setTicketPool(ticketPool);
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public Vendor(int id, String f_name, TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        super(id, ticketPool);
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
//this is the body of a thread
    @Override
    public void run() {
        for(int i = 1 ; i <= totalTickets ; i++){
            Ticket ticket = new Ticket(i,
                    "Movie",
                    3.50,
                    "Scope Cinema");
            getTicketPool().addTicket(ticket);
            System.out.println(getId()+ " ( " + Thread.currentThread().getName() + " ) released a Ticket: " + ticket.toString());
            try {
                Thread.sleep(ticketReleaseRate * 1000);// the thread that executes the code will sleep for 2 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }

        }
    }
}
