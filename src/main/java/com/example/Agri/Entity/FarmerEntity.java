package com.example.Agri.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Farmer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "farmer_first_name")
    private String farmerFirstName;

    @Column(name = "farmer_last_name")
    private String farmerLastName;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
}
