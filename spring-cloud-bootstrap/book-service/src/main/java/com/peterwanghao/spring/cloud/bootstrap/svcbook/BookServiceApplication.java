package com.peterwanghao.spring.cloud.bootstrap.svcbook;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  BookServiceApplication
 * @Description:业务系统-图书服务
 * @author: wanghao
 * @date:   2018年4月25日 下午1:33:11
 * @version V1.0
 * 
 * @Copyright: 2018 www.viewhigh.com Inc. All rights reserved.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/books")
public class BookServiceApplication {
	public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }
 
    private List<Book> bookList = Arrays.asList(
        new Book(1L, "Spring Cloud微服务实战", "翟永超"),
        new Book(2L, "Mastering Spring Cloud", "Piotr Mińkowski")
    );
 
    @GetMapping("")
    public List<Book> findAllBooks() {
        return bookList;
    }
 
    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
    }
}
