package com.api.customer.operation;

import com.api.customer.data.AddressRepository;
import com.api.customer.data.CustomerRepository;
import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.data.entity.address.DistrictEntity;
import com.api.customer.data.entity.address.DistrictRepository;
import com.api.customer.dto.address.AddressCreateDto;
import com.api.customer.dto.address.AddressDto;
import com.api.customer.data.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressOperation {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    CustomerRepository customerRepository;


    public AddressDto getAddressById(UUID uuid) throws Exception{
        AddressEntity addressEntity = addressRepository.findById(uuid).orElseThrow(() -> new Exception("can not find address"));
        return addressMapper.toDto(addressEntity);
    }

    public AddressDto save(AddressCreateDto addressCreateDto) throws Exception {
        DistrictEntity districtEntity = districtRepository.findById(addressCreateDto.getDistrictId()).orElseThrow(() -> new Exception("can not find district"));
        CustomerEntity customerEntity = customerRepository.findById(addressCreateDto.getCustomerId()).orElseThrow(() -> new Exception("can not find customer"));
        AddressEntity addressEntity = addressMapper.toEntity(addressCreateDto);
        addressEntity.setDistrict(districtEntity);
        addressEntity.setCustomer(customerEntity);
        return addressMapper.toDto(addressRepository.save(addressEntity));
    }
}
