package Bookstore.project.BookController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Bookstore.project.BookModel.Book;
import Bookstore.project.BookService.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("BookStore")
public class BookController {
   @Autowired
   private BookService bookService;
   
   @PostMapping("/addbook")
   Book newBook(@Valid @RequestBody Book newBook) {
       return bookService.add(newBook);
	}
   
   @GetMapping("allbooks")
 
  public List<Book> getAllUser(){
      return bookService.disp(); 
   }  
   
   

   @DeleteMapping("{id}")
    
   public String del(@PathVariable String id) {
	   return bookService.del(id);
   }
   
   
   
   @PutMapping("{id}")
   
   public Book upd(@RequestBody Book book,@PathVariable String id) {
	   
	   return bookService.upd(book,id);
   }
   
}
   

