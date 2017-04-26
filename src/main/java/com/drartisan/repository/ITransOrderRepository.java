package com.drartisan.repository;

import com.drartisan.entity.TransOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface ITransOrderRepository extends JpaRepository<TransOrder,String>,JpaSpecificationExecutor<TransOrder> {
    Page<TransOrder> findByMainStoreId(int mainStoreId, Pageable pageable);
    Page<TransOrder> findByBranchStoreId(int branchStoreId, Pageable pageable);
}
