package com.br.kaetano.budget.domain.users.entity;

import com.br.kaetano.budget.domain.address.Address;
import com.br.kaetano.budget.dtos.users.CreateUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date birth;

    @Embedded
    private Address address;

    private String phoneNumber;
    private String personalDocument;
    private boolean active;

    public User(CreateUserDTO userData) {
        this.active = true;
        this.email = userData.email();
        this.username = userData.username();
        this.password = userData.password();
        this.firstName = userData.firstName();
        this.lastName = userData.lastName();
        this.personalDocument = userData.personalDocument();
        this.birth = userData.birth();
        this.address = new Address(userData.address());
        this.phoneNumber = userData.phoneNumber();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
