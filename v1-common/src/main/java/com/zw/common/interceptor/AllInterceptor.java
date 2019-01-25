package com.zw.common.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午10:55
 * @describe 一个简单的Interceptor拦截器类
 */
public class AllInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            //RequestUtil.saveRequest();
        }
        // 跨越代码===start====
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
        // 非常重要，如果前端http请求设置有自定义header一定要写在这里
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, token");
        response.addHeader("Access-Control-Max-Age", "3600");
        // 跨越代码===end====
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        // System.out.println("myinterc posthandler");
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     * <p>
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        // System.out.println("myinterc aftercompletion");
    }
}
