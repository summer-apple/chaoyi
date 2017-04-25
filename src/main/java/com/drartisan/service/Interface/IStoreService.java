package com.drartisan.service.Interface;

import com.drartisan.entity.SaleOrder;
import com.drartisan.entity.Store;

import java.util.List;

/**
 * Created by summer on 2017/4/23.
 */
public interface IStoreService {

    //登录
    Store login(String username,String password);


    //新增或更新店铺
    Store save(Store store);


    //查询分店
    List<Store> findByMainStore(int mainStore);


    // 根据ID查询店铺信息
    Store findByStoreId(int storeId);
}
