package com.sarah.tickettingsystem.ticketBookingSystem;
import java.lang.Exception;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private int maximumNoOfTickets;
    private Queue<Ticket> ticket;


    public TicketPool(int maximumNoOfTickets, Ticket ticket ){
        this.maximumNoOfTickets = maximumNoOfTickets;
        this.ticket = new LinkedList<Ticket>();
    }

    public int getMaximumNoOfTickets() {
        return maximumNoOfTickets;
    }

    public void setNoOfTickets(int maximumNoOfTickets) {
        this.maximumNoOfTickets = maximumNoOfTickets;
    }

    public void addTicket(int number){
        try{
            maximumNoOfTickets += number;
            System.out.println(number + " tickets added successfully");
        } catch (Exception e){
            System.out.println("an error has occured while adding the ticket - " + e);
        }
    }
}
