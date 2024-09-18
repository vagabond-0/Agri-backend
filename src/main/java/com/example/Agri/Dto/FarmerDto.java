package com.example.Agri.Dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String FarmerFirstName;
    public String FarmerLastName;
    private String Username;
    private String Password;
}
