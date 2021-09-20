package com.jm.wikigames.writerservice.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
public class Outside {

    private String platform;
    private String distributor;
    private String gameUniversity;
    private String outsideGenre;
    private String systemRequirements;
    private String gameMode;
}


