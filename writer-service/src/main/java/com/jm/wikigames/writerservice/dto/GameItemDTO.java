package com.jm.wikigames.writerservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
public class GameItemDTO {

    private String name;
    private String lore;
    private String originalSource;
    private String genre;
    private String platform;
    private String dateOfCreation;
    private String distributor;
    private String outsideGenre;
    private String gameUniversity;
    private String systemRequirements;
    private String gameMode;
    private String heroes;
    private String villains;
    private String status;
    private String link;

}
