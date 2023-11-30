<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>
<!DOCTYPE html>
<html>
	<head>
	<title>|| Web User Management ||</title>
	
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
	    
	    <link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.css"/>
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.css"/>
	    
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
								<li class="active" data-toggle="tab"><a href="javascript:" onclick="displaydiv('C');" title="Create User">Create User</a></li>
								<li data-toggle="tab"><a href="javascript:" onclick="displaydiv('D');" title="Delete User">Delete User</a></li>
								<!-- <li data-toggle="tab"><a href="javascript:" onclick="displaydiv('M');" title="Modify User">Modify User</a></li> -->
							</ul>
						</div>
					</div>
	
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
						<!-- ****************************************************************** -->
							<!-- # Work For Create User Tablet -->
							<div id="dvCreateUsr" class="allShowTableDiv">
								<div class="col-md-2 col-sm-2 col-xs-12 blue_Border">
									<div class="row">
										<!-- <p class="selectivedLavel">Select Level <sup>*</sup></p> -->
										<div class="leftBoxFixed">
											<p class="selectivedLavel">Select Level <sup>*</sup></p>
										</div>
									</div>
									<div class="leftBox">
										<div class="singalLevel">
											<input id="rdCrtUsrST" type="radio" checked="checked" name="levelCrtUsr" value="ST"> <label class="selectLevelLabel">State</label>
										</div>
										<div class="singalLevel">
											<input id="rdCrtUsrDT" type="radio" name="levelCrtUsr" value="DT"> <label class="selectLevelLabel">District</label>
										</div>
										<div class="singalLevel">
											<input id="rdCrtUsrBK" type="radio" name="levelCrtUsr" value="BK"> <label class="selectLevelLabel">Block</label>
										</div>
										<div class="singalLevel">
											<input id="rdCrtUsrGP" type="radio" name="levelCrtUsr" value="GP"> <label class="selectLevelLabel">GP</label>
										</div>
										<!-- <div class="singalLevel">
											<input id="rdCrtUsrMPA" type="radio" name="levelCrtUsr" value="MP"> <label class="selectLevelLabel">MPA</label>
										</div> -->
										<div class="singalLevel">
											<br>
											<button id="btnLvlProceed" class="submitBtn">Proceed</button>
										</div>
									</div>
								</div>
								<div class="col-md-10 col-sm-10 col-xs-12">
									<div class="row">
										<label id="lblEnterDtl">Enter User Details:</label>
										<div id="divEnterDtl" class="divStateShow">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="row">
													<div class="col-md-3 col-sm-6 col-xs-12">
														<label class="frmLabel">Name <sup>*</sup></label>
														<input type="text" id="txtCrtUsrName" maxlength="50" class="frmTextBox blue_Border" >
													</div>
													<div class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Email id <sup>*</sup></Label>
														<input type="text" id="txtCrtUsrEmail" maxlength="50" class="frmTextBox blue_Border">
													</div>
													<div class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Cell Phone No. <sup>*</sup></Label>
														<input type="text" id="txtCrtUsrPhn" maxlength="10" class="frmTextBox blue_Border">
													</div>
													<div class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Enter User Name <sup>*</sup></Label>
														<input type="text" id="txtCrtUsrId" maxlength="50" class="frmTextBox blue_Border">
														<font size=2><a href="#" onclick="ChkUserAvail();">Check Availability</a></font>
														<img id="imgRightUserName" alt="" height="20" width="20" src="../../images/right.png" style="display: none;">
														<img id="imgWrongUserName" alt="" height="20" width="20" src="../../images/wrong.png" style="display: none;">
													</div>
													<div class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Enter Password <sup>*</sup></Label>
														<input type="password" id="txtCrtUsrPwd" type="password" maxlength="64" class="frmTextBox blue_Border">
														<spna class="passwordHints" data-toggle="modal" data-target="#password_hints"><i class="fa fa-info-circle" aria-hidden="true"></i> password Hints</spna>
														
														<!--------- Hints Modal ----------->
														<div id="password_hints" class="modal fade" role="dialog">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal">&times;</button>
																		<h4 class="modal-title">Password Hints</h4>
																	</div>
																	<div class="modal-body">
																		<div class="col-md-12 col-sm-12 col-xs-12">
																			<div class="noticinfomation">
																				<div id="divPwdValidate" class="divPwdValidate">
																					<img src="<%=getServletContext().getContextPath() %>/images/locked-padlock.png" style="float:left; margin-top:2.5%; margin-left:2%;" title=""><h4 style="margin-left:8%;">Your Password needs to:</h4>
																					<ul>
																						<li id="capital" class="invalid clearfix">
																							<span class="icon-container">
																								<i class="fa fa-check" aria-hidden="true" style="margin-left:-7%;"></i>
																							</span>
																							<b>include both lower and upper case characters.</b>
																						</li>
																						<li id="number" class="invalid clearfix">
																							<span class="icon-container">
																								<i class="fa fa-close" aria-hidden="true" style="margin-left:-7%;"></i>
																							</span>
																							<b>include at least one number or symbol.</b>
																						</li>
																						<li id="length" class="invalid clearfix">
																							<span class="icon-container">
																								<i class="fa fa-close" aria-hidden="true" style="margin-left:-7%;"></i>
																							</span>
																							<b>be at least 8 characters long.</b>
																						</li>
																					</ul>
																				</div>
																			</div>
																		</div>   
																	</div>
																<div class="modal-footer">
																<!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
																</div>
																</div>
															</div>
														</div>
														<!--------- Hints Modal End ----------->

													</div>
													<div class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Re-enter Password <sup>*</sup></Label>
														<input type="password" id="txtCrtUsrRePwd" type="password" maxlength="64" class="frmTextBox blue_Border">
														<img id="imgRightPwd" alt="" height="20" width="20" src="../../images/right.png" style="display: none;">
														<img id="imgWrongPwd" alt="" height="20" width="20" src="../../images/wrong.png" style="display: none;">
													</div>
													<div id="div_dt" class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">District <sup>*</sup></Label>
														<select id="selDist" class="frmTextBox frmSelectBox blue_Border">
															<option value="">Select District</option>
														</select>
													</div>
													<div id="div_bk" class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">Block <sup>*</sup></Label>
														<select id="selBlock" class="frmTextBox frmSelectBox blue_Border">
															<option value="">Select Block</option>
														</select>
													</div>
													<div id="div_gp" class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">GP <sup>*</sup></Label>
														<select id="selGP" class="frmTextBox frmSelectBox blue_Border">
															<option value="">Select GP</option>
														</select>
													</div>
													<!-- # MPA -->
													<div id="div_mpa" class="col-md-3 col-sm-6 col-xs-12">
														<Label class="frmLabel">MPA <sup>*</sup></Label>
														<select id="selMPA" class="frmTextBox frmSelectBox blue_Border">
															<option value="">Select MPA</option>
														</select>
													</div>
												</div>
												
												<div class="row">
													<div class="col-md-12">
														<div id="div_module" class="div_module">
															<div class="div_module_top">
																<table id="example_head" border="1">
																	<thead>
																		<tr>
																			<th>Menu</th>
																			<th>Sub Menu</th>
																			<th>Group</th>
																			<th>Sub Group</th>
																			<th>Select</th>
																		</tr>
																	</thead>
																</table>
															</div>
														<div class="div_module_bottom">
															<table id="example" style="width:100%">
																<!--<thead>
																	<tr>
																		<th>Menu</th>
																		<th>Sub Menu</th>
																		<th>Group</th>
																		<th>Sub Group</th>
																		<th>Select</th>
																	</tr>
																</thead>-->
																<tbody>
																
																<!-- Overview Start -->																
																	<tr>
																	    <td class="text-center" rowspan="4">Overview</td>
																	    <td rowspan="4">-</td>
																	    <td>Functional Creches</td>
																	    <td rowspan="4">-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '1', 'N/A', '1', 'N/A');"/></td>
																	</tr>
																	<tr>
																	    <td>Children in Creches</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '1', 'N/A', '2', 'N/A');"/></td>
																	</tr>
																	<tr>
																	    <td>Child Anthropometry</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '1', 'N/A', '3', 'N/A');"/></td>
																	</tr>
																	<tr>
																	    <td>Monthly Status</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '1', 'N/A', '4', 'N/A');"/></td>
																	</tr>
																<!-- Overview End -->
																	
																<!-- Monitoring Start -->
																	<tr>
																	    <td class="text-center" rowspan="24">Monitoring</td>
																	    <td rowspan="24">-</td>
																	    <td rowspan="4">Demography</td>
																	    <td>Total</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '2', 'N/A', '5', '1');"/></td>
																	</tr>
																	<tr>
																	    <td>By Sex</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '5', '2');"/></td>
																	</tr>
																	<tr>
																	    <td>By Religion</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '5', '3');"/></td>
																	</tr>    
																	<tr>
																	    <td>By Caste</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '5', '4');"/></td>
																	</tr> 
																	<tr>
																	    <td rowspan="5">Anthropometry</td>
																	</tr>
																	<tr>
																	    <td>Total</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '2', 'N/A', '6', '5');"/></td>
																	</tr>
																	<tr>
																	    <td>By Sex</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '6', '6');"/></td>
																	</tr>
																	<tr>
																	    <td>By Religion</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '6', '7');"/></td>
																	</tr>    
																	<tr>
																	    <td>By Caste</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '6', '8');"/></td>
																	</tr> 
																	
																	<tr>
																	    <td rowspan="5">Operational Details</td>
																	</tr>
																	<tr>
																	    <td>Total</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '2', 'N/A', '7', '9');"/></td>
																	</tr>
																	<tr>
																	    <td>By Sex</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '7', '10');"/></td>
																	</tr>
																	<tr>
																	    <td>By Religion</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '7', '11');"/></td>
																	</tr>    
																	<tr>
																	    <td>By Caste</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '7', '12');"/></td>
																	</tr> 
																	
																	<tr>
																	    <td rowspan="5">Other Details</td>
																	</tr>
																	<tr>
																	    <td>Total</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '2', 'N/A', '8', '13');"/></td>
																	</tr>
																	<tr>
																	    <td>By Sex</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '8', '14');"/></td>
																	</tr>
																	<tr>
																	    <td>By Religion</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '8', '15');"/></td>
																	</tr>    
																	<tr>
																	    <td>By Caste</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '8', '16');"/></td>
																	</tr> 
																	
																	<tr>
																	    <td rowspan="5">Red Flag</td>
																	</tr>
																	<tr>
																	    <td>Total</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '2', 'N/A', '9', '17');"/></td>
																	</tr>
																	<tr>
																	    <td>By Sex</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '9', '18');"/></td>
																	</tr>
																	<tr>
																	    <td>By Religion</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '9', '19');"/></td>
																	</tr>    
																	<tr>
																	    <td>By Caste</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '2', 'N/A', '9', '20');"/></td>
																	</tr>
																<!-- Monitoring End -->
																																		
																<!-- Dashboard Start -->
																	<tr>
																	    <td class="text-center" rowspan="5">Dashboard</td>
																	    <td rowspan="5">-</td>
																	    <td rowspan="2">Comparison of Baseline</td>
																	    <td>Anthropometry Comparison</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '3', 'N/A', '10', '21');"/></td>
																	</tr>
																	<tr>
																	    <td>Socio-Economic Comparison</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '3', 'N/A', '10', '22');"/></td>   
																	</tr>
																	<tr>
																	    <td>Time Series Monthly Analysis</td>
																	    <td>Anthropometry</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '3', 'N/A', '11', '23');"/></td>   
																	</tr>
																	
																	<tr>
																	    <td rowspan="2">Creche Related Activities</td>
																	    <td>Creche Committee Meeting Card</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '3', 'N/A', '12', '24');"/></td>
																	</tr>
																	<tr>
																	    <td>Creche Monitoring</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '3', 'N/A', '12', '25');"/></td>   
																	</tr>
																<!-- Dashboard End -->
																	
																<!-- Admin Start -->
																	<tr>
																	    <td class="text-center" rowspan="6">Admin</td>
																	    <td>User Management</td>
																	    <td rowspan="6">-</td>
																	    <td rowspan="6">-</td>
																	    <td align="center"><input type="checkbox" disabled onclick="setUserSelectedVal(this.checked, '4', '1', 'N/A', 'N/A');"/></td>
																	</tr>
																	<tr>
																	    <td>Creche Management</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '4', '2', 'N/A', 'N/A');"/></td>   
																	</tr>
																	<tr>
																	    <td>Content Management</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '4', '3', 'N/A', 'N/A');"/></td>   
																	</tr>
																	<tr>
																	    <td>Add Geography</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '4', '4', 'N/A', 'N/A');"/></td>   
																	</tr>
																	<tr>
																	    <td>Add New Question</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '4', '5', 'N/A', 'N/A');"/></td>   
																	</tr>
																	<tr>
																	    <td>Child Shifting</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '4', '6', 'N/A', 'N/A');"/></td>   
																	</tr>
																<!-- Admin End -->
																	
																<!-- Data Logs Start -->
																	<tr>
																	    <td class="text-center">Data Logs</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '5', 'N/A', 'N/A', 'N/A');"/></td>   
																	</tr>
																<!-- Data Logs End -->
																	
																<!-- Report Start -->
																	<tr>
																	    <td class="text-center" rowspan="2">Report</td>
																	    <td>Web Report</td>
																	    <td rowspan="2">-</td>
																	    <td rowspan="2">-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '6', '7', 'N/A', 'N/A');"/></td>   
																	</tr>
																	<tr>
																	    <td>Child Atlas</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '6', '8', 'N/A', 'N/A');"/></td>   
																	</tr>
																<!-- Report End -->
																	
																<!-- GIS Start -->
																	<tr>
																	    <td class="text-center">GIS</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '7', 'N/A', 'N/A', 'N/A');"/></td>   
																	</tr>
																<!-- GIS End -->
																	
																<!-- Data Edit History Start -->
																	<tr>
																	    <td class="text-center">View Data Edit History</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '8', 'N/A', 'N/A', 'N/A');"/></td>   
																	</tr>
																<!-- Data Edit History End -->
																	
																<!-- Manage Data Edit Start -->
																	<tr>
																	    <td class="text-center">Manage Data Edit</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td>-</td>
																	    <td align="center"><input type="checkbox" onclick="setUserSelectedVal(this.checked, '9', 'N/A', 'N/A', 'N/A');"/></td>   
																	</tr>						
																<!-- Manage Data Edit End -->
																											
																</tbody>
															</table>
														</div>															
														</div>	
													</div>
													
												</div>
												
												<div class="row">
													<div class="col-md-12 col-sm-12 col-xs-12">
														<div class="webSubmitCancelBtn">
																
																<button id="btnCrtUsrSubmit" class="btnCrtUsrSubmit splBtn">Submit</button>
																<button id="btnCrtUsrCancel" class="btnCrtUsrCancel splBtn">Cancel</button>
															<!-- <span>
																<button id="btnCrtUsrCancel" class="btnCrtUsrCancel">Cancel</button>
															</span>
															<span>
																<button id="btnCrtUsrSubmit" class="btnCrtUsrSubmit">Submit</button>
															</span> -->
														</div>
													</div>
													<!-- <div class="col-md-6 col-sm-6 col-xs-12">
														<div class="noticinfomation">
															<div id="divPwdValidate" class="divPwdValidate">
																<img src="<%=getServletContext().getContextPath() %>/images/locked-padlock.png" style="float:left; margin-top:2.5%; margin-left:2%;" title=""><h4 style="margin-left:8%;">Your Password needs to:</h4>
																<ul>
																	<li id="capital" class="invalid clearfix">
																		<span class="icon-container">
																			<i class="fa fa-check" aria-hidden="true" style="margin-left:-7%;"></i>
																		</span>
																		<b>include both lower and upper case characters.</b>
																	</li>
																	<li id="number" class="invalid clearfix">
																		<span class="icon-container">
																			<i class="fa fa-close" aria-hidden="true" style="margin-left:-7%;"></i>
																		</span>
																		<b>include at least one number or symbol.</b>
																	</li>
																	<li id="length" class="invalid clearfix">
																		<span class="icon-container">
																			<i class="fa fa-close" aria-hidden="true" style="margin-left:-7%;"></i>
																		</span>
																		<b>be at least 8 characters long.</b>
																	</li>
																</ul>
															</div>
														</div>
													</div> -->

												</div>
											</div>
										</div>
									</div>
								</div>
							</div> 
							<!-- # End Work For Create User Tablet -->
							<!-- # Work For Delete User Tablet -->
							<div id="dvDeleteUsr" class="allShowTableDiv">
								<div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-ofset-3 col-xs-12 deleteUserWebTable">
									<div class="row">
										<p class="selectivedLavelWeb">Select User Details <sup>*</sup></p>

										<div class="col-md-6 col-sm-6 col-xs-12">
											<select id="sel_user_detail_del" onchange="popUserForDelete()" class="frmTextBox frmSelectBox" >
												<option disabled="disabled" selected="true" value="">Select User Level</option>
												<option value="ST">State</option>
												<option value="DT">District</option>
												<option value="BK">Block</option>
											</select>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<select id="sel_user_del" class="frmTextBox frmSelectBox" >
												<option value="">Select User</option>
											</select>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12 webUserBtn">
											<div class="twoBtnDiv">
												<button id="btnDltUsrDelete" class="btnDltUsrDelete">Delete Forever</button>
												<button id="btnDltUsrCancel" class="btnDltUsrCancel" >Cancel</button>
											</div>
										</div>

									</div>
								</div>
							</div>
							<!-- # End Work For Delete User Tablet -->
							
							<!-- # Work For Modify User Tablet -->
							<!-- <div id="dvModifyUsr" class="allShowTableDiv">
								<div class="col-md-2 col-sm-12 col-xs-12">
									<div class="row">
										<p class="selectivedLavel">Select User Details <sup>*</sup></p>
									</div>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-xs-12">
											<div class="modifyblock">
												<div id="div_dist_mod" class="dvModifyUsr_inn">
													<div class="col-md-6 col-sm-6 col=-xs-12">
														<select id="sel_dist_mod" class="sel_dist_mod" onchange="popUsersMod()">
															<option value="">Select District</option>
														</select>
													</div>
													<div class="col-md-6 col-sm-6 col=-xs-12">
														<select id="sel_user_mod" class="sel_user_mod" onchange="popAssignedBlock()">
															<option value="">Select User</option>
														</select>
													</div>
												</div>
												<div class="dvModifyUsr_inn">
													<div class="col-md-6 col-sm-6 col-xs-12">
														<div id="div_chk_del_bk_mod" class="div_chk_del_bk_mod">
															<input type="checkbox" id="del_bk_mod" class="mod_type">&nbsp;Delete Blocks	
															<input type="checkbox" id="add_bk_mod" class="mod_type" checked="checked">&nbsp;Add New Blocks
														</div>
													</div>
													<div class="col-md-6 col-sm-6 col-xs-12">
													Delete Blocks
														<div id="div_del_bk_mod" style="display: none;">
															<div id="div_asgn_bk_del_mod" class="divAsgnBkDelMod"></div>
															<input type="button" id="btn_cancel_bk_del_mod" class="btnCancelBkDelMod" value="Cancel">
															<input type="button" id="btn_submit_bk_del_mod" class="btnSubmitBkDelMod" value="Delete Selected Blocks">
														</div>
													</div>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<div class="row">
														Add New Blocks
															<div id="div_add_bk_mod" class="divAddBkMod">
																<div class="col-md-6 col-sm-12 col-xs-12">
																	<select id="sel_add_bk_dist_mod" onchange="popBlockMod()" class="frmTextBox frmSelectBox">
																		<option value="">Select District</option>
																	</select>
																</div>
																<div class="col-md-6 col-sm-12 col-xs-12">
																	<select id="sel_add_bk_bk_mod" onchange="" class="frmTextBox frmSelectBox">
																		<option value="">Select Block</option>
																	</select>
																</div>
																<div class="col-md-12 col-sm-12 col-xs-12 btnAddBkMod">
																	<input type="button" id="btn_add_bk_mod" class="btn_add_bk_mod" value="Add to List">
																</div>
																<div class="col-md-12 col-sm-12 col-xs-12 twoBtnDiv">
																	<input type="button" id="btn_cancel_bk_add_mod" class="btn_cancel_bk_add_mod" value="Cancel">
																	<input type="button" id="btn_submit_bk_add_mod" class="btn_submit_bk_add_mod" value="Submit">
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<label class="assignedText">Assigned Blocks</label>
											<div id="div_asgn_bk_add_mod" class="divAsgnBkAddModBox"></div>
										</div>
									</div>
								</div>
							# End Work For Modify User Tablet
							</div> -->
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
			
			<%-- <script src="<%=getServletContext().getContextPath() %>/script_datatable/jquery.dataTables.min.js"></script>		
			<script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.responsive.js"></script>
			<script src="<%=getServletContext().getContextPath() %>/script_datatable/dataTables.fixedColumns.min.js"></script> --%>
			<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
			
		 	<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/admin/script/usermng_web.js"></script>
		 	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
	</section>
	</body>
</html>