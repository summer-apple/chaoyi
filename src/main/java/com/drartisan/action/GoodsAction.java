package com.drartisan.action;

import com.drartisan.entity.Goods;
import com.drartisan.entity.ReturnMessage;
import com.drartisan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by summer on 2017/5/7.
 */
@RestController
@RequestMapping("goods")
public class GoodsAction {

    @Autowired
    GoodsService goodsService;




    @RequestMapping(value = "/no/{goodsNo}", method = RequestMethod.GET)
    public ReturnMessage getGoodsByGoodsNo(@PathVariable("goodsNo") String goodsNo){
        Goods goods = goodsService.findGoodsByGoodsNo(goodsNo);
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goods);
    }

    @RequestMapping(value = "/id/{goodsNo}", method = RequestMethod.GET)
    public ReturnMessage getGoodsByGoodsNo(@PathVariable("goodsId") int goodsId){
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goods);
    }





}
