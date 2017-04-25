package com.drartisan.service;

/**
 * Created by summer on 2017/4/17.
 */
import com.drartisan.entity.User;
import com.drartisan.repository.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IUserRepositoryTest {

    private ApplicationContext ctx = null;
    private IUserRepository us = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        us = (IUserRepository)ctx.getBean("IUserRepository");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindById() {

        User user = us.findById(3);
        System.out.println("id:" + user.getId()
                + " , name:" + user.getUserName()
                + " ,age:" + user.getAge());
    }

    @Test
    public void testFindByUsername() {

        User user = us.findByUserName("admin");
        System.out.println("id:" + user.getId()
                + " , name:" + user.getUserName()
                + " ,age:" + user.getAge());
    }


    @Test
    public void testFindByState() {
        List<User> users = us.findByState("1");

        for(User user:users) {
            System.out.println("id:" + user.getId()
                    + " , name:" + user.getUserName()
                    + " ,age:" + user.getAge());
        }
    }

    
}
