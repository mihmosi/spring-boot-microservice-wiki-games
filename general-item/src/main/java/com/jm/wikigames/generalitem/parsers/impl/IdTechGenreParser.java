package com.jm.wikigames.generalitem.parsers.impl;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import com.jm.wikigames.generalitem.parsers.GenreParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class IdTechGenreParser implements GenreParser {
    private final String userAgent = "Chrome/92.0.4515.159";
    private final String referrer = "http://www.google.com";
    private Elements parsedPage;
    private Elements parsedKeyNames;
    private List<Integer> keyIndexList;
    private List<String> parsedValues;
    private Map<String, String> genreDescriptionMap;


    @Override
    public Map<String, String> parseGenreMap() {
        return parseGenreMap("https://www.idtech.com/blog/different-types-of-video-game-genres",
                "#blog-post-content > p, h3, h4",
                "[style], h3 > img, [alt], [itemprop], [href=mailto:collegeprep@idtech.com], " +
                        "[href = mailto:privacy@idtech.com], [href = mailto:privacy@idtech.com]",
                "h3");
    }

    @Override
    public Map<String, String> updateParsedGenreMap() {
        return updateGenreMap("https://www.idtech.com/blog/different-types-of-video-game-genres",
                "#blog-post-content > p, h3, h4",
                "[style], h3 > img, [alt], [itemprop], [href=mailto:collegeprep@idtech.com], " +
                        "[href = mailto:privacy@idtech.com], [href = mailto:privacy@idtech.com]",
                "h3");
    }


    public Map<String, String> parseGenreMap(String url, String cssQuery, String excludeCssQuery, String keysCssQuery) {
        getParsedPage(url, cssQuery, excludeCssQuery);
        getParsedKeyNames(keysCssQuery);
        getKeyIndexList(keysCssQuery);
        getValues(keyIndexList);

        if (genreDescriptionMap == null) {
            genreDescriptionMap = new HashMap<>();

            for (int i = 0; i < parsedKeyNames.size(); i++) {
                genreDescriptionMap.put(parsedKeyNames.get(i).text(), parsedValues.get(i));
            }
        }
        return genreDescriptionMap;
    }


    public Map<String, String> updateGenreMap(String url, String cssQuery, String excludeCssQuery, String keysCssQuery) {
        resetValues();
        return parseGenreMap(url, cssQuery, excludeCssQuery, keysCssQuery);
    }


    private void resetValues() {
        genreDescriptionMap = null;
        parsedPage = null;
        parsedKeyNames = null;
        keyIndexList = null;
        parsedValues = null;
    }


    public Elements getParsedPage(String url, String cssQuery, String excludeCssQuery) {
        if (parsedPage == null) {
            try {
                parsedPage = Jsoup
                        .connect(url)
                        .userAgent(userAgent)
                        .referrer(referrer)
                        .get()
                        .select(cssQuery)
                        .not(excludeCssQuery);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return parsedPage;
    }

    public Elements getParsedKeyNames(String keysCssQuery) {
        if (parsedKeyNames == null) {
            parsedKeyNames = parsedPage.select(keysCssQuery);

            parsedKeyNames = new Elements(parsedKeyNames
                    .stream()
                    .filter(e -> (parsedPage.get(parsedPage.indexOf(e)).text().length() > 2))
                    .collect(Collectors.toList()));
        }
        return parsedKeyNames;
    }


    private List<Integer> getKeyIndexList(String keysCssQuery) {
        if (keyIndexList == null) {
            keyIndexList = parsedKeyNames
                    .stream()
                    .map(e -> parsedPage.indexOf(e))
                    .collect(Collectors.toList());
        }
        return keyIndexList;
    }


    public List<String> getValues(List<Integer> keyIndexList) {
        if (parsedValues == null) {
            parsedValues = new ArrayList<>();

            for (int i = 0; i < (keyIndexList.size() - 1); i++) {
                String valueDescription = parsedPage
                        .subList((keyIndexList.get(i) + 1), (keyIndexList.get(i + 1)))
                        .stream()
                        .map(e -> {
                            StringBuilder sb = new StringBuilder();
                            return sb.append(e.text());
                        })
                        .reduce(new StringBuilder(), StringBuilder::append).toString();
                parsedValues.add(valueDescription);
            }
            parsedValues.add(parsedPage
                    .subList((keyIndexList.get(keyIndexList.size() - 1) + 1), parsedPage.size())
                    .stream()
                    .map(e -> {
                        StringBuilder sb = new StringBuilder();
                        return sb.append(e.text());
                    })
                    .reduce(new StringBuilder(), StringBuilder::append).toString());
        }
        return parsedValues;
    }
}