package hit.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class modifyYml3 {
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:逐行读取文件并修改，去掉文件中的!java.util.HashMap
	 *创建时间:2016年5月18日下午4:05:37
	 * @param fileName
	 */
	@Test
	 public  static  void modifyFile(String fileName) {
		  try{
		   //文件路径
		   String filePath = fileName;
		   //读取文件
		   BufferedReader File_pwd=new BufferedReader(new FileReader(filePath));
		   //将文件内容按行存到list;
		   List<String> list=new ArrayList<String>();
		   //声明读文件行的临时变量
		   String temp;                                             
		   do{                                                      
		    //按行循环读取文件
		    temp=File_pwd.readLine();
		    System.out.println("读取到的原文件:"+temp);
		    list.add(temp);                                      
		    //把读取到的行存入数组变量
		   }while(temp!=null);
		   File_pwd.close();
		   
		   /**
		    * 删除原文件
		    */
		   File f = new File(filePath);
		   if(f.exists()){
			   f.delete();
		   }
		   
		   //将内容写到新文件
		   //newFilePath = "G:\\newPlayer\\" + fileName;
		   BufferedWriter File_bak=new BufferedWriter(new FileWriter(new File(filePath)));
		   String s=new String();
		 
		   for(int j=0;j<list.size()-1;j++){
		    //使用循环把行字符串取出来,并调用replaceall函数,对字符内容进行正则表达式替换
				    s=list.get(j);
				   
				    if(s.contains("!java.util.HashMap")){
				    	String new_s = s.replace("!java.util.HashMap", "");
				    	File_bak.write(new_s+"\n");
				    }else if (s.contains("location")) {//位置
						String new_s = s.replace("\"", "");
						File_bak.write(new_s+"\n");
					}
				    else if (s.contains("detection limit")) {
						String new_s = s.replace("\"", "");
						File_bak.write(new_s+"\n");
					}else if (s.contains("metric")) {
						String new_s = s.replace("\"", "");
						File_bak.write(new_s+"\n");
					}else if (s.contains("detection:")) {
						String new_s = s.replace("\"", "");
						File_bak.write(new_s+"\n");
					}
				    else if(s.contains("--- ")) {
				    	String new_s = s.replace("---", "");
						File_bak.write(new_s+"\n");
					}else if (s.contains("\"") && (!s.contains("["))) {//包含" 不包含【  去除
						String new_s = s.replace("\"", "");
						File_bak.write(new_s+"\n");
					}else if (s.contains("\'") && s.contains("[")) { //包含' 包含[  不变
						File_bak.write(s+"\n");
					}
					else if (s.contains("!java.lang.Double")) {
						String new_s = s.replace("!java.lang.Double", "");
						File_bak.write(new_s+"\n");
					}
					else {
						File_bak.write(s+"\n");
					}
				    
		   }
		 	    
		   //必须先刷新,才能用close关闭
		   File_bak.flush();
		   File_bak.close();
		   System.out.println("file write success");
		  }catch(IOException ex){
		   ex.printStackTrace();
		   System.out.println("file read or write error");
		  }
		 }
	
}
