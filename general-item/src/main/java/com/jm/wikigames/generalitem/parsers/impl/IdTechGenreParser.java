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
    private List<Element> parsedKeyNames;
    private List<Integer> keyIndexList;
    private List<String> parsedValues;
    private Map<String, String> genreDescriptionMap;

    private final String url = "https://www.idtech.com/blog/different-types-of-video-game-genres";
    private final String selectQuery = "#blog-post-content > p, #blog-post-content > h3, #blog-post-content > h4";
    private final String delElemQuery = "h3 > img";
    private final String keysCssQuery = "h3";


    public Map<String, String> createGenreMap() {
        if (genreDescriptionMap == null) {
            genreDescriptionMap = new HashMap<>();
            processFields();

            for (int i = 0; i < parsedKeyNames.size(); i++) {
                genreDescriptionMap.put(parsedKeyNames.get(i).text(), parsedValues.get(i));
            }
        }
        return genreDescriptionMap;
    }


    public Map<String, String> updateGenreMap() {
        resetValues();
        return createGenreMap();
    }


    private void processFields() {
        parsePage(url, selectQuery);
        parseGenreNames();
        createKeyIndexes();
        parseGenreDescript();
    }


    private void resetValues() {
        setGenreDescriptionMap(null);
        setParsedPage(null);
        setParsedKeyNames(null);
        setKeyIndexList(null);
        setParsedValues(null);
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


    private void parseGenreNames() {
        if (parsedKeyNames == null) {
            Elements fetchedElem = selectElements(parsedPage, keysCssQuery);
            parsedKeyNames = deleteElements(fetchedElem, delElemQuery)
                    .stream()
                    .filter(e -> (e.text().length() > 2))
                    .collect(Collectors.toList());
        }
    }


    private void createKeyIndexes() {
        if (keyIndexList == null) {
            keyIndexList = parsedKeyNames
                    .stream()
                    .map(parsedPage::indexOf)
                    .collect(Collectors.toList());
        }
    }


    private String elemListToString(List<Element> sublist) {
        return sublist
                .stream()
                .reduce((acc, el) -> acc.append(el.text()))
                .get()
                .text();
    }


    private void parseGenreDescript() {
        if (parsedValues == null) {
            parsedValues = new ArrayList<>();

            for (int i = 0; i < (keyIndexList.size() - 1); i++) {
                List<Element> keyDescription = parsedPage.subList((keyIndexList.get(i) + 1), (keyIndexList.get(i + 1)));
                parsedValues.add(elemListToString(keyDescription));
            }

            List<Element> keyDescription =
                    parsedPage.subList((keyIndexList.get(keyIndexList.size() - 1) + 1), (parsedPage.indexOf(parsedPage.last())));
            parsedValues.add(elemListToString(keyDescription));
        }
    }
}