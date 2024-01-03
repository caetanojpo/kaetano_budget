package com.br.kaetano.budget.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        @Pattern(regexp = "^[0-9]+$", message = "Only numeric values are allowed")
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}", message = "Must have 8 digit")
        String postalCode,
        @NotBlank
        String city,
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]+${2}", message = "Only alphabetical characters are allowed. Only 2 characters")
        String state,
        @NotBlank
        String country

) {
}
