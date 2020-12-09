package com.SpringH2.SpringH2.quotes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SpringH2.SpringH2.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="QUOTE")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String quotestring;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "authorid")
	@JsonIgnore
	public Book book;
	
	public Quote(Long id, String quotestring, Book book) {
		super();
		this.id = id;
		this.quotestring = quotestring;
		this.book = book;
	}

	public Quote(Long id) {
		
		
	}
	
	public Quote() {
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuotestring() {
		return quotestring;
	}

	public void setQuotestring(String quotestring) {
		this.quotestring = quotestring;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	
}
