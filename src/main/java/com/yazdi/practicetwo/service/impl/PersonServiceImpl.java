package com.yazdi.practicetwo.service.impl;

import com.yazdi.practicetwo.domain.Address;
import com.yazdi.practicetwo.domain.Person;
import com.yazdi.practicetwo.exceptions.PersonNotExistsException;
import com.yazdi.practicetwo.repository.PersonRepository;
import com.yazdi.practicetwo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public Person savePerson(Person person) {
        List<Address> addresses = person.getAddressList();
        person = repository.save(person);
        Person finalPerson = person;
        addresses.forEach(address -> {
            address.setPerson(finalPerson);
        });
        person.setAddressList(addresses);
        return repository.save(person);
    }

    @Override
    public void updatePerson(Person person) throws PersonNotExistsException{
        if (person.getId() > 0 && repository.existsById(person.getId())){
            repository.save(person);
        }else {
            throw new PersonNotExistsException();
        }
    }

    @Override
    public void deletePersonById(long personId) throws PersonNotExistsException{
        if(personId > 0 && repository.existsById(personId)){
            repository.deleteById(personId);
        }else{
            throw new PersonNotExistsException();
        }
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person findById(long personId) {
        return repository.findById(personId).orElse(null);
    }

    @Override
    public boolean existsById(long personId) {
        return repository.existsById(personId);
    }
}
