package org.zuul;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * 
* @Description: 自定义过滤器,在请求被路由之前检查请求中是否有accessToken参数，若有就进行路由，若没有就拒绝访问，返回401 Unauthorized错误。
* @author security
* @date 2019年2月18日
*
 */
public class AccessFilter extends ZuulFilter  {

	@Override
	public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();		
        HttpServletRequest request = requestContext.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
        	requestContext.setResponseStatusCode(401);
        	requestContext.setSendZuulResponse(false);
        	requestContext.setResponseBody("no accessToken.deny to access");
        }

        return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
