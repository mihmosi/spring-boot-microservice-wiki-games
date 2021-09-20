package com.jm.wikigames.writerservice.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
public class GameItem {

    private String name;
    private String dateOfCreation;
    private String genre;
    private String heroes;
    private String villains;
    private String status;

}
