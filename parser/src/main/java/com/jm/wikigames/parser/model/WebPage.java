package com.jm.wikigames.parser.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.Map;

public class WebPage {
    private Elements parsedPage;
    private List<Element> genreNames;
    private List<Element> subGenNames;
    private List<Integer> genreIndexList;
    private List<Integer> subGenIndexList;
    private List<Element> genreDescript;
    private List<Element> subGenDescript;
    private Map<String, String> genreDescMap;
    private Map<String, String> subGenDescMap;
}
