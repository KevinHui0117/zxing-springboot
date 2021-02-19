package com.zgh.xxg.xxg.util;

import javax.servlet.*;
import java.io.IOException;


/**
 * Servlet Filter implementation class EncodeFilter
 */
public class EncodeFilter implements Filter {

	public FilterConfig config;
	
	public static final String ENCODE = "encode";

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	
    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String codeSet = config.getInitParameter(ENCODE);
		if(codeSet == null ){
			codeSet = "utf-8";
		}
		
		String encode_req = request.getCharacterEncoding();
		if( encode_req == null || !codeSet.equals(encode_req.toLowerCase())){
			request.setCharacterEncoding(codeSet);
		}
		
		String encode_rep = response.getCharacterEncoding();
		if( encode_rep == null || !codeSet.equals(encode_rep.toLowerCase())){
			response.setCharacterEncoding(codeSet);
		}
		
		chain.doFilter(request, response);
	}
}
