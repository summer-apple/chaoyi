package com.drartisan.service;

import com.drartisan.entity.SubGoods;
import com.drartisan.repository.ISubGoodsRepository;
import com.drartisan.service.Interface.ISubGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by summer on 2017/5/4.
 */
@Service
public class SubGoodsService implements ISubGoodsService {
    @Autowired
    ISubGoodsRepository iSubGoodsRepository;

    @Override
    public SubGoods findSubGoodsBySubGoodsId(int subGoodsId) {
        return iSubGoodsRepository.findOne(subGoodsId);
    }

    @Override
    public List<SubGoods> findSubGoodsByGoodsId(int goodsId) {
        return iSubGoodsRepository.findSubGoodsByGoodsId(goodsId);
    }


}
