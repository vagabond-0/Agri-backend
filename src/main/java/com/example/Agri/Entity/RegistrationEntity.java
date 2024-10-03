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
}
