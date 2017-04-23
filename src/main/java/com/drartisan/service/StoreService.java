package com.drartisan.service;


import com.drartisan.entity.Store;
import com.drartisan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by summer on 2017/4/23.
 */
@Service
public class StoreService implements IStoreService{

    @Autowired
    StoreRepository storeRepository;

    public Store findByStoreId(int storeId) {
        return storeRepository.findOne(storeId);
    }

    @Override
    public Store findByMainStore(int mainStore) {
        return storeRepository.findByMainStore(mainStore);
    }
}
