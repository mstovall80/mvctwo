package com.stovall.mvctwo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stovall.mvctwo.models.Book;
import com.stovall.mvctwo.repositories.BookRepository;



@Service
public class BookServices {

	 // adding the book repository as a dependency
   private final BookRepository bookRepository;
   public BookServices(BookRepository bookRepository) {
       this.bookRepository = bookRepository;
   }
   // returns all the books
   public List<Book> allBooks() {
       return bookRepository.findAll();
   }
   // creates a book
   public Book createBook(Book book) {
	   
       return bookRepository.save(book);
   }
   public Book updateBook(Book b) {
   	return bookRepository.save(b);
   }
   public void deleteBook(Long id) {
   	bookRepository.deleteById(id);
   }
   // retrieves a book
   public Book findBook(Long id) {
       Optional<Book> optionalBook = bookRepository.findById(id);
       if(optionalBook.isPresent()) {
           return optionalBook.get();
       } else {
           return null;
       }
   }

}