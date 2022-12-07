package com.api.customer.data.entity.phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhoneCodeRepository extends JpaRepository<PhoneCodeEntity, UUID> {
    List<PhoneCodeEntity> findAll();
}
