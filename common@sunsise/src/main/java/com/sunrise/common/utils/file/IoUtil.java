package com.sunrise.common.utils.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class IoUtil {

  public static byte[] readInputStream(InputStream inputStream, String inputStreamName) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[16*1024];
    try {
      int bytesRead = inputStream.read(buffer);
      while (bytesRead!=-1) {
        outputStream.write(buffer, 0, bytesRead);
        bytesRead = inputStream.read(buffer);
      }
    } catch (Exception e) {
      throw new RuntimeException("couldn't read input stream "+inputStreamName, e);
    }
    return outputStream.toByteArray();
  }
  
  public static String readFileAsString(String filePath) {
    byte[] buffer = new byte[(int) getFile(filePath).length()];
    BufferedInputStream inputStream = null;
    try {
      inputStream = new BufferedInputStream(new FileInputStream(getFile(filePath)));
      inputStream.read(buffer);
    } catch(Exception e) {
      throw new RuntimeException("Couldn't read file " + filePath + ": " + e.getMessage());
    } finally {
      IoUtil.closeSilently(inputStream);
    }
    return new String(buffer);
  }
  
  public static File getFile(String filePath) {
    URL url = IoUtil.class.getClassLoader().getResource(filePath);
    try {
      return new File(url.toURI());
    } catch (Exception e) {
    	e.printStackTrace();
      throw new RuntimeException("Couldn't get file " + filePath + ": " + e.getMessage());
    }
  }
  
  public static void writeStringToFile(String content, String filePath) {
    BufferedOutputStream outputStream = null;
    try {
      outputStream = new BufferedOutputStream(new FileOutputStream(getFile(filePath)));
      outputStream.write(content.getBytes());
      outputStream.flush();
    } catch(Exception e) {
      throw new RuntimeException("Couldn't write file " + filePath, e);
    } finally {
      IoUtil.closeSilently(outputStream);
    }
  }
  
  /**
   * 将字节数组写入文件
   * add by liushd at 2016.1.28
   * @param content
   * @param filePath
 * @throws IOException 
   */
  public static void writeByteToFile(byte[] content, String filePath) throws IOException {
	    BufferedOutputStream outputStream = null;
	    try {
	      outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
	      outputStream.write(content);
	      outputStream.flush();
	    }  finally {
	      IoUtil.closeSilently(outputStream);
	    }
	  }
  
  /**
   * 从文件读取字节数组
   * add by liushd at 2016.1.30
   * @param content
   * @param filePath
 * @throws IOException 
   */
  public static byte[] readByteFromFile(String filePath) throws IOException {
	    BufferedInputStream inputStream = null;
	    ByteArrayOutputStream byteOut = null;
	    try {
	    	inputStream = new BufferedInputStream(new FileInputStream(filePath));
	    	byteOut = new ByteArrayOutputStream();
	    	byte[] buf = new byte[1024];
            int count=0;  
            while ((count = inputStream.read(buf)) != -1) {  
            	byteOut.write(buf, 0, count);  
            }
            return byteOut.toByteArray();
	    }  finally {
	      IoUtil.closeSilently(inputStream);
	      IoUtil.closeSilently(byteOut);
	    }
	  }
  
  /**
   * Closes the given stream. The same as calling {@link InputStream#close()}, but
   * errors while closing are silently ignored.
   */
  public static void closeSilently(InputStream inputStream) {
    try {
      if(inputStream != null) {
        inputStream.close();
      }
    } catch(IOException ignore) {
      // Exception is silently ignored
    }
  }

  /**
   * Closes the given stream. The same as calling {@link OutputStream#close()}, but
   * errors while closing are silently ignored.
   */
  public static void closeSilently(OutputStream outputStream) {
    try {
      if(outputStream != null) {
        outputStream.close();
      }
    } catch(IOException ignore) {
      // Exception is silently ignored
    }
  }
}
