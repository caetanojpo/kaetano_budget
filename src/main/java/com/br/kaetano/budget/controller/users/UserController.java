package com.br.kaetano.budget.controller.users;

import com.br.kaetano.budget.domain.users.entity.User;
import com.br.kaetano.budget.domain.users.repository.UsersRepository;
import com.br.kaetano.budget.dtos.users.CreateUserDTO;
import com.br.kaetano.budget.dtos.users.DetailedUserDTO;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController()
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    @PermitAll
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateUserDTO userData, UriComponentsBuilder uriBuilder) {

    var user = new User(userData);
    repository.save(user);

    var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(user.getId()).toUri();

    return ResponseEntity.created(uri).body(new DetailedUserDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailedUserDTO(user));
    }
}
