package com.yazdi.practicetwo.repository;

import com.yazdi.practicetwo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsById(long addressId);

}