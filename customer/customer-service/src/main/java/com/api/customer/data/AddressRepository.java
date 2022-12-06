package com.api.customer.data;

import com.api.customer.data.entity.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findAll();

    Optional<AddressEntity> findById(UUID uuid);
}

