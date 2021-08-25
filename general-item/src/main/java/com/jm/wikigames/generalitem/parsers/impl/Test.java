package com.jm.wikigames.generalitem.parsers.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Data
//public class GenreParserImpl implements GenreParser {
//    private Map<String, String> genreDescriptionMap = new HashMap<>();
//    private final String userAgent = "Chrome/92.0.4515.159";
//    private final String referrer = "http://www.google.com";
//
//    @Override
//    public Map<String, String> parseGenreMap(String url) {
//        try {
//            Document doc = Jsoup.connect(url)
//                    .userAgent(userAgent)
//                    .referrer(referrer)
//                    .get();
//
//            Elements rawPage = doc.select("#blog-post-content > p, h3, h4")
//                    .not("[style], [itemprop], [href=mailto:collegeprep@idtech.com], " +
//                            "[href = mailto:privacy@idtech.com], [href = mailto:privacy@idtech.com]");
//
//            Elements genreNameList = rawPage.select("h3");
//            List<Integer> genreNameIndexesList = new ArrayList<>();
//
//            for (int i = 0; i < genreNameList.size(); i++) {
//                Element genreName = rawPage.select("h3").first();
//                int indexGenreNameEl = rawPage.indexOf(genreName);
//                genreNameIndexesList.add(indexGenreNameEl);
//                rawPage.remove(indexGenreNameEl);
//            }
//
//            for (int i = 0; i < genreNameList.size(); i++) {
//                List<Element> genreDescriptionList;
//                StringBuilder sb = new StringBuilder();
//
//                if (i < genreNameList.size() - 1) {
//                    genreDescriptionList = rawPage.subList(genreNameIndexesList.get(i), genreNameIndexesList.get(i + 1));
//                } else {
//                    genreDescriptionList = rawPage.subList(genreNameIndexesList.get(i), rawPage.size());
//                }
//
//                for (Element el : genreDescriptionList) {
//                    sb.append(el.text());
//                }
//
//                String genreName = genreNameList.get(i).text();
//                String genreDetails = sb.toString();
//                genreDescriptionMap.put(genreName, genreDetails);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return genreDescriptionMap;
//    }
//}




//public class Test {
//private static Map<String, String> genreDescriptionMap = new HashMap<>();
//private final String userAgent = "Chrome/92.0.4515.159";
//private final String referrer = "http://www.google.com";
//private final String cssQuery = "#blog-post-content > p, h3, h4";
//private final String elementsCssQuery = "h3";
//private final String subGenreQuery = "h4";
//private final String url = "https://www.idtech.com/blog/different-types-of-video-game-genres";
//
//@Override
//public Map<String, String> parseGenreMap() {
//        return createParsedMap(parsePage(cssQuery, url), createKeysIndexList(parsePage(cssQuery, url), elementsCssQuery), elementsCssQuery);
//        }
//
//public Elements parsePage(String cssQuery, String url) {
//        Elements parsedPage = new Elements();
//
//        try {
//        Document doc = Jsoup.connect(url)
//        .userAgent(userAgent)
//        .referrer(referrer)
//        .get();
//
//        parsedPage = doc.select(cssQuery)
//        .not("[style], h3 > img, [alt], [itemprop], [href=mailto:collegeprep@idtech.com], " +
//        "[href = mailto:privacy@idtech.com], [href = mailto:privacy@idtech.com]");
//
//        return parsedPage;
//
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        return parsedPage;
//        }
//
//public List<Integer> createKeysIndexList(Elements parsedPage, String elementsCssQuery) {
//        List<Integer> keyIndexList = new ArrayList<>();
//        Elements elementsList = parsedPage.select(elementsCssQuery);
//        for (int i = 0; i < elementsList.size(); i++) {
//        int keyIndex = parsedPage.indexOf(parsedPage.select(elementsCssQuery).first());
//        if (!keyIndexList.contains(keyIndex)){
//        keyIndexList.add(keyIndex);
//        parsedPage.remove(keyIndex);
//        }
//        }
//        return keyIndexList;
//        }
//
//public Map<String, String> createParsedMap(Elements parsedPage, List<Integer> keyIndexList, String elementsCssQuery) {
//        Elements keysNames = parsedPage.select(elementsCssQuery);
//        Elements processedPage = parsedPage;
//        List<Element> genreDescriptionList = new ArrayList<>();
//        StringBuilder genreDescription = new StringBuilder();
//
//        for (int i = 0; i < keyIndexList.size(); i++) {
//        if (i < keyIndexList.size() - 1) {
//        genreDescriptionList = processedPage.subList(keyIndexList.get(i) + 1, keyIndexList.get(i + 1));
//        } else {
//        genreDescriptionList = processedPage.subList(keyIndexList.get(i) + 1, processedPage.size());
//        }
//        for (Element el : genreDescriptionList) {
//        genreDescription.append(el.text());
//        }
//        if (keysNames.get(i).text().length() > 2) {
//        genreDescriptionMap.put(keysNames.get(i).text(), genreDescription.toString());
//        }
//        }
//        return genreDescriptionMap;
//        }
//
//// test
//public static void main(String[] args) {
//        GenreParser gp = new GenreParserImpl();
//        Map<String, String> map = gp.parseGenreMap();
//        Set<String> keys = map.keySet();
//        for (String k : keys) {
//        System.out.println(k);
//        System.out.println(map.get(k));
//        }
//        }
//        }