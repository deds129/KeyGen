<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>


<body>
<div>
	<form name = "license" action="/save" method="post">
	<p>Customer</p>
		<input title="Customer" type="text" name="name" value="${license.customer}">
	<p>License Type</p>
		<input title="License Type" type="text" name="name" value="${license.licenseType}">
	<p>Host</p>
		<input title="Host" type="text" name="name" value="${license.host}">
	<p>Port</p>
		<input title="Post" type="text" name="name" value="${license.port}">
	<p>OS</p>
		<input title="OS" type="text" name="name" value="${license.operSystem}">
		<br>
		<input type="submit" value="OK">
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
	</form>
</div>

<div>
	
</div>

</body>
</html>