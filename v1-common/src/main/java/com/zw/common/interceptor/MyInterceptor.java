package com.zw.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zw.common.util.TokenUtil;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午10:55
 * @describe 一个简单的Interceptor拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            //RequestUtil.saveRequest();
        }

        // 如果请求url包含/v1/public/，不需要token验证，直接通过拦截
        String requestUri = request.getRequestURI();
        if(requestUri.indexOf("/v1/public/") != -1){
            return true;
        }

        // 默认token从http请求头里拿
        String token = request.getHeader("token");
        // 如果http请求头里没有，使用url参数名字为token的值
        if (token == null) {
            token = request.getParameter("token");
        }

        if(token!=null){
            // 根据token字符串，获取tokenVo，如果返回不为null，验证通过
            TokenVo tokenVo = TokenUtil.getTokenVo(token);
            if ( tokenVo!= null) {
                // 设置request属性tokenVo，在Controller里调用
                // 使用方法如下：
                // TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
                request.setAttribute("tokenVo",tokenVo);
                return true;
            }
        }

        // 上面未返回true，返回401
        ResponseVo response1 = new ResponseVo();
        response1.failure(401, "未经授权,服务器拒绝响应。");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(response1);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        return false;
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
