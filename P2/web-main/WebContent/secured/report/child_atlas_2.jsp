<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>|| Child Atlas 2 ||</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!--  Bootstrap CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link href="<%=getServletContext().getContextPath() %>/style/animate.min.css" rel="stylesheet">
	    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap-dropdownhover.min.css" rel="stylesheet">
	    <!--  Custom Style CSS -->
	    <link href="<%=getServletContext().getContextPath() %>/style/style.css" rel="stylesheet">
	    <!--  DataTable CSS -->
	    <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.css"/>
	
		<!-- JQuery -->
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/jquery.loadingModal.css">
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-1.12.4.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.js"></script>  
	    
	     <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-dropdownhover.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/jquery.loadingModal.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
	    
	    <script src="https://www.google.com/jsapi"></script>
	    <script type="text/javascript">
    		google.load("visualization", "1", {packages:["corechart"]});
			google.load("visualization", "1", {packages:["table"]});
    	</script>	    
    	
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
		
		<!--Header Start-->
			<%@ include file="../header.jsp" %>
		<!--Header End-->
		
		<!-- Main container -->
		<section id="childAtlasDiv" class="newchildatlasdiv">
			<div class="container-fluid">
				<input type="hidden" value="" id="child_code">
				<input type="hidden" value="" id="child_name">
				<input type="hidden" value="" id="file_id">
				<div class="row">
					<div class="topThreeSelctDiv">
						<div class="selectBoxDiv">
							<label>Select District <sup>*</sup> : </label>
							<select id="sel_dt" class="selectAwcBox selectAwcBoxFix blue_Border" onchange="popCombo('BK');"></select>
						</div>
						<div class="selectBoxDiv">
							<label>Select Block <sup>*</sup> : </label>
							<select id="sel_bk" class="selectAwcBox selectAwcBoxFix blue_Border" onchange="popCombo('Proj')"></select>
						</div>
						<div class="selectBoxDiv">
							<label>Select Project <sup>*</sup> : </label>
							<select id="sel_pjtprg" class="selectAwcBox selectAwcBoxFix blue_Border" onchange="popCombo('CR')"></select>
						</div>
						<div class="selectBoxDiv">
							<label>Select Creche <sup>*</sup> : </label>
							<select id="sel_cr" class="selectAwcBox selectAwcBoxFix blue_Border"></select>
						</div>
						<span>
							<button id="btn_go" type="button" class="btn btn-success goBtn" onclick="prepareNutriDataNew()">Go</button>
						</span>
					</div>
				</div>
				<div class="row">
					<!-- Left Div -->
					<div class="col-md-5 col-sm-4 col-xs-12">
						<div class="row">
							<!-- Start -->
							<div class="normal_moderate_severe">
			    				<table id="childStats" class="childStatsTable" style="display:table;">
			                     	<tr>
			                     		<td colspan="4" align="center">Count showing Current Month's WAZ Status</td>
			                     	</tr>
			                     	<tr>
			                        	<td class="normalLabel">
			                        		<label><b>N - </b></label>
			                        		<label>Normal</label>
			                        	</td>
										<td class="moderateLabel">
			                        		<label><b>M -</b> </label>
			                        		<label>Moderate</label>
			                        	</td>
			                        	<td class="severeLabel" style="">
			                        		<label><b>S - </b></label>
			                        		<label>Severe</label>
			                        	</td>
			                        	<td class="totalLabel" style="">
			                        		<label>Total</label>
			                        	</td>
							     	 </tr>
							     	 <tr>
			                        	<td class="normalValue">
			                        		<label id="normal">0</label>
			                        	</td>
										
										<td class="moderateValue">
			                        		<label id="moderate">0</label>
			                        	</td>
			                        	<td class="severeValue">
			                        		<label id="severe">0</label>
			                        	</td>
			                        	<td class="totalvalue">
			                        		<label id="total">0</label>
			                        	</td>
							     	 </tr>
			                  	</table>
						    </div>
							<!-- End -->
							<div id="div_back" class="backbtn" style="display: none">
								<!--<input type="button" id="btn_back" class="backprebtn" value="Show Previous 3 months">-->
								<button id="btn_back" class="backprebtn"><span><i class="fa fa-reply" aria-hidden="true"></i></span> Show Previous 3 months</button>
							</div>
							<div id="div_default" class="defaultkbtn" style="display: none">
								<!--<input type="button" id="btn_default" class="backprebtn" value="Show Last 6 months" disabled="disabled">-->
								<button id="btn_default" class="backprebtn" disabled="disabled">Show Last 6 months <span><i class="fa fa-share" aria-hidden="true"></i></span></button>
							</div>
							<div id="nutri2" class="leftTableDiv"></div>
						</div>
					</div>
					<!-- Left Div End -->
					<!-- Mid Div -->
					<div class="col-md-3 col-sm-4 col-xs-12">
						<div class="row">
							<input type="hidden" id="cntr"/> 
							<div class="midTabaleTopDiv">
								<div align="center" id="imgDiv" style="width: 100%; height: 175px; vertical-align: top; overflow:hidden;">
									<img id="imageView" name="imageView" style=" border: none; position: relative;top:5px;" onclick="rotateImage();" />
								</div>
							</div>
							<div class="midTabaleBotomDiv">
								<div id="info"></div>
							</div>
						</div>
					</div>
					<!-- Mid Div End -->
					<!-- Right Div -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="row">

							<div class="rightTableDiv">
								<div class="rightTableDiv_inn">
									
									<!-- Weight-for-age -->
									<div class="chatShowBox" id="ch1">
										<div id="tblChart" class="chatShowBox_inn">
											<div id="wfa_head" class="chatHeadLine" style="display:none;">
												Weight-for-age - Birth to 3 years
												<br/>
													<small>(As per WHO Child Growth Standards)</small>
											</div>
											<div class="chatbody">
												<div class="WFA_chartWithOverlay mainChartShowDiv">
													<div id="WFA_chart_div" class="mainChart"></div>
													<div id="WFA_legend" class="wfaLegendDiv chartLegendLink"  style="display:none;">
														<div class="sd3WFA">3</div>
														<div class="sd2WFA">2</div>
														<div class="sd1WFA">1</div>
														<div class="sdmWFA">Median</div>
														<div class="sd-1WFA">-1</div>
														<div class="sd-2WFA">-2</div>
														<div class="sd-3WFA">-3</div>
													</div>
												</div>
											</div>
											<div class="chartshowlink" style="display:none;" id="wfa_large">
												<a class="popUpText" onclick="enlarge_chart('1',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);"  style="">
												Click to enlarge Weight for Age.		
												</a>
											</div>
										</div>									
									</div>
									<!-- Weight-for-age END -->

									<!-- Weight-for-length -->
									<div id="ch2" class="chatShowBox">
										<div id="tblChart2" class="chatShowBox_inn">
											<div id="wfl_head" style="display:none;" class=" chatHeadLine chatHeadText">
												Weight-for-length/height - Birth to 3 years
												<br />
													<small>(As per WHO Child Growth Standards)</small>
											</div>
											<div class="chatbody">
												<div class="WFL_chartWithOverlay mainChartShowDiv">
													<div id="WFL_chart_div" class="mainChart"></div>
													<div id="WFL_legend" class="wflLegend chartLegendLink2" style="display:none;">
														<div class="sd3WFL">3</div>
														<div class="sd2WFL">2</div>
														<div class="sd1WFL">1</div>
														<div class="sdmWFL">Median</div>
														<div class="sd-1WFL">-1</div>
														<div class="sd-2WFL">-2</div>
														<div class="sd-3WFL">-3</div>
													</div>
												</div>
											</div>
											<div class="chartshowlink" style="display:none;" id="wfl_large" align="center">
												<a class="popUpText" onclick="enlarge_chart('2',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);">
												Click to enlarge Weight for Length / Height.							
												</a>
											</div>
										</div>
									</div>
									<!-- Weight-for-length END -->

									<!-- Height-for-age -->
									<div id="ch3" class="chatShowBox">	
										<div id="tblChart3" class="chatShowBox_inn">
											<div id="hfa_head" class=" chatHeadLine chatHeadText" style="display:none;">
												Length/height-for-age - Birth to 3 years
												<br />
													<small>(As per WHO Child Growth Standards)</small>
											</div>
											<div class="chatbody">
												 <div class="HFA_chartWithOverlay mainChartShowDiv">
													<div id="HFA_chart_div" class="mainChart"></div>
													<div id="HFA_legend" class="hfaLegend chartLegendLink3"  style="display:none;">
														<div class="sd3HFA">3</div>
														<div class="sd2HFA">2</div>
														<div class="sd1HFA">1</div>
														<div class="sdmHFA">Median</div>
														<div class="sd-1HFA">-1</div>
														<div class="sd-2HFA">-2</div>
														<div class="sd-3HFA">-3</div>
													</div>
												</div>
											</div>
											<div class="chartshowlink" id="hfa_large" align="center" style="display:none;">
												<a class="popUpText" onclick="enlarge_chart('3',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);">
												Click to enlarge Length/Height for Age.							
												</a>
											</div>
										</div>
									</div>
									<!-- Height-for-age END -->
									<input type="hidden" id="cntr"/>
								</div>
							</div>


						</div>
					</div>
					<!-- Right Div End -->
				</div>
			</div>
		</section>
		<input type="hidden" id="mother_cr">
		<!-- Main container END -->
		
		<!-- # For Store User Id in Session -->
		<input type="hidden" id="hdUserRole" value=<%=request.getSession().getAttribute("role").toString() %>>
		<input type="hidden" id="hdUserId" value=<%=request.getSession().getAttribute("map_id").toString() %>>
		<input type="hidden" id="hdUserDt" value=<%=request.getSession().getAttribute("user_dt").toString() %>>
		<input type="hidden" id="hdUserBk" value=<%=request.getSession().getAttribute("user_bk").toString() %>>
		<input type="hidden" id="cur_date" value=<%=Utility.getCurrentDate() %> >	
		
		<script src="<%=getServletContext().getContextPath() %>/script/jquery_rotate.js"></script>
		<%-- <script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.js"></script> --%>		
		<!-- <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> -->
		<script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.js"></script>
	    <!-- <script src="https://cdn.datatables.net/fixedcolumns/3.3.0/js/dataTables.fixedColumns.min.js"></script> -->
	    <script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.fixedColumns.min.js"></script>
		<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/report/script/child_atlas_2.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
		<!--footer-->
		<%@ include file="../footer.jsp" %>          
		<!--footer-->
		</section>
	</body>
</html>