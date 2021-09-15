package com.jm.wikigames.writerservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.writerservice.dto.GameItemDTO;
import com.jm.wikigames.writerservice.service.Writer;

import java.io.File;
import java.io.IOException;

public class WriterImpl implements Writer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void writeToJSON(GameItemDTO gameItemDTO) {
        File jsonFile = new File("writer-service/src/main/resources/json/gameItemDtoJson.json");
        try {
           objectMapper.writeValue(jsonFile, gameItemDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String writeToXML(GameItemDTO gameItemDTO) {
        return null;
    }
}
