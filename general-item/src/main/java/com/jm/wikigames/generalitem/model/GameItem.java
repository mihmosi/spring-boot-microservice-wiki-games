package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.converter.Status;
import com.jm.wikigames.generalitem.converter.StatusConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game_item")
public class GameItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private Inside inside;
    @Convert(converter = StatusConverter.class)
    private Status status;
}
