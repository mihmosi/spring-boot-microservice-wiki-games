package com.jm.wikigames.writerservice.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
public class Inside {

    private String lore;
    private String originalSource;

}
