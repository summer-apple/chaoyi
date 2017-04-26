package com.drartisan.service.Interface;

import com.drartisan.entity.OrderGoods;
import com.drartisan.entity.StockGoods;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface IOrderGoodsService {

    // 根据订单ID获取订单商品
    List<OrderGoods> findOrderGoodsByOrderId(String orderId);

    // 新增订单商品
    Boolean addOrderGoods(List<OrderGoods> orderGoodses);


}
