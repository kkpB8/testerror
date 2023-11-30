<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="icon" type="../image/png" href="../../images/nhm_logo1.png" />
		<title>|| Change Password ||</title>

		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<!-- Bootstrap -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <!-- Bootstrap Dropdown Hover CSS -->
	    <link href="<%=getServletContext().getContextPath() %>/style/animate.min.css" rel="stylesheet">
	    <link href="<%=getServletContext().getContextPath() %>/style/bootstrap-dropdownhover.min.css" rel="stylesheet">
	    <link href="<%=getServletContext().getContextPath() %>/style/style.css" rel="stylesheet">
	    <link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/css/password_check.css" />
	    
	    <script src="<%=getServletContext().getContextPath() %>/script/jquery.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap.min.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/js/bootstrap-dropdownhover.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/secured/script/common.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/script/highlightNav.js"></script>
	    <script src="<%=getServletContext().getContextPath() %>/secured/script/menu.js"></script>
		<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/script/change_password.js"></script>
		<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/secured/script/utility.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/js/bootbox.js"></script>
	
		<style type="text/css">
			.divRowInner3{
				margin-bottom:30px;
			}
			.divRowInner3 label{
				width:35%;
			}
			@media only screen and (max-width: 480px){
				#mainDiv{
					margin-top: 60px;
				}
				.divRowInner3 label{
					width:100%;
				}
			}
		</style>
	</head>
	<body>
		<section id="bodyInner">
			<!-- Header -->
				<%@ include file="../header.jsp" %>
			<!-- Header End -->
<!-- -->
<div id="mainDiv" class="changePasswordMainDiv">
	<div class="container">
		<div id="page" class="changepasswordpage">
			<div class="pod">
				<form class="validate-password" method="post" action="#">
					<fieldset class="fieldset-password">
						<div id="alert-invalid-password" class="alert alert-danger hide">Please enter a valid password</div>
						<p>All checkmarks must turn green in order to proceed</p>
						<!--- MD-6 SM-6 XS-6 -->
						<div class="col-md-6 col-sm-6 col-xs-12" id="password-info">
							<ul>
								<li id="length" class="invalid clearfix">
									<span class="icon-container">
										<i class="fa fa-check" aria-hidden="true"></i>
									</span>
									At least 8 characters
								</li>
								<li id="capital" class="invalid clearfix">
									<span class="icon-container">
										<i class="fa fa-check" aria-hidden="true"></i>
									</span>
									At least 1 uppercase letter
								</li>
								<li id="lowercase" class="invalid clearfix">
									<span class="icon-container">
										<i class="fa fa-check" aria-hidden="true"></i>
									</span>
									At least 1 lowercase letter
								</li>
								<li id="number-special" class="invalid clearfix">
									<span class="icon-container">
										<i class="fa fa-check" aria-hidden="true"></i>
									</span>
									At least 1 number or <span title="&#96; &#126; &#33; &#64; &#35; &#36; &#37; &#94; &#38; &#42; &#40; &#41; &#43; &#61; &#124; &#59; &#58; &#39; &#34; &#44; &#46; &#60; &#62; &#47; &#63; &#92; &#45;" class="special-characters tip">special character</span>
								</li>
							</ul>
						</div>
						<!-- MD-6 SM-6 XS-6 End -->

						<!-- MD-6 SM-6 XS-6 -->
						<div class="col-md-6 col-sm-6 col-xs-12 changePassBox"> 
							<div class="form-group password-group passGroup">
								<label class="passlabel" for="input-cur-password">Current Password:</label>
								<div class="passGroup_inn">
									<input type="password" id="input-cur-password" name="curPasswordMasked" class="required form-control passTextbox" maxlength="15" autocomplete="off"/>
									<span class="passshowhiden">
										<label class="check-text" >
											<input type='checkbox'/>
											<span id="sp_cur_pwd_close" class="glyphicon glyphicon-eye-open checked" onclick="togglePassword('cur_pass', this.id, 'hide')"></span>
											<span id="sp_cur_pwd_open" class="glyphicon glyphicon-eye-close unchecked" onclick="togglePassword('cur_pass', this.id, 'show')"></span>
										</label>
									</span>
								</div>
							</div>
							<div class="form-group password-group passGroup">
								<label class="passlabel" for="input-password">New Password:</label>
								<div class="passGroup_inn">
									<input type="password" id="input-password" name="passwordMasked" class="required form-control passTextbox" maxlength="15" autocomplete="off" />
									<span class="passshowhiden">
										<label class="check-text" >
											<input type='checkbox'/>
												<span id="sp_new_pwd_close" class="glyphicon glyphicon-eye-open checked" onclick="togglePassword('new_pass', this.id, 'hide')"></span>
												<span id="sp_new_pwd_open" class="glyphicon glyphicon-eye-close unchecked" onclick="togglePassword('new_pass', this.id, 'show')"></span>
										</label>
									</span>
								</div>
							</div>
							<div class="form-group password-group passGroup">
								<label class="passlabel" for="input-password-check">Re-enter Password:</label>
								<div class="passGroup_inn">
									<input type="password" id="input-password-check" name="passwordCheckMasked" class="required form-control passTextbox" maxlength="15" autocomplete="off"/>
									<span class="passshowhiden">
										<label class="check-text" >
											<input type='checkbox'/>
												<span id="sp_conf_pwd_close" class="glyphicon glyphicon-eye-open checked" onclick="togglePassword('conf_pass', this.id, 'hide')"></span>
												<span id="sp_conf_pwd_open" class="glyphicon glyphicon-eye-close unchecked" onclick="togglePassword('conf_pass', this.id, 'show')"></span>
										</label>
									</span>
								</div>
								<small id="pwd_match"></small>
							</div>
						</div>
					<!-- MD-6 SM-6 XS-6 End -->
					<!-- MD-6 SM-6 XS-6 -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="btnTwoDiv">
								<div class="leftSubmitBtn">
									<div class="form-actions clearfix">
										<button type="button" id="btn_submit" class="btn btn-primary_submit" style="background:#006c90;" onclick="changePassword();">Submit</button>
									</div>
								</div>
								<div class="rightSubmitBtn">
									<div class="form-actions clearfix">
										<button type="button" class="btn btn-primary_reset" onclick="resetAll()" style="background:grey;">Reset</button>
									</div>
								</div>
							</div>
						</div>
					<!-- MD-6 SM-6 XS-6 End -->
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>



	<script>
		// tell the embed parent frame the height of the content
			if (window.parent && window.parent.parent){
				window.parent.parent.postMessage(["resultsFrame", {
				height: document.body.getBoundingClientRect().height,
				slug: "53tqvpm7"
			}], "*")
		}
		// always overwrite window.name, in case users try to set it manually
		window.name = "result"
	</script>
	<script src="<%=getServletContext().getContextPath() %>/secured/profile/script/changepassword.js"></script>
	<script src="<%=getServletContext().getContextPath() %>/script/default.js"></script>
<%--	
			<!-- Main -->
			<div id="mainDiv" class="changePasswordMainDiv">
				<div id="content">
					<div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-12">
						<form id="pswrd_profile" name="pswrd_profile">
							<div class="divRow">
								<span class="frmPassworDiv">
									<!-- Old Password -->
									<div class="frmRowDiv">
										<div class="divRowInner3">
											<label>Old Password :</label>
											<input type="password" id="old_pass" class="passBox" onkeyup=""/>
										</div>
									</div>
									<!-- New Password -->
									<div class="frmRowDiv">
										<div class="divRowInner3">
											<label>New Password :</label>
											<input type="password" id="new_pass" class="passBox" onkeyup=""/>
										</div>
									</div>
									<!-- Confirm New Password -->
									<div class="frmRowDiv">
										<div class="divRowInner3">
											<label>Confirm Password :</label>
											<input type="password" id="conf_pass" class="passBox" name="confirm" onkeyup="checkIfPwdSame(this.value);" />
											<small id="success" style="font-size: 8pt; display: block;"></small>
										</div>
									</div>
									<!-- Submit & Cancel -->
									<div class="frmRowDiv">
										<div class="divRowInner3" style="text-align:center;">
											<input id="cancel" class="btn btn-custom customClearBtn" type="reset" title="Clear entered password" value="Clear" onclick="chngPassStrength()">
											<input id="sub_chng" class="btn btn-custom customSaveBtn" type="button" title="Save New Password"  value="Save" onclick="changePassword();">
										</div>
									</div>
								</span>
							</div>
						</form>
					</div>
				</div>
			</div><!-- End Change Password -->
			<!-- Main End -->
			
			<script src="<%=getServletContext().getContextPath() %>/secured/profile/script/changepassword.js"></script>
--%>
			<!-- Footer -->
				 <%@ include file="../../footer.jsp" %>
			<!-- Footer End -->
	
	
	
	
	
	<%--
		<div class="container-fluid">
	 		<!-- Header -->
			<%@ include file="../header.jsp" %>
	    	<!-- Header -->
	    	
	    	<div class="main">
	       		<!-- content -->
			      <div class="row content">
			      	<div class="col-sm-3"></div>
			      	<div class="col-sm-6">
					    <div id="mainDiv">
					     	<!-- <form id="pswrd_profile" name="pswrd_profile" action="../../curPass.Change" onsubmit="return beginEncryption();" method="post"> -->
					     	<form id="pswrd_profile" name="pswrd_profile">
							     <div class="divRow" style="padding:40px;">
							     	<!-- <tr>
									       <td>
									        	<label>Current Password :</label>
									       </td>
									       <td>
									       		<input type="text" id="cur_pass"/>
									       </td>
								      </tr> -->
								      
									<div class="divRowInner3">
							       		<label>New Password :</label>
							       		<input type="text" id="new_pass" onkeyup="checkIfPwdSame(this.value);"/>
							       	</div>
							       	
							       	<div class="divRowInner3">
							       		<label>Confirm Password :</label>
							       		<input type="password" id="confirm" name="confirm" onkeyup="checkIfPwdSame(this.value);" />
							       		<small id="success" style="font-size: 8pt; display: block;"></small>
							       	</div>
							       	
							       	<div class="divRowInner3" style="text-align:center;">
										<input id="cancel" class="btn btn-custom" type="reset" title="Clear entered password" value="Clear" onclick="chngPassStrength()">
										<input id="sub_chng" class="btn btn-custom" type="button" title="Save New Password"  value="Save" onclick="chngPassword();">
								    </div>
							     </div>
						     </form>
					     </div><!-- End Change Password -->
				     </div>
				     <div class="col-sm-3"></div>
			     </div>
		     </div>
		     <%@ include file="../../footer.jsp" %>
	     </div>
	--%>
	
		</section>
	</body>
</html>