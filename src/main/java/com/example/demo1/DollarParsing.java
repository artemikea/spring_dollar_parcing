package com.example.demo1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@EnableScheduling
@Service
public class DollarParsing {
    String dollarExchangeRate;

    @Scheduled(fixedDelay = 10000)
    public void parsing() throws IOException {
        Document doc = Jsoup.connect("https://www.cbr.ru/")
                .userAgent("Chrome/102.0.5005.61 Safari/537.36")
                .get();
        Elements dollar = doc.select("#content > div > div > div > div.home-main > div.home-main_aside >" +
                " div > div.main-indicator_rates > div > div:nth-child(2) > div:nth-child(3)");
        if (!dollar.text().isEmpty()) {
            dollarExchangeRate = dollar.text();
        }
        System.out.println(dollarExchangeRate);
    }
}
