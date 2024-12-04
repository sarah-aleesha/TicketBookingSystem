package com.sarah.tickettingsystem.ticketBookingSystem;

public class Main {
    public static void main(String[] args) {
        TicketPool ticketPool = new TicketPool(10);
        for (int i = 1; i <= ticketPool.getMaximumNoOfTickets() ; i++) {
            Thread seller = new Thread("vendor" + i);
            Vendor vendor = new Vendor(ticketPool.getMaximumNoOfTickets(), 4);
        }


    }
}
