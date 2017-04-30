package com.drartisan.service;

import com.drartisan.entity.Store;
import com.drartisan.entity.TransOrder;
import com.drartisan.repository.IStoreRepository;
import com.drartisan.service.Interface.ITransOrderService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import java.util.HashMap;

/**
 * Created by summer on 2017/4/27.
 */
public class TransOrderServiceTest {

    private ApplicationContext ctx = null;
    private TransOrderService transOrderService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        transOrderService = (TransOrderService)ctx.getBean("transOrderService");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testCreateTransOrder() {

        TransOrder transOrder = new TransOrder("TO134",5,1,"adsfasf","15757135741","滨兴小区",3344.34,"20170427070700",null,null,null,null,null,"0",null);
        TransOrder savedTransOrder = transOrderService.createTransOrder(transOrder);
        Assert.assertEquals("15757135741",savedTransOrder.getAddressPhone());
    }

    @Test
    public void testUpdateTransOrder() {
        TransOrder transOrder = transOrderService.updateTransOrder("TO130","9");
        Assert.assertEquals(transOrder.getState(),"9");
    }


    @Test
    public void testDeleteTransOrder() {
        transOrderService.deleteTransOrder("TO129");
        Assert.assertEquals(transOrderService.getOrderById("TO129"),null);
    }


    @Test
    public void testGetOrderByMainStore() {
        Page<TransOrder> transOrderPage = transOrderService.getOrderByMainStore(1,1,10);

        System.out.println(transOrderPage.getTotalPages());
        System.out.println(transOrderPage.getTotalElements());
        for(TransOrder transOrder:transOrderPage.getContent()) {
            System.out.println(transOrder.getOrderId());
            System.out.println(transOrder.getMainStoreId());
            System.out.println(transOrder.getBranchStoreId());
        }
    }

    @Test
    public void testGetOrderByMainStore2() {
        Page<TransOrder> transOrderPage = transOrderService.getOrderByConditions2(new HashMap<>(),1,10);

        System.out.println(transOrderPage.getTotalPages());
        System.out.println(transOrderPage.getTotalElements());
        for(TransOrder transOrder:transOrderPage.getContent()) {
            System.out.println(transOrder.getOrderId());
            System.out.println(transOrder.getMainStoreId());
            System.out.println(transOrder.getBranchStoreId());
        }
    }



}
