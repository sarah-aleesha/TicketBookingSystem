package com.sarah.tickettingsystem.ticketBookingSystem.backend.repository;

import com.sarah.tickettingsystem.ticketBookingSystem.backend.entity.TicketPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketPool, Integer> {
}
