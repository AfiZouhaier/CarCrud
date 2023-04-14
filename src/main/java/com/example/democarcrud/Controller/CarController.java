package com.example.democarcrud.Controller;

import com.example.democarcrud.Entities.Car;
import com.example.democarcrud.Services.CarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("allcars" )
    public List<Car> getAll(){
        return carService.ReadCars();
    }
    @PostMapping("/addcar")
    public HttpStatus createCar(@RequestBody Car car){
        return carService.CreateCar(car);
    }
    @GetMapping("/{id}")
    public Optional<Car> deleteCard(@PathVariable("id") Long id){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        return carService.ReadCar(id);
    }
    @DeleteMapping("/deletecar/{id}")
    public HttpStatus deleteCar(@PathVariable("id") Long id){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        return carService.DeleteCar(id);
    }
    @PutMapping("/updatecar/{id}")
    public HttpStatus updateCar(@PathVariable Long id, @RequestBody Car car){
        return carService.UpdateCar(id, car);
    }

}
