package com.kong.filter;/**
 * Created by xuebi on 2019/8/9.
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/9 14:08
 * @Version 1.0
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取context
        RequestContext context = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            //拦截请求，不会向下发送
            context.setSendZuulResponse(false);
            //设置状态码
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置返回内容
            context.setResponseBody("token");
        }
        return null;
    }
}
