package com.personsApi.personApi.dto;

import com.personsApi.personApi.entity.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Map;

@Data
@AllArgsConstructor
public class DtoPerson {
    @Size(min = 6, max = 16)
    @NotBlank
    private String username;
    @NotEmpty
    private Map<ResourceType, Double> resource;

}
