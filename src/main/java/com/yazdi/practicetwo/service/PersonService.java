package com.yazdi.practicetwo.service;

import com.yazdi.practicetwo.domain.Person;
import com.yazdi.practicetwo.dto.request.PersonDtoRequest;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(long personId);

    List<Person> getAll();
    List<Person> search(PersonDtoRequest dtoRequest);
    Person findById(long personId);
    boolean existsById(long personId);

}
