package com.sarah.tickettingsystem.ticketBookingSystem.backend.entity;

import jakarta.persistence.*; // imports all the features included in this package

@Entity
@Table(name = "Vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_vendor")
    private String nameOfVendor;

    @Column(name = "contact_details")
    private String contactDetails;

    /*
     * Many vendors can be associated with one instance of the ticket pool.
     * This is a many-to-one relationship.
     */
    @ManyToOne
    @JoinColumn(name = "ticket_pool_id", nullable = false)
    TicketPool ticketPool;

    // Empty constructor
    public Vendor() {}

    // Constructor with name and contact details
    public Vendor(String nameOfVendor, String contactDetails) {
        this.nameOfVendor = nameOfVendor;
        this.contactDetails = contactDetails;
    }

    // Constructor with name, contact details, and ticket pool
    public Vendor(String nameOfVendor, String contactDetails, TicketPool ticketPool) {
        this.nameOfVendor = nameOfVendor;
        this.contactDetails = contactDetails;
        this.ticketPool = ticketPool;
    }

    public String getNameOfVendor() {
        return nameOfVendor;
    }

    public void setNameOfVendor(String nameOfVendor) {
        this.nameOfVendor = nameOfVendor;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    // A missing setter to limit control over the id, giving it only read-only access
    public int getId() {
        return id;
    }
}
