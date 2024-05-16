package com.personalinfo.controller;

import com.personalinfo.dto.CreatePersonalRequest;
import com.personalinfo.dto.PersonalDto;
import com.personalinfo.dto.UpdatePersonalRequest;
import com.personalinfo.service.PersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/personal")
public class PersonalController {

  private  final   PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }



    @PostMapping
    public  ResponseEntity<PersonalDto> createPersonal(@RequestBody CreatePersonalRequest createPersonalRequest) {

        return  ResponseEntity.ok(personalService.createPersonal(createPersonalRequest));
    }

    @GetMapping
    public  ResponseEntity<List<PersonalDto>> getAllPersonals() {

        return ResponseEntity.ok(personalService.getAllPersonals());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PersonalDto> getPersonalById(@PathVariable Long id) {

        return ResponseEntity.ok(personalService.getPersonalById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalById(@PathVariable Long id) {

        personalService.deletePersonalById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<PersonalDto> updatePersonal(@RequestBody UpdatePersonalRequest updateCustomerRequest, @PathVariable Long id) {
        return  ResponseEntity.ok(personalService.updatePersonal(updateCustomerRequest,id));
    }
}
