package com.peterwanghao.spring.cloud.bootstrap.svcrating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  RatingServiceApplication
 * @Description:业务系统-评分服务
 * @author: wanghao
 * @date:   2018年4月25日 下午2:12:05
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/ratings")
public class RatingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

	private List<Rating> ratingList = Arrays.asList(new Rating(1L, 1L, 2), new Rating(2L, 1L, 3), new Rating(3L, 2L, 4),
			new Rating(4L, 2L, 5));

	@GetMapping("")
	public List<Rating> findRatingsByBookId(@RequestParam Long bookId) {
		return bookId == null || bookId.equals(0L) ? Collections.emptyList()
				: ratingList.stream().filter(r -> r.getBookId().equals(bookId)).collect(Collectors.toList());
	}

	@GetMapping("/all")
	public List<Rating> findAllRatings() {
		return ratingList;
	}
}
