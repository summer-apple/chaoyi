package com.drartisan.repository;

import com.drartisan.entity.Store;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by summer on 2017/4/23.
 */
public interface IStoreRepository extends CrudRepository<Store,Integer> {

    List<Store> findByMainStore(int mainStore);
    List<Store> findByUsernameAndPassword(String username,String password);
}
