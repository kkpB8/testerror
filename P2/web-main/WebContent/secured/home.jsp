<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="icon" type="../image/png" href="../images/nhm_logo1.png" /> -->
<title>|| Home ||</title>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/animate.min.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap-datepicker.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/style.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/dataentry_style.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath() %>/style/large_style.css" rel="stylesheet">
   
   <!-- Local import -->
	<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.css"/>
	<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/jquery.loadingModal.css">
	<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-1.12.4.js"></script>
	<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.js"></script>  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-dropdownhover.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-datepicker.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/js/jquery.loadingModal.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/js/bootbox.js"></script>
	
		<% 
	        if(session.getAttribute("Hits") == null) {
		  		session.setAttribute("Hits", HitCounter.getHitCount());
		  	} 
		%>
		
		<!-- To get Login User details -->
		<%
			if (request.getSession().getAttribute("map_id") == null){
				List<String[]> datas = DataFetcher.getData("SELECT role_name, name, map_id,user_code FROM users_info WHERE user_name = '"+request.getRemoteUser()+"'");
				request.getSession().setAttribute("role", datas.get(0)[0]);
				request.getSession().setAttribute("name", datas.get(0)[1]);
				request.getSession().setAttribute("map_id", datas.get(0)[2]);
				request.getSession().setAttribute("user_code", datas.get(0)[3]);
			}
		%>
		
	<style type="text/css">
		li{
			list-style-type: none;
		}
		.footer_img_div{ display: none; }
		@media screen and (min-width:768px) and (max-width:1024px){
			.footer_img_div{ display: block; }
		}
	</style>
</head>
<body>
	<!-- # For Store User Id in Session -->
	<input type="hidden" id="hdUserId" value=<%=request.getSession().getAttribute("map_id").toString() %> >
    <div class="container-fluid">
    	<!-- Header -->
    		<%@ include file="header.jsp" %>
        <!-- Header -->
		<div class="contentdetails">
    	 		<div class="col-md-4"></div>
    	 		<div class="col-md-4 div_hm_cntnt">
    	 			<fieldset class="scheduler_border">
    	 				<legend style="color:#3c91ab;">Search Eligible Couple / Mother / Child :</legend>
    	 				<input type="text" id="txt_serach" value="1000000719" style="height:31px;margin-left: 18%;width: 54%;"  placeholder="Enter for active RCH/MCTS ID No.">&nbsp;&nbsp;<button type="button" class="btn btn-primary" id="bttn_go" style="padding:5px;">Go</button>
    	 			</fieldset>
    	 		</div>
    	 		<div class="col-md-4"></div>
       	 </div>
        <!-- footer -->
        	<%@ include file="footer.jsp" %>
        <!-- footer -->
    </div>
    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/home.js"></script>
    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/dataentry/script/target_page.js"></script>
</body>
</html>