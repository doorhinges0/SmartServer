package com.fuck.mobile.fastdfs;

import java.io.UnsupportedEncodingException;

import com.fuck.mobile.fastdfs.common.NameValuePair;
import com.fuck.mobile.test.JUnitTestBase;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.serialize.support.kryo.ResponseData;


public class test extends JUnitTestBase {

	@Autowired
	private IFastdfsService fastdfs;

	private long uid = 1470636546502L;

	@Test
	public void testUpload() {
  		byte[] file_buff = null;
  		NameValuePair[] meta_list;
  		String result;
  		String prefix_name;
  		String file_ext_name;
  		String generated_slave_filename;
  		int errno;
  							
  		meta_list = new NameValuePair[4];
  		meta_list[0] = new NameValuePair("width", "800");
  		meta_list[1] = new NameValuePair("heigth", "600");
  		meta_list[2] = new NameValuePair("bgcolor", "#FFFFFF");
  		meta_list[3] = new NameValuePair("author", "Mike");
  		
  		try {
			file_buff = "this is a test".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		System.out.println("file length: " + file_buff.length);

  		//fastdfs.init();
  		result = fastdfs.uploadFile(file_buff, "txt", meta_list);

  	
		System.out.println(result);
	}
}
