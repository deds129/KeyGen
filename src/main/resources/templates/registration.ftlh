<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Spring Security Example </title>
</head>
<body>
Add new user
<#if message??>
	${message}
</#if>
<form action="/registration" method="post">
	<div><label> User Name : <input type="text" name="username"/> </label></div>
	<div><label> Password: <input type="password" name="password"/> </label></div>
	<input type="hidden" name="${_csrf.parameterName}"
		   value="${_csrf.token}" />
	<div><input type="submit" value="Add user"/></div>
</form>
</body>
</html>