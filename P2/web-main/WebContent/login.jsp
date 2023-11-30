<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		
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
	   <%--  <link href="<%=getServletContext().getContextPath() %>/style/large_style.css" rel="stylesheet"> --%>
	   
	   <!-- Local import -->
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/style/jquery.loadingModal.css">
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-1.12.4.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/jquery/jquery-ui.js"></script>  
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <script src="<%=getServletContext().getContextPath() %>/translate/Translate.js"></script>
	    
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-dropdownhover.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-datepicker.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/jquery.loadingModal.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootbox.js"></script>
	</head>
	<body>
		<!-- Header -->
	   	<%@ include file="header.jsp" %>
	    <!-- Header End -->
	      
	    <!-- Body Cont -->
	    <section id="contentmain">
	    	<div class="container-fluid">
	        	<div class="row twoDiv">
	          		<!-- Left Box -->
	          		<div class="col-md-6 col-sm-6 col-xs-12">
	            		<div class="login_leftbox">
							<!------------------------------------------------------>
							<div class="loginbanner">
					  			<!-- <img src="<%=getServletContext().getContextPath() %>/images/banner_img_1.jpg" alt="..." class="bannerlog"> -->
								<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox">
										<div class="item active">
											<img src="<%=getServletContext().getContextPath() %>/images/banner_1.jpg" alt="..." class="sliderimg">
										</div>
										<div class="item">
											<img src="<%=getServletContext().getContextPath() %>/images/banner_2.jpg" alt="..." class="sliderimg">
										</div>
										<div class="item">
											<img src="<%=getServletContext().getContextPath() %>/images/banner_3.jpg" alt="..." class="sliderimg">
										</div>
									</div>

									<!-- Controls -->
									<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
										<span class="glyphicon glyphicon-menu-left preBtn" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a>
									<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
										<span class="glyphicon glyphicon-menu-right nextBtn" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>
							</div>
							<!------------------------------------------------------------>
			                <p>
			                	<!-- In order to attain the larger goal and commitment to reduce the malnutrition in Odisha, 
			                	APPI is supporting PHRN for implementation of the Programme "Mainstreaming of Creches to 
			                	Reduce Malnutrition in Odisha". -->
			                	
			                	‘Mainstreaming Crèches to Reduce Malnutrition in Odisha’ is a collaborative initiative 
			                	between Public Health Resource Society (PHRS) and Azim Premji Philanthropic Initiatives’ (APPI), 
			                	with support from the Government of Odisha, which seeks to address the high levels of 
			                	malnutrition among children below three years. The programme is currently underway in 
			                	five districts of Southern Odisha (Rayagada, Kalahandi, Malkangiri, Koraput, and Nabarangpur). 
			                	This Web system is a real-time representation of the creches and presents evidence and data 
			                	that can be used for planning, result-driven programme evaluation, activity monitoring, 
			                	and overall programme implementation. It is an accompaniment to a unique app that is used 
			                	at the field-level for data entry.
			                	
			                	<a href="" data-toggle="modal" data-target="#myModal">Read More [...]</a>
			                </p>
	            		</div>
						<!------------------------------------------------------------------------------->
						<!-- Modal -->
						<div id="myModal" class="modal fade" role="dialog">
						  <div class="modal-dialog splModalDiv">
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">About e-Kalika Creche MIS Project</h4>
						      </div>
						      <div class="modal-body">
						          <p>
							      	  <!-- The Web system is a robust framework to make evidence based data available on real-time for planning, 
							          result driven programme evaluation, strengthened activity monitoring and better programme implementaion. 
							          In order to attain the larger goal and commitment to reduce the malnutrition in Odisha.APPI has been 
							          supporting PHRN for implementation of the Programme "Mainstreaming of Creches to Reduce Malnutrition in Odisha". 
							          The Web system is a robust framework to make evidence based data available on real-time for planning, result 
							          driven programme evaluation, strengthened activity monitoring and better programme implementaion. -->
							          
							          ‘Mainstreaming Crèches to Reduce Malnutrition in Odisha’ is a collaborative initiative 
							          between Public Health Resource Society (PHRS) and Azim Premji Philanthropic Initiatives’ (APPI), 
							          with support from the Government of Odisha, which seeks to address the high levels of 
							          malnutrition among children below three years. The programme is currently underway in 
							          five districts of Southern Odisha (Rayagada, Kalahandi, Malkangiri, Koraput, and Nabarangpur). 
							          This Web system is a real-time representation of the creches and presents evidence and data 
							          that can be used for planning, result-driven programme evaluation, activity monitoring, 
							          and overall programme implementation. It is an accompaniment to a unique app that is used 
							          at the field-level for data entry.							          
						          </p>
						          <p>
						         	  Crèches are decentralised community-based centres where mothers leave their children when 
						         	  they go for work.  The crèches provide a safe and secure environment for the overall growth 
						         	  and development of children through care, feeding, and health promotion. The children are 
						         	  kept nourished and healthy and sick children are identified and referred to the hospital 
						         	  for care. The crèche helps elder siblings attend school and supports women’s work and 
						         	  thereby increases the household income. The dashboard in this web page links to a 
						         	  comprehensive overview of the programme, while also providing demographic, anthropometric 
						         	  and operational details at several levels.
						          </p>
						          <p>
						          	  Please contact PHRS [delhi@phrnindia.org] and APPI [roopesh@azimpremjiphilanthropicinitiatives.org] 
						          	  for programmatic details and RIDDHI [info@riddhi.org] for technical information about the dashboard.
						          </p>
						      </div>
						      <!--<div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>-->
						    </div>
						  </div>
						</div>
						<!------------------------------------------------------------------------------->              
	          		</div>
		          	<!-- Right Box -->
					<div class="col-md-6 col-sm-6 col-xs-12">
		            	<div class="login_rightbox_inn">
		              		<div class="loginfrmDiv">
		                		<h4>Please login to proceed</h4>
		                		<form name="uform" id="uform" style="height: 100%;" action="<%=getServletContext().getContextPath() %>/j_security_check" enctype="multipart/form-data">
		                  			<label><input type="text" name="j_username" id="j_username" placeholder="Username" class="textbox" autocomplete="off" autofocus required></label>
		                  			<label><input type="password" name="j_password" id="j_password" placeholder="Password" class="textbox" autocomplete="off" required></label>
		                  			<label><input type="submit" class="subbtn" value="Login" name="" name="log" id="log"></label>
		                		</form>
		              		</div>
		              		<div class="login_rightbox">
		                		<h3>Important Documents</h3>
		                		<div class="marqueeDiv">
		                    		<%-- <p class="downloadlink"><a href="<%=getServletContext().getContextPath()%>/user_guide/Creche_Manual_Operational_Guideline.pdf"><span><i class="fa fa-download" aria-hidden="true"></i></span>  Download User Guide</a></p> --%>
		                    		<%-- <p class="marqueetext_inn"><span><i class="fa fa-info-circle" aria-hidden="true"></i></span>  <a href="<%=getServletContext().getContextPath()%>/user_guide/Creche_Manual_Operational_Guideline.pdf" target="_blank">Creche Operational Manual</a></p> --%>
		                    		<!-- <p class="marqueetext_inn"><span><i class="fa fa-info-circle" aria-hidden="true"></i></span>  <a href="#">Presentation No...</a></p>
		                    		<p class="marqueetext_inn"><span><i class="fa fa-info-circle" aria-hidden="true"></i></span>  <a href="#">Write Up No...</a></p> -->
			                    	<div id="div_download_link" style="max-height: 280px; overflow-x: hidden;"></div>                                  
		                		</div>
		              		</div>
		            	</div>
		          	</div>
	        	</div>
	      	</div>
	    </section>
	    <!-- Body Cont End -->
	    
	    <script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/login.js"></script>
	
	    <!-- Footer -->
	      <%@ include file="footer.jsp" %>
	    <!-- Footer End -->
	
	     <script>
	         $(function() {
	        	    $('marquee').mouseover(function() {
	        	        $(this).attr('scrollamount',0);
	        	    }).mouseout(function() {
	        	         $(this).attr('scrollamount',2);
	        	    });
	        	});
		</script>
	</body>
</html>