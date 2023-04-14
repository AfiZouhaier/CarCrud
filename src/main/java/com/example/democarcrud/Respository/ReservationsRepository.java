package com.example.democarcrud.Respository;

import com.example.democarcrud.Entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    List<Reservations> ReservationsList = new ArrayList<>();
}
