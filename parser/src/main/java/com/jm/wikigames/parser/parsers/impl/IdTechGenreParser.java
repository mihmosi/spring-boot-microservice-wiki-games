package com.jm.wikigames.parser.parsers.impl;

import com.jm.wikigames.parser.model.WebPage;
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

    private final String url = "https://www.idtech.com/blog/different-types-of-video-game-genres";
    private final String selectQuery = "#blog-post-content > p, #blog-post-content > h3, #blog-post-content > h4";
    private final String genreDelQuery = "h3 > img, alt=Strategy, Games height=90";
    private final String subGenDelQuery = "h4 > em";
    private final String genreNamesCss = "h3";
    private final String subGenCss = "h4";

    private WebPage page = new WebPage();


    @Override
    public Map<String, String> createGenreMap() {

        try {
            processPage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> genreDescMap = page.getGenreDescMap();
        genreDescMap.putAll(page.getSubGenDescMap());

        return genreDescMap;
    }


    private void processPage() throws IOException {

        page.setParsedPage(parsePage(url, selectQuery));
        page.setGenreNames(page.getParsedPage()
                .select(genreNamesCss)
                .stream()
                .filter(e -> e.text().length() > 2)
                .collect(Collectors.toList()));
        page.setGenreIndexList(createKeyIndexes(page.getParsedPage(), page.getGenreNames()));
        page.setGenreDescript(parseDescriptions(page.getParsedPage(), page.getGenreIndexList()));
        page.setGenreDescMap(createMap(page.getGenreNames(), page.getGenreDescript()));

        page.setSubGenNames(page.getParsedPage()
                .select(subGenCss)
                .stream()
                .filter(e -> !e.text().equals("Types of RPG Games:"))
                .collect(Collectors.toList()));
        page.setSubGenIndexList(createKeyIndexes(page.getParsedPage(), page.getSubGenNames()));
        page.setSubGenDescript(parseSubGenDesc(page.getParsedPage(), page.getSubGenIndexList(), page.getGenreIndexList()));

        page.setSubGenDescMap(createMap(page.getSubGenNames(), page.getSubGenDescript()));
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