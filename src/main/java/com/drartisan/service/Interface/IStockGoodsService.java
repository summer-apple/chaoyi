package com.drartisan.service.Interface;

import com.drartisan.entity.StockGoods;
import com.drartisan.entity.SubGoods;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface IStockGoodsService {

    // 根据商店ID 获取库存
    List<StockGoods> findStockGoodsByStoreId(int storeId);

    // 入库
    List<StockGoods> addStockGoods(List<StockGoods> stockGoodses);

    // 出库
    Boolean stockGoodsOut(List<StockGoods> stockGoodses);





}
