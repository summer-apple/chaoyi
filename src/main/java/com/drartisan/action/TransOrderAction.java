package com.drartisan.action;

import com.drartisan.entity.ReturnMessage;
import com.drartisan.entity.Store;
import com.drartisan.entity.TransOrder;
import com.drartisan.service.TransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summer on 2017/5/1.
 */
@RestController
@RequestMapping("/trans-order")
public class TransOrderAction {

    static final String UNCHECKED = "1"; // 待审核
    static final String UNSHIP = "2"; // 待发货
    static final String SHIPED = "3"; // 已发货
    static final String FINISHED = "4"; // 已完成
    static final String REFUSED =  "5"; // 审核不通过
    static final String CANCELD = "6"; // 已取消






    @Autowired
    TransOrderService transOrderService;

    /**
     * 根据订单号查询订单
     * @param orderId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ReturnMessage getOrderById(@PathVariable("orderId") String orderId, HttpServletRequest request){
        Store loginStore = (Store)request.getSession().getAttribute("store");

        TransOrder transOrder = transOrderService.getOrderById(orderId);
        if(null == transOrder){
            return ReturnMessage.failureMsg().setRetMsg("订单号不存在");
        }else if(transOrder.getMainStoreId() != loginStore.getStoreId() && transOrder.getBranchStoreId() != loginStore.getStoreId()) {
            return ReturnMessage.failureMsg().setRetMsg("无权限");
        }else {
            return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(transOrder);
        }
    }

    /**
     * 更新订单状态
     * @param orderId
     * @param state
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ReturnMessage updateTransOrder(String orderId, String state, HttpServletRequest request) {
        Store loginStore = (Store) request.getSession().getAttribute("store");

        TransOrder transOrder = transOrderService.getOrderById(orderId);
        if(null == transOrder){
            return ReturnMessage.failureMsg().setRetMsg("订单号不存在");
        }else if(transOrder.getMainStoreId() == loginStore.getStoreId()){ // 总店更新：审核通过、不通过、发货
            if(UNCHECKED.equals(transOrder.getState()) && (UNSHIP.equals(state) || REFUSED.equals(state) )){ // 未审核
                transOrderService.updateTransOrder(orderId, state);
                transOrder.setState(state);
                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
            }else if(UNSHIP.equals(transOrder.getState()) && SHIPED.equals(state)){ // 代发货
                transOrderService.updateTransOrder(orderId,state);
                transOrder.setState(state);
                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
            }else {
                return ReturnMessage.failureMsg().setRetMsg("更新失败--状态错误");
            }

        }else if(transOrder.getBranchStoreId() == loginStore.getStoreId()) {// 分店更新：取消、确认收货
            if((UNCHECKED.equals(transOrder.getState()) && CANCELD.equals(state)) || (SHIPED.equals(transOrder.getState()) && FINISHED.equals(state))){
                transOrderService.updateTransOrder(orderId,state);
                transOrder.setState(state);
                return ReturnMessage.successMsg().setRetMsg("更新成功").setRetContent(transOrder);
            }else{
                return ReturnMessage.failureMsg().setRetMsg("更新失败--状态错误");
            }
        }else{
            return ReturnMessage.failureMsg().setRetMsg("无权限");
        }
    }

    /**
     * 查询总店订单
     * @param request
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/main/{page}/{size}", method=RequestMethod.GET)
    public ReturnMessage getOrderByMainStore(HttpServletRequest request,@PathVariable("page") int page,@PathVariable("size") int size){
        Store loginStore = (Store)request.getSession().getAttribute("store");
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(transOrderService.getOrderByMainStore(loginStore.getStoreId(),page,size));
    }

    /**
     * 查询分店订单
     * @param request
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/branch/{page}/{size}", method=RequestMethod.GET)
    public ReturnMessage getOrderByBranchStore(HttpServletRequest request,@PathVariable("page") int page,@PathVariable("size") int size){
        Store loginStore = (Store)request.getSession().getAttribute("store");
        return ReturnMessage.successMsg().setRetMsg("查询成功").setRetContent(transOrderService.getOrderByBranchStore(loginStore.getStoreId(),page,size));

    }


    @RequestMapping(method = RequestMethod.PUT)
    public ReturnMessage createTransOrder(TransOrder transOrder,HttpServletRequest request){
        Store loginStore = (Store)request.getSession().getAttribute("store");
        transOrder.setBranchStoreId(loginStore.getStoreId());
        transOrder = transOrderService.createTransOrder(transOrder);
        return ReturnMessage.successMsg().setRetMsg("保存成功").setRetContent(transOrder);
    }

}
