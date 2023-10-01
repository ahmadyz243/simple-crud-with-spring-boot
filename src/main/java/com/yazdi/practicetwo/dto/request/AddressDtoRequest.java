package com.yazdi.practicetwo.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressDtoRequest {

    private long id;

    @NotEmpty
    @Size(min = 2, message = "city name should have at least 2 characters")
    private String city;

    @NotEmpty
    @Size(min = 2, message = "street name should have at least 2 characters")
    private String street;

    @NotEmpty
    @Size(min = 8, max = 8, message = "postal code should have 8 digits")
    private String postalCode;

    private long personId;

}
