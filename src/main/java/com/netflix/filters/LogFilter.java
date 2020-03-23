package com.netflix.filters;





import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LogFilter extends ZuulFilter{

	private static final Logger log = Logger.getLogger(LogFilter.class);
	
	// runs for each http request
	// requestconext is created for each http request and bound to thread local 
	// access it via RequestContext.getCurrentContext()
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		log.info(RequestContext.getCurrentContext());
		log.info(RequestContext.getCurrentContext().getRequest().getRequestURL());
		return new Object();
	}
	
	@Override
	public String filterType() {
		// pre post routing error
		
		return "pre";
	}
	
		
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	// called for each httprequest
	@Override
	public boolean shouldFilter() {
		boolean run = RequestContext.getCurrentContext().getRequest().getRequestURI().contains("movies");
		//only execute when URI contains "movies"
		log.info("should filter?" + run);
		return RequestContext.getCurrentContext().getRequest().getRequestURI().contains("movies");
		
	}
	
}
