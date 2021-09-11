package com.jm.wikigames.gameitem.dto;

import com.jm.wikigames.gameitem.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameItemDTO {

    private Long id;
    private String name;
    private String dateOfCreation;
    private String genre;
    private String heroes;
    private String villains;
    private Status status;

}
