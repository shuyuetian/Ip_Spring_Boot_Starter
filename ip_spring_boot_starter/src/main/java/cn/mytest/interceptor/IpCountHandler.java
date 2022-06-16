package cn.mytest.interceptor;

import cn.mytest.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IpCountHandler implements HandlerInterceptor {
    @Autowired
    IpCountService ipCountService;

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-------------拦截器启动-------------");
        ipCountService.count();
        return true;
    }
}
