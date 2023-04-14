package com.example.democarcrud.Respository;

import com.example.democarcrud.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    List<Car> findByMatricule(String matricule);
    void deleteById(Long id);
}
