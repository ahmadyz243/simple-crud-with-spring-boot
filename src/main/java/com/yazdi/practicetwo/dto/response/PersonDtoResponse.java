package com.yazdi.practicetwo.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDtoResponse {

    private long id;
    private String firstName;
    private String lastname;
    private Date birthDate;
    private List<AddressDtoResponse> addressList = new ArrayList<>();

}
