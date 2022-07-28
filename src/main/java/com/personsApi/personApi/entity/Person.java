package com.personsApi.personApi.entity;


import com.personsApi.personApi.dto.DtoPerson;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    private String password;

    @ElementCollection
    @CollectionTable(name = "person_resources")
    @Column(name="resources")
    private Map<ResourceType, Double> resource;

    public Person() {
    }

    public Person(String username, String password, Map<ResourceType, Double> resource) {
        this.username = username;
        this.password = password;
        this.resource = resource;
    }

    public DtoPerson toPersonDto(){
        return new DtoPerson(username, resource);
    }
}
