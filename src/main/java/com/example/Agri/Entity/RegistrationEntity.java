package com.example.Agri.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "Registration")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private FarmerEntity farmer;

    @ManyToOne
    @JoinColumn(name = "crop_id", referencedColumnName = "id")
    private CropEntity crop;

    @Column(name = "registered_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registeredMonth;

    @Transient
    private long timeLeftToHarvest;

    public long calculateTimeLeftToHarvest() {
        if (crop != null && registeredMonth != null) {
            // Calculate the total days to harvest from the registered month
            long totalHarvestTimeInMillis = crop.getHarvestTime() * 24 * 60 * 60 * 1000; // Convert days to milliseconds
            long harvestDateInMillis = registeredMonth.getTime() + totalHarvestTimeInMillis;
            long currentTimeInMillis = new Date().getTime();

            // Calculate time left to harvest
            timeLeftToHarvest = (harvestDateInMillis - currentTimeInMillis) / (24 * 60 * 60 * 1000); // Convert milliseconds to days
        } else {
            timeLeftToHarvest = -1; // Indicates that the calculation cannot be performed
        }
        return timeLeftToHarvest;
    }
}
