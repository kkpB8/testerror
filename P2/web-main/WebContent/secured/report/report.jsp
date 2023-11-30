<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="com.rmspl.app.data.service.DataFetcher"%>
<%@page import="java.util.List"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>|| Report ||</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- Bootstrap -->
	    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap.min.css" rel="stylesheet">
	    <link href="<%=getServletContext().getContextPath() %>/style/animate.min.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/bootstrap-dropdownhover.min.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/bootstrap-datepicker.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/style.css" rel="stylesheet">
	    
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
		<!-- # For Store User Id in Session -->
		<input type="hidden" id="cur_date" value=<%=Utility.getCurrentDate() %> >
		<input type="hidden" id="role" value=<%=request.getSession().getAttribute("role").toString() %> >
		<input type="hidden" id="name" value=<%=request.getSession().getAttribute("name").toString() %> >
		<input type="hidden" id="map_id" value=<%=request.getSession().getAttribute("map_id").toString() %> >
		<input type="hidden" id="user_code" value=<%=request.getSession().getAttribute("user_code").toString() %> >
		<input type="hidden" id="user_type" value=<%=request.getSession().getAttribute("user_type").toString() %> >

		<section id="bodyInner">
			<!-- Header -->
				<%@ include file="../header.jsp" %>
			<!-- Header -->
		
			<!-- Main Contain -->
			<section id="webreport">
				<div class="container">
					<div class="col-md-12 col-m-12 col-xs-12">
						<h3 class="reportHeadline">Web Report</h3>
					</div>
					
					<div class="reportSectionDiv">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label class="frmLabel">Project/Program.</label>
							<select id="sel_prjprg" class="frmTextBox frmSelectBox blue_Border" onchange="changeProjetPrgm()">
								<option value="All">All</option>
								<option value="OPNIP">OPNIP</option>
								<option value="APF-PHRS">APF-PHRS</option>
								<option value="WCD-OMBADC">WCD-OMBADC</option>
								<option value="DMF KEONJHAR">DMF KEONJHAR</option>
							</select>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label class="frmLabel">Select Report Type</label>
							<select id="sel_rept_type" class="frmTextBox frmSelectBox blue_Border" onchange="changeReport()"></select>
						</div>
						
						<div id="div_rept1">
							<div class="col-md-3 col-sm-6 col-xs-12">
								<label class="frmLabel">Select Report Category</label>						
								<select id="sel_period" class="frmTextBox frmSelectBox blue_Border">
									<option value="till_month">Till Month</option>
									<option value="by_month">For Month</option>
								</select>						
							</div>
							<div class="col-md-3 col-sm-6 col-xs-12">
								<label class="frmLabel">Select Month / Year</label>	
								<input id="sel_mnth_yr" type="text" class="form-control form-control-1 input-sm from frmTextBox blue_Border" readonly="readonly" style="background:#f1f1f1;border:1px solid #000;">
							</div>
						</div>
					<div id="div_rept2" style="display: none;">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label class="frmLabel">Select Report Category</label>						
							<select id="sel_catg" class="frmTextBox frmSelectBox blue_Border">
								<option value="waz">Weight for Age</option>
								<option value="haz">Length/Height for Age</option>
								<option value="whz">Weight for Length/Height</option>
							</select>						
						</div>				
						<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<label class="frmLabel">Select Period</label>						
							<select id="sel_period" class="frmTextBox frmSelectBox">
								<option value="03">3 Months</option>
								<option value="06">6 Months</option>
							</select>						
						</div> -->
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label class="frmLabel">Select Month / Year</label>	
							<input id="sel_mnth_yr_start" type="text" class="form-control form-control-1 input-sm from frmTextBox blue_Border" readonly="readonly" style="background:#f1f1f1;border:1px solid #000;">
						</div>
						<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<label class="frmLabel">End Month / Year</label>	
							<input id="sel_mnth_yr_end" type="text" class="form-control form-control-1 input-sm frmTextBox" readonly="readonly" style="background:#f1f1f1;border:1px solid #000;">
						</div> -->
					</div>
					
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="dv_rpt_cntrl">
							<button id="btn_dwnld" type="button" class="btnDownload">Download</button>
							<%-- 
							<%
								if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("super_user")
										|| request.getSession().getAttribute("role").toString().equalsIgnoreCase("st_user")){%>
									<div class="btnDownload_inn">
										<a href="javascript:" onclick="downloadAllAnthroData();">Download All Anthropometry Data</a>
									</div>
								<%}
							%>
							 --%>
						</div>
					</div>
					
					</div>
					
					<div id="bulkReportDiv" class="reportSectionDiv" style="display:none;">
					<!--  ***************** 2/11/2020 ******************* -->
					<%
						if(request.getSession().getAttribute("role").toString().equalsIgnoreCase("super_user")
								|| request.getSession().getAttribute("role").toString().equalsIgnoreCase("st_user")){%>
									<div class="col-md-12 col-sm-12 col-xs-12 secondReportTyoe">
										<div class="row">
											<div class="col-md-4 col-sm-4 col-xs-12">
												<label class="frmLabel">Select Report Type for Bulk Download</label>
												<select id="selRptTypeBulk" class="frmTextBox frmSelectBox blue_Border">
												</select>
											</div>
											<div class="col-md-4 col-sm-4 col-xs-12">
												<label class="frmLabel">District Name</label>
												<select id="selDist" class="frmTextBox frmSelectBox blue_Border">
												</select>
											</div>
											<div class="col-md-4 col-sm-4 col-xs-12">
												<label class="frmLabel">Year</label>
												<select id="selYear" class="frmTextBox frmSelectBox blue_Border">
													<% for(String year : Utility.getCalenderYears(2015)) {%>
					                          	 		<option value="<%=year%>"><%=year%> </option>
					                           		<% } %>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="dv_rpt_cntrl">
											<button id="btnBulkDwnld" type="button" class="btnDownload">Download</button>
										</div>
									</div>
					
						<%}
					%>
					</div>
					
				</div>
			</section>
			<!-- Main Contain End -->
		
			<!-- footer -->
				<%@ include file="../footer.jsp" %>
			<!-- footer -->
		</section>
		
		<!-- # For Store User Id in Session -->
		<input type="hidden" id="hdUserRole" value=<%=request.getSession().getAttribute("role").toString() %>>
		<input type="hidden" id="hdUserId" value=<%=request.getSession().getAttribute("map_id").toString() %>>
		<input type="hidden" id="hdUserDt" value=<%=request.getSession().getAttribute("user_dt").toString() %>>
		<input type="hidden" id="hdUserBk" value=<%=request.getSession().getAttribute("user_bk").toString() %>>
		<input type="hidden" id="cur_date" value=<%=Utility.getCurrentDate() %> >

    	<script src="<%=getServletContext().getContextPath() %>/secured/report/script/report.js"></script>
    	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
	</body>
</html>