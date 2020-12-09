package com.SpringH2.SpringH2.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringH2.SpringH2.book.BookService;


@Controller
@RequestMapping("/quotes")
public class QuoteController {

	
			@Autowired
			QuoteService quoteservice;
			
			@Autowired
			BookService bookservice;
			
			@RequestMapping("/quotes")
			public String showQuotes (Model model) {
			model.addAttribute("quotes", quoteservice.findAll());
			return "quotes/quotes.html";
			}
			
			 @RequestMapping(value = "/addQuote", method = RequestMethod.GET)
			    public String add(Model model) {

			        model.addAttribute("quote", new Quote());
			        model.addAttribute("books", bookservice.findAll());
			        return "quotes/newQuote";
			    }

			    @RequestMapping(value = "/addQuote", method = RequestMethod.POST)
			    public String processAdd(@ModelAttribute("quote")Quote author, Model model, BindingResult bindingResult) {
			    	
			    	    if (bindingResult.hasErrors()) {
			            return "quotes/quotes";
			        }
			        quoteservice.insertQuote(author);
			        return "quotes/quotes";
			    }
			
			
			@RequestMapping("/deleteQuote")
			public String deleteQuote(@RequestParam("id") Long id, Model model) {
			//public String deleteQuote(@RequestParam("id") String name, Model model) {
			
			Quote quote = new Quote(id);
			//Quote quote = new Quote(id);
			quoteservice.deleteQuote(quote);
			model.addAttribute("quotes", quoteservice.findAll());
			return "quotes/quotes.html";
			}
		
	}
