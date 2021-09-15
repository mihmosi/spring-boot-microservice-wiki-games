package com.jm.wikigames.parser.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface WebPageParser {
    String userAgent = "Chrome/92.0.4515.159";
    String referrer = "http://www.google.com";

    Map<String, String> createGenreMap();

    default Elements parsePage(String url, String cssQuery) throws IOException {
        return Jsoup
                .connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get()
                .select(cssQuery);
    }

    default Map<String, String> createMap(List<Element> names, List<Element> descriptions) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i).text(), descriptions.get(i).text());
        }
        return map;
    }
}
