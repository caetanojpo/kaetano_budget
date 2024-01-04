package com.br.kaetano.budget.dtos.users;

import com.br.kaetano.budget.dtos.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CreateUserDTO(
        @NotNull
        @Email(message = "Invalid email format")
        String email,

        @NotNull
        @Pattern(regexp = "^[a-zA-Z\\d]{6,}$", message = "Username must be at least 6 characters long and should not contain special characters")
        String username,

        @NotNull
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must be at least 8 characters long, contain at least one uppercase letter, one digit, and one special character"
        )
        String password,

        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ ]+$", message = "{ONLY.ALPHABETICAL}")
        String firstName,

        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ ]+$", message = "{ONLY.ALPHABETICAL}")
        String lastName,

        @Pattern(regexp = "^\\d{11}$", message = "Invalid CPF format")
        String personalDocument,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        Date birth,

        @NotNull
        @Valid
        AddressDTO address,

        @Pattern(regexp = "^[0-9]{8,12}$", message = "Phone number must contain between 8 and 12 digits")
        String phoneNumber
) {
}
