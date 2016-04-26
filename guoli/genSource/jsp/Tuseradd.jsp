<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Tuser 录入</title>
	<link rel="stylesheet" type="text/css" href="../resources/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../resources/easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../resources/demo.css">
	<script type="text/javascript" src="../resources/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../resources/easyUI/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<h2>Tuser 录入</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="新建Tuser" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="formid" method="post">
	    	<table cellpadding="5">
				<tr>
	<td>userid:</td>
	<td><input class="easyui-textbox" name="userid" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>logonname:</td>
	<td><input class="easyui-textbox" name="logonname" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>displayname:</td>
	<td><input class="easyui-textbox" name="displayname" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>pwdmd5:</td>
	<td><input class="easyui-textbox" name="pwdmd5" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
</tr>
<tr>
	<td>createtime:</td>
	<td><input class="easyui-datebox"  name="createtime"></td>
</tr>
<tr>
	<td>enabled:</td>
	<td><input class="" type="checkbox" name="enabled"></td>
</tr>
<tr>
	<td>pictureurl:</td>
	<td><input class="easyui-textbox" name="pictureurl" data-options="prompt:'请输入...',required:true,validType:'length[3,10]'"></td>
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
					
					$.post("../Tuser/save",$("#formid").serialize(), function(data){
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
