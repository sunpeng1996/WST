package hit.controller;
/**
 * @author sunpeng123
 * 污染源定位的controller
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
public class InversionController extends AbstractController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/readInversionYaml.do")
	public String readYaml(HttpServletRequest request) throws FileNotFoundException{
		//读取污染源定位的配置文件，并把数据保存到session域中
		 File f = new File("G:/wst-1.2/bin/inversion_ex1.yml");
		 System.out.println(f.getAbsolutePath());
		 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	     System.out.println(ml.size());        
	        //System.out.println();
	        HashMap network = (HashMap) ml.get("network");
	        HashMap measurements = (HashMap) ml.get("measurements");
	        HashMap inversion = (HashMap) ml.get("inversion");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        
	        request.getSession().setAttribute("epanet", network.get("epanet file"));//EPANET管网模型
	        System.out.println(network.get("epanet file"));
	        
	        request.getSession().setAttribute("grab_samples", measurements.get("grab samples"));
	        
	        
	        request.getSession().setAttribute("algorithm", inversion.get("algorithm"));
	        request.getSession().setAttribute("horizon", inversion.get("horizon"));
	        request.getSession().setAttribute("formulation", inversion.get("formulation"));
	        request.getSession().setAttribute("model_format", inversion.get("model format"));
	        request.getSession().setAttribute("num_injections", inversion.get("num injections"));
	        request.getSession().setAttribute("measurement_failure", inversion.get("measurement failure"));
	        request.getSession().setAttribute("positive_threshold", inversion.get("positive threshold"));
	        request.getSession().setAttribute("negative_threshold", inversion.get("negative threshold"));
	        request.getSession().setAttribute("feasible_nodes", inversion.get("feasible nodes"));
	        request.getSession().setAttribute("candidate_threshold", inversion.get("candidate threshold"));
	        request.getSession().setAttribute("confidence", inversion.get("confidence"));
	        request.getSession().setAttribute("output_impact_nodes", inversion.get("output impact nodes"));
	   
	        
	        
	     
	        
	        request.getSession().setAttribute("type", solver.get("type"));
	        request.getSession().setAttribute("options", solver.get("options"));
	        request.getSession().setAttribute("logfile", solver.get("logfile"));
	        request.getSession().setAttribute("verbose", solver.get("verbose"));
	        request.getSession().setAttribute("initial_points", solver.get("initial points"));
	        
	        
	        request.getSession().setAttribute("output_prefix", configure.get("output prefix"));
	        request.getSession().setAttribute("debug", configure.get("debug"));
			return null;
        
		
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:修改yaml配置文件的方法
	 *创建时间:2016年5月18日下午2:41:37
	 * @return
	 */
	@RequestMapping(value="saveInversionYAML.do")
	public String saveYAML(){
		
		
		
		return null;
		
	}
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:调用污染源定位命令的方法
	 *创建时间:2016年5月17日下午5:16:52
	 */
	@RequestMapping(value="/Inversion.do")
	public String Inversion(HttpServletRequest request){
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","inversion","G:\\wst-1.2\\bin\\inversion_ex1.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("污染源定位程序运行时间： "+(totalTime)+"ms");
		//然后跳转到运行之后生成的页面就可以了
		return "Page/inversion";
		
	}

}
