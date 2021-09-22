package com.jm.wikigames.writerservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.writerservice.dto.GameItemDTO;
import com.jm.wikigames.writerservice.service.Writer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Arrays;

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
        String filePath = String.join(FileSystems.getDefault().getSeparator(), Arrays.asList(".", "writer-service", "src", "main", "resources", "gameItemDTO.xml"));
        File file = new File(filePath);
        String xml = null;
        try (java.io.Writer writer = new PrintWriter(file)){
            file.createNewFile();
            xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + new XmlMapper().writeValueAsString(gameItemDTO);
            writer.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
