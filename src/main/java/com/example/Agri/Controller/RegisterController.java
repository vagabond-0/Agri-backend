package com.example.Agri.Controller;


import com.example.Agri.Dto.CropDto;
import com.example.Agri.Dto.RegisterRequestDto;
import com.example.Agri.Dto.RegistrationDto;
import com.example.Agri.Service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<RegistrationDto> registerCrop(@RequestBody RegisterRequestDto registerRequestDto) {

        RegistrationDto registeredCrop = registerService.registerCrop(
                registerRequestDto.getFarmerId(),
                registerRequestDto.getCropId(),
                registerRequestDto.getRegisteredMonth()
        );

        return ResponseEntity.ok(registeredCrop);
    }

    @GetMapping("/getUserCrop")
    public ResponseEntity<List<CropDto>> getUserCrops(@RequestParam("userId") String userId) {
        UUID farmerId = UUID.fromString(userId);
        List<CropDto> userCrops = registerService.getAllRegisteredCrops(farmerId);
        return ResponseEntity.ok(userCrops);
    }
}
