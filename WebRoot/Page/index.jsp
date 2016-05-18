<!DOCTYPE html >
<html >
<head>
<link rel="Shortcut Icon" href="../images/bg.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水资源调查</title>
<link rel="stylesheet" type="text/css" href="../Css/index.css">
<link rel="stylesheet" type="text/css" href="../Css/table_set.css">
</head>

<body id="bg">
<div class="web_title">
	<img src="../images/bg.png" alt="logo">
	<span>哈尔滨工业大学市政学院</span>
</div>
<div class="container">

	<div class="leftsidebar_box">
		<dl class="system_log">
			<dt onClick="changeImage()">污染源定位<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="polution_edit_a">编辑</a></dd>
			<dd><a href="#" id="polution_count">计算</a></dd>
		</dl>
	
		<dl class="custom">
			<dt onClick="changeImage()">取样点优化<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="sample_edit_a">编辑</a></dd>
			<dd><a href="#" id="sample_count">计算</a></dd>
		</dl>
	
		<dl class="channel">
			<dt>阀门调度<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="dispatch_edit_a">编辑</a></dd>
			<dd><a href="##" id="dispatch_count">计算</a></dd>
		</dl>
	
		<dl class="app">
			<dt onClick="changeImage()">消毒增压<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="##" id="degassing_edit_a">编辑</a></dd>
			<dd><a href="##" id="degassing_count">计算</a></dd>
		</dl>
	</div>
	<div class="web_content">
		<div class="polution_edit table_set">
				<form action="#" method="get" accept-charset="utf-8">
					<table>
					<caption>污染源定位参数设置</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">反馈</td>
						</tr>
						<tr>
							<td>EPANET管网模型：</td>
							<td><input type="text"></input></td>
							<td>模型：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">监测数据</td>
							<td>注入类型：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td >取样数据：</td>
							<td><input type="text"></input></td>
							<td>模型格式：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">求解程序</td>
							<td>时间：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text"></input></td>
							<td>注入节点数量：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>选项：</td>
							<td><input type="text"></input></td>
							<td>监测失败率：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>记录文件：</td>
							<td><input type="text"></input></td>
							<td>正阕值：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>冗余：</td>
							<td><input type="text"></input></td>
							<td>负阕值：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>起始节点：</td>
							<td><input type="text"></input></td>
							<td>可行节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">配置</td>
							<td>候选阕值：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>输入前缀：</td>
							<td><input type="text"></input></td>
							<td>置信度：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>调试：</td>
							<td><input type="text"></input></td>
							<td>输出影响节点：</td>
							<td><input type="text"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
			
		</div>
		
		<div class="sample_edit table_set">
			<form action="#" method="get" accept-charset="utf-8">
					<table>
					<caption>取样点优化</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">优化取样</td>
						</tr>
						<tr>
							<td>epanet文件</td>
							<td><input type="text"></input></td>
							<td>模型格式：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">场景</td>
							<td>取样时间：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td >位置：</td>
							<td><input type="text"></input></td>
							<td>阈值：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">类型：</td>
							<td>传感器节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>强度：</td>
							<td><input type="text"></input></td>
							<td>可行取样节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>种类：</td>
							<td><input type="text"></input></td>
							<td>取样数：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text"></input></td>
							<td>选择贪婪式：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="text"></input></td>
							<td class="catalogue" colspan="2">求解程序</td>
						</tr>
						<tr>
							<td>TSG文件：</td>
							<td><input type="text"></input></td>
							<td>类型：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>TSI文件：</td>
							<td><input type="text"></input></td>
							<td>选项：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>MSX文件：</td>
							<td><input type="text"></input></td>
							<td>记录文件：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text"></input></td>
							<td>冗余：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>merlion：</td>
							<td><input type="text"></input></td>
							<td>起始节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td colspan="2" class="catalogue">配置</td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>输出前缀：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>调试：</td>
							<td><input type="text"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
		</div>
		<div class="dispatch_edit table_set">
			<form action="#" method="get" accept-charset="utf-8">
					<table>
					<caption>阀门调度</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">冲洗</td>
						</tr>
						<tr>
							<td>epanet文件</td>
							<td><input type="text"></input></td>
							<td>传感器节点编号：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">场景</td>
							<td class="catalogue" colspan="2">冲洗节点</td>
						</tr>
						<tr>
							<td >位置：</td>
							<td><input type="text"></input></td>
							<td>可行节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text"></input></td>
							<td>不可行节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>强度：</td>
							<td><input type="text"></input></td>
							<td>最大节点数：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text"></input></td>
							<td>冲洗速率：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="text"></input></td>
							<td>反应时间：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>TSG文件：</td>
							<td><input type="text"></input></td>
							<td>持续时间：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>TSI文件：</td>
							<td><input type="text"></input></td>
							<td class="catalogue" colspan="2">阀门关闭</td>
						</tr>
						<tr>
							<td>MSX文件：</td>
							<td><input type="text"></input></td>
							<td>可行管道：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text"></input></td>
							<td>不可行管道：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>merlion：</td>
							<td><input type="text"></input></td>
							<td>最大管道数：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">影响</td>
							<td>反应时间：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>erd文件：</td>
							<td><input type="text"></input></td>
							<td colspan="2" class="catalogue">求解程序</td>
						</tr>
						<tr>
							<td>度量标准：</td>
							<td><input type="text"></input></td>
							<td>类型：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>tai文件：</td>
							<td><input type="text"></input></td>
							<td>选项：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>反应时间：</td>
							<td><input type="text"></input></td>
							<td>记录文件：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>检测阈值：</td>
							<td><input type="text"></input></td>
							<td>冗余：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>检测置信度：</td>
							<td><input type="text"></input></td>
							<td>起始节点：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td>MSX种类：</td>
							<td><input type="text"></input></td>
							<td colspan="2" class="catalogue">配置</td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>输出前缀：</td>
							<td><input type="text"></input></td>
						</tr>
						<tr>
							<td colspan="2" class="catalogue"></td>
							<td>调试：</td>
							<td><input type="text"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset" type="reset" value="取消"></input>
				</form>
		</div>
		<div class="degassing_edit">
			44444444444
		</div>
	</div>
</div>



<script type="text/javascript" src="../Js/jquery.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#e0edff"});
$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#e0edff"})
		$(this).css({"background-color": "#e0ebfd"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","../images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
	$("#polution_edit_a").click(function(){
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'block'});
	});
	$("#sample_edit_a").click(function(){
		$('.polution_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.sample_edit').css({'display':'block'});
	});
	$("#dispatch_edit_a").click(function(){
		$('.sample_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'block'});
	});
	$("#degassing_edit_a").click(function(){
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'block'});
	});
})
</script>

</body>
</html>
