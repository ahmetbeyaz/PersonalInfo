package com.personalinfo.service;

import com.personalinfo.dto.CreatePersonalRequest;
import com.personalinfo.dto.PersonalDto;
import com.personalinfo.dto.UpdatePersonalRequest;

import java.util.List;

public interface PersonalService {
    PersonalDto createPersonal(CreatePersonalRequest createPersonalRequest);

    List<PersonalDto> getAllPersonals();

   PersonalDto getPersonalById(Long id);

    void deletePersonalById(Long id);

    PersonalDto updatePersonal(UpdatePersonalRequest updateCustomerRequest, Long id);
}
