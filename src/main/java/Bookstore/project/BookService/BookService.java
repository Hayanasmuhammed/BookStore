package Bookstore.project.BookService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Bookstore.project.BookModel.Book;
import Bookstore.project.BookRepository.BookRepository;


@Service
public class BookService {
   
	 @Autowired
	 private BookRepository bookRepo;
	 
	 public Book add(Book book) {
		
			return bookRepo.save(book);
		 
	 }

	public List<Book> disp() {
		List<Book> res = new ArrayList<>();
		List<Book> userList = bookRepo.findAll();

		Iterator<Book> iterator = userList.iterator();

		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			if (book.getDelete() == null) {
				res.add(book);
			}

		}

		return res;
		
	}

	public String del(String id) {
		Optional<Book> b=bookRepo.findById(id);
		if(!b.isPresent()) {
			return "book with provided id is not present";
		}
		else {
			 Book book=b.get();
			 if(book.getDelete() !=null) {
				 return "already deleted";
			 }
			 else {
				 
		       book.setDelete(LocalDateTime.now());
		       bookRepo.save(book);
		       return "deleted";
		}
	}
	}
	public Book upd(Book br,String id) {
		
		Optional<Book> b=bookRepo.findById(id);
		Book book=b.get();
		book.setName(br.getName());
		book.setYear(br.getYear());
		book.setAuthor(br.getAuthor());
		book.setRate(br.getRate());
		book.setShelfNum(br.getShelfNum());
		book.setCatogory(br.getCatogory());
		return bookRepo.save(book);
		
	
	}

	
}
