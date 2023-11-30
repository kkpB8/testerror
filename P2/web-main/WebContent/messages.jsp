<html>
<head>
<title>Messages</title>
<script>
function goBack() {
	
}
</script>
</head>
<body>
<%
	String type = request.getParameter("type");

	if(type.equalsIgnoreCase("Profile.update_Success")) { //profile update successful
		request.getSession().invalidate();
		response.getWriter().print("<font size='6' color='blue'><p>Please authenticate your mail id by clicking on the link which has been sent"+
				" in your mail.</p></font><font size='4'><p>Click <a href='"+response.encodeURL("index.jsp")+"'>here</a> to login.</p></font>");
	} else if(type.equalsIgnoreCase("Profile.update_Failed")) { //profile update failed
		request.getSession().invalidate();
		response.getWriter().print("<font size='6' color='red'><p>Failed to update your profile.</p></font><font size='4'><p>Click "+
				"<a href='"+response.encodeURL("index.jsp")+"'>here</a> to retry login.</p></font>");
	} else if(type.equalsIgnoreCase("Authenticate.Mail_Success")) { //mail authentication successful
		response.getWriter().print("<font size='6' color='blue'>Thanks for authenticating your mail-id.</font><font size='4'><p>"+
				"Click <a href='"+response.encodeURL("index.jsp")+"'>here</a> to login. </p></font>");
	} else if(type.equalsIgnoreCase("Authenticate.Mail_Failed")) { //mail authentication failed
		response.getWriter().print("<font size='6' color='red'>Error to authenticate your mail id. Please contact with system administrator!!!</font>");
	} else if(type.equalsIgnoreCase("Not.Found")) { //if unable to find requested file
		response.getWriter().print("<font size='6' color='red'>Can not find the specified file.</font>");
	} else if(type.equalsIgnoreCase("Login.Failed")) { //for login failed
		response.getWriter().print("<font size='6' color='red'>Incorrect user name or password.</font><font size='4'><p>Click <a href='"+
			response.encodeURL("index.jsp")+"'>here</a> to retry login. </p></font>");
	} else if(type.equalsIgnoreCase("Password.Change_Success")) { //successfully updated profile password
		request.getSession().invalidate();
		response.getWriter().print("<font size='6' color='blue'>Password changed successfully.</font><font size='4'><p>Click <a href='"+
				response.encodeURL("index.jsp")+"'>here</a> to login. </p></font>");
	} else if(type.equalsIgnoreCase("Password.Change_Failed")) { //error to update profile password
		request.getSession().invalidate();
		response.getWriter().print("<font size='6' color='red'>Unable to change password.</font><font size='4'><p>Click <a href='"+
				response.encodeURL("index.jsp")+"'>here</a> to login. </p></font>");
	} else if(type.equalsIgnoreCase("Password.Recover_Success")) { //profile password recovered successfully
		response.getWriter().print("<font size='6' color='blue'>Your password is sent to your mail.</font><font size='4'><p>Click <a href='"+
				response.encodeURL("index.jsp")+"'>here</a> to login. </p></font>");
	} else if(type.equalsIgnoreCase("Password.Recover_Failed")) { //error to recover profile password
		response.getWriter().print("<font size='6' color='red'>Unable to recover password. Please contact with system administrator.</font><font size='4'><p>Click <a href='"+
				response.encodeURL("index.jsp")+"'>here</a> to login. </p></font>");
	} else if(type.equalsIgnoreCase("ERR_NT_AUTH")) {
		response.getWriter().print("<font size='6' color='red'>Access not permitted!</font><font size='4'><p>Click <a href='"+
				response.encodeRedirectURL(request.getContextPath()+"/index.jsp")+"'>here</a> to go to home page. </p></font>");
	} else if(type.equalsIgnoreCase("no_user")) { //for login failed
		request.getSession().invalidate();
		response.getWriter().print("<font size='6' color='red'>No User Found.</font><font size='4'><p>Click <a href='"+
				response.encodeURL("index.jsp")+"'>here</a> to retry login. </p></font>");
	}
%>
</body>
</html>