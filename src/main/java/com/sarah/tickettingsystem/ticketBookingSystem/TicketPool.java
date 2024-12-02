package com.sarah.tickettingsystem.ticketBookingSystem;
import java.lang.Exception;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private int maximumNoOfTickets;
    private Queue<Ticket> ticketQueue;


    public TicketPool(int maximumNoOfTickets, Ticket ticket ){
        this.maximumNoOfTickets = maximumNoOfTickets;
        this.ticketQueue = new LinkedList<Ticket>();
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
                // that is running until the wait is interrupted by notify() / notifyAll()
            } catch (InterruptedException e){
                e.printStackTrace();// prints the exact location of the error that makes it easier to debug
                throw new RuntimeException();
            }
        }
    }
}
