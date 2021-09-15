package com.jm.wikigames.gameitem.model;


import com.jm.wikigames.gameitem.model.enums.GameMode;
import com.jm.wikigames.gameitem.model.enums.Genre;
import com.jm.wikigames.gameitem.model.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Outside {

    @Enumerated(EnumType.STRING)
    private List<Platform> platform;

    private Date releaseDate;

    private String distributor;

    @Enumerated(EnumType.STRING)
    private List<Genre> InsideGenre;

    private String developer;

    private String gameUniversity;

    private String systemRequirements;

    @Enumerated(EnumType.STRING)
    private List<GameMode> gameMode;
}
