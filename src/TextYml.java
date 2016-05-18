import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	  public void getYamlFile() throws IOException{    
	        File f = new File("G:/grabsample_ex1.yml");
	        System.out.println(f.getAbsolutePath());
	        HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	        System.out.println(ml.size());        
	        //System.out.println();
	        HashMap object = (HashMap) ml.get("grabsample");
	        object.replace("sample time", object.get("sample time"), 87897);
	        
	        Yaml yaml = new Yaml();
	        yaml.dump(ml, new File("G:/grabsample_ex1.yml"), false);
	        
	        
	      /*  System.out.println(ml.values());*/
	        
	        System.out.println(object.get("sample time"));
	        
	    }
	
	
		

}
