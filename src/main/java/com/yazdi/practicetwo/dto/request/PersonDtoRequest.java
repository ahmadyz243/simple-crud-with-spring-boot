package com.yazdi.practicetwo.dto.request;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDtoRequest {

    private long id;
    private String firstName;
    private String lastname;
    private String birthDate;
    private List<AddressDtoRequest> addressList;

}
