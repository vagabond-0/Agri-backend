package com.example.Agri.Repository;

import com.example.Agri.Entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegisterationRepository extends JpaRepository<RegistrationEntity, UUID> {
    List<RegistrationEntity> findByFarmerId(UUID farmerId);
}
