
<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	<link rel="Shortcut Icon" href="Image/bg.png">
		<meta charset='utf-8'/>
		<title>水资源调查</title>
		<link rel="stylesheet" type="text/css" href="Css/index.css">
	</head>
	<body>
		<div class='ribbon'>
			<a href="javascript:;" onclick="openWin()"><span>污染源定位</span></a>
			<a href="#"><span>取样点优化</span></a>
			<a href='#'><span>阀门调度</span></a>
			<a href='#'><span>消毒增压</span></a>
		</div>
		<div class="introduce">
			哈尔滨工业大学市政学院
		</div>
		<div style="text-align:center;clear:both">
			<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
			<script src="/follow.js" type="text/javascript"></script>
		</div>
		<script>
		<!--
			function openWin(){
				var bool=window.showModalDialog('Page/prompt1.jsp','','status:0;help:0;edge:raised;dialogLeft:500px;dialogTop:200px;dialogWidth:400;dialogHeight:250;scroll:no');
				if(bool){
					window.open('Page/form1.jsp','','width='+(window.screen.availWidth-10)+',height='+(window.screen.availHeight-30)+ ',status=yes,left=0,top=0,')
				}
				//计算按钮  返回false
				else{

				}
			}
			-->
		</script>
	</body>
</html>



<!-- href="javascript:;" onClick="javascript:window.open('prompt.html','','width=400,height=250,left=500, top=200,toolbar=no, status=no, menubar=no, resizable=no, scrollbars=no,location=no');return false;" -->
