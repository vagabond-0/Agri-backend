package com.example.Agri.Service;


import com.example.Agri.Dto.CropDto;
import com.example.Agri.Entity.CropEntity;
import com.example.Agri.Repository.CropRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CropService {
    final ModelMapper modelMapper;
    final CropRepository cropRepository;

    public CropService(ModelMapper modelMapper, CropRepository cropRepository) {
        this.modelMapper = modelMapper;
        this.cropRepository = cropRepository;
    }

    public List<CropDto> GetAllCrop(){
        List<CropEntity> cropEntities = cropRepository.findAll();
        return cropEntities.stream()
                .map(cropEntity -> modelMapper.map(cropEntity,CropDto.class))
                .collect(Collectors.toList());
    }

    public List<CropDto> getCropByWeatherAndMonth(float weather, Date month) {
        List<CropEntity> cropEntities = cropRepository.findCropsByWeatherAndMonth(weather, month);
        return cropEntities.stream()
                .map(cropEntity -> modelMapper.map(cropEntity, CropDto.class))
                .collect(Collectors.toList());
    }


    public CropDto getCropById(String id) {
        UUID id1 = UUID.fromString(id);
        return cropRepository.findById(id1)
                .map(cropEntity -> modelMapper.map(cropEntity, CropDto.class)) // Use ModelMapper for conversion
                .orElse(null); // Return null if not found
    }
}
