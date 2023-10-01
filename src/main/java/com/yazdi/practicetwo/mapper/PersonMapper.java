package com.yazdi.practicetwo.mapper;

import com.yazdi.practicetwo.domain.Person;
import com.yazdi.practicetwo.dto.request.PersonDtoRequest;
import com.yazdi.practicetwo.dto.response.PersonDtoResponse;

import java.text.ParseException;

public interface PersonMapper {

    Person personDtoRequestToPerson(PersonDtoRequest personDtoRequest) throws ParseException;
    PersonDtoResponse personToPersonDtoResponse(Person person);

}
