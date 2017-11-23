package com.sunrise.common.office.pageoffice.seal;

import com.sunrise.common.services.CommonServiceUtils;
import com.sunrise.common.utils.dal.QueryParser;
import com.sunrise.fsp.dal.gen.model.FileVO;
import com.sunrise.oa.dal.gen.model.SealsVOExample;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.model.BaseQuery;
import com.sunrise.common.model.constants.OAModel;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.file.FileToolkit;
import com.sunrise.common.utils.network.HttpUtils;
import com.sunrise.common.utils.network.ResponseWrap;
import com.sunrise.fsp.dal.gen.model.VirtualfileVO;
import com.sunrise.oa.dal.gen.dao.SealsVOMapper;
import com.sunrise.oa.dal.gen.model.SealsVO;

public class SealManager {
	
	private static Logger logger = LoggerFactory.getLogger(SealManager.class);
	
	public static HttpUtils login(){
		String loginUrl  = getLoginUrl();
		 HttpUtils http = HttpUtils.post(loginUrl);
	     http.setContentType("application/x-www-form-urlencoded", Consts.UTF_8);
	     ResponseWrap wrap = http.execute();
	     if (!wrap.statusCodeEquals(200)) {
				int statusCode = wrap.getStatusCode();
				logger.error("can't login seal status code:  " + statusCode);
				logger.error("can't login seal error! loginUrl:  " + loginUrl);
	     }
	     return http;
	}
	
	public static void addSeal(SealsVO vo){
		HttpUtils http = login();
		try {
			if (http != null) {
				String fileCode = vo.getFilecode();
				VirtualfileVO vFile = CommonServiceUtils.getVirtualFileByFileCode(fileCode);
				FileVO file = CommonServiceUtils.getFileByFileId(vFile.getFileid());
				String tmpDir = CommonServiceUtils.getUCPParamValue("pageoffice.seal.tmpdir", OAModel.APP_CODE.value(), FileToolkit.getTmpDir());
				logger.error("copyFileToTmpDir:  " + tmpDir + ", " + file.getFilepath());
				FileToolkit.copyFileToTmpDir(file.getFilepath(), tmpDir);//把印章文件复制到临时目录（pageoffice电子签章功能写死了从临时目录读取印章文件）
				String addUrl = getAddUrl();
				http = HttpUtils.post(addUrl, http);
				
				vo.setSealimagetype(String.format("img/%s", FilenameUtils.getExtension(file.getFilepath())));
				http.addParameter("txtSealName", vo.getSealname()); //
				http.addParameter("txtSignerName", vo.getSignername()); //
				http.addParameter("txtDeptName", vo.getDeptname()); //
				http.addParameter("SelectSealType", vo.getSealtype()); //
				http.addParameter("ipt_ImageType", vo.getSealimagetype()); //
				http.addParameter("ipt_TmpPicPath", FilenameUtils.getName(file.getFilepath())); //
				
				ResponseWrap wrap = http.execute(); //office电子签章系统需与oa使用不同的数据库，如果共库会导致事务问题，处理非常慢最终超时失败
				
				if (wrap.statusCodeEquals(200)) {
					//新增seal，通过触发器更新seal库中对应印章的信息，同时把其id等信息更新至本库
					SealsVOMapper dao = SpringCtxUtils.getBean(SealsVOMapper.class);
					dao.insert(vo);
				} else {
					int statusCode = wrap.getStatusCode();
					logger.error("can't add seal error! status code:  " + statusCode);
					logger.error("can't add seal error! add url:  " + addUrl);
				}
			}
		} catch (Exception ex) {
			logger.error("addSeal operation error!", ex);
		}finally {
			if (null != http){
				http.shutdown();
			}
		}
	}
	
	public static void delSealById(int id){
		SealsVOMapper dao = SpringCtxUtils.getBean(SealsVOMapper.class);
		dao.deleteByPrimaryKey(id);
	}
	
	public static void updateSeal(SealsVO vo){
		SealsVOMapper dao = SpringCtxUtils.getBean(SealsVOMapper.class);
		dao.updateByPrimaryKey(vo);
	}
	
	public static void delSealsByExample(BaseQuery query){
		try {
			SealsVOExample example = new QueryParser().parseExample(query, SealsVOExample.class);
			SealsVOMapper dao = SpringCtxUtils.getBean(SealsVOMapper.class);
			//通过触发器同步删除seal库中对应的印章
			dao.deleteByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SealsVO getSealByExample(SealsVO vo){
		SealsVOMapper dao = SpringCtxUtils.getBean(SealsVOMapper.class);
		SealsVOExample example = new SealsVOExample();
		example.createCriteria().andSignernameEqualTo(vo.getSignername())
			.andSealnameEqualTo(vo.getSealname()).andSealtypeEqualTo(vo.getSealtype());
		
		return CollectionUtils.getOneIfNoEmpty(dao.selectByExample(example));
	}
	
	private static String getAddUrl(){
		return CommonServiceUtils.getUCPParamValue("pageoffice.seal.add.url", OAModel.APP_CODE.value(), "http://localhost:81/portal-web/adminseal.do?op=add");
	}
	
	private static String getLoginUrl(){
		String url = CommonServiceUtils.getUCPParamValue("pageoffice.seal.login.url", OAModel.APP_CODE.value(), "http://localhost:81/portal-web/loginseal.do");
		String pwd = CommonServiceUtils.getUCPParamValue("pageoffice.seal.login.password", OAModel.APP_CODE.value(), "111111");
		url = String.format("%s?TextUserName=admin&TextPassword=" + pwd, url);
		return url;
	}
}
