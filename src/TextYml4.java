import hit.util.modifyYml1;
import hit.util.modifyYml4;

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

import javax.management.loading.MLet;

import org.ho.yaml.Yaml;
import org.junit.Assert;
import org.junit.Test;


public class TextYml4 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		TextYml4 t = new TextYml4();        
    //    t.getYamlFile();
	}
	public void getTest() {
        Assert.assertEquals(1,2);
        System.out.println("1234");
    }
	
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:测试成功
	 *创建时间:2016年5月19日上午9:32:54
	 * @throws IOException
	 */
	@Test
	  public void getYamlFile() throws IOException{    
		File f = new File("G:/wst-1.2/bin/booster_mip_ex1.yml");
		 System.out.println(f.getAbsolutePath());
		 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	     System.out.println(ml.size());        
	     
       HashMap booster_mip = (HashMap) ml.get("booster mip");
       HashMap network = (HashMap) ml.get("network");
       HashMap scenario = (HashMap) ml.get("scenario");
       HashMap solver = (HashMap) ml.get("solver");
       HashMap configure = (HashMap) ml.get("configure");
	        
       System.out.println(booster_mip.get("detection"));;
	        System.out.println(scenario.get("location"));
	        System.out.println(booster_mip.get("max boosters"));
	       // booster.replace("detection", booster.get("detection"), "['15', '35','11111111111', '219', '253']");
	//      scenario.replace("start time", scenario.get("start time"),  20);
	        Yaml yaml = new Yaml();
	        
	        yaml.dump(ml, new File("G:/wst-1.2/bin/booster_mip_ex1.yml"), false);
	        modifyYml4.modifyFile("G:/wst-1.2/bin/booster_mip_ex1.yml");
	        
	      /*  System.out.println(ml.values());*/
	        
	     /*   modifyYml４.modifyFile("G:/wst-1.2/bin/booster_mip_ex1.yml");*/
	        
	    }
	
	
		

}
