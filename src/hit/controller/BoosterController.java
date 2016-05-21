package hit.controller;
/**
 * @author sunpeng123
 * 消毒增压控制器
 */
import hit.util.CommandUtils;
import hit.util.modifyYml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
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
public class BoosterController extends AbstractController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/readBoosterYaml.do")
	public String readYaml(HttpServletRequest request) throws FileNotFoundException{
		//读取取样点优化的配置文件，并把数据保存到session域中
		 File f = new File("G:/wst-1.2/bin/booster_mip_ex1.yml");
		 System.out.println(f.getAbsolutePath());
		 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
	     System.out.println(ml.size());        
	        //System.out.println();
	        HashMap booster_mip = (HashMap) ml.get("booster mip");
	        HashMap network = (HashMap) ml.get("network");
	        HashMap scenario = (HashMap) ml.get("scenario");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        
	        request.getSession().setAttribute("epanet", network.get("epanet file"));//EPANET管网模型
	        System.out.println(network.get("epanet file"));
	        
	        request.getSession().setAttribute("location_scenario", scenario.get("location"));
	        request.getSession().setAttribute("type_scenario", scenario.get("type"));
	        request.getSession().setAttribute("strength_scenario", scenario.get("strength"));
	        request.getSession().setAttribute("start_time_scenario", scenario.get("start time"));
	        request.getSession().setAttribute("end_time_scenario", scenario.get("end time"));
	        request.getSession().setAttribute("tsg_file_scenario", scenario.get("tsg file"));
	        request.getSession().setAttribute("tsi_file_scenario", scenario.get("tsi file"));
	        request.getSession().setAttribute("msx_file_scenario", scenario.get("msx file"));
	        request.getSession().setAttribute("msx_species_scenario", scenario.get("msx species"));
	        request.getSession().setAttribute("merlion_scenario", scenario.get("merlion"));
	        
	        request.getSession().setAttribute("detection_booster_mip", booster_mip.get("detection"));
	        request.getSession().setAttribute("model_type_booster_mip", booster_mip.get("model type"));
	        request.getSession().setAttribute("model_format_booster_mip", booster_mip.get("model format"));
	        request.getSession().setAttribute("stoichiometric_ratio_booster_mip", booster_mip.get("stoichiometric ratio"));
	        request.getSession().setAttribute("objective_booster_mip", booster_mip.get("objective"));
	        request.getSession().setAttribute("toxin_decay_coefficient_booster_mip", booster_mip.get("toxin decay coefficient"));
	        request.getSession().setAttribute("decon_decay_coefficient_booster_mip", booster_mip.get("decon decay coefficient"));
	        request.getSession().setAttribute("feasible_nodes_booster_mip", booster_mip.get("feasible nodes"));
	        request.getSession().setAttribute("infeasible_nodes_booster_mip", booster_mip.get("infeasible nodes"));
	        request.getSession().setAttribute("fixed_nodes_booster_mip", booster_mip.get("fixed nodes"));
	        request.getSession().setAttribute("max_boosters_booster_mip", booster_mip.get("max boosters"));
	        request.getSession().setAttribute("type_booster_mip_booster_mip", booster_mip.get("type"));
	        request.getSession().setAttribute("strength_booster_mip", booster_mip.get("strength"));
	        request.getSession().setAttribute("response_time_booster_mip", booster_mip.get("response time"));
	        request.getSession().setAttribute("duration_booster_mip", booster_mip.get("duration"));
	        request.getSession().setAttribute("evaluate_booster_mip", booster_mip.get("evaluate"));
	        
	        request.getSession().setAttribute("type_solver", solver.get("type"));
	        request.getSession().setAttribute("options_solver", solver.get("options"));
	        request.getSession().setAttribute("logfile_solver", solver.get("logfile"));
	        request.getSession().setAttribute("verbose_solver", solver.get("verbose"));
	        
	        
	        request.getSession().setAttribute("output_prefix_configure", configure.get("output prefix"));
	        request.getSession().setAttribute("debug_configure", configure.get("debug"));
	        
	        
	        Date date = new Date();
	        System.out.println("阀门调度文件已经取出"+date.toString());
			return null;
        
		
	}
	
	@RequestMapping(value="/saveBoosterYAML.do")
	public String saveBoosterYAML(HttpServletRequest request, @RequestParam(defaultValue="") String epanet,
			 @RequestParam(defaultValue="") String detection_booster_mip , @RequestParam(defaultValue="") String  model_type_booster_mip,
			 @RequestParam(defaultValue="") String location_scenario , @RequestParam(defaultValue="") String model_format_booster_mip ,
			 @RequestParam(defaultValue="") String  strength_scenario, @RequestParam(defaultValue="") String objective_booster_mip ,
			 @RequestParam(defaultValue="") String  msx_species_scenario, @RequestParam(defaultValue="") String toxin_decay_coefficient_booster_mip ,
			 @RequestParam(defaultValue="") String  start_time_scenario, @RequestParam(defaultValue="") String decon_decay_coefficient_booster_mip ,
			 @RequestParam(defaultValue="") String end_time_scenario , @RequestParam(defaultValue="") String  feasible_nodes_booster_mip,
			 @RequestParam(defaultValue="") String  tsg_file_scenario, @RequestParam(defaultValue="") String infeasible_nodes_booster_mip ,
			 @RequestParam(defaultValue="") String  msx_file_scenario, @RequestParam(defaultValue="") String  fixed_nodes_booster_mip,
			 @RequestParam(defaultValue="") String  type_scenario, @RequestParam(defaultValue="") String max_boosters_booster_mip ,
			 @RequestParam(defaultValue="") String  merlion_scenario, @RequestParam(defaultValue="") String type_booster_mip_booster_mip ,
			 @RequestParam(defaultValue="") String strength_booster_mip , @RequestParam(defaultValue="") String type_solver ,
			 @RequestParam(defaultValue="") String response_time_booster_mip , @RequestParam(defaultValue="") String  options_solver,
			 @RequestParam(defaultValue="") String  duration_booster_mip, @RequestParam(defaultValue="") String  logfile_solver,
			 @RequestParam(defaultValue="") String evaluate_booster_mip , @RequestParam(defaultValue="") String  verbose_solver,
			 @RequestParam(defaultValue="") String  output_prefix_configure, @RequestParam(defaultValue="") String debug_configure,
			 @RequestParam(defaultValue="") String tsi_file_scenario,@RequestParam String stoichiometric_ratio_booster_mip
			) throws FileNotFoundException{
		
		//
			 File f = new File("G:/wst-1.2/bin/booster_mip_ex1.yml");
			 System.out.println(f.getAbsolutePath());
			 HashMap ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
		     System.out.println(ml.size());        
		     
	        HashMap booster_mip = (HashMap) ml.get("booster mip");
	        HashMap network = (HashMap) ml.get("network");
	        HashMap scenario = (HashMap) ml.get("scenario");
	        HashMap solver = (HashMap) ml.get("solver");
	        HashMap configure = (HashMap) ml.get("configure");
	        
	        booster_mip.replace("detection", booster_mip.get("detection"), detection_booster_mip);
	        booster_mip.replace("model type", booster_mip.get("model type"), model_type_booster_mip);
	        booster_mip.replace("model format", booster_mip.get("model format"), model_format_booster_mip);
	        booster_mip.replace("stoichiometric ratio", booster_mip.get("stoichiometric ratio"),stoichiometric_ratio_booster_mip );
	        booster_mip.replace("objective", booster_mip.get("objective"), objective_booster_mip);
	        booster_mip.replace("toxin decay coefficient", booster_mip.get("toxin decay coefficient"), toxin_decay_coefficient_booster_mip);
	        booster_mip.replace("decon decay coefficient", booster_mip.get("decon decay coefficient"), decon_decay_coefficient_booster_mip);
	        booster_mip.replace("feasible nodes", booster_mip.get("feasible nodes"),feasible_nodes_booster_mip );
	        booster_mip.replace("infeasible nodes", booster_mip.get("infeasible nodes"), infeasible_nodes_booster_mip );
	        booster_mip.replace("fixed nodes", booster_mip.get("fixed nodes"), fixed_nodes_booster_mip);
	        booster_mip.replace("max boosters", booster_mip.get("max boosters"), max_boosters_booster_mip );
	        booster_mip.replace("type", booster_mip.get("type"), type_booster_mip_booster_mip);
	        booster_mip.replace("strength", booster_mip.get("strength"),strength_booster_mip );
	        booster_mip.replace("response time", booster_mip.get("response time"),response_time_booster_mip );
	        booster_mip.replace("duration", booster_mip.get("duration"),duration_booster_mip );
	        booster_mip.replace("evaluate", booster_mip.get("evaluate"),evaluate_booster_mip );
	        
	        
	        scenario.replace("location", scenario.get("location"),location_scenario  );
	        scenario.replace("type", scenario.get("type"), type_scenario );
	        scenario.replace("strength", scenario.get("strength"), strength_scenario );
	        scenario.replace("start time", scenario.get("start time"), start_time_scenario );
	        scenario.replace("end time", scenario.get("end time"),end_time_scenario  );
	        scenario.replace("tsg file", scenario.get("tsg file"), tsg_file_scenario );
	        scenario.replace("tsi file", scenario.get("tsi file"), tsi_file_scenario );
	        scenario.replace("msx file", scenario.get("msx file"), msx_file_scenario );
	        scenario.replace("msx species", scenario.get("msx species"),msx_file_scenario  );
	        scenario.replace("merlion", scenario.get("merlion"),  merlion_scenario);
	        
	        
	        network.replace("epanet file", network.get("epanet file"), epanet);
	        
	        solver.replace("type", solver.get("type"), type_solver);
	        solver.replace("options", solver.get("options"), options_solver);
	        solver.replace("type",  solver.get("logfile"), logfile_solver);
	        solver.replace("type", solver.get("verbose"), verbose_solver);
	        
	        configure.replace("output prefix", configure.get("output prefix"),output_prefix_configure );
	        configure.replace("debug", configure.get("debug"), debug_configure);
		
	        Yaml yaml = new Yaml();
	        yaml.dump(ml, new File("G:/wst-1.2/bin/booster_mip_ex1.yml"), false);
	        modifyYml.modifyFile("G:/wst-1.2/bin/booster_mip_ex1.yml");
	        System.out.println("文件已经更改完成");
	        readYaml(request);
		
	        return null;
		
	}
	
	
	@RequestMapping(value="/booster_mip.do")
	public String booster_mip(HttpServletRequest request){
		
		long startTime=System.currentTimeMillis();   //获取开始时间
		CommandUtils.excuteCommand(new String[]{"G:\\wst-1.2\\bin\\wst.exe","booster_mip","G:\\wst-1.2\\bin\\booster_mip_ex1.yml"},
							null,	new File("G:/wst-1.2/bin"));
		long endTime=System.currentTimeMillis(); //获取结束时间
		long totalTime = endTime-startTime;
		System.out.println("消毒增压运行时间： "+(totalTime)+"ms");
		
		return "Page/booster";
		
	}

}
