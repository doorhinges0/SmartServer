package com.fuck.mobile.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.base.exception.BaseException;
import com.fuck.mobile.common.IZooKeeperConfig;
import com.fuck.mobile.fastdfs.common.MyException;
import com.fuck.mobile.fastdfs.common.NameValuePair;
import com.fuck.mobile.util.FileTypeUtil;
import com.fuck.mobile.util.FileUtil;


@Service
public class FastdfsServiceImp implements IFastdfsService {

	static Log log = LogFactory.getLog(FastdfsServiceImp.class);
	

	private TrackerGroup trackerGroup;
	private TrackerClient trackerClient;
	
	@Autowired
	IZooKeeperConfig zkConfig;

	
	
	
	@PostConstruct
	public int init() {
		log.debug("FastdfsServiceImp init------------");
		try {
			ClientGlobal.init(zkConfig);
			
			//访问路径
			zkConfig.dataChanges("YunWei/Fastdfs/FastdfsAccessBasePath",Constants.FastdfsAccessBasePath,"http://192.168.0.206");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -3;
		}
		trackerGroup = ClientGlobal.g_tracker_group;
		trackerClient = new TrackerClient(trackerGroup);
		return 0;
	}

	@Override
	public String uploadFile(byte[] fileBuff, String fileExtName, NameValuePair[] metaList) {
		TrackerServer trackerServer = null;
		try {
			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				log.error("get trackerServer is null");
				throw new BaseException(1001, "get trackerServer is null");
			}
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			if (storageServer == null) {
				log.error("get storageServer is null");
				throw new BaseException(1002,"get storageServer is null");
			}
			StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
			String fileId = storageClient.upload_file1(fileBuff, fileExtName, metaList);
			if (StringUtils.isEmpty(fileId)) {
				log.error("file upload fail");
				throw new BaseException(1003, "file upload fail");
			}
			return fileId;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("file upload fail");
			return null;
		}finally{
			try {
				if (trackerServer != null) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String uploadFile(byte[] fileBuff, String fileExtName) {
		return uploadFile(fileBuff, fileExtName, null);
	}
	
	
	@Override
	public String uploadFile(String filePath, String fileExtName){
		return uploadFile(filePath, fileExtName, null);
	}
	
	@Override
	public String uploadFile(String filePath, String fileExtName, NameValuePair[] metaList){
		StorageClient1 storageClient = getStorageClient();
		try {
			String fileId = storageClient.upload_file1(filePath, fileExtName, metaList);
			if (fileId == null) {
				throw new BaseException(1005, "upload file fail");
			}
			return fileId;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally{
			if (storageClient != null) {
				try {
					storageClient.getTrackerServer().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public String uploadFile(String masterFileId, String prefix, String path, String fileExtName, NameValuePair[] metaList){
		StorageClient1 storageClient = getStorageClient();
		try {
			String fileId = storageClient.upload_file1(masterFileId, prefix, path, fileExtName, metaList);
			if (fileId == null) { //先判断slave文件是否是已经上传，如果是已经上传则正常返回
				FileInfo fileInfo = storageClient.query_file_info1(getSlaveFileId(masterFileId, "_small"));
				if (fileInfo == null) {
					log.error("upload slave file fail, fileid="+masterFileId);
					throw new BaseException(1009, "upload file fail");
				} else {
					log.info("file["+masterFileId+"] 文件的slave文件已存在，不需要重复上传");
					fileId= getSlaveFileId(masterFileId, "_small");
				}
			}
			return fileId;
		} catch (Exception e) {
			log.error("upload slave file exception e =" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			closeClient(storageClient);
		}
	}
	
	@Override
	public byte[] download(String fileId){
		StorageClient1 storageClient = getStorageClient();
		try {
			return storageClient.download_file1(fileId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			closeClient(storageClient);
		}
	}
	
	@Override
	public int downloadFile(String fileId, String localFile){
		StorageClient1 storageClient = getStorageClient();
		try {
			return storageClient.download_file1(fileId, localFile);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally{
			closeClient(storageClient);
		}
	}
	
	@Override
	public FileInfo getFileInfo(String fileId){
		StorageClient1 storageClient = getStorageClient();
		try {
			return storageClient.get_file_info1(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeClient(storageClient);
		}
		return null;
	}

	private StorageClient1 getStorageClient() {
		TrackerServer trackerServer = null;
		try {
			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				log.error("get trackerServer is null");
				throw new BaseException(1001, "get trackerServer is null");
			}
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			if (storageServer == null) {
				log.error("get storageServer is null");
				throw new  BaseException(1002,"get storageServer is null");
			}
			StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
			return storageClient;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("file upload fail");
			return null;
		}
	}
	private void closeClient(StorageClient storageClient) {
		if (storageClient != null) {
			try {
				storageClient.getTrackerServer().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getSlaveFileId(String fileId, String suffix) {
		StringBuilder sb = new StringBuilder(fileId);
		sb.insert(fileId.lastIndexOf("."), suffix);
		return sb.toString();
	}
	
	
	/**
	 * 字节流方式上传
	 */
	@Override
	public  Map<String, Object> uploadFileName(byte[] fileBuff, String fileName) {
		log.debug("fileName:" + fileName);
		String originalFileName = FilenameUtils.getName(fileName);// 文件名
		log.debug("originalFileName:" + originalFileName);
		String baseName = FilenameUtils.getBaseName(fileName);// 不含后缀名
		log.debug("baseName:" + baseName);
		String fileExtName = FilenameUtils.getExtension(originalFileName);// 文件后缀名
		log.debug("fileExtName:" + fileExtName);

		long length = fileBuff.length;// 字节
		log.debug("length:" + length);

		log.debug("fileBuff.length:" + fileBuff.length);

		boolean isImage = FileTypeUtil.isImage(originalFileName);
		log.debug("isImage:" + isImage);
		String mimeType = FileUtil.getMimeType(fileName);
		log.debug("mimeType:" + mimeType);

		int width = 0;
		int height = 0;
		if (isImage) {
			int[] imageInfo = FileTypeUtil.getImageInfo(fileBuff);
			if (imageInfo != null) {
				width = imageInfo[0];
				height = imageInfo[1];
			}
		}

		String fileType = FileTypeUtil.getFileTypeByStream(fileBuff);
		log.debug("fileType:" + fileType);

		NameValuePair[] metaList = new NameValuePair[] { new NameValuePair("fileName", fileName), new NameValuePair("isImage", isImage + ""), new NameValuePair("mimeType", mimeType), new NameValuePair("width", width + ""), new NameValuePair("height", height + ""), new NameValuePair("author", "Fastdfs") };

		boolean status = false;
		String message = "文件上传失败！";
		String[] responseData = storeFile(fileBuff, fileExtName, metaList);
		Map<String, Object> uploadResult = new HashMap<String, Object>();
		if (responseData != null) {
			status = true;
			message = "文件上传成功！";

			uploadResult.put("isImage", isImage);
			if (isImage) {
				uploadResult.put("width", width);
				uploadResult.put("height", height);
			}
			
			uploadResult.put("groupName", responseData[0]);
			uploadResult.put("storageFileName", responseData[1]);
			uploadResult.put("link", responseData[0] + "/" + responseData[1]);// 文件访问链接
		}
		
		uploadResult.put("status", status);
		uploadResult.put("message", message);
		
		uploadResult.put("fileName", fileName);
		uploadResult.put("mimeType", mimeType);
		uploadResult.put("length", length);
		
		return uploadResult;
	}
	
	
	
	private  String[] storeFile(byte[] fileBuff, String fileExtName, NameValuePair[] metaList) {
		String[] responseData = null;
		try {
			StorageClient1 storageClient = getStorageClient();
			responseData = storageClient.upload_file(fileBuff, fileExtName.toLowerCase(), metaList);
		} catch (Exception e) {
			log.error("storeFile时发生异常:", e);
		}
		return responseData;
	}
}
