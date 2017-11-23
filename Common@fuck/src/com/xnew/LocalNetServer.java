package com.xnew;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.SocketUtils;

public class LocalNetServer {
	static Log log = LogFactory.getLog(LocalNetServer.class);

	public static interface INetServer {

		public void onMessage(String msg);

	}

	private ServerSocket ss;
	private INetServer inf;
	private boolean isStart;
	private int port;

	public LocalNetServer(INetServer lis) {
		inf = lis;
	}

	public int getPort() {
		return port;

	}

	public synchronized void start() throws IOException {
		ss = new ServerSocket(SocketUtils.findAvailableTcpPort(), 128, InetAddress.getByName("127.0.0.1"));
		if (isStart)
			return;
		isStart = true;
		port = ss.getLocalPort();
		ss.setSoTimeout(1000);
		
		final ServerSocket mys1 = ss;
		new Thread(() -> {
			log.debug("LocalNetServer start....");
			ServerSocket mms = mys1;
			while (isStart) {
				try {
					if(mms.isClosed())
					{
						mms = new ServerSocket(SocketUtils.findAvailableTcpPort(), 128, InetAddress.getByName("127.0.0.1"));
					}
					Socket s = mms.accept();
					InputStream is = s.getInputStream();
					int k = is.read();
					if(k == -1)
					{
						try
						{
							is.close();
							s.close();
						}catch(Exception e)
						{
							
						}
						
					}else
					{
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						try {
							while (k != -1) {
								out.write(k);
								k = is.read();
							}
							is.close();
							s.close();
						} catch (Exception e) {
							log.info("", e);
						}

						inf.onMessage(out.toString("utf-8"));
					}
					
				} catch(SocketTimeoutException e){
					
				}catch (Exception e) {
					if (!(e instanceof SocketException && "socket closed".equals(e.getMessage()))) {
						log.info("", e);
					}

				}
			}

			log.debug("LocalNetServer exit....");

		}).start();

		new Thread(() -> {
			while (isStart) {

				try
				{
					Socket s = new Socket("127.0.0.1", port);
					s.close();
				}catch(Exception e){}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}

			}

		}).start();

	}

	public synchronized void stop() {
		isStart = false;
		if (ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
			}
		}
		ss = null;
	}

	public static void sendLocalMsg(String msg, int port) {
		try {
			Socket s = new Socket("127.0.0.1", port);
			s.getOutputStream().write(msg.getBytes("utf-8"));
			s.getOutputStream().close();
			s.close();
		} catch (Exception e) {
			log.error("", e);
		}

	}

	public static void main(String[] args) throws Exception {

		LocalNetServer lc = new LocalNetServer((msg) -> {
			System.out.println(msg);
		});
		lc.start();
		System.out.println("port -> " + lc.getPort());

		Thread.sleep(1000);
		for (int i = 0; i < 10; i++)
			sendLocalMsg("yaaaaa" + System.currentTimeMillis(), lc.getPort());

		Thread.sleep(6000);
		lc.stop();
	}

}
