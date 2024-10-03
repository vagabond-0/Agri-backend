package com.example.Agri.Controller;


import com.example.Agri.Dto.RegisterRequestDto;
import com.example.Agri.Dto.RegistrationDto;
import com.example.Agri.Service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
