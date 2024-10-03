package com.example.Agri.Dto;


import com.example.Agri.Entity.CropEntity;
import com.example.Agri.Entity.FarmerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public FarmerEntity farmer;
    public CropEntity crop;
    @Column(name = "Registered Month", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date registeredMonth;
}
