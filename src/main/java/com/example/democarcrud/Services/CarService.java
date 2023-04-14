package com.example.democarcrud.Services;

import com.example.democarcrud.Entities.Car;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {

    HttpStatus CreateCar(Car c);
    Optional ReadCar(Long id);
    List<Car> ReadCars();
    HttpStatus UpdateCar(Long id, Car car);
    HttpStatus DeleteCar(Long id);
}
