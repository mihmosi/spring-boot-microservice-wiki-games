package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.model.RoleModel;

public interface RoleService {

    RoleModel addRole(RoleModel roleModel);

    void deleteRoleById(long id);

}
