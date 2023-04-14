package com.example.democarcrud.Services;

import com.example.democarcrud.Entities.Reservations;
import com.example.democarcrud.Respository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsServiceImpl implements ReservationsService{
    @Autowired
    private ReservationsRepository reservationsRepository;
    @Override
    public List<Reservations> getAll() {
        return reservationsRepository.findAll();
    }

    @Override
    public HttpStatus createReservation(Reservations reservation) {
        reservationsRepository.save(reservation);
        return HttpStatus.OK;
    }

    @Override
    public Reservations updateReservation(Long carId, Long userId, Reservations reservation) {
        return null;
    }

    @Override
    public HttpStatus DeleteReservation(Long carId, Long userId) {
        return null;
    }
}
