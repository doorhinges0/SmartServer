package tools.mybatis.gen;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.NullProgressCallback;

import com.sunrise.common.utils.string.StringToolkit;

public class GenMybatisFiles {
	static final String[] contexts = new String[]{"common-MySqlTables","ucp-MySqlTables","pm-MySqlTables"};
	
	public static void gen(String configFile, String[] tableNames)
			throws IOException, XMLParserException,
			InvalidConfigurationException, SQLException, InterruptedException {
		// 配置文件
		InputStream in = GenMybatisFiles.class.getResourceAsStream(configFile);

		// 生成配置对象
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(in);
		addTables(tableNames, config);

		// 初始化 MyBatisGenerator
		boolean overwrite = true;
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);

		// 重载2个方法，用于跟踪运行情况
		ProgressCallback progressCallback = new NullProgressCallback() {
			public void startTask(String taskName) {
				System.out.println("start task:" + taskName);
			}

			public void done() {
				System.out.println("done");
			}
		};
		myBatisGenerator.generate(progressCallback);

		// 查看警告
		if (warnings.size() > 0) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("warnings:");
			for (String warning : warnings) {
				System.out.println(warning);
			}
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}

	/**
	 * @param tableNames
	 * @param config
	 */
	public static void addTables(String[] tableNames, Configuration config) {
		config.getContexts();
		for (Context context:config.getContexts()){
			String contextId = context.getId();
			for (String tableName : tableNames) {
				if (isContextTable(tableName,contextId)){
					TableConfiguration tc = new TableConfiguration(new Context(null));
					tc.setTableName(tableName);
					tc.setDomainObjectName(StringToolkit.tableName2VOName(tableName.substring(tableName.indexOf("_")+1)));
					tc.setConfiguredModelType("flat");
					context.addTableConfiguration(tc);
				}
				
			}
		}
//		for (String contextId : contexts){
//			// 添加表
//			Context context = config.getContext(contextId);
//			if (null != context){
//				String tablePrefix = contextId.split("-")[0] + "_";
//				for (String tableName : tableNames) {
//					if (tableName.startsWith(tablePrefix)){
//						TableConfiguration tc = new TableConfiguration(new Context(null));
//						tc.setTableName(tableName);
//						tc.setDomainObjectName(StringToolkit.tableName2VOName(tableName.substring(tableName.indexOf("_")+1)));
//						tc.setConfiguredModelType("flat");
//						context.addTableConfiguration(tc);
//					}
//					
//				}
//			}
//			
//		}
	}

	private static boolean isContextTable(String tableName,String contextId){
		String tablePrefix = contextId.split("_")[0] ;//当contextid以_开头时，配置所有表名
		return tableName.startsWith(tablePrefix);
	}
	/**
	 * 举例：
	 * 输入： host__deploy_record
	 * 输出： HostDeployRecord
	 */
	static public String tableName2ObjectName(String table) {
		StringBuffer sb = new StringBuffer();
		String last = "_";
		table = table.toLowerCase();
		for (int i = 0; i < table.length(); i++) {
			Character c = table.charAt(i);
			String s = c.toString();
			if (!"_".equals(s)) {
				if ("_".equals(last)) {
					sb.append(s.toUpperCase());
				} else {
					sb.append(s);
				}
			}
			last = s;
		}
		return sb.toString();
	}

	
}
