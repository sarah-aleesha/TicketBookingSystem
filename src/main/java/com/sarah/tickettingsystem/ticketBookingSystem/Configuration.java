package com.sarah.tickettingsystem.ticketBookingSystem;

public class Configuration {
    private int totalTicketsCreated;
    private final int maximumTicketCapacity;
    private final int ticketReleaseRate;
    private final int customerRetievalRate;// the keyword final makes the variable a constant. therefore the value cannot be altered by anyone (ti maintain data integrity)

    public Configuration(int maximumTicketCapacity, int ticketReleaseRate, int customerRetievalRate, int totalTicketsCreated) {
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetievalRate = customerRetievalRate;
        this.totalTicketsCreated = totalTicketsCreated;
    }

    public int getTotalTicketsCreated() {
        return totalTicketsCreated;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetievalRate() {
        return customerRetievalRate;
    }
}
