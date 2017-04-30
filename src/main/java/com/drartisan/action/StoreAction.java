package com.drartisan.action;

import com.drartisan.entity.Store;
import com.drartisan.entity.ReturnMessage;
import com.drartisan.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by summer on 2017/4/30.
 */
@RestController
@RequestMapping("/store")
public class StoreAction {

    @Autowired
    StoreService storeService;
    private ReturnMessage successMsg = new ReturnMessage(0,"",null);
    private ReturnMessage failureMsg = new ReturnMessage(1,"",null);


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Store login(HttpServletRequest request,String username,String password){
        Store store = storeService.login(username,password);
        request.getSession().setAttribute("store",store);
        return store;
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ReturnMessage save(Store store,HttpServletRequest request){
        Store loginStore = (Store)request.getSession().getAttribute("store");

        if(! this.loginCheck(request)){
            return this.failureMsg.setRetMsg("未登录");
        }else
        if(loginStore.getStoreId() == store.getStoreId()) { // 更新本店信息
            store.setMainStore(loginStore.getMainStore());
            store = storeService.save(store);
        }else if(store.getMainStore() == loginStore.getStoreId()){ // 更新分店信息
            store = storeService.save(store);
        }else{ // 更新非自己分店的店铺
            return this.failureMsg.setRetMsg("无权限");
        }
        return this.successMsg.setRetMsg("保存成功").setRetContent(store);
    }


    @RequestMapping(value = "/branch/{mainStoreId}/{page}/{size}", method = RequestMethod.GET)
    public ReturnMessage  findByMainStore(HttpServletRequest request, @PathVariable("mainStoreId") int mainStoreId,
                                          @PathVariable("page") int page,@PathVariable("size") int size){
        if(this.loginCheck(request)){
            Page<Store> result= storeService.findByMainStore(mainStoreId,page,size);
            return this.successMsg.setRetMsg("查询成功").setRetContent(result);
        }else{
            return this.failureMsg.setRetMsg("未登录");
        }
    }

    @RequestMapping(value = "/check-username/{username}", method = RequestMethod.GET)
    public boolean isUsernameAvailable(@PathVariable("username") String username){
        return storeService.isUsernameAvailable(username);
    }

    private boolean loginCheck(HttpServletRequest request){
       return null != request.getSession().getAttribute("store");
    }




}
