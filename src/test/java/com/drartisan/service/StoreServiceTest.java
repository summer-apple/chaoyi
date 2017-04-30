package com.drartisan.service;

/**
 * Created by summer on 2017/4/17.
 */
import com.drartisan.entity.Store;
import com.drartisan.repository.IStoreRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

public class StoreServiceTest {

    private ApplicationContext ctx = null;
    private StoreService storeService = null;
    private IStoreRepository storeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        storeService = (StoreService)ctx.getBean("storeService");
        storeRepository = (IStoreRepository)ctx.getBean("IStoreRepository");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testSave() {

        Store store = new Store();
        store.setOwner("lalalla");
        store.setAddress("杭州。。。。");
        store.setUsername("summer");
        store.setPassword("summer");
        store.setMainStore(0);

        storeService.save(store);
        System.out.println("store id:" + store.getStoreId()
                + " , store name:" + store.getStoreName()
                + " ,ownner:" + store.getOwner()
                + " ,address: " + store.getAddress());
    }


    @Test
    public void testFindByMainStore() {

        Page<Store> stores = storeService.findByMainStore(0,0,10);
        for(Store store :stores) {
            System.out.println("store id:" + store.getStoreId()
                    + " , store name:" + store.getStoreName()
                    + " ,ownner:" + store.getOwner());
        }
    }

    @Test
    public void testFindByStoreId() {

        Store store = storeService.findByStoreId(1);
        System.out.println("store id:" + store.getStoreId()
                + " , store name:" + store.getStoreName()
                + " ,ownner:" + store.getOwner());
    }



    @Test
    public void testLogin() {
        Store store = storeService.login("summer","summer");
        if(null != store) {
            System.out.println("store id:" + store.getStoreId()
                    + " , store name:" + store.getStoreName()
                    + " ,ownner:" + store.getOwner());
        }else{
            System.out.println("用户名或密码错误！");
        }
    }



    @Test
    public void testUpdate() {

        Store store = storeService.findByStoreId(1);
        store.setOwner("xiadong");
        store.setAddress("杭州滨江");
        store.setStoreName("楼塔总部");
        storeService.save(store);
        System.out.println("store id:" + store.getStoreId()
                + " , store name:" + store.getStoreName()
                + " ,ownner:" + store.getOwner()
                + " ,address: " + store.getAddress());
    }

    @Test
    public void testFindCountByUsername(){
        int count = storeRepository.findByUsernameCount("xiadong");
        System.out.println(count);
    }




    
}
