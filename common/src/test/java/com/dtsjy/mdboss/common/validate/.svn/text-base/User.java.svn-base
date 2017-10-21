package com.dtsjy.mdboss.common.validate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.dtsjy.mdboss.common.utils.json.CustomDateFormatDeserializer;

public class User {
	public String name;
	public int height;

	@JSONField(name = "com-google-com")
	public void setName(String name) {
		this.name = name;
	}

	// @JSONField(format = "yyyy-MM/dd HH:mm:ss")
	public Date birthday;
	
	public static void main(String[] args) throws IOException, ParseException {

		String json = "{\"name\":\"22323\", \"age\": 1234,"
				+ " \"birthday\": \"2012-12/12 12:12:12\"}";
		ParserConfig config = new ParserConfig();
		config.putDeserializer(Date.class, new CustomDateFormatDeserializer(
				"yyyy-MM/dd HH:mm:ss"));
		User t = JSON.parseObject(json, User.class, config,
				JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
		System.out.println(t.name);
		System.out.println(t.height);
		System.out.println(t.birthday);
		System.out.println(new SimpleDateFormat("yyyy-MM/dd HH:mm:ss")
				.parse("2012-12/12 12:12:12"));

		json = "{\"name\":\"22323\", \"age\": 1234,"
				+ " \"birthday\": \"2012-12-12 12:12:12\"}";
		t = JSON.parseObject(json, User.class);
		System.out.println(json);
		System.out.println(t.birthday);

		json = "[{'name':'22323', 'age': 1234, 'birthday': '2012-12/12 12:12:12'},{'name':'22323', 'age': 1234, 'birthday': '2012-12/12 12:12:12'}]";
		System.out.println(JSON.parseArray(json).toString());
		JSON.toJavaObject(JSON.parseArray(json), List.class);
		
		List<User> dates = JSON.parseObject(json,List.class, config,
					JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);//只能得到List<JSONObjcet>
		
		
		dates = JSON.parseObject(json, new TypeReference<List<User>>() {
		}.getType(), config, JSON.DEFAULT_PARSER_FEATURE);//成功转换为List<User>
		
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM/dd HH:mm:ss";//临时修改日期模式，由于是全局的，可能对其它正执行的转换有影响
		dates = JSON.parseObject(json,
				new TypeReference<List<User>>() {
				});
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		
		
		System.out.println(dates.size());
		System.out.println(JSON.toJSONString(dates));
		System.out.println(JSON.toJSONString(dates,
				SerializerFeature.WriteDateUseDateFormat));
		System.out.println(JSON.toJSONStringWithDateFormat(dates, "yyyy-MM-dd",
				new SerializerFeature[0]));
		
		SerializeConfig mapping = new SerializeConfig();  
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		 mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat)); 
		System.out.println(JSON.toJSONString(JSON.parse(json), mapping));//不能转换
	}
}
