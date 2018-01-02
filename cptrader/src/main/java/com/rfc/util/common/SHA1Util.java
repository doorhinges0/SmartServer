package com.rfc.util.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA1Util {

	private static final char[] hexadecimal = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static final String SHA1="SHA-1";
	public static final String SHA256="SHA-256";
	public static final String SHA384="SHA-384";

	public static byte[] sha1(byte[] data, String type) {
		if (type == null)
			type = SHA1;
		if(data == null)
		{
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance(type);
			return md.digest(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public static String getSHA1String(byte[] data, String type) {
		byte[] b = sha1(data, type);
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
	
	public static String getSHA1String(String data, String type) {
		if(data == null)
		{
			return null;
		}
		return getSHA1String(data.getBytes(), type);
	}

	@SuppressWarnings(value={"unchecked", "rawtypes"})
	public static String getSHA1StringFromUtf8(String data, String type) {
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
		return getSHA1String(z, type);
	}
	
	
	public static void main(String[] args) {
//		for(int i = 0; i <= 10 ;i++)
//		{
//			long s = System.currentTimeMillis();
//			System.out.println(getSHA1StringFromUtf8("ok" + i));
//			System.out.println(System.currentTimeMillis() - s);
//		}
		System.out.println(getSHA1StringFromUtf8("daveliu", SHA1Util.SHA256));
		System.out.println(Sign.sha256Hex("daveliu"));
		System.out.println(getSHA1StringFromUtf8("daveliu", SHA1Util.SHA256));
//		System.out.println(getSHA1StringFromUtf8("123456zyxrAdminkey"));
	}
}
