package com.company.Summative1TarikuHewan.controllers;

import com.company.Summative1TarikuHewan.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final List<Quote> quotes = new ArrayList<>(Arrays.asList(
            new Quote(1, "Neil Armstrong", "That’s one small step for a man, a giant leap for mankind." ),
            new Quote(2, "Franklin D. Roosevelt", "The only thing we have to fear is fear itself." ),
            new Quote(3, "Benjamin Franklin", "Nothing is certain except for death and taxes." ),
            new Quote(4, "Sir Francis Bacon", "Knowledge is power." ),
            new Quote(5, "Michael Jordan", "I can accept failure, everyone fails at something. But I can't accept not trying." ),
            new Quote(6, "Walt Disney", "The way to get started is to quit talking and begin doing." ),
            new Quote(7, "Winston Churchill", "Success is stumbling from failure to failure with no loss of enthusiasm" ),
            new Quote(8, "Napoleon Hill", "Life is what we make it and how we make it – whether we realize it or not." ),
            new Quote(9, "Barack Obama", "Don't let anyone tell you what you can't do. Follow your dreams and persist." ),
            new Quote(10, "Steve Jobs", "Your time is limited, don't waste it living someone else's life." )
    ));

    private Quote getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Quote getQuoteOfTheDay() {
        Quote randomQuote = getRandomQuote();
        return new Quote(
                randomQuote.getId(),
                randomQuote.getAuthor(),
                randomQuote.getQuote()
        );
    }
}
