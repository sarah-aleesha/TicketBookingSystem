package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;


import jakarta.persistence.Entity;

@Entity
public class Ticket {
    private int id;
    private String location;
    private String nameOfEvent;
    private Double price;
}
