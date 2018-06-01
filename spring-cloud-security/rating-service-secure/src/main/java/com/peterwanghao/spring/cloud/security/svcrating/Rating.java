package com.peterwanghao.spring.cloud.security.svcrating;

/**   
 * @ClassName:  Rating
 * @Description:评分对象类
 * @author: wanghao
 * @date:   2018年5月2日 上午10:35:11
 * @version V1.0
 * 
 */
public class Rating {
	private Long id;
	private Long bookId;
	private int stars;

	public Rating() {
	}

	public Rating(Long id, Long bookId, int stars) {
		this.id = id;
		this.bookId = bookId;
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
}
