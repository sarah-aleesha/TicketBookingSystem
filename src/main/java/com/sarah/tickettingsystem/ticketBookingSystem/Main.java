package com.sarah.tickettingsystem.ticketBookingSystem;

public class Main {
    public static void main(String[] args) {
        TicketPool ticketPool = new TicketPool(5);
        for (int i = 1; i <= ticketPool.getMaximumNoOfTickets() ; i++) {
            Vendor vendor = new Vendor(ticketPool, ticketPool.getMaximumNoOfTickets(), 3);
            Thread seller = new Thread(vendor,"vendor: " + i);
            seller.start();//this invokes the run method in the Vendor class

        }

        for (int i = 1; i <= ticketPool.getMaximumNoOfTickets() ; i++) {
            Customer customer = new Customer(3, 3, ticketPool);
            Thread buyer = new Thread(customer,"customer: " + i);
            buyer.start();//this invokes the run method in the Customer class
        }


    }
}
