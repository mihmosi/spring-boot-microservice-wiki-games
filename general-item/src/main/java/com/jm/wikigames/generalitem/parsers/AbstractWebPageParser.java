package com.jm.wikigames.generalitem.parsers;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;

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
}
