package com.example.Agri.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Crop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "crop_name", nullable = false)
    private String cropName;

    @Column(name = "weather_start", nullable = false)
    private float weatherStart;

    @Column(name = "weather_end", nullable = false)
    private float weatherEnd;

    @Column(name = "humidity_start", nullable = false)
    private float humidityStart;

    @Column(name = "humidity_end", nullable = false)
    private float humidityEnd;

    @Column(name = "suitable_month_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date suitableMonthStart;

    @Column(name = "suitable_month_end", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date suitableMonthEnd;

    @Column(name = "market_price", nullable = false)
    private long marketPrice;

    @Column(name = "soil_type", nullable = false)
    private String soilType;

    @Column(name = "soil_ph", nullable = false)
    private float soilPh;

    @Column(name = "soil_moisture", nullable = false)
    private float soilMoisture;
}
