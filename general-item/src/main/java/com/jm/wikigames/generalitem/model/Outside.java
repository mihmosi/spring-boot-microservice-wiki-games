package com.jm.wikigames.generalitem.model;


import com.jm.wikigames.generalitem.model.enums.GameMode;
import com.jm.wikigames.generalitem.model.enums.Genre;
import com.jm.wikigames.generalitem.model.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Outside {

    @Enumerated(EnumType.STRING)
    private Platform platform;

    private Date releaseDate;

    private String distributor;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String developer;

    private String gameUniversity;

    private String systemRequirements;

    @Enumerated(EnumType.STRING)
    private GameMode gameMode;
}
