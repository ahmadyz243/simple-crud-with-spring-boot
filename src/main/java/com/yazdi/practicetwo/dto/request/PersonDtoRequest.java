package com.yazdi.practicetwo.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDtoRequest {

    private long id;
    @NotEmpty
    @Size(min = 3, message = "firstname should have at least 3 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 3, message = "lastname should have at least 3 characters")
    private String lastname;
    private String birthDate;
    private List<AddressDtoRequest> addressList;

}
