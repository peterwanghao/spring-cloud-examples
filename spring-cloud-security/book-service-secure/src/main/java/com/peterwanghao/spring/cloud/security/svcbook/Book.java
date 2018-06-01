package com.peterwanghao.spring.cloud.security.svcbook;

/**   
 * @ClassName:  Book
 * @Description:图书对象类
 * @author: wanghao
 * @date:   2018年5月2日 上午10:26:50
 * @version V1.0
 * 
 */
public class Book {
	private Long id;
	private String author;
	private String title;

	public Book() {
	}

	public Book(Long id, String author, String title) {
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
