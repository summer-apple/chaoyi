package com.drartisan.service;

import com.drartisan.entity.Store;
import com.drartisan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by summer on 2017/4/23.
 */
public interface IStoreService {

    Store findByMainStore(int mainStore);
}
