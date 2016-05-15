<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset=utf-8>
	<meta name=description content="">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../Css/prompt.css">
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
	<div class="title">
		污染源定位
	</div>
	<div class="btn">
		<button  type="submit"  formaction="<%=path%>/readYML1.do" >编辑</button>
		<button onclick='return a1()'>计算</button>
	</div>
	<script type='text/javascript'>
		 function a(){
			parent.window.returnValue=true;
			window.close();
		} 
		function a1(){
			parent.window.returnValue=false;
			window.close();
		}
	</script>
</body>
</html>