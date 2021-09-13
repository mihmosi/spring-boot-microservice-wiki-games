package com.jm.wikigames.parser.controller;

import com.jm.wikigames.parser.service.ParserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/parser/")
public class ParserController {

    private final ParserService parserService;

    public ParserController(ParserService parserService) {
        this.parserService = parserService;
    }

    @GetMapping
    @RequestMapping("/idtech")
    public Map<String, String> getGenreMap() {
        return parserService.createGenreMap();
    }
}
