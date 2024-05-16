package com.personalinfo.dto;

import com.personalinfo.model.Personal;
import org.springframework.stereotype.Component;



@Component
public class PersonalDtoConverter {

    public PersonalDto convert(Personal personal) {
        return  PersonalDto.builder()
                .name(personal.getName())
                .surname(personal.getSurname())
                .email(personal.getEmail())
                .phoneNumber(personal.getPhoneNumber())
                .build();

    }

}
