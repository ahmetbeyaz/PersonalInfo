package com.personalinfo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDto {

    String name;
    String surname;
    String email;
    String phoneNumber;


}
