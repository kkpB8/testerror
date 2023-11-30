<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
<head>
<title>|| Child Shifting ||</title>

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
	
	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
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
	<section id="bodyInner">
	<!-- Header -->
		<%@ include file="../header.jsp" %>
	<!-- Header End -->	
	
	<!-- Main Conta --->
		<section id="usermngTabletDiv">
			<div class="container-fluid">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="row">
						<h3 class="cm_Headline">Child Shifting</h3>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 cm_MainModifyDiv">
								<div class="row displayflex">
									<!-- Left Side -->
									<div class="col-md-6 col-sm-6 col-xs-12 cm_spldiv">
										<div class="cm_modifySDDiv blue_Border">
											<div class="leftBoxFixed">
												<p class="selectivedLavel">Select Child for Source Geography</p>
											</div>
											<!-- <h2>Select Child for Source Geography</h2> -->
											<div class="cm_modifySDDiv_inn">
												<div class="cm_modifySDDiv_col">
													<label>Select District <sup>*</sup></label>
													<select id="sel_dt_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Block <sup>*</sup></label>
													<select id="sel_bk_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select GP <sup>*</sup></label>
													<select id="sel_gp_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Village <sup>*</sup></label>
													<select id="sel_vl_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Creche <sup>*</sup></label>
													<select id="sel_cr_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Child <sup>*</sup></label>
													<select id="sel_ch_ch_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
											</div>
										</div>
									</div>
									<!-- Right Side -->
									<div class="col-md-6 col-sm-6 col-xs-12 cm_spldiv">
										<div class="cm_modifySDDiv blue_Border">
											<div class="leftBoxFixed">
												<p class="selectivedLavel">Select Child for Destination Geography</p>
											</div>
											<!-- <h2>Select Destination Geography</h2> -->
											<div class="cm_modifySDDiv_inn">
												<div class="cm_modifySDDiv_col">
													<label>Select District <sup>*</sup></label>
													<select id="sel_dt_ch_shf_des" class="cm_ComboBox blue_Border">
														
													</select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Block <sup>*</sup></label>
													<select id="sel_bk_ch_shf_des" class="cm_ComboBox blue_Border">
														
													</select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select GP <sup>*</sup></label>
													<select id="sel_gp_ch_shf_des" class="cm_ComboBox blue_Border">
														
													</select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Village <sup>*</sup></label>
													<select id="sel_vl_ch_shf_des" class="cm_ComboBox blue_Border">
														
													</select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Creche <sup>*</sup></label>
													<select id="sel_cr_ch_shf_des" class="cm_ComboBox blue_Border">
														
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="btnTwoDiv">
										<div class="leftSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_submit" onclick="shiftChild()">Submit</button>
											</div>
										</div>
										<div class="rightSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_reset" onclick="popComboDistChldShfSrc()">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</div>

			</div>
		</section>
	<!-- Main Conta End --->
	
		
	
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
	 	<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/admin/script/childshifting.js"></script>
	 	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
	
	</section>
</body>
</html>