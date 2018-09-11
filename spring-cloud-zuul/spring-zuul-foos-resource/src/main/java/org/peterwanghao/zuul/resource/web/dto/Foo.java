package org.peterwanghao.zuul.resource.web.dto;

/**   
 * @ClassName:  Foo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午9:36:53
 * @version V1.0
 * 
 */
public class Foo {
	private long id;
	private String name;

	public Foo() {
		super();
	}

	public Foo(final long id, final String name) {
		super();

		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
