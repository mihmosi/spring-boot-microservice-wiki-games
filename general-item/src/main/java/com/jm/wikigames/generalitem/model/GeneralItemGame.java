//package com.jm.wikigames.generalitem.model;
//
//import com.jm.wikigames.generalitem.converter.StatusEnumToStringConverter;
//import com.jm.wikigames.generalitem.model.enums.Status;
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = {"id","name"})
//public class GeneralItemGame {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NonNull
//    private String name;
//    private String dateOfCreation;
//    private String genre;
//    private String heroes;
//    private String villains;
//
//    @Convert(converter = StatusEnumToStringConverter.class)
//    private Status status;
//}
