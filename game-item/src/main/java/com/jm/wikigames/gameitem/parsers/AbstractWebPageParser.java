package com.jm.wikigames.gameitem.parsers;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public abstract class AbstractWebPageParser {
    private final String userAgent = "Chrome/92.0.4515.159";
    private final String referrer = "http://www.google.com";


    public Elements parsePage(String url, String cssQuery) throws IOException {
        return Jsoup
                .connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get()
                .select(cssQuery);
    }


    public Map<String, String> createMap(List<Element> names, List<Element> descriptions) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i).text(), descriptions.get(i).text());
        }
        return map;
    }
}
