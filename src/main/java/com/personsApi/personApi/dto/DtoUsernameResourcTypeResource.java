package com.personsApi.personApi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DtoUsernameResourcTypeResource {
    @NotBlank
    @Size(min = 6, max = 16)
    private String username;
    @NotBlank
    private String resourceType;
    private Double resource;
}
