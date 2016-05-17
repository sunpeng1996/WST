<!DOCTYPE html>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"  src="js/jquery-1.10.2.js"></script>
  </head>

  <body>
	<h1>测试jsp</h1>
	<button id="links"  onclick="a()" ></button>
	图像dadada
	<div>
		<h2>孙鹏</h2>
	</div>
	<%
	  FileReader fr = new FileReader("G:\\wst-1.2\\bin\\grabsample_ex1\\Net3visualization_output.html"); //建立FileReader对象,并设定由fr对象变量引用
	  BufferedReader br = new BufferedReader(fr); //建立BufferedReader对象,并设定由br对象变量引  
	  String Line = br.readLine(); //读取一行数据
	  /* br.println(Line + "<BR>"); //输出读取得的数据 */
	  StringBuffer sb = new StringBuffer();
	  sb.append(Line);
	  br.close(); //关闭BufferedReader对象
	  fr.close(); //关闭文件
      //String sss = "aaaaa路上看见的法律上看的飞机";
	%>
	<div>
		
	<%= sb%>
		
	</div>	
  </body>
</html>
