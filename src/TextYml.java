import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.ho.yaml.Yaml;
import org.junit.Assert;
import org.junit.Test;


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
	
	@Test
	  public void getYamlFile() throws FileNotFoundException{    
	        File f = new File("G:/wst-1.2/bin/grabsample_ex1.yml");
	        System.out.println(f.getAbsolutePath());
	        HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	        System.out.println(ml.size());        
	        //System.out.println();
	        HashMap object = (HashMap) ml.get("grabsample");
	        System.out.println(object.get("sample time"));
	        
	    }

}
