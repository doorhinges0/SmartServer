package com.fuck.mobile.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


@WebFilter(urlPatterns = "*")
public class IPFilter implements Filter {

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		if (paramServletRequest instanceof HttpServletRequest) {
			HttpServletRequestWrapper proxyreq = new HttpServletRequestWrapper(
					(HttpServletRequest) paramServletRequest) {
				@Override
				public String getRemoteAddr() {

					String ipaddr = getHeader("X-Real-IP");
					if (isNotEmpty(ipaddr)) {
						int k = ipaddr.indexOf(",");
						if (k > 0) {
							ipaddr = ipaddr.substring(0, k).trim();
							return ipaddr;
						}

						if (ipaddr.length() > 32) {
							ipaddr = ipaddr.substring(0, 32);
						}
						return ipaddr;
					}

					ipaddr = getHeader("X-Forwarded-For");
					if (isNotEmpty(ipaddr)) {
						int k = ipaddr.indexOf(",");
						if (k > 0) {
							ipaddr = ipaddr.substring(0, k).trim();
							return ipaddr;
						}

						if (ipaddr.length() > 32) {
							ipaddr = ipaddr.substring(0, 32);
						}
						return ipaddr;
					}

					return super.getRemoteAddr();
				}

				@Override
				public int getServerPort() {

					String port = getHeader("ServerPort");
					if (isNotEmpty(port)) {
						try {
							return Integer.parseInt(port);
						} catch (Exception ex) {
						}
					}
					return super.getServerPort();
				}

				@Override
				public String getServerName() {

					String servername = getHeader("Host");
					if (isNotEmpty(servername)) {
						int k = servername.indexOf(":");
						if (k > 0) {
							return servername.substring(0, k);
						}
						return servername;
					}

					return super.getServerName();
				}
			};
			paramFilterChain.doFilter(proxyreq, paramServletResponse);
		} else {
			paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
		}

	}

	@Override
	public void destroy() {

	}

	private static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
	
	
	private static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}
}
