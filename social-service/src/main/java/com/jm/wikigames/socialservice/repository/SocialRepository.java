package com.jm.wikigames.socialservice.repository;


import com.jm.wikigames.socialservice.model.Social;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialRepository extends JpaRepository<Social, Long> {

    Optional<Social> getSocialByGameItemId(Long id);

}
