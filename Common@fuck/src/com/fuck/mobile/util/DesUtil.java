package com.fuck.mobile.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

 
public class DesUtil {

	private final static String DES = "DES";
	
	/**
	 * @category  must be 8 bytes long
	 */
	private final static String KEY = "fuck.com";

	public static void main(String[] args) throws Exception
	{
		String data = "18664872695";
		String s = encrypt(data);
		System.err.println(s);
		System.err.println(decrypt(s));

	}

	public static String encrypt(String message) throws Exception
	{
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(KEY.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return toHexString(cipher.doFinal(message.getBytes("UTF-8")));
	}

	public static String decrypt(String message) throws Exception
	{

		byte[] bytesrc = convertHexString(message);

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

		IvParameterSpec iv = new IvParameterSpec(KEY.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	public static byte[] convertHexString(String ss)
	{
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++)
		{
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		return digest;
	}

	public static String toHexString(byte b[])
	{
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++)
		{
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2) plainText = "0" + plainText;

			hexString.append(plainText);
		}

		return hexString.toString();
	}
}
