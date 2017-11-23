package com.fuck.mobile.base.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

public class SqlRowSetEx implements SqlRowSet{
	private static final long serialVersionUID = -8484369489903803904L;
	static Log log = LogFactory.getLog(SqlRowSetEx.class);
	private SqlRowSet p;

	public SqlRowSetEx(SqlRowSet p) {
		this.p = p;
	}

	@Override
	public boolean absolute(int arg0) throws InvalidResultSetAccessException {
		return p.absolute(arg0);
	}

	@Override
	public void afterLast() throws InvalidResultSetAccessException {
		p.afterLast();
	}

	@Override
	public void beforeFirst() throws InvalidResultSetAccessException {
		p.beforeFirst();
	}

	@Override
	public int findColumn(String arg0) throws InvalidResultSetAccessException {

		return p.findColumn(arg0);
	}

	@Override
	public boolean first() throws InvalidResultSetAccessException {

		return p.first();
	}

	@Override
	public BigDecimal getBigDecimal(int arg0) throws InvalidResultSetAccessException {
		return p.getBigDecimal(arg0);
	}

	@Override
	public BigDecimal getBigDecimal(String arg0) throws InvalidResultSetAccessException {
		return p.getBigDecimal(arg0);
	}

	@Override
	public boolean getBoolean(int arg0) throws InvalidResultSetAccessException {
		return p.getBoolean(arg0);
	}

	@Override
	public boolean getBoolean(String arg0) throws InvalidResultSetAccessException {
		return p.getBoolean(arg0);
	}

	@Override
	public byte getByte(int arg0) throws InvalidResultSetAccessException {

		return p.getByte(arg0);
	}

	@Override
	public byte getByte(String arg0) throws InvalidResultSetAccessException {

		return p.getByte(arg0);
	}

	@Override
	public Date getDate(int arg0) throws InvalidResultSetAccessException {

		return p.getDate(arg0);
	}

	@Override
	public Date getDate(String arg0) throws InvalidResultSetAccessException {

		return p.getDate(arg0);
	}

	@Override
	public Date getDate(int arg0, Calendar arg1) throws InvalidResultSetAccessException {

		return p.getDate(arg0, arg1);
	}

	@Override
	public Date getDate(String arg0, Calendar arg1) throws InvalidResultSetAccessException {
		return p.getDate(arg0, arg1);
	}

	@Override
	public double getDouble(int arg0) throws InvalidResultSetAccessException {
		return p.getDouble(arg0);
	}

	@Override
	public double getDouble(String arg0) throws InvalidResultSetAccessException {
		return p.getDouble(arg0);
	}

	@Override
	public float getFloat(int arg0) throws InvalidResultSetAccessException {
		return p.getFloat(arg0);
	}

	@Override
	public float getFloat(String arg0) throws InvalidResultSetAccessException {

		return p.getFloat(arg0);
	}

	@Override
	public int getInt(int arg0) throws InvalidResultSetAccessException {
		return p.getInt(arg0);
	}

	@Override
	public int getInt(String arg0) throws InvalidResultSetAccessException {
		return p.getInt(arg0);
	}

	@Override
	public long getLong(int arg0) throws InvalidResultSetAccessException {
		return p.getLong(arg0);
	}

	@Override
	public long getLong(String arg0) throws InvalidResultSetAccessException {
		return p.getLong(arg0);
	}

	@Override
	public SqlRowSetMetaData getMetaData() {
		return p.getMetaData();
	}

	@Override
	public Object getObject(int arg0) throws InvalidResultSetAccessException {
		return p.getObject(arg0);
	}

	@Override
	public Object getObject(String arg0) throws InvalidResultSetAccessException {
		return p.getObject(arg0);
	}

	@Override
	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws InvalidResultSetAccessException {
		return p.getObject(arg0, arg1);
	}

	@Override
	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws InvalidResultSetAccessException {
		return p.getObject(arg0, arg1);
	}

	@Override
	public int getRow() throws InvalidResultSetAccessException {
		return p.getRow();
	}

	@Override
	public short getShort(int arg0) throws InvalidResultSetAccessException {
		return p.getShort(arg0);
	}

	@Override
	public short getShort(String arg0) throws InvalidResultSetAccessException {
		return p.getShort(arg0);
	}

	@Override
	public String getString(int arg0) throws InvalidResultSetAccessException {
		return p.getString(arg0);
	}

	@Override
	public String getString(String arg0) throws InvalidResultSetAccessException {

		return p.getString(arg0);
	}

	@Override
	public Time getTime(int arg0) throws InvalidResultSetAccessException {
		return p.getTime(arg0);
	}

	@Override
	public Time getTime(String arg0) throws InvalidResultSetAccessException {
		return p.getTime(arg0);
	}

	@Override
	public Time getTime(int arg0, Calendar arg1) throws InvalidResultSetAccessException {
		return p.getTime(arg0, arg1);
	}

	@Override
	public Time getTime(String arg0, Calendar arg1) throws InvalidResultSetAccessException {
		return p.getTime(arg0, arg1);
	}

	@Override
	public Timestamp getTimestamp(int arg0) throws InvalidResultSetAccessException {
		return p.getTimestamp(arg0);
	}

	@Override
	public Timestamp getTimestamp(String arg0) throws InvalidResultSetAccessException {
		return p.getTimestamp(arg0);
	}

	@Override
	public Timestamp getTimestamp(int arg0, Calendar arg1) throws InvalidResultSetAccessException {
		return p.getTimestamp(arg0, arg1);
	}

	@Override
	public Timestamp getTimestamp(String arg0, Calendar arg1) throws InvalidResultSetAccessException {
		return p.getTimestamp(arg0, arg1);
	}

	@Override
	public boolean isAfterLast() throws InvalidResultSetAccessException {
		return p.isAfterLast();
	}

	@Override
	public boolean isBeforeFirst() throws InvalidResultSetAccessException {
		return p.isBeforeFirst();
	}

	@Override
	public boolean isFirst() throws InvalidResultSetAccessException {
		return p.isFirst();
	}

	@Override
	public boolean isLast() throws InvalidResultSetAccessException {

		return p.isLast();
	}

	@Override
	public boolean last() throws InvalidResultSetAccessException {
		return p.last();
	}

	@Override
	public boolean next() throws InvalidResultSetAccessException {
		return p.next();
	}

	@Override
	public boolean previous() throws InvalidResultSetAccessException {
		return p.previous();
	}

	@Override
	public boolean relative(int arg0) throws InvalidResultSetAccessException {

		return p.relative(arg0);
	}

	@Override
	public boolean wasNull() throws InvalidResultSetAccessException {
		return p.wasNull();
	}

	// ------------------------------------------------------

	public Character getCharacter(String arg0) throws InvalidResultSetAccessException {
		Character ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Character) {
				ret = (Character) o;
			} else {
				String oo = o.toString();
				if (oo.length() > 0) {
					ret = oo.charAt(0);
				}
			}
		}
		return ret;
	}

	public Character getCharacter(int arg0) throws InvalidResultSetAccessException {
		Character ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Character) {
				ret = (Character) o;
			} else {
				String oo = o.toString();
				if (oo.length() > 0) {
					ret = oo.charAt(0);
				}
			}
		}
		return ret;
	}

	public Byte getBYTE(int arg0) throws InvalidResultSetAccessException {
		Byte ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).byteValue();
			} else {
				ret = Byte.parseByte(o.toString());
			}
		}
		return ret;
	}

	public Byte getBYTE(String arg0) throws InvalidResultSetAccessException {
		Byte ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).byteValue();
			} else {
				ret = Byte.parseByte(o.toString());
			}
		}
		return ret;
	}
	
	
	public Short getSHORT(int arg0) throws InvalidResultSetAccessException {
		Short ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).shortValue();
			} else {
				ret = Short.parseShort(o.toString());
			}
		}
		return ret;
	}

	public Short getSHORT(String arg0) throws InvalidResultSetAccessException {
		Short ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).shortValue();
			} else {
				ret = Short.parseShort(o.toString());
			}
		}
		return ret;
	}
	
	

	public Double getDOUBLE(int arg0) throws InvalidResultSetAccessException {
		Double ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).doubleValue();
			} else {
				ret = Double.parseDouble(o.toString());
			}
		}
		return ret;
	}

	public Double getDOUBLE(String arg0) throws InvalidResultSetAccessException {
		Double ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).doubleValue();
			} else {
				ret = Double.parseDouble(o.toString());
			}
		}
		return ret;
	}

	public Float getFLOAT(int arg0) throws InvalidResultSetAccessException {
		Float ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).floatValue();
			} else {
				ret = Float.parseFloat(o.toString());
			}
		}
		return ret;
	}

	public Float getFLOAT(String arg0) throws InvalidResultSetAccessException {

		Float ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).floatValue();
			} else {
				ret = Float.parseFloat(o.toString());
			}
		}
		return ret;
	}

	public Integer getINT(int arg0) throws InvalidResultSetAccessException {
		Integer ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).intValue();
			} else {
				ret = Integer.parseInt(o.toString());
			}
		}
		return ret;
	}

	public Integer getINT(String arg0) throws InvalidResultSetAccessException {
		Integer ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).intValue();
			} else {
				ret = Integer.parseInt(o.toString());
			}
		}
		return ret;
	}

	public Long getLONG(int arg0) throws InvalidResultSetAccessException {
		Long ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).longValue();
			} else {
				ret = Long.parseLong(o.toString());
			}
		}
		return ret;
	}

	public Long getLONG(String arg0) throws InvalidResultSetAccessException {
		Long ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Number) {
				ret = ((Number) o).longValue();
			} else {
				ret = Long.parseLong(o.toString());
			}
		}
		return ret;
	}

	public Boolean getBOOLEAN(int arg0) throws InvalidResultSetAccessException {
		Boolean ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Boolean) {
				ret = (Boolean) o;
			} else {
				String str = o.toString();

				ret = "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str) || "1".equals(str) || "y".equalsIgnoreCase(str) || "t".equalsIgnoreCase(str);
			}
		}
		return ret;

	}

	public Boolean getBOOLEAN(String arg0) throws InvalidResultSetAccessException {
		Boolean ret = null;
		Object o = p.getObject(arg0);
		if (o != null) {
			if (o instanceof Boolean) {
				ret = (Boolean) o;
			} else {
				String str = o.toString();

				ret = "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str) || "1".equals(str) || "y".equalsIgnoreCase(str) || "t".equalsIgnoreCase(str);
			}
		}
		return ret;
	}

	public Long getDateAsLong(int arg0) throws InvalidResultSetAccessException {

		Long l = null;
		Date d = p.getDate(arg0);
		if (d != null) {
			l = d.getTime();
		}
		return l;
	}

	public Long getDateAsLong(String arg0) throws InvalidResultSetAccessException {
		Long l = null;
		Date d = p.getDate(arg0);
		if (d != null) {
			l = d.getTime();
		}
		return l;
	}

	static class FieldObject {
		public Field f;
		public int index;
		FieldObject(Field f,int index)
		{
			this.f= f;
			this.index = index;
		}
	}
	
	
	//把一个字符串中的大写转为小写，小写转换为大写：思路1  
	private  String exChange(String str){  
	    StringBuffer sb = new StringBuffer();  
	    if(str!=null){  
	        for(int i=0;i<str.length();i++){  
	            char c = str.charAt(i);  
	            if(Character.isUpperCase(c)){  
	                sb.append("_").append(Character.toLowerCase(c));  
	            }else{
	            	 sb.append(c);   
	            }
	        }  
	    }  
	      
	    return sb.toString();  
	}  

	
	/**
	 * 自动填充对象
	 * 
	 * @param obj
	 * @throws InvalidResultSetAccessException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T> List<T> fillObject(Class<T> c) {
		List<T> ret = new ArrayList<T>();
		try
		{
		Field[] ff = c.getFields();
		ArrayList<FieldObject> fobj = new ArrayList<SqlRowSetEx.FieldObject>();
		for (Field f : ff) {
			try {
				if(Modifier.isStatic(f.getModifiers()) || Modifier.isPrivate(f.getModifiers()) || Modifier.isFinal(f.getModifiers()))
				{
					continue;
				}
				int cindex = -1;
				try
				{
				cindex = this.findColumn(exChange(f.getName()));
				}catch(Exception ex)
				{
				}
				
				if(cindex >= 0)
				{
					fobj.add(new FieldObject(f, cindex));
				}
			} catch (Exception ex) {
				log.debug("fillObject", ex);
			}
		}
		while (next()) {
			T objc = c.newInstance();;
			for(FieldObject o : fobj)
			{
				Object retobj = null;
				if(o.f.getType() == String.class)
				{
					retobj = getString(o.index);
				}else if(o.f.getType() == Byte.class)
				{
					retobj = getBYTE(o.index);
				}else if(o.f.getType() == BigDecimal.class)
				{
					retobj = getBigDecimal(o.index);
				}else if(o.f.getType() == Boolean.class)
				{
					retobj = getBOOLEAN(o.index);
				}else if(o.f.getType() == Character.class)
				{
					retobj = getCharacter(o.index);
				}else if(o.f.getType() == Date.class)
				{
					retobj = getDate(o.index);
				}else if(o.f.getType() == Double.class)
				{
					retobj = getDOUBLE(o.index);
				}else if(o.f.getType() == Float.class)
				{
					retobj = getFLOAT(o.index);
				}else if(o.f.getType() == Integer.class)
				{
					retobj = getINT(o.index);
				}else if(o.f.getType() == Long.class)
				{
					retobj = getLONG(o.index);
				}else if(o.f.getType() == Short.class)
				{
					retobj = getSHORT(o.index);
				}else if(o.f.getType() == Time.class)
				{
					retobj = getTime(o.index);
				}else if(o.f.getType() == Timestamp.class)
				{
					retobj = getTimestamp(o.index);
				}else 
				{
					retobj = getObject(o.index);
				}
				if(o.f.getType().isEnum())
				{
					 Method m = o.f.getType().getMethod("ObjectFromNumber", Number.class);
					 retobj = m.invoke(null, retobj);
				}
				if(retobj == null && o.f.getType().isPrimitive())
				{
					//不处理
					
				}else
				{
					o.f.set(objc, retobj);
				}
			
				
			}
			ret.add(objc);
		}
		}catch(Exception ex)
		{
			throw new DataAccessException("fillObject",ex) {
				private static final long serialVersionUID = -5753662451433380145L;
			};
		}
		return ret;
	}

	@Override
	public String getNString(int paramInt)
			throws InvalidResultSetAccessException {
		
		return p.getNString(paramInt);
	}

	@Override
	public String getNString(String paramString)
			throws InvalidResultSetAccessException {
		
		return p.getNString(paramString);
	}

	@Override
	public <T> T getObject(int paramInt, Class<T> paramClass)
			throws InvalidResultSetAccessException {
		
		return p.getObject(paramInt, paramClass);
	}

	@Override
	public <T> T getObject(String paramString, Class<T> paramClass)
			throws InvalidResultSetAccessException {
	
		return p.getObject(paramString,paramClass);
	}
}
