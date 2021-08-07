package com.jm.wikigames.userservice.repository;

import com.jm.wikigames.userservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByName(String name);
}
