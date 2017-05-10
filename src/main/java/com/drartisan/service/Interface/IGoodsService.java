package com.drartisan.service.Interface;

import com.drartisan.entity.Goods;
import org.omg.CORBA.Object;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/7.
 */
public interface IGoodsService {
    Page<Goods> findAll(int page,int size);
    Goods findGoodsByGoodsId(int goodsId);
    Goods findGoodsByGoodsNo(String goodsNo);
    Page<Goods> findGoodsByCategoryId(int categoryId, int page, int size);
    Page<Goods> findGoodsByGoodsNoLike(String goodsNo, int page, int size);
    Page<Goods> findGoodsByKvs(String goodsNo,int categoryId, int page,int size);
}
