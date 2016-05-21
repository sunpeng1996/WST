package hit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SPDemo extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
				/*response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				FileReader fr = new FileReader("G:\\wst-1.2\\bin\\grabsample_ex1\\Net3visualization_output.html"); //建立FileReader对象,并设定由fr对象变量引用
				BufferedReader br = new BufferedReader(fr); //建立BufferedReader对象,并设定由br对象变量引  
				String Line = br.readLine(); //读取一行数据
				 br.println(Line + "<BR>"); //输出读取得的数据 
				StringBuffer sb = new StringBuffer();
				sb.append(Line);
				out.println(sb);
				out.flush();
				out.close();*/
				response.reset();
				response.setContentType("text/html ");
				OutputStream output = response.getOutputStream();// 得到输出流  
				File file = new File("G:\\wst-1.2\\bin\\grabsample_ex1\\Net3visualization_output.html");// 文件流  
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));// 输入缓冲流  
				BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流  
				byte data[] = new byte[2048];// 缓冲字节数  
				int size = 0;
				size = bis.read(data);
				while (size != -1) {
					bos.write(data, 0, size);
					size = bis.read(data);
				}
				bis.close();
				bos.flush();
				bos.close();
				output.close();

			}
}
