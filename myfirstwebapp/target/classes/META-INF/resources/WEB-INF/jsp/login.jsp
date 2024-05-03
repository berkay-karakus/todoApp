<html>
<head>
<title>My first HTML Page -JSP</title>
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="username" /> Password: <input
				type="password" name="password" /> <input type="submit" />
		</form>
	</div>
</body>
</html>