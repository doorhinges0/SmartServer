package com.rfc.util.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.*;

/**
 * 功能：公用函数类(生成签名数据)
 * 
 * @author daveliu
 * 
 */

public class Sign {

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式
	public static String sign_type = "MD5";

	/**
	 * 生成要请求给支付的秘钥
	 * 
	 * @param sParaTemp
	 *            请求前的参数数组
	 * @return String
	 */
	public static String buildRequestPara(Map<String, Object> sParaTemp, String key) {
		// 除去数组中的空值和签名参数
		Map<String, Object> sPara = Sign.paraFilter(sParaTemp);
		// 生成签名结果
		String mysign = buildRequestMysign(sPara, key);
		return mysign;
	}

	/**
	 * 生成签名结果
	 * 
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	public static String buildRequestMysign(Map<String, Object> sPara, String key) {
		String prestr = Sign.createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
		String mysign = "";
		if (Sign.sign_type.equals("MD5")) {
			mysign = Sign.sign(prestr, key, Sign.input_charset);
		}
		return mysign;
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, Object> paraFilter(Map<String, Object> sArray) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = (String)sArray.get(key);
			if (value == null || "".equals(value)) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuffer prestr = new StringBuffer("");
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = (String)params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr.append(key)//
						.append("=")//
						.append(value);
			} else {
				prestr.append(key)//
						.append("=")//
						.append(value)//
						.append("&");
			}
		}
		return prestr.toString();
	}


	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 *
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkStringNoSort(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
//		Collections.sort(keys);
		StringBuffer prestr = new StringBuffer("");
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = (String)params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr.append(key)//
						.append("=")//
						.append(value);
			} else {
				prestr.append(key)//
						.append("=")//
						.append(value)//
						.append("&");
			}
		}
		return prestr.toString();
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String input_charset) {
		text = text + key;
		return DigestUtils.md5Hex(getContentBytes(text, input_charset));
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * Base64 encode
	 * */
	public static String base64Encode(String data){
		return Base64.encodeBase64String(data.getBytes());
	}

	/**
	 * Base64 decode
	 * @throws UnsupportedEncodingException
	 * */
	public static String base64Decode(String data) throws UnsupportedEncodingException{
		return new String(Base64.decodeBase64(data.getBytes()),"utf-8");
	}

	/**
	 * md5
	 * */
	public static String md5Hex(String data){
		return DigestUtils.md5Hex(data);
	}

	/**
	 * sha1
	 * */
	public static String sha1Hex(String data){
		return DigestUtils.sha1Hex(data);
	}

	/**
	 * sha256
	 * */
	public static String sha256Hex(String data){
		return DigestUtils.sha256Hex(data);
	}

}
