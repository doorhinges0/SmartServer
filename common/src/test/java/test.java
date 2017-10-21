import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class test {

	public static void main(String[] args) {
//		String shellString = "curl -i --negotiate -u hdfs/hadoop-master-1:"+p+" http://100.100.100.80:50070/webhdfs/v1/?op=LISTSTATUS";
		String shellString = "curl --help ";
//		List<String> processList = new ArrayList<String>();
//		try {
//			Process process = Runtime.getRuntime().exec(shellString);
//			BufferedReader read = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = "";
//            while ((line = read.readLine()) != null) {
//                processList.add(line);
//            }
//            read.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String uri="hdfs://100.100.100.80:50070/";   //hdfs 地址  
        String local="D:/text.txt";  //本地路径  
        String remote="hdfs://100.100.100.80:50070/home/hadoop";  
        Configuration conf = new Configuration();
        
        try {
			copyFile(conf,uri,local,remote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        
		  
	}
	
	public static void copyFile(Configuration conf , String uri , String local, String remote) throws IOException {  
        FileSystem fs = FileSystem.get(URI.create(uri), conf);  
        fs.copyFromLocalFile(new Path(local), new Path(remote));  
        System.out.println("copy from: " + local + " to " + remote);  
        fs.close();  
    }

}
