/**
 * 设备管理
 * llc new 2016.03.07
 */

	var url="";// 添加 修改 传入不同的url地址
	var selectIndex = -1; //单选，取消单选 全局变量
	
	$(document).ready(function() {
		
		$('#rtuDataId').combobox({
			url: "rtuDataController/getRtuData",
			editable:false ,//禁用combobox里面的输入框
			panelHeight : 200,
			valueField:'rtuDataId',
			textField:'rtuDataId'
		});
	//添加
	$("#addBtn").linkbutton({iconCls: 'icon-add', plain: true, disabled: false}).click(function(){
		$("#dlg").dialog("open").dialog('setTitle', '添加采集设备');
        $("#fm").form("clear");
        url = 'rtuController/insertRtu';
	});

	//修改
	$("#updateBtn").linkbutton({iconCls: 'icon-edit', plain: true, disabled: false}).click(function(){
		updateRtu();
	});
	
	//删除
	$("#removeBtn").linkbutton({iconCls: 'icon-remove', plain: true, disabled: false}).click(function(){
		deleteRtu();
	});
	
	//查询
	$("#submit_search").click(function () {
		$('#rtuList').datagrid('load',{
			rtuId: $('#rtuId').val(),
			name: $('#name').val(),
			productor: $('#productor').val(),
			address: $('#address').val()
		});
		
	});

	// 获取高度
//	var height = $(window).height() - $("#search").height()-28;
//	if(height < 250){
//		height = 250;
//	}
//	var width = $(window).width()-15;
	
	// 表格定义部分
	$("#rtuList").datagrid({
		loadMsg: "正在努力为您加载数据",
//		width: width,
//		height: height,
		nowrap : false, // True 就会把数据显示在一行里
		rownumbers : true, // True 就会显示行号的列
		singleSelect : true, // True 就会只允许选中一行。
		url : "rtuController/selectRtu",	 
		method : "post",
		pageSize : 20,
		striped : true,									 
		pagination : true,							 
		fit : true,
		fitColumns : true,								 
		idField:'rtuId',
		columns:[[
	          	{field:'ck',checkbox:true},
				{field:'rtuId',title:'采集设备ID',width:60,align:'center'},
				{field:'name',title:'采集设备名称',width:110,align:'center'},
				{field:'phoneNumber',title:'SIM卡号',width:80,align:'center'},
				{field:'productor',title:'生产厂家',width:80,align:'center'},
				{field:'address',title:'设备安装地址',width:200,align:'center'},
				{field:'longitude',title:'经度',width:60,align:'center'},
				{field:'latitude',title:'纬度',width:60,align:'center'},
				{field:'rtuDataId',title:'采集设备数据ID',width:60,align:'center'}
	    ]],
	    onClickRow: function(index, data) {
	    	if (index == selectIndex) {
	    		//第一次单击选中,第二次单击取消选中
	    		$(this).datagrid('unselectRow', index);
	    		selectIndex = -1;
	    	}else{
	    		selectIndex = index;
	    	}
	    },
		toolbar : "#toolbars"
	});

	var pager = $("#rtuList").datagrid("getPager");
	pager.pagination({
		showPageList : false,
		pageSize : 20, //设置本页显示总条目数
		pageNumber : 1, //显示的页码
		beforePageText : '第', //页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});


});
		

	/**
	 * 添加，修改的保存事件
	 */
	function saveRtu() {
	    $("#fm").form("submit", {
	        url: url,
	        dataType : 'post',
			onSubmit:function(){
				
			},
	        success: function (data) {
	        	var obj = JSON.parse(data); 
	            if (obj[0].isSuccess > 0) {
	                $.messager.alert("提示信息", "操作成功");
	                $("#dlg").dialog("close");
	                $("#rtuList").datagrid("load");
	                $('#rtuList').datagrid('clearSelections');//删除成功 清空check勾选行
	            }
	            else {
	                $.messager.alert("提示信息", "操作失败");
	            }
	        }
	    });
	}


	/***
	 * 修改采集设备
	 */
	function updateRtu() {
	
	    var row = $("#rtuList").datagrid("getSelected");
	    if (row) {
	        $("#dlg").dialog("open").dialog('setTitle', '修改采集设备');
	        $("#fm").form("load", row);
	        url = 'rtuController/updateRtu';
	    }else{
	    	$.messager.alert("提示信息", "请选择一条数据！");
			return;
	    }
	}

	/***
	 * 删除采集设备
	 */
	function deleteRtu(){
		var row = $('#rtuList').datagrid('getSelections');
		if(row.length==0){
			$.messager.alert("提示信息", "请选择一条数据！");
			return;
		}else{
			var rtuIds="";  
	        //批量获取选中行的rtuId  
	        for (i = 0; i < row.length;i++) {
	            if (rtuIds =="") { 
	            	rtuIds = row[i].rtuId;  
	            } else {  
	            	rtuIds = row[i].rtuId + "," + rtuIds;  
	            }    
			}
	        $.messager.confirm('删除采集设备', '确定删除采集设备吗?', function (r) {
	            if (r) {
	                $.post('rtuController/delRtu', { id: rtuIds }, function (data) {
	                    if (data[0].isSuccess > 0) {
	                    	$.messager.alert("提示信息", "删除成功!");
	                        $('#rtuList').datagrid('reload'); 
	                        $('#rtuList').datagrid('clearSelections');//删除成功 清空check勾选行
	                    } else {
	                    	$.messager.alert("提示信息", "删除失败!");
	                    }
	                }, 'json');
	            }
	        });
		}
	}


	/**
	 * 重置
	 */
	function clearCondition(){
		$('#rtuList').datagrid('clearSelections');//重置清空check勾选行
		$("#rtuList").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
		$("#search").find("input").val("");//找到form表单下的所有input标签并清空
	}

