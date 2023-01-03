package com.stream.app.services;

import jakarta.persistence.criteria.Predicate;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stream.app.models.entities.Quote;
import com.stream.app.models.repository.QuotesRepository;

@Service
public class QuotesService {
    
    @Autowired
    private QuotesRepository quotesRepository;

    public Quote saveQuotes(Quote quotes) {
        return quotesRepository.save(quotes);
    }

    public Quote likeQuotes(Long quotesId, String userLike) throws RelationNotFoundException {
        Quote quotes = quotesRepository.findById(quotesId).orElse(null);
        if (quotes == null) {
            throw new RelationNotFoundException("Quotes with ID " + quotesId + " not found");
        }

        if (quotes.getLikes().contains(userLike)) {
            quotes.getLikes().remove(userLike);
        } else {
            quotes.getLikes().add(userLike);
        }

        return quotesRepository.save(quotes);
    }

    public Page<Quote> getQuotesByChar(String character, String sort, int page, int size) {
        Sort.Direction direction = "ASC".equalsIgnoreCase(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        return quotesRepository.findAll((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (character != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("quote"), character + "%"));
            }
            return predicate;
        }, PageRequest.of(page, size, Sort.by(direction, "quote")));
    }
    
}
