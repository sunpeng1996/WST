<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="form1.css">
</head>
<body>
	<div class="container">
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
					<td>正阈值：</td>
					<td><input type="text"></input></td>
				</tr>
				<tr>
					<td>冗余：</td>
					<td><input type="text"></input></td>
					<td>负阈值：</td>
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
</body>
</html>