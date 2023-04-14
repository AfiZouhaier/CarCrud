package com.example.democarcrud.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String matricule;
    private String color;
    private boolean is_rented=false;

    public Car(Long id, String type, String matricule, String color) {
        this.id = id;
        this.type = type;
        this.matricule = matricule;
        this.color = color;
        this.is_rented = false;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean is_rented() {
        return is_rented;
    }

    public void setRented(boolean rented) {
        is_rented = rented;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", matricule='" + matricule + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
