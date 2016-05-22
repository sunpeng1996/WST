package hit.controller;
/**
 * @author sunpeng123
 *阀门调度控制器3
 */
import hit.util.CommandUtils;
import hit.util.modifyYml3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ho.yaml.Yaml;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class FlushingController extends AbstractController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/readFlushingYaml.do")
	public String readYaml(HttpServletRequest request) throws FileNotFoundException{
		//读取污染源定位的配置文件，并把数据保存到session域中
		 File f = new File("G:/wst-1.2/bin/flushing_ex2.yml");
		 System.out.println(f.getAbsolutePath());
		 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	     System.out.println(ml.size());        
	        //System.out.println();
	        HashMap network = (HashMap) ml.get("network");
	        HashMap scenario = (HashMap) ml.get("scenario");
	        HashMap flushing = (HashMap) ml.get("flushing");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        HashMap impact = (HashMap) ml.get("impact");
	        
	        request.getSession().setAttribute("epanet", network.get("epanet file"));//EPANET管网模型
	        System.out.println(network.get("epanet file"));
	        
	        request.getSession().setAttribute("location", scenario.get("location"));
	        request.getSession().setAttribute("type_scenario", scenario.get("type"));
	        request.getSession().setAttribute("strength", scenario.get("strength"));
	        request.getSession().setAttribute("species", scenario.get("species"));
	        request.getSession().setAttribute("start_time", scenario.get("start time"));
	        request.getSession().setAttribute("end_time", scenario.get("end time"));
	        request.getSession().setAttribute("tsg_file", scenario.get("tsg file"));
	        request.getSession().setAttribute("tsi_file", scenario.get("tsi file"));
	        request.getSession().setAttribute("msx_file", scenario.get("msx file"));
	        request.getSession().setAttribute("msx_species", scenario.get("msx species"));
	        request.getSession().setAttribute("merlion", scenario.get("merlion"));
	        request.getSession().setAttribute("msx_species_scenario", scenario.get("msx species"));

	        
	        
	        request.getSession().setAttribute("erd_file", impact.get("erd file"));
	        request.getSession().setAttribute("metric", impact.get("metric"));
	        request.getSession().setAttribute("tai_file", impact.get("tai file"));
	        request.getSession().setAttribute("response_time_impact", impact.get("response time"));
	        request.getSession().setAttribute("detection_limit", impact.get("detection limit"));
	        request.getSession().setAttribute("detection_confidence", impact.get("detection confidence"));
	        request.getSession().setAttribute("msx_species_impact", impact.get("msx species"));
	        
	        request.getSession().setAttribute("detection", flushing.get("detection"));
	        HashMap flush_nodes = (HashMap) flushing.get("flush nodes");
	        request.getSession().setAttribute("feasible_nodes", flush_nodes.get("feasible nodes"));
	        request.getSession().setAttribute("infeasible_nodes", flush_nodes.get("infeasible nodes"));
	        request.getSession().setAttribute("max_nodes", flush_nodes.get("max nodes"));
	        request.getSession().setAttribute("rate", flush_nodes.get("rate"));
	        request.getSession().setAttribute("response_time_flush_nodes", flush_nodes.get("response time"));
	        request.getSession().setAttribute("duration", flush_nodes.get("duration"));
	        
	        HashMap close_valves = (HashMap) flushing.get("close valves");
	        request.getSession().setAttribute("feasible_pipes", close_valves.get("feasible pipes"));
	        request.getSession().setAttribute("infeasible_pipes", close_valves.get("infeasible pipes"));
	        request.getSession().setAttribute("max_pipes", close_valves.get("max pipes"));
	        request.getSession().setAttribute("response_time_close_valves", close_valves.get("response time"));
	        
	        request.getSession().setAttribute("type_solver", solver.get("type"));
	        request.getSession().setAttribute("options", solver.get("options"));
	        request.getSession().setAttribute("logfile", solver.get("logfile"));
	        request.getSession().setAttribute("verbose", solver.get("verbose"));
	        
	        
	        request.getSession().setAttribute("output_prefix", configure.get("output prefix"));
	        request.getSession().setAttribute("debug", configure.get("debug"));
	        Date date = new Date();
	        System.out.println("阀门调度文件已经取出"+date.toString());
			return null;
			
		
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:阀门调度
	 *创建时间:2016年5月21日下午8:36:08
	 * @return
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value="/saveFlushingYAML.do")
	public String saveFlushingYAML(HttpServletRequest request,@RequestParam(defaultValue="") String epanet,
			@RequestParam(defaultValue="") String detection,@RequestParam(defaultValue="") String location, @RequestParam(defaultValue="") String feasible_nodes,
			@RequestParam(defaultValue="") String type_scenario,@RequestParam(defaultValue="") String infeasible_nodes,@RequestParam (defaultValue="")String strength,
			@RequestParam(defaultValue="") String max_nodes,@RequestParam(defaultValue="") String start_time,@RequestParam(defaultValue="") String rate,
			@RequestParam(defaultValue="") String end_time,@RequestParam(defaultValue="") String response_time_flush_nodes,@RequestParam(defaultValue="") String tsg_file,
			@RequestParam(defaultValue="") String duration,@RequestParam(defaultValue="") String tsi_file,@RequestParam(defaultValue="") String msx_file,
			@RequestParam(defaultValue="") String feasible_pipes,@RequestParam(defaultValue="") String msx_species_scenario,@RequestParam(defaultValue="") String infeasible_pipes,
			@RequestParam(defaultValue="") String merlion,@RequestParam(defaultValue="") String max_pipes,@RequestParam(defaultValue="") String response_time_close_valves,
			@RequestParam(defaultValue="") String erd_file,@RequestParam(defaultValue="") String metric,@RequestParam(defaultValue="") String type_solver,
			@RequestParam(defaultValue="") String tai_file,@RequestParam(defaultValue="") String options,@RequestParam(defaultValue="") String response_time_impact,
			@RequestParam(defaultValue="") String logfile,@RequestParam(defaultValue="") String detection_limit,@RequestParam(defaultValue="") String verbose,
			@RequestParam(defaultValue="") String detection_confidence,@RequestParam(defaultValue="") String msx_species_impact,@RequestParam(defaultValue="") String output_prefix,
			@RequestParam(defaultValue="") String debug,@RequestParam(defaultValue="") String species) throws FileNotFoundException{
		
			System.out.println("正在更改文件");
			//读取污染源定位的配置文件，并把数据保存到session域中
			File f = new File("G:/wst-1.2/bin/flushing_ex2.yml");
			System.out.println(f.getAbsolutePath());
			HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	        //System.out.println();
	        HashMap network = (HashMap) ml.get("network");
	        HashMap scenario = (HashMap) ml.get("scenario");
	        HashMap flushing = (HashMap) ml.get("flushing");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        HashMap impact = (HashMap) ml.get("impact");
	        
	        network.replace("epanet file", network.get("epanet file"), epanet);
	        
	        scenario.replace("location", scenario.get("location"),location );
	        scenario.replace("type", scenario.get("type"),type_scenario );
	        scenario.replace("strength", scenario.get("strength"), strength);
	        scenario.replace("species", scenario.get("species"),species );
	        scenario.replace("start time", scenario.get("start time"), start_time);
	        scenario.replace("end time", scenario.get("end time"),end_time );
	        scenario.replace("tsg file", scenario.get("tsg file"),tsg_file );
	        scenario.replace("tsi file",scenario.get("tsi file") , tsi_file);
	        scenario.replace("msx file", scenario.get("msx file"), msx_file);
	        scenario.replace("msx species",scenario.get("msx species") ,msx_species_scenario );
	        scenario.replace("merlion", scenario.get("merlion"), merlion);
	        
	        
	        impact.replace("erd file", impact.get("erd file"),erd_file  );
	        impact.replace("metric", impact.get("metric"),  metric);
	        impact.replace("tai file", impact.get("tai file"), tai_file);
	        impact.replace("response time", impact.get("response time"),  response_time_impact);
	        impact.replace("detection limit", impact.get("detection limit"),  detection_limit);
	        impact.replace("detection confidence", impact.get("detection confidence"),  detection_confidence);
	        impact.replace("msx species", impact.get("msx species"),  msx_species_impact);
	        
	        
	        flushing.replace("detection", flushing.get("detection"), detection);
		
	        HashMap flush_nodes = (HashMap) flushing.get("flush nodes");
	        flush_nodes.replace("feasible nodes", flush_nodes.get("feasible nodes"),feasible_nodes );
	        flush_nodes.replace("infeasible nodes", flush_nodes.get("infeasible nodes"),infeasible_nodes );
	        flush_nodes.replace("max nodes", flush_nodes.get("max nodes"),max_nodes );
	        flush_nodes.replace("rate", flush_nodes.get("rate"),rate );
	        flush_nodes.replace("response time", flush_nodes.get("response time"), response_time_flush_nodes);
	        flush_nodes.replace("duration", flush_nodes.get("duration"), duration);

	        HashMap close_valves = (HashMap) flushing.get("close valves");
	        close_valves.replace("feasible pipes",  close_valves.get("feasible pipes"), feasible_pipes);
	        close_valves.replace("infeasible pipes",  close_valves.get("infeasible pipes"), infeasible_pipes);
	        close_valves.replace("max pipes",  close_valves.get("max pipes"), max_pipes);
	        close_valves.replace("response time",  close_valves.get("response time"), response_time_close_valves);
	        
	        
	        solver.replace("type", solver.get("type"), type_solver );
	        solver.replace("options", solver.get("options"), options );
	        solver.replace("logfile", solver.get("logfile"),logfile  );
	        solver.replace("verbose", solver.get("verbose"),  verbose);
	        
	        configure.replace("output prefix",  configure.get("output prefix") , output_prefix );
	        configure.replace("debug",  configure.get("debug") ,debug  );
	        
	        Date date = new Date();
	        System.out.println("阀门调度文件修改完毕" + date.toString());
	        
	        Yaml yaml = new Yaml();
	        yaml.dump(ml, new File("G:\\wst-1.2\\bin\\flushing_ex2.yml"), false);
	        modifyYml3.modifyFile("G:\\wst-1.2\\bin\\flushing_ex2.yml");
	        System.out.println("文件已经更改完成");
	        
	        
	        //第二次设置session数据
	        readYaml(request);
	        
	        
		return "index";
		
	}
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @Description:调用阀门调度的方法
	 * @date
	 */
	@RequestMapping(value="/Flushing.do")
	public String Inversion(HttpServletRequest request) throws IllegalStateException, IOException{
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","flushing","G:\\wst-1.2\\bin\\flushing_ex2.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("污染源定位程序运行时间： "+(totalTime)+"ms");
		
		
		return "Page/flushing";
		
	}
	
	
	

}
