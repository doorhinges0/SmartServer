package com.ssdb;

import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * @category SSDB
 * @author MegaX
 * 
 * http://ssdb.io/docs/zh_cn/php/index.html
 *
 */
public class SSDBPool implements Closeable{
		
	private static final int maxPool = 10;
	
	private ArrayList<Link> pools = new ArrayList<Link>();
	
	private boolean isClose = false;
	
	private static final Charset utf8 = Charset.forName("utf-8");
	
	private String host ;
	private int port;
	private int timeout_ms;
	
	public SSDBPool(String host, int port)
	{
		this(host,port,0);
	}

	public SSDBPool(String host, int port, int timeout_ms) {
		this.host = host;
		this.port = port;
		this.timeout_ms = timeout_ms;		
	}
	
	
	public void close()
	{
		if(isClose)
		{
			return;
		}
		isClose = true;
		for(Link s : pools)
		{
			try
			{
				s.close();
			}catch(Exception e){}
		}
		pools.clear();
	}
	
	
	private Link get()
	{
		synchronized (pools) {
			while(!pools.isEmpty())
			{
				try
				{
					Link s = pools.remove(0);
					if(s.isConnected())
					{
						return s;
					}
				}catch(Exception e){}
			}
		}
		try {
			Link ss = new Link(host, port, timeout_ms);
			return ss;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}		
	}
	
	
	private void returnResource(Link obj)
	{
		if(obj == null)
		{
			return;
		}
		if(pools.size() > maxPool)
		{
			try
			{
				obj.close();
			}catch(Exception e){}
			return;
		}
		synchronized (pools) {
			pools.add(obj);
		}
	}
	
	/**
	 * @category 设置指定 key 的值内容.
	 * @param key
	 * @param val
	 * @throws Exception
	 */
	public boolean set(String key, String val){
		Link s = get();
		boolean f = false;
		try
		{
			Response resp = s.request("set", key.getBytes(utf8), val.getBytes(utf8));
			returnResource(s);
			
			if(resp.ok()){
				if(resp.raw.size() > 1)
				{
					String v = new String(resp.raw.get(1));
					return "1".equals(v);
				}else
				{
					return false;
				}
			}
			resp.exception();
			return false;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();
		}
		return f;
		
	}
	
	/**
	 * @category 删除指定的 key.
	 * @param key
	 * @throws Exception
	 */
	public boolean del(String key){
		Link s = get();
		boolean f = false;
		try
		{
			Response resp = s.request("del", key.getBytes(utf8));
			returnResource(s);
			if(resp.ok()){
				
				if(resp.raw.size() > 1)
				{
					String v = new String(resp.raw.get(1));
					return "1".equals(v);
				}else
				{
					return false;
				}
			}
			resp.exception();
			return false;			
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();
		}
		return f;
		
	}
	
	/**
	 * @category 获取指定 key 的值内容.
	 * @param key
	 * @return
	 */
	public String get(String key){
		Link s = get();
		try
		{
			Response resp = s.request("get", key.getBytes(utf8));
			returnResource(s);
			
			if(resp.not_found()){
				return null;
			}
			if(resp.raw.size() != 2){
				throw new Exception("Invalid response");
			}
			byte[] b = null;
			if(resp.ok()){
				b = resp.raw.get(1);
			}else
			{
				resp.exception();
			}
			String ss = null;
			if(b != null)
			{
				ss =  new String(b,utf8);
			}
			return ss;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @category 设置指定 key 的值内容, 同时设置存活时间.
	 * @param key
	 * @param val
	 * @param ttl
	 */
	public boolean setx(String key, String val,int ttl) {
		Link s = get();
		try
		{
			Response resp = s.request("setx",key.getBytes(utf8), val.getBytes(utf8),String.valueOf(ttl).getBytes());
			returnResource(s);
			if(resp.ok()){
				return true;
			}else
			{
				resp.exception();
				return false;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 当  key 不存在时, 设置指定 key 的值内容. 如果已存在, 则不设置.
	 * @param key
	 * @param val
	 * @throws Exception
	 */
	public boolean setnx(String key, String val) throws Exception{
		Link s = get();
		boolean f = false;
		try
		{
			Response resp = s.request("setnx", key.getBytes(utf8), val.getBytes(utf8));
			returnResource(s);
			if(resp.ok()){
				if(resp.raw.size() > 1)
				{
					String v = new String(resp.raw.get(1));
					return "1".equals(v);
				}else
				{
					return false;
				}
			}
			resp.exception();
			return false;		
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return f;
	}
	
	
	/**
	 * @category 设置 key 只针对 KV 类型  的存活时间.
	 * @param key
	 * @param ttl
	 * @return
	 */
	public boolean expire(String key,int ttl)
	{
		Link s = get();
		boolean f = false;
		try
		{
			Response resp = s.request("expire", key.getBytes(utf8), String.valueOf(ttl).getBytes());
			returnResource(s);
			if(resp.ok()){
				if(resp.raw.size() > 1)
				{
					String v = new String(resp.raw.get(1));
					return "1".equals(v);
				}else
				{
					return false;
				}
			}
			resp.exception();
			return false;
						
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return f;
	}
	
	
	
	/**
	 * @category 判断指定的 key 是否存在.
	 * @param key
	 * @return
	 */
	public boolean exists(String key)
	{
		Link s = get();
		boolean f = false;
		try
		{
			Response resp = s.request("exists", key.getBytes(utf8));
			returnResource(s);
			if(resp.ok()){
				if(resp.raw.size() > 1)
				{
					String v = new String(resp.raw.get(1));
					return "1".equals(v);
				}else
				{
					return false;
				}
			}
			resp.exception();
			return false;	
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return f;
	}
	/**
	 * @category 批量设置一批 key-value
	 * @param kvs
	 * @return
	 */
	public boolean multi_set(Map<String, String> kvs)
	{
		if(kvs == null || kvs.size() == 0)
		{
			return false;
		}
		Link s = get();
		try
		{
			Iterator<String> keys = kvs.keySet().iterator();
			ArrayList<byte[]> list = new ArrayList<byte[]>();
			while(keys.hasNext())
			{
				String k = keys.next();
				String v = kvs.get(k);
				list.add(k.getBytes(utf8));
				list.add(v.getBytes(utf8));
			}		
			Response resp = s.request("multi_set", list);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}	
			return true;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	/**
	 * @category 批量获取一批 key 对应的值内容.
	 * @param keys
	 * @return
	 */
	public Map<String, String> multi_get(List<String> keys) 
	{
		Map<String, String> m = new LinkedHashMap<String, String>();
		if(keys == null || keys.size() == 0)
		{
			return m;
		}
		Link s = get();
		try
		{	
			List<byte[]> kk = new ArrayList<byte[]>();
			for(String sz : keys)
			{
				kk.add(sz.getBytes(utf8));
			}
			Response resp = s.request("multi_get", kk);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			for(int i=1; i<resp.raw.size(); i+=2){
				byte[] k = resp.raw.get(i);
				byte[] v = resp.raw.get(i+1);
			
				m.put(k == null ? null : new String(k,utf8), v == null? null :new String( v,utf8));
			}
			
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return m;
	}
	
	/**
	 * @category 批量删除一批 key 和其对应的值内容.
	 * @param keys
	 */
	public boolean multi_del(List<String> keys)
	{
		if(keys == null || keys.size() == 0)
		{
			return false;
		}
		Link s = get();
//		Map<String, String>  m = null;
		try
		{
			List<byte[]> ll = new ArrayList<byte[]>();
			for(String ssss:keys)
			{
				ll.add(ssss.getBytes(utf8));
				
			}
			
			Response resp = s.request("multi_del", ll);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			return true;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 列出处于区间 (key_start, key_end] 的 key-value 列表.
	 * @param key_start 返回的起始 key(不包含), 空字符串表示 -inf.
	 * @param key_end 返回的结束 key(包含), 空字符串表示 +inf.
	 * @param limit 最多返回这么多个元素.
	 * @return
	 */
	public Map<String, String> scan(String key_start,String key_end,int limit)
	{
		Map<String, String>  m = new HashMap<String, String>();
		if(limit <= 0)
		{
			return m;
		}
		if(key_start == null)
		{
			key_start = "";
		}
		if(key_end == null)
		{
			key_end = "";
		}
		
		Link s = get();

		try
		{
			Response resp = s.request("scan", key_start.getBytes(utf8),key_end.getBytes(utf8),String.valueOf(limit).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			for(int i=1; i<resp.raw.size(); i+=2){
				byte[] k = resp.raw.get(i);
				byte[] v = resp.raw.get(i+1);
			
				m.put(k == null ? null : new String(k,utf8), v == null? null :new String( v,utf8));
			}
			
			
			
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return m;
	}
	
	/**
	 * @category 列出处于区间 (key_start, key_end] 的 key-value 列表, 反向顺序.
	 * @param key_start 返回的起始 key(不包含), 空字符串表示 -inf.
	 * @param key_end 返回的结束 key(包含), 空字符串表示 +inf.
	 * @param limit 最多返回这么多个元素.
	 * @return
	 */
	public Map<String, String> rscan(String key_start,String key_end,int limit)
	{
		Map<String, String>  m = new HashMap<String, String>();
		if(limit <= 0)
		{
			return m;
		}
		if(key_start == null)
		{
			key_start = "";
		}
		if(key_end == null)
		{
			key_end = "";
		}
		
		Link s = get();

		try
		{
			Response resp = s.request("scan", key_start.getBytes(utf8),key_end.getBytes(utf8),String.valueOf(limit).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			for(int i=1; i<resp.raw.size(); i+=2){
				byte[] k = resp.raw.get(i);
				byte[] v = resp.raw.get(i+1);
			
				m.put(k == null ? null : new String(k,utf8), v == null? null :new String( v,utf8));
			}
			
			
			
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return m;
	}
	
	/**
	 * @category 使key对应的值增加num. 参数num可以为负数.如果原来的值不是整数(字符串形式的整数), 它会被先转换成整数.
	 * @param key
	 * @param num
	 * @return
	 */
	public Long incr(String key,Long num)
	{
		if(num == null)
		{
			return num;
		}
		Link s = get();
		Long m = null;
		try
		{
			Response resp = s.request("incr", key.getBytes(utf8),String.valueOf(num).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				String r = new String(resp.raw.get(1));
				m = Long.parseLong(r);
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return m;
	}

	/**
	 * @category 设置 hashmap 中指定 key 对应的值内容.
	 * @param name
	 * @param key
	 * @param value
	 */
	public boolean hset(String name, String key ,String value )
	{
		Link s = get();

		try
		{
			Response resp = s.request("hset",name.getBytes(utf8), key.getBytes(utf8),value.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				return true;
//				String v = new String(resp.raw.get(1));
//				System.out.println(v);
//				return "1".equals(v);
			}else
			{
				return false;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}

	/**
	 * @category 获取 hashmap 中指定 key 的值内容.
	 * @param name
	 * @param key
	 * @return
	 */
	public String hget(String name,String key)
	{
		Link s = get();

		try
		{
			Response resp = s.request("hget",name.getBytes(utf8), key.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	/**
	 * @category 删除 hashmap 中指定 key
	 * @param name
	 * @param key
	 * @return
	 */
	public boolean hdel(String name,String key)
	{
		Link s = get();

		try
		{
			Response resp = s.request("hdel",name.getBytes(utf8), key.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return "1".equals(v);
			}else
			{
				return false;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 删除 hashmap 中的所有 key.
	 * @param name
	 * @return
	 */
	public boolean hclear(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("hclear",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return "1".equals(v);
			}else
			{
				return false;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 返回队列的长度.
	 * @param name
	 * @return
	 */
	public Long qsize(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qsize",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return Long.parseLong(v);
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 清空一个队列.
	 * @param name
	 * @return
	 */
	public boolean qclear(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qclear",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return "1".equals(v);
			}else
			{
				return false;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 返回队列的第一个元素.
	 * @param name
	 * @return
	 */
	public String qfront(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qfront",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 返回队列的最后一个元素.
	 * @param name
	 * @return
	 */
	public String qback(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qback",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 返回指定位置的元素. 0 表示第一个元素, 1 是第二个 ... -1 是最后一个.
	 * @param name
	 * @param index
	 * @return
	 */
	public String qget(String name,long index)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qget",name.getBytes(utf8),String.valueOf(index).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 更新位于 index 位置的元素. 如果超过现有的元素范围, 会返回错误.
	 * @param name
	 * @param index
	 * @param val
	 * @return
	 */
	public boolean qset(String name,long index,String val)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qset",name.getBytes(utf8),String.valueOf(index).getBytes(),val.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			return true;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	/**
	 * @category 往队列的首部添加一个或者多个元素
	 * @param name
	 * @param val
	 * @return 添加元素之后, 队列的长度
	 */
	public Long qpush_front(String name,String val)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qpush_front",name.getBytes(utf8),val.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return Long.parseLong(v);
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 往队列的尾部添加一个或者多个元素
	 * @param name
	 * @param val
	 * @return
	 */
	public Long qpush_back(String name,String val)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qpush_back",name.getBytes(utf8),val.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return Long.parseLong(v);
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 返回下标处于区域 [offset, offset + limit] 的元素.
	 * @param name
	 * @param offset  整数, 从此下标处开始返回. 从 0 开始. 可以是负数, 表示从末尾算起.
	 * @param limit  正整数, 最多返回这么多个元素.
	 * @return
	 */
	public List<String> qrange(String name,long offset ,long limit )
	{
		ArrayList<String> ll = new ArrayList<String>();

		Link s = get();
		try
		{
			Response resp = s.request("qrange",name.getBytes(utf8),String.valueOf(offset).getBytes(),String.valueOf(limit).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				for(int i = 1; i < resp.raw.size();i++)
				{
					ll.add(new String(resp.raw.get(i),utf8));
				}
				
				return ll;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 从队列首部弹出最后一个或者多个元素.
	 * @param name
	 * @return
	 */
	public String qpop_front(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qpop_front",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	
	/**
	 * @category 从队列尾部弹出最后一个或者多个元素.
	 * @param name
	 * @return
	 */
	public String qpop_back(String name)
	{
		Link s = get();

		try
		{
			Response resp = s.request("qpop_back",name.getBytes(utf8));
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				if(b == null)
				{
					return null;
				}
				String v = new String(b,utf8);
				return v;
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 从队列头部删除多个元素.
	 * @param name
	 * @param size
	 * @return
	 */
	public Long qtrim_front(String name,long size )
	{
		Link s = get();

		try
		{
			Response resp = s.request("qtrim_front",name.getBytes(utf8),String.valueOf(size).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return Long.parseLong(v);
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	/**
	 * @category 从队列尾部删除多个元素.
	 * @param name
	 * @param size
	 * @return
	 */
	public Long qtrim_back(String name,long size )
	{
		Link s = get();

		try
		{
			Response resp = s.request("qtrim_back",name.getBytes(utf8),String.valueOf(size).getBytes());
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			if(resp.raw.size() > 1)
			{
				byte[] b = resp.raw.get(1);
				String v = new String(b,utf8);
				return Long.parseLong(v);
			}else
			{
				return null;
			}
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return null;
	}
	
	
	/**
	 * @category 批量设置 hashmap 中的 key-value.
	 * @param kvs
	 * @return
	 */
	public boolean multi_hset(String name,Map<String, String> kvs)
	{
		if(kvs == null || kvs.size() == 0)
		{
			return false;
		}
		Link s = get();
		try
		{
			Iterator<String> keys = kvs.keySet().iterator();
			ArrayList<byte[]> list = new ArrayList<byte[]>();
			list.add(name.getBytes(utf8));
			while(keys.hasNext())
			{
				String k = keys.next();
				String v = kvs.get(k);
				list.add(k.getBytes(utf8));
				list.add(v.getBytes(utf8));
			}		
			Response resp = s.request("multi_hset", list);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}	
			return true;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	
	/**
	 * @category 批量获取 hashmap 中多个 key 对应的权重值.
	 * @param name
	 * @param keys
	 * @return
	 */
	public Map<String, String> multi_hget(String name,List<String> keys)
	{
		Map<String, String>  m = new HashMap<String, String>();
		
		if(keys == null || keys.size() == 0)
		{
			return m;
		}
		Link s = get();

		try
		{
			ArrayList<byte[]> ll = new ArrayList<byte[]>();
			ll.add(name.getBytes(utf8));
			for(String sss : keys)
			{
				ll.add(sss.getBytes(utf8));
			}
			Response resp = s.request("multi_hget", ll);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			
			for(int i=1; i<resp.raw.size(); i+=2){
				byte[] k = resp.raw.get(i);
				byte[] v = resp.raw.get(i+1);
			
				m.put(k == null ? null : new String(k,utf8), v == null? null :new String( v,utf8));
			}
			
			
			
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return m;
	}
	
	public boolean multi_hdel(String name ,List<String> keys)
	{
		if(keys == null || keys.size() == 0)
		{
			return false;
		}
		Link s = get();
//		Map<String, String>  m = null;
		try
		{
			List<byte[]> ll = new ArrayList<byte[]>();
			ll.add(name.getBytes(utf8));
			for(String ssss:keys)
			{
				ll.add(ssss.getBytes(utf8));
				
			}
			
			Response resp = s.request("multi_hdel", ll);
			returnResource(s);
			if(!resp.ok()){
				resp.exception();
			}
			return true;
		}catch(Exception e)
		{
			if(s != null)
			{
				s.close();
			}
			e.printStackTrace();;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		SSDBPool pool = new SSDBPool("192.168.8.228",8888, 2000);
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("v1", "u");
		m.put("v2", "u22");

		System.out.println(pool.multi_hset("hx", m));
		ArrayList<String> kvs = new ArrayList<String>();
		kvs.add("v1");
		kvs.add("v2");
		kvs.add("v3");
		
		
		
		System.out.println(pool.multi_hget("hx", kvs));
		
		System.out.println(pool.multi_hdel("hx", kvs));
		System.out.println(pool.multi_hget("hx", kvs));
		
		
//		System.out.println(pool.qpush_back("h","按时大声的" + System.currentTimeMillis()));
//        System.out.println(pool.qrange("h",0,-1));
    
		pool.close();
	}
	
	
	
	
}
