package com.sunrise.common.utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

	private static final Logger log = LoggerFactory.getLogger(LogUtils.class);
	
	
	public static void info(String msg){
		if (log.isInfoEnabled()){
			log.info(msg);
		}
	}
	
	public static void info(String msg,Class<?> clazz){
		Logger log = LoggerFactory.getLogger(clazz);
		if (log.isInfoEnabled()){
			log.info(msg);
		}
	}
	
	public static void info(Logger log,String msg){
		if (log.isInfoEnabled()){
			log.info(msg);
		}
	}
	
	
	public static void debug(String msg){
		if (log.isDebugEnabled()){
			log.debug(msg);
		}
	}
	
	public static void warn(String msg){
		if (log.isWarnEnabled()){
			log.warn(msg);
		}
	}
	
	public static void error(String msg){
		if (log.isErrorEnabled()){
			log.error(msg);
		}
	}
	
	public static void debug(String format,String...args){
		if (log.isDebugEnabled()){
			log.debug(format,args);
		}
	}
	
	public static void warn(String format,String...args){
		if (log.isWarnEnabled()){
			log.warn(format,args);
		}
	}
	
	public static void error(String format,String...args){
		if (log.isErrorEnabled()){
			log.error(format,args);
		}
	}
	
	public static void debug(Logger log,String msg){
		if (log.isDebugEnabled()){
			log.debug(msg);
		}
	}
	
	public static void warn(Logger log, Throwable t, String msg){
		if (log.isWarnEnabled()){
			log.warn(msg, t);
		}
	}
	
	public static void warn(Logger log,String msg){
		if (log.isWarnEnabled()){
			log.warn(msg);
		}
	}
	
	public static void error(Logger log,String msg){
		if (log.isErrorEnabled()){
			log.error(msg);
		}
	}
	
	public static void debug(Logger log,String format,String...args){
		if (log.isDebugEnabled()){
			log.debug(format,args);
		}
	}
	
	public static void warn(Logger log,String format,String...args){
		if (log.isWarnEnabled()){
			log.warn(format,args);
		}
	}
	
	public static void error(Logger log,String format,String...args){
		if (log.isErrorEnabled()){
			log.error(format,args);
		}
	}
}
