package com.peterwanghao.spring.cloud.bootstrap.svcbook;

/**   
 * @ClassName:  Book
 * @Description:图书对象类
 * @author: wanghao
 * @date:   2018年4月25日 下午1:40:26
 * @version V1.0
 * 
 * @Copyright: 2018 www.viewhigh.com Inc. All rights reserved.
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
