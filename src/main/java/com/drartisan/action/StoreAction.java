package com.drartisan.action;

import com.drartisan.entity.Store;
import com.drartisan.entity.ReturnMessage;
import com.drartisan.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    /**
     * 登录
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response,String username, String password) throws IOException,ServletException{
        Store store = storeService.login(username,password);
        String url = "../dashboard/login.jsp";
        if(null != store){
            request.getSession().setAttribute("store",store);
            url = store.getMainStore() == 0 ? "../dashboard/main.jsp":"../dashboard/branch.jsp";
        }else{
            request.getSession().setAttribute("flag",true);
        }
        request.getRequestDispatcher(url).forward(request,response);
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        request.getSession().removeAttribute("store");
        request.getRequestDispatcher("../dashboard/login.jsp").forward(request,response);
    }


    /**
     * 保存或更新商店信息
     * @param store
     * @param request
     * @return
     */
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

    /**
     * 查看分店信息
     * @param request
     * @param mainStoreId
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/branch/{page}/{size}", method = RequestMethod.GET)
    public ReturnMessage  findByMainStore(HttpServletRequest request,int mainStoreId,
                                          @PathVariable("page") int page,@PathVariable("size") int size){
        Store loginStore = (Store)request.getSession().getAttribute("store");
        if(null != loginStore){
            Page<Store> result= storeService.findByMainStore(loginStore.getStoreId(),page,size);
            return this.successMsg.setRetMsg("查询成功").setRetContent(result);
        }else{
            return this.failureMsg.setRetMsg("未登录");
        }
    }

    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    @RequestMapping(value = "/check-username/{username}", method = RequestMethod.GET)
    public boolean isUsernameAvailable(@PathVariable("username") String username){
        return storeService.isUsernameAvailable(username);
    }

    /**
     * 检查用户是否登录
     * @param request
     * @return
     */
    private boolean loginCheck(HttpServletRequest request){
       return null != request.getSession().getAttribute("store");
    }




}
