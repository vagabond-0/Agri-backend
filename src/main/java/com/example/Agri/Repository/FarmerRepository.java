package com.example.Agri.Repository;


import com.example.Agri.Entity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerEntity, UUID> {
    FarmerEntity findByUsernameAndPassword(String username, String password);
}
