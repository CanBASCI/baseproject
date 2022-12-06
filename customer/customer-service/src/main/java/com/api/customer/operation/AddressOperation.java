package com.api.customer.operation;

import com.api.customer.data.AddressRepository;
import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.dto.address.AddressDto;
import com.api.customer.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressOperation {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    AddressRepository addressRepository;

    public AddressDto getAddressById(UUID uuid) throws Exception{
        AddressEntity addressEntity = addressRepository.findById(uuid).orElseThrow(() -> new Exception("can not find address"));
        return addressMapper.toDto(addressEntity);
    }

}
