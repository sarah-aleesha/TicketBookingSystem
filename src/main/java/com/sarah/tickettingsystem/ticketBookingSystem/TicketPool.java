package com.sarah.tickettingsystem.ticketBookingSystem;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool{
    private int maximumNoOfTickets;
    private Queue<Ticket> ticketQueue;


    public TicketPool(int maximumNoOfTickets, Ticket ticket ){
        this.maximumNoOfTickets = maximumNoOfTickets;
        this.ticketQueue = new LinkedList<>();
    }
 //This method is used to get the number of maximum tickets which can be stored in the ticket pool
//takes no arguments
    // returns the maximum number of tickets
    public int getMaximumNoOfTickets() {
        return maximumNoOfTickets;
    }
//This method is used to set the number of maximum tickets which can be stored in the ticket pool
// takes the maximum capacity of tickets of type integer
// returns void
    public void setMaximumNoOfTickets(int maximumNoOfTickets) {
        this.maximumNoOfTickets = maximumNoOfTickets;
    }
//This method is used to add tickets to the queue which is done by the vendor
// takes a ticket of type Ticket as its argument
// returns void
    public synchronized void addTicket(Ticket ticket){
        while(ticketQueue.size() >= maximumNoOfTickets){
            try{
                wait(); //this method stops the execution of the particular thread
                // that is running until the wait is interrupted by notifyAll()
            } catch (InterruptedException e){
                e.printStackTrace();// prints the exact location of the error that makes it easier to debug
                throw new RuntimeException(e.getMessage());
            }
        }
        //once a spot or more is open in the ticket queue, tickets can be added until it becomes full again
        ticketQueue.add(ticket);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + "added a " + ticket.getType() +" ticket to the pool");
        System.out.println("Current size of the ticketpool : " + ticketQueue.size());

    }
// the customer will call this method to purchase a ticket if the ticket pool is not full
    //this method takes no arguments and returns a ticket
    public synchronized Ticket buyTicket() {
        while(ticketQueue.isEmpty()){
            try {
                wait();//the customer will have to wait if the queue is empty
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketQueue.poll();//this method will retrieve the head ticket of the queue
        notifyAll();//notifies the waiting threads
        System.out.println(Thread.currentThread().getName() + "purchased a " + ticket.getTicketId() + "ticket");
        System.out.println("Current size of the ticketpool : " + ticketQueue.size());
        return ticket;
    }
}
