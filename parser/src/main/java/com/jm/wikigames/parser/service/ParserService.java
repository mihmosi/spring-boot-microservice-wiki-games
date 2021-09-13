package com.jm.wikigames.parser.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ParserService {

    public Map<String, String> createGenreMap();
}
