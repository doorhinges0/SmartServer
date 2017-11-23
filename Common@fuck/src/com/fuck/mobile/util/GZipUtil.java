package com.fuck.mobile.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GZipUtil {

	/**
	 * @category gzip 压缩
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static byte[] gzipCompress(byte[] data) throws IOException
	{
		ByteArrayOutputStream bb = new ByteArrayOutputStream();
		GZIPOutputStream out = new GZIPOutputStream(bb);
		out.write(data);
		out.flush();
		out.close();
		byte[] b = bb.toByteArray();
		bb.close();
		return b;
	}
	
	/**
	 * @category gzip解压
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static byte[] gzipDecompress(byte[] data) throws IOException
	{
		ByteArrayOutputStream bb = new ByteArrayOutputStream();
		InputStream in = new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(data)));
		byte[] b = new byte[1024];
		int k = in.read(b);
		while(k > 0)
		{
			bb.write(b, 0, k);
			k = in.read(b);
		}
		in.close();
		b = bb.toByteArray();
		bb.close();
		return b;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		byte[] ddd = new byte[]{1,2,3,4,5,6};
		byte[] d = gzipCompress(ddd);
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(gzipDecompress(d)));
	}
	
	
}
