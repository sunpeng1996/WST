package hit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class OrderController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) throws IOException {
		  /*excuteCommand("ipconfig");
		 excuteCommand("ping 192.168.8.100");*/
		  //测试通过
		 
		/*excuteCommand("cmd.exe /C cd F:\\wst-1.2\\bin");
		excuteCommand("java");*/
		excuteCommand("ipconfig");
		 //String[] commands = new String[]{"wst", "grabsample", "grabsample_ex1.yml"};
		/* excuteCommand("wst grabsample grabsample_ex1.yml"); */
		 // Runtime.getRuntime().exec(commands);
		 //Runtime.getRuntime().exec("wst grabsample grabsample_ex1.yml");
		 //excuteCommand("wst"); 
	}
	
/*	//inversionsim.exe
	@Test
	public void orderTest(){
		//记事本测试通过
		String cmdStr = "" ;
		try {
			Runtime.getRuntime().exec(cmdStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//inversionsim.exe
		@Test
		public void orderDosInversionsim() throws InterruptedException{
			String path = "F:\\wst-1.2\\bin";
	        Runtime run = Runtime.getRuntime();
			try {
				 Process process = run.exec("cmd.exe /k  " + path);
				 InputStream in = process.getInputStream();
		            while (in.read() != -1) {
		                System.out.println(in.read());
		            }
		            in.close();
		            process.waitFor();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		  public static void  excuteCommand(String command)
		    {
		    
		        Runtime r = Runtime.getRuntime();
		        Process p;
		            try {
		                p = r.exec(command);
		                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
		                String inline;
		                while ((inline = br.readLine()) != null) {
		                    System.out.println(inline);
		                }
		                br.close();
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }

		    }
		
		 }

