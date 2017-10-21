package com.dtsjy.mdboss.common.utils.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtsjy.mdboss.common.utils.log.LogUtils;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class NumberToolkit {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberToolkit.class);
	
	public static Integer ONE = new Integer(1);
	
	public static Integer TWO = new Integer(2);
	
	public static Integer THREE = new Integer(3);
	
	public static String formatNumber(String code, String format) {
		String value = code;
		try {
			NumberFormat nf;
			if (StringToolkit.isEmpty(format)) {
				nf = NumberFormat.getInstance();
				nf.setParseIntegerOnly(true);
				nf.setMaximumFractionDigits(0);
			} else {
				nf = new DecimalFormat(format);
			}
			double dValue = Double.parseDouble(value);
			value = nf.format(dValue);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.info(logger,"转换数字字符串'" + code + "'为格式'" + format + "'时出错!");
		}
		return value;
	}
}
