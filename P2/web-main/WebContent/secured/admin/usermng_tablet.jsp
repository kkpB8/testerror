<%@page import="com.rmspl.odisha.creche.utility.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rmspl.app.misc.HitCounter"%>
<%@page import="com.rmspl.app.data.service.*"%>

<!DOCTYPE html>
<html>
	<head>
		<title>|| Tablet User Management ||</title>
	
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
		
		<%
			if(session.getAttribute("Hits") == null) {
		  		session.setAttribute("Hits", HitCounter.getHitCount());
		  	}
		%>		
		<!-- To get Login User details -->
		<%
			if (request.getSession().getAttribute("user_code") == null) {
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
			li {
				list-style-type: none;
			}
			.footer_img_div {
				display: none; 
			}
			@media screen and (min-width:768px) and (max-width:1024px) {
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
		      		<li data-toggle="tab"><a href="javascript:" onclick="displaydiv('M');" title="Modify User">Modify User</a></li>
		   		</ul>
			</div>
		</div>
<!---------------------------------------------->
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
<!-- ****************************************************************** -->
<!-- # Work For Create User Tablet -->
		<div id="dvCreateUsr" class="allShowTableDiv displayFlex">
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
						<input id="rdCrtUsrMPA" type="radio" name="levelCrtUsr" value="MPA"> <label class="selectLevelLabel">MPA</label>
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
						<!-- <div id="div_mpa" class="col-md-3 col-sm-6 col-xs-12">
							<Label class="frmLabel">MPA <sup>*</sup></Label>
							<select id="selMPA" class="frmTextBox frmSelectBox blue_Border">
								<option value="">Select MPA</option>
							</select>
						</div> -->
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="submitCancelBtn">
								<span>
									<button id="btnCrtUsrCancel" class="btnCrtUsrCancel">Cancel</button>
								</span>
								<span>
									<button id="btnCrtUsrSubmit" class="btnCrtUsrSubmit">Submit</button>
								</span>
							</div>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-12">
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
				</div>


				<!--<table>
					<tr style="color:#2fb7af;">
						<td>
							<Label style="margin-left:1%;">Name <sup style="color: red;">*</sup></Label>
							<br>
							<input type="text" id="txtCrtUsrName" maxlength="50" >
						</td>
						<td>
							<Label style="margin-left:-14%;">Email id <sup style="color: red;">*</sup></Label>
							<br>
							<input type="text" id="txtCrtUsrEmail" maxlength="50" >
						</td>
						<td>
							<Label style="margin-left:-63%;">Cell Phone No. <sup style="color: red;">*</sup></Label>
							<br>
							<input type="text" id="txtCrtUsrPhn" maxlength="10">
						</td>
						<td>
							<Label style="margin-top:9%;">Enter User Name <sup style="color: red;">*</sup></Label>
							<br>
							<input type="text" id="txtCrtUsrId" maxlength="50">
							<br>
							<font size=2><a href="#" onclick="ChkUserAvail();">Check Availability</a></font>
							<img id="imgRightUserName" alt="" height="20" width="20" src="../../images/right.png" style="display: none;">
							<img id="imgWrongUserName" alt="" height="20" width="20" src="../../images/wrong.png" style="display: none;">
						</td>
					</tr> 
					<tr style="color:#2fb7af; margin-left:20%;">
						<td style="width:35%;">
							<Label>Enter Password (Login Password) <sup style="color: red;">*</sup></Label>
							<br>
							<input type="password" id="txtCrtUsrPwd" type="password" maxlength="64" >
						</td>
						<td style="width: 35%;">
							<Label style="margin-left:-15%;">Re-enter Password (Login Password) <sup style="color: red;">*</sup></Label>
							<br>
							<input type="password" id="txtCrtUsrRePwd" type="password" maxlength="64" >
							<br>
							<img id="imgRightPwd" alt="" height="20" width="20" src="../../images/right.png" style="display: none;">
							<img id="imgWrongPwd" alt="" height="20" width="20" src="../../images/wrong.png" style="display: none;">
						</td>
					</tr>
					<tr>
						<td>
							<select id="selDist" style="color:#2fb7af;" >
								<option value="">Select District</option>
							</select>
						</td>
						<td>
							<select id="selBlock" style="color:#2fb7af;" >
								<option value="">Select Block</option>
							</select>
						</td>
						<td colspan="2">
							<div id="divPwdValidate_1" style="border: 1px red solid;">
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
						</td>
					</tr>
					<tr>
						<td style="width:20%;">
							<button id="btnCrtUsrCancel">Cancel</button>
							<button id="btnCrtUsrSubmit">Submit</button>
						</td>
					</tr>				
				</table>-->
				</div>
			</div>
		</div>


		</div> 
	<!-- # End Work For Create User Tablet -->

	<!-- # Work For Delete User Tablet -->
		<div id="dvDeleteUsr" class="allShowTableDiv">
			<div class="col-md-2 col-sm-12 col-xs-12">
				<div class="row">
					<div class="leftBoxFixed">
						<p class="selectivedLavel">Select User Details <sup>*</sup></p>
					</div>
				
					<!-- <p class="selectivedLavel">Select User Details <sup>*</sup></p> -->
				</div>
			</div>
			<div class="col-md-10 col-sm-12 col-xs-12">
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<select id="sel_user_detail_del" onchange="popUserForDelete()" class="frmTextBox frmSelectBox blue_Border" >
							<option value="">Select User Level</option>
							<option value="ST">State</option>
							<option value="DT">District</option>
							<option value="BK">Block</option>
							<option value="GP">GP</option>
							<!-- <option value="MPA">MPA</option> -->
						</select>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<select id="sel_user_del" class="frmTextBox frmSelectBox blue_Border" >
							<option value="">Select User</option>
						</select>
					</div>
					<div class="col-md-4 col-sm-12 col-xs-12">
						<div class="twoBtnDiv">
							<button id="btnDltUsrDelete" class="btnDltUsrDelete">Delete Forever</button>
							<button id="btnDltUsrCancel" class="btnDltUsrCancel" >Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--<div id="dvDeleteUsr" style="margin-top:15%; ">
			<label>Delete User</label>
			<fieldset>
				<legend style="color:#2fb7af;">Select User Details:</legend>
				<table style="border:2px #000000 solid; width:23%;">
					<tr>
						<td colspan="2" style="text-align: center;">
							<select id="sel_user_detail_del" onchange="popUserForDelete()" >
								<option value="">Select User Level</option>
								<option value="ST">State</option>
								<option value="DT">District</option>
								<option value="BK">Block</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
							<select id="sel_user_del" >
								<option value="">Select User</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<button id="btnDltUsrDelete">Delete Forever</button>
						</td>
						<td>
							<button id="btnDltUsrCancel">Cancel</button>
						</td>
					</tr>					
				</table>
			</fieldset>
		</div>-->
	<!-- # End Work For Delete User Tablet -->

	<!-- # Work For Modify User Tablet -->
		<div id="dvModifyUsr" class="allShowTableDiv">
			<div class="col-md-2 col-sm-12 col-xs-12">
				<div class="row">
					<div class="leftBoxFixed">
						<p class="selectivedLavel">Select User Details <sup>*</sup></p>
					</div>
					<!-- <p class="selectivedLavel">Select User Details <sup>*</sup></p> -->
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12">
<!-------------------------------------------------------------->
						<div class="modifyblock blue_Border">
							<div id="div_dist_mod" class="dvModifyUsr_inn">
								<div class="col-md-6 col-sm-6 col=-xs-12">
									<select id="sel_dist_mod" class="sel_dist_mod blue_Border" onchange="popUsersMod()">
										<option value="">Select District</option>
									</select>
								</div>
								<div class="col-md-6 col-sm-6 col=-xs-12">
									<select id="sel_user_mod" class="sel_user_mod blue_Border" onchange="popAssignedBlock()">
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
								<!-- Delete Blocks -->
								<div id="div_del_bk_mod" style="display: none;">
									<div id="div_asgn_bk_del_mod" class="divAsgnBkDelMod blue_Border"></div>
										<input type="button" id="btn_cancel_bk_del_mod" class="btnCancelBkDelMod" value="Cancel">
										<input type="button" id="btn_submit_bk_del_mod" class="btnSubmitBkDelMod" value="Delete Selected Blocks">
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="row">
									<!-- Add New Blocks -->
									<div id="div_add_bk_mod" class="divAddBkMod">
										<div class="col-md-6 col-sm-12 col-xs-12">
											<select id="sel_add_bk_dist_mod" onchange="popBlockMod()" class="frmTextBox frmSelectBox blue_Border">
												<option value="">Select District</option>
											</select>
										</div>
										<div class="col-md-6 col-sm-12 col-xs-12">
											<select id="sel_add_bk_bk_mod" onchange="" class="frmTextBox frmSelectBox blue_Border">
												<option value="">Select Block</option>
											</select>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12 btnAddBkMod">
											<input type="button" id="btn_add_bk_mod" class="btn_add_bk_mod blue_Border" value="Add to List">
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
<!-------------------------------------------------------------->
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<label class="assignedText">Assigned Blocks</label>
					<div id="div_asgn_bk_add_mod" class="divAsgnBkAddModBox"></div>
					</div>
				</div>
			</div>




		<!--<div id="dvModifyUsr" style="margin-top:15%; ">
			<label>Modify User</label>
			<div style="color:#2fb7af; font-size:20px;"><b>Select User Details:</b></div>

			<div style="border:2px solid #000000; height:300px;">
				<div style="width:50%; float:left; margin-left:2%; color:#2fb7af;">
					<div id="div_dist_mod">
						<select id="sel_dist_mod" onchange="popUsersMod()" >
							<option value="">Select District</option>
						</select>

						<select id="sel_user_mod" onchange="popAssignedBlock()" >
							<option value="">Select User</option>
						</select>
					</div>

					<div id="div_chk_del_bk_mod">
						<input type="checkbox" id="del_bk_mod" class="mod_type">&nbsp;Delete Blocks	
						<input type="checkbox" id="add_bk_mod" class="mod_type" checked="checked">&nbsp;Add New Blocks					
					</div>-->

					<!-- Delete Blocks -->
					<!--<div id="div_del_bk_mod" style="display: none;">
						<div id="div_asgn_bk_del_mod"></div>
						<input type="button" id="btn_cancel_bk_del_mod" value="Cancel">
						<input type="button" id="btn_submit_bk_del_mod" value="Delete Selected Blocks">
					</div>-->

					<!-- Add New Blocks -->
					<!--<div id="div_add_bk_mod">
						<select id="sel_add_bk_dist_mod" onchange="popBlockMod()" >
							<option value="">Select District</option>
						</select>
						<select id="sel_add_bk_bk_mod" onchange="" >
							<option value="">Select Block</option>
						</select>
					<br>
						<input type="button" id="btn_add_bk_mod" value="Add to List">

					<br>
						<input type="button" id="btn_cancel_bk_add_mod" value="Cancel">
						<input type="button" id="btn_submit_bk_add_mod" value="Submit">
					</div>

				</div>

				<div style="width:40%; border-left:2px solid #000000; float:left; height:297px;">
					<label style="text-align:center; margin:auto; margin-left:49%; border-top::1px solid black; margin-top:1%;">Assigned Blocks</label>
				<br>
					<div id="div_asgn_bk_add_mod" style="overflow:auto; width:116%; border: 1px solid #000000; margin-left:2%;  height:246px;"></div>	
				</div>
			</div>
		</div>-->
	<!-- # End Work For Modify User Tablet -->
<!-- **************************** END **********************************-->
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
	 	<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/admin/script/usermng_tablet.js"></script>
	 	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>

</section>
	</body>
</html>