package com.br.kaetano.budget.service.user;

import com.br.kaetano.budget.domain.User;
import com.br.kaetano.budget.dtos.users.CreateUserDTO;
import com.br.kaetano.budget.mapper.UserMapper;
import com.br.kaetano.budget.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository repository;

    public User save(CreateUserDTO userData) {

        var user = UserMapper.INSTANCE.toUser(userData);

        repository.save(user);

        return user;

    }

}
