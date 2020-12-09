package com.SpringH2.SpringH2.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringH2.SpringH2.quotes.QuoteService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookservice;

	@Autowired
	QuoteService quoteservice;
 

	@RequestMapping("/library")
	public String showBooks(Model model) {
		model.addAttribute("library", bookservice.findAll());
		model.addAttribute("quotes", quoteservice.findAll());
		return "books/library.html";
	}

	
	 @RequestMapping(value = "/addBook", method = RequestMethod.GET)
	    public String add(Model model) {

	        model.addAttribute("book", new Book());
	        model.addAttribute("quotes", quoteservice.findAll());
	        return "books/newBook";
	    }

	    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
	    public String processAdd(@ModelAttribute("book")Book book, Model model, BindingResult bindingResult) {
	    	model.addAttribute("library", bookservice.findAll());
	        if (bindingResult.hasErrors()) {
	            return "books/library";
	        }
	        bookservice.insertBook(book);
	        return "books/library";
	    }
	    

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") Long id, Model model) {

		Book book = new Book(id);
		book.setId(id);
		bookservice.deleteBook(book);
		model.addAttribute("library", bookservice.findAll());
		return "books/library.html";
		
		
		
	}
}