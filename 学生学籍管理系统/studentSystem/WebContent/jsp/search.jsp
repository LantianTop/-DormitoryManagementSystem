<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>

<title>搜索学生信息</title>

<script type="text/javascript">
$().ready(function() {
    $("#form1").validate({
     rules: {
       "id": {
       required: true,
       digits:true,
       minlength:0,
       maxlength:8
       },
       "name": {
           required: true,
           maxlength:16
       }
      },
      messages: {
       "id": {
       required:"请输入学号",
       digits:"学号必须为数字",
       minlength:jQuery.format("学号不能小于{0}个字符"),
       maxlength:jQuery.format("学号不能大于{0}个字符")
       },
       "name": {
           required: "请输入姓名",
           maxlength:Query.format("学号不能大于{0}个字符")
       }
      }
      }); });
</script>
</head>
<body>
	<form id="form1" action="searchStudentInfo" method="post">
	<table align="center">
		<tbody>
			<tr>
				<td>学号</td>
				<td><input type="text" id="id" name="id"/></td>
				<td><input type="hidden" name="type" value="id"/></td>
				<td><input type="submit" value="搜索"/></td>
			</tr>
		</tbody> 
	</table>
	</form>
	<form id="form2" action="searchStudentInfo" method="post">
	<table align="center">
		<tbody>
			<tr>
				<td>姓名</td>
				<td><input type="text" id="name" name="name"/></td>
				<td><input type="hidden" name="type" value="name"/></td>
				<td><input type="submit" value="搜索"/></td>
			</tr>
		</tbody> 
	</table>
	</form>
</body>
</html>