package com.example.Agri.Controller;


import com.example.Agri.Dto.CropDto;
import com.example.Agri.Service.CropService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/crop")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping("/getcrop")
    public List<CropDto> getAllCrop(){
        return cropService.GetAllCrop();
    }
    @GetMapping("/suggestionByWeatherAndMonth")
    public List<CropDto> getCropByWeatherAndMonth(
            @RequestParam float weather,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date month) {
        return cropService.getCropByWeatherAndMonth(weather, month);
    }
}
