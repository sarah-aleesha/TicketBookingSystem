package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import com.sarah.tickettingsystem.ticketBookingSystem.CLI.Ticket;
import jakarta.persistence.Entity;

import java.util.Queue;
@Entity
public class TicketPool {
    private static int maximumNoOfTickets;
    private static Queue<Ticket> ticketQueue;
}
