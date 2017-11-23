package com.sunrise.common.utils.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class CustomDateFormatDeserializer extends DateFormatDeserializer{
	private String myFormat;
	private static SerializeConfig mapping = new SerializeConfig();
	private static String dateFormat;
	static {
		dateFormat = "yyyy-MM-dd HH:mm:ss";
		mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
	}

	public CustomDateFormatDeserializer(String myFormat) {
		super();
		this.myFormat = myFormat;
	}

	@Override
	protected <Date> Date cast(DefaultJSONParser parser,
			java.lang.reflect.Type clazz, Object fieldName, Object val) {
		if (myFormat == null) {
			return null;
		}
		if (val instanceof String) {
			String strVal = (String) val;
			if (strVal.length() == 0) {
				return null;
			}

			try {
				return (Date) new SimpleDateFormat(myFormat)
						.parse((String) val);
			} catch (ParseException e) {
				throw new JSONException("parse error");
			}
		}
		throw new JSONException("parse error");
	}

}
