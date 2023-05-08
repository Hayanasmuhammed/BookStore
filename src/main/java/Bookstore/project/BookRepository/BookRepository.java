package Bookstore.project.BookRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Bookstore.project.BookModel.Book;



public interface BookRepository extends MongoRepository<Book,String> {

}
