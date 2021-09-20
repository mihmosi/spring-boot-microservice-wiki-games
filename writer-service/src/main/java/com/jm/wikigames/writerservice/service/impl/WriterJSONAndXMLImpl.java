package com.jm.wikigames.writerservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.writerservice.dto.GameItemDTO;
import com.jm.wikigames.writerservice.dto.GameItemInsideOutsideDTO;
import com.jm.wikigames.writerservice.dto.model.GameItem;
import com.jm.wikigames.writerservice.dto.model.Inside;
import com.jm.wikigames.writerservice.dto.model.Outside;
import com.jm.wikigames.writerservice.service.WriterJSONAndXML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Setter
@Getter
@AllArgsConstructor
@Service
public class WriterJSONAndXMLImpl implements WriterJSONAndXML {

    private static final String relativePathToJSONFile = "writer-service/src/main/resources/json/gameItemDto.json";
    private ObjectMapper objectMapper;
    private GameItem gameItem;
    private Inside inside;
    private Outside outside;
    private GameItemInsideOutsideDTO gameItemInsideOutsideDTO;

    @Override
    public String writeToJSON(GameItemDTO gameItemDTO) {

        File jsonFile = new File(relativePathToJSONFile);

        gameItem.setName(gameItemDTO.getName());
        gameItem.setDateOfCreation(gameItemDTO.getDateOfCreation());
        gameItem.setGenre(gameItemDTO.getGenre());
        gameItem.setHeroes(gameItemDTO.getHeroes());
        gameItem.setVillains(gameItemDTO.getVillains());
        gameItem.setStatus(gameItemDTO.getStatus());

        inside.setLore(gameItemDTO.getLore());
        inside.setOriginalSource(gameItemDTO.getOriginalSource());

        outside.setPlatform(gameItemDTO.getPlatform());
        outside.setDistributor(gameItemDTO.getDistributor());
        outside.setGameUniversity(gameItemDTO.getGameUniversity());
        outside.setOutsideGenre(gameItemDTO.getOutsideGenre());
        outside.setSystemRequirements(gameItemDTO.getSystemRequirements());
        outside.setGameMode(gameItemDTO.getGameMode());

        gameItemInsideOutsideDTO.setGameItem(gameItem);
        gameItemInsideOutsideDTO.setInside(inside);
        gameItemInsideOutsideDTO.setOutside(outside);
        gameItemInsideOutsideDTO.setLink(gameItemDTO.getLink());

        try {
            objectMapper.writeValue(jsonFile, gameItemInsideOutsideDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = null;

        try {
            json = objectMapper.writeValueAsString(gameItemInsideOutsideDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public String writeToXML(GameItem gameItemDTO) {
        return null;
    }
}
