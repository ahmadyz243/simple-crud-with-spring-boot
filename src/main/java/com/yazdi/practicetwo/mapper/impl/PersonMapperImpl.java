package com.yazdi.practicetwo.mapper.impl;

import com.yazdi.practicetwo.domain.Person;
import com.yazdi.practicetwo.dto.request.PersonDtoRequest;
import com.yazdi.practicetwo.dto.response.PersonDtoResponse;
import com.yazdi.practicetwo.mapper.AddressMapper;
import com.yazdi.practicetwo.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class PersonMapperImpl implements PersonMapper {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final AddressMapper addressMapper;

    @Override
    public Person personDtoRequestToPerson(PersonDtoRequest personDtoRequest) throws ParseException {

        Person person = new Person();
        if(personDtoRequest.getId() > 0){
            person.setId(personDtoRequest.getId());
        }

        BeanUtils.copyProperties(personDtoRequest, person);

        person.setBirthDate(dateFormat.parse(personDtoRequest.getBirthDate()));

        if(person.getAddressList() == null) person.setAddressList(new ArrayList<>());

        personDtoRequest.getAddressList().forEach(
                addressDtoRequest -> {
                    person.getAddressList().add(addressMapper.addressDtoRequestToAddress(addressDtoRequest));
                }
        );

        return person;
    }

    @Override
    public PersonDtoResponse personToPersonDtoResponse(Person person) {
        PersonDtoResponse personDtoResponse = new PersonDtoResponse();
        if(person.getId() > 0){
            personDtoResponse.setId(person.getId());
        }
        BeanUtils.copyProperties(person, personDtoResponse);
        person.getAddressList().forEach(address -> {
            personDtoResponse.getAddressList().add(addressMapper.addressToAddressDtoResponse(address));
        });
        return personDtoResponse;
    }

}
