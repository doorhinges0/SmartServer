package com.sunrise.common.model;

/**
 * 在线程级别保存应用编码、交易流水号、操作用户编码
 * @author livan.c
 *
 */
public class SerialNoHolder {
	public  static ThreadLocal<String> serialNo = new ThreadLocal<String>();//交易流程号
	public  static ThreadLocal<String> userCode = new ThreadLocal<String>();//用户编码
	public  static ThreadLocal<String> appcode = new ThreadLocal<String>();//应用编码
	
	public  static ThreadLocal<ReqParamsVO> reqParams = new ThreadLocal<ReqParamsVO>();//应用编码
}
