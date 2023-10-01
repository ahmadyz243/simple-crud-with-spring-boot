package com.yazdi.practicetwo.repository;


import com.yazdi.practicetwo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsById(long id);

}
