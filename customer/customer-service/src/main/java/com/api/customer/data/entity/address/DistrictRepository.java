package com.api.customer.data.entity.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {
    List<DistrictEntity> findAll();

    Optional<DistrictEntity> findById(UUID uuid);
}
