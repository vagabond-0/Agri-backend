package com.example.Agri.Dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String cropName;
    public int TimeRequiredForHarvest;
    public float weatherStart;
    public float weatherEnd;
    public float humidityStart;
    public float humidityEnd;
    @Temporal(TemporalType.DATE)
    public Date suitableMonthStart;
    @Temporal(TemporalType.DATE)
    public Date suitableMonthEnd;
    public long marketPrice;
    public String soilType;
    public float soilPh;
    public float soilMoisture;
}
