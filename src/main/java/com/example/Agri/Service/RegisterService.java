package com.example.Agri.Service;

import com.example.Agri.Dto.CropDto;
import com.example.Agri.Dto.cropdto;
import com.example.Agri.Dto.RegistrationDto;
import com.example.Agri.Entity.CropEntity;
import com.example.Agri.Entity.FarmerEntity;
import com.example.Agri.Entity.RegistrationEntity;
import com.example.Agri.Repository.CropRepository;
import com.example.Agri.Repository.FarmerRepository;
import com.example.Agri.Repository.RegisterationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class RegisterService {

    private final ModelMapper modelMapper;
    private final RegisterationRepository registerationRepository;
    private final FarmerRepository farmerRepository;
    private final CropRepository cropRepository;
    public RegisterService(ModelMapper modelMapper, RegisterationRepository registerationRepository, FarmerRepository farmerRepository, CropRepository cropRepository) {
        this.modelMapper = modelMapper;
        this.registerationRepository = registerationRepository;
        this.farmerRepository = farmerRepository;
        this.cropRepository = cropRepository;
    }

    public RegistrationDto registerCrop(UUID farmerId, UUID cropId, Date registeredMonth) {

        Optional<FarmerEntity> farmer = farmerRepository.findById(farmerId);
        if (!farmer.isPresent()) {
            throw new IllegalArgumentException("Farmer not found with ID: " + farmerId);
        }

        Optional<CropEntity> crop = cropRepository.findById(cropId);
        if (!crop.isPresent()) {
            throw new IllegalArgumentException("Crop not found with ID: " + cropId);
        }

        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setFarmer(farmer.get());
        registrationEntity.setCrop(crop.get());
        registrationEntity.setRegisteredMonth(registeredMonth);

        registerationRepository.save(registrationEntity);

        return modelMapper.map(registrationEntity, RegistrationDto.class);
    }
    public List<cropdto> getAllRegisteredCrops(UUID farmerId) {
        // Fetch all registrations for the given farmer ID
        List<RegistrationEntity> registrations = registerationRepository.findByFarmerId(farmerId);

        // Map RegistrationEntity to CropDto
        return registrations.stream()
                .map(registration -> {
                    cropdto cropDto = modelMapper.map(registration.getCrop(), cropdto.class);
                    cropDto.setDaysRemaining(registration.getTimeLeftToHarvest());
                    return cropDto;
                })
                .collect(Collectors.toList());
    }


}
