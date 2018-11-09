<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/js.js"></script>
</head>
<body>
<h1><s:property value="#request.notAdminError" /> </h1>
<div id="top"> </div>
<form id="login" name="login" action="login" method="post">
  <div id="center">
    <div id="center_left"></div>
    <div id="center_middle">
      <div class="user">
        <label>用户名：
        <input type="text" name="username" id="user" />
        </label>
      </div>
      <div class="user">
        <label>密　码：
        <input type="password" name="password" id="pwd" />
        </label>
      </div>
      <div class="chknumber">
        <label>
        	<s:if test="#session.addmin=null"></s:if>
        	<s:property value="#request.inputError"/>
        </label>
      </div>
    </div>
    <div id="center_middle_right"></div>
    <div id="center_submit">
      <div class="button"> <s:submit width="57" height="20" align="center" value="登录     " /> </div>
      <div class="button"> <s:reset width="57" height="20" align="center" value="重置     " /></div>
    </div>
    <div id="center_right"></div>
  </div>
</form>
<div id="footer"></div>
</body>
</html>
