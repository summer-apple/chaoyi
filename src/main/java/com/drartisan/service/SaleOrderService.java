package com.drartisan.service;

import com.drartisan.entity.OrderGoods;
import com.drartisan.entity.SaleOrder;
import com.drartisan.repository.ISaleOrderRepository;
import com.drartisan.repository.jpaUtils.Criteria;
import com.drartisan.repository.jpaUtils.Restrictions;
import com.drartisan.service.Interface.ISaleOrderService;
import com.drartisan.util.CommonUtil;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by summer on 2017/4/27.
 */
@Service
public class SaleOrderService implements ISaleOrderService {


    @Autowired
    ISaleOrderRepository iSaleOrderRepository;
    @Autowired
    OrderGoodsService orderGoodsService;


    /**
     * 新增订单
     * @param saleOrder
     * @return
     */
    @Override
    @Transactional
    public SaleOrder createSaleOrder(SaleOrder saleOrder) {



        String createTime = CommonUtil.getCurrentDatetimeStr();
        String randomStr = CommonUtil.getRandomString(10);
        saleOrder.setCreateTime(createTime);
        saleOrder.setOrderId("S"+createTime+randomStr);
        saleOrder.setState("1");


        List<OrderGoods> orderGoodsList = saleOrder.getOrderGoodses();

        //计算总价
        double totalPrice = 0;
        for(int i=0; i<orderGoodsList.size();i++) {
            OrderGoods orderGoods = orderGoodsList.get(i);
            totalPrice += orderGoods.getPrice() * orderGoods.getQuantity();
        }
        saleOrder.setTotalPrice(totalPrice);


        saleOrder  = iSaleOrderRepository.save(saleOrder);

        orderGoodsList = orderGoodsService.addOrderGoods(saleOrder.getOrderId(),orderGoodsList);

        saleOrder.setOrderGoodses(orderGoodsList);
        return saleOrder;
    }


    @Override
    @Transactional
    public SaleOrder updateSaleOrder(String orderId, String state) {
        SaleOrder saleOrder = iSaleOrderRepository.findOne(orderId);
        saleOrder.setState(state);
        // TODO 根据订单状态，修改总店和分店的库存情况

        return iSaleOrderRepository.save(saleOrder);
    }

    @Override
    public void deleteSaleOrder(String orderId) {
        iSaleOrderRepository.delete(orderId);
    }

    @Override
    public SaleOrder getOrderById(String orderId) {
        return iSaleOrderRepository.findOne(orderId);
    }


    @Override
    public Page<SaleOrder> getOrderByBranchStore(int branchStoreId,String orderId,String orderTimeStart, String orderTimeEnd, int page, int size) {

       Criteria<SaleOrder> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("branchStoreId",branchStoreId,false));
        criteria.add(Restrictions.like("orderId",orderId, MatchMode.ANYWHERE,true));
        criteria.add(Restrictions.gte("createTime",orderTimeStart,true));
        criteria.add(Restrictions.lte("createTime",orderTimeEnd,true));
        // TODO 订单状态

        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"state");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"createTime");
        orders.add(order2);
        orders.add(order1);

        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page-1,size,sort);

        Page<SaleOrder> saleOrderPage =  iSaleOrderRepository.findAll(criteria, pageable);

        for(SaleOrder saleOrder:saleOrderPage){
            saleOrder.setOrderGoodses(orderGoodsService.findOrderGoodsByOrderId(saleOrder.getOrderId()));
        }
        return saleOrderPage;

    }







}
