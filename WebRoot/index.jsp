<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html >
<head>
<link rel="Shortcut Icon" href="images/bg.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水资源调查</title>
<link rel="stylesheet" type="text/css" href="Css/index.css">
<link rel="stylesheet" type="text/css" href="Css/table_set.css">
</head>

<body id="bg">
<div class="web_title">
	<span>供水管网水质预警系统</span>
</div>
<div class="container">

	<div class="leftsidebar_box">
		<dl class="system_log">
			<dt onClick="changeImage()">污染源定位<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="polution_edit_a" >编辑</a></dd>
			<dd><a href="<%=path %>/Inversion.do" id="degassing_count">计算</a></dd>
		</dl>
	
		<dl class="custom">
			<dt onClick="changeImage()">取样点优化<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="sample_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/Grabsample.do" id="degassing_count">计算</a></dd>
		</dl>
	
		<dl class="channel">
			<dt>阀门调度<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="dispatch_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/Flushing.do" id="degassing_count">计算</a></dd>
		</dl>
	
		<dl class="app">
			<dt onClick="changeImage()">消毒增压<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="degassing_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/booster_mip.do" id="degassing_count">计算</a></dd>
		</dl>
		<div class="time_display">
			计算时间：
			<br><span id="yy004" >0时0分0秒</span>
		</div>
	</div>
	<div class="web_content">
	<div class="welcome">
		<img src="images/welcome.jpg" alt="welcome_logo">
		<span>供水管网水质预警系统</span>
	</div>
		<div class="polution_edit table_set">
				<form action="<%=path %>/saveInversionYAML.do" method="post" accept-charset="utf-8" >
					<table>
					<caption>污染源定位参数设置</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">反馈</td>
						</tr>
						<tr>
							<td>EPANET管网模型：</td>
							<td><input type="text" value="${sessionScope.epanet }" name="epanet"></input></td>
							<td>模型：</td>
							<td><input type="text" value="${sessionScope.algorithm } " name="algorithm"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">监测数据</td>
							<td>注入类型：</td>
							<td><input type="text" value="${sessionScope.formulation }" name="formulation"></input></td>
						</tr>
						<tr>
							<td >取样数据：</td>
							<td><input type="text" value="${sessionScope.grab_samples}" name="grab_samples"></input></td>
							<td>模型格式：</td>
							<td><input type="text" value="${sessionScope.model_format}" name="model_format"></input></td>
						</tr> 
						<tr>
							<td class="catalogue" colspan="2">求解程序</td>
							<td>时间：</td>
							<td><input type="text" value="${sessionScope.horizon }" name="horizon"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type }" name="type"></input></td>
							<td>注入节点数量：</td>
							<td><input type="text" value="${sessionScope.num_injections }" name="num_injections"></input></td>
						</tr>
						<tr>
							<td>选项：</td>
							<td><input type="text" value="${sessionScope.options }" name="options"></input></td>
							<td>监测失败率：</td>
							<td><input type="text" value="${sessionScope.measurement_failure }" name="measurement_failure"></input></td>
						</tr>
						<tr>
							<td>记录文件：</td>
							<td><input type="text" value="${sessionScope.logfile }" name="logfile"></input></td>
							<td>正阕值：</td>
							<td><input type="text" value="${sessionScope.positive_threshold }" name="positive_threshold"></td>
						</tr>
						<tr>
							<td>冗余：</td>
							<td><input type="text" value="${sessionScope.verbose }" name="verbose"></input></td>
							<td>负阕值：</td>
							<td><input type="text" value="${sessionScope.negative_threshold }" name="negative_threshold"></input></td>
						</tr>
						<tr>
							<td>起始节点：</td>
							<td><input type="text" value="${sessionScope.initial_points }" name="initial_points"></input></td>
							<td>可行节点：</td>
							<td><input type="text" value="${sessionScope.feasible_nodes }" name="feasible_nodes"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">配置</td>
							<td>候选阕值：</td>
							<td><input type="text" value="${sessionScope.candidate_threshold }" name="candidate_threshold"></input></td>
						</tr>
						<tr>
							<td>输出前缀：</td>
							<td><input type="text" value="${sessionScope.output_prefix }" name="output_prefix"></input></td>
							<td>置信度：</td>
							<td><input type="text" value="${sessionScope.confidence }" name="confidence"></input></td>
						</tr>
						<tr>
							<td>调试：</td>
							<td><input type="text" value="${sessionScope.debug }" name="debug"></input></td>
							<td>输出影响节点：</td>
							<td><input type="text" value="${sessionScope.output_impact_nodes }" name="output_impact_nodes"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset"   type="reset"  value="取消"></input>
				</form>
			
		</div>
		
		<div class="sample_edit table_set">
			<form action="<%=path %>/saveGrabSampleYAML.do" method="post" accept-charset="utf-8">
					<table>
					<caption>取样点优化</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">优化取样</td>
						</tr>
						<tr>
							<td>epanet文件</td>
							<td><input type="text" value="${sessionScope.epanet } "  name="epanet"></input></td>
							<td>模型格式：</td>
							<td><input type="text" value="${sessionScope.model_format }" name="model_format"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2" >场景</td>
							<td>取样时间：</td>
							<td><input type="text" value="${sessionScope.sample_time }" name="sample_time"></input></td>
						</tr>
						<tr>
							<td >位置：</td>
							<td><input type="text" value="${sessionScope.location }" name="location"></input></td>
							<td>阈值：</td>
							<td><input type="text" value="${sessionScope.threshold }" name="threshold"></input></td>
						</tr>
						<tr>
							<!-- <td class="catalogue" colspan="2">类型：</td> -->
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_changjing}" name="type_changjing"></input></td>
							<td>传感器节点：</td>
							<td><input type="text" value="${sessionScope.fixed_sensors }" name="fixed_sensors"></input></td>
						</tr>
						<tr>
							<td>强度：</td>
							<td><input type="text" value="${sessionScope.strength }" name="strength"></input></td>
							<td>可行取样节点：</td>
							<td><input type="text" value="${sessionScope.feasible_nodes }" name="feasible_nodes"></input></td>
						</tr>
						<tr>
							<td>种类：</td>
							<td><input type="text" value="${sessionScope.species }" name="species"></input></td>
							<td>取样数：</td>
							<td><input type="text" value="${sessionScope.num_samples }" name="num_samples"></input></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text" value="${sessionScope.start_time }" name="start_time"></input></td>
							<td>选择贪婪式：</td>
							<td><input type="text" value="${sessionScope.greedy_selection }" name="greedy_selection"></input></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="text" value="${sessionScope.end_time }" name="end_time"></input></td>
							<td class="catalogue" colspan="2">求解程序</td>
						</tr>
						<tr>
							<td>TSG文件：</td>
							<td><input type="text" value="${sessionScope.tsg_file }" name="tsg_file"></input></td>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_qiujiechengxu}" name="type_qiujiechengxu"></input></td>
						</tr>
						<tr>
							<td>TSI文件：</td>
							<td><input type="text" value="${sessionScope.tsi_file }" name="tsi_file"></input></td>
							<td>选项：</td>
							<td><input type="text" value="${sessionScope.options }" name="options"></input></td>
						</tr>
						<tr>
							<td>MSX文件：</td>
							<td><input type="text" value="${sessionScope.msx_file }" name="msx_file"></input></td>
							<td>记录文件：</td>
							<td><input type="text" value="${sessionScope.logfile }" name="logfile"></input></td>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text" value="${sessionScope.msx_species }" name="msx_species"></input></td>
							<td>冗余：</td>
							<td><input type="text" value="${sessionScope.verbose }" name="verbose"></input></td>
						</tr>
						<tr>
							<td>merlion：</td>
							<td><input type="text" value="${sessionScope.merlion }" name="merlion"></input></td>
							<td>起始节点：</td>
							<td><input type="text" value="${sessionScope.initial_points }" name="initial_points"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td colspan="2" class="catalogue">配置</td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>输出前缀：</td>
							<td><input type="text" value="${sessionScope.output_prefix }" name="output_prefix"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>调试：</td>
							<td><input type="text" value="${sessionScope.debug }" name="debug"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
		</div>
		<div class="dispatch_edit table_set">
			<form action="<%=path %>/saveFlushingYAML.do" method="get" accept-charset="utf-8">
					<table>
					<caption>阀门调度</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">冲洗</td>
						</tr>
						<tr>
							<td>epanet文件</td>
							<td><input type="text" value="${sessionScope.epanet }" name="epanet"></input></td>
							<td>传感器节点编号：</td>
							<td><input type="text" value="${sessionScope.detection }" name="detection"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">场景</td>
							<td class="catalogue" colspan="2">冲洗节点</td>
						</tr>
						<tr>
							<td >位置：</td>
							<td><input type="text" value="${sessionScope.location }" name="location"></input></td>
							<td>可行节点：</td>
							<td><input type="text" value="${sessionScope.feasible_nodes }" name="feasible_nodes"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_scenario }" name="type_scenario"></input></td>
							<td>不可行节点：</td>
							<td><input type="text" value="${sessionScope.infeasible_nodes }" name="infeasible_nodes"></input></td>
						</tr>
						<tr>
							<td>强度：</td>
							<td><input type="text" value="${sessionScope.strength }" name="strength"></input></td>
							<td>最大节点数：</td>
							<td><input type="text" value="${sessionScope.max_nodes }" name="max_nodes"></input></td>
						</tr>
						<tr>
							<td>种类：</td>
							<td><input type="text" value="${sessionScope.species}" name="species"></input></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text" value="${sessionScope.start_time }" name="start_time"></input></td>
							<td>冲洗速率：</td>
							<td><input type="text" value="${sessionScope.rate }" name="rate"></input></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="text" value="${sessionScope.end_time }" name="end_time"></input></td>
							<td>反应时间：</td>
							<td><input type="text" value="${sessionScope.response_time_flush_nodes }" name="response_time_flush_nodes"></input></td>
						</tr>
						<tr>
							<td>TSG文件：</td>
							<td><input type="text" value="${sessionScope.tsg_file }" name="tsg_file"></input></td>
							<td>持续时间：</td>
							<td><input type="text" value="${sessionScope.duration }" name="duration"></input></td>
						</tr>
						<tr>
							<td>TSI文件：</td>
							<td><input type="text" value="${sessionScope.tsi_file }" name="tsi_file"></input></td>
							<td class="catalogue" colspan="2">阀门关闭</td>
						</tr>
						<tr>
							<td>MSX文件：</td>
							<td><input type="text" value="${sessionScope.msx_file }" name="msx_file"></input></td>
							<td>可行管道：</td>
							<td><input type="text" value="${sessionScope.feasible_pipes }" name="feasible_pipes"></input></td>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text" value="${sessionScope.msx_species_scenario }" name="msx_species_scenario"></input></td>
							<td>不可行管道：</td>
							<td><input type="text" value="${sessionScope.infeasible_pipes }" name="infeasible_pipes"></input></td>
						</tr>
						<tr>
							<td>merlion：</td>
							<td><input type="text" value="${sessionScope.merlion }" name="merlion"></input></td>
							<td>最大管道数：</td>
							<td><input type="text" value="${sessionScope.max_pipes }" name="max_pipes"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">影响</td>
							<td>反应时间：</td>
							<td><input type="text" value="${sessionScope.response_time_close_valves }" name="response_time_close_valves"></input></td>
						</tr>
						<tr>
							<td>erd文件：</td>
							<td><input type="text" value="${sessionScope.erd_file }" name="erd_file"></input></td>
							<td colspan="2" class="catalogue">求解程序</td>
						</tr>
						<tr>
							<td>度量标准：</td>
							<td><input type="text" value="${sessionScope.metric }" name="metric"></input></td>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_solver }" name="type_solver"></input></td>
						</tr>
						<tr>
							<td>tai文件：</td>
							<td><input type="text" value="${sessionScope.tai_file }" name="tai_file"></input></td>
							<td>选项：</td>
							<td><input type="text" value="${sessionScope.options }" name="options"></input></td>
						</tr>
						<tr>
							<td>反应时间：</td>
							<td><input type="text" value="${sessionScope.response_time_impact }" name="response_time_impact"></input></td>
							<td>记录文件：</td>
							<td><input type="text" value="${sessionScope.logfile }" name="logfile"></input></td>
						</tr>
						<tr>
							<td>检测阈值：</td>
							<td><input type="text" value="${sessionScope.detection_limit }" name="detection_limit"></input></td>
							<td>冗余：</td>
							<td><input type="text" value="${sessionScope.verbose }" name="verbose"></input></td>
						</tr>
						<tr>
							<td>检测置信度：</td>
							<td><input type="text" value="${sessionScope.detection_confidence }" name="detection_confidence"></input></td>
							<%-- <td>起始节点：</td>
							<td><input type="text" value="${sessionScope. }"></input></td> --%>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text" value="${sessionScope.msx_species_impact }" name="msx_species_impact"></input></td>
							<td colspan="2" class="catalogue">配置</td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>输出前缀：</td>
							<td><input type="text" value="${sessionScope.output_prefix }" name="output_prefix"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>调试：</td>
							<td><input type="text" value="${sessionScope.debug }" name="debug"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
		</div>
		<div class="degassing_edit table_set">
			<form action="#" method="get" accept-charset="utf-8">
					<table>
					<caption>消毒增压参数设置</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">booster_mip</td>
						</tr>
						<tr>
							<td>epanet文件</td>
							<td><input type="text" value="${sessionScope.epanet }"  name="epanet"></input></td>
							<td>传感器节点编号：</td>
							<td><input type="text" value="${sessionScope.detection_booster_mip}"  name="detection_booster_mip"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">场景</td>
							<td>模型格式：</td>
							<td><input type="text" value="${sessionScope.model_type_booster_mip }" name="model_type_booster_mip"></input></td>
						</tr>
						<tr>
							<td >位置：</td>
							<td><input type="text" value="${sessionScope.location_scenario }" name="location_scenario"></input></td>
							<td>模型类型：</td>
							<td><input type="text" value="${sessionScope.model_type_booster_mip }" name="model_format_booster_mip"></input></td>
						</tr>
						<tr>
							<td ></td>
							<td></td>
							<td>化学计量比率：</td>
							<td><input type="text" value="${sessionScope.stoichiometric_ratio_booster_mip }" name="stoichiometric_ratio_booster_mip"></input></td>
						</tr>
						<tr>
							<td>强度：</td>
							<td><input type="text" value="${sessionScope.strength_scenario }" name="strength_scenario"></input></td>
							<td>目标：</td>
							<td><input type="text" value="${sessionScope.objective_booster_mip }" name="objective_booster_mip"></input></td>
						</tr>
						<tr>
							<td>种类：</td>
							<td><input type="text" value="${sessionScope.type_scenario }" name="type_scenario"></input></td>
							<td>污染物衰减系数：</td>
							<td><input type="text" value="${sessionScope.toxin_decay_coefficient_booster_mip }" name="toxin_decay_coefficient_booster_mip"></input></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text" value="${sessionScope.start_time_scenario }" name="start_time_scenario"></input></td>
							<td>消毒剂衰减系数：</td>
							<td><input type="text" value="${sessionScope.decon_decay_coefficient_booster_mip }" name="decon_decay_coefficient_booster_mip"></input></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="text" value="${sessionScope.end_time_scenario }" name="end_time_scenario"></input></td>
							<td>可行节点：</td>
							<td><input type="text" value="${sessionScope.feasible_nodes_booster_mip }" name="feasible_nodes_booster_mip"></input></td>
						</tr>
						<tr>
							<td>tsg文件：</td>
							<td><input type="text" value="${sessionScope.tsg_file_scenario }" name="tsg_file_scenario"></input></td>
							<td>不可行节点：</td>
							<td><input type="text" value="${sessionScope.infeasible_nodes_booster_mip }" name="infeasible_nodes_booster_mip"></input></td>
						</tr>
						<tr>
							<td>tsi文件：</td>
							<td><input type="text" value="${sessionScope.tsi_file_scenario }" name="tsi_file_scenario"></input></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>msx文件：</td>
							<td><input type="text" value="${sessionScope.msx_file_scenario }" name="msx_file_scenario"></input></td>
							<td>固定节点：</td>
							<td><input type="text" value="${sessionScope.fixed_nodes_booster_mip }" name="fixed_nodes_booster_mip"></input></td>
						</tr>
						<tr>
							<td>msx种类：</td>
							<td><input type="text" value="${sessionScope.msx_species_scenario }" name="msx_species_scenario"></input></td>
							<td>增压磊站最大数：</td>
							<td><input type="text" value="${sessionScope.max_boosters_booster_mip }" name="max_boosters_booster_mip"></input></td>
						</tr>
						<tr>
							<td>merlion：</td>
							<td><input type="text" value="${sessionScope.merlion_scenario }" name="merlion_scenario"></input></td>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_booster_mip_booster_mip }" name="type_booster_mip_booster_mip"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">求解程序</td>
							<td>强度：</td>
							<td><input type="text" value="${sessionScope.strength_booster_mip }" name="strength_booster_mip"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type_solver }" name="type_solver"></input></td>
							<td>反应时间：</td>
							<td><input type="text" value="${sessionScope.response_time_booster_mip }" name="response_time_booster_mip"></input></td>
						</tr>
						<tr>
							<td>选项：</td>
							<td><input type="text" value="${sessionScope.options_solver }" name="options_solver"></input></td>
							<td>持续时间：</td>
							<td><input type="text" value="${sessionScope.duration_booster_mip }" name="duration_booster_mip"></input></td>
						</tr>
						<tr>
							<td>记录文件：</td>
							<td><input type="text" value="${sessionScope.logfile_solver }" name="logfile_solver"></input></td>
							<td>评估：</td>
							<td><input type="text" value="${sessionScope.evaluate_booster_mip }" name="evaluate_booster_mip"></input></td>
						</tr>
						<tr>
							<td>冗余：</td>
							<td><input type="text" value="${sessionScope.verbose_solver }" name="verbose_solver"></input></td>
							<td colspan="2" class="catalogue">配置</td>
						</tr>
						<tr>
							<td>输出前缀：</td>
							<td><input type="text" value="${sessionScope.output_prefix_configure }" name="output_prefix_configure"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>调试：</td>
							<td><input type="text" value="${sessionScope.debug_configure }" name="debug_configure"></input></td>
						</tr>
					
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
		</div>
	</div>
</div>



<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript">
//这是计时的程序

	var sec =0;
	var minu=0;
	var hou=0;

$('#degassing_count').click(function(){
//每隔一秒刷新一次
window.setTimeout("uupdate()",1000);
});

function uupdate()
{
    sec++;    
    if(sec==60)
    {
        sec =0;
        minu +=1;
    }
    if(minu==60)
    {
        minu=0;
        hou+=1;
    }
    var ss04 =hou+ "时"+minu+"分"+sec+"秒";
    document.getElementById('yy004').innerHTML=ss04;
    window.setTimeout("uupdate()",1000);
}

</script>









<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#e0edff"});
$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
$(function(){
	
	var basePath = "http://localhost:8080/WST";
	
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#e0edff"})
		$(this).css({"background-color": "#e0ebfd"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
	

	
	$("#polution_edit_a").click(function(){
		 $.ajax({ 
            url:  "http://localhost:8080/WST/readInversionYaml.do", 
            type:'post', 
            success: function(data){ 
            	alert("success");
            	
            },
            error: function(data){
            	alert("failture");
            }
        }); 
		//alert("niubi");
	 	$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'block'}); 
		
		//alert("你好");
		
	}); 
	$("#sample_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.sample_edit').css({'display':'block'});
	});
	$("#dispatch_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'block'});
	});
	$("#degassing_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'block'});
	});
	
	
	//取样点优化点击编辑
	$("#sample_edit_a").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.sample_edit').css({'display':'block'}); 
		
		 $.ajax({ 
           url:  "http://localhost:8080/WST/readGrabsampleYaml.do", 
           type:'post', 
           success: function(data){ 
           	alert("success");
           	
           },
           error: function(data){
           	alert("取样点优化");
           }
       }); 
	});
	
	
	//阀门调度编辑
	$("#dispatch_edit_a").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'block'});
		
		 $.ajax({ 
           url:  "http://localhost:8080/WST/readFlushingYaml.do", 
           type:'post', 
           success: function(data){ 
           	alert("success");
           	
           },
           error: function(data){
           	alert("阀门调度");
           }
       }); 
	});
	
	
 	//消毒增压编辑
	$("#degassing_edit_a").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'block'});
		
		 $.ajax({ 
           url:  "http://localhost:8080/WST/readBoosterYaml.do", 
           type:'post', 
           success: function(data){ 
           	alert("success");
           	
           },
           error: function(data){
           	alert("消毒增压");
           }
       }); 
	});
	
	
	
});
</script>

</body>
</html>
