package Bookstore.project.BookController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bookstore.project.BookModel.Book;
import Bookstore.project.BookReq.BookReq;
import Bookstore.project.BookResponse.APIResponse;
import Bookstore.project.BookResponse.BookResponse;
import Bookstore.project.BookResponse.UserResponse;
import Bookstore.project.BookService.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("bookStore")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/addbook")
	public BookResponse addNewBook(@Valid @RequestBody BookReq newBook) {
		return bookService.addNewBook(newBook);
//	   UserResponse userResponse = new UserResponse();
//       String d= bookService.add(newBook);
//       userResponse.setResponse(d);
//	   return userResponse;
	}

	@GetMapping("allbooks")
//	public List<BookResponse> getAllUser() {
//		return bookService.disp();
//	}
	public APIResponse<List<BookResponse>> getAllBook(){
		List<BookResponse> allBooks=bookService.getAllBook();
		return new APIResponse<>(allBooks.size(),allBooks);
		
	}

	@DeleteMapping("/{_id}")
	public UserResponse deleteBook(@PathVariable String _id) {
		String b = bookService.deleteBook(_id);
		UserResponse userResponse = new UserResponse(b);
		return userResponse;
	}

	@PutMapping("/{_id}")
	public UserResponse updateBook(@RequestBody BookReq book, @PathVariable String _id) {
		
		String b = bookService.updateBook(book, _id);
		UserResponse userResponse = new UserResponse();
		return userResponse;
	}

	@GetMapping("/{shelfNum}")
	public List<BookResponse> findByShelfNo(@PathVariable Integer shelfNum) {
		
		return bookService.findByShelfNo(shelfNum);
	}

	@GetMapping("/Paging/{pageNumber}/{pageSize}")
	public APIResponse<List<BookResponse>> findBookWithPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
		List<BookResponse> bookWithPagination= bookService.findBookWithPagination(pageNumber, pageSize);
		return new APIResponse<>(bookWithPagination.size(),bookWithPagination);
		
	}
	
	@GetMapping("/sort/{pageNo}/{pageSize}/{field}")
	public APIResponse<List<BookResponse>> findBookWithSorting(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@PathVariable String field,@RequestParam(defaultValue="DESC",required=false,name="value") String value){
		List<BookResponse> allBooks=bookService.findBookWithSorting(pageNo,pageSize,field,value);
		return new APIResponse<>(allBooks.size(),allBooks);
	}
	
		
	
	
//	@GetMapping("/sorting/{pageNo}/{pageSize}")
//	public Page<Book> getBooks(@PathVariable Integer pageNo,
//			@PathVariable Integer pageSize, @RequestParam(defaultValue="rate"  ) String sortBy) {
//		return bookService.getBooks(pageNo, pageSize, sortBy);
//	}
//
//	@GetMapping("/sortingwithaddedtime")
//	public Iterable<Book> findBooks(
//			@RequestParam(name = "pageNo") Integer pageNo,
//		@RequestParam(name = "pageSize")Integer pageSize,
//			@RequestParam (defaultValue="addedTime") String sortBy) {
//		return bookService.findBooks(sortBy);
//	}

}
