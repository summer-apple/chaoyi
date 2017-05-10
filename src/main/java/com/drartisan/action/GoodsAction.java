package com.drartisan.action;

import com.drartisan.entity.Goods;
import com.drartisan.entity.ReturnMessage;
import com.drartisan.entity.SubGoods;
import com.drartisan.service.GoodsService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/7.
 */
@RestController
@RequestMapping("goods")
public class GoodsAction {

    @Autowired
    GoodsService goodsService;

//
//    /**
//     * 根据商品编号查
//     * @param goodsNo
//     * @return
//     */
//    @RequestMapping(value = "/no/{goodsNo}", method = RequestMethod.GET)
//    public ReturnMessage getGoodsByGoodsNo(@PathVariable("goodsNo") String goodsNo){
//        Goods goods = goodsService.findGoodsByGoodsNo(goodsNo);
//        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goods);
//    }
//
//    /**
//     * 根据id查
//     * @param goodsId
//     * @return
//     */
//    @RequestMapping(value = "/id/{goodsId}", method = RequestMethod.GET)
//    public ReturnMessage getGoodsByGoodsId(@PathVariable("goodsId") int goodsId){
//        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
//        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goods);
//    }
//
//    /**
//     * 根据商品编号模糊查询
//     * @param goodsNo
//     * @param page
//     * @param size
//     * @return
//     */
//    @RequestMapping(value = "/no-like/{goodsNo}/{page}/{size}", method = RequestMethod.GET)
//    public ReturnMessage findGoodsByGoodsNoLike(@PathVariable("goodsNo") String goodsNo, @PathVariable("page") int page,@PathVariable("size") int size){
//        Page<Goods> goodsPage = goodsService.findGoodsByGoodsNoLike(goodsNo,page,size);
//        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goodsPage);
//    }
//
//    /**
//     * 根据分类查
//     * @param categoryId
//     * @param page
//     * @param size
//     * @return
//     */
//    @RequestMapping(value = "/category/{categoryId}/{page}/{size}", method = RequestMethod.GET)
//    public ReturnMessage findGoodsByCategoryId(@PathVariable("categoryId") int categoryId, @PathVariable("page") int page,@PathVariable("size") int size){
//        Page<Goods> goodsPage = goodsService.findGoodsByCategoryId(categoryId,page,size);
//        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goodsPage);
//    }
//
//
//    /**
//     * 查询全部
//     * @param page
//     * @param size
//     * @return
//     */
//    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
//    public ReturnMessage findAll(@PathVariable("page") int page,@PathVariable("size") int size){
//        Page<Goods> goodsPage = goodsService.findAll(page,size);
//        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goodsPage);
//    }
//
//
//
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ReturnMessage findAllByKvs(String goodsNo,int categoryId,int page,int size){
        Page<Goods> goodsPage = goodsService.findGoodsByKvs(goodsNo,categoryId,page,size);
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(goodsPage);
    }


    @RequestMapping(value = "/obj", method = RequestMethod.POST)
    public ReturnMessage test(@RequestBody Goods goods){
        System.out.println(goods.getGoodsNo());
        System.out.println(goods.getCategoryName());
        //System.out.println(goodsNo+categoryId+page+size);
        //Page<Goods> goodsPage = goodsService.findGoodsByKvs(kvs,page,size);
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(null);
    }






}
