
<!DOCTYPE html>
<head>
    License keys
    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid #999;
            padding: 5px;
        }
    </style>
</head>

<body>
<div>
	<form action="/logout" method="post">
		<input type="submit" value="Sign Out"/>
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
	</form>
	
</div>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>CUSTOMER</th>
            <th>LICENSE TYPE</th>
            <th>HOST</th>
            <th>PORT</th>
            <th>OS</th>
        </tr>
        <#list allLicenses as license>
            <tr>
                <td>${license.id}</td>
                <td>${license.customer}</td>
                <td>${license.licenseType}</td>
				<td>${license.host}</td>
				<td>${license.port}</td>
				<td>${license.operSystem}</td>
				<td><form action="/delete/${license.id}">
						<input type="submit" value="Delete"></form></td>
				<td><form action="/update/${license.id}">
					<input type="submit" value="Update"></form></td>
            </tr>
        </#list>
    </table>
</div>

<div>
	<input type="button" value="Add"
		   onclick="window.location.href = 'addLicense'"/>
</div>

</body>
</html>