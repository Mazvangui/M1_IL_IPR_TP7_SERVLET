<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
</head>
<body>
	<pre>
    	<%= request.getAttribute("content") %>
	</pre>
	<form name="chatForm" action="chat" method="post">
		<input type="text" name="ligne" value=""/>
		<input type="submit" name="action" value="submit"/>
		<input type="submit" name="action" value="refresh"/>
		<input type="submit" name="action" value="logOut"/>
	</form>
</body>
</html>