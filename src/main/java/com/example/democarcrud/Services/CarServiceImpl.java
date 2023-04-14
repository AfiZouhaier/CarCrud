package com.example.democarcrud.Services;


import com.example.democarcrud.Entities.Car;
import com.example.democarcrud.Respository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public HttpStatus CreateCar(Car c) {
        List<Car> returnedCarSearchByMatricule = carRepository.findByMatricule(c.getMatricule());
        if(!returnedCarSearchByMatricule.isEmpty()){
            return HttpStatus.ALREADY_REPORTED;
        }
        carRepository.save(c);
        return HttpStatus.ACCEPTED;
    }
    @Override
    public Optional<Car> ReadCar(Long id){
        return carRepository.findById(id);
    }
    @Override
    public List<Car> ReadCars() {
        return carRepository.findAll();
    }

    @Override
    public HttpStatus UpdateCar(Long id, Car car) {
        return carRepository.findById(id).map(c->{
            List<Car> returnedCarSearchByMatricule = carRepository.findByMatricule(car.getMatricule());
            if(!returnedCarSearchByMatricule.isEmpty()){
                System.out.println(returnedCarSearchByMatricule);
                if(returnedCarSearchByMatricule.get(0).getMatricule()== c.getMatricule()){
                    c.setColor(car.getColor());
                    c.setType(car.getType());
                    c.setMatricule(car.getMatricule());
                    carRepository.save(c);
                    return HttpStatus.ACCEPTED;
                }
                return HttpStatus.ALREADY_REPORTED;
            }else {
            c.setColor(car.getColor());
            c.setType(car.getType());
            c.setMatricule(car.getMatricule());
            carRepository.save(c);
            return HttpStatus.ACCEPTED;}
        }).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public HttpStatus DeleteCar(Long id) {
        carRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
