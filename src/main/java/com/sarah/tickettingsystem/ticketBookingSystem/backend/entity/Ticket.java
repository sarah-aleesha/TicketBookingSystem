package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;


import jakarta.persistence.*;//imports all the features included in this package


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
    /*
    * many instances of tickets will be linked to one instance of the ticket pool
    * */
    @ManyToOne
    @JoinColumn(name = "ticket_pool_id", nullable = false)
    TicketPool ticketPool;
    //empty constructor
    public Ticket(){}
    public Ticket(String nameOfEvent,Double price){
        this.nameOfEvent = nameOfEvent;
        this.price = price;
    }
    public Ticket(String nameOfEvent, Double price, TicketPool ticketPool) {
        this.nameOfEvent = nameOfEvent;
        this.price = price;
        this.ticketPool = ticketPool;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
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
