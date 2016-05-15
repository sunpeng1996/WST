package hit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class ReadInversion extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 读取第一个配置文件
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:
	TODO
	 *创建时间:2016年5月14日下午5:28:43
	 * @throws IOException
	 */
	@RequestMapping(value="/readYML1.do",method={RequestMethod.POST,RequestMethod.GET})
	public String readYML1(HttpServletRequest request) throws IOException {
		File file = new File("F:/wst-1.2/bin/inversion_ex1.yml");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while((str = br.readLine() )!=null){
				if(str.contains("epanet file")){//EPANET管网模型
					String epanet = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("epanet", epanet);
					System.out.println(epanet);
				}else if(str.contains("grab samples")){//取样数据
					String samples = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("samples", samples);
					System.out.println(samples);
				}else if(str.contains("algorithm")){//模型
					String algorithm = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("algorithm", algorithm);
					System.out.println(algorithm);
				}else if(str.contains("formulation")){//注入类型
					String formulation = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("formulation", formulation);
					System.out.println(formulation);
				}else if(str.contains("model format")){//模型格式
					String format = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("format", format);
					System.out.println(format);
				}else if(str.contains("horizon")){//时间
					String horizon = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("horizon", horizon);
					System.out.println(horizon);
				}else if(str.contains("num injections")){//注入节点数量
					String injections = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("injections", injections);
					System.out.println(injections);
				}else if(str.contains("measurement failure")){//失败率
					String failure = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("failure", failure);
					System.out.println(failure);
				}else if(str.contains("positive threshold")){//正阈值
					String positive = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("positive", positive);
					System.out.println(positive);
				}else if(str.contains("negative threshold")){//负阈值
					String negative = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("negative", negative);
					System.out.println(negative);
				}else if(str.contains("feasible nodes")){//可行节点
					String nodes = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("nodes", nodes);
					System.out.println(nodes);
				}else if(str.contains("candidate threshold")){//候选阈值
					String candidate = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("candidate", candidate);
					System.out.println(candidate);
				}else if(str.contains("confidence")){//置信度
					String confidence = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("confidence", confidence);
					System.out.println(confidence);
				}else if(str.contains("output impact nodes")){//输出影响结点
					String outputImpact = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("outputImpact", outputImpact);
					System.out.println(outputImpact);
				}else if(str.contains("type")){//类型
					String type = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("type", type);
					System.out.println(type);
				}else if(str.contains("options")){//选项
					String options = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("options", options);
					System.out.println(options);
				}else if(str.contains("logfile")){//记录文件
					String logfile = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("logfile", logfile);
					System.out.println(logfile);
				}else if(str.contains("verbose")){//冗余
					String verbose = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("verbose", verbose);
					System.out.println(verbose);
				}else if(str.contains("initial points")){//起始节点
					String initialpoints = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("initialpoints", initialpoints);
					System.out.println(initialpoints);
				}else if(str.contains("output prefix")){//输出前缀
					String outputPrefix = str.split(":")[str.split(":").length-1];
				request.getSession().setAttribute("outputPrefix", outputPrefix);
					System.out.println(outputPrefix);
				}else if(str.contains("debug")){//调试
					String debug = str.split(":")[str.split(":").length-1];
					request.getSession().setAttribute("debug", debug);
					System.out.println(debug);
				}else {
					System.err.println("全部输出完毕");
				}
				//System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "form1";
		
		
	}
	
	@RequestMapping(value="/saveYML1.do",method={RequestMethod.POST})
	public void saveYML1(HttpServletRequest request) {
			System.out.println("这里存储到文件中");
		
	}
	
}
