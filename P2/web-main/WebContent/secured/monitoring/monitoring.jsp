<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>|| Monitoring Indicators ||</title>
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
	    
	    <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.css"/>
	   
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
	    <style>
	    	.chartsheetDiv{
	    		min-height:60vh;
	    	}
	    	.div_chrt_mnt {
  				height:300px;
			}
			.splNote{
				margin:0;
			}
	    </style>
		
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
			<section id="overviewDiv">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<!----------------------------------->
							<div id="div_filter_details" class="filter_details"></div>
							<!----------------------------------->
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 sub_menu">
							<ul id="mtr_grp_ul" class="nav-tabs nav-tabs_ul">
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 sub_menu">
							<ul id="mtr_sub_grp_ul" class="nav-tabs nav-tabs_ul sub_sub_menu">
							</ul>
						</div>
					</div>
					<!---------------------------------------------->
					<div class="chartsheetDiv">
						<div class="row">
							<div class="col-md-2 col-sm-2 col-xs-12 leftpanelDiv">
								<div class="row">
									<div class="leftBoxFixed">
										<p class="selectivedLavel">Select Level</p>
									</div>
								</div>
								
								<div class="row">
									<div class="leftBoxUlLi">
										<div id="div_Crech_Catg" class="selectdiv_spl" >
											<label>Project/Program. <sup class="splSup">**</sup></label>
											<select id="sel_catg" class="overviewselectbox">
												<option value="All">All</option>
												<option value="OPNIP">OPNIP</option>
												<option value="APF-PHRS">APF-PHRS</option>
												<option value="WCD-OMBADC">WCD-OMBADC</option>
												<option value="DMF KEONJHAR">DMF KEONJHAR</option>
											</select>
										</div>
										<div class="col-sm-12" id="div_rd_st_mtr">
											<input type="radio" id="rdb_st" name="level" value="state" onclick="showHideCombo(this.value);">&nbsp; <label>State</label>
										</div>
										<div class="col-sm-12" id="div_rd_dt_mtr">
											<input type="radio" id="rdb_dt" name="level" value="district" onclick="showHideCombo(this.value);">&nbsp; <label>District</label>
										</div>
										<div class="col-sm-12" id="div_rd_bk_mtr">
											<input type="radio" id="rdb_bk" name="level" value="block" onclick="showHideCombo(this.value);">&nbsp; <label>Block</label>
										</div>
										<div class="col-sm-12" id="div_rd_gp_mtr">
											<input type="radio" id="rdb_gp" name="level" value="gp" onclick="showHideCombo(this.value);">&nbsp; <label>GP</label>
										</div>
										<div class="col-sm-12" id="div_rd_vl_mtr">
											<input type="radio" id="rdb_vl" name="level" value="village" onclick="showHideCombo(this.value);">&nbsp; <label>Village</label>
										</div>
										<div class="col-sm-12" id="div_rd_cr_mtr">
											<input type="radio" id="rdb_cr" name="level" value="creche" onclick="showHideCombo(this.value);">&nbsp; <label>Creche</label>
										</div>
										<div class="col-sm-12">
											<div id="div_dt" class="selectdiv" style="display: none;">
												<label>Select District <sup>*</sup></label>
												<select id="sel_dt" class="overviewselectbox">
													<option>Select District</option>
												</select>
											</div>
										</div>
										<div class="col-sm-12">
											<div id="div_bk" class="selectdiv" style="display: none;">
												<label>Select Block <sup>*</sup></label>
												<select id="sel_bk" class="overviewselectbox">
													<option>Select Block</option>
												</select>
											</div>
										</div>
										<div class="col-sm-12">
											<div id="div_gp" class="selectdiv" style="display: none;">
												<label>Select GP <sup>*</sup></label>
												<select id="sel_gp" class="overviewselectbox">
													<option>Select GP</option>
												</select>
											</div>
										</div>
										<div class="col-sm-12">
											<div id="div_vl" class="selectdiv" style="display: none;">
												<label>Select Village <sup>*</sup></label>
												<select id="sel_vl" class="overviewselectbox">
													<option>Select Village</option>
												</select>
											</div>
										</div>
										<div class="col-sm-12">
											<div id="div_cr" class="selectdiv" style="display: none;">
												<label>Select Creche <sup>*</sup></label>
												<select id="sel_cr" class="overviewselectbox">
													<option>Select Creche</option>
												</select>
											</div>
										</div>
										<div class="col-sm-12 selectdiv">
											<label>Select Period</label>
											<select id="sel_period" class="overviewselectbox">
												<option value="till_month">Till Month</option>
												<option value="by_month">For Month</option>
											</select>
												<input id="sel_mnth_yr" type="text" class="form-control form-control-1 input-sm from" readonly="readonly" style="width:120px; margin-top: 5px;">
												<br>
												<button id="btn_submit_ovr" type="button" class="btn btn-default selectSubmitBtn" style="width: 120px; margin-bottom: 5px;">Submit</button>
										</div>
									</div>
								</div>
							</div>
							<!-- ******************* -->
							<div class=" col-md-7 col-sm-7 col-xs-12 div_chrt_mnt">
								<!-- <label id="lbl_indi"></label> -->
								<div id="div_chart" class="blue_Border mainChartDiv"></div>
							</div>
							<!-- ******************* -->
							<div class="col-md-3 col-sm-3 col-xs-12 right_sel_lbl">
								<div class="row">
									<div class="leftBoxFixed">
										<p class="selectivedLavel">Select Indicator</p>
									</div>
									<div class="leftBox">
										<!-- <div class="leftBoxFixed">
											<p>Select Indicator</p>
										</div> -->
										<div class="leftBoxUlLi">
											<ul id="indi_ul"></ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--------------------------------------------->
					<span class="splNote"><sup class="splSup">**</sup> Kindly note : Indicators related to Household Listing Form and Child Details Form Data are not associated with any creche. </span>
				</div>
			</section>
			<!-- Main Conta End --->
	
			<!-- footer -->
				<%@ include file="../footer.jsp" %>
			<!-- footer End -->
		
			<!-- # For Store User Id in Session -->
			<input type="hidden" id="hdUserRole" value=<%=request.getSession().getAttribute("role").toString() %>>
			<input type="hidden" id="hdUserId" value=<%=request.getSession().getAttribute("map_id").toString() %>>
			<input type="hidden" id="hdUserDt" value=<%=request.getSession().getAttribute("user_dt").toString() %>>
			<input type="hidden" id="hdUserBk" value=<%=request.getSession().getAttribute("user_bk").toString() %>>
			<input type="hidden" id="cur_date" value=<%=Utility.getCurrentDate() %> >			
		</section>
		
	    <script src="<%=getServletContext().getContextPath() %>/script_highcharts/highcharts.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_highcharts/grouped-categories.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_highcharts/venn.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_highcharts/exporting.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/monitoring/script/monitoring.js"></script>
	</body>
</html>