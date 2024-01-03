package com.br.kaetano.budget.domain.address;

import com.br.kaetano.budget.dtos.address.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String  postalCode;
    private String city;
    private String state;
    private String country;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.number = addressDTO.number();
        this.complement = addressDTO.complement();
        this.neighborhood = addressDTO.neighborhood();
        this.postalCode = addressDTO.postalCode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.country = addressDTO.country();
    }
}
