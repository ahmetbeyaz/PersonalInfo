package com.personalinfo.service.impl;

import com.personalinfo.dto.CreatePersonalRequest;
import com.personalinfo.dto.PersonalDto;
import com.personalinfo.dto.PersonalDtoConverter;
import com.personalinfo.dto.UpdatePersonalRequest;
import com.personalinfo.model.Personal;
import com.personalinfo.repository.PersonalRepository;
import com.personalinfo.service.PersonalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;

    private final PersonalDtoConverter personalDtoConverter;

    public PersonalServiceImpl(PersonalRepository personalRepository, PersonalDtoConverter personalDtoConverter) {
        this.personalRepository = personalRepository;
        this.personalDtoConverter = personalDtoConverter;
    }

    @Override
    public PersonalDto createPersonal(CreatePersonalRequest createPersonalRequest) {

        Personal personal=new Personal();
        personal.setName(createPersonalRequest.getName());
        personal.setEmail(createPersonalRequest.getEmail());
        personal.setSurname(createPersonalRequest.getSurname());
        personal.setPhoneNumber(createPersonalRequest.getPhoneNumber());

        personalRepository.save(personal);


        return PersonalDto.builder()
                .name(personal.getName())
                .surname(personal.getSurname())
                .email(personal.getEmail())
                .phoneNumber(personal.getPhoneNumber())
                .build();
    }

    @Override
    public List<PersonalDto> getAllPersonals() {
        List<Personal> personalList=personalRepository.findAll();

        List<PersonalDto> personalDtoList = new ArrayList<>();


        for(Personal personal:personalList){
            personalDtoList.add(personalDtoConverter.convert(personal));
        }

        return personalDtoList;
    }

    @Override
    public PersonalDto getPersonalById(Long id) {

      Optional<Personal> personal=personalRepository.findById(id);
      return personal.map(personalDtoConverter::convert).orElse(new PersonalDto());

    }

    @Override
    public void deletePersonalById( Long id) {

        personalRepository.deleteById(id);

    }

    @Override
    public PersonalDto updatePersonal(UpdatePersonalRequest updatePersonalRequest, Long id) {
        Optional<Personal> personalOptional=personalRepository.findById(id);

        personalOptional.ifPresent(personal -> {
            personal.setName(updatePersonalRequest.getName());
            personal.setSurname(updatePersonalRequest.getSurname());
            personal.setEmail(updatePersonalRequest.getEmail());
            personal.setPhoneNumber(updatePersonalRequest.getPhoneNumber());
            personalRepository.save(personal);
        });

       return  personalOptional.map(personalDtoConverter::convert).orElse(new PersonalDto());



    }

}
