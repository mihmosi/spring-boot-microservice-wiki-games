package com.jm.wikigames.userservice.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByName(String name);
}
