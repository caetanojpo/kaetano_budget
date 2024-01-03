package com.br.kaetano.budget.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String postalCode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String country

) {
}
