package com.stream.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.stream.app.models.entities.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Long>, JpaSpecificationExecutor<Quote> {

}