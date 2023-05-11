package Bookstore.project.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import Bookstore.project.BookModel.Book;
import Bookstore.project.BookReq.BookReq;
@Component
public class CustomRepositoryImpl implements CustomRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	public void updateBook(String id,BookReq req) {
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("name", req.getName());
		update.set("year", req.getYear());
		update.set("author", req.getAuthor());
		update.set("rate", req.getRate());
		update.set("shelfNum", req.getShelfNum());
		update.set("catogory", req.getCatogory());
		
		mongoTemplate.updateFirst(query, update, Book.class);
		
	}

}
