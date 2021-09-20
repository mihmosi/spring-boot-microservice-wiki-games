package com.jm.wikigames.writerservice.service.impl;

import com.jm.wikigames.writerservice.dto.GameItemDTO;
import com.jm.wikigames.writerservice.service.WriterJSONAndXML;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WriterJSONAndXMLImplTest {

    @Autowired
    private WriterJSONAndXML writerJSONAndXML;
    private final GameItemDTO gameItemDTO = new GameItemDTO();

    @BeforeEach
    void init() {
        gameItemDTO.setName("StarCraft 2");
        gameItemDTO.setDateOfCreation("2020-12-12");
        gameItemDTO.setGenre("Strategy");
        gameItemDTO.setHeroes("Raynor");
        gameItemDTO.setVillains("none");
        gameItemDTO.setStatus("in progress");
        gameItemDTO.setLore("Cosmos");
        gameItemDTO.setOutsideGenre("First Genre");
        gameItemDTO.setOriginalSource("Blizzard");
        gameItemDTO.setPlatform("PC");
        gameItemDTO.setDistributor("Blizzard");
        gameItemDTO.setGameUniversity("StarCraft");
        gameItemDTO.setSystemRequirements("medium");
        gameItemDTO.setGameMode("First gamemode");
        gameItemDTO.setLink("www.starcraft.com");
    }

    @Test
    public void writeToXML () {
        String result = writerJSONAndXML.writeToXML(gameItemDTO);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<GameItemInsideOutsideDTO><gameItem><name>StarCraft 2</name><dateOfCreation>2020-12-12</dateOfCreation><genre>Strategy</genre><heroes>Raynor</heroes><villains>none</villains><status>in progress</status></gameItem><outside><platform>PC</platform><distributor>Blizzard</distributor><gameUniversity>StarCraft</gameUniversity><outsideGenre>First Genre</outsideGenre><systemRequirements>medium</systemRequirements><gameMode>First gamemode</gameMode></outside><inside><lore>Cosmos</lore><originalSource>Blizzard</originalSource></inside><link>www.starcraft.com</link></GameItemInsideOutsideDTO>";
        assertEquals(expected, result);
        try {
            Files.delete(Path.of("../writer-service/src/main/resources/xml/gameItemDTO.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void writeToJSON() {

        String actual = "{\"gameItem\":{\"name\":\"StarCraft 2\",\"dateOfCreation\":\"2020-12-12\",\"genre\":" +
                "\"Strategy\",\"heroes\":\"Raynor\",\"villains\":\"none\",\"status\":\"in progress\"},\"outside\"" +
                ":{\"platform\":\"PC\",\"distributor\":\"Blizzard\",\"gameUniversity\":\"StarCraft\",\"outsideGenre\"" +
                ":\"First Genre\",\"systemRequirements\":\"medium\",\"gameMode\":\"First gamemode\"},\"inside\":" +
                "{\"lore\":\"Cosmos\",\"originalSource\":\"Blizzard\"},\"link\":\"www.starcraft.com\"}";

        String expected = writerJSONAndXML.writeToJSON(gameItemDTO);

        assertEquals(actual, expected);

        try {
            Files.delete(Path.of("../writer-service/src/main/resources/json/gameItemDto.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}