package com.example.Agri.Repository;

import com.example.Agri.Entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CropRepository extends JpaRepository<CropEntity, UUID> {
    @Query("SELECT c FROM CropEntity c WHERE " +
            ":weather BETWEEN c.weatherStart AND c.weatherEnd AND " +
            ":month BETWEEN c.suitableMonthStart AND c.suitableMonthEnd")
    List<CropEntity> findCropsByWeatherAndMonth(
            @Param("weather") float weather,
            @Param("month") Date month
    );
}
