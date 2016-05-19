import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.ho.yaml.Yaml;
import org.junit.Test;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:修改yml文件的测试类
 *创建时间:2016年5月18日下午2:52:28
 */
public class TestUpdateYml {
	public static void main(String[] args) {
		
		
	}
	
	@Test
	public void testDump() {
	    Map<String, Object> data = new HashMap<String, Object>();
	    data.put("name", "Silenthand Olleander");
	    data.put("race", "Human");
	    data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
	    
	    Map<String, String> data2 = new HashMap<String, String>();
	    data2.put("name", "sunpeng");
	    data2.put("sex", "male");
	    
	    Map bigMap = new HashMap();
	    bigMap.put("1", data);
	    bigMap.put("2",data2);
	    
	    
	    Yaml yaml = new Yaml();
	  //  String output = yaml.dump(bigMap);
	    File file = new File("c:/1.yml");
	    StringWriter writer = new StringWriter();
	    //yaml.dump(bigMap, writer);
	    System.out.println();
	}
	
	
}
