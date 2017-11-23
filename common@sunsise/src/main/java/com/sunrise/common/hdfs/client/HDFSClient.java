package com.sunrise.common.hdfs.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.apache.hadoop.security.authentication.client.AuthenticationException;

/**
 * HDFS 客户端接口
 *
 * @author cola
 * @version 2016年6月1日
 */
public interface HDFSClient {
	
	/**
	 * 获取主目录
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getHomeDirectory() throws MalformedURLException, IOException,AuthenticationException;
	
	/**
	 * 新建文件
	 * @param path
	 * @param is
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String create(String path, InputStream is) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 新建目录，可递归
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String mkdirs(String path) throws MalformedURLException, IOException, AuthenticationException ;

	/**
	 * 删除文件或者目录
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String delete(String path) throws MalformedURLException, IOException, AuthenticationException ;

	/**
	 * 获取文件状态
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public  String getFileStatus(String path) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 重命名文件
	 * @param srcPath
	 * @param destPath
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String rename(String srcPath, String destPath) throws MalformedURLException, IOException, AuthenticationException ;	

	/**
	 * 获取当前目录及文件状态
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public  String listStatus(String path) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 打开文件
	 * @param path
	 * @param os
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String open(String path, OutputStream os) throws MalformedURLException, IOException, AuthenticationException ;

	
	/**
	 * 追加文件内容
	 * @param path
	 * @param is
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String append(String path, InputStream is) throws MalformedURLException, IOException, AuthenticationException;

	
	/**
	 * 创建文件快捷方式
	 * @param srcPath
	 * @param destPath
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String createSymLink(String srcPath, String destPath) throws MalformedURLException, IOException,
	AuthenticationException;
	
	/**
	 * 获取文件或路径的汇总信息（如文件数，长度等）
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String getContentSummary(String path) throws MalformedURLException, IOException, AuthenticationException;
	
	/**
	 * 获取文件校验汇总
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String getFileCheckSum(String path) throws MalformedURLException, IOException, AuthenticationException;

	
	/**
	 * 修改文件所有者
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String setOwner(String path) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 设置文件或者路径权限
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String setPermission(String path) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 设置HDFS文件副本集数量
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String setReplication(String path) throws MalformedURLException, IOException, AuthenticationException;

	/**
	 * 修改文件的accesstime 和 modificationtime
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	public String setTimes(String path) throws MalformedURLException, IOException, AuthenticationException;

}
