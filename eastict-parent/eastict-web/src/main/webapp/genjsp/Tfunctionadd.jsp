<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Tfunction 录入</title>
	<link rel="stylesheet" type="text/css" href="../resources/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../resources/easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../resources/demo.css">
	<script type="text/javascript" src="../resources/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../resources/easyUI/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<h2>Tfunction 录入</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="新建Tfunction" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="formid" method="post">
	    	<table cellpadding="5">
				<tr>
	<td>funcid:</td>
	<td><input class="easyui-numberbox" value="123456789" name="funcid" data-options="precision:0,groupSeparator:' ',decimalSeparator:','"></input></td>
</tr>
<tr>
	<td>appid:</td>
	<td><input class="easyui-numberbox" value="123456789" name="appid" data-options="precision:0,groupSeparator:' ',decimalSeparator:','"></input></td>
</tr>
<tr>
	<td>funceame:</td>
	<td><input class="easyui-textbox" name="funceame" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>funccnname:</td>
	<td><input class="easyui-textbox" name="funccnname" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>description:</td>
	<td><input class="easyui-textbox" name="description" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>isgroup:</td>
	<td><input class="" type="checkbox" name="isgroup"></td>
</tr>
<tr>
	<td>parentid:</td>
	<td><input class="easyui-numberbox" value="123456789" name="parentid" data-options="precision:0,groupSeparator:' ',decimalSeparator:','"></input></td>
</tr>
 
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPage.submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPage.clearForm()">重置</a>
	    </div>
	    </div>
	</div>
	<script type="text/javascript">
		var addPage  = {
				submitForm : function (){
					if(!$('#formid').form('validate')){
						$.messager.alert('提示','表单还未填写完成!');
						return ;
					}
					
					$.post("../Tfunction/save",$("#formid").serialize(), function(data){
						if(data.status == 200){
							$.messager.alert('提示','新增内容成功!');
						}else{
							$.messager.alert('提示','新增内容失败!');
						}
					});
				},
				clearForm : function(){
					$('#formid').form('reset');
				}
		};
	</script>

</body>
</html>
