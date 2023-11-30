<%@page import="com.rmspl.app.misc.HitCounter"%>
<html>
<head>
<title></title>

</head>
<body>
	<%
		//# Default language set English
		session.setAttribute("curlang","eng");
		session.setAttribute("Hits", HitCounter.getHitCount());
		response.sendRedirect("secured/overview/overview.jsp");
	%>
</body>
</html>