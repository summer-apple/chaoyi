package com.drartisan.repository;

import com.drartisan.entity.OrderGoods;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.lang.annotation.Native;
import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface IOrderGoodsRepository extends CrudRepository<OrderGoods,String> {

    List<OrderGoods> findOrderGoodsByOrderId(String orderId);
    List<OrderGoods> findOrderGoodsByOrderIdAndSubGoodsId(String orderId,int subGoodsId);
}
