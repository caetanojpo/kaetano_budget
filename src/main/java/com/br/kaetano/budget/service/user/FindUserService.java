package com.br.kaetano.budget.service.user;

import com.br.kaetano.budget.domain.User;
import com.br.kaetano.budget.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserService {

    private final UserRepository repository;

    public User byId(Long id){
        return repository.getReferenceById(id);
    }
}
