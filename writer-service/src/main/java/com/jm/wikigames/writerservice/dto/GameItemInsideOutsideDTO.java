package com.jm.wikigames.writerservice.dto;

import com.jm.wikigames.writerservice.dto.model.GameItem;
import com.jm.wikigames.writerservice.dto.model.Inside;
import com.jm.wikigames.writerservice.dto.model.Outside;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
public class GameItemInsideOutsideDTO {

    private GameItem gameItem;
    private Inside inside;
    private Outside outside;
    private String link;
}
