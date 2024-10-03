package com.example.Agri.Dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
public class RegisterRequestDto {
    public  UUID farmerId;
    public UUID cropId;
    public Date registeredMonth;
}
