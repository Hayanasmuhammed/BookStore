package Bookstore.project.BookService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Service;

import Bookstore.project.BookModel.Book;
import Bookstore.project.BookRepository.BookRepository;
import Bookstore.project.BookRepository.CustomRepository;

import Bookstore.project.BookReq.BookReq;
import Bookstore.project.BookResponse.BookResponse;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private CustomRepository customRepo;

	public BookResponse addNewBook(BookReq book) {

		Book br = new Book(null, book.getName(), book.getYear(), book.getAuthor(), book.getRate(), book.getShelfNum(),
				book.getCatogory(), null, LocalDateTime.now());
		bookRepo.save(br);

		BookResponse res = new BookResponse(br.getId(), br.getName(), br.getYear(), br.getAuthor(), br.getRate(),
				br.getShelfNum(), br.getCatogory(), br.getAddedTime());

		return res;

	}

	public List<BookResponse> getAllBook() {
		List<BookResponse> res = new ArrayList<>();
		List<Book> userList = bookRepo.findBooksWithoutDelted();
		Iterator<Book> iterator = userList.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			BookResponse br = new BookResponse(book.getId(), book.getName(), book.getYear(), book.getAuthor(),
					book.getRate(), book.getShelfNum(), book.getCatogory(), book.getAddedTime());
			res.add(br);
		}

		return res;

	}

	public String deleteBook(String _id) {
		Optional<Book> b = bookRepo.findById(_id);
		if (!b.isPresent()) {
			return "book with provided id is not present";
		} else {
			Book book = b.get();
			if (book.getDelete() != null) {
				return "already deleted";
			} else {

				book.setDelete(LocalDateTime.now());
				bookRepo.save(book);
				return "deleted";
			}
		}
	}

	public String updateBook(BookReq br, String id) {

		customRepo.updateBook(id, br);
		return "updated";
//		Optional<Book> b=bookRepo.findById(id);
//		Book book=b.get();
//		book.setName(br.getName());
//		book.setYear(br.getYear());
//		book.setAuthor(br.getAuthor());
//		book.setRate(br.getRate());
//		book.setShelfNum(br.getShelfNum());
//		book.setCatogory(br.getCatogory());
//		bookRepo.save(book);
//		

	}

	public List<BookResponse> findByShelfNo(Integer shelfNum) {
		List<Book> userList = bookRepo.findByshelfNum(shelfNum);
		List<BookResponse> res = new ArrayList<>();
		Iterator<Book> iterator = userList.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			BookResponse br = new BookResponse(book.getId(), book.getName(), book.getYear(), book.getAuthor(),
					book.getRate(), book.getShelfNum(), book.getCatogory(), book.getAddedTime());
			res.add(br);
		}
		return res;

	}

	public List<BookResponse> findBookWithPagination(Integer pageNo, Integer pageSize) {
		Page<Book> books = bookRepo.findAll(PageRequest.of(pageNo, pageSize));
		List<BookResponse> res = new ArrayList<>();
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			BookResponse br = new BookResponse(book.getId(), book.getName(), book.getYear(), book.getAuthor(),
					book.getRate(), book.getShelfNum(), book.getCatogory(), book.getAddedTime());
			res.add(br);
		}

		return res;
//		Pageable paging = PageRequest.of(pageNo, pageSize);
//		Page<Book> allProducts = bookRepo.findAll(paging);
//		return allProducts;

	}

	public List<BookResponse> findBookWithSorting(Integer pageNo, Integer pageSize, String field, String value) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Direction.fromString(value), field));
		Page<Book> result = bookRepo.findAll(paging);
		List<BookResponse> res = new ArrayList<>();
		Iterator<Book> iterator = result.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			BookResponse br = new BookResponse(book.getId(), book.getName(), book.getYear(), book.getAuthor(),
					book.getRate(), book.getShelfNum(), book.getCatogory(), book.getAddedTime());
			res.add(br);
		}
		return res;
//				
	}

//
//	public Page<Book> getBooks(Integer pageNo, Integer pageSize, String sortBy) {
//		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
//		Page<Book> result = bookRepo.findAll(paging);
//		return result;
//
//	}
//
//	public Iterable<Book> findBooks(String sortBy) {
//
//		Sort sort = Sort.by(Direction.DESC, "addedTime");
//		Iterable<Book> result = bookRepo.findAll(sort);
//		return result;
//	}

}
