<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>|| Manage Data Edit ||</title>
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
	    
	    <%-- <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/bootstrap.min.css"/> --%>
	    <%-- <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.bootstrap.min.css"/> --%>
	    <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.css"/>
	   
	   	<!-- Local import -->
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/jquery.loadingModal.css">
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-1.12.4.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.js"></script>  
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    
	    <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	    
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    
	    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	    
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
			 if (request.getSession().getAttribute("user_code") == null){
				List<String[]> datas = DataFetcher.getData("call sp_df_web_user_details('"+request.getRemoteUser()+"')");
				request.getSession().setAttribute("role", datas.get(0)[0]);
				request.getSession().setAttribute("name", datas.get(0)[1]);
				request.getSession().setAttribute("map_id", datas.get(0)[2]);
				request.getSession().setAttribute("user_code", datas.get(0)[3]);
				request.getSession().setAttribute("user_type", datas.get(0)[4]);
				request.getSession().setAttribute("user_dt", datas.get(0)[5]);
				request.getSession().setAttribute("user_bk", datas.get(0)[6]);
			} 
		%>
	</head>
	<body>
		<section id="bodyInner">
			<!-- Header -->
				<%@ include file="../header.jsp" %>
			<!-- Header End -->
			
			<!-- Main Conta --->
			<section id="datalogs">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<!-- <h3 class="cm_Headline">Manage Data Edit</h3> -->
							<h3 class="cm_Headline">summary as per edit requests submission</h3>
							
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="row">
								<div class="backBtn">
									<h3 id="hdFormNm"></h3>
									<a href="#" id="aLnkBack" style="display: none;">Back to Previous</a>
								</div>
								
								<div class="col-md-12 col-sm-12 col-xs-12" id="divYr">
									<label  >Select Year : </label>
									<select id="sel_yr" class="from selectYearBox" >
											<% for(String year : Utility.getCalenderYears(2018)) {%>
				                          	 	<option value="<%=year%>"><%=year%> </option>
				                           	<% } %>
									</select>		
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div id="div_data" class="manageDivShow">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<!-- footer -->
				<%@ include file="../footer.jsp" %>
			<!-- footer End -->
		
			<!-- # For Store User Id in Session -->
			<input type="hidden" id="hdUserId" value=<%=request.getSession().getAttribute("user_code").toString() %>>
			<input type="hidden" id="hdMapId" value=<%=request.getSession().getAttribute("map_id").toString() %>>
			<input type="hidden" id="hdUserRole" value=<%=request.getSession().getAttribute("role").toString() %>>
			<input type="hidden" id="hdUserDt" value=<%=request.getSession().getAttribute("user_dt").toString() %>>
			<input type="hidden" id="hdUserBk" value=<%=request.getSession().getAttribute("user_bk").toString() %>>
			<input type="hidden" id="cur_date" value=<%=Utility.getCurrentDate() %> >
		</section>
		<%-- <script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery-3.5.1.js"></script> --%>
		
		<script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.js"></script>
				    	
    	<script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.bootstrap.min.js"></script>
		<script src="https://www.jqueryscript.net/demo/Transpose-Table-jQuery-Plugin/scripts/jquery.table.transpose.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/secured/manage_data_edit/script/manage_data_edit.js"></script>
	    
	</body>
</html>