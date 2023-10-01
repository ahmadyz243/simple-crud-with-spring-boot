package com.yazdi.practicetwo.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressDtoResponse {

    private long id;
    private String city;
    private String street;
    private String postalCode;
    private long personId;

}
