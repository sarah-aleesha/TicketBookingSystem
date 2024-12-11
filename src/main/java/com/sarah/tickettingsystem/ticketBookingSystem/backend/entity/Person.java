package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import com.sarah.tickettingsystem.ticketBookingSystem.CLI.TicketPool;
import jakarta.persistence.Entity;

@Entity
public class Person {
    private int id;
    private TicketPool ticketPool;
}
