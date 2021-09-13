package com.jm.wikigames.parser.parsers.impl;

import com.jm.wikigames.parser.parsers.WebPageParser;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Data
public class IdTechGenreParser implements WebPageParser {
    private Elements parsedPage;
    private List<Element> genreNames;
    private List<Element> subGenNames;
    private List<Integer> genreIndexList;
    private List<Integer> subGenIndexList;
    private List<Element> genreDescript;
    private List<Element> subGenDescript;
    private Map<String, String> genreDescMap;
    private Map<String, String> subGenDescMap;

    private final String url = "https://www.idtech.com/blog/different-types-of-video-game-genres";
    private final String selectQuery = "#blog-post-content > p, #blog-post-content > h3, #blog-post-content > h4";
    private final String genreDelQuery = "h3 > img, alt=Strategy, Games height=90";
    private final String subGenDelQuery = "h4 > em";
    private final String genreNamesCss = "h3";
    private final String subGenCss = "h4";


    @Override
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


    private void processFields() {
        try {
            parsedPage = parsePage(url, selectQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
        genreNames = parsedPage
                .select(genreNamesCss)
                .stream()
                .filter(e -> e.text().length() > 2)
                .collect(Collectors.toList());
        genreIndexList = createKeyIndexes(parsedPage, genreNames);
        genreDescript = parseDescriptions(parsedPage, genreIndexList);

        subGenNames = parsedPage
                .select(subGenCss)
                .stream()
                .filter(e -> !e.text().equals("Types of RPG Games:"))
                .collect(Collectors.toList());

        subGenIndexList = createKeyIndexes(parsedPage, subGenNames);
        subGenDescript = parseSubGenDesc(parsedPage, subGenIndexList, genreIndexList);

        subGenDescMap = createMap(subGenNames, subGenDescript);
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


    private List<Integer> createKeyIndexes(Elements page, List<Element> elements) {
        return elements
                .stream()
                .map(page::indexOf)
                .collect(Collectors.toList());
    }


    private Element shrinkToOne(List<Element> sublist) {
        return sublist
                .stream()
                .reduce((acc, el) -> acc.append(el.text()))
                .get();
    }


    private List<Element> parseDescriptions(Elements page, List<Integer> indexes) {
        List<Element> parsedValues = new ArrayList<>();
        List<Element> keyDescription;

        for (int i = 0; i < (indexes.size() - 1); i++) {
            keyDescription = page.subList((indexes.get(i) + 1), (indexes.get(i + 1)));
            if (keyDescription.size() > 0) {
                parsedValues.add(shrinkToOne(keyDescription));
            }
        }
        keyDescription = page.subList((indexes.get(indexes.size() - 1) + 1), (page.indexOf(page.last())));
        parsedValues.add(shrinkToOne(keyDescription));

        return parsedValues;
    }


    private List<Element> parseSubGenDesc(Elements page, List<Integer> subIndexes, List<Integer> endIndexes) {
        List<Element> parsedValues = new ArrayList<>();
        List<Element> keyDescription;
        List<Integer> indexes = new ArrayList<>(subIndexes);
        indexes.addAll(endIndexes);
        Collections.sort(indexes);
        int firstInd;
        int lastInd;

        for (int i = 0; i < (indexes.size() - 1); i++) {
            firstInd = indexes.get(i);
            if (!endIndexes.contains(firstInd)) {
                lastInd = indexes.get(i + 1);
                keyDescription = page.subList((firstInd + 1), (lastInd));
                if (keyDescription.size() > 0) {
                    parsedValues.add(shrinkToOne(keyDescription));
                }
            }
        }
        keyDescription = page.subList((indexes.get(indexes.size() - 1) + 1), (page.indexOf(page.last())));
        parsedValues.add(shrinkToOne(keyDescription));

        return parsedValues;
    }
}