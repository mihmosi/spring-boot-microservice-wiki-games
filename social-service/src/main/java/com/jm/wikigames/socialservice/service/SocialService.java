package com.jm.wikigames.socialservice.service;


import com.jm.wikigames.socialservice.model.Social;

public interface SocialService {

    Social incrementSocialCount(Long id, Boolean inc);

}
