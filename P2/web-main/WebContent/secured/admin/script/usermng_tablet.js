var urlCombo = "../../pop.combo.data";
var objDistBlk; 
var GLOBAL_LOGIN_USER_ID;
var GLOBAL_MAP_ID;
var booUserName = false;
var json_bk_add = {};
var json_added_bk = {};
var json_added_bk_del = {};
var json_bk_del = {};
var mod_type = "add";

//# Page Load Function
$(document).ready(function() {
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	$("#dvCreateUsr").show();
	$("#dvDeleteUsr").hide();
	$("#dvModifyUsr").hide();
	$("#lblEnterDtl").hide();
	$("#divEnterDtl").hide();
	$("#div_dt").hide();
	$("#div_bk").hide();
	//# District Load
	initLocation("selDist", "");
}); //# End Page Load

function displaydiv(id) {
	$("#lblEnterDtl").hide();$("#divEnterDtl").hide();
	$('input[type=radio][name=levelCrtUsr][value=st]').prop('checked', true);
	
	switch (id) {
	case "D":
		$("#dvCreateUsr").hide();
		$("#dvDeleteUsr").show();
		$("#dvModifyUsr").hide();
		break;
	case "M":
		$("#dvCreateUsr").hide();
		$("#dvDeleteUsr").hide();
		$("#dvModifyUsr").show();
		popDistMod();
		break;
	default:
		$("#dvCreateUsr").show();
		$("#dvDeleteUsr").hide();
		$("#dvModifyUsr").hide();
		break;
	}
} //# End displaydiv

//# Change Level
$('input[type=radio][name=levelCrtUsr]').on('change', function() {
	$("#lblEnterDtl").hide();$("#divEnterDtl").hide();
	$('#selDist')[0].selectedIndex = 0;
	$('#selBlock')
		.empty()
		.append('<option value="">Select Block</option>');
	
}); //# End Change Level

$("#btnLvlProceed").click(function(){
	//alert($("input[type=radio][name='levelCrtUsr']:checked").val());
	var strLvlVal = $("input[type=radio][name='levelCrtUsr']:checked").val();
	if(strLvlVal=="ST"){
		$("#div_dt").hide();
    	$("#div_bk").hide();
    	$("#div_gp").hide();
    	$("#div_mpa").hide();
	} else if(strLvlVal=="DT"){
		$("#div_dt").show();
    	$("#div_bk").hide();
    	$("#div_gp").hide();
    	$("#div_mpa").hide();
	} else if(strLvlVal=="BK"){
		$("#div_dt").show();
    	$("#div_bk").show();
    	$("#div_gp").hide();
    	$("#div_mpa").hide();
	} else if(strLvlVal=="GP"){
		$("#div_dt").show();
    	$("#div_bk").show();
    	$("#div_gp").show();
    	$("#div_mpa").hide();
	}
	else{
		$("#div_dt").hide();
    	$("#div_bk").hide();
    	$("#div_gp").hide();
    	$("#div_mpa").show();
    	GetMPA("selMPA", "");
	}
	$("#divEnterDtl").show();
});


function initLocation(comboID, code) {
	//showModal();
	$.ajax({
		  url: urlCombo,
		  type: "get", //send it through get method
		  data: {
			  type: comboID,
			  code: code,
		  },
		  success: function(response) {
			 // alert(response.length);
			  if (response == "N/A") {
					//alert("Unable To get data.");
					hideModal();
					return;
				} else {
					objDistBlk  = eval ("("+ response +")");
					$('#'+comboID).html('');
					$('#'+comboID).append('<option value="">Select District</option>');
					//# Get Unique District
					var arSC = GetUniqueDT(objDistBlk);
					for ( var i = 0; i < arSC.length; i++) {
						var data= arSC[i].split("^");
						$('#'+comboID).append('<option value="'+data[0]+'">'+data[1]+'</option>');
	  		        }					
	  		        hideModal();
				}
		  },
		  error: function(xhr) {
			  //Do Something to handle error
			  //hideModal();
			  alert("Unable To Find data.");
			  return;
		  }
	});
} //# End initLocation

function GetMPA(comboID, code) {
	showModal();
	$.ajax({
		  url: urlCombo,
		  type: "get", //send it through get method
		  data: {
			  type: comboID,
			  code: code,
		  },
		  success: function(response) {
			 // alert(response.length);
			  if (response == "N/A") {
					//alert("Unable To get data.");
					hideModal();
					return;
				} else {
					var objMPA  = eval ("("+ response +")");
					$('#'+comboID).html('');
					$('#'+comboID).append('<option value="">Select MPA</option>');
					//# Get Unique District
					for ( var i = 0; i < objMPA.length; i++) {
						$('#'+comboID).append('<option value="'+objMPA[i][0]+'">'+objMPA[i][1]+'</option>');
	  		        }					
	  		        hideModal();
				}
		  },
		  error: function(xhr) {
			  //Do Something to handle error
			  //hideModal();
			  alert("Unable To Find data.");
			  return;
		  }
	});
} //# End GetMPA

//# Get unique District
function GetUniqueDT(inputArray){
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][0]+"^"+inputArray[i][1], outputArray)) == -1){
			outputArray.push(inputArray[i][0]+"^"+inputArray[i][1]);
		}
	}
	return outputArray;
}//# End GetUniqueDT

//# District Change
$('#selDist').on("change", function(e) {
	if($('input[type=radio][name=levelCrtUsr]:checked').val()=="BK"
			|| $('input[type=radio][name=levelCrtUsr]:checked').val()=="GP"){
		$('#selBlock')
	    	.empty()
	    	.append('<option value="">Select Block</option>');	
		//# Get BLK Wise Village Populate
		var arSch = GetUniqueBlkBaseDT(objDistBlk ,$('#selDist').val());
		for ( var i = 0; i < arSch.length; i++) {
			var data= arSch[i].split("^");
			$('#selBlock').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }
	}
	
});

//# Get unique Block respective Dist
function GetUniqueBlkBaseDT(inputArray, mnthFilter){
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][0]==mnthFilter){
			if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
				outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
			}
		}
	}
	return outputArray;
}//# End GetUniqueBlkBaseDT


//# Block Change
$('#selBlock').on("change", function(e) {
	if($('input[type=radio][name=levelCrtUsr]:checked').val()=="GP"){
		$('#selGP')
	    	.empty()
	    	.append('<option value="">Select GP</option>');	
		//# Get BLK Wise GP Populate
		var arSch = GetUniqueGpBaseBlk(objDistBlk ,$('#selBlock').val());
		for ( var i = 0; i < arSch.length; i++) {
			var data= arSch[i].split("^");
			$('#selGP').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }
	}
	
});

//# Get unique GP respective Block
function GetUniqueGpBaseBlk(inputArray, mnthFilter){
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2]==mnthFilter){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
			}
		}
	}
	return outputArray;
}//# End GetUniqueGpBaseBlk

//# Data Save for Create User
$("#btnCrtUsrSubmit").click(function(){
	var strUsrLvl = $("input[type=radio][name='levelCrtUsr']:checked").val();
	
	if(validateDataCrtUser(strUsrLvl)) {
		//Confirmation message
		bootbox.confirm({
			size: "small",
			title: "Create User",
			message: "Do you want to save the data?", 
		    buttons: {
		        confirm: {
		            label: '<i class="fa fa-check"></i> Yes',
		            className: 'btn-primary'
		        },
		        cancel: {
		            label: '<i class="fa fa-times"></i> No',
		            className: 'btn-danger'
		        }
		    },
		    callback: function(result){
		    	 if(result == true) {
		    		 //showModal();
		    		 // CALL `sp_di_tab_usr_create`('ST','abcd','abcd@gmail.com','999999999',
		    		 //   'abcd1','12345','21',NULL,NULL,'appi0001',NOW());
		    		 var json_param_set = {};	    		 
		    		 //alert("Counter : " + counter);
	    			 json_param_set["userlvl"]= strUsrLvl;
					 json_param_set["txtCrtUsrName"]= $('#txtCrtUsrName').val();
	    			 json_param_set["txtCrtUsrEmail"]= $('#txtCrtUsrEmail').val();
	    			 json_param_set["txtCrtUsrPhn"]= $('#txtCrtUsrPhn').val();
	    			 json_param_set["txtCrtUsrId"]= $('#txtCrtUsrId').val();
	    			 json_param_set["txtCrtUsrPwd"]= $('#txtCrtUsrPwd').val();
	    			 
	    			 json_param_set["st_code"]= GLOBAL_MAP_ID;
	    			 json_param_set["selDist"]= "NULL";
					 json_param_set["selBlock"]= "NULL";
					 json_param_set["selGP"]= "NULL";
					 json_param_set["selMPA"]= "NULL";
	    			 if(strUsrLvl=="DT"){
	    				 json_param_set["selDist"]= $('#selDist').val();
	    				 json_param_set["selBlock"]= "NULL";
	    				 json_param_set["selGP"]= "NULL";
	    			 } else if(strUsrLvl=="BK"){
	    				 json_param_set["selDist"]= $('#selDist').val();
	    				 json_param_set["selBlock"]= $('#selBlock').val();
	    				 json_param_set["selGP"]= "NULL";
	    			 } else if(strUsrLvl=="GP"){
	    				 json_param_set["selDist"]= $('#selDist').val();
	    				 json_param_set["selBlock"]= $('#selBlock').val();
	    				 json_param_set["selGP"]= $('#selGP').val();	    				 
	    			 } else if(strUsrLvl=="MPA"){
	    				 json_param_set["selDist"]= "NULL";
	    				 json_param_set["selBlock"]= "NULL";
	    				 json_param_set["selGP"]= "NULL";
	    				 json_param_set["selMPA"]= $('#selMPA').val();
	    			 }
	    			 json_param_set["loginusrid"]= GLOBAL_LOGIN_USER_ID;
		
	    			//console.log(json_param_set);
	    			//Send Request to server
	    			$.ajax({
	    				type: 'POST',
	    			    // make sure you respect the same origin policy with this url:
	    			    url: '../../insert.SaveNewTabletUser',
	    			    data: { 
	    			    	json_param_set: JSON.stringify(json_param_set),
	    			    	//anm_counter: counter,
	    			    },
	    			    success: function(response){
	    			    	//console.log(response);
	    			    	var obj_response = JSON.parse(response);
	    			    	if (obj_response.status == "1") {
	    			    		bootbox.alert({
	    			    			message: "User created successfully.", 
	    			    			callback: function(){
	    			    				clearDataCrtUser();
	    			    			}
	    			    		});
	    			    		hideModal();
	    			    		return;
	    					} else {
	    						bootbox.alert('Form update failed.');
	    						hideModal();
	    			    		return;
	    					}
	    			    },
	    			    error: function(xhr) {
	    			    	bootbox.alert('Form update failed.');
	    			    	hideModal();	    			    	
	    		    		return;
	    			    }
	    			}); 
		    	 } else {
					hideModal();
					return;
		    	 }
		    }
		}); //# End Confirm
	} //# End Validation
}); //# End Save


/**
 * Data validation for Create User
 * @param strUsrLvl
 * @returns
 */
function validateDataCrtUser(strUsrLvl) {
	//Name
	if($("#txtCrtUsrName").val() == '') {
		bootbox.dialog({
            message: "Name field cannot be blank!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrName').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}
	
	//Email Id
	var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if(!email_regex.test($("#txtCrtUsrEmail").val())) {
		bootbox.dialog({
            message: "Please enter proper Email Id!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrEmail').focus();
                        }, 10);
                    }
                }
            }
        });
		return false; 
	}
		
	//Cell Phone No.
	var cell_ph_regex = /^[0-9-+]+$/;
	var cell_ph_pattern = /^\d{10}$/;
	
	if(!(cell_ph_regex.test($("#txtCrtUsrPhn").val()) 
			&& cell_ph_pattern.test($("#txtCrtUsrPhn").val()))) {
		bootbox.dialog({
            message: "Please enter 10 digit Number!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrPhn').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}	
	
	//User Name
	if($("#txtCrtUsrId").val() == '') {
		bootbox.dialog({
            message: "User Name field cannot be blank!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrId').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}
	
	//Password
	if($("#txtCrtUsrPwd").val() == '') {
		bootbox.dialog({
            message: "Password field cannot be blank!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrPwd').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}
	
	//Confirm Password
	if($("#txtCrtUsrRePwd").val() == '') {
		bootbox.dialog({
            message: "Confirm Password field cannot be blank!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrRePwd').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}
	
	//var strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	var password_regex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9,~!@#\$%\^&\*])(?=.{8,})");
	
	if(!password_regex.test($("#txtCrtUsrPwd").val())) {
		bootbox.dialog({
            message: "Password criteria does not match!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrPwd').focus();
                        }, 10);
                    }
                }
            }
        });
		return false; 
	}
	
	if($("#txtCrtUsrPwd").val() != $("#txtCrtUsrRePwd").val()) {
		bootbox.dialog({
            message: "Confirm Password does not match!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrRePwd').focus();
                        }, 10);
                    }
                }
            }
        });
		return false; 
	}
	
	if(!booUserName) {
		bootbox.dialog({
            message: "Please check whether User available or not!",
            //title: 'Warning',
            buttons: {
                danger: {
                	label: 'Ok',
                    className: "btn-primary",
                    callback: function () {
                    	setTimeout(function() {
                    		$('#txtCrtUsrId').focus();
                        }, 10);
                    }
                }
            }
        });
		return false;
	}
	
	if(strUsrLvl=="DT") {
		if($("#selDist option:selected").val() == "") {
			bootbox.dialog({
				message: "Please select a District!",
		        //title: 'Warning',
		        buttons: {
		        	danger: {
		        		label: 'Ok',
		                className: "btn-primary",
		                callback: function () {
		                	setTimeout(function() {
		                		$('#selDist').focus();
		                    }, 10);
		                }
		            }
		        }
		    });
			return false;
		 }
	} else if(strUsrLvl=="BK") {
		if($("#selBlock option:selected").val() == "") {
			bootbox.dialog({
				message: "Please select a Block!",
			    //title: 'Warning',
			    buttons: {
			    	danger: {
			    		label: 'Ok',
			            className: "btn-primary",
			            callback: function () {
			            	setTimeout(function() {
			            		$('#selDist').focus();
			                }, 10);
			            }
			        }
			    }
			});
			return false;
		 }		 
	} else if(strUsrLvl=="GP") {
		if($("#selGP option:selected").val() == "") {
			bootbox.dialog({
				message: "Please select a GP!",
			    //title: 'Warning',
			    buttons: {
			    	danger: {
			    		label: 'Ok',
			            className: "btn-primary",
			            callback: function () {
			            	setTimeout(function() {
			            		$('#selDist').focus();
			                }, 10);
			            }
			        }
			    }
			});
			return false;
		 }		 
	}  else if(strUsrLvl=="MPA") {
		if($("#selMPA option:selected").val() == "") {
			bootbox.dialog({
				message: "Please select a MPA!",
			    //title: 'Warning',
			    buttons: {
			    	danger: {
			    		label: 'Ok',
			            className: "btn-primary",
			            callback: function () {
			            	setTimeout(function() {
			            		$('#selMPA').focus();
			                }, 10);
			            }
			        }
			    }
			});
			return false;
		 }		 
	}
	return true;
}


/**
 * Function to check availability of User Name
 * @returns
 */
function ChkUserAvail() {
	//showModal();
	$.ajax({
		url: "../../check.TabletUserName",
		type: "get", //send it through get method
		data: {
			user_name: $('#txtCrtUsrId').val(),
		},
		success: function(response) {
			// alert(response.length);
			if (response == "N/A") {
				booUserName = false;
				bootbox.alert("User not available!");
				$("#imgRightUserName").hide();
				$("#imgWrongUserName").show();
				hideModal();
				return;
			} else {
				//booUserName = true;
				//$("#imgRightUserName").show();
				//$("#imgWrongUserName").hide();
				
				var obj_response  = eval ("("+ response +")");
				//When User already exists
				if(obj_response[0][0] == '0') {
					booUserName = false;
					$("#imgRightUserName").hide();
					$("#imgWrongUserName").show();
				} 
				//When User doesn't exists
				else if(obj_response[0][0] == '1') {
					booUserName = true;
					$("#imgRightUserName").show();
					$("#imgWrongUserName").hide();
				}
			}
		},
		error: function(xhr) {
			booUserName = false;
			$("#imgRightUserName").hide();
			$("#imgWrongUserName").show();
			bootbox.alert("User not available!");
			hideModal();
			return;
		}
	});
}


/**
 * Cancel button click for Create User
 * @returns
 */
$("#btnCrtUsrCancel").click(function(){
	clearDataCrtUser();
});


/**
 * Clear all data fields for Create User
 * @returns
 */
function clearDataCrtUser() {
	$("#txtCrtUsrName").val('');
	$("#txtCrtUsrEmail").val('');
	$("#txtCrtUsrPhn").val('');
	$("#txtCrtUsrId").val('');
	$("#txtCrtUsrPwd").val('');
	$("#txtCrtUsrRePwd").val('');
	booUserName = false;
	$("#imgRightUserName").hide();
	$("#imgWrongUserName").hide();
}


/**
 * Function to populate User for Delete
 * @returns
 */
function popUserForDelete() {
	$('#sel_user_del').html('');
	$('#sel_user_del').append('<option value="">Select User</option>');
	
	if($("#sel_user_detail_del option:selected").val() == "") {
		bootbox.alert("Please select User not available!");
		hideModal();
		return;
	}
	$.ajax({
		  url: "../../popUser.Delete",
		  type: "get",
		  data: {
			  type: $("#sel_user_detail_del option:selected").val()
		  },
		  success: function(response) {
			  var obj_response  = eval ("("+ response +")");
			  console.log(obj_response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable To get data.");
					hideModal();
					return;
				} else {					
					for ( var i = 0; i < obj_response.length; i++) {
						$('#sel_user_del').append('<option value="'+obj_response[i][1]+'">'+obj_response[i][0]+'</option>');
	  		        }					
	  		        hideModal();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable To Find data.");
			  hideModal();
			  return;
		  }
	});
}


/**
 * Click event for Delete User
 * @returns
 */
$("#btnDltUsrDelete").click(function() {
	bootbox.confirm({
		size: "small",
		title: "Delete User",
		message: "Do you want to delete the User?", 
	    buttons: {
	    	confirm: {
	            label: '<i class="fa fa-check"></i> Yes',
	            className: 'btn-primary'
	        },
	        cancel: {
	            label: '<i class="fa fa-times"></i> No',
	            className: 'btn-danger'
	        }
	    },
	    callback: function(result){
	    	if(result == true) {
	    		var json_param_set = {};	    		 
				json_param_set["user_name"] = $("#sel_user_del option:selected").val();
				json_param_set["loginusrid"] = GLOBAL_LOGIN_USER_ID;
	
    			//console.log(json_param_set);
    			//Send Request to server
    			$.ajax({
    				type: 'POST',
    			    // make sure you respect the same origin policy with this url:
    			    url: '../../delete.TabletUser',
    			    data: { 
    			    	json_param_set: JSON.stringify(json_param_set),
    			    },
    			    success: function(response){
    			    	//console.log(response);
    			    	var obj_response = JSON.parse(response);
    			    	if (obj_response.status == "1") {
    			    		bootbox.alert({
    			    			size: "small",
    			    			message: "User deleted successfully.", 
    			    			callback: function(){
    			    				clearDataDltUser();
    			    			}
    			    		});
    			    		hideModal();
    			    		return;
    					} else {
    						bootbox.alert('Form update failed.');
    						hideModal();
    			    		return;
    					}
    			    },
    			    error: function(xhr) {    			    	
    			    	bootbox.alert('Form update failed.');
    			    	hideModal();
    		    		return;
    			    }
    			}); 
	    	} else {
				hideModal();
				return;
			}
	    }
	}); //# End Confirm
});


$("#btnDltUsrCancel").click(function() {
	clearDataDltUser();
})


/**
 * Cancel button click for Delete User
 * @returns
 */
function clearDataDltUser() {
	$("select#sel_user_detail_del").prop('selectedIndex', 0);
	$('#sel_user_del').html('');
	$('#sel_user_del').append('<option value="">Select User</option>');
}


/**
 * Add/Delete Block for Modify User
 * @returns
 */
/*$('input[type="checkbox"]').on('change', function() {
	$('input[type="checkbox"]').not(this).prop('checked', false);
});*/
$('.mod_type').on('change', function() {
	//console.log(this.id+"..."+this.checked);
	if(!($(this).is(':checked'))) {
		bootbox.alert("Please select 1 Check box");
		$(this).prop('checked', true);
		return;
	} else {
		if(this.id == 'del_bk_mod') {
			$('#add_bk_mod').prop('checked', false);
			$('#div_del_bk_mod').show();
			$('#div_add_bk_mod').hide();	
			$('#div_asgn_bk_add_mod').html('');
			$('#div_asgn_bk_del_mod').html('');		
			mod_type = "del";
		} else if(this.id == 'add_bk_mod') {
			$('#del_bk_mod').prop('checked', false);
			$('#div_del_bk_mod').hide();
			$('#div_add_bk_mod').show();		
			$('#div_asgn_bk_add_mod').html('');
			$('#div_asgn_bk_del_mod').html('');
			mod_type = "add";
		}
	}
	
	/*if(this.id == 'del_bk_mod') {
		$('#div_del_bk_mod').show();
		$('#div_add_bk_mod').hide();	
		$('#div_asgn_bk_add_mod').html('');
		$('#div_asgn_bk_del_mod').html('');		
		mod_type = "del";
		//popAssignedBkDelMod();
	} else if(this.id == 'add_bk_mod') {
		$('#div_del_bk_mod').hide();
		$('#div_add_bk_mod').show();		
		$('#div_asgn_bk_add_mod').html('');
		$('#div_asgn_bk_del_mod').html('');
		mod_type = "add";
		//popDistMod();
	}*/
	$("select#sel_dist_mod").prop('selectedIndex', 0);
	$('#sel_user_mod').html('');
	$('#sel_user_mod').append('<option value="">Select User</option>');
});


/**
 * Function to populate District for Add Blocks in Modify User
 * @returns
 */
function popDistMod() {
	$('#sel_dist_mod').html('');
	$('#sel_dist_mod').append('<option value="">Select District</option>');
	
	$('#sel_add_bk_dist_mod').html('');
	$('#sel_add_bk_dist_mod').append('<option value="">Select District</option>');
	//# Get Unique District
	var arr_dist = GetUniqueDT(objDistBlk);
	for ( var i = 0; i < arr_dist.length; i++) {
		var data = arr_dist[i].split("^");
		$('#sel_dist_mod').append('<option value="'+data[0]+'">'+data[1]+'</option>');
		$('#sel_add_bk_dist_mod').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to populate Users w.r.t a District in Modify User
 * @returns
 */
function popUsersMod() {
	//console.log($("#sel_dist_mod option:selected").val());
	$('#sel_user_mod').html('');
	$.ajax({
		url: "../../popUser.Modify",
		type: "get",
		data: {
			level: 'BK',
			dt_code: $("#sel_dist_mod option:selected").val()
		},
		success: function(response) {
			//console.log(response);			
			if (response == "N/A") {
				bootbox.alert("Unable To get User.");
				$('#sel_user_mod').append('<option value="">Select User</option>');
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				for ( var i = 0; i < obj_response.length; i++) {
					$('#sel_user_mod').append('<option value="'+obj_response[i][1]+'">'+obj_response[i][0]+'</option>');
	  		    }
				//popAssignedBkMod();
				popAssignedBlock();
				hideModal();				
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable To Find data.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to populate Assigned Blocks w.r.t a User
 * @returns
 */
//function popAssignedBkAddMod() {
function popAssignedBlock() {
	//console.log(mod_type);
	//console.log($("#sel_dist_mod option:selected").val());
	//$('#div_asgn_bk_add_mod').html('');
	$('#div_asgn_bk_add_mod').html('');
	$('#div_asgn_bk_del_mod').html('');
	json_bk_del = {};
	
	$.ajax({
		url: "../../popAssignedBlock.Modify",
		type: "get",
		data: {
			user_code: $("#sel_user_mod option:selected").val()
		},
		success: function(response) {
			//console.log(response);			
			if (response == "N/A") {
				bootbox.alert("Unable To get Block.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				//console.log(obj_response);
				json_bk_add = {};
				for ( var i = 0; i < obj_response.length; i++) {
					//$('#sel_user_mod').append('<option value="'+obj_response[i][1]+'">'+obj_response[i][0]+'</option>');
					json_bk_add[obj_response[i][3]] = obj_response[i][4];
					json_bk_del[obj_response[i][3]] = obj_response[i][2]+" - "+obj_response[i][4];
	  		    }
				//console.log(json_bk_add);
				//console.log(json_bk_del);
				
				//console.log(json_bk_add);
				//console.log(json_added_bk);			
				
				//console.log(mod_type);
				//Adding Block for Add Block option				
				if(mod_type == "add") {
					//console.log(json_bk_add);
					//$('#div_asgn_bk_add_mod').html('');
					//$('#div_asgn_bk_del_mod').html('');
					for (var key in json_bk_add) {		
				        var dv = $('<div/>')			        
				    			.attr('id', 'div_'+key)
				    			.appendTo('#div_asgn_bk_add_mod');
					    var lbl = $('<label/>')
					    		.attr('id', 'lbl_'+key)
					    		.text(json_bk_add[key])
					    		.appendTo(dv);
					}
				}				
											
				//Adding Block for Delete Block option
				if(mod_type == "del") {					
					//$('#div_asgn_bk_add_mod').html('');
					//$('#div_asgn_bk_del_mod').html('');
					for (var key in json_bk_del) {		
						/*var dv = $('<div/>')			        
				    			.attr('id', 'div_del_'+key)
				    			.appendTo('#div_asgn_bk_del_mod');
					    var lbl = $('<checkbox/>')
					    		.attr('id', 'chk_del_'+key)
					    		.attr('value', json_bk_del[key])
					    		.text(json_bk_del[key])
					    		.appendTo(dv);*/
						
						var node = document.createElement('div');   
						node.id = "div_"+key;
				        node.innerHTML = '<input type="checkbox" id="'+key+'" name="'+key+'" value="'+json_bk_del[key]+'" onclick=toggleCheckbox(this)> <label for="'+key+'">'+json_bk_del[key]+'</label>';       
				        document.getElementById('div_asgn_bk_del_mod').appendChild(node);
						
					}
				}	
				$("select#sel_add_bk_dist_mod").prop('selectedIndex', 0);
				$('#sel_add_bk_bk_mod').html('');
				$('#sel_add_bk_bk_mod').append('<option value="">Select Block</option>');
				hideModal();				
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable To Find data.");
			hideModal();
			return;
		}
	});
	//console.log(">>>"+mod_type);
}


/**
 * Function to populate Blocks w.r.t a District in Modify User
 * @returns
 */
function popBlockMod() {
	//console.log("before..."+mod_type);
	$('#sel_add_bk_bk_mod')
	.empty()
	.append('<option value="">Select Block</option>');	
	//# Get Block w.r.t.a District
	var arr_bk = GetUniqueBlkBaseDT(objDistBlk, $("#sel_add_bk_dist_mod option:selected").val());
	for (var i = 0; i < arr_bk.length; i++) {
		var booAdd = true;
		var data = arr_bk[i].split("^");
		//$('#sel_add_bk_bk_mod').append('<option value="'+data[0]+'">'+data[1]+'</option>');
		
		if(checkBlockExists(data[0])) {
			$('#sel_add_bk_bk_mod').append('<option value="'+data[0]+'">'+data[1]+'</option>');
		}
	}
	//console.log("..."+mod_type);
}


/**
 * Function to check Block already exists or not
 * @param str_val
 * @returns
 */
function checkBlockExists(str_val) {
	//console.log("Data..."+str_val);
	//console.log(json_bk_add);
	for (var key in json_bk_add) {
		//console.log("Key..."+key);
		if(str_val == key) {
			return false;
		}
	}
	
	for (var key in json_added_bk) {
		//console.log("Key..."+key);
		if(str_val == key) {
			return false;
		}
	}
	return true;
}


/**
 * Click event of Add to List button
 * @returns
 */
$("#btn_add_bk_mod").click(function() {
	var sel_bk_code = $("#sel_add_bk_bk_mod option:selected").val();
	var sel_bk_name = $("#sel_add_bk_bk_mod option:selected").html();
	
	//console.log("..."+sel_bk_code+"...");
	if(sel_bk_code == ""){
		bootbox.alert("Please select a Block.");
		return;
	}
	
	var dv = $('<div/>')			        
			.attr('id', 'div_'+sel_bk_code)
			.appendTo('#div_asgn_bk_add_mod');
	var lbl = $('<label/>')
			.attr('id', 'lbl_'+sel_bk_code)
			.text(sel_bk_name)
			.appendTo(dv);
	
	$("#sel_add_bk_bk_mod option[value='"+sel_bk_code+"']").remove();
	json_added_bk[sel_bk_code] = sel_bk_name;
	//console.log(json_added_bk);	
});


/**
 * Click event of Submit button for Add Block
 * @returns
 */
$("#btn_submit_bk_add_mod").click(function() {
	//console.log(mod_type);
	//return;
	if(Object.keys(json_added_bk).length == 0) {
		bootbox.alert('Please add at least 1 Block.');
		hideModal();
		return;
	}
	bootbox.confirm({
		size: "small",
		title: "Modify User",
		message: "Do you want to add block/s to the User?", 
	    buttons: {
	    	confirm: {
	            label: '<i class="fa fa-check"></i> Yes',
	            className: 'btn-primary'
	        },
	        cancel: {
	            label: '<i class="fa fa-times"></i> No',
	            className: 'btn-danger'
	        }
	    },
	    callback: function(result){
	    	if(result == true) {
	    		var json_param_set = {};	    		 
				json_param_set["user_name"] = $("#sel_user_mod option:selected").val();
				json_param_set["mod_type"] = mod_type;				
				var added_bk = "\"";
				for (var key in json_added_bk) {
					added_bk += "'"+key+"'^"
				}
				added_bk = added_bk.substring(0, (added_bk.length-1));
				added_bk += "\"";				
				json_param_set["added_bk"] = added_bk;
				json_param_set["loginusrid"] = GLOBAL_LOGIN_USER_ID;
	
    			//console.log(json_param_set);
    			//Send Request to server
    			$.ajax({
    				type: 'POST',
    			    // make sure you respect the same origin policy with this url:
    			    url: '../../addBlock.TabletUser',
    			    data: { 
    			    	json_param_set: JSON.stringify(json_param_set),
    			    },
    			    success: function(response){
    			    	//console.log(response);
    			    	var obj_response = JSON.parse(response);
    			    	if (obj_response.status == "1") {
    			    		bootbox.alert({
    			    			message: "Block added successfully.", 
    			    			callback: function(){
    			    				clearDataAddBlock();
    			    			}
    			    		});
    			    		hideModal();
    			    		return;
    					} else {
    						bootbox.alert('Form update failed.');
    						hideModal();
    			    		return;
    					}
    			    },
    			    error: function(xhr) {    			    	
    			    	bootbox.alert('Form update failed.');
    			    	hideModal();
    		    		return;
    			    }
    			}); 
	    	} else {
				hideModal();
				return;
			}
	    }
	}); //# End Confirm
});


/**
 * Click event of Cancel button for Add Block
 * @returns
 */
$("#btn_cancel_bk_add_mod").click(function() {
	clearDataAddBlock();	
});


/**
 * Cancel operation for Add Block
 * @returns
 */
function clearDataAddBlock() {
	$("select#sel_dist_mod").prop('selectedIndex', 0);
	$('#sel_user_mod').html('');
	$('#sel_user_mod').append('<option value="">Select User</option>');
	
	$("select#sel_add_bk_dist_mod").prop('selectedIndex', 0);
	$('#sel_add_bk_bk_mod').html('');
	$('#sel_add_bk_bk_mod').append('<option value="">Select Block</option>');
	
	$("#div_asgn_bk_add_mod").html("");
	
	json_added_bk = {};
	json_bk_add = {};
	json_bk_del = {};
}


/**
 * Function to select block to delete
 * @param chk_id
 * @returns
 */
function toggleCheckbox(chk_id) {
	//console.log(chk_id.id+"..."+chk_id.value+"..."+chk_id.checked);
	if(chk_id.checked) {
		json_added_bk_del[chk_id.id] = chk_id.value;
	} else {
		delete json_added_bk_del[chk_id.id];
	}
	//console.log(json_added_bk_del);
}


/**
 * Click event of Submit button for Delete Block
 * @returns
 */
$("#btn_submit_bk_del_mod").click(function() {
	if(Object.keys(json_added_bk_del).length == 0) {
		bootbox.alert('Please add at least 1 Block.');
		hideModal();
		return;
	}
	bootbox.confirm({
		size: "small",
		title: "Modify User",
		message: "Do you want to delete block/s to the User?", 
	    buttons: {
	    	confirm: {
	            label: '<i class="fa fa-check"></i> Yes',
	            className: 'btn-primary'
	        },
	        cancel: {
	            label: '<i class="fa fa-times"></i> No',
	            className: 'btn-danger'
	        }
	    },
	    callback: function(result){
	    	if(result == true) {
	    		var json_param_set = {};	    		 
				json_param_set["user_name"] = $("#sel_user_mod option:selected").val();
				json_param_set["mod_type"] = mod_type;				
				var added_bk = "\"";
				for (var key in json_added_bk_del) {
					added_bk += "'"+key+"'^"
				}
				added_bk = added_bk.substring(0, (added_bk.length-1));
				added_bk += "\"";				
				json_param_set["added_bk"] = added_bk;
				json_param_set["loginusrid"] = GLOBAL_LOGIN_USER_ID;
	
    			console.log(json_param_set);
    			//Send Request to server
    			$.ajax({
    				type: 'POST',
    			    // make sure you respect the same origin policy with this url:
    			    url: '../../delBlock.TabletUser',
    			    data: { 
    			    	json_param_set: JSON.stringify(json_param_set),
    			    },
    			    success: function(response){
    			    	//console.log(response);
    			    	var obj_response = JSON.parse(response);
    			    	if (obj_response.status == "1") {
    			    		bootbox.alert({
    			    			message: "Block deleted successfully.", 
    			    			callback: function(){
    			    				clearDataDelBlock();
    			    			}
    			    		});
    			    		hideModal();
    			    		return;
    					} else {
    						bootbox.alert('Form update failed.');
    						hideModal();
    			    		return;
    					}
    			    },
    			    error: function(xhr) {    			    	
    			    	bootbox.alert('Form update failed.');
    			    	hideModal();
    		    		return;
    			    }
    			}); 
	    	} else {
				hideModal();
				return;
			}
	    }
	}); //# End Confirm
});


/**
 * Cancel operation for Delete Block
 * @returns
 */
function clearDataDelBlock() {
	$("select#sel_dist_mod").prop('selectedIndex', 0);
	$('#sel_user_mod').html('');
	$('#sel_user_mod').append('<option value="">Select User</option>');
	
	$("#div_asgn_bk_del_mod").html("");
	
	json_added_bk_del = {};
	json_bk_add = {};
	json_bk_del = {};
}


/**
 * Click event of Cancel button for Delete Block
 * @returns
 */
$("#btn_cancel_bk_add_mod").click(function() {
	clearDataDelBlock();	
});

