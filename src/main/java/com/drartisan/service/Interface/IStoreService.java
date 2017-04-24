package com.drartisan.service.Interface;

import com.drartisan.entity.Store;

import java.util.List;

/**
 * Created by summer on 2017/4/23.
 */
public interface IStoreService {

    Store findByStoreId(int storeId);
    List<Store> findByMainStore(int mainStore);
    Store login(String username,String password);
    Store save(Store store);
}
