package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class SimpleParser implements Parser {

    private final Logger logger = LogManager.getLogger(SimpleParser.class.getName());

    private Map<String, Integer> mapMonthStringInteger = Map.ofEntries(
            Map.entry("янв", 1),
            Map.entry("фев", 2),
            Map.entry("мар", 3),
            Map.entry("апр", 4),
            Map.entry("май", 5),
            Map.entry("июн", 6),
            Map.entry("июл", 7),
            Map.entry("авг", 8),
            Map.entry("сен", 9),
            Map.entry("окт", 10),
            Map.entry("ноя", 11),
            Map.entry("дек", 12)
    );

    @Override
    public Set<Vacancy> parse(String url, Set<Timestamp> setDate) {
        int i = 1;
        Set<Vacancy> result = new HashSet<>();
        List<Vacancy> countVacanciesOnPage = new ArrayList<>();
        try {
            do {
                countVacanciesOnPage.clear();
                String urlJobOffers = String.format("%s/%s", url, i);
                Document document = Jsoup.connect(urlJobOffers).get();
                Elements links = document.select("a[href]");
                for (Element link : links) {
                    if (link.attr("href").contains("java") && !link.attr("href").contains("script")) {
                        int currentYear = LocalDateTime.now().getYear();
                        if (!setDate.isEmpty()) {
                            if (setDate.contains(getCreateDate(link.attr("href")))) {
                                break;
                            }
                        }
                        if (getCreateDate(link.attr("href")).toString().contains(
                                String.valueOf(currentYear))) {
                            logger.info("New vacancy found.");
                            countVacanciesOnPage.add(new Vacancy(
                                    getName(link.attr("href")),
                                    getText(link.attr("href")),
                                    link.attr("href"),
                                    getCreateDate(link.attr("href")))
                            );
                        }
                    }
                }
                result.addAll(countVacanciesOnPage);
                logger.info("On page {} {} new vacancies.", urlJobOffers, countVacanciesOnPage.size());
                i++;
            } while (!(countVacanciesOnPage.size() == 0));

        } catch (IOException ioe) {
            logger.error(ioe.getMessage(), ioe);
        }
        return result;
    }

    private String getName(String url) throws IOException {
        String result = "";
        Document document = Jsoup.connect(url).get();
        if (document != null) {
            result = document.title().split(" / ")[0].trim();
        }
        return result;
    }

    private String getText(String url) throws IOException {
        String text = "";
        Document document = Jsoup.connect(url).get();
        if (document != null) {
            Elements el = document.getElementsByClass("msgBody");
            if (el != null) {
                text = el.get(1).text();
            }
        }
        return text;
    }

    private Timestamp getCreateDate(String url) throws IOException {
        Timestamp createDate = null;
        Document doc = Jsoup.connect(url).get();
        if (doc != null) {
            Elements el = doc.getElementsByClass("msgFooter");
            if (el != null) {
                String[] a = el.get(0).text().split("\\[");
                createDate = convert(a[0].trim());
            }
        }
        return createDate;
    }

    private Timestamp convert(String date) {
        String result = "";
        String[] splitYearAndTime = date.split(", ");
        String[] splitYearMonthDay = splitYearAndTime[0].split(" ");
        if (splitYearMonthDay.length == 3) {
            result = String.format(
                    "%s-%s-%s %s:%s",
                    Integer.parseInt(splitYearMonthDay[2]) + 2000,
                    mapMonthStringInteger.get(splitYearMonthDay[1]),
                    Integer.parseInt(splitYearMonthDay[0]),
                    splitYearAndTime[1],
                    "00.0");
        } else if (splitYearAndTime[0].contains("сегодня")) {
            LocalDateTime ldt = LocalDateTime.now();
            result = String.format(
                    "%s-%s-%s %s:%s",
                    ldt.getYear(),
                    ldt.getMonth().getValue(),
                    ldt.getDayOfMonth(),
                    splitYearAndTime[1],
                    "00.0"
            );
        } else {
            LocalDateTime ldt = LocalDateTime.now().minusDays(1);
            result = String.format(
                    "%s-%s-%s %s:%s",
                    ldt.getYear(),
                    ldt.getMonth().getValue(),
                    ldt.getDayOfMonth(),
                    splitYearAndTime[1],
                    "00.0"
            );
        }
        return Timestamp.valueOf(result);
    }
}
