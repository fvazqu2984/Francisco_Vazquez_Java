package com.company.Summative1TarikuHewan.controllers;

import com.company.Summative1TarikuHewan.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/word")
public class WordController {
    private final List<Definition> definitions = new ArrayList<>(Arrays.asList(
            new Definition(1, "Dog", "A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, non-retractable claws, and a barking, howling, or whining voice."),
            new Definition(2, "Book", "A written or printed work consisting of pages glued or sewn together along one side and bound in covers."),
            new Definition(3, "Sunflower", "A tall plant of the daisy family, with large yellow or golden-colored flowers that turn to face the sun."),
            new Definition(4, "Computer", "An electronic device that is capable of receiving information, processing it according to a program, and producing a result."),
            new Definition(5, "Mountain", "A large natural elevation of the earth's surface rising abruptly from the surrounding level; a large steep hill."),
            new Definition(6, "Music", "Vocal or instrumental sounds (or both) combined in such a way as to produce beauty of form, harmony, and expression of emotion."),
            new Definition(7, "Ocean", "A very large expanse of sea, in particular, each of the main areas into which the sea is divided geographically."),
            new Definition(8, "Coffee", "A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."),
            new Definition(9, "Rainbow", "An arch of colors formed in the sky in certain circumstances, caused by the refraction and dispersion of the sun's light by rain or other water droplets."),
            new Definition(10, "Adventure", "An unusual and exciting, typically hazardous, experience or activity.")
            ));

    private Definition getRandomDefinition() {
        Random random = new Random();
        int randomIndex = random.nextInt(definitions.size());
        return definitions.get(randomIndex);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Definition getRandomWord() {
        Definition randomDefinition = getRandomDefinition();
        return new Definition(
                randomDefinition.getId(),
                randomDefinition.getWord(),
                randomDefinition.getDefinition()
        );
    }
}
