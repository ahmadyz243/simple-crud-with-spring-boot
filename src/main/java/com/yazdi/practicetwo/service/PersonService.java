package com.yazdi.practicetwo.service;



import com.yazdi.practicetwo.domain.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(long personId);

    List<Person> getAll();
    Person findById(long personId);
    boolean existsById(long personId);

}
