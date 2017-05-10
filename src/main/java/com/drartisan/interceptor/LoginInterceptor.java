package com.drartisan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by summer on 2017/5/2.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {



//        //获取url地址
//        String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");
//        //当url地址为登录的url的时候跳过拦截器
//        if(reqUrl.contains("/store/login")){
//            return true;
//        }else{
//            HttpSession session=request.getSession();
//            Object obj=session.getAttribute("store");
//            if(obj==null||"".equals(obj.toString())){
//                String path = request.getContextPath();
//                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//
//                response.sendRedirect(basePath+"dashboard/login.jsp");
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
