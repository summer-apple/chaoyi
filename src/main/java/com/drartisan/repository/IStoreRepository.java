package com.drartisan.repository;

import com.drartisan.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by summer on 2017/4/23.
 */
public interface IStoreRepository extends JpaRepository<Store,Integer>,JpaSpecificationExecutor<Store> {

    Page<Store> findByMainStore(int mainStore, Pageable pageable);
    List<Store> findByUsernameAndPassword(String username,String password);
    @Query("select count(1) from Store o where o.username=?1")
    int findByUsernameCount(String username);
}
