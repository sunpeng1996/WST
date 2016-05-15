<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>form</title>
	<meta charset=utf-8>
	<meta name=description content="">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../Css/form1.css">
</head>
<body>
	<div class="container">
	<form action="<%=path%>/saveYML1.do" method="post" >
		<table>
			<caption>污染源定位参数设置</caption>
			<tbody>
				<tr>
					<td  class="catalogue" colspan="2">管网模型</td>
					<td class="catalogue" colspan="2">反演</td>
				</tr>
				<tr>
					<td>EPANET管网模型：</td>
					<td><input type="text" value="${sessionScope.epanet }"></input></td>
					<td>模型：</td>
					<td><input type="text" value="${sessionScope.algorithm}"></input></td>
				</tr>
				<tr>
					<td class="catalogue" colspan="2">监测数据</td>
					<td>注入类型：</td>
					<td><input type="text" value="${sessionScope.formulation}"></input></td>
				</tr>
				<tr>
					<td >取样数据：</td>
					<td><input type="text" value="${sessionScope.samples}"></input></td>
					<td>模型格式：</td>
					<td><input type="text" value="${sessionScope.format}"></input></td>
				</tr>
				<tr>
					<td class="catalogue" colspan="2">求解程序</td>
					<td>时间：</td>
					<td><input type="text" value="${sessionScope.horizon}"></input></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input type="text" value="${sessionScope.type}"></input></td>
					<td>注入节点数量：</td>
					<td><input type="text" value="${sessionScope.injections}"></input></td>
				</tr>
				<tr>
					<td>选项：</td>
					<td><input type="text" value="${sessionScope.options}"></input></td>
					<td>监测失败率：</td>
					<td><input type="text" value="${sessionScope.failure}"></input></td>
				</tr>
				<tr>
					<td>记录文件：</td>
					<td><input type="text" value="${sessionScope.logfile}"></input></td>
					<td>正阕值：</td>
					<td><input type="text" value="${sessionScope.positive}"></input></td>
				</tr>
				<tr>
					<td>冗余：</td>
					<td><input type="text" value="${sessionScope.verbose}"></input></td>
					<td>负阕值：</td>
					<td><input type="text" value="${sessionScope.negative}"></input></td>
				</tr>
				<tr>
					<td>起始节点：</td>
					<td><input type="text" value="${sessionScope.initialpoints}"></input></td>
					<td>可行节点：</td>
					<td><input type="text" value="${sessionScope.nodes}"></input></td>
				</tr>
				<tr>
					<td class="catalogue" colspan="2">配置</td>
					<td>候选阕值：</td>
					<td><input type="text" value="${sessionScope.candidate}"></input></td>
				</tr>
				<tr>
					<td>输入前缀：</td>
					<td><input type="text" value="${sessionScope.outputPrefix}"></input></td>
					<td>置信度：</td>
					<td><input type="text" value="${sessionScope.confidence}"></input></td>
				</tr>
				<tr>
					<td>调试：</td>
					<td><input type="text" value="${sessionScope.debug}"></input></td>
					<td>输出影响节点：</td>
					<td><input type="text" value="${sessionScope.outputImpact}"></input></td>
				</tr>
			</tbody>
		</table>
		<input id="submit" type="submit" value="提交"></input>
		<input id="reset" type="reset" value="取消"></input>
	</form>
		
	</div>
</body>
</html>