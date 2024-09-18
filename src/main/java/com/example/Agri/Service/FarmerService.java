package com.example.Agri.Service;


import com.example.Agri.Dto.FarmerDto;
import com.example.Agri.Entity.FarmerEntity;
import com.example.Agri.Repository.FarmerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FarmerService {
    final ModelMapper modelMapper;
    final FarmerRepository farmerRepository;

    @Autowired
    public FarmerService(ModelMapper modelMapper, FarmerRepository farmerRepository) {
        this.modelMapper = modelMapper;
        this.farmerRepository = farmerRepository;
    }

    public FarmerDto FarmerLogin(String username,String Password){
        FarmerEntity farmerEntity = farmerRepository.findByUsernameAndPassword(username,Password);

        if(farmerEntity == null){
            throw new RuntimeException("Invalid username or password");
        }

        return modelMapper.map(farmerEntity,FarmerDto.class);
    }
    public FarmerDto CreateFarmer(FarmerDto farmerDto){
        FarmerEntity farmerEntity = modelMapper.map(farmerDto,FarmerEntity.class);
        FarmerEntity savedEntity = farmerRepository.save(farmerEntity);
        return  modelMapper.map(savedEntity,FarmerDto.class);
    }

    public FarmerDto DeleteFarmer(UUID id){
        Optional<FarmerEntity> optionalFarmerEntity = farmerRepository.findById(id);
        if (optionalFarmerEntity.isPresent()) {
            FarmerEntity farmerEntity = optionalFarmerEntity.get();
            farmerRepository.delete(farmerEntity);
            return modelMapper.map(farmerEntity, FarmerDto.class);
        } else {
            throw new RuntimeException("Invalid Id");
        }
    }

    public List<FarmerDto> getAllFarmer(){
        List<FarmerEntity> farmerEntities = farmerRepository.findAll();
        return farmerEntities.stream()
                .map(farmerEntity -> modelMapper.map(farmerEntity, FarmerDto.class))
                .collect(Collectors.toList());
    }
}