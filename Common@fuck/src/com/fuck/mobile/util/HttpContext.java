package com.fuck.mobile.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class HttpContext {
	public static interface AfterHttpResponse
	{
		void afterHttpResponse();
	}
	
	private HttpContext()
	{
		
	}
	static ThreadLocal<HttpServletRequest> reqs = new ThreadLocal<HttpServletRequest>();
	static ThreadLocal<HttpServletResponse> reps = new ThreadLocal<HttpServletResponse>();
	static ThreadLocal<List<AfterHttpResponse>> infc = new ThreadLocal<List<AfterHttpResponse>>(){
	    protected List<AfterHttpResponse> initialValue() {
	        return new ArrayList<AfterHttpResponse>();
	    }
	};
	
	protected static void doset(HttpServletRequest req,HttpServletResponse rep)
	{
		reqs.set(req);
		reps.set(rep);
	}
	
	
	protected static void remove() {
		reqs.remove();
		reps.remove();
		List<AfterHttpResponse> lis = infc.get();
		for(AfterHttpResponse l : lis)
		{
			try
			{
				l.afterHttpResponse();
			}catch(Exception e){}
		}
		infc.remove();
	}
	
	public static HttpServletRequest gethttpServletRequest()
	{
		return reqs.get();
	}
	
	
	public static HttpServletResponse gethttpServletResponse()
	{
		return reps.get();
	}
	
	
	public static HttpSession gethttpSession()
	{
		return gethttpServletRequest().getSession();
	}
	
	public static void addAfterHttpResponse(AfterHttpResponse inf)
	{
		if(inf != null)
		infc.get().add(inf);
	}
}
