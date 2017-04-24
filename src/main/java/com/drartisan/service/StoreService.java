package com.drartisan.service;


import com.drartisan.entity.Store;
import com.drartisan.repository.IStoreRepository;
import com.drartisan.service.Interface.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by summer on 2017/4/23.
 */
@Service
public class StoreService implements IStoreService {

    @Autowired
    IStoreRepository storeRepository;

    @Override
    public Store findByStoreId(int storeId) {
        return storeRepository.findOne(storeId);
    }

    @Override
    public List<Store> findByMainStore(int mainStore) {
        return storeRepository.findByMainStore(mainStore);
    }

    @Override
    public Store save(Store store){
        return storeRepository.save(store);
    }

    @Override
    public Store login(String username, String password) {
        List<Store> stores = storeRepository.findByUsernameAndPassword(username,password);
        if(stores.size()!=1){
            return null;
        }else {
            return stores.get(0);
        }
    }
}
