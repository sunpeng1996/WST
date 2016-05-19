package hit.controller;
/**
 * 取样点优化
 */
import hit.util.CommandUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ho.yaml.Yaml;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class GrabsampleController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="")
	public void readYaml(HttpServletRequest request) throws FileNotFoundException{
		//读取取样点优化的配置文件，并把数据保存到session域中
	
		 File f = new File("G:/wst-1.2/bin/grabsample_ex1.yml");
		 System.out.println(f.getAbsolutePath());
		 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	     System.out.println(ml.size());        
	        //System.out.println();
	        HashMap grabsample = (HashMap) ml.get("grabsample");
	        HashMap network = (HashMap) ml.get("network");
	        HashMap scenario = (HashMap) ml.get("scenario");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        
	        request.getSession().setAttribute("epanet", network.get("epanet file"));//EPANET管网模型
	        System.out.println(network.get("epanet file"));
	        
	        request.getSession().setAttribute("location", scenario.get("location"));
	        request.getSession().setAttribute("type", scenario.get("type"));
	        request.getSession().setAttribute("strength", scenario.get("strength"));
	        request.getSession().setAttribute("species", scenario.get("species"));
	        request.getSession().setAttribute("start time", scenario.get("start time"));
	        request.getSession().setAttribute("end time", scenario.get("end time"));
	        request.getSession().setAttribute("tsg file", scenario.get("tsg file"));
	        request.getSession().setAttribute("tsi file", scenario.get("tsi file"));
	        request.getSession().setAttribute("msx file", scenario.get("msx file"));
	        request.getSession().setAttribute("msx species", scenario.get("msx species"));
	        request.getSession().setAttribute("merlion", scenario.get("merlion"));
	        
	        
	        request.getSession().setAttribute("model format", grabsample.get("model format"));
	        request.getSession().setAttribute("sample time", grabsample.get("sample time"));
	        request.getSession().setAttribute("threshold", grabsample.get("threshold"));
	        request.getSession().setAttribute("fixed sensors", grabsample.get("fixed sensors"));
	        request.getSession().setAttribute("feasible nodes", grabsample.get("feasible nodes"));
	        request.getSession().setAttribute("num samples", grabsample.get("num samples"));
	        request.getSession().setAttribute("greedy selection", grabsample.get("greedy selection"));
	        
	        request.getSession().setAttribute("type", solver.get("type"));
	        request.getSession().setAttribute("options", solver.get("options"));
	        request.getSession().setAttribute("logfile", solver.get("logfile"));
	        request.getSession().setAttribute("verbose", solver.get("verbose"));
	        request.getSession().setAttribute("initial points", solver.get("initial points"));
	        
	        
	        request.getSession().setAttribute("output prefix", configure.get("output prefix"));
	        request.getSession().setAttribute("debug", configure.get("debug"));
        
		
	}
	
	@RequestMapping(value="saveGradsampleYAML.do")
	public String saveYAML(){
		
		
		
		return null;
		
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:调用取样点优化的方法
	 *创建时间:2016年5月17日下午5:16:52
	 */
	@RequestMapping(value="/Grabsample.do")
	public String Inversion(HttpServletRequest request){
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","grabsample ","G:\\wst-1.2\\bin\\grabsample_ex1.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("取样点优化程序运行时间： "+(totalTime)+"ms");
		//然后跳转到运行之后生成的页面就可以了
		return "Page/grabsample";
		
	}

}
