package com.personsApi.personApi.controller;



import com.personsApi.personApi.dto.DtoUsernameEndResource;
import com.personsApi.personApi.dto.DtoUsernameResourcTypeResource;
import com.personsApi.personApi.entity.Person;
import com.personsApi.personApi.repository.PersonRepository;
import com.personsApi.personApi.utils.UtilsTypeResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Validated
public class ResourcesController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/getResource")
    @ResponseBody
    public String getResource(@Valid @RequestBody  DtoUsernameEndResource user){

        Person person = personRepository.findPerosonByUsername(user.getUsername());
        return  UtilsTypeResource.getResource(person, user.getResource());
    }


    @PostMapping("/setResource")
    public ResponseEntity<String> setResource(
            @RequestBody @Valid DtoUsernameResourcTypeResource user
    ){
        Person person = personRepository.findPerosonByUsername(user.getUsername());
        UtilsTypeResource.setResource(person,user.getResourceType(),user.getResource());
        personRepository.save(person);
        return new ResponseEntity<>("resource changed", HttpStatus.OK);
    }
}
