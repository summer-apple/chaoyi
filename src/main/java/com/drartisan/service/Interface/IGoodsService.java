package com.drartisan.service.Interface;

import com.drartisan.entity.Goods;
import org.springframework.data.domain.Page;

/**
 * Created by summer on 2017/5/7.
 */
public interface IGoodsService {
    Goods findGoodsByGoodsId(int goodsId);
    Goods findGoodsByGoodsNo(String goodsNo);
    Page<Goods> findGoodsByCategoryId(int categoryId, int page, int size);
    Page<Goods> findGoodsByGoodsNoLike(String goodsNo, int page, int size);
}
