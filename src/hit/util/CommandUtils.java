package hit.util;
/**
 * @author sunpeng123
 * 调用命令的工具类，抽象出来
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
public class CommandUtils {
	
	
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
