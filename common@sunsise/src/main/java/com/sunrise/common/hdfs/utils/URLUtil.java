package com.sunrise.common.hdfs.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;

/**
 *  URL 编码工具类
 */
public class URLUtil {
	
	  private static BitSet safeCharacters;

	  private static final char[] hexadecimal =
	  {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	   'A', 'B', 'C', 'D', 'E', 'F'};

	  static {
	      safeCharacters = new BitSet(256);
	      int i;

	      for (i = 'a'; i <= 'z'; i++) {
	          safeCharacters.set(i);
	      }
 
	      for (i = 'A'; i <= 'Z'; i++) {
	          safeCharacters.set(i);
	      }

	      for (i = '0'; i <= '9'; i++) {
	          safeCharacters.set(i);
	      }

	      safeCharacters.set('$');
	      safeCharacters.set('-');
	      safeCharacters.set('_');
	      safeCharacters.set('.');
	      safeCharacters.set('+');

	      safeCharacters.set('!');
	      safeCharacters.set('*');
	      safeCharacters.set('\'');
	      safeCharacters.set('(');
	      safeCharacters.set(')');
	      safeCharacters.set(',');

	      safeCharacters.set('/');
	      safeCharacters.set(':');
	      safeCharacters.set('@');
	      safeCharacters.set('&');
	      safeCharacters.set('=');
	  }


	  /**
	   * url编码，可编码mime 为 x-www-form-urlencoded类型
	   * @param path
	   * @return
	   */
	  public static String encodePath(String path) {
	    
	      int maxBytesPerChar = 10;
	      StringBuffer rewrittenPath = new StringBuffer(path.length());
	      ByteArrayOutputStream buf = new ByteArrayOutputStream(maxBytesPerChar);
	      OutputStreamWriter writer;
	      try {
	          writer = new OutputStreamWriter(buf, "UTF8");
	      } catch (Exception e) {
	          e.printStackTrace();
	          writer = new OutputStreamWriter(buf);
	      }

	      for (int i = 0; i < path.length(); i++) {
	          int c = path.charAt(i);
	          if (safeCharacters.get(c)) {
	              rewrittenPath.append((char)c);
	          } else {
	              // convert to external encoding before hex conversion
	              try {
	                  writer.write(c);
	                  writer.flush();
	              } catch(IOException e) {
	                  buf.reset();
	                  continue;
	              }
	              byte[] ba = buf.toByteArray();
	              for (int j = 0; j < ba.length; j++) {
	                  // Converting each byte in the buffer
	                  byte toEncode = ba[j];
	                  rewrittenPath.append('%');
	                  int low = (toEncode & 0x0f);
	                  int high = ((toEncode & 0xf0) >> 4);
	                  rewrittenPath.append(hexadecimal[high]);
	                  rewrittenPath.append(hexadecimal[low]);
	              }
	              buf.reset();
	          }
	      }
	      return rewrittenPath.toString();
	  }
	  
}
