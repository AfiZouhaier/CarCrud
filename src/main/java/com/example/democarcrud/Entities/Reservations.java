package com.example.democarcrud.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String carId;

    private String userId;
    private Date TakeDate=new Date(20230326);
    private Date ReturnDate = new Date(20230328);
    private boolean isAccepted = false;
}
