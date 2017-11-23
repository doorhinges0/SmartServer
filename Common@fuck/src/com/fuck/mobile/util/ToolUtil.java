package com.fuck.mobile.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

public class ToolUtil {

	private static Gson gson = new Gson();

	private static Log log = LogFactory.getLog(ToolUtil.class);

	private static final String BANK_CARD_KEY = "8e8d9065c3e2f62ed637ffc402f32565";
	// public static final String BANK_CARD_KEY =
	// "09d6b87fb1bf5458be4d0004fc7a7b63a17eb669";
	private static final byte[] BANK_CARD_JAVA_KEY = new byte[16];

	static {
		int i = 0;
		try {
			for (byte b : BANK_CARD_KEY.getBytes("UTF-8"))
				BANK_CARD_JAVA_KEY[i++ % 16] ^= b;
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
	}


	public static String mapToJson(Map<String, Object> map) {
		return gson.toJson(map);
	}

	public static void main(String[] args) {
//		System.out.println(aesEncrypt("6214856554438255"));
//		System.out.println(aesEncrypt("6217002710001564119"));
//		System.out.println(aesEncrypt("6217002710120614119"));
		// System.out.println(aesDecrypt("563B9F197E6939EBC15F6414B65369CE218447A0AE058744D68362815D3A2D05"));
//		System.out.println(aesDecrypt("D3E31BBFF3E2475E7E2EA10E8D2DCCEAB79D3A969D48290964C3A14C0B5825B1"));
		// System.out.println(aesDecrypt("FD6F31556B56265544B6D4F3816370200D356DCB3D89D170E95F798ECE729190"));
	}

	/**
	 * AES加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @return
	 */
	public static String aesEncrypt(String content) {
		return parseByte2HexStr(aesEncryptByte(content));
	}

	/**
	 * AES加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @return byte
	 */
	public static byte[] aesEncryptByte(String content) {
		try {
			// KeyGenerator kgen = KeyGenerator.getInstance("AES");
			// SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			// random.setSeed(BANK_FINAL_KEY);
			// kgen.init(128, random);
			// SecretKey secretKey = kgen.generateKey();
			// byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(BANK_CARD_JAVA_KEY, "AES");
			// final byte[] finalKey = new byte[16];
			// int i = 0;
			// for (byte b : BANK_CARD_KEY.getBytes("UTF-8"))
			// finalKey[i++ % 16] ^= b;
			// System.out.println(parseByte2HexStr(finalKey));
			// SecretKeySpec key = new SecretKeySpec(finalKey, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			return cipher.doFinal(byteContent);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * AES解密
	 * 
	 * @param content
	 *            待解密内容
	 * @return
	 */
	public static String aesDecrypt(String content) {
		try {
			// KeyGenerator kgen = KeyGenerator.getInstance("AES");
			// SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			// random.setSeed(BANK_CARD_KEY.getBytes());
			// kgen.init(128, random);
			// SecretKey secretKey = kgen.generateKey();
			// byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(BANK_CARD_JAVA_KEY, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(parseHexStr2Byte(content));
			return new String(result); // 加密
		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
		} catch (InvalidKeyException e) {
//			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
		} catch (BadPaddingException e) {
//			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
}
