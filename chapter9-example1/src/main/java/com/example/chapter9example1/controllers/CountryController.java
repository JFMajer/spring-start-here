package com.example.chapter9example1.controllers;

import com.example.chapter9example1.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(c);
    }

    @GetMapping("/getAll")
    public List<Country> getAll() {
        Country c1 = Country.of("France", 67000000);
        Country c2 = Country.of("Italy", 60000000);
        Country c3 = Country.of("Germany", 83000000);
        Country c4 = Country.of("Spain", 47000000);

        return List.of(c1, c2, c3, c4);
    }
}
