import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.ho.yaml.Yaml;
import org.junit.Assert;


public class TextYml {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		TextYml t = new TextYml();        
        t.getYamlFile();
	}
	public void getTest() {
        Assert.assertEquals(1,2);
        System.out.println("1234");
    }
	
	  public void getYamlFile() throws FileNotFoundException{    
	        File f = new File("src/com/test/Test2.yaml");
	        System.out.println(f.getAbsolutePath());
	        HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	        System.out.println(ml.size());        
	        System.out.println(((HashMap) ml.get("loadString")).get("locater"));        
	    }

}
