package com.drartisan.service;

import com.drartisan.entity.Goods;
import com.drartisan.repository.IGoodsRepository;
import com.drartisan.repository.jpaUtils.Criteria;
import com.drartisan.repository.jpaUtils.Restrictions;
import com.drartisan.service.Interface.IGoodsService;
import org.hibernate.criterion.MatchMode;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

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
        Page<Goods> goodsPage = iGoodsRepository.findGoodsByCategoryId(categoryId,new PageRequest(page-1,size));
        return this.getSubGoods(goodsPage);
    }

    @Override
    public Page<Goods> findGoodsByGoodsNoLike(String goodsNo, int page, int size) {
        Page<Goods> goodsPage = iGoodsRepository.findGoodsByGoodsNoLike(goodsNo,new PageRequest(page-1,size));
        return this.getSubGoods(goodsPage);
    }

    @Override
    public Page<Goods> findAll(int page, int size) {
        Page<Goods> goodsPage = iGoodsRepository.findAll(new PageRequest(page-1,size));
        return this.getSubGoods(goodsPage);
    }

    private Page<Goods> getSubGoods(Page<Goods> goodsPage){
        for(int i=0;i<goodsPage.getNumberOfElements();i++){
            int goodsId = goodsPage.getContent().get(i).getGoodsId();
            goodsPage.getContent().get(i).setSubGoodses(subGoodsService.findSubGoodsByGoodsId(goodsId));
        }
        return goodsPage;
    }

    @Override
    public Page<Goods> findGoodsByKvs(String goodsNo,int categoryId, int page, int size) {

        Criteria<Goods> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("categoryId",categoryId,true));
        criteria.add(Restrictions.like("goodsNo",goodsNo, MatchMode.ANYWHERE,true));


        Sort sort =  new Sort(new Sort.Order(Sort.Direction.DESC,"goodsId"));
        Page<Goods> goodsPage = iGoodsRepository.findAll(criteria,new PageRequest(page-1,size,sort));
        return this.getSubGoods(goodsPage);
    }
}
