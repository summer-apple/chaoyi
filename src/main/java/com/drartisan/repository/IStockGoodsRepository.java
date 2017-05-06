package com.drartisan.repository;

import com.drartisan.entity.OrderGoods;
import com.drartisan.entity.StockGoods;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface IStockGoodsRepository extends CrudRepository<StockGoods,Integer> {
    List<StockGoods> findStoctGoodsByStoreId(int storeId);
    int findCountSotckGoodsByStoreIdAndSubGoodsId(int storeId,int subGoodsId);


    @Modifying
    @Query("update StockGoods o set o.quantity = o.quantity+?3 where o.storeId=?1 and o.subGoodsId=?2")
    void updateQuantity(int storeId,int subGoodsId,int quantity);
}
