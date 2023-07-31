package com.company.Summative1TarikuHewan.controllers;

import com.company.Summative1TarikuHewan.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8BallController {
    private final List<Answer> responses = new ArrayList<>(Arrays.asList(
            new Answer(1, null, "Yes"),
            new Answer(2, null, "It is certain"),
            new Answer(3, null, "Without a doubt"),
            new Answer(4, null, "No"),
            new Answer(5, null, "Don't count on it"),
            new Answer(6, null, "Outlook is not so good")
    ));

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Answer getAnswer(@RequestBody Answer question) {
        Random rand = new Random();
        Answer response = responses.get(rand.nextInt(responses.size()));
        response.setQuestion(question.getQuestion());
        return response;
    }
}
