package com.zgh.xxg.xxg.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogListener implements ServletContextListener {

	public static final String LOG_DIR_KEY = "logDir";

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		System.getProperties().remove(LOG_DIR_KEY);
	}

	public void contextInitialized(ServletContextEvent servletcontextevent) {
		String logDir = servletcontextevent.getServletContext().getRealPath("/");
		System.setProperty(LOG_DIR_KEY, logDir);
	}
}
