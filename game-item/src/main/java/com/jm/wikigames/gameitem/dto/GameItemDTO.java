package com.jm.wikigames.gameitem.dto;

import com.jm.wikigames.gameitem.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameItemDTO {

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
    private String heroes; //возможно лишнее, не перечислено в ТЗ
    private String villains; //возможно лишнее, не перечислено в ТЗ
//    TODO: Поменять Status на String
    private Status status;
    private String link; //new

}
