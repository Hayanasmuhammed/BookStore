package Bookstore.project.BookModel;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Book {
	@Id
	private String id;
    private String name;
    private Integer year;
    private String author;
    private Integer rate;
    private Integer shelfNum;
	private String catogory;
	private LocalDateTime delete;
	private LocalDateTime addedTime;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String name, Integer year, String author, Integer rate, Integer shelfNum, String catogory,
			LocalDateTime delete, LocalDateTime addedTime) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.author = author;
		this.rate = rate;
		this.shelfNum = shelfNum;
		this.catogory = catogory;
		this.delete = delete;
		this.addedTime = addedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getShelfNum() {
		return shelfNum;
	}

	public void setShelfNum(Integer shelfNum) {
		this.shelfNum = shelfNum;
	}

	public String getCatogory() {
		return catogory;
	}

	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}

	public LocalDateTime getDelete() {
		return delete;
	}

	public void setDelete(LocalDateTime delete) {
		this.delete = delete;
	}

	public LocalDateTime getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(LocalDateTime addedTime) {
		this.addedTime = addedTime;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", year=" + year + ", author=" + author + ", rate=" + rate
				+ ", shelfNum=" + shelfNum + ", catogory=" + catogory + ", delete=" + delete + ", addedTime="
				+ addedTime + "]";
	}

	

}
