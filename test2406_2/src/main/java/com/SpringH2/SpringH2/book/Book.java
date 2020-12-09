package com.SpringH2.SpringH2.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SpringH2.SpringH2.quotes.Quote;

@Entity
@Table(name="BOOK")

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Long id;
	public String title;
	public String isbn;
	public int pages;
	public int year;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//	, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Quote> quotes = new ArrayList<Quote>();
	
	public Book() {
			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}



}
