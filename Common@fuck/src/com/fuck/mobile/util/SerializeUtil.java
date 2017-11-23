package com.fuck.mobile.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.fuck.mobile.base.common.Pager;

public class SerializeUtil {
	
	public static Object deserialize(byte[] objectData) {
		if (objectData == null) {
			throw new IllegalArgumentException("The byte[] must not be null");
		}
		
		Kryo kro = new Kryo();
		kro.setReferences(true);  
		kro.setRegistrationRequired(false);  
			
		kro.setClassLoader(Thread.currentThread().getContextClassLoader());
		Object o =	kro.readClassAndObject(new Input(objectData));
		return o;
	}
	
	public static byte[] serialize(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("The obj must not be null");
		}
		
		Kryo kro = new Kryo();
		kro.setReferences(true);  
		kro.setRegistrationRequired(false); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Output output = new Output(out);
		
		kro.writeClassAndObject(output, obj);
		output.close();
		byte[] b = out.toByteArray();
		try {
			out.close();
		} catch (IOException e) {
		}
		return b;
	}
	
	public static void main(String[] args) {

		Pager p = new Pager();
		p.setTotalCount(100);
		p.setPageSize(10);
		p.setCurrPageNo("0");
		
		byte[] b2 = serialize(p);
		String s2 = Base64.ToBase64String(b2);
		System.out.println(s2);
		
		byte[] d2 = Base64.FromBase64String(s2);
		
		Object o2 = deserialize(d2);
		 
		Pager p2 = (Pager)o2;
		System.out.println(p2.toString());
		
	}
	
}
