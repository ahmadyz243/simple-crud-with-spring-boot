package com.yazdi.practicetwo.mapper.impl;

import com.yazdi.practicetwo.domain.Address;
import com.yazdi.practicetwo.dto.request.AddressDtoRequest;
import com.yazdi.practicetwo.dto.response.AddressDtoResponse;
import com.yazdi.practicetwo.mapper.AddressMapper;
import com.yazdi.practicetwo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapperImpl implements AddressMapper {

    private final PersonService personService;

    @Override
    public AddressDtoResponse addressToAddressDtoResponse(Address address) {
        AddressDtoResponse dtoResponse = new AddressDtoResponse();
        if(address.getId() > 0) dtoResponse.setId(address.getId());
        BeanUtils.copyProperties(address, dtoResponse);

        if(address.getPerson() != null){
            dtoResponse.setPersonId(address.getPerson().getId());
        }

        return dtoResponse;
    }

    @Override
    public Address addressDtoRequestToAddress(AddressDtoRequest addressDtoRequest) {
        Address address = new Address();
        if(addressDtoRequest.getId() > 0) address.setId(addressDtoRequest.getId());

        BeanUtils.copyProperties(addressDtoRequest, address);

        if(addressDtoRequest.getPersonId() > 0){
            address.setPerson(
                    personService.findById(addressDtoRequest.getPersonId())
            );
        }

        return address;
    }

}