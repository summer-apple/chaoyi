package com.drartisan.service.Interface;

import com.drartisan.entity.SaleOrder;
import com.drartisan.entity.Store;
import org.springframework.data.domain.Page;

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
    Page<Store> findByMainStore(int mainStore, int page,int size);


    // 根据ID查询店铺信息
    Store findByStoreId(int storeId);

    // 查询用户名是否可用
    boolean isUsernameAvailable(String username);
}
