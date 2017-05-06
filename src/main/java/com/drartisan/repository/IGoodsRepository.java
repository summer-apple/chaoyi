package com.drartisan.repository;

import com.drartisan.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/25.
 */
public interface IGoodsRepository extends JpaRepository<Goods,Integer>,JpaSpecificationExecutor<Goods> {
    Goods findGoodsByGoodsNo(String goodsNo);
    Page<Goods> findGoodsByCategoryId(int categoryId, Pageable pageable);
    Page<Goods> findGoodsByGoodsNoLike(String goodsNo, Pageable pageable);

}
