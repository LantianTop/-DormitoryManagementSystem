<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">        
<meta http-equiv="cache-control" content="no-cache">        
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>

<title>添加学生信息</title>
<script type="text/javascript">
$().ready(function() {
    $("#form").validate({
     rules: {
       "s.name":{
    	   required: true,
    	   minlength:0,
           maxlength:16
       },
       "s.birthday":{
    	   required: true,
    	   dateISO:true 
       },
       "s.province":{
    	   required: true,
    	   minlength:3
       },
       "s.city":{
    	   required: true,
    	   minlength:3
       },
       "s.nation":{
    	   required: true,
    	   minlength:2
       }
      },
      messages: {
       "s.name": {
           required:"请输入姓名",
           minlength:jQuery.format("姓名不能小于{0}个字符"),
           maxlength:jQuery.format("姓名不能大于{0}个字符")
        },
        "s.birthday":{
     	   required: "请输入出生年月日",
     	   dateISO:"输入日期格式不正确" 
        },
        "s.province":{
      	   required: "请输入省份",
      	  minlength:jQuery.format("省份不能小于{0}个字符"),
         },
        "s.city":{
     	   required: "请输入地区",
     	  minlength:jQuery.format("地区不能小于{0}个字符"),
        },
        "s.nation":{
      	   required: "请输入民族",
      	  minlength:jQuery.format("民族不能小于{0}个字符"),
         }
      }
      }); });
</script>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
s table tr  {
	 border:"1";
	 align:"center";
	 bordercolor:"#BBBBBB";
}

</style>
</head>
<body>
<s:form id="form" action="../addStudent" method="post" enctype="multipart/form-data">
	<table align="center">
		<tr>
			<td><s:textfield label="姓名" name="s.name"/></td>
		</tr>
		<tr>

			<td>
				<s:radio name="s.gender" label="性别" value="'男'" list="#{'男':'男','女':'女'}"/>
			</td>
		</tr>
		<tr>
			<td><s:textfield label="生日" name="s.birthday"/></td>
			<td><s:label value="(日期格式:1993-05-27)"/></td>
		</tr>
		<tr>
			<td><s:textfield label="省份" name="s.province"/></td>
		</tr>
		<tr>
			<td><s:textfield label="地区" name="s.city"/></td>
		</tr>
		<tr>
			<td><s:textfield label="民族" name="s.nation"/></td>
		</tr>
		<tr>
			<td>
				<s:radio name="s.leagueMember" label="团员" value="true" list="#{true:'是',false:'否'}"/>
			</td>
		</tr>
		<tr>
			<td>
			<s:file name="photo" label="照片"/></td>
			<td><td><s:label value="(照片大小必须小于64kb)"/></td>
			
		</tr>
		<tr>
			<td><input type="submit" value="提交"/></td>
			<td><input type="reset" value="重置"/></td>
		</tr>
	</table>	
	<s:hidden name="s.deleted" value="false"/>
</s:form>


</body>
</html>