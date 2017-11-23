package tools.mybatis.gen;


public class GenMain2 {
	public static void main(String[] args) {
		String configFile = "/generatorConfig.xml";
		try {
			GenMybatisDal.genDal(configFile);
//			genMapping();//TODO:修改为自动替换xml文件的内容
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void genMapping(){
		GenMybatisTabMapping gp = new GenMybatisTabMapping();
		gp.genMappingConfig("ucpdb", "classpath:tables");;
	}
}
