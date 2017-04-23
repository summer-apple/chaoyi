package com.drartisan.repository;

import com.drartisan.entity.Store;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/23.
 */
public interface StoreRepository extends CrudRepository<Store,Integer> {

    Store findByMainStore(int mainStore);
}
