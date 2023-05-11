package Bookstore.project.BookRepository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Bookstore.project.BookModel.Book;



@Repository
public interface BookRepository extends MongoRepository<Book,String> {
	
	@Query("{delete:null}")
	List<Book> findBooksWithoutDelted();
    
    @Query("{shelfNum:?0}")
    List<Book> findByshelfNum(Integer shelfNum);

	
	
	
    
	
     
	
}
