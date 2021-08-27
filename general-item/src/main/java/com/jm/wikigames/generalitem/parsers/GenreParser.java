package com.jm.wikigames.generalitem.parsers;

import java.util.Map;

public interface GenreParser {

    public Map<String, String> parseGenreMap();
    public Map<String, String> updateParsedGenreMap();

}
