package com.drartisan.service;

import com.drartisan.entity.OrderGoods;
import com.drartisan.repository.IOrderGoodsRepository;
import com.drartisan.service.Interface.IOrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by summer on 2017/5/4.
 */
@Service
public class OrderGoodsService implements IOrderGoodsService {

    @Autowired
    IOrderGoodsRepository iOrderGoodsRepository;
    @Autowired
    SubGoodsService subGoodsService;


    @Override
    public List<OrderGoods> findOrderGoodsByOrderId(String orderId) {
        return iOrderGoodsRepository.findOrderGoodsByOrderId(orderId);
    }

    @Override
    public List<OrderGoods> addOrderGoods(String orderId, List<OrderGoods> orderGoodses) {


        for(int i=0; i<orderGoodses.size();i++) {
            orderGoodses.get(i).setOrderId(orderId);
        }
        return  (List<OrderGoods>)iOrderGoodsRepository.save(orderGoodses);
    }
}
