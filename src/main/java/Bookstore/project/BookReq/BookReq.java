package Bookstore.project.BookReq;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookReq {
    
	@NotBlank(message="Book name is not blank")
	private String name;
	@NotNull(message="enter book year")
	private Integer year;
    @NotBlank(message="Author name is not blank")
	private String author;
    @NotNull(message="enter rate")
	private Integer rate;
    @NotNull(message="enter shelfnum")
	private Integer shelfNum;
	private String catogory;
	public BookReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookReq(String name, Integer year, String author, Integer rate, Integer shelfNum, String catogory) {
		super();
		this.name = name;
		this.year = year;
		this.author = author;
		this.rate = rate;
		this.shelfNum = shelfNum;
		this.catogory = catogory;
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
	
	@Override
	public String toString() {
		return "BooqReq [name=" + name + ", year=" + year + ", author=" + author + ", rate=" + rate + ", shelfNum="
				+ shelfNum + ", catogory=" + catogory + "]";
	}

	
	
}
