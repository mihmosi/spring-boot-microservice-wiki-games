package com.jm.wikigames.generalitem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","name"})
public class GeneralItemGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String dateOfCreation;
    @NonNull
    private String genre;
    @NonNull
    private String heroes;
    @NonNull
    private String villains;
}
