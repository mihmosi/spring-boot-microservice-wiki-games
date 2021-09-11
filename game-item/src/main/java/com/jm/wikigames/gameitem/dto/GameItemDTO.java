package com.jm.wikigames.gameitem.dto;

import com.jm.wikigames.gameitem.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameItemDTO {

    private Long id; //возможно лишнее, нет в описании
    private String name;
    private String lore; //new
    private String originalSource; //new
    private String genre;
    private String platform; //new
    private String dateOfCreation;
    private String distributor; //new
    private String outsideGenre; //new - экшн, стратегия, РПГ, аркада...
    private String gameUniversity; //new
    private String systemRequirements; //new
    private String gameMode; //new - режим игры ( одиночная, кооператив...)
    private String heroes; //возможно лишнее, нет в описании
    private String villains; //возможно лишнее, нет в описании
    private Status status;
    private String link; //new

}
