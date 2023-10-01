package com.yazdi.practicetwo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastname;
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Address> addressList;

}
