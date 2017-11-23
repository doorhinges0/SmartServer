package com.sunrise.common.utils.string;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

import com.sunrise.ucp.dal.gen.model.UserVO;

public class ObjectUtil {
	public static String getAttribute(Object obj) {

		String objStr = obj.getClass().getName() + "@"
				+ Integer.toHexString(obj.hashCode());

		StringBuffer sb = new StringBuffer(objStr);
		sb.append("\n{\n");

		Method[] ms = obj.getClass().getMethods();
		for (Method m : ms) {
			String name = m.getName();
			if (name.indexOf("get") == 0 && !"getClass".equals(name)) {
				Object value;
				try {
					value = m.invoke(obj, new Object[] {});
				} catch (Exception e) {
					value = "exception = " + e.getMessage();
				}
				sb.append("\t").append(m.getName().substring(3)).append(" : ")
						.append(value).append("\n");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public static Object ByteToObject(byte[] bytes) {
		Object obj = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			obj = oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static byte[] ObjectToByte(java.lang.Object obj) {
		byte[] bytes = null;
		try {
			// object to bytearray
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);

			bytes = bo.toByteArray();

			bo.close();
			oo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	public static void main(String[] args) {
		System.out.println(getAttribute(new UserVO()));
	}
}
