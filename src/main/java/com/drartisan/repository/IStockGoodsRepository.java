package com.drartisan.repository;

import com.drartisan.entity.StockGoods;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/25.
 */
public interface IStockGoodsRepository extends CrudRepository<StockGoods,Integer> {
}
