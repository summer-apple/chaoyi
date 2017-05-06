package com.drartisan.service.Interface;

import com.drartisan.entity.SubGoods;
import com.drartisan.repository.ISubGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by summer on 2017/5/4.
 */
public interface ISubGoodsService {
    SubGoods findSubGoodsBySubGoodsId(int subGoodsId);
    List<SubGoods> findSubGoodsByGoodsId(int goodsId);
}
