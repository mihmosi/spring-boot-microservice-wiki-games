package com.jm.wikigames.generalitem.parsers;

import java.util.Map;

public interface GenreParser {

    public Map<String, String> parseGenreMap(String url, String cssQuery, String excludeCssQuery, String keysCssQuery);

    public Map<String, String> updateGenreMap(String url, String cssQuery, String excludeCssQuery, String keysCssQuery);
}
