package parsers.impl;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.jm.wikigames.generalitem.parsers.GenreParser;
import java.io.IOException;
import java.util.*;

@Data
public class GenreParserImpl implements GenreParser {
    private Map<String, String> genreDescriptionMap = new HashMap<>();
    private final String userAgent = "Chrome/92.0.4515.159";
    private final String referrer = "http://www.google.com";

    @Override
    public Map<String, String> parseGenreMap(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .referrer(referrer)
                    .get();

            Elements rawPage = doc.select("#blog-post-content > p, h3, h4")
                    .not("[style], [itemprop], [href=mailto:collegeprep@idtech.com], " +
                            "[href = mailto:privacy@idtech.com], [href = mailto:privacy@idtech.com]");

            Elements genreNameList = rawPage.select("h3");
            List<Integer> genreNameIndexesList = new ArrayList<>();

            for (int i = 0; i < genreNameList.size(); i++) {
                Element genreName = rawPage.select("h3").first();
                int indexGenreNameEl = rawPage.indexOf(genreName);
                genreNameIndexesList.add(indexGenreNameEl);
                rawPage.remove(indexGenreNameEl);
            }

            for (int i = 0; i < genreNameList.size(); i++) {
                List<Element> genreDescriptionList;
                StringBuilder sb = new StringBuilder();

                if (i < genreNameList.size() - 1) {
                    genreDescriptionList = rawPage.subList(genreNameIndexesList.get(i), genreNameIndexesList.get(i + 1));
                } else {
                    genreDescriptionList = rawPage.subList(genreNameIndexesList.get(i), rawPage.size());
                }

                for (Element el : genreDescriptionList) {
                    sb.append(el.text());
                }

                String genreName = genreNameList.get(i).text();
                String genreDetails = sb.toString();
                genreDescriptionMap.put(genreName, genreDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return genreDescriptionMap;
    }
}


/*
 // test
    public static void main(String[] args) {
        GenreParser gp = new GenreParserImpl();
        Map<String, String> map = gp.parseGenreMap("https://www.idtech.com/blog/different-types-of-video-game-genres");
        Set<String> keys = map.keySet();
        for (String k : keys         ) {
            System.out.println(k);
            System.out.println(map.get(k));
        }
    }
 */
