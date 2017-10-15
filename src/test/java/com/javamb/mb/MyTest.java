package com.javamb.mb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javamb.mb.service.UserService;
import com.javamb.mb.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-mysql-db.xml")
public class MyTest {
    
    @Autowired
    UserService userService;
    
    @Test
    public void test1() {
        List<UserVO> list = userService.findUser();
        System.out.println(list);
    }
    
    @Test
    public void test2() {
        UserVO userVO = new UserVO();
        userVO.setPassword("123");
        userVO.setSex(0);
        userVO.setUsername("jack1");
        userService.addUser(userVO);
    }
}
