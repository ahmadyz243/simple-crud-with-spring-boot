package com.yazdi.practicetwo.service.impl;

import com.yazdi.practicetwo.domain.Address;
import com.yazdi.practicetwo.exceptions.AddressNotExistsException;
import com.yazdi.practicetwo.exceptions.PersonNotExistsException;
import com.yazdi.practicetwo.repository.AddressRepository;
import com.yazdi.practicetwo.service.AddressService;
import com.yazdi.practicetwo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final PersonService personService;


    @Override
    public Address saveAddress(Address address) {
        if(address.getPerson() != null){
            return repository.save(address);
        }else {
            throw new PersonNotExistsException();
        }
    }

    @Override
    public void updateAddress(Address address) {
        if(address.getId() > 0 && repository.existsById(address.getId()) && address.getPerson() != null){
            repository.save(address);
        }else if (!repository.existsById(address.getId())){
            throw new AddressNotExistsException("address was not found");
        }else if (address.getPerson() == null){
            throw new PersonNotExistsException();
        }
    }

    @Override
    public void deleteAddressById(long addressId) {
        if (repository.existsById(addressId)){
            repository.deleteById(addressId);
        }else {
            throw new AddressNotExistsException("address was not found");
        }
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

}