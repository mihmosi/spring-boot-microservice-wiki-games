package com.jm.wikigames.parser.service.impl;

import com.jm.wikigames.parser.parsers.WebPageParser;
import com.jm.wikigames.parser.service.ParserService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ParserServiceImpl implements ParserService {
    private final WebPageParser webPageParser;

    public ParserServiceImpl(WebPageParser webPageParser){
        this.webPageParser = webPageParser;
    }

    @Override
    public Map<String, String> createGenreMap(){
        return webPageParser.createGenreMap();
    }
}
