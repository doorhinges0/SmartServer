package tools;

import org.apache.commons.io.FileUtils;

import tools.mybatis.gen.GenMybatisFiles;

import com.dtsjy.mdboss.common.utils.file.ResourceUtils;

/**
 * 生产数据操作层代码
 * @author 
 *
 */
public class GenMain {
	public static void main(String[] args) {
		String configFile = "/generatorConfig.xml";
		try {
			 String[] tableNames =  FileUtils.readLines(ResourceUtils.getFile("classpath:tables")).toArray(new String[]{});
			 tableNames = new String[]{"fsp_virtualfile"};
			GenMybatisFiles.gen(configFile, tableNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
