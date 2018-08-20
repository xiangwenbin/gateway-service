/**
 */
package com.zhonghui.gateway;
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zhonghui.core.utils.LoggerUtils;

/**
 * 添加ZuulFilter filter bean
 */

@Configuration
public class AccessFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String authorization = request.getHeader("Authorization");
		LoggerUtils.runlog("authorization:"+authorization);
		if(authorization!=null&&!"".equals(authorization))
			ctx.addZuulRequestHeader("Authorization", authorization);
		return null;
	}
}
