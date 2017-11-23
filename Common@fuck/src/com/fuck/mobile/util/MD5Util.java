package com.fuck.mobile.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class MD5Util {
	private static final char[] hexadecimal = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static byte[] md5(byte[] data)
	{
		if(data == null)
		{
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public static String getMd5String(byte[] data)
	{
		byte[] b = md5(data);
		if(b == null)
		{
			return null;
		}
		char[] buffer = new char[b.length * 2];
		for(int i = 0; i < b.length;i++)
		{
			int low = b[i] & 0xF;
			int high = (b[i] & 0xF0) >> 4;
			buffer[(i * 2)] = hexadecimal[high];
			buffer[(i * 2 + 1)] = hexadecimal[low];
		}
		return new String(buffer);
	}
	
	public static String getMd5String(String data)
	{
		if(data == null)
		{
			return null;
		}
		return getMd5String(data.getBytes());
	}
	
	public static String getMd5StringFromUtf8(String data)
	{
		if(data == null)
		{
			return null;
		}
		byte[] z = null;
		try {
			z = data.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
		}
    	int off = 0;
    	if(z!=null && z.length >= 3 && z[0] == (byte)0xEF && z[1] == (byte)0xBB && z[2] == (byte)0xBF)
    	{
    		off = 3;
    		z = Arrays.copyOfRange(z, off, z.length);
    	}
		return getMd5String(z);
	}
	
	
	public static void main(String[] args)
	{
		for(int i = 0; i <= 10 ;i++)
		{
			long s = System.currentTimeMillis();
			System.out.println(getMd5StringFromUtf8("ok" + i));
			System.out.println(System.currentTimeMillis() - s);
		}
		System.out.println(getMd5String("07a159d6db9cec6992f9ba"));
	}
	
}
