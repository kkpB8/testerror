<%@page import="java.util.StringTokenizer"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@page import="com.rmspl.app.data.service.DataFetcher"%>	

<%String str_url; %>

<%if(request.getRequestURL().toString().endsWith("home.jsp")){ %>
	<%str_url = "../images/header.png"; %>
<%} else {%>
	<%str_url = "../../images/header.png"; %>
<%}%>			         

<!-- Session time out set in hidden field  -->
<input type="hidden" id="session_time_out" value="<%= request.getServletContext().getInitParameter("sessionTimeOut")%>">

<!-- user name set in hidden field  -->
<input type="hidden" id="userName_hidden" value="<%= request.getRemoteUser()%>">

<div class="row head_inner">			
	<!-- Menubar -->
	<section id="topmenu">
		<div class="container-fluid">
			<div class=row>
				<div class="col-md-3 col-sm-12 col-xs-12 govlogo">
					<img alt="Logo" src="<%=getServletContext().getContextPath() %>/images/Govt_Logo.png" title="">
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<h3>e-Kalika</h3>
					<small>CRECHE MIS</small>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12 spologo">
					<!--			<img alt="Logo" src="<%=getServletContext().getContextPath() %>/images/appi_phrn.png" title="">		-->
					<!--<span style="width:50%;float:left;">
						<img id="logo_wb" alt="Logo" src="<%=getServletContext().getContextPath() %>/images/APPI_Logo_2.png" title="" style="width:100%;height:55px;">
					</span>
					<span style="width:50%;float:left;">
						<img id="logo_wb" alt="Logo" src="<%=getServletContext().getContextPath() %>/images/PHRN_Logo_2.png" title="" style="width:100%;height:55px;">
					</span>-->
				</div>
			</div>
		</div>
	</section>
	
	<div class="menu_inner">
		<nav class="navbar navbar-default">
	  		<div class="container-fluid">
	    		<!-- Brand and toggle get grouped for better mobile display -->
	    		<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        	<span class="sr-only">Toggle navigation</span>
			        	<span class="icon-bar"></span>
			        	<span class="icon-bar"></span>
			        	<span class="icon-bar"></span>
			      	</button>
	    		</div>
	
	    		<!-- Collect the nav links, forms, and other content for toggling -->
	    		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    	<ul class="nav navbar-nav">
			    	
			    		<%
			    		List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_mst_user_module('"+request.getRemoteUser()+"')"); 
	    				for(String[] strings : lst_data) {
	    					if(strings[1].equalsIgnoreCase("Overview")) {%>
								<li><a id="overview" href="<%=getServletContext().getContextPath() %>/secured/overview/overview.jsp" title="Overview">Overview</a></li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Monitoring")) {%>
								<li><a id="monitoring" href="<%=getServletContext().getContextPath() %>/secured/monitoring/monitoring.jsp" title="Monitoring Indicator">Monitoring</a></li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Dashboard")) {%>
								<li><a id="dashboard" href="<%=getServletContext().getContextPath() %>/secured/dashboard/dashboard.jsp" title="Dashboard">Dashboard</a></li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Admin")) {%>
								<li class="dropdown">
									<a href="javascript:" id="admin" title="Admin" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Admin <b class="caret"></b></a>
									<%if(!strings[3].equalsIgnoreCase("N/A")) {%>
										<ul class="dropdown-menu">
											<%StringTokenizer token = new StringTokenizer(strings[3], "^"); 
									        while (token.hasMoreTokens()){
									        	String str_sub_menu = token.nextToken();
									        	if(str_sub_menu.equalsIgnoreCase("USER Management")) {%>
									        		<li class="dropdown">
														<a href="javascript:" title="User Management">User Management <b class="caret"></b></a>
														<ul class="dropdown-menu">
															<li><a href="<%=getServletContext().getContextPath() %>/secured/admin/usermng_tablet.jsp" title="Tablet User">Tablet User<span></span></a></li>
															<li><a href="<%=getServletContext().getContextPath() %>/secured/admin/usermng_web.jsp" title="Web User">Web User<span></span></a></li>
														</ul>	
													</li>								        	
									        	<%} else {
									        		if(str_sub_menu.equalsIgnoreCase("Creche Management")) {%>
									        			<li><a id="creche_management" href="<%=getServletContext().getContextPath() %>/secured/admin/creche_management.jsp" title="Creche Management">Creche Management<span></span></a></li>
									        		<%}
									        		else if(str_sub_menu.equalsIgnoreCase("Content Management")) {%>
									        			<li><a id="content_management" href="<%=getServletContext().getContextPath() %>/secured/admin/content_management.jsp" title="Content Management">Content Management<span></span></a></li>
									        		<%}
									        		else if(str_sub_menu.equalsIgnoreCase("ADD Geography")) {%>
									        			<li><a id="add_geography" href="<%=getServletContext().getContextPath() %>/secured/admin/add_geography.jsp" title="Add Geography">Add Geography<span></span></a></li>
									        		<%}
									        		else if(str_sub_menu.equalsIgnoreCase("ADD NEW Question")) {%>
									        			<li><a id="add_new_question" href="<%=getServletContext().getContextPath() %>/secured/admin/add_new_question.jsp" title="Add New Question">Add New Question<span></span></a></li>
									        		<%}
									        		else if(str_sub_menu.equalsIgnoreCase("Child Shifting")) {%>
									        			<li><a id="child_shifting" href="<%=getServletContext().getContextPath() %>/secured/admin/childshifting.jsp" title="Child Shifting">Child Shifting<span></span></a></li>
									        		<%}
									        	}
									        }%>
								        </ul>								        									             
									<%}%>
								</li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Data Logs")) {%>
								<li><a id="data_logs" href="<%=getServletContext().getContextPath() %>/secured/data_logs/datalogs.jsp" title="Data Logs">Data Logs<span></span></a></li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Report")) {%>
		    					<li class="dropdown">
									<a href="javascript:" id="report" title="Report" data-toggle="dropdown" role="button" aria-expanded="false">Report <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li class="dropdown-content">
											<%StringTokenizer token = new StringTokenizer(strings[3], "^"); 
											while (token.hasMoreTokens()){
									        	String str_sub_menu = token.nextToken();
									        	if(str_sub_menu.equalsIgnoreCase("Web Report")) {%>
								        			<a href="<%=getServletContext().getContextPath() %>/secured/report/report.jsp" title="Web Report">Web Report</a>
								        		<%}
								        		else if(str_sub_menu.equalsIgnoreCase("Child Atlas")) {%>
								        			<a href="<%=getServletContext().getContextPath() %>/secured/report/child_atlas_2.jsp" title="Child Atlas">Child Atlas</a>
								        		<%}
											}%>
										</li>
									</ul>
								</li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("GIS")) {%>
								<li class="dropdown">
									<a href="javascript:" id="gis" title="GIS" data-toggle="dropdown" role="button" aria-expanded="false">GIS <b class="caret"></b></a>
						    		<ul class="dropdown-menu">
						    			<%
						    				JSONObject json_data = new JSONObject();
						    				json_data.put("395", "Kalahandi");
						    				json_data.put("398", "Koraput");
						    				json_data.put("399", "Malkangiri");
						    				json_data.put("397", "Nabarangapur");
						    				json_data.put("396", "Rayagada");
						    			%>
						    		
						    			<%if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("super_user")
						    					|| request.getSession().getAttribute("role").toString().equalsIgnoreCase("st_user")) {%>
						    				<li><a href="javascript:" onclick="showMap('21', 'State', 'ST')">State</a></li>
							    			<li><a href="javascript:" onclick="showMap('395', 'Kalahandi', 'DT')">Kalahandi</a></li>
							    			<li><a href="javascript:" onclick="showMap('398', 'Koraput', 'DT')">Koraput</a></li>
							    			<li><a href="javascript:" onclick="showMap('399', 'Malkangiri', 'DT')">Malkangiri</a></li>
											<li><a href="javascript:" onclick="showMap('397', 'Nabarangapur', 'DT')">Nabarangapur</a></li>
											<li><a href="javascript:" onclick="showMap('396', 'Rayagada', 'DT')">Rayagada</a></li>
						    			<%} else if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("dt_user")
						    							|| request.getSession().getAttribute("role").toString().equalsIgnoreCase("bk_user")) {%>
						    				<li><a href="javascript:" onclick="showMap('<%=request.getSession().getAttribute("user_dt").toString() %>', '<%=json_data.get(request.getSession().getAttribute("user_dt").toString()) %>', 'DT')"><%=json_data.get(request.getSession().getAttribute("user_dt").toString()) %></a></li>
						    			<%} %>
						    			
						    			<!-- <li><a href="javascript:" onclick="showMap('21', 'State', 'ST')">State</a></li>
						    			<li><a href="javascript:" onclick="showMap('395', 'Kalahandi', 'DT')">Kalahandi</a></li>
						    			<li><a href="javascript:" onclick="showMap('398', 'Koraput', 'DT')">Koraput</a></li>
						    			<li><a href="javascript:" onclick="showMap('399', 'Malkangiri', 'DT')">Malkangiri</a></li>
										<li><a href="javascript:" onclick="showMap('397', 'Nabarangapur', 'DT')">Nabarangapur</a></li>
										<li><a href="javascript:" onclick="showMap('396', 'Rayagada', 'DT')">Rayagada</a></li> -->
									</ul>
						    	</li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("View Data Edit History")) {%>
								<li><a id="data_edit_history" href="<%=getServletContext().getContextPath() %>/secured/data_edit_history/data_edit_history.jsp" title="View Data Edit History">View Data Edit History<span></span></a></li>
							<%}
	    					else if(strings[1].equalsIgnoreCase("Manage Data Edit")) {%>
								<li><a id="manage_data_edit" href="<%=getServletContext().getContextPath() %>/secured/manage_data_edit/manage_data_edit.jsp" title="Manage Data Edit">Manage Data Edit<span></span></a></li>
							<%}
	    				}%>
			    		
			    	
			    	
			    		<%--  
			        	<li><a id="home" href="<%=getServletContext().getContextPath() %>/secured/overview/overview.jsp" title="Overview">Overview</a></li>
			        	<li><a id="monitoring" href="<%=getServletContext().getContextPath() %>/secured/monitoring/monitoring.jsp" title="Monitoring Indicator">Monitoring</a></li>
			        	<li><a id="dashboard" href="<%=getServletContext().getContextPath() %>/secured/dashboard/dashboard.jsp" title="Dashboard">Dashboard</a></li>
						<%if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("super_user")){ %>
							<li class="dropdown">
							<a href="javascript:" id="admin" title="Admin" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Admin <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="dropdown">
										<a href="javascript:" title="User Management">User Management <b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="<%=getServletContext().getContextPath() %>/secured/admin/usermng_tablet.jsp" title="Tablet">Tablet<span></span></a></li>
											<li><a href="<%=getServletContext().getContextPath() %>/secured/admin/usermng_web.jsp" title="Web Browser">Web Browser<span></span></a></li>
										</ul>	
									</li>
									<li><a id="creche_management" href="<%=getServletContext().getContextPath() %>/secured/admin/creche_management.jsp" title="Creche Management">Creche Management<span></span></a></li>
									<li><a id="content_management" href="<%=getServletContext().getContextPath() %>/secured/admin/content_management.jsp" title="Content Management">Content Management<span></span></a></li>
									<li><a id="add_geography" href="<%=getServletContext().getContextPath() %>/secured/admin/add_geography.jsp" title="Add Geography">Add Geography<span></span></a></li>
									<li><a id="add_new_question" href="<%=getServletContext().getContextPath() %>/secured/admin/add_new_question.jsp" title="Add New Question">Add New Question<span></span></a></li>
									<li><a id="child_shifting" href="<%=getServletContext().getContextPath() %>/secured/admin/childshifting.jsp" title="Child Shifting">Child Shifting<span></span></a></li>
								</ul>
							</li>
							<li><a id="data_logs" href="<%=getServletContext().getContextPath() %>/secured/data_logs/datalogs.jsp" title="Data Logs">Data Logs<span></span></a></li>
						<%} else if (request.getSession().getAttribute("role").toString().equalsIgnoreCase("other_user")){ %>
							<li class="dropdown">
								<a href="javascript:" id="admin" title="Admin" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Admin <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="javascript:" title="Creche Management">Creche Management <b class="caret"></b></a></li>
									<li><a href="javascript:" title="Content Management">Content Management <b class="caret"></b></a></li>
									<li><a href="javascript:" title="Add Geography">Add Geography <b class="caret"></b></a></li>
								</ul>
							</li>
						<%} %>
						<li class="dropdown">
							<a href="javascript:" id="report" title="Report" data-toggle="dropdown" role="button" aria-expanded="false">Report <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="dropdown-content">
									<a href="<%=getServletContext().getContextPath() %>/secured/report/report.jsp" title="Web Report">Web Report</a>
									<a href="<%=getServletContext().getContextPath() %>/secured/report/child_atlas_2.jsp" title="Child Atlas">Child Atlas</a>
								</li>
							</ul>
						</li>
					
						<li class="dropdown">
							<a href="javascript:" id="gis" title="GIS" data-toggle="dropdown" role="button" aria-expanded="false">GIS <b class="caret"></b></a>
				    		<ul class="dropdown-menu">
				    			<li><a href="javascript:" onclick="showMap('21', 'State', 'ST')">State</a></li>
				    			<li><a href="javascript:" onclick="showMap('395', 'Kalahandi', 'DT')">Kalahandi</a></li>
				    			<li><a href="javascript:" onclick="showMap('398', 'Koraput', 'DT')">Koraput</a></li>
				    			<li><a href="javascript:" onclick="showMap('399', 'Malkangiri', 'DT')">Malkangiri</a></li>
								<li><a href="javascript:" onclick="showMap('397', 'Nabarangapur', 'DT')">Nabarangapur</a></li>
								<li><a href="javascript:" onclick="showMap('396', 'Rayagada', 'DT')">Rayagada</a></li>
							</ul>
				    	</li>
				    	<li><a id="data_edit_history" href="<%=getServletContext().getContextPath() %>/secured/data_edit_history/data_edit_history.jsp" title="View Data Edit History">View Data Edit History<span></span></a></li>
				    	<li><a id="manage_data_edit" href="<%=getServletContext().getContextPath() %>/secured/manage_data_edit/manage_data_edit.jsp" title="Manage Data Edit">Manage Data Edit<span></span></a></li>
				    	 --%>
				    	
				    	
			      	</ul>
	      
				    <ul class="nav navbar-nav navbar-right">
						<%-- <li><a href="javascript:">Welcome :<b> <%=request.getSession().getAttribute("name").toString()%></b></a></li> --%>
						<li class="dropdown">
							<a href="javascript:">Welcome :<b> <%=request.getSession().getAttribute("name").toString()%></b><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a id="chg_pass" href="<%=getServletContext().getContextPath() %>/secured/profile/changepassword.jsp" title="change password">Change password</a></li>
								<li><a id="logout" href="<%=getServletContext().getContextPath() %>/logout.jsp" title="Log Out">Log Out</a></li>
							</ul>
						</li>
						<%-- <li><a id="chg_pass" href="<%=getServletContext().getContextPath() %>/secured/profile/changepassword.jsp" title="change password">Change password</a></li>
						<li><a id="logout" href="<%=getServletContext().getContextPath() %>/logout.jsp" title="Log Out">Log Out</a></li>  --%>
				    </ul>
	    		</div><!-- /.navbar-collapse -->
	  		</div><!-- /.container-fluid -->
		</nav>
	</div>
</div>
