package com.jm.wikigames.generalitem.parsers.impl;

import com.jm.wikigames.generalitem.parsers.AbstractWebPageParser;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Data
public class IdTechGenreParser extends AbstractWebPageParser {
    private Elements parsedPage;
    private List<Element> genreNames;
    private List<Element> subGenNames;
    private List<Integer> genreIndexList;
    private List<Integer> subGenIndexList;
    private List<String> genreDescript;
    private List<String> subGenDescript;
    private Map<String, String> genreDescMap;
    private Map<String, String> subGenDescMap;

    private final String url = "https://www.idtech.com/blog/different-types-of-video-game-genres";
    private final String selectQuery = "#blog-post-content > p, #blog-post-content > h3, #blog-post-content > h4";
    private final String genreDelQuery = "h3 > img, alt=Strategy, Games height=90";
    private final String subGenDelQuery = "h4 > em";
    private final String genreNamesCss = "h3";
    private final String subGenCss = "h4";


    public Map<String, String> createGenreMap() {
        if (genreDescMap == null) {
            processFields();
            genreDescMap = createMap(genreNames, genreDescript);
            genreDescMap.putAll(subGenDescMap);
        }
        return genreDescMap;
    }


    public Map<String, String> updateGenreMap() {
        resetValues();
        return createGenreMap();
    }


    private Map<String, String> createMap(List<Element> names, List<String> descriptions) {
        Map<String, String> map = new HashMap<>();
        processFields();

        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i).text(), descriptions.get(i));
        }
        return map;
    }


    private void createSubMap() {
        if (subGenDescMap == null) {
            subGenDescMap = new HashMap<>();
            subGenDescMap = createMap(subGenNames, subGenDescript);
        }
    }


    private void processFields() {
        parsePage(url, selectQuery);
        genreNames = parsedPage
                .select(genreNamesCss)
                .stream()
                .filter(e -> e.text().length() > 2)
                .collect(Collectors.toList());
        genreIndexList = createKeyIndexes(genreNames);
        genreDescript = parseDescriptions(genreIndexList);

        subGenNames = parsedPage
                .select(subGenCss)
                .stream()
                .filter(e -> !e.text().equals("Types of RPG Games:"))
                .collect(Collectors.toList());

        subGenIndexList = createKeyIndexes(subGenNames);
        subGenDescript = parseDescriptions(subGenIndexList);

        createSubMap();
    }


    private void resetValues() {
        setParsedPage(null);
        setGenreDescMap(null);
        setSubGenDescMap(null);

        setGenreNames(null);
        setGenreIndexList(null);
        setGenreDescript(null);

        setSubGenNames(null);
        setSubGenIndexList(null);
        setSubGenDescript(null);
    }


    @Override
    public Elements parsePage(String url, String cssQuery) {
        if (parsedPage == null) {
            try {
                parsedPage = super.parsePage(url, cssQuery);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return parsedPage;
    }


    private List<Integer> createKeyIndexes(List<Element> elements) {
        return elements
                .stream()
                .map(parsedPage::indexOf)
                .collect(Collectors.toList());
    }


    private String elemListToString(List<Element> sublist) {
        return sublist
                .stream()
                .reduce((acc, el) -> acc.append(el.text()))
                .get()
                .text();
    }


    private List<String> parseDescriptions(List<Integer> indexes) {
        List<String> parsedValues = new ArrayList<>();
        List<Element> keyDescription;

        for (int i = 0; i < (indexes.size() - 1); i++) {
            keyDescription = parsedPage.subList((indexes.get(i) + 1), (indexes.get(i + 1)));
            if (keyDescription.size() > 0) {
                parsedValues.add(elemListToString(keyDescription));
            }

        }

        keyDescription = parsedPage.subList((indexes.get(indexes.size() - 1) + 1), (parsedPage.indexOf(parsedPage.last())));
        parsedValues.add(elemListToString(keyDescription));

        return parsedValues;
    }
}