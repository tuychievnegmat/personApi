package com.personsApi.personApi.controller;





import com.personsApi.personApi.dto.DtoLoginPassword;
import com.personsApi.personApi.dto.DtoPerson;
import com.personsApi.personApi.entity.Person;
import com.personsApi.personApi.entity.ResourceType;
import com.personsApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


//TODO по тз не понятно нужно ли реализовать security или уже есть
// реализованная и просто нужно подключить ее. здесь в качестве
// заглушки будут использоваться методы создания и проверки.
// нужно реализовать security authorithation проверку
@RestController
@Validated
public class PersonController {
   @Autowired
   private PersonRepository personRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(
            @Valid @RequestBody  DtoLoginPassword usernameEndPassword
    ){
        Person user = personRepository.findPerosonByUsername(usernameEndPassword.getUsername());
        if (user != null){
            return new ResponseEntity<>("user exists", HttpStatus.FOUND);
        }
        else {
            Map<ResourceType, Double> resources = new HashMap<>();
            for (ResourceType resourceType : ResourceType.values()) {
                resources.put(resourceType, 0.0);
            }

            user = new Person(usernameEndPassword.getUsername(), usernameEndPassword.getPassword(), resources);
            personRepository.save(user);
            return new ResponseEntity<>("created", HttpStatus.CREATED);

        }
    }

    @GetMapping("/getUser")
    @ResponseBody
    public DtoPerson getUser(@RequestParam  @Valid String username){
        return personRepository.findPerosonByUsername(username).toPersonDto();
    }

}
