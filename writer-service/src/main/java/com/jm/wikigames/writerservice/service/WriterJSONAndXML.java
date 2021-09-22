package com.jm.wikigames.writerservice.service;

import com.jm.wikigames.writerservice.dto.model.GameItem;
import com.jm.wikigames.writerservice.dto.GameItemDTO;

public interface WriterJSONAndXML {

    String writeToJSON(GameItemDTO gameItemDTO);

    String writeToXML(GameItemDTO gameItemDTO);

}
