package com.br.kaetano.budget.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,

        @NotBlank
        @Pattern(regexp = "^\\d+$", message = "{ONLY.NUMERICAL}")
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
        @Pattern(regexp = "^[a-zA-Z]{2}$", message = "{ONLY.ALPHABETICAL}. Only 2 characters")
        String state,

        @NotBlank
        String country

) {
}
