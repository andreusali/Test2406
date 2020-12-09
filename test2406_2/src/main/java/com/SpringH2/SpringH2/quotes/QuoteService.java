package com.SpringH2.SpringH2.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringH2.SpringH2.book.Book;
import com.SpringH2.SpringH2.book.BookRepository;


@Service
public class QuoteService {

	@Autowired
	QuoteRepository repository;

	public Iterable<Quote> findAll() {
	return repository.findAll();
	}
	public void insertQuote(Quote quote) {
	repository.save(quote);
	}
	public void deleteQuote(Quote quote) {
	repository.delete(quote);
	}
}

