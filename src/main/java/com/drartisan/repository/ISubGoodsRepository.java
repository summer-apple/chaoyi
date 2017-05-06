package com.drartisan.repository;

import com.drartisan.entity.SubGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface ISubGoodsRepository extends JpaRepository<SubGoods,Integer>,JpaSpecificationExecutor<SubGoods> {
    List<SubGoods> findSubGoodsByGoodsId(int goodsId);

}
