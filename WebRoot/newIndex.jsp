<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0070)http://haerbin.imwork.net:9090/llb_ewater_heb/userController/checkUser -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml" class="panel-fit"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<base href="http://haerbin.imwork.net:9090/llb_ewater_heb/">--><base href=".">
<title>哈尔滨供水管网水质预警系统</title>


<link rel="Shortcut Icon" href="http://haerbin.imwork.net:9090/llb_ewater_heb/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="newJs/easyui.css">
<link rel="stylesheet" type="text/css" href="newJs/icon.css">
<link rel="stylesheet" type="text/css" href="newJs/easyuinew.css">
<script type="text/javascript" src="newJs/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="newJs/jquery.easyui.min.js"></script>
<script type="text/javascript" src="newJs/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="newJs/jquery.validate.js"></script>
<script type="text/javascript" src="newJs/jquery.validate.ext.js"></script>
<script type="text/javascript" src="newJs/echarts.js"></script>
<script type="text/javascript" src="newJs/common.js"></script>
<style>
	.menuClass a{padding-top:2px;line-height:24px; display:inline-block; color:#666; text-decoration:none; padding-left:20px;}
	.menuClass a:hover{border:1px solid #99BBE8; background:#E0ECFF;cursor:pointer;}
	.menuClass a:hover a{color:#416AA3;}
	.menuClass a.selected{border:1px solid #99BBE8; background:#E0ECFF;cursor:default;}
	.menuClass a.selected a{color:#416AA3; font-weight:bold;}
	.head a{margin:0 5px; color:#fff;}
	li {list-style-type:none;}
</style>
<script type="text/javascript">

	/**
	 * 进入页面初始化加载
	 */
	$(function(){
		
		InitLeftMenu();//初始化 左侧树手风琴
		tabClose();//初始化 双击关闭TAB选项卡
		tabCloseEven();//初始化 绑定右键菜单事件
		$("#menu").accordion('getSelected').panel('collapse');//初始化 折叠手风琴
	
		/*//动画效果关闭
		$('#menu').accordion({    
		    animate: true    
		});
		*/
	})

	//点击菜单 出tab选项卡
	function InitLeftMenu() {
		$('.easyui-accordion li a').click(function(){
			var tabTitle = $(this).text();
			var url = $(this).attr("ghref");
			addTab(tabTitle,url);
			$('.easyui-accordion li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	
	}
	
	/**
	 * 选项卡
	 */
	function addTab(subtitle,url){
		if(!$('#tabs').tabs('exists',subtitle)){
			$('#tabs').tabs('add',{
				title:subtitle,
				content:createFrame(url),
				closable:true,
				width:$('#mainPanle').width()-10,
				height:$('#mainPanle').height()-26
			});
		}else{
			$('#tabs').tabs('select',subtitle);
		}
		tabClose();
	}

	function createFrame(url){
		var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		return s;
	}

	/**
	 *  双击关闭TAB选项卡
	 */
	function tabClose(){
	
		$(".tabs-inner").dblclick(function(){
			var subtitle = $(this).children("span").text();
			if(subtitle != "首页"){
				$('#tabs').tabs('close',subtitle);
			}
		})
	
		$(".tabs-inner").bind('contextmenu',function(e){
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY,
			});
			
			var subtitle =$(this).children("span").text();
			$('#mm').data("currtab",subtitle);
			
			return false;
		});
	}

	/**
	 * 绑定右键菜单事件
	 */
	function tabCloseEven(){
		//关闭当前
		$('#mm-tabclose').click(function(){
			var currtab_title = $('#mm').data("currtab");
			if(currtab_title != "首页"){
				$('#tabs').tabs('close',currtab_title);
			}
		})
		//全部关闭
		$('#mm-tabcloseall').click(function(){
			$('.tabs-inner span').each(function(i,n){
				var t = $(n).text();
				if(t != "首页"){
					$('#tabs').tabs('close',t);
				}
			});
		});
		




</script>
</head>
<body class="easyui-layout layout panel-noscroll" style="overflow-y: hidden" scroll="no">
    <div class="panel layout-panel layout-panel-north layout-split-north" style="width: 1589px; left: 0px; top: 0px;"><div region="north" split="true" border="false" style="overflow: hidden; background-color: rgb(127, 153, 190); line-height: 50px; color: rgb(255, 255, 255); font-family: Verdana, 微软雅黑, 黑体; width: 1589px; height: 55.55555534362793px; background-position: 50% 50%; background-repeat: repeat no-repeat;" title="" class="panel-body panel-body-noheader panel-body-noborder layout-body">
        <span style="padding-left:15px; font-size: 22px; "><img src="newJs/master_logo.png" align="absmiddle"></span>
    </div></div>
    <div class="panel layout-panel layout-panel-south layout-split-south" style="width: 1589px; left: 0px; top: 734px;"><div region="south" split="true" style="background-color: rgb(210, 224, 242); width: 1586.777777671814px; height: 33.333333015441895px; background-position: initial initial; background-repeat: initial initial;" title="" class="panel-body panel-body-noheader layout-body">
        <div class="footer">
        <div style="width: 100%; text-align: center; font-size: 14px; padding-top: 7px;">
		<span>©Copyright 2016 哈尔滨工业大学</span>
		<!-- <span style="margin-left: 30px;">技术支持：莱力柏软件部</span> -->
	</div></div>
    </div></div>
<!-- 左侧手风琴 begin -->
	<div class="panel layout-panel layout-panel-west layout-split-west" style="width: 195.55555534362793px; left: 0px; top: 60px;"><div class="panel-header" style="width: 183.3333330154419px;"><div class="panel-title panel-with-icon">&nbsp;菜单导航栏</div><div class="panel-icon icon-icmonitor"></div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-collapse" style="display: none;"></a><a href="javascript:void(0)" class="layout-button-left"></a></div></div><div data-options="region: &#39;west&#39;, title: &#39; 菜单导航栏&#39;, iconCls: &#39;icon-icmonitor&#39;, split: true, minWidth: 200, maxWidth: 400" style="width: 193.3333330154419px; height: 644.888888835907px;" id="west" title="" class="panel-body layout-body panel-noscroll">
	    <div id="menu" class="easyui-accordion accordion easyui-fluid" data-options="fit:true," style="width: 190.77777767181396px; height: 642.777777671814px;">
    		<!-- 普通用户看到的模块 -->
    		
    		<div class="panel" style="width: 190px;"><div class="panel-header panel-header-noborder accordion-header accordion-header-selected" style="height: 15.888888835906982px; width: 180px;"><div class="panel-title panel-with-icon">污染源定位</div><div class="panel-icon icon-cpservice"></div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-collapse" style="display: none;"></a><a href="javascript:void(0)" class="accordion-collapse"></a></div></div><div style="padding-top: 5px; display: block; width: 190px; height: 529.888888835907px;" title="" data-options="border:false, iconCls: &#39;icon-cpservice&#39;" class="menuClass panel-body panel-body-noborder accordion-body">
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">刷新</a>
				</li>
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">编辑</a>
				</li>
	            <li style="width:100%;" class="">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtuData">计算</a>
				</li>
    		</div></div>
    		<div class="panel" style="width: 190px;"><div class="panel-header panel-header-noborder accordion-header" style="height: 15.888888835906982px; width: 180px;"><div class="panel-title panel-with-icon">取样点优化</div><div class="panel-icon icon-cpservice"></div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-collapse panel-tool-expand" style="display: none;"></a><a href="javascript:void(0)" class="accordion-collapse accordion-expand"></a></div></div><div style="padding-top: 5px; display: none; width: 190px; height: 529.888888835907px;" title="" data-options="border:false, iconCls: &#39;icon-cpservice&#39;" class="menuClass panel-body panel-body-noborder accordion-body">
			<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">刷新</a>
				</li>
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">编辑</a>
				</li>
	            <li style="width:100%;" class="">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtuData">计算</a>
				</li>
    		</div></div>
    		<div class="panel" style="width: 190px;"><div class="panel-header panel-header-noborder accordion-header" style="height: 15.888888835906982px; width: 180px;"><div class="panel-title panel-with-icon">阀门调度</div><div class="panel-icon icon-cpservice"></div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-collapse panel-tool-expand" style="display: none;"></a><a href="javascript:void(0)" class="accordion-collapse accordion-expand"></a></div></div><div style="padding-top: 5px; display: none; width: 190px; height: 528.888888835907px;" title="" data-options="border:false, iconCls: &#39;icon-cpservice&#39;" class="menuClass panel-body panel-body-noborder accordion-body">
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">刷新</a>
				</li>
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">编辑</a>
				</li>
	            <li style="width:100%;" class="">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtuData">计算</a>
				</li>
    		</div></div>
    		<div class="panel" style="width: 190px;"><div class="panel-header panel-header-noborder accordion-header" style="height: 15.888888835906982px; width: 180px;"><div class="panel-title panel-with-icon">消毒增压</div><div class="panel-icon icon-cpservice"></div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-collapse panel-tool-expand" style="display: none;"></a><a href="javascript:void(0)" class="accordion-collapse accordion-expand"></a></div></div><div style="padding-top: 5px; display: none; width: 190px; height: 529.888888835907px;" title="" data-options="border:false, iconCls: &#39;icon-cpservice&#39;" class="menuClass panel-body panel-body-noborder accordion-body">
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">刷新</a>
				</li>
				<li style="width:100%;" class="selected">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtu">编辑</a>
				</li>
	            <li style="width:100%;" class="">
					<a target="mainFrame" style="width:85%;" ghref="treeController/toRtuData">计算</a>
				</li>
    		</div></div>
    		
    		
	    </div>
	</div></div>
<!-- 左侧手风琴 end -->

	<!-- tab选项 begin -->
    <div class="panel layout-panel layout-panel-center" style="width: 1389px; left: 200px; top: 60px;"><div id="mainPanle" region="center" style="background-color: rgb(238, 238, 238); overflow-y: hidden; width: 1386.777777671814px; height: 671.777777671814px; background-position: initial initial; background-repeat: initial initial;" title="" class="panel-body panel-body-noheader layout-body panel-noscroll">
        <div id="tabs" class="easyui-tabs tabs-container easyui-fluid" fit="true" border="false" style="width: 1386px; height: 671px;">
			
		<div class="tabs-header tabs-header-noborder" style="width: 1386px;"><div class="tabs-scroller-left" style="display: none;"></div><div class="tabs-scroller-right" style="display: none;"></div><div class="tabs-wrap" style="margin-left: 0px; margin-right: 0px; width: 1386px;"><ul class="tabs" style="height: 26px;"><li class="tabs-first"><a href="javascript:void(0)" class="tabs-inner" style="height: 24.777777671813965px; line-height: 24.777777671813965px;"><span class="tabs-title">首页</span><span class="tabs-icon"></span></a></li><li class="tabs-last tabs-selected"><a href="javascript:void(0)" class="tabs-inner" style="height: 24.777777671813965px; line-height: 24.777777671813965px;"><span class="tabs-title tabs-closable">设备管理</span><span class="tabs-icon"></span></a><a href="javascript:void(0)" class="tabs-close"></a></li></ul></div></div><div class="tabs-panels tabs-panels-noborder" style="height: 635px; width: 1386px;"><div class="panel" style="display: none; width: 1386px;"><div title="" style="padding: 20px; overflow: hidden; background-image: url(http://haerbin.imwork.net:9090/llb_ewater_heb/images/welcome.png); width: 1346px; height: 594px; background-repeat: no-repeat no-repeat;" id="home" class="panel-body panel-body-noheader panel-body-noborder">
			</div></div><div class="panel" style="display: block; width: 1386px;"><div title="" class="panel-body panel-body-noheader panel-body-noborder" style="width: 1386px; height: 634px;"><iframe name="mainFrame" scrolling="auto" frameborder="0" src="newJs/toRtu.htm" style="width:100%;height:100%;"></iframe></div></div></div></div>
    </div></div>
   	<!-- tab选项 end -->
   
    <!--修改密码窗口 begin -->
	
	 
	<!--修改密码窗口 end -->
	
    <!-- tab右键展开 begin -->
	
	<!-- tab右键展开 end -->

<div id="mm" class="easyui-menu menu-top menu" style="width: 143.77777767181396px; height: 147.77777767181396px; overflow: hidden; display: none; left: 0px; top: 0px;"><div class="menu-line" style="height: 152px;"></div>
		<div id="mm-tabclose" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">关闭</div></div>
		<div id="mm-tabcloseall" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">全部关闭</div></div>
		<div id="mm-tabcloseother" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">除此之外全部关闭</div></div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">当前页右侧全部关闭</div></div>
		<div id="mm-tabcloseleft" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">当前页左侧全部关闭</div></div>
		<div class="menu-sep"></div>
		<div id="mm-exit" class="menu-item" style="height: 19.777777671813965px;"><div class="menu-text" style="height: 20px; line-height: 20px;">退出</div></div>
	</div><div class="layout-split-proxy-h"></div><div class="layout-split-proxy-v"></div><div class="panel window" style="display: none; width: 337.77777767181396px; left: 619px; top: 322px;"><div class="panel-header panel-header-noborder window-header" style="width: 337.77777767181396px;"><div class="panel-title">New Dialog</div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-close"></a></div></div><div id="upPwd" class="easyui-dialog panel-body panel-body-noborder window-body" style="padding: 10px 20px; width: 295.55555534362793px; height: 36.88888883590698px;" closed="true" modal="true" buttons="#upPwd-buttons" title=""> 
       <form id="upPwdForm" method="post"> 
       <div class="fitem"> 
           <label>新密码 </label> 
        	<input missingmessage="新密码必须填写" name="pwd" class="easyui-validatebox validatebox-text validatebox-invalid" required="true"> 
       </div>
       </form> 
   </div><div id="upPwd-buttons" class="dialog-button" style="position: relative; top: -1px; width: 325.77777767181396px;"> 
        <a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="saveNewPwd()" iconcls="icon-save" group="" id=""><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">保存</span><span class="l-btn-icon icon-save">&nbsp;</span></span></a> 
        <a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="javascript:$(&#39;#upPwd&#39;).dialog(&#39;close&#39;)" iconcls="icon-cancel" group="" id=""><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">取消</span><span class="l-btn-icon icon-cancel">&nbsp;</span></span></a> 
    </div></div><div class="window-shadow" style="display: none; left: 619px; top: 322px; width: 350px; height: 131px;"></div><div class="window-mask" style="display:none"></div></body></html>