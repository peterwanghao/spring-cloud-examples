package org.peterwanghao.zuul.ui.config;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**   
 * @ClassName:  CustomZuulFilter
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午10:02:13
 * @version V1.0
 * 
 */
@Component
public class CustomZuulFilter extends ZuulFilter {
	 @Override
	    public Object run() {
		final RequestContext ctx = RequestContext.getCurrentContext();
	        ctx.addZuulRequestHeader("Test", "TestSample");
	        return null;
	    }

	    @Override
	    public boolean shouldFilter() {
	        return true;
	    }

	    @Override
	    public int filterOrder() {
	        return 1110;
	    }

	    @Override
	    public String filterType() {
	        return "pre";
	    }
}
