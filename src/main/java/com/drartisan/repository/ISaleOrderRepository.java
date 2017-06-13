package com.drartisan.repository;

import com.drartisan.entity.SaleOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by summer on 2017/4/25.
 */
public interface ISaleOrderRepository extends JpaRepository<SaleOrder,String>, JpaSpecificationExecutor<SaleOrder> {
    Page<SaleOrder> findByBranchStoreId(int branchStoreId, Pageable pageable);
}
