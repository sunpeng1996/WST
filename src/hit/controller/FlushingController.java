package hit.controller;
/**
 * @author sunpeng123
 *阀门调度控制器
 */
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

	        
	        
	        request.getSession().setAttribute("erd_file", impact.get("erd file"));
	        request.getSession().setAttribute("metric", impact.get("metric"));
	        request.getSession().setAttribute("tai_file", impact.get("tai file"));
	        request.getSession().setAttribute("response_time_impact", impact.get("response time"));
	        request.getSession().setAttribute("detection_limit", impact.get("detection limit"));
	        request.getSession().setAttribute("detection_confidence", impact.get("detection confidence"));
	        request.getSession().setAttribute("msx_species", impact.get("msx species"));
	        
	        
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
			return null;
			
		
	}
	
	@RequestMapping(value="/saveFlushingYAML.do")
	public String saveFlushingYAML(){
		
		
		
		return null;
		
	}
	
	
	
	

}
