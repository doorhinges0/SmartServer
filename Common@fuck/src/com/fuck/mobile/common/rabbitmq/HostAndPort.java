package com.fuck.mobile.common.rabbitmq;

import java.util.HashSet;
import java.util.Set;

public class HostAndPort {

	@Override
	public String toString() {
		return "HostAndPort [host=" + host + ", port=" + port + "]";
	}

	public String host;
	public int port;

	public HostAndPort(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

	public static Set<HostAndPort> getAddresses(String url) {
		HashSet<HostAndPort> addrs = new HashSet<HostAndPort>();
		String[] us = url.split(",");

		for (String u : us) {
			u = u.trim();
			int k = u.indexOf(":");
			HostAndPort ap = null;
			if (k > 0) {
				int p = Integer.parseInt(u.substring(k + 1, u.length()));
				ap = new HostAndPort(u.substring(0, k), p);

			} else {
				ap = new HostAndPort(u, 6379);
			}
			addrs.add(ap);
		}
		return addrs;

	}

}
