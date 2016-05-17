package hit.controller;
/**
 * @author sunpeng123
 * 
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
	
	@RequestMapping(value="readBoosterYaml.do")
	public void readYaml(HttpServletRequest request) throws FileNotFoundException{
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
	        
	        request.getSession().setAttribute("location", scenario.get("location"));
	        request.getSession().setAttribute("type", scenario.get("type"));
	        request.getSession().setAttribute("strength", scenario.get("strength"));
	        request.getSession().setAttribute("start time", scenario.get("start time"));
	        request.getSession().setAttribute("end time", scenario.get("end time"));
	        request.getSession().setAttribute("tsg file", scenario.get("tsg file"));
	        request.getSession().setAttribute("tsi file", scenario.get("tsi file"));
	        request.getSession().setAttribute("msx file", scenario.get("msx file"));
	        request.getSession().setAttribute("msx species", scenario.get("msx species"));
	        request.getSession().setAttribute("merlion", scenario.get("merlion"));
	        
	        request.getSession().setAttribute("detection", booster_mip.get("detection"));
	        request.getSession().setAttribute("model type", booster_mip.get("model type"));
	        request.getSession().setAttribute("model format", booster_mip.get("model format"));
	        request.getSession().setAttribute("stoichiometric ratio", booster_mip.get("stoichiometric ratio"));
	        request.getSession().setAttribute("objective", booster_mip.get("objective"));
	        request.getSession().setAttribute("toxin decay coefficient", booster_mip.get("toxin decay coefficient"));
	        request.getSession().setAttribute("decon decay coefficient", booster_mip.get("decon decay coefficient"));
	        request.getSession().setAttribute("feasible nodes", booster_mip.get("feasible nodes"));
	        request.getSession().setAttribute("infeasible nodes", booster_mip.get("infeasible nodes"));
	        request.getSession().setAttribute("fixed nodes", booster_mip.get("fixed nodes"));
	        request.getSession().setAttribute("max boosters", booster_mip.get("max boosters"));
	        request.getSession().setAttribute("type", booster_mip.get("type"));
	        request.getSession().setAttribute("strength", booster_mip.get("strength"));
	        request.getSession().setAttribute("response time", booster_mip.get("response time"));
	        request.getSession().setAttribute("duration", booster_mip.get("duration"));
	        request.getSession().setAttribute("evaluate", booster_mip.get("evaluate"));
	        
	        request.getSession().setAttribute("type", solver.get("type"));
	        request.getSession().setAttribute("options", solver.get("options"));
	        request.getSession().setAttribute("logfile", solver.get("logfile"));
	        request.getSession().setAttribute("verbose", solver.get("verbose"));
	        
	        
	        request.getSession().setAttribute("output prefix", configure.get("output prefix"));
	        request.getSession().setAttribute("debug", configure.get("debug"));
        
		
	}
	
	@RequestMapping(value="saveBoosterYAML.do")
	public String saveYAML(){
		
		
		
		return null;
		
	}

}
