package com.br.kaetano.budget.dtos.users;

import com.br.kaetano.budget.domain.Address;
import com.br.kaetano.budget.domain.User;

public record DetailedUserDTO(Long id, String email, String userName, String firstName, String lastName,
                              String personalDocument, String birth, Address address, String phoneNumber) {

    public DetailedUserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getPersonalDocument(), String.valueOf(user.getBirth()),
                user.getAddress(), user.getPhoneNumber());
    }
}
