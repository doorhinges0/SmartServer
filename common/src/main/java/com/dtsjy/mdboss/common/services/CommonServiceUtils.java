package com.dtsjy.mdboss.common.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dtsjy.mdboss.common.dal.gen.model.SysParamVO;
import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.model.DataPackage;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.code2name.Code2NameFacade;
import com.dtsjy.mdboss.common.model.code2name.Code2NameUtil;
import com.dtsjy.mdboss.common.model.config.CommonConfigFacade;
import com.dtsjy.mdboss.common.model.config.InterfDefFacade;
import com.dtsjy.mdboss.common.model.constants.CmModel;
import com.dtsjy.mdboss.common.model.constants.CmsModel;
import com.dtsjy.mdboss.common.model.constants.FspModel;
import com.dtsjy.mdboss.common.model.constants.HRModel;
import com.dtsjy.mdboss.common.model.constants.OAModel;
import com.dtsjy.mdboss.common.model.constants.PMModel;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.model.constants.WfsModel;
import com.dtsjy.mdboss.common.utils.JsonResponseUtils;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.config.RunMode;
import com.dtsjy.mdboss.common.utils.config.Settings;
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.fsp.dal.gen.model.FileVO;
import com.dtsjy.mdboss.fsp.dal.gen.model.VirtualfileVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.OrgVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UserRoleVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UserVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UsergroupMemberVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UsergroupVO;

public class CommonServiceUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CommonServiceUtils.class);
	
	private static final String UCP_COMMON_SERVICE = "ucp-commonService";
	private static final String WFS_COMMON_SERVICE = "wfs-commonService";
	private static final String PM_COMMON_SERVICE = "pm-commonService";
	private static final String OA_COMMON_SERVICE = "oa-commonService";
	private static final String SSP_COMMON_SERVICE = "ssp-commonService";
	private static final String FSP_COMMON_SERVICE = "fsp-commonService";
	private static final String HR_COMMON_SERVICE = "hr-commonService";
	private static final String CMS_COMMON_SERVICE = "cms-commonService";
	private static final String CM_COMMON_SERVICE = "cm-commonService";
	
	public static CommonService appCommonService(String app){
		if (UcpModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getUcpCommonService();
		}else if (FspModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getFspCommonService();
		}else if (WfsModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getWfsCommonService();
		}else if (PMModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getPMCommonService();
		}else if(HRModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getHrCommonService();
		}else if(CmsModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getCmsCommonService();
		}else if(OAModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getOACommonService();
		}else if(CmModel.APP_CODE.value().equalsIgnoreCase(app)){
			return getCmCommonService();
		}else {
			return getUcpCommonService();
		}
	}
	
	public static CommonService getUcpCommonService() {
		return SpringCtxUtils.getBean(UCP_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getWfsCommonService() {
		return SpringCtxUtils.getBean(WFS_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getPMCommonService() {
		return SpringCtxUtils.getBean(PM_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getOACommonService() {
		return SpringCtxUtils.getBean(OA_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getSspCommonService() {
		return SpringCtxUtils.getBean(SSP_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getFspCommonService() {
		return SpringCtxUtils.getBean(FSP_COMMON_SERVICE, CommonService.class);
	}
	
	public static CommonService getHrCommonService() {
		return SpringCtxUtils.getBean(HR_COMMON_SERVICE, CommonService.class);
	}

	public static CommonService getCmsCommonService() {
		return SpringCtxUtils.getBean(CMS_COMMON_SERVICE, CommonService.class);
	}
	
	
	public static CommonService getCmCommonService() {
		return SpringCtxUtils.getBean(CM_COMMON_SERVICE, CommonService.class);
	}

	/**
	 * 根据用户编码查询用户信息，返回标准json格式
	 * （在应用层调用本方法）
	 * @param userCode 用户编码
	 * @return 用户对象标准json
	 */
	public static String getUcpUserRsp(String userCode) {
		BaseQuery param = new BaseQuery();
		param.addCondition("usercode", QueryOperate.EQUAL_TO, userCode);
		CommonService commonService = getUcpCommonService();
		return commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
				SerialNoHolder.userCode.get(), UcpModel.UCP_USER.value(), JSON.toJSONString(param));
	}

	/**
	 * 根据用户编码获取用户对象
	 * （在应用层调用本方法）
	 * @param userCode
	 * @return
	 */
	public static UserVO getUcpUser(String userCode) {
		String rsp = getUcpUserRsp(userCode);
		return JsonResponseUtils.getOneIfNotEmpty(rsp, UserVO.class);
	}

	/**
	 * 根据用户编码获取用户的名称
	 * 
	 * @param usercode
	 * @return
	 */
	public static String getUcpUserName(String usercode) {
		try {
			return getUcpUser(usercode).getUsername();
		} catch (Exception ex) {
			logger.error("getUcpUserName-err: " + usercode, ex);
		}
		return null;
	}


	/**
	 * 获取用户对象json
	 * (在portal-web调用本方法)
	 * @param appcode 应用编码
	 * @param tenant 交易流水号
	 * @param oprcode 操作人编码
 	 * @param userCode 用户编码
	 * @return 用户对象json
	 */
	public static String getUcpUserRsp(String appcode, String tenant,
			String oprcode, String userCode) {
		BaseQuery param = new BaseQuery();
		param.addCondition("usercode", QueryOperate.EQUAL_TO, userCode);
		CommonService commonService = getUcpCommonService();
		return commonService.selectByExample(appcode, tenant, oprcode,
				UcpModel.UCP_USER.value(), JSON.toJSONString(param));
	}

	/**
	 * 获取用户对象
	 * (在portal-web调用本方法)
	 * @param appcode 应用编码
	 * @param tenant 交易流水号
	 * @param oprcode 操作人编码
 	 * @param userCode 用户编码
	 * @return
	 */
	public static UserVO getUcpUser(String appcode, String tenant,
			String oprcode, String userCode) {
		String rsp = getUcpUserRsp(appcode, tenant, oprcode,
				userCode);
		return JsonResponseUtils.getOneIfNotEmpty(rsp, UserVO.class);
	}

	
	/**
	 * 获取用户名称
	 * (在portal-web调用本方法)
	 * @param appcode 应用编码
	 * @param tenant 交易流水号
	 * @param oprcode 操作人编码
 	 * @param userCode 用户编码
	 * @return
	 */
	public static String getUcpUserName(String appcode, String tenant,
			String oprcode, String usercode) {
		return getUcpUser(appcode, tenant, oprcode, usercode).getUsername();
	}
	
	/**
	 * 根据用户组编码查询用户组对象信息，返回标准json格式
	 * 
	 * @param groupcode
	 * @return
	 */
	public static String getUcpUserGroupRsp(String groupcode) {
		BaseQuery param = new BaseQuery();
		param.addCondition("groupcode", QueryOperate.EQUAL_TO, groupcode);
		CommonService commonService = getUcpCommonService();
		return commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
				SerialNoHolder.userCode.get(),  UcpModel.UCP_USERGROUP.value(), JSON.toJSONString(param));
	}

	/**
	 * 根据用户组编码查询用户组json对象
	 * @param groupcode
	 * @return
	 */
	public static UsergroupVO getUcpUserGroup(String groupcode){
		String rsp = getUcpUserGroupRsp(groupcode);
		return JsonResponseUtils.getOneIfNotEmpty(rsp, UsergroupVO.class);
	}

	/**
	 * 根据用户编码获取用户组成员响应json
	 * @param usercode 用户编码
	 * @return 标准json格式，data为用户组dp
	 */
	public static String getUsergroupMembersRsp(String usercode,String groupCode) {
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		if (StringToolkit.isNotEmpty(usercode)){
			param.addCondition("usercode", QueryOperate.EQUAL_TO, usercode);
		}
		if (StringToolkit.isNotEmpty(groupCode)){
			param.addCondition("groupcode", QueryOperate.EQUAL_TO, groupCode);
		}
		return commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
				SerialNoHolder.userCode.get(),  UcpModel.UCP_USERGROUP_MEMBER.value(),
				JSON.toJSONString(param));
	}

	/**
	 * 根据用户编码获取所有用户组成员
	 * @param usercode 用户编码
	 * @return 用户组列表
	 */
	public static List<UsergroupMemberVO> getUsergroupMembers(String usercode,String groupCode) {
		String rsp = getUsergroupMembersRsp(usercode,groupCode);
		return JsonResponseUtils.getPackageFormResponse(rsp, UsergroupMemberVO.class).getRows();
	}
	

	/**
	 * 查询用户拥有的所有用户角色
	 * @param usercode 用户编码
	 * @roleCode 如果为空，则返回赋予用户的所有角色；不为空则返回指定的角色 (可用于判断用户是否被分配该角色)
	 * @return 用户角色标准json
	 */
	public static List<UserRoleVO> getUserRoles(String usercode,String roleCode) {
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		param.addCondition("effecttime", QueryOperate.LESS_THAN_OR_EQUAL_TO, new Date())
			.addCondition("expiretime", QueryOperate.GREATER_THAN_OR_EQUAL_TO, new Date());
		if (StringToolkit.isNotEmpty(usercode)){
			param.addCondition("usercode", QueryOperate.EQUAL_TO, usercode);
		}
		if (StringToolkit.isNotEmpty(roleCode)){
			param.addCondition("rolecode", QueryOperate.EQUAL_TO, roleCode);
		}
		String rsp =  commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
				SerialNoHolder.userCode.get(),  UcpModel.UCP_USER_ROLE.value(),
				JSON.toJSONString(param));
		
		return JsonResponseUtils.getPackageFormResponse(rsp, UserRoleVO.class).getRows();
	}
	

	public static List<UserVO> getOrgUsers(String orgCode){
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		param.addCondition("orgcode", QueryOperate.EQUAL_TO, orgCode);
		String rsp = commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), SerialNoHolder.userCode.get(),
				UcpModel.UCP_USER.value(), JSON.toJSONString(param));
		return JsonResponseUtils.getPackageFormResponse(rsp, UserVO.class).getRows();
		
	}
	
	public static List<UserVO> getOrgUsers(String orgCode,int pageNo,int pageSize){
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		param.setPageNo(pageNo);
		param.setPageSize(pageSize);
		param.addCondition("orgcode", QueryOperate.EQUAL_TO, orgCode);
		String rsp = commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), SerialNoHolder.userCode.get(),
				UcpModel.UCP_USER.value(), JSON.toJSONString(param));
		return JsonResponseUtils.getPackageFormResponse(rsp, UserVO.class).getRows();
		
	}
	

	/**
	 * 根据组织编码查询组织信息
	 * 
	 * @param appcode
	 * @param tenant
	 * @param oprcode
	 * @param orgcode
	 * @return
	 */
	public static OrgVO getOrgByCode(String appcode, String tenant,
			String oprcode, String orgcode) {
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		param.addCondition("orgcode", QueryOperate.EQUAL_TO, orgcode);
		String rsp = commonService.selectByExample(appcode, tenant, oprcode,
				UcpModel.UCP_ORG.value(), JSON.toJSONString(param));
		DataPackage<OrgVO> dp = JsonResponseUtils.getPackageFormResponse(rsp,
				OrgVO.class);
		if (JsonResponseUtils.isNotEmptyDP(dp)) {
			return dp.getRows().get(0);
		}

		return null;
	}

	/**
	 * 根据组织编码查询组织信息
	 * 
	 * @param appcode
	 * @param tenant
	 * @param oprcode
	 * @param orgcode
	 * @return
	 */
	public static OrgVO getOrgByCode(String orgcode) {
		CommonService commonService = getUcpCommonService();
		BaseQuery param = new BaseQuery();
		param.addCondition("orgcode", QueryOperate.EQUAL_TO, orgcode);
		String rsp = commonService.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), SerialNoHolder.userCode.get(),
				UcpModel.UCP_ORG.value(), JSON.toJSONString(param));
		DataPackage<OrgVO> dp = JsonResponseUtils.getPackageFormResponse(rsp,
				OrgVO.class);
		if (JsonResponseUtils.isNotEmptyDP(dp)) {
			return dp.getRows().get(0);
		}

		return null;
	}
	
	/**
	 * 判断当前运行模式
	 * 
	 * @return 如果运行在product环境则返回假，非product环境返回真
	 */
	public static boolean runNotInProduct() {
		return Settings.RUNMODE.value().toUpperCase()
				.equals(RunMode.LOCAL.name())
				|| Settings.RUNMODE.value().toUpperCase()
						.equals(RunMode.TEST.name());
	}
	
	/**
	 * 获取数据字典项
	 * @param definition
	 * @param dictCode
	 * @return
	 */
	public static DictItemVO getDictItem(String definition, String dictCode) {
		return SpringCtxUtils.getBean(CommonConfigFacade.class).getDictItem(definition, dictCode);
	}
	
//	/**
//	 * 获取数据字典项
//	 * @param definition
//	 * @param dictCode
//	 * @return
//	 */
//	private static List<DictItemVO> getDictItems(String definition,String keyword) {
//		return SpringCtxUtils.getBean(CommonConfigFacade.class).getDictItems(definition, keyword);
//	}
	
	/**
	 * 获取数据字典项
	 * @param definition
	 * @param dictCode
	 * @return
	 */
	public static List<DictItemVO> getAppDictItems(String definition,String appCode) {
		return getAppDictItems(definition,appCode,null);
	}
	
	/**
	 * 获取数据字典项
	 * @param definition
	 * @param dictCode
	 * @return
	 */
	public static List<DictItemVO> getAppDictItems(String definition,String appCode,String keyword) {
		appCode = Code2NameUtil.surmiseAppCode(appCode, definition);
		return SpringCtxUtils.getBean(CommonConfigFacade.class).getAppDictItems(definition, appCode, keyword);
	}
	
	public static String appCode2Name(String appCode,String definition,String codeValue,String userCode){
		appCode = Code2NameUtil.surmiseAppCode(appCode, definition);
		return SpringCtxUtils.getBean(Code2NameFacade.class).appCode2Name(appCode, definition, codeValue, userCode);
	}
	
	public static Map appCode2NameValueList(String appCode,String definition,String userCode){
		appCode = Code2NameUtil.surmiseAppCode(appCode, definition);
		return SpringCtxUtils.getBean(Code2NameFacade.class).appCode2NameValueList(appCode, definition, userCode);
	}
	
	public static Map appCode2NameValueListWithCondition(String appCode,String definition,String condition,String userCode){
		appCode = Code2NameUtil.surmiseAppCode(appCode, definition);
		return SpringCtxUtils.getBean(Code2NameFacade.class).appCode2NameValueListWithCondition(appCode, definition, condition, userCode);
	}
	
	
	/**
	 * 根据文件编码，获取虚拟文件对象
	 * @param fileCode 文件编码
	 * @return  VirtualfileVO
	 */
	public static VirtualfileVO getVirtualFileByFileCode(String fileCode){
		CommonService service = getFspCommonService();
		BaseQuery query = new BaseQuery();
		query.addCondition("filecode", QueryOperate.EQUAL_TO, fileCode);
		String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), SerialNoHolder.userCode.get(),
				FspModel.FSP_VIRTUALFILE.value(), JsonUtil.toJSonWithDate(query));
		return JsonResponseUtils.getOneIfNotEmpty(rsp, VirtualfileVO.class);
	}
	
	/**
	 * 根据文件标识，获取物理文件对象
	 * @param fileId 文件标识
	 * @return  FileVO
	 */
	public static FileVO getFileByFileId(String fileId){
		CommonService service = getFspCommonService();
		BaseQuery query = new BaseQuery();
		query.addCondition("fileid", QueryOperate.EQUAL_TO, fileId);
		String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), SerialNoHolder.userCode.get(),
				FspModel.FSP_FILE.value(), JsonUtil.toJSonWithDate(query));
		return JsonResponseUtils.getOneIfNotEmpty(rsp, FileVO.class);
	}
	
	/**
	 * 
	 * <p>Description: 判断是否需要登记业务日志、异常日志、业务调用的输入及输出<p>
	 * @param appCode 应用编码 暂时未用到
	 * @param interClass 接口类全路径
	 * @param methodName 方法名称 值为*时配置接口类的所有方法
	 * @param oprType saveservlog/保存业务日志，saveexceptionlog/只在异常日志，记录业务输出/saveservouput，记录业务输入/saveservinput
	 * @return
	 */
	public static boolean canTakeAspectOper(String appCode,String interClass,String methodName,String oprType){
		try {
			InterfDefFacade interf = SpringCtxUtils.getBean(InterfDefFacade.class);
			InterfdefVO interfDef = interf.getInterDef(SerialNoHolder.appcode.get(), interClass, "*");
			if (null != interfDef){
				Object result = MethodUtils.invokeMethod(interfDef, "get"+StringToolkit.toUpperFisrtChar(oprType), new Object[]{});
				return (Boolean)result;
			}
			
			interfDef = interf.getInterDef(SerialNoHolder.appcode.get(), interClass, methodName);
			if (null != interfDef){
				Object result = MethodUtils.invokeMethod(interfDef, "get"+StringToolkit.toUpperFisrtChar(oprType), new Object[]{});
				return (Boolean)result;
			}
		} catch (Exception e) {
			//do nothing
		}
		
		return true;
	}
	
	/**
	 * 
	 * <p>Description: <p>
	 * @param paramCode 系统参数编码
	 * @param appCode 应用编码
	 * @return 参数值
	 */
	public static String getUCPParamValue(String paramCode,String appCode,String valIfNull){
		String value = SpringCtxUtils.getBean(CommonConfigFacade.class).getUCPParamValue(paramCode, appCode);
		return StringToolkit.isNotEmpty(value) ? value : valIfNull;
	}
	
	/**
	 * 
	 * <p>Description: <p>
	 * @param paramCode 系统参数编码
	 * @param appCode 应用编码
	 * @return 参数值
	 */
	public static String getUCPParamValue(String paramCode,String appCode){
		return SpringCtxUtils.getBean(CommonConfigFacade.class).getUCPParamValue(paramCode, appCode);
	}
	
	/**
	 * 获取系统参数
	 * @param paramCode 系统参数编码
	 * @param appCode 应用编码
	 * @return 系统参数对象
	 */
	public static SysParamVO getUCPSysParam(String paramCode,String appCode){
		return SpringCtxUtils.getBean(CommonConfigFacade.class).getUCPSysParam(paramCode, appCode);
	}
}
