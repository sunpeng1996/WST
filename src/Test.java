import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:这是取样点优化的cmd命令
 *创建时间:2016年5月15日下午9:56:59
 */

public class Test {

	public static void main(String[] args) {
		try {
		/*	excuteCommand(new String[] { "wst","grabsample","grabsample_ex1.yml" },
					new String[]{"wst=F:\\wst-1.2\\bin\\wst.exe"},
					new File("f:/wst-1.2/bin"));*/	
	//	excuteCommand(new String[]{"F:\\wst-1.2\\bin\\epanet.exe"});
			long startTime=System.currentTimeMillis();   //获取开始时间
		excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","flushing","G:\\wst-1.2\\bin\\flushing_ex2.yml"},
				null,	new File("G:/wst-1.2/bin"));
		
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

	public static void excuteCommand(String[] command, String[] strings, File file) {

		Runtime r = Runtime.getRuntime();
		Process p;
		try {
			p = r.exec(command,strings,file);
			System.out.println(p);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inline;
			while ((inline = br.readLine()) != null) {
				System.out.println(inline);
			}
			br.close();
			br = new BufferedReader(new InputStreamReader(p.getErrorStream(),"gbk"));
			while ((inline = br.readLine()) != null) {
				System.out.println("error:" + inline);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void excuteCommand(String[] command) {

		Runtime r = Runtime.getRuntime();
		Process p;
		try {
			p = r.exec(command);
			System.out.println(p);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inline;
			while ((inline = br.readLine()) != null) {
				System.out.println(inline);
			}
			br.close();
			br = new BufferedReader(new InputStreamReader(p.getErrorStream(),"GBK"));
			while ((inline = br.readLine()) != null) {
				System.out.println("error:" + inline);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
