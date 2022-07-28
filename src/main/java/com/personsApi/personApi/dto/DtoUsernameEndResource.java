package com.personsApi.personApi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DtoUsernameEndResource {
    @Size(min = 8, max = 16)
    @NotBlank
    private String username;
    private String resource;
}
