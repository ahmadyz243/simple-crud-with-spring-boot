package com.yazdi.practicetwo.service;



import com.yazdi.practicetwo.domain.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    void updateAddress(Address address);
    void deleteAddressById(long addressId);

    List<Address> getAll();


}