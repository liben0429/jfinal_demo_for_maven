package com.demo.blog;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class BlogInterceptor implements Interceptor {
	
	private static Log log = Log.getLog(BlogInterceptor.class);
	
	public void intercept(Invocation inv) {
        log.info("*************接口拦截器预处理方法****************");
        Controller controller = inv.getController();
        HttpServletRequest request = controller.getRequest();
        log.info("请求IP地址：" + request.getRemoteAddr());
        log.info("请求url路径：" + request.getRequestURL());
		inv.invoke();
	}
}
