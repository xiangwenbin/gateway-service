/**
 */
package com.zhonghui.gateway;
 

import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zhonghui.core.utils.LoggerUtils;

/**
 * 添加ZuulFilter filter bean
 */

@Configuration
public class ErrorExceptionFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 99;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        LoggerUtils.errorlog(throwable.getCause().getMessage(),throwable);
		return null;
	}
}
