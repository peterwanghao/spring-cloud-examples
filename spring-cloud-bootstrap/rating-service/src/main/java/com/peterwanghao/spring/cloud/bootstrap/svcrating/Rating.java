package com.peterwanghao.spring.cloud.bootstrap.svcrating;

/**   
 * @ClassName:  Rating
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年4月25日 下午2:13:50
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
