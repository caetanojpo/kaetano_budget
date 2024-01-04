package com.br.kaetano.budget.mapper;

import com.br.kaetano.budget.domain.Address;
import com.br.kaetano.budget.domain.User;
import com.br.kaetano.budget.dtos.address.AddressDTO;
import com.br.kaetano.budget.dtos.users.CreateUserDTO;
import com.br.kaetano.budget.enums.UserStatus;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", qualifiedByName = "encryptPassword")
    @Mapping(target = "address", ignore = true)
    User toUser(CreateUserDTO createUserDTO);

    Address toAddress(AddressDTO address);

    @Named("encryptPassword")
    default String encryptPassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    @Named("mappingAddress")
    default Address mappingAddress(AddressDTO address){
        return toAddress(address);
    }


}
