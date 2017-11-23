package com.fuck.mobile.fastdfs;
import java.util.Map;

import com.fuck.mobile.fastdfs.common.NameValuePair;

/**
 * @author ASPRCK
 *
 */
public interface IFastdfsService {
	
	/**
	 * 初始化
	 */
	//int init();

	/**
	 * @param fileBuff 文件内容
	 * @param fileExtName 文件后缀名
	 * @param metaList 其他属性
	 * @return 文件ID
	 */
	String uploadFile(byte[] fileBuff, String fileExtName,	
		       NameValuePair[] metaList);

	/**
	 * @param fileBuff
	 * @param fileExtName
	 * @return 文件ID
	 */
	String uploadFile(byte[] fileBuff, String fileExtName);
	
	
	String uploadFile(String filePath, String fileExtName);
	
	String uploadFile(String filePath, String fileExtName, NameValuePair[] metaList);

	/** 上传从文件
	 * @param masterFileId
	 * @param prefix
	 * @param path
	 * @param fileExtName
	 * @param metaList
	 * @return
	 */
	String uploadFile(String masterFileId, String prefix, String path, String fileExtName, NameValuePair[] metaList);
	
	byte[] download(String fileId);
	
	int downloadFile(String fileId, String localFile);
	
	FileInfo getFileInfo(String fileId);
	
	
	Map<String, Object> uploadFileName(byte[] fileBuff, String fileName);
}
