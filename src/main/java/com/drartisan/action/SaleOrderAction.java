package com.drartisan.action;

import com.drartisan.entity.ReturnMessage;
import com.drartisan.entity.SaleOrder;
import com.drartisan.entity.Store;
import com.drartisan.entity.TransOrder;
import com.drartisan.service.SaleOrderService;
import com.drartisan.service.TransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summer on 2017/5/1.
 */
@RestController
@RequestMapping("/sale-order")
public class SaleOrderAction {

    static final String UNPAY = "1"; // 待支付
    static final String UNSHIP = "2"; // 待发货
    static final String SHIPED = "3"; // 已发货
    static final String FINISHED = "4"; // 已完成
    static final String PAYFAIL =  "5"; // 支付失败
    static final String CANCELD = "6"; // 已取消






    @Autowired
    SaleOrderService saleOrderService;
//
//    /**
//     * 根据订单号查询订单
//     * @param orderId
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
//    public ReturnMessage getOrderById(@PathVariable("orderId") String orderId, HttpServletRequest request){
//        Store loginStore = (Store)request.getSession().getAttribute("store");
//
//        TransOrder transOrder = transOrderService.getOrderById(orderId);
//        if(null == transOrder){
//            return ReturnMessage.failureMsg().setRetMsg("订单号不存在");
//        }else if(transOrder.getMainStoreId() != loginStore.getStoreId() && transOrder.getBranchStoreId() != loginStore.getStoreId()) {
//            return ReturnMessage.failureMsg().setRetMsg("无权限");
//        }else {
//            return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(transOrder);
//        }
//    }
//
//    /**
//     * 更新订单状态
//     * @param orderId
//     * @param state
//     * @param request
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public ReturnMessage updateTransOrder(String orderId, String state, HttpServletRequest request) {
//        Store loginStore = (Store) request.getSession().getAttribute("store");
//
//        TransOrder transOrder = transOrderService.getOrderById(orderId);
//        if(null == transOrder){
//            return ReturnMessage.failureMsg().setRetMsg("订单号不存在");
//        }else if(transOrder.getMainStoreId() == loginStore.getStoreId()){ // 总店更新：审核通过、不通过、发货
//            if(UNCHECKED.equals(transOrder.getState()) && (UNSHIP.equals(state) || REFUSED.equals(state) )){ // 未审核
//                transOrderService.updateTransOrder(orderId, state);
//                transOrder.setState(state);
//                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
//            }else if(UNSHIP.equals(transOrder.getState()) && SHIPED.equals(state)){ // 代发货
//                transOrderService.updateTransOrder(orderId,state);
//                transOrder.setState(state);
//                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
//            }else {
//                return ReturnMessage.failureMsg().setRetMsg("更新失败--状态错误");
//            }
//
//        }else if(transOrder.getBranchStoreId() == loginStore.getStoreId()) {// 分店更新：取消、确认收货
//            if((UNCHECKED.equals(transOrder.getState()) && CANCELD.equals(state)) || (SHIPED.equals(transOrder.getState()) && FINISHED.equals(state))){
//                transOrderService.updateTransOrder(orderId,state);
//                transOrder.setState(state);
//                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
//            }else{
//                return ReturnMessage.failureMsg().setRetMsg("更新失败--状态错误");
//            }
//        }else{
//            return ReturnMessage.failureMsg().setRetMsg("无权限");
//        }
//    }


    /**
     * 查询分店订单
     * @param request
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/branch", method=RequestMethod.POST)
    public ReturnMessage getOrderByBranchStore(String orderId,String orderTimeStart, String orderTimeEnd, int page,int size,HttpServletRequest request){
        Store loginStore = (Store)request.getSession().getAttribute("store");
        if(! StringUtils.isEmpty(orderTimeStart)) orderTimeStart = orderTimeStart+"000000";
        if(! StringUtils.isEmpty(orderTimeEnd)) orderTimeEnd = orderTimeEnd+"235959";
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(saleOrderService.getOrderByBranchStore(loginStore.getStoreId(), orderId, orderTimeStart, orderTimeEnd,page,size));

    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ReturnMessage createTransOrder(HttpServletRequest request, @RequestBody SaleOrder saleOrder){
        System.out.println(saleOrder.getAddressName());
        Store loginStore = (Store)request.getSession().getAttribute("store");
        saleOrder.setBranchStoreId(loginStore.getStoreId());
        saleOrder.setMainStoreId(loginStore.getMainStore());
        saleOrder = saleOrderService.createSaleOrder(saleOrder);
        return ReturnMessage.successMsg().setRetMsg("保存成功").setRetContent(saleOrder);
    }

}
