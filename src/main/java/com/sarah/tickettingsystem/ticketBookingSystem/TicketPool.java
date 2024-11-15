package com.sarah.tickettingsystem.ticketBookingSystem;
import java.lang.Exception;
public class TicketPool {
    private int noOfTickets;

    public TicketPool(int noOfTickets){
        this.noOfTickets = noOfTickets;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public void addTicket(int number){
        try{
            noOfTickets += number;
            System.out.println(number + " tickets added successfully");
        } catch (Exception e){
            System.out.println("an error has occured while adding the ticket - " + e);
        }
    }
}
