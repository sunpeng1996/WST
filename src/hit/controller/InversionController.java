package hit.controller;
/**
 * @author sunpeng123
 * 第一个
 * 污染源定位的controller
 */
import hit.util.CommandUtils;
import hit.util.modifyYml1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ho.yaml.Yaml;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@RequestMapping(value="/readInversionYaml.do",method={RequestMethod.POST,RequestMethod.GET})
	public String readYaml(HttpServletRequest request) throws FileNotFoundException{
		//读取污染源定位的配置文件，并把数据保存到session域中
		
		
		request.getSession().removeAttribute("epanet");
		
		System.out.println("到达污染源定位的后台action位置");
		
			 File f = new File("G:/wst-1.2/bin/inversion_ex1.yml");
			 System.out.println(f.getAbsolutePath());
			 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);

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
	        System.out.println("污染源定位文件解析完毕----------dasdadadada");
	        
	        
	        
			return null;
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:修改yaml配置文件的方法
	 *创建时间:2016年5月18日下午2:41:37
	 * @return
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value="saveInversionYAML.do")
	public String saveYAML(HttpServletRequest request,@RequestParam(defaultValue="") String epanet,
			@RequestParam(defaultValue="") String algorithm,	@RequestParam(defaultValue="") String formulation,
			@RequestParam(defaultValue="") String grab_samples,	@RequestParam(defaultValue="") String model_format,	
			@RequestParam(defaultValue="") String horizon,	@RequestParam(defaultValue="") String type,	
			@RequestParam(defaultValue="") String num_injections,	@RequestParam(defaultValue="") String options,	
			@RequestParam(defaultValue="") String measurement_failure,	@RequestParam(defaultValue="") String logfile,	
			@RequestParam(defaultValue="") String positive_threshold,	@RequestParam(defaultValue="") String verbose,	
			@RequestParam(defaultValue="") String negative_threshold,	@RequestParam(defaultValue="") String initial_points,	
			@RequestParam(defaultValue="") String feasible_nodes,	@RequestParam(defaultValue="") String candidate_threshold,	
			@RequestParam(defaultValue="") String output_prefix,	@RequestParam(defaultValue="") String confidence	,	
			@RequestParam(defaultValue="") String debug,	@RequestParam(defaultValue="") String output_impact_nodes	
			) throws FileNotFoundException{
		
		 	File f = new File("G:\\wst-1.2\\bin\\inversion_ex1.yml");
	        System.out.println(f.getAbsolutePath());
	        HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	      /*  modifyYml1.modifyFile("G:\\wst-1.2\\bin\\inversion_ex1.yml");*/
	        System.out.println(ml.size());        
	        //System.out.println();
	        HashMap network = (HashMap) ml.get("network");
	        HashMap measurements = (HashMap) ml.get("measurements");
	        HashMap inversion = (HashMap) ml.get("inversion");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        
	        
	        network.replace("epanet file", network.get("epanet file"), epanet);
	        
	        measurements.replace("grab samples",  measurements.get("grab samples"),grab_samples );
	        
	        inversion.replace("algorithm",inversion.get("algorithm") , algorithm);
	        inversion.replace("horizon", inversion.get("horizon"), horizon);
	        inversion.replace("formulation", inversion.get("formulation"),formulation );
	        inversion.replace("model format", inversion.get("model format"), model_format);
	        inversion.replace("num injections", inversion.get("num injections"),num_injections );
	        inversion.replace("measurement failure", inversion.get("measurement failure"),measurement_failure );
	        inversion.replace("positive threshold", inversion.get("positive threshold"), positive_threshold);
	        inversion.replace("negative threshold", inversion.get("negative threshold"), negative_threshold);
	        inversion.replace("feasible nodes", inversion.get("feasible nodes"),feasible_nodes );
	        inversion.replace("candidate threshold", inversion.get("candidate threshold"), candidate_threshold);
	        inversion.replace("confidence", inversion.get("confidence"), confidence);
	        inversion.replace("output impact nodes", inversion.get("output impact nodes"),output_impact_nodes );
	        
	        solver.replace("type",solver.get("type"), type);
	        solver.replace("options",solver.get("options"), options);
	        solver.replace("logfile",solver.get("logfile"), logfile);
	        solver.replace("verbose",solver.get("verbose"), verbose);
	        solver.replace("initial points",solver.get("initial points"), initial_points);
	        
	        configure.replace("output prefix", configure.get("output prefix"), output_prefix);
	        configure.replace("debug", configure.get("debug"),debug);
	        
	        Yaml yaml = new Yaml();
	        yaml.dump(ml, new File("G:\\wst-1.2\\bin\\inversion_ex1.yml"), false);
	        modifyYml1.modifyFile("G:\\wst-1.2\\bin\\inversion_ex1.yml");
	        System.out.println("文件已经更改完成");
	        
	        //第二次重复操作，目的是更新session的数据
	        readYaml(request);
	        
	        
	        return "index";
		
	}
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @Description:调用污染源定位命令的方法
	 *创建时间:2016年5月17日下午5:16:52
	 */
	@RequestMapping(value="/Inversion.do")
	public String Inversion(HttpServletRequest request) throws IllegalStateException, IOException{
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","inversion","G:\\wst-1.2\\bin\\inversion_ex1.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("污染源定位程序运行时间： "+(totalTime)+"ms");
		//然后跳转到运行之后生成的页面就可以了
		
		//作死，设计文件上传
		//FileUploadToServer(request,"G:\\wst-1.2\\bin\\inversion_ex1\\Net3visualization_output.html");
		
		return "Page/inversion";
		
	}



}
