package com.personalinfo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasePersonalRequest {

    String name;
    String surname;
    String email;
    String phoneNumber;
}
