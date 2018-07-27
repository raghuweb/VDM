package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter {
	
	//avoid-urls List;
	private List<String> urlsList=null;
	
	
	public void destroy() {
	}

	public void doFilter(
		ServletRequest request, 
		ServletResponse response, 
		FilterChain chain) throws 
		IOException, 
		ServletException {
		
	 HttpServletRequest req=
		(HttpServletRequest)request;
	 HttpServletResponse res=
		(HttpServletResponse)response;
		
		//disable cache-control
	res.setHeader("Cache-Control",
	"no-cache,no-store,must-revalidate"); 
	res.setHeader("Pragma", 
			 "no-cache");	
	res.setDateHeader("Expires", 0); 
	
	String uri=req.getRequestURI();
	boolean flag=false;
	try {
	 if(urlsList.contains(uri)){
		//avoid session check
		flag=true;
	 }
	 if(!flag){	//check session
		HttpSession ses=req.
				getSession(false);
		if(ses==null || ses.
		 getAttribute("username") 
		    == null)
		 res.sendRedirect(
			 req.getContextPath());
	 }
	} catch (Exception e) {	}
		
	chain.doFilter(request,response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String urls=fConfig.getInitParameter("avoid-urls");
		StringTokenizer st=new StringTokenizer(urls, ",");
		urlsList=new ArrayList<String>();
		
		while(st.hasMoreTokens()){
			urlsList.add(st.nextToken());
		}
		
	}

}
