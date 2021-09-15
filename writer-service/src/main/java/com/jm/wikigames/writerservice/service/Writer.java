package com.jm.wikigames.writerservice.service;

import com.jm.wikigames.writerservice.dto.GameItemDTO;

public interface Writer {

    void writeToJSON(GameItemDTO gameItemDTO);

    String writeToXML(GameItemDTO gameItemDTO);

}
