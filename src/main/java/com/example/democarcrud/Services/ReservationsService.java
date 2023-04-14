package com.example.democarcrud.Services;

import com.example.democarcrud.Entities.Reservations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public interface ReservationsService {
    List<Reservations> getAll();
    HttpStatus createReservation(Reservations reservation);

    Reservations updateReservation(Long carId, Long userId, Reservations reservation);

    HttpStatus DeleteReservation(Long carId, Long userId);

}
