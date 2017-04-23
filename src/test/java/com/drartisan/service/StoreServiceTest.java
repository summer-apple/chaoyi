package com.drartisan.service;

/**
 * Created by summer on 2017/4/17.
 */
import com.drartisan.entity.Store;
import com.drartisan.entity.User;
import com.drartisan.repository.StoreRepository;
import com.drartisan.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StoreServiceTest {

    private ApplicationContext ctx = null;
    private StoreService storeService = null;
    private StoreRepository storeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        storeService = (StoreService)ctx.getBean("storeService");
        storeRepository = (StoreRepository)ctx.getBean("storeRepository");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindByMainStore() {
        System.out.println("assssssss");

        Store store = storeService.findByMainStore(0);

        System.out.println(null == store);

        System.out.println("store id:" + store.getStoreId()
                + " , store name:" + store.getStoreName()
                + " ,ownner:" + store.getOwner());


        System.out.println("nnnnn");
    }

//    @Test
//    public void testFindByUsername() {
//
//        User user = us.findByUsername("admin");
//        System.out.println("id:" + user.getId()
//                + " , name:" + user.getUsername()
//                + " ,age:" + user.getAge());
//    }
//
//
//    @Test
//    public void testFindByState() {
//        List<User> users = us.findByState("1");
//
//        for(User user:users) {
//            System.out.println("id:" + user.getId()
//                    + " , name:" + user.getUsername()
//                    + " ,age:" + user.getAge());
//        }
//    }

    
}
