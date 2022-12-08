package com.api.customer.operation;

import com.api.customer.data.entity.phone.PhoneCodeRepository;
import com.api.customer.dto.address.PhoneCodeDto;
import com.api.customer.data.mapper.PhoneCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneOperation {
    @Autowired
    PhoneCodeMapper phoneCodeMapper;
    @Autowired
    PhoneCodeRepository phoneCodeRepository;

    public List<PhoneCodeDto> getPhoneCodes(){
        return phoneCodeMapper.toDtos(phoneCodeRepository.findAll());
    }
}
