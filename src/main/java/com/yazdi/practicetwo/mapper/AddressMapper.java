package com.yazdi.practicetwo.mapper;

import com.yazdi.practicetwo.domain.Address;
import com.yazdi.practicetwo.dto.request.AddressDtoRequest;
import com.yazdi.practicetwo.dto.response.AddressDtoResponse;

public interface AddressMapper {

    AddressDtoResponse addressToAddressDtoResponse(Address address);
    Address addressDtoRequestToAddress(AddressDtoRequest addressDtoRequest);

}
