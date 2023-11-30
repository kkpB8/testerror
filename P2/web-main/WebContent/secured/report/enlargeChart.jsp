<%@page import="java.util.List"%>
<%@page import="com.rmspl.app.data.service.DataFetcher"%>
<!DOCTYPE html>
<html>
	<head>
    	<title>|| Child Atlas ||</title>   
        <link href='<%=getServletContext().getContextPath() %>/style/style.css' rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href='<%=getServletContext().getContextPath() %>/style/jqueryslidemenu.css' />
        <link rel="stylesheet" type="text/css" href='<%=getServletContext().getContextPath() %>/style/StyleCalender.css' />
        <!--[if gte IE 9]>
          <style type="text/css">
            .header, .footer-bar {
               filter: none;
            }
          </style>
        <![endif]-->
        <!-- # For Total Child Count display--> 
        <style>
			.headerfont {
				background-color: '#9bd1df';
				font-size: 10px;
				text-align: 'center';
			}
			.sd-3WFA, .sd-2WFA, .sd-1WFA, .sdmWFA, .sd1WFA, .sd2WFA, .sd3WFA, .sd-3HFA, .sd-2HFA, .sd-1HFA, .sdmHFA, .sd1HFA, .sd2HFA, .sd3HFA, .sd-3WFL, .sd-2WFL, .sd-1WFL, .sdmWFL, .sd1WFL, .sd2WFL, .sd3WFL, .pic1 {
			       width: 30px;
			       height: 20px;
			       position: absolute;
			       font-size: 10px;
			 }
			 .google-visualization-table-th {
			 		font-size: 10px;
			 }
		</style>
	
    	
	    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
	    <script type="text/javascript">
    	google.load("visualization", "1", {packages:["corechart"]});
		google.load("visualization", "1", {packages:["table"]});
      	
    	</script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/report/script/enlargeChart.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/jqueryslidemenu.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
	    <script type="text/javascript" src="<%=getServletContext().getContextPath() %>/script/CalendarControl.js"></script>
	    
  </head>
  <%if(request.getParameter("gender").equalsIgnoreCase("Boy")){ %>
  	<body onload="enlargedChart('<%=request.getParameter("mode") %>','<%=request.getParameter("child_code") %>','<%=request.getParameter("child_name") %>','<%=request.getParameter("gender") %>','<%=request.getParameter("file_id") %>');" style="background-color: #fffcd5;">
  <%} else { %>
  	<body onload="enlargedChart('<%=request.getParameter("mode") %>','<%=request.getParameter("child_code") %>','<%=request.getParameter("child_name") %>','<%=request.getParameter("gender") %>','<%=request.getParameter("file_id") %>');" style="background-color: #fffcd5;">
  <%} %>
  	
   		<input type="hidden" id="chart" />
   		<div align="center" style="width: 100%;">
          <table style="width: 85%; height: 80%; margin: 0 auto; vertical-align: center; border-collapse: collapse; border: 1px black solid;">
          	<tr>
          		<td colspan="4">
          		<%if(request.getParameter("gender").equalsIgnoreCase("Boy")) {%>
					<%-- <img id="header" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
					<img id="header2" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b_wfl.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
					<img id="header3" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b_hfa.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" /> --%>
					<img id="header" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
					<img id="header2" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b_wfl_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
					<img id="header3" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_b_hfa_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
       			<%} else { %>	
  					<%-- <img id="header" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
  					<img id="header2" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g_wfl.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
  					<img id="header3" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g_hfa.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" /> --%>
  					<img id="header" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
  					<img id="header2" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g_wfl_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
  					<img id="header3" name="header" src="<%=getServletContext().getContextPath() %>/images/enlrg_hd_g_hfa_eng.png" style="background-repeat: no-repeat; border: 1px black solid; display:none" />
       			<%} %>
       			</td>          		
          	</tr>
          	<tr>
				<td align="center" colspan="4" style="width: 100%; vertical-align: top; background-color: white;">
					<div>
						<div class="<%=request.getParameter("mode_value") %>_chartWithOverlay" style="background-color: transparent;">
							<div style="width: 100%; height: 425px; background-color: #ffffff;">
								<div id="<%=request.getParameter("mode_value") %>_chart_div" style="width: 632px; height: 402px; background-color: transparent;"></div>
								<div id="<%=request.getParameter("mode_value") %>_legend"  style="display:none; background-color: transparent;">
									<div class="sd3<%=request.getParameter("mode_value") %>">3SD</div>
									<div class="sd2<%=request.getParameter("mode_value") %>">2SD</div>
									<div class="sd1<%=request.getParameter("mode_value") %>">1SD</div>
									<div class="sdm<%=request.getParameter("mode_value") %>">Median</div>
									<div class="sd-1<%=request.getParameter("mode_value") %>">-1SD</div>
									<div class="sd-2<%=request.getParameter("mode_value") %>">-2SD</div>
									<div class="sd-3<%=request.getParameter("mode_value") %>">-3SD</div>
									<%-- <div class="pic1"><img id="pic" name="pic" src="<%=getServletContext().getContextPath() %>/images/pic1.png" style="height: 100px; width: 200px; border: none;" /></div> --%>
									<%if(request.getParameter("gender").equalsIgnoreCase("Male")) {%>
										<div class="pic1" style="width: 150px; height: auto;">
											<img id="imageView" name="imageView" style="height: 70px; width: auto; border: none; display: inline; " />
										</div>
				          			<%} else { %>	
				          				<div class="pic1" style="width: 150px; height: auto;">
				          					<img id="imageView" name="imageView" style="height: 70px; width: auto; border: none; display: inline;" />
				          				</div>
				          			<%} %>
								</div>
								<div style="width: 100%; text-align: center; border-top: 1px grey solid;"><small><a href="javascript:" onclick="window.print();">Print</a></small></div>
							</div>
						</div>
					</div>
				</td>
			</tr>
           </table>
           </div>    
  
  </body>
</html>