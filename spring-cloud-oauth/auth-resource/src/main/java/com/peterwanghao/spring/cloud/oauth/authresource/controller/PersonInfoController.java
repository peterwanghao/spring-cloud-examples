package com.peterwanghao.spring.cloud.oauth.authresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterwanghao.spring.cloud.oauth.authresource.model.Person;

/**   
 * @ClassName:  PersonInfoController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午2:43:05
 * @version V1.0
 * 
 */
@RestController
public class PersonInfoController {

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody Person personInfo() {
        return new Person("peter", "Beijing", "China", 29, "Male");
    }   
}
