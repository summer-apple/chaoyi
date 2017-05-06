package com.drartisan.service;

import com.drartisan.entity.Goods;
import com.drartisan.repository.IGoodsRepository;
import com.drartisan.service.Interface.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by summer on 2017/5/7.
 */
@Service
public class GoodsService implements IGoodsService {


    @Autowired
    IGoodsRepository iGoodsRepository;
    @Autowired
    SubGoodsService subGoodsService;

    @Override
    public Goods findGoodsByGoodsId(int goodsId) {
        return iGoodsRepository.findOne(goodsId);
    }

    @Override
    public Goods findGoodsByGoodsNo(String goodsNo) {
        Goods goods = iGoodsRepository.findGoodsByGoodsNo(goodsNo);
        if(null != goods){
            goods.setSubGoodses(subGoodsService.findSubGoodsByGoodsId(goods.getGoodsId()));
        }
        return goods;
    }

    @Override
    public Page<Goods> findGoodsByCategoryId(int categoryId, int page, int size) {
        Page<Goods> goodsPage = iGoodsRepository.findGoodsByCategoryId(categoryId,new PageRequest(page,size));
        for(int i=0;i<=goodsPage.getTotalElements();i++){
            int goodsId = goodsPage.getContent().get(i).getGoodsId();
            goodsPage.getContent().get(i).setSubGoodses(subGoodsService.findSubGoodsByGoodsId(goodsId));
        }
        return goodsPage;
    }

    @Override
    public Page<Goods> findGoodsByGoodsNoLike(String goodsNo, int page, int size) {
        Page<Goods> goodsPage = iGoodsRepository.findGoodsByCategoryId(goodsNo,new PageRequest(page,size));
        for(int i=0;i<=goodsPage.getTotalElements();i++){
            int goodsId = goodsPage.getContent().get(i).getGoodsId();
            goodsPage.getContent().get(i).setSubGoodses(subGoodsService.findSubGoodsByGoodsId(goodsId));
        }
        return goodsPage;
    }
}
