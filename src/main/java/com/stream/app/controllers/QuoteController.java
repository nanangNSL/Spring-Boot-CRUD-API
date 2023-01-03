package com.stream.app.controllers;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stream.app.models.entities.Quote;
import com.stream.app.services.QuotesService;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
    @Autowired
    private QuotesService quotesService;

    @PostMapping
    public ResponseEntity<Quote> saveQuotes(@RequestBody Quote quotes) {
        Quote savedQuotes = quotesService.saveQuotes(quotes);
        return ResponseEntity.ok(savedQuotes);
    }
    
    @PutMapping("/{id}/like")
    public ResponseEntity<Quote> likeQuotes(@PathVariable Long id, @RequestBody String userLike) throws RelationNotFoundException {
        Quote likedQuotes = quotesService.likeQuotes(id, userLike);
        return ResponseEntity.ok(likedQuotes);
    }

    @GetMapping("/api")
    public Page<Quote> getQuotesByChar(@RequestParam(required = false) String character,
                                        @RequestParam(required = false, defaultValue = "ASC") String sort,
                                        @RequestParam(required = false, defaultValue = "0") int page,
                                        @RequestParam(required = false, defaultValue = "10") int size) {
        return quotesService.getQuotesByChar(character, sort, page, size);
    }


}
