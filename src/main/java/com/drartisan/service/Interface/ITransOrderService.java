package com.drartisan.service.Interface;

import com.drartisan.entity.TransOrder;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface ITransOrderService {
    // 创建调货订单
    TransOrder createTransOrder(TransOrder transOrder);

    // 更新订单状态
    TransOrder updateTransOrder(String orderId,String state);

    // 删除订单
    void deleteTransOrder(String orderId);

    // 根据ID获取订单
    TransOrder getOrderById(String orderId);

    // 根据总店获取订单
    Page<TransOrder> getOrderByMainStore(int mainStoreId,String orderId,String orderTimeStart, String orderTimeEnd, int page, int size);

    // 根据分店获取订单
    Page<TransOrder> getOrderByBranchStore(int branchStoreId,String orderId,String orderTimeStart, String orderTimeEnd, int page, int size);



}
