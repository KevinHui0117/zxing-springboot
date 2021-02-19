package com.zgh.xxg.xxg.filter;

import com.zgh.xxg.xxg.base.module.Operater;
import com.zgh.xxg.xxg.util.SystemConstant;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

//公用过滤器
public class CommonFilter implements Filter {
	
	
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String path = request.getServletPath();
		request.setAttribute("currUrl", path);
		HttpSession current_session = request.getSession();
		
		if(!path.startsWith("/workflow/")&&!path.startsWith("/mobile/")&& StringUtils.isNotBlank(vaildParams(request))){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("参数包含非法字符，请修改");
			return;
		}

		//过滤css、js等文件
		if(FilterHelper.ifFilter(path, FilterHelper.PUBLIC_ALL)){
			req.setAttribute("NoSSOInterceptor", "1");
			chain.doFilter(req, resp);
		}else{
			//组装loginUrl
			String loginUrl=request.getContextPath()+"/login.action?ssoReturnURL=";
		
			if("get".equalsIgnoreCase(request.getMethod())){//仅能支持get方式在登录后自动跳转
				String returnURL=request.getServletPath();
				String queryString=request.getQueryString();
				if(StringUtils.isNotBlank(queryString)){
					returnURL=returnURL+"?"+queryString;
				}
				try{
					loginUrl=loginUrl+URLEncoder.encode(returnURL,"utf-8");
				}catch(UnsupportedEncodingException ex){

				}
			}

			
			//判断是否有登录
			Object obj=current_session.getAttribute(SystemConstant.SESSION_USER_KEY);
			
			//对AJAX请求会话过期进行处理
		    if(obj == null && FilterHelper.isAjax(request)) {
		        response.setHeader("sessionError", "sessionTimeOut");
		        response.setStatus(401);
		        response.getWriter().write("由于您没有登录或者长时间没有操作, 登录状态已失效, 请刷新");
		        return;
		    }
			
			
			if(obj == null){
				clearSession(request.getSession());
				response.sendRedirect(loginUrl);
				return;
			}

			Operater operater = (Operater) obj;
			if(operater.getUserId()==0  && FilterHelper.isAjax(request)) {
				response.setHeader("sessionError", "sessionTimeOut");
			    response.setStatus(401);
			    response.getWriter().write("由于您没有登录或者长时间没有操作, 登录状态已失效, 请刷新");
		        return;
		    }

			if(operater.getUserId()==0){
				clearSession(request.getSession());
				response.sendRedirect(loginUrl);
				return;
			}
			//安全考虑，对IP进行检查
			if(StringUtils.isNotBlank(operater.getIp())){
				/*if(!operater.getIp().equals(request.getRemoteAddr())){
				    clearSession(request.getSession());
					response.sendRedirect(loginUrl);
					return;
				}*/
			}
			
			this.doFilter(chain, request, response);

		}

	}
	
	
	private void clearSession(HttpSession session){
		session.removeAttribute(SystemConstant.SESSION_USER_KEY);
		session.removeAttribute(SystemConstant.SESSION_LOGIN_KEY);
		session.removeAttribute(SystemConstant.SESSION_LOGIN_COUNT);
		session.removeAttribute(SystemConstant.SESSION_MENU_ALL);
		session.removeAttribute(SystemConstant.SESSION_MENU_TITLES);
		session.removeAttribute(SystemConstant.SESSION_MENU_FIRSTS);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	/**
	 * 强制防止表单重复提交
	 */
	private void doFilter(FilterChain chain, ServletRequest req, ServletResponse resp) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		String url=request.getServletPath();
		String controllerMethod=url.substring(url.lastIndexOf("/")+1, url.length());
		if((controllerMethod.startsWith("insert") ||
				controllerMethod.startsWith("add") ||
				controllerMethod.startsWith("update") ||
				controllerMethod.startsWith("delete") ||
				controllerMethod.startsWith("save")  
			) && controllerMethod.endsWith(".action")
		){
			/*if(checkToken(request)){
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("请求已提交，请勿重复操作！");
				return;
			}else{*/
				chain.doFilter(req, resp);
			//}
		}else{
			chain.doFilter(req, resp);
		}
	}



	public boolean checkToken(HttpServletRequest request) throws IOException{
		Object token_obj = request.getParameter("formToken");
		if(token_obj != null && StringUtils.isNotBlank(token_obj.toString())){
			if(getToken(token_obj.toString(), request.getSession())){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean getToken(String token, HttpSession session){
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.MINUTE, -30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = sdf.format(cl.getTime());
		boolean rs = false;
		
		Enumeration<String>  enu=session.getAttributeNames();
		while(enu.hasMoreElements()){
			String name=enu.nextElement();
			if(name.startsWith("formToken")){
			    String value =(String)session.getAttribute(name);
			    if(dateStr.compareTo(value) > 0){ //已经超时
					session.removeAttribute(name);
				}else if(StringUtils.isNotBlank(token)&&token.equals(name.substring(9))){
					session.removeAttribute(name);
					rs = true;
				}
			}
		}
		return rs;
	}
	
	/**
	 * 验证参数是否带有非法关键字
	 */
	@SuppressWarnings("rawtypes")
	private String vaildParams(HttpServletRequest request) {
        Enumeration paramNames = request.getParameterNames(); 
        String flag = "";
        while (paramNames.hasMoreElements()) {  
            String paramName = (String) paramNames.nextElement();  
            String[] paramValues = request.getParameterValues(paramName);  
            if (paramValues.length == 1) {  
                String paramValue = paramValues[0];
                if (paramValue.length() != 0 && !isValid(paramValue.toLowerCase())) {  
                	flag = "参数非法";
                	break;
                }  
            }  
        }
        return flag;
    }
	
	private  boolean isValid(String p) {  
		if(p.indexOf("'")>=0){
			if(p.indexOf("delete") >= 0 || p.indexOf("ASCII") >= 0  
			        || p.indexOf("update") >= 0 || p.indexOf("select") >= 0 || p.indexOf("substr(") >= 0  
			        || p.indexOf("count(") >= 0 || p.indexOf(" or ") >= 0  
			        || p.indexOf(" and ") >= 0 || p.indexOf("drop") >= 0  
			        || p.indexOf("execute") >= 0 || p.indexOf("exec") >= 0  
			        || p.indexOf("truncate") >= 0 || p.indexOf("into") >= 0  
			        || p.indexOf("declare") >= 0 || p.indexOf("master") >= 0  
			        || p.indexOf("--") >= 0){
				 return false; 
			}
		}
		
		if(p.indexOf("<script")>=0 || p.indexOf("<input")>=0 || p.indexOf("<iframe")>=0){
			return false; 
		}
	    return true;  
	}
	

	

}

