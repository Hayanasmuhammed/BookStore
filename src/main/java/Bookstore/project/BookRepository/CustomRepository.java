package Bookstore.project.BookRepository;

import org.springframework.stereotype.Repository;

import Bookstore.project.BookReq.BookReq;
@Repository
public interface CustomRepository {
    void updateBook(String id,BookReq req);
}
