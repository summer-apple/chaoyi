package com.drartisan.service.Interface;

import com.drartisan.entity.SaleOrder;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface ISaleOrderService {


    // 创建调货订单
    SaleOrder createSaleOrder(SaleOrder saleOrder);

    // 查询分店销售订单
    Page<SaleOrder> getOrderByBranchStore(int branchStoreId, String orderId, String orderTimeStart, String orderTimeEnd, int page, int size);

    // 更新订单状态
    SaleOrder updateSaleOrder(String orderId,String state);

    // 删除订单
    void deleteSaleOrder(String orderId);

    // 根据ID获取订单
    SaleOrder getOrderById(String orderId);



    // 支付订单

    // 支付成功

    // 支付失败

    // 预支付订单生成

}
