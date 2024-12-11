package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;


import jakarta.persistence.*;//imports all the features included in this package
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_of_event")
    private String nameOfEvent;
    @Column(name = "price")
    private Double price;
    //empty constructor
    public Ticket(){}
    public Ticket(String nameOfEvent,Double price){
        this.nameOfEvent = nameOfEvent;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }
// a missing setter make limits the control over the id, giving it only the readability access
    public int getId() {
        return id;
    }
}
