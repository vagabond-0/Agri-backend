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
    private UUID id;

    private FarmerEntity farmer;

    private CropEntity crop;

    @Column(name = "registered_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registeredMonth;

    private long timeLeftToHarvest;

    // Constructor to calculate timeLeftToHarvest based on registeredMonth and crop's harvestTime
    public RegistrationDto(UUID id, FarmerEntity farmer, CropEntity crop, Date registeredMonth) {
        this.id = id;
        this.farmer = farmer;
        this.crop = crop;
        this.registeredMonth = registeredMonth;
        this.timeLeftToHarvest = calculateTimeLeftToHarvest();
    }

    private long calculateTimeLeftToHarvest() {
        if (crop != null && registeredMonth != null) {
            // Calculate the total days to harvest from the registered month
            long totalHarvestTimeInMillis = crop.getHarvestTime() * 24 * 60 * 60 * 1000; // Convert days to milliseconds
            long harvestDateInMillis = registeredMonth.getTime() + totalHarvestTimeInMillis;
            long currentTimeInMillis = new Date().getTime();

            // Calculate time left to harvest
            return (harvestDateInMillis - currentTimeInMillis) / (24 * 60 * 60 * 1000); // Convert milliseconds to days
        }
        return -1; // Indicates that the calculation cannot be performed
    }
}
