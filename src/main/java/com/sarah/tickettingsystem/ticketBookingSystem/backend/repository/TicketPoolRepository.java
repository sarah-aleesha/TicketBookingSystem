package com.sarah.tickettingsystem.ticketBookingSystem.backend.repository;

import com.sarah.tickettingsystem.ticketBookingSystem.backend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPoolRepository extends JpaRepository<Ticket, Integer> {
    /*TicketPool is entity that will be managed and is mapped to a table in the database,
    while Integer is the type if its primary key.

    Additionally, the two interfaces extend the JpaRepository since that repository includes functional methods that
    support database operations*/
}
