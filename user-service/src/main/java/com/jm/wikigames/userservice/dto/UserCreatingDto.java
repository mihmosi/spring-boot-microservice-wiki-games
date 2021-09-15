package com.jm.wikigames.userservice.dto;

import com.jm.wikigames.userservice.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatingDto {

    private String name;
    private String password;
    private String email;
    private Set<RoleModel> roles;

}
