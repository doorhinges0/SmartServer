package tools.mybatis.gen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class GenMybatisTabMapping {
	public static void genMappingConfig(String schema,String configFile) {
		
		try {
			File file = ResourceUtils.getFile(configFile);
			List<String> list = FileUtils.readLines(file);
			
			for (String tableName : list) {
				
				String voName = StringToolkit.tableName2VOName(tableName.substring(tableName.indexOf("_")+1));
				String mapping = new StringBuffer().append("<table schema=\"").append(schema).append("\" tableName=\"").append(tableName)
					.append("\" domainObjectName=\"").append(voName).append("\"/>").toString();
				
				System.out.println(mapping);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
