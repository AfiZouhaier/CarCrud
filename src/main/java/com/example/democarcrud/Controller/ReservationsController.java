package com.example.democarcrud.Controller;

import com.example.democarcrud.Entities.Reservations;
import com.example.democarcrud.Services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired
    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Reservations>> getAllReservations(){

        return ResponseEntity.ok(reservationsService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<HttpStatus> addReservation(@RequestBody Reservations reservation){
        System.out.println(reservation);
        return ResponseEntity.ok(reservationsService.createReservation(reservation));
    }
}
