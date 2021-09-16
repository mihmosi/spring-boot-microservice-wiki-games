package com.jm.wikigames.userservice.mapper;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.dto.UserDTO;
import com.jm.wikigames.userservice.model.RoleModel;
import com.jm.wikigames.userservice.model.UserModel;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserMapperTest {

    private final UserMapper mapper = new UserMapper();

    @Test
    void itShouldCreateDTO() {
        //given
        Set<RoleModel> givenRole = new HashSet<>();
        givenRole.add(new RoleModel(
                1L,
                "ROLE_USER",
                new HashSet<>()));

        UserModel givenUser = new UserModel(
                "John",
                "pass",
                "john@mail.com",
                givenRole);

        //when
        UserDTO result = mapper.toDTO(givenUser);

        //then
        UserDTO expected = new UserDTO(
                "John",
                "john@mail.com",
                givenRole);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldCreateUser() {
        //given
        Set<RoleModel> givenRole = new HashSet<>();
        givenRole.add(new RoleModel(
                1L,
                "ROLE_USER",
                new HashSet<>()));

        UserCreatingDTO givenDTO = new UserCreatingDTO(
                "Bill",
                "pass",
                "bill@mail.com",
                givenRole);

        //when
        UserModel result = mapper.toUser(givenDTO);

        //then
        UserModel expected = new UserModel(
                "Bill",
                "pass",
                "bill@mail.com",
                givenRole);
        assertThat(result).isEqualTo(expected);
    }
}