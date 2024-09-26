package com.example.Agri.Controller;


import com.example.Agri.Dto.FarmerDto;
import com.example.Agri.Dto.LoginRequest;
import com.example.Agri.Dto.UserDto;
import com.example.Agri.Exception.FarmerException;
import com.example.Agri.Service.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("/login/")
    public ResponseEntity<FarmerDto> farmerLogin(@RequestBody LoginRequest loginRequest) {
        try {
            FarmerDto farmerDto = farmerService.farmerLogin(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(farmerDto);
        } catch (FarmerException.InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PostMapping("/createFarmer/")
    public FarmerDto createFarmer(@RequestBody  FarmerDto farmerDto){
        return farmerService.createFarmer(farmerDto);
    }

    @PostMapping("/deleteFarmer")
    public FarmerDto DeleteFarmer(@RequestParam  UUID id){
        return farmerService.DeleteFarmer(id);
    }

    @GetMapping("/AllFarmer")
    public List<FarmerDto> getallFarmer(){
        return farmerService.getAllFarmer();
    }


    @GetMapping("/getuser")
    public UserDto getFarmerByUsername(@RequestParam String username){
        return farmerService.getFarmerByUsername(username);
    }
}
