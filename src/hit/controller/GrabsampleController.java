package hit.controller;
/**
 * 取样点优化
 */
import hit.util.CommandUtils;
import hit.util.modifyYml1;
import hit.util.modifyYml2;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/readGrabsampleYaml.do")
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
	        request.getSession().setAttribute("type_changjing", scenario.get("type"));
	        request.getSession().setAttribute("strength", scenario.get("strength"));
	        request.getSession().setAttribute("species", scenario.get("species"));
	        request.getSession().setAttribute("start_time", scenario.get("start time"));
	        request.getSession().setAttribute("end_time", scenario.get("end time"));
	        request.getSession().setAttribute("tsg_file", scenario.get("tsg file"));
	        request.getSession().setAttribute("tsi_file", scenario.get("tsi file"));
	        request.getSession().setAttribute("msx_file", scenario.get("msx file"));
	        request.getSession().setAttribute("msx_species", scenario.get("msx species"));
	        request.getSession().setAttribute("merlion", scenario.get("merlion"));
	        
	        
	        request.getSession().setAttribute("model_format", grabsample.get("model format"));
	        request.getSession().setAttribute("sample_time", grabsample.get("sample time"));
	        request.getSession().setAttribute("threshold", grabsample.get("threshold"));
	        request.getSession().setAttribute("fixed_sensors", grabsample.get("fixed sensors"));
	        request.getSession().setAttribute("feasible_nodes", grabsample.get("feasible nodes"));
	        request.getSession().setAttribute("num_samples", grabsample.get("num samples"));
	        request.getSession().setAttribute("greedy_selection", grabsample.get("greedy selection"));
	        
	        request.getSession().setAttribute("type_qiujiechengxu", solver.get("type"));
	        request.getSession().setAttribute("options", solver.get("options"));
	        request.getSession().setAttribute("logfile", solver.get("logfile"));
	        request.getSession().setAttribute("verbose", solver.get("verbose"));
	        request.getSession().setAttribute("initial_points", solver.get("initial points"));
	        
	        
	        request.getSession().setAttribute("output_prefix", configure.get("output prefix"));
	        request.getSession().setAttribute("debug", configure.get("debug"));
	        
		
	}
	
	@RequestMapping(value="/saveGrabSampleYAML.do")
	public String saveGradsampleYAML(HttpServletRequest request,@RequestParam(defaultValue="") String epanet,
				@RequestParam(defaultValue="") String model_format,	@RequestParam(defaultValue="") String sample_time,
				@RequestParam(defaultValue="") String location,	@RequestParam(defaultValue="") String threshold,	
				@RequestParam(defaultValue="") String fixed_sensors,	@RequestParam(defaultValue="") String strength,	
				@RequestParam(defaultValue="") String feasible_nodes,	@RequestParam(defaultValue="") String species,	
				@RequestParam(defaultValue="") String num_samples,	@RequestParam(defaultValue="") String start_time,	
				@RequestParam(defaultValue="") String greedy_selection,	@RequestParam(defaultValue="") String end_time,	
				@RequestParam(defaultValue="") String tsg_file,	@RequestParam(defaultValue="") String type_qiujiechengxu,	
				@RequestParam(defaultValue="") String tsi_file,	@RequestParam(defaultValue="") String options,	
				@RequestParam(defaultValue="") String msx_file,	@RequestParam(defaultValue="") String logfile	,	
				@RequestParam(defaultValue="") String msx_species,	@RequestParam(defaultValue="") String verbose	,
				@RequestParam(defaultValue="") String merlion,	@RequestParam(defaultValue="") String initial_points	,
				@RequestParam(defaultValue="") String output_prefix,	@RequestParam(defaultValue="") String debug	,
				@RequestParam(defaultValue="") String type_changjing
				) throws FileNotFoundException{
			
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
		        
		        
		        network.replace("epanet file", network.get("epanet file"), epanet);
		        
		        
		        grabsample.replace("model format", grabsample.get("model format"),model_format );
		        grabsample.replace("sample time",grabsample.get("sample time") , sample_time);
		        grabsample.replace("threshold",grabsample.get("threshold") , threshold);
		        grabsample.replace("fixed sensors", grabsample.get("fixed sensors"),fixed_sensors );
		        grabsample.replace("feasible nodes",grabsample.get("feasible nodes") ,feasible_nodes );
		        grabsample.replace("num samples",grabsample.get("num samples") ,num_samples );
		        grabsample.replace("greedy selection", grabsample.get("greedy selection") , greedy_selection);
		        
		       scenario.replace("location",scenario.get("location") , location);
		       scenario.replace("type", scenario.get("type"), type_changjing);
		       scenario.replace("strength", scenario.get("strength"),  strength);
		       scenario.replace("species", scenario.get("species"), species);
		       scenario.replace("start time",scenario.get("start time") , start_time);
		       scenario.replace("end time", scenario.get("end time"), end_time);
		       scenario.replace("tsg file", scenario.get("tsg file"), tsg_file);
		       scenario.replace("tsi file",scenario.get("tsi file") , tsi_file);
		       scenario.replace("msx file", scenario.get("msx file"), msx_file);
		       scenario.replace("msx species",scenario.get("msx species") ,msx_species );
		       scenario.replace("merlion", scenario.get("merlion"), merlion);
		        
		     
		       solver.replace("type",  solver.get("type"),  type_qiujiechengxu);
		       solver.replace("options",  solver.get("options") , options );
		       solver.replace("logfile",solver.get("logfile")  , logfile );
		       solver.replace("verbose", solver.get("verbose") ,  verbose);
		       solver.replace("initial points",solver.get("initial points")  , initial_points );
		        
		        configure.replace("output prefix", configure.get("output prefix"), output_prefix);
		        configure.replace("debug", configure.get("debug"),debug);
		        
		        Yaml yaml = new Yaml();
		        yaml.dump(ml, new File("G:\\wst-1.2\\bin\\grabsample_ex1.yml"), false);
		        modifyYml2.modifyFile("G:\\wst-1.2\\bin\\grabsample_ex1.yml");
		        System.out.println("文件已经更改完成");
		        
		        //第二次重复操作，目的是更新session的数据
		       readYaml(request);
			        
		        System.out.println("取样点优化，修改成功");
		        return "index";
			
		}
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:调用取样点优化的方法
	 *创建时间:2016年5月17日下午5:16:52
	 */
	@RequestMapping(value="/Grabsample.do")
	public String Inversion(HttpServletRequest request){
		System.out.println("执行取样点优化的方法呢");
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","grabsample","G:\\wst-1.2\\bin\\grabsample_ex1.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("取样点优化程序运行时间： "+(totalTime)+"ms");
		//然后跳转到运行之后生成的页面就可以了
		return "Page/grabsample";
		
	}

}
