package com.yazdi.practicetwo.specification;

import com.yazdi.practicetwo.domain.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecifications {

    public static Specification<Person> hasFirstname(String firstName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Person> hasLastname(String lastName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<Person> hasBirthday(String birthDate) {
        return (root, query, cb) -> cb.equal(root.get("birthDate"), birthDate);
    }

}
