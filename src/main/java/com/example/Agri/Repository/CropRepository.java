package com.example.Agri.Repository;

import com.example.Agri.Entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CropRepository extends JpaRepository<CropEntity, UUID> {
}
