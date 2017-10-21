package tools.mybatis.gen;

import org.apache.commons.io.FileUtils;

import com.dtsjy.mdboss.common.utils.file.ResourceUtils;

/**
 * 生产数据操作层代码
 * 
 *  
 *
 */
public class GenMain {
	public static void main(String[] args) {
		String configFile = "/generatorConfig.xml";
		try {
//			String[] tableNames = new String[] { "CLOUD_DISK", "demo", "DISK_OF_HOST", "DNS_OF_PROJECT", "DNS_SERVER", "DOMAIN", "DOMAIN_OF_HOST", "EXCEPTION_LOG",
//					"EXTERNAL_CALL_LOG", "HOST", "HOST_DEPLOY_RECORD", "HOST_DEPLOY_TASK_RECORD", "HOST_MANAGE_LOG", "HOST_OF_PROJECT", "HOST_OF_USER", "PACKAGE",
//					"PACKAGE_DEPENDENCIES", "PROJECT", "PROJECT_DEPLOY_RECORD", "PROJECT_OF_USER", "PROJECT_OPERATE_LOG", "PROJECT_TEMPLATE_RECORD", "REF_SERVICE_OF_PROJECT",
//					"REFERENCE_SERVICE", "SYSTEM_PARAM", "USER", "TEMPLATE_DEPLOY_TOP", "TEMPLATE_HOST", "WORKFLOW", "DEPLOY_TASK_RECORD", "PROJECT", "APP_CREDENTIAL",
//					"HOST_OF_WORKFLOW", "GITLAB_ID" };

			 String[] tableNames = new String[] { "PROJECT"};
			tableNames =  FileUtils.readLines(ResourceUtils.getFile("classpath:tables")).toArray(new String[]{});
			GenMybatisFiles.gen(configFile, tableNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
