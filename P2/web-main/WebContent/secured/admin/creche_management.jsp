<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
<head>
<title>|| Creche Management ||</title>

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
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 contentdetails">			
						<ul class="nav-tabs nav-tabs_ul userMngTablet_TabsUl">
							<li class="active" data-toggle="tab"><a href="javascript:" onclick="showHideDiv('A');" title="Create User">Create Creche</a></li>
							<li data-toggle="tab"><a href="javascript:" onclick="showHideDiv('D');" title="Delete User">Delete Creche</a></li>
							<li data-toggle="tab"><a href="javascript:" onclick="showHideDiv('S');" title="Modify User">Shift Creche</a></li>
						</ul>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<!-- ****************************************************************** -->
						<!-- # Work For Create Creche -->
						<div id="div_cr_mgnt_add" class="allShowTableDiv">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="row">
									<h3 class="cm_Headline">Create Creche</h3>
								</div>
							</div>
							<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 cm_maindiv blue_Border">
								<div class="row">
									<div class="cm_SelectFiled">
										<label>Select District <sup>*</sup></label>
										<select id="sel_dt_add" class="cm_ComboBox blue_Border" onchange=""></select>
									</div>
									<div class="cm_SelectFiled">
										<label>Select Block <sup>*</sup></label>
										<select id="sel_bk_add" class="cm_ComboBox blue_Border"></select>
									</div>
									<div class="cm_SelectFiled">
										<label>Select GP <sup>*</sup></label>
										<select id="sel_gp_add" class="cm_ComboBox blue_Border"></select>
									</div>
									<div class="cm_SelectFiled">
										<label>Select Village <sup>*</sup></label>
										<select id="sel_vl_add"  class="cm_ComboBox blue_Border"></select>
									</div>
									<div class="cm_SelectFiled">
										<label>Creche Name <sup>*</sup></label>
										<input type="text" id="txt_cr_add" class="cm_ComboBox blue_Border" name="" placeholder="Creche Name">
									</div>
								</div>
								<div class="row">
									<div class="cm_SelectFiled">
										<label>Whether Functional? <sup>*</sup></label>
										<select id="sel_func_add" class="cm_ComboBox blue_Border">
											<option disabled="disabled" selected="true" value="select">Select</option>
											<option value="Functional">Functional</option>
											<option value="Non-Functional">Non-Functional</option>
										</select>
									</div>
									<div class="cm_SelectFiled">
										<label>Type of Creche: <sup>*</sup></label>
										<select id="sel_type_add" class="cm_ComboBox blue_Border">
											<option disabled="disabled" selected="true" value="select">Select</option>
											<option value="PVTG Area">PVTG Area</option>
											<option value="Non PVTG Area">Non PVTG Area</option>
											<option value="Anganwadi Cum Creche Model">Anganwadi Cum Creche Model</option>	
										</select>
									</div>
									
									<div class="cm_SelectFiled">
										<label>Project/Programme: <sup>*</sup></label>
										<select id="sel_prj_prog" class="cm_ComboBox blue_Border">
											<option disabled selected="true" value="select">Select</option>
											<option value="OPNIP">OPNIP</option>
											<option value="APF-PHRS">APF-PHRS</option>	
										</select>
									</div>
									
									
									<div class="cm_SelectFiled">
										<label>Select Date <sup>*</sup></label>
										<div class="datePicker">
											<div class="date" id="dv_cr_add">
												<input type="text" class="dateBox blue_Border" id="sel_date_add" for="sel_date_add" readonly>
													<div class="input-group-addon inconBg">
														<span class="glyphicon glyphicon-calendar"></span>
													</div>
											</div>
										</div>
										<!-- <div class="date" id="dv_cr_add">
											<input type="text" class="cm_ComboBox" id="sel_date_add" for="sel_date_add">
											<div class="input-group-addon inconBg">
												<span class="glyphicon glyphicon-calendar"></span>
											</div>
										</div> -->
									</div>
									<div class="cm_SelectFiled">
										<label>Remarks <sup>*</sup></label>
										<textarea class="cm_ComboBox blue_Border" rows="2" cols="" id="txt_remarks_add"></textarea>
									</div>
									
								</div>
								<div class="row">
									<div class="btnTwoDiv">
										<div class="leftSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_submit" onclick="createCreche()">Submit</button>
											</div>
										</div>
										<div class="rightSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_reset" onclick="clearDataCrtAdd()">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> 
						<!-- # End Work For Create Creche -->
						
						<!-- # Work For Delete Creche -->
						<div id="div_cr_mgnt_del" class="allShowTableDiv">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="row">
									<h3 class="cm_Headline">Delete Creche</h3>
								</div>
							</div>
							<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 cm_maindiv blue_Border">
								<div class="cm_Delete_Divs">
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Select District <sup>*</sup></label>
										<select id="sel_dt_del" class="delFiledsBox blue_Border"></select>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Select Block <sup>*</sup></label>
										<select id="sel_bk_del" class="delFiledsBox blue_Border"></select>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Select GP <sup>*</sup></label>
										<select id="sel_gp_del" class="delFiledsBox blue_Border"></select>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Select Village <sup>*</sup></label>
										<select id="sel_vl_del" class="delFiledsBox blue_Border"></select>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Select Creche <sup>*</sup></label>
										<select id="sel_cr_del" class="delFiledsBox blue_Border"></select>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-12 deleteFileds">
										<label>Remarks <sup>*</sup></label>
										<textarea rows="1" cols="" class="delFiledsBox blue_Border" id="txt_remarks_del"></textarea>
									</div>
								</div>
								<div class="row">
									<div class="btnTwoDiv">
										<div class="leftSubmitBtn cmBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_reset" onclick="deleteCreche()">Delete Forever</button>
											</div>
										</div>
										<div class="rightSubmitBtn cmBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_submit" onclick="popComboDistDel()">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>						
						<!-- # End Work For Delete Creche -->
						
						<!-- # Work For Modify Creche -->
						<div id="div_cr_mgnt_shf" class="allShowTableDiv">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="row">
									<h3 class="cm_Headline">Shift Creche</h3>
								</div>
							</div>
							
							<div class="col-md-12 col-sm-12 col-xs-12 cm_MainModifyDiv">
								<div class="row displayflex">
									<!-- Left Side -->
									<div class="col-md-6 col-sm-6 col-xs-12 cm_spldiv">
										<div class="cm_modifySDDiv blue_Border">
											<div class="leftBoxFixed">
												<p class="selectivedLavel">Select Source Geography</p>
											</div>
											<!-- <h2>Select Source Geography</h2> -->
											<div class="cm_modifySDDiv_inn">
												<div class="cm_modifySDDiv_col">
													<label>Select District <sup>*</sup></label>
													<select id="sel_dt_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Block <sup>*</sup></label>
													<select id="sel_bk_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select GP <sup>*</sup></label>
													<select id="sel_gp_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Village <sup>*</sup></label>
													<select id="sel_vl_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Creche <sup>*</sup></label>
													<select id="sel_cr_shf_src" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label id="lblCrchPrjPrg"> </label>
												</div>
											</div>
										</div>
									</div>
									<!-- Right Side -->
									<div class="col-md-6 col-sm-6 col-xs-12 cm_spldiv">
										<div class="cm_modifySDDiv blue_Border">
											<div class="leftBoxFixed">
												<p class="selectivedLavel">Select Destination Geography</p>
											</div>
										
											<!-- <h2>Select Destination Geography</h2> -->
											<div class="cm_modifySDDiv_inn">
												<div class="cm_modifySDDiv_col">
													<label>Select District <sup>*</sup></label>
													<select id="sel_dt_shf_des" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Block <sup>*</sup></label>
													<select id="sel_bk_shf_des" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select GP <sup>*</sup></label>
													<select id="sel_gp_shf_des" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Select Village <sup>*</sup></label>
													<select id="sel_vl_shf_des" class="cm_ComboBox blue_Border"></select>
												</div>
												<div class="cm_modifySDDiv_col">
													<label>Project/Programme: <sup>*</sup></label>
													<select id="sel_prj_prog_des" class="cm_ComboBox blue_Border">
														<option disabled selected="true" value="select">Select Project/Programe</option>
														<option value="OPNIP">OPNIP</option>
														<option value="APF-PHRS">APF-PHRS</option>	
													</select>
												</div>
												
												<div class="cm_modifySDDiv_col">
													<label>Remarks <sup>*</sup></label>
													<textarea class="cm_ComboBox blue_Border" rows="1" cols="" id="txt_remarks_shf_des"></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="btnTwoDiv">
										<div class="leftSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_submit" onclick="shiftCreche()">Submit</button>
											</div>
										</div>
										<div class="rightSubmitBtn">
											<div class="form-actions clearfix">
												<button type="button" class="btn btn-primary_reset" onclick="popComboDistShfSrc()">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						<!-- # End Work For Modify Creche -->
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
	 	<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/admin/script/creche_management.js"></script>
	 	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>

</section>
</body>
</html>