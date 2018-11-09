<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@ page import="whb.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览学生信息</title>
</head>
<body>
	<table width="400" border="1" align="center" style="top: 200px"
		cellspacing="0" bordercolor="#ccc">
		<tbody>
			<tr>
				<td>姓名：</td>
				<td width="100"><s:property value="#request.s.name" /></td>
				<td rowspan="7" colspan="2">
				<img src="${pageContext.request.contextPath}/getImage?id=<s:property value="#request.s.id"/>" width="200" height="320" alt="照片"
                  title="<s:property value="#user.username" />"/> 
				</td>
			</tr>
			<tr>
				<td>学号：</td>
				<td><s:property value="#request.s.id" /></td>
			</tr>
			<tr>
				<td width="100">出生年月：</td>
				<td width="100">${s.birthday}</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><s:property value="#request.s.gender" /></td>
			</tr>
			<tr>
				<td>省份：</td>
				<td><s:property value="#request.s.province" /></td>
			</tr>
			<tr>
				<td>地区：</td>
				<td><s:property value="#request.s.city" /></td>
			</tr>
			<tr>
				<td>团员：</td>
				<td><s:if test="#request.s.leagueMember==true">是</s:if> <s:else>否</s:else></td>
			</tr>
		</tbody>
	</table>
</body>
</html>