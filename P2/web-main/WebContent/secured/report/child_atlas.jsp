
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="java.util.List"%>
<%@page import="com.rmspl.app.data.service.DataFetcher"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="utf-8">
		<!-- Always force latest IE rendering engine & Chrome Frame -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
		<title>|| Child Atlas ||</title>   
		
    	<!-- responsive and mobile friendly stuff -->
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<%--  <link href='<%=getServletContext().getContextPath() %>/style/style.css' rel="stylesheet" type="text/css" />  --%>
        <link href='<%=getServletContext().getContextPath() %>/style/styleNutri.css' rel="stylesheet" type="text/css" />
        <link href="<%=getServletContext().getContextPath() %>/style/style_desk_small.css" rel="stylesheet" media="all and (min-width: 800px) and (max-width: 1024px)">
        <link href="<%=getServletContext().getContextPath() %>/style/style_tab.css" rel="stylesheet" media="all and (min-width: 480px) and (max-width: 800px)">
        <link href="<%=getServletContext().getContextPath() %>/style/style_mobile.css" rel="stylesheet" media="all and (max-width: 480px)">
        
        <link rel="stylesheet" type="text/css" href='<%=getServletContext().getContextPath() %>/style/jqueryslidemenu.css' />
        <link rel="stylesheet" type="text/css" href='<%=getServletContext().getContextPath() %>/style/slicknav.css' />
		
		<!-- Bootstrap -->
	    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap.min.css" rel="stylesheet">
	    <link href="<%=getServletContext().getContextPath() %>/style/animate.min.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/bootstrap-dropdownhover.min.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/bootstrap-datepicker.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.css" rel="stylesheet">
    	<link href="<%=getServletContext().getContextPath() %>/style/style.css" rel="stylesheet">
	    
	    <!-- Local import -->	    
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/jquery.loadingModal.css">
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-1.12.4.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.js"></script>  
		
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    
	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap.min"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-dropdownhover.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-datepicker.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/jquery.loadingModal.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/jqueryslidemenu.js"></script>
	    <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootbox.js"></script>
	    
        <!--[if gte IE 9]>
          <style type="text/css">
            .header, .footer-bar {
               filter: none;
            }
          </style>
        <![endif]-->
        <!-- # For Total Child Count display--> 
        <style>
			 .tableClass,.oddTableClass,.selectedTableClass {
			 	font-size:10px;
			 }
			 .selectedTableClass {
				 	background-color:rgb(100,212,212);
				 }
			 @media all and (max-width:1024px){
			 	/* #WFA_legend{margin-top: 25px; border: 1px solid red;} */
			 	.tableClass,.oddTableClass,.selectedTableClass {
			 		font-size:10px;
			 	}
			 	.google-visualization-table-th{
			 		font-size:10px !important;
			 	}
			 	.selectedTableClass {
				 	font-size:10px !important;
				 	background-color:rgb(100,212,212);
				 }
			 }
			 .google-visualization-table-th{
			 	font-size:10px;
			 }
			 
			 .google-visualization-table-table{
			 	width: 100%;
			 }
        	 .google-visualization-table-td {
				text-align: center !important;
			 }
			.headerfont {
				background-color: '#9bd1df';
				font-size: 8px;
				text-align: 'center';
			}
			 .sd-3WFA, .sd-2WFA, .sd-1WFA, .sdmWFA, .sd1WFA, .sd2WFA, .sd3WFA, .sd-3HFA, .sd-2HFA, .sd-1HFA, .sdmHFA, .sd1HFA, .sd2HFA, .sd3HFA, .sd-3WFL, .sd-2WFL, .sd-1WFL, .sdmWFL, .sd1WFL, .sd2WFL, .sd3WFL {
			       width: 30px;
			       height: 20px;
			       position: absolute;
			       font-size: 8px;
			 } 
			 .sd-3WFA, .sd-2WFA, .sd-1WFA, .sdmWFA, .sd1WFA, .sd2WFA, .sd3WFA {
			       width: 30px;
			       height: 20px;
			       position: absolute;
			       font-size: 8px;
			 }			 		 
			 .google-visualization-table-th {
			 		font-size: 10px ;
			 }	
			 .google-visualization-table{
			 	width: 100%;
			 }		 
		</style>
	
    	
	    <script src="https://www.google.com/jsapi"></script>
	    <script type="text/javascript">
    		google.load("visualization", "1", {packages:["corechart"]});
			google.load("visualization", "1", {packages:["table"]});
    	</script>
	    
	    <% 	
			/* List<String[]> datas = DataFetcher.getData("select role_name, block_name, block_code from users_info where user_name = '"+request.getRemoteUser()+"'");
	        request.getSession().setAttribute("role", datas.get(0)[0]);
	        request.getSession().setAttribute("bk_name", datas.get(0)[1]);
	        request.getSession().setAttribute("bk_code", datas.get(0)[2]); */
		
			if(session.getAttribute("Hits") == null) {
		  		session.setAttribute("Hits", HitCounter.getHitCount());
		  	} 
			SimpleDateFormat formater = new SimpleDateFormat("MM-yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
		    //String curDate = formater.format(new Date());
		    String curDate = formater.format(cal.getTime());
		    
		     if(curDate.substring(0, 2).equalsIgnoreCase("01")){
		    	 curDate = "January"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("02")){
		    	 curDate = "February"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("03")){
		    	 curDate = "March"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("04")){
		    	 curDate = "April"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("05")){
		    	 curDate = "May"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("06")){
		    	 curDate = "June"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("07")){
		    	 curDate = "July"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("08")){
		    	 curDate = "August"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("09")){
		    	 curDate = "September"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("10")){
		    	 curDate = "October"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("11")){
		    	 curDate = "November"+curDate.subSequence(2, 7);
		     } else if(curDate.substring(0, 2).equalsIgnoreCase("12")){
		    	 curDate = "December"+curDate.subSequence(2, 7);
		     } 
		%>
  </head>
  <body>
  	<section id="bodyInner">
<!--Header Start-->
	<%@ include file="../header.jsp" %>
<!--Header End-->

<!-- Main container -->
<section id="childAtlasDiv">
	<div id="content">
		<div id="selCriteria">
			<input type="hidden" value="" id="child_code">
			<input type="hidden" value="" id="child_name">
			<input type="hidden" value="" id="file_id">

			<!-- select AWC -->
			<div class="selectBoxAwcDiv">
				<div id="divDist">
					<label>Select District :</label>
						<select id="sel_dt" class="selectAwcBox" onchange="popCombo('BK');"></select>
				</div>
			</div>
			<div class="selectBoxAwcDiv">
				<div id="divBk">
					<label>Select Block :</label>
						<select id="sel_bk" class="selectAwcBox" onchange="popCombo('CR')"></select>
				</div>
			</div>
			<div class="selectBoxAwcDiv">
				<div id="divCr">
					<label>Select Creche :</label>
						<select id="sel_cr" class="selectAwcBox"></select>
					
				</div>
				<div class="divAwc_noCat">

				</div>
			</div>
			<span class="goBtnDiv">
				<!-- <button id="btn_go" type="button" class="btn btn-success goBtn" onclick="prepareNutriData()">Go</button> -->
				<button id="btn_go" type="button" class="btn btn-success goBtn" onclick="prepareNutriDataNew()">Go</button>
			</span>
		</div>
<!-- ************************************************************* -->
<div id="dispArea">
                     		<div id="divLeft">
                     			<div id="pic">
                     				<table style="width: 100%;">
										<tr>
											<td id="tdLeft">
												<!-- <div id="tble_header_div">
													<div class="left_header_div"><label>Weight for Age status</label></div>
													<div class="right_header_div"><label>Anthro Indicators</label></div>
												</div> -->
												<div id="div_back" class="backbtn" style="display: none">
											    	<input type="button" id="btn_back" value="Back">
											    </div>
											    <div id="div_default" class="defaultkbtn" style="display: none">
											    	<input type="button" id="btn_default" value="Default" disabled="disabled">
											    </div>
												<div id="nutri"></div>
												<!-- <div class="normal_moderate_severe">
								    				<table id="childStats" class="childStatsTable">
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
								                        	
												     	 </tr>
												     	 
												     	ind. count 
												     	 <tr>
								                        	<td class="normalValue">
								                        		<label id="normal"></label>
								                        	</td>
															
															<td class="moderateValue">
								                        		<label id="moderate"></label>
								                        	</td>
								                        	
								                        	<td class="severeValue">
								                        		<label id="severe"></label>
								                        	</td>
								                        	
												     	 </tr>
												     	 
												     	 total count
												     	 <tr>
								                        	<td colspan="4" class="totalvalue">
								                        		<label id="total"></label>
								                        	</td>
															
												     	 </tr>
								                  </table>
							                  	</div> -->
											</td>
										</tr>
										<tr style="display: none;">
											<td style="vertical-align: top; height:30px; background-color: transparent;" align="center">
												<input type="hidden" disabled="disabled" name="refresh" id="refresh" value="Refresh List" onclick="refresh();" />

												<input type="hidden" disabled="disabled" name="sort_age" id="sort_age" value="Sort by Age" onclick="refresh();" />
											</td>
										</tr>
									</table>
                     			</div>
                     		</div>
                 <!------------------------------ IMAGES ----------------->
                     		<div id="divMiddle">
                     			<div>
                     				<input type="hidden" id="cntr"/> 
                     				<table style="width: 100%;">
										 <tr>
											<td width="50%" style="height: 175px; vertical-align: top; border-bottom: 1px solid black; background-color: transparent;">
												 <div align="center" id="imgDiv" style="width: 100%; height: 175px; vertical-align: top; overflow:hidden;">
													<img id="imageView" name="imageView" style=" border: none; position: relative;top:5px;" onclick="rotateImage();" />
												</div> 
											</td>
										</tr> 
										<tr>
											<td id="tdInfo">
												<div id="info"></div>
											</td>
										</tr>
										
									</table>
                     			</div>
                     		</div>
                 <!------------------------------ IMAGES ----------------->
                     		
                     		<div id="divRight">
                     			<div id="weight_height"></div>
                     			<div>
                     			<div id="ch1">
                     				<table id="tblChart">
                     				
                     				<!-- Weight-for-age -->
										<tr class="trHeight">
											<td class="tdText">
												<div id="wfa_head" class="chatHeadText">
													Weight-for-age - Birth to 3 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>
										<tr class="trHeightMain">
											<td style="width: 50%; vertical-align: middle; text-align: center;">
												<div style="width: 100%; margin: 0 auto;">
													<div class="WFA_chartWithOverlay" style="background-color: transparent;">
														<div id="WFA_chart_div" style="width: 90%; height: 300px; background-color: transparent;"></div>
														<div id="WFA_legend" class="wfaLegendDiv"  style="display:none; background-color: transparent;">
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
												<br />
												<div style="display:none; text-align: center;" id="wfa_large">
													<a class="popUpText" onclick="enlarge_chart('1',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);"  style="">
														Click to enlarge Weight for Age.							
													</a>
												</div>
											</td>
										</tr>	
									</table>
									<!-- arrow -->
										<div id="arow_right" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/next.png"></div>
									<!-- arrow -->
									<!-- Weight-for-age -->
									</div>
																		
									<div id="ch2">
									<!-- Weight-for-length -->		
									<table id="tblChart2">								
										<tr style="height: 20%">
											<td style="font-size: 12px; text-align: center;">
												<div id="wfl_head" style="display: none;" class="chatHeadText">
													Weight-for-length/height - Birth to 3 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>	
										<tr>
											<td style="width: 90%; vertical-align: middle; text-align: center; height:300px;">
												<div style="width: 100%; margin: 0 auto;">
													<div class="WFL_chartWithOverlay" style="background-color: transparent;">
														<div id="WFL_chart_div" style="width: 90%; height: 300px; background-color: transparent;"></div>
														<div id="WFL_legend" class="wflLegend"  style="display:none">
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
											</td>
										</tr>
										<tr>
											<td style="vertical-align: top; height: 10px;">
												<div class="wflLargeDiv" style="" id="wfl_large" align="center">
													<a class="popUpText" onclick="enlarge_chart('2',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);">
													Click to enlarge Weight for Length / Height.							
													</a>
												</div>
											</td>
										</tr>
									</table>
									<!-- arrow -->
										<div id="arow_right_2" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/next.png"></div>
    									<div id="arow_left_2" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/previous.png"></div>
									<!-- arrow -->
									<!-- Weight-for-length -->
									</div>
									
									<div id="ch3">
									<!-- Height-for-age -->
									<table id="tblChart3">
										<tr style="height: 20%">
											<td style="font-size: 12px; text-align: center;">
												<div id="hfa_head" style="display: none;" class="chatHeadText">
													Length/height-for-age - Birth to 3 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>								
										<tr>
											<td style="width: 50%; vertical-align: middle; text-align: center;">
												 <div style="width: 100%; margin: 0 auto;">
													 <div class="HFA_chartWithOverlay">
														<div id="HFA_chart_div" style="width: 90%; height: 300px; background-color: transparent;">	</div>
														<div id="HFA_legend" class="hfaLegend"  style="display:none">
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
											</td>
										</tr>
										<tr>
											<td style="vertical-align: top; height: 10px;">
												<div class="hfaLargeDiv" id="hfa_large" align="center">
													<a class="popUpText" onclick="enlarge_chart('3',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);">
													Click to enlarge Length/Height for Age.							
													</a>
												</div>
											</td>
										</tr>
									</table>
									<!-- arrow -->
										<div id="arow_left_3" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/previous.png"></div>	
									<!-- arrow -->	
									<!-- Height-for-age -->
									</div>	
														
									
                     			</div>	
                     		</div>
	    				</div>
<!-- ************************************************************* -->
	</div>
	<input type="hidden" id="mother_cr">
</section>
<!-- Main container End -->
<!--footer-->
	<%@ include file="../footer.jsp" %>          
<!--footer-->
    


<%--
<!-- <body onload="popSectorDashBoard();"> -->
  	  <body>
  	  <!-- loading -->
		<!-- <div id = "loading_bg"></div>
		<p id="loading"><span>L </span><span>o </span><span>a </span><span>d </span><span>i </span><span>n </span><span>g</span></p> -->
	  <!-- loading -->
            <div class="wrapper">
                <div id="page-container">
                <!--header-->
                    <%@ include file="../header.jsp" %>
                <!--header-->
              	
              	<!--menu-->
    				  <%-- <%@ include file="../menu.jsp" %> --%> 
              	<!--menu-->
              	
                <!--content-->
                    <!--<div id="content">  
                     	<div id="selCriteria">
	                     	<input type="hidden" value="" id="child_code">
	                     	<input type="hidden" value="" id="child_name">
	                     	<input type="hidden" value="" id="file_id">-->
	                     	
                     	 	<!-- select sector -->
                         	<!-- <div id="divSect">
                         		<label>Select Beat :</label>
                         		<input type="text" readonly="readonly" id="sector" style="width: 190px; position: relative;">
                         		<select name="sector" id="sector" onchange="popAwcDashBoard('2');" style="min-width: 150px;">
                         		</select>
                       		</div> -->
                       		<!-- select sector -->
                         
                         	<!-- select AWC -->
                         	<!-- <div id="divAwc_noCat">
                         		<label>Select AWC :</label>
                         		<div>
	                         		<select name="awc" id="awc" onchange="" style="min-width: 150px;">
	                         		</select>
                         		</div>
                         		&nbsp;
                         		<input id="Proceed" class="hvr-pop" type="button" value="Go" style="width: 50px;" onclick="prepareNutriData()" title="Show Chart" />
                     		</div> -->
                         	<!-- select AWC -->
                         	
                         	<!--<div id="divDist">
		        				<label style="margin-top:1.5%;">Select District :</label>
		        				<select id="sel_dt" style="min-width: 150px;" onchange="popCombo('BK');">-->
		        					<!-- <option value="">Select</option> -->
		        				<!--</select>
		        			</div>
		        			<div id="divBk">
		        				<label style="margin-top:1.5%;">Select Block :</label>
		        				<select id="sel_bk" style="min-width: 150px;" onchange="popCombo('CR')">-->
		        					<!-- <option value="">Select</option> -->
		        				<!--</select>
		        			</div>
		        			<div id="divCr">
		        				<label style="margin-top:1.5%;">Select Creche :</label>
		        				<select id="sel_cr" style="min-width: 150px;">-->
		        					<!-- <option value="">Select</option> -->
		        				<!--</select>
		        				<button id="btn_go" type="button" class="btn btn-success" onclick="prepareNutriData()" style="background:#008f4a;color:white;">Go</button>
		        			</div>
		        			<div class="divAwc_noCat">
		        				
		        			</div>
                         	
                         	
                         	
                     	</div>-->
                     	<!-- <br />  -->                    	
                     	<!--<div id="dispArea">
                     		<div id="divLeft">
                     			<div id="pic">
                     				<table style="width: 100%;">
										<tr>
											<td id="tdLeft">
												<div id="tble_header_div">
													<div class="left_header_div"><label>Weight for Age status</label></div>
													<div class="right_header_div"><label>Anthro Indicators</label></div>
												</div>
												<div id="nutri"></div>
												<div style="width: 100%;vertical-align: bottom;">
								    				<table id="childStats" style="display: none; width: 100%; margin: 0 auto; font-size: 9pt; border-collapse: collapse;">
								                        <tr>
								                        	<td style="text-align: center; background-color: #34DC8C;">
								                        		<label style="font-weight: bold;">N - </label>
								                        		<label>Normal</label>
								                        	</td>
															
															<td style="text-align: center; background-color: #F2FE67;">
								                        		<label style="font-weight: bold;">M - </label>
								                        		<label>Moderate</label>
								                        	</td>
								                        	
								                        	<td style="text-align: center; background-color: #FF4646">
								                        		<label style="font-weight: bold;">S - </label>
								                        		<label>Severe</label>
								                        	</td>-->
								                        	
								                        	<!-- <td style="text-align: center; background-color: #6a9da9">
								                        		<label style="font-weight: bold;">O - </label>
								                        		<label>Overweight</label>
								                        	</td> -->
												     	 <!--</tr>-->
												     	 
												     	<!-- ind. count --> 
												     	 <!--<tr>
								                        	<td style="text-align: center; background: #ffffff; border-right: 1px black solid; border-bottom: 1px black solid; border-top: 1px black solid;">
								                        		<label id="normal"></label>
								                        	</td>
															
															<td style="text-align: center; background: #ffffff; border-right: 1px black solid; border-bottom: 1px black solid; border-top: 1px black solid;">
								                        		<label id="moderate"></label>
								                        	</td>
								                        	
								                        	<td style="text-align: center; background: #ffffff; border-right: 1px black solid; border-bottom: 1px black solid; border-top: 1px black solid;">
								                        		<label id="severe"></label>
								                        	</td>-->
								                        	
								                        	<!-- <td style="text-align: center; background: #ffffff; border-bottom: 1px black solid; border-top: 1px black solid;">
								                        		<label id="over"></label>
								                        	</td> -->
												     	 <!--</tr>-->
												     	 
												     	 <!-- total count -->
												     	 <!--<tr>
								                        	<td colspan="4" style="text-align: center; background: #ffffff;">
								                        		<label id="total"></label>
								                        	</td>
															
												     	 </tr>
								                  </table>
							                  	</div>
											</td>
										</tr>
										<tr style="display: none;">
											<td style="vertical-align: top; height:30px; background-color: transparent;" align="center">
												<input type="hidden" disabled="disabled" name="refresh" id="refresh" value="Refresh List" onclick="refresh();" />
												<input type="hidden" disabled="disabled" name="sort_age" id="sort_age" value="Sort by Age" onclick="refresh();" />
											</td>
										</tr>
									</table>
                     			</div>
                     		</div>
                     		
                     		<div id="divMiddle">
                     			<div>
                     				<input type="hidden" id="cntr"/> 
                     				<table style="width: 100%;">
										 <tr>
											<td width="50%" style="height: 175px; vertical-align: top; border: 1px solid black; background-color: transparent;">
												 <div align="center" id="imgDiv" style="width: 100%; height: 175px; vertical-align: top; overflow:hidden;">
													<img id="imageView" name="imageView" style=" border: none; position: relative;top:5px;" onclick="rotateImage();" />
												</div> 
											</td>
										</tr> 
										<tr>
											<td id="tdInfo">
												<div id="info" style="overflow-y: scroll;"></div>
											</td>
										</tr>-->
										<!-- <tr>
											<td align="center" width="50%" style="vertical-align: top; background-color: transparent;">
												<div style="width: 100%; height: 20px; vertical-align: top;">
													<input class="hvr-pop" type="button" name="generate" id="generate" value="Generate Report" onclick="gen_report();" />
													<input class="hvr-pop" type="button" name="" id="" value="Generate Cohort" onclick="genCohotReport();" />
												</div>
											</td>
										</tr> -->
									<!--</table>
                     			</div>
                     		</div>
                     		
                     		<div id="divRight">-->
                     			<!-- <div id="weight_age"></div> -->                     			
                     			<!-- <div id="height_age"></div> -->
                     			<!--<div id="weight_height"></div>
                     			<div>
                     			<div id="ch1">
                     				<table id="tblChart">-->
                     				
                     				<!-- Weight-for-age -->
										<!--<tr style="height: 20%">
											<td style="font-size: 12px; text-align: center;">
												<div id="wfa_head" style="display: none;">
													Weight-for-age - Birth to 5 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>
										<tr style="height: 80%;">
											<td style="width: 50%; vertical-align: middle; text-align: center;">
												<div style="width: 100%; margin: 0 auto;">
													<div class="WFA_chartWithOverlay" style="background-color: transparent;">
														<div id="WFA_chart_div" style="width: 90%; height: 300px; background-color: transparent;"></div>
														<div id="WFA_legend"  style="display:none; background-color: transparent;">
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
												<br />
												<div style="display:none; text-align: center;" id="wfa_large">
													<a onclick="enlarge_chart('1',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);" style="text-decoration: underline; color: blue; font-size: 8.5pt; cursor: pointer;">
														Click to enlarge Weight for Age.							
													</a>
												</div>
											</td>
										</tr>	
									</table>-->
									<!-- arrow -->
										<!--<div id="arow_right" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/next.png"></div>-->
									<!-- arrow -->
									<!-- Weight-for-age -->
									<!--</div>
																		
									<div id="ch2">-->
									<!-- Weight-for-length -->		
									<!--<table id="tblChart2">								
										<tr style="height: 20%">
											<td style="font-size: 12px; text-align: center;">
												<div id="wfl_head" style="display: none;">
													Weight-for-length/height - Birth to 5 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>	
										<tr>
											<td style="width: 90%; vertical-align: middle; text-align: center; height:300px;">
												<div style="width: 100%; margin: 0 auto;">
													<div class="WFL_chartWithOverlay" style="background-color: transparent;">
														<div id="WFL_chart_div" style="width: 90%; height: 300px; background-color: transparent;"></div>
														<div id="WFL_legend"  style="display:none">
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
											</td>
										</tr>
										<tr>
											<td style="vertical-align: top; height: 10px;">
												<div style="height: 10px; display:none; position: relative; bottom: 20px;" id="wfl_large" align="center">
													<a onclick="enlarge_chart('2',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);" style="text-decoration: underline; color: blue;  font-size: 8.5pt; position: relative; bottom: 6px; cursor: pointer;">
													Click to enlarge Weight for Length / Height.							
													</a>
												</div>
											</td>
										</tr>
									</table>-->
									<!-- arrow -->
										<!--<div id="arow_right_2" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/next.png"></div>
    									<div id="arow_left_2" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/previous.png"></div>-->
									<!-- arrow -->
									<!-- Weight-for-length -->
									<!--</div>
									
									<div id="ch3">-->
									<!-- Height-for-age -->
									<!--<table id="tblChart3">
										<tr style="height: 20%">
											<td style="font-size: 12px; text-align: center;">
												<div id="hfa_head" style="display: none;">
													Length/height-for-age - Birth to 5 years
													<br />
													<small>(As per WHO Child Growth Standards)</small>
												</div>	
											</td>
										</tr>								
										<tr>
											<td style="width: 50%; vertical-align: middle; text-align: center;">
												 <div style="width: 100%; margin: 0 auto;">
													 <div class="HFA_chartWithOverlay">
														<div id="HFA_chart_div" style="width: 90%; height: 300px; background-color: transparent;">	</div>
														<div id="HFA_legend"  style="display:none">
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
											</td>
										</tr>
										<tr>
											<td style="vertical-align: top; height: 10px;">
												<div style="height: 10px; display:none; position: relative; bottom: 20px;" id="hfa_large" align="center">
													<a onclick="enlarge_chart('3',document.getElementById('file_id').value,document.getElementById('gender').innerHTML);" style="text-decoration: underline; color: blue;  font-size: 8.5pt; position: relative; bottom: 6px; cursor: pointer;">
													Click to enlarge Length/Height for Age.							
													</a>
												</div>
											</td>
										</tr>
									</table>-->
									<!-- arrow -->
										<!--<div id="arow_left_3" style="height: 80px;"><img src="<%=getServletContext().getContextPath() %>/images/previous.png"></div>-->	
									<!-- arrow -->	
									<!-- Height-for-age -->
									<!--</div>	
														
									
                     			</div>	
                     		</div>
	    				</div>
			         </div> 
			         <br />--> 
			                                         	
                <!--content--> 			                                	     
                    <!--<div class="push"></div>
                </div>
            </div> 
            <input type="hidden" id="mother_cr">-->
<!--wrapper ends-->
	<!--footer-->
            <!--<%@ include file="../footer.jsp" %>          -->
    <!--footer-->
    
    	<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
	  	<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
    	<!--<script src="<%=getServletContext().getContextPath() %>/script/jquery_rotate.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/jquery.slicknav.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/report/script/child_atlas.js"></script>	    
    </body>-->




</section>
    	<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
	  	<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
    	<script src="<%=getServletContext().getContextPath() %>/script/jquery_rotate.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/jquery.slicknav.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.js"></script>
	    <!-- <script src="https://cdn.datatables.net/fixedcolumns/3.3.0/js/dataTables.fixedColumns.min.js"></script> -->
	    
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/report/script/child_atlas.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
  </body>
</html>