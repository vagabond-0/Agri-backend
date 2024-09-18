package com.example.Agri.Controller;


import com.example.Agri.Dto.FarmerDto;
import com.example.Agri.Service.FarmerService;
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
    public FarmerDto FarmerLogin(@RequestParam  String Username,@RequestParam String Password){
        return farmerService.FarmerLogin(Username,Password);
    }

    @PostMapping("/createFarmer/")
    public FarmerDto createFarmer(@RequestBody  FarmerDto farmerDto){
        return farmerService.CreateFarmer(farmerDto);
    }

    @PostMapping("/deleteFarmer")
    public FarmerDto DeleteFarmer(@RequestParam  UUID id){
        return farmerService.DeleteFarmer(id);
    }

    @GetMapping("/AllFarmer")
    public List<FarmerDto> getallFarmer(){
        return farmerService.getAllFarmer();
    }
}
