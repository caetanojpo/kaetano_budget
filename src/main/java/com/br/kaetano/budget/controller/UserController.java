package com.br.kaetano.budget.controller;

import com.br.kaetano.budget.domain.User;
import com.br.kaetano.budget.dtos.users.CreateUserDTO;
import com.br.kaetano.budget.dtos.users.DetailedUserDTO;
import com.br.kaetano.budget.service.user.CreateUserService;
import com.br.kaetano.budget.service.user.FindUserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController()
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService create;
    private final FindUserService find;

    @PostMapping
    @PermitAll
    @Transactional
    public ResponseEntity<DetailedUserDTO> create(@RequestBody @Valid CreateUserDTO userData, UriComponentsBuilder uriBuilder) {

        var user = create.save(userData);

        var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailedUserDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedUserDTO> detail(@PathVariable Long id) {
        var user = find.byId(id);
        return ResponseEntity.ok(new DetailedUserDTO(user));
    }
}
