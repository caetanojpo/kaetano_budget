package com.br.kaetano.budget.dtos.users;

import com.br.kaetano.budget.domain.address.Address;
import com.br.kaetano.budget.domain.users.entity.User;


import java.util.Date;

public record DetailedUserDTO(Long id, String email, String userName, String firstName, String lastName,
                              String personalDocument, String birth, Address address, String phoneNumber) {

    public DetailedUserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getPersonalDocument(), String.valueOf(user.getBirth()),
                user.getAddress(), user.getPhoneNumber());
    }
}
