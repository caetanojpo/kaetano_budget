package com.br.kaetano.budget.domain.users.repository;

import com.br.kaetano.budget.domain.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

}
