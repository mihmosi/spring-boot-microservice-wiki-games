package com.jm.wikigames.socialservice.service.impl;

import com.jm.wikigames.socialservice.model.Social;
import com.jm.wikigames.socialservice.repository.SocialRepository;
import com.jm.wikigames.socialservice.service.SocialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SocialServiceImpl implements SocialService {

    private final SocialRepository socialRepository;

    @Override
    public synchronized Social incrementSocialCount(Long id, Boolean inc) {
        Optional<Social> social = socialRepository.getSocialByGameItemId(id);
        if (inc) {
            if (social.isEmpty()) {
                social = Optional.of(new Social(1L, id));
            } else {
                social.get().increment();
            }
            return socialRepository.save(social.get());
        }
        return social.get();
    }


}
