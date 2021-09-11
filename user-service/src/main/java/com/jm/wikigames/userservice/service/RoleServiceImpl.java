package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.model.RoleModel;
import com.jm.wikigames.userservice.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Override
    public RoleModel addRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
}
