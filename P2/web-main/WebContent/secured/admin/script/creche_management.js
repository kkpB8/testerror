var objStDtBkGpVlCr;

/**
 * Page Ready Function
 * @returns
 */
$(document).ready(function() {
	showModal();
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	$("#div_cr_mgnt_add").show();
	$("#div_cr_mgnt_del").hide();
	$("#div_cr_mgnt_shf").hide();
	
	//var cur_mnth_yr = $('#cur_date').val().substring(0, 7);
	//console.log(cur_mnth_yr);
	//$("#sel_mnth_yr_add").val(cur_mnth_yr);	
	/*$('.from').datepicker({
		autoclose: true,	
	    minViewMode: 1,
	    format: 'yyyy-mm-dd',
	}).on('changeDate', function(selected){
		startDate = new Date(selected.date.valueOf());
	    startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
	});*/

	//var cur_date = $('#cur_date').val();
	//$("#sel_date_add").val(cur_date);
	$('#dv_cr_add').datepicker({
		autoclose: true,
		format: 'dd-mm-yyyy',
		todayHighlight: true,
		//Future Date not accepted
		endDate: new Date(),
	});
	popStDtBkGpVlCr('add');	
});


/**
 * Function to populate ST/DT/BK/GP/VL/CR
 * @param type
 * @returns
 */
function popStDtBkGpVlCr(type) {
	showModal();
	$.ajax({
		  url: "../../pop.StDtBkGpVlCr",
		  type: "get",
		  data: {
			  
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get data.");
					hideModal();
					return;
				} else {
					objStDtBkGpVlCr  = eval ("("+ response +")");
					//console.log(objStDtBkGpVlCr);
					if(type == 'add') {
						popComboDistAdd();
						hideModal();
					} else if(type == 'del') {
						popComboDistDel();
						hideModal();
					} else if(type == 'shf') {
						popComboDistShfSrc();
						hideModal();
					}
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get data.");
			  hideModal();
			  return;
		  }
	});
}

/**
 * Function to show/hide div
 * @param id
 * @returns
 */
function showHideDiv(id) {
	switch (id) {
	case "D":
		$("#div_cr_mgnt_add").hide();
		$("#div_cr_mgnt_del").show();
		$("#div_cr_mgnt_shf").hide();
		popStDtBkGpVlCr('del');
		break;
	case "S":
		$("#div_cr_mgnt_add").hide();
		$("#div_cr_mgnt_del").hide();
		$("#div_cr_mgnt_shf").show();
		popStDtBkGpVlCr('shf');
		break;
	default:
		$("#div_cr_mgnt_add").show();
		$("#div_cr_mgnt_del").hide();
		$("#div_cr_mgnt_shf").hide();
		popStDtBkGpVlCr('add');
		break;
	}
} //# End displaydiv



////////////////////////////////////////////////-----------CREATE CRECHE START-----------////////////////////////////////////////////////

/**
 * Function to clear data for Create Creche
 * @returns
 */
function clearComboDataCrAdd() {
	$('#sel_dt_add').html('');
	$('#sel_dt_add').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_add').html('');
	$('#sel_bk_add').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_add').html('');
	$('#sel_gp_add').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_add').html('');
	$('#sel_vl_add').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
	$('#sel_cr_add').html('');
	$('#sel_cr_add').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistAdd() {
	//console.log("here in popComboDistAdd...");
	clearComboDataCrAdd();
	$('#sel_dt_add').html('');
	$('#sel_dt_add').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTAdd();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_add').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTAdd() {
	var inputArray = objStDtBkGpVlCr;
	//console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
			outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
		}
	}
	return outputArray;
}


/**
 * District change event
 * @param e
 * @returns
 */
$('#sel_dt_add').on("change", function(e) {
	$('#sel_bk_add').html('');	
	$('#sel_bk_add').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_add').html('');
	$('#sel_gp_add').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_add').html('');
	$('#sel_vl_add').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_add').html('');
	$('#sel_cr_add').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_bk = GetUniqueBKAdd();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_add').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKAdd() {
	var inputArray = objStDtBkGpVlCr;
	var dt_code = $("#sel_dt_add option:selected").val();
	//console.log(dt_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2] == dt_code){
			if ((jQuery.inArray(inputArray[i][4]+"^"+inputArray[i][5], outputArray)) == -1){
				outputArray.push(inputArray[i][4]+"^"+inputArray[i][5]);
			}
		}
	}
	return outputArray;
}


/**
 * Block change event
 * @param e
 * @returns
 */
$('#sel_bk_add').on("change", function(e) {
	$('#sel_gp_add').html('');
	$('#sel_gp_add').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_add').html('');
	$('#sel_vl_add').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_add').html('');
	$('#sel_cr_add').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_gp = GetUniqueGPAdd();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_add').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPAdd() {
	var inputArray = objStDtBkGpVlCr;
	var bk_code = $("#sel_bk_add option:selected").val();	
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == bk_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
			}
		}
	}
	return outputArray;
}


/**
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_add').on("change", function(e) {
	$('#sel_vl_add').html('');
	$('#sel_vl_add').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_add').html('');
	$('#sel_cr_add').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueVLAdd();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_add').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLAdd() {
	var inputArray = objStDtBkGpVlCr;
	var gp_code = $("#sel_gp_add option:selected").val();	
	//console.log(gp_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == gp_code){
			if ((jQuery.inArray(inputArray[i][8]+"^"+inputArray[i][9], outputArray)) == -1){
				outputArray.push(inputArray[i][8]+"^"+inputArray[i][9]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to create New Creche
 * @returns
 */
function createCreche() {
	if($("#sel_dt_add option:selected").val() == "select") {
		//bootbox.alert("Please select a District.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a District."
		});
		hideModal();
		return;
	}
	if($("#sel_bk_add option:selected").val() == "select") {
		//bootbox.alert("Please select a Block.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Block."
		});
		hideModal();
		return;
	}
	if($("#sel_gp_add option:selected").val() == "select") {
		//bootbox.alert("Please select a GP.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a GP."
		});
		hideModal();
		return;
	}
	if($("#sel_vl_add option:selected").val() == "select") {
		//bootbox.alert("Please select a Village.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Village."
		});
		hideModal();
		return;
	}
	if($("#txt_cr_add").val() == "") {
		//bootbox.alert("Please enter a Creche Name.");
		bootbox.alert({
		    size: "small",
		    message: "Please enter a Creche Name."
		});
		hideModal();
		return;
	}
	if($("#sel_func_add option:selected").val() == "select") {
		//bootbox.alert("Please select wheter the Creche is Functional or not.");
		bootbox.alert({
		    size: "small",
		    message: "Please select wheter the Creche is Functional or not."
		});
		hideModal();
		return;
	}
	if($("#sel_type_add option:selected").val() == "select") {
		//bootbox.alert("Please select Creche type.");
		bootbox.alert({
		    size: "small",
		    message: "Please select Creche type."
		});
		hideModal();
		return;
	}
	//# 28.01.2022
	if($("#sel_prj_prog option:selected").val() == "select") {
		//bootbox.alert("Please select Project/Programme.");
		bootbox.alert({
		    size: "small",
		    message: "Please select Project/Programme."
		})
		hideModal();
		return;
	}	
	if($("#sel_date_add").val() == "") {
		//bootbox.alert("Please enter a Date.");
		bootbox.alert({
		    size: "small",
		    message: "Please enter a Date."
		});
		hideModal();
		return;
	}
	if($("#txt_remarks_add").val() == "") {
		//bootbox.alert("Please enter a Remarks.");
		bootbox.alert({
		    size: "small",
		    message: "Please enter a Remarks."
		});
		hideModal();
		return;
	}
	
	bootbox.confirm({
		size: "small",
		title: "Create Creche",
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
	    		 showModal();
	    		 
	    		 var json_param_set = {};	    		 
	    		 json_param_set["opt_type"] = "A";
    			 json_param_set["sel_dt_add"] = $("#sel_dt_add option:selected").val();
    			 json_param_set["sel_bk_add"] = $("#sel_bk_add option:selected").val();
    			 json_param_set["sel_gp_add"] = $("#sel_gp_add option:selected").val();
    			 json_param_set["sel_vl_add"] = $("#sel_vl_add option:selected").val();
    			 json_param_set["txt_cr_add_code"] = "N/A";
    			 json_param_set["txt_cr_add"] = $("#txt_cr_add").val();
    			 json_param_set["sel_func_add"] = $("#sel_func_add option:selected").val();
    			 json_param_set["sel_type_add"] = $("#sel_type_add option:selected").val();
    			 json_param_set["sel_prj_prog"] = $("#sel_prj_prog option:selected").val(); //# 28.01.2022
    			 json_param_set["sel_date_add"] = $("#sel_date_add").val();
    			 json_param_set["txt_remarks_add"] = $("#txt_remarks_add").val();
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 //console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../create.Creche',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Creche created successfully.", 
    							 callback: function(){
    								 popStDtBkGpVlCr('add');	
    								 clearDataCrtAdd();
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
	});
}


/**
 * Function to clear Data for create Creche
 * @returns
 */
function clearDataCrtAdd() {
	popComboDistAdd();
	$("select#sel_func_add").prop('selectedIndex', 0);
	$("select#sel_type_add").prop('selectedIndex', 0);
	$("select#sel_prj_prog").prop('selectedIndex', 0);
	$('#txt_cr_add').val('');
	$('#sel_date_add').val('');
	$('#txt_remarks_add').val('');
}

////////////////////////////////////////////////-----------CREATE CRECHE END-----------////////////////////////////////////////////////



////////////////////////////////////////////////-----------DELETE CRECHE START-----------////////////////////////////////////////////////

/**
 * Function to clear data for Create Creche
 * @returns
 */
function clearComboDataCrDel() {
	$('#sel_dt_del').html('');
	$('#sel_dt_del').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_del').html('');
	$('#sel_bk_del').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_del').html('');
	$('#sel_gp_del').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_del').html('');
	$('#sel_vl_del').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
	$('#sel_cr_del').html('');
	$('#sel_cr_del').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistDel() {
	//console.log("here in popComboDistDel...");
	clearComboDataCrDel();
	$('#sel_dt_del').html('');
	$('#sel_dt_del').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTDel();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_del').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTDel() {
	var inputArray = objStDtBkGpVlCr;
	//console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
			outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
		}
	}
	return outputArray;
}


/**
 * District change event
 * @param e
 * @returns
 */
$('#sel_dt_del').on("change", function(e) {
	$('#sel_bk_del').html('');	
	$('#sel_bk_del').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_del').html('');
	$('#sel_gp_del').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_del').html('');
	$('#sel_vl_del').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_del').html('');
	$('#sel_cr_del').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_bk = GetUniqueBKDel();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_del').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKDel() {
	var inputArray = objStDtBkGpVlCr;
	var dt_code = $("#sel_dt_del option:selected").val();
	//console.log(dt_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2] == dt_code){
			if ((jQuery.inArray(inputArray[i][4]+"^"+inputArray[i][5], outputArray)) == -1){
				outputArray.push(inputArray[i][4]+"^"+inputArray[i][5]);
			}
		}
	}
	return outputArray;
}


/**
 * Block change event
 * @param e
 * @returns
 */
$('#sel_bk_del').on("change", function(e) {
	$('#sel_gp_del').html('');
	$('#sel_gp_del').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_del').html('');
	$('#sel_vl_del').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_del').html('');
	$('#sel_cr_del').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_gp = GetUniqueGPDel();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_del').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPDel() {
	var inputArray = objStDtBkGpVlCr;
	var bk_code = $("#sel_bk_del option:selected").val();
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == bk_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
			}
		}
	}
	return outputArray;
}


/**
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_del').on("change", function(e) {
	$('#sel_vl_del').html('');
	$('#sel_vl_del').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_del').html('');
	$('#sel_cr_del').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueVLDel();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_del').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLDel() {
	var inputArray = objStDtBkGpVlCr;
	var gp_code = $("#sel_gp_del option:selected").val();	
	//console.log(gp_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == gp_code){
			if ((jQuery.inArray(inputArray[i][8]+"^"+inputArray[i][9], outputArray)) == -1){
				outputArray.push(inputArray[i][8]+"^"+inputArray[i][9]);
			}
		}
	}
	return outputArray;
}


/**
 * Village change event
 * @param e
 * @returns
 */
$('#sel_vl_del').on("change", function(e) {
	$('#sel_cr_del').html('');
	$('#sel_cr_del').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_cr = GetUniqueCRDel();
	for (var i = 0; i < arr_cr.length; i++) {
		var data = arr_cr[i].split("^");
		$('#sel_cr_del').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCRDel() {
	var inputArray = objStDtBkGpVlCr;
	var vl_code = $("#sel_vl_del option:selected").val();	
	//console.log(vl_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][8] == vl_code){
			if ((jQuery.inArray(inputArray[i][10]+"^"+inputArray[i][11], outputArray)) == -1){
				outputArray.push(inputArray[i][10]+"^"+inputArray[i][11]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to delete Existing Creche
 * @returns
 */
function deleteCreche() {
	if($("#sel_dt_del option:selected").val() == "select") {
		//bootbox.alert("Please select a District.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a District."
		});
		hideModal();
		return;
	}
	if($("#sel_bk_del option:selected").val() == "select") {
		//bootbox.alert("Please select a Block.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Block."
		});
		hideModal();
		return;
	}
	if($("#sel_gp_del option:selected").val() == "select") {
		//bootbox.alert("Please select a GP.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a GP."
		});
		hideModal();
		return;
	}
	if($("#sel_vl_del option:selected").val() == "select") {
		//bootbox.alert("Please select a Village.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Village."
		});
		hideModal();
		return;
	}
	if($("#sel_cr_del option:selected").val() == "select") {
		//bootbox.alert("Please select a creche.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a creche."
		});
		hideModal();
		return;
	}
	if($("#txt_remarks_del").val() == "") {
		//bootbox.alert("Please select a remarks.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a remarks."
		});
		hideModal();
		return;
	}
	
	bootbox.confirm({
		size: "small",
		title: "Delete Creche",
		message: "Do you want to delete the data?", 
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
	    		 showModal();
	    		 
	    		 var json_param_set = {};	    		 
	    		 json_param_set["opt_type"] = "D";
    			 json_param_set["sel_dt_del"] = $("#sel_dt_del option:selected").val();
    			 json_param_set["sel_bk_del"] = $("#sel_bk_del option:selected").val();
    			 json_param_set["sel_gp_del"] = $("#sel_gp_del option:selected").val();
    			 json_param_set["sel_vl_del"] = $("#sel_vl_del option:selected").val();
    			 json_param_set["sel_cr_del"] = $("#sel_cr_del option:selected").val();
    			 json_param_set["txt_cr_del_name"] = "N/A";
    			 json_param_set["sel_func_del"] = "N/A";
    			 json_param_set["sel_type_del"] = "N/A";
    			 json_param_set["sel_date_del"] = "N/A";
    			 json_param_set["txt_remarks_del"] = $("#txt_remarks_del").val();
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 //console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../delete.Creche',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Creche deleted successfully.", 
    							 callback: function(){
    								 popStDtBkGpVlCr('del');	
    								 //clearComboDataCrDel();
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
	});
}

////////////////////////////////////////////////-----------DELETE CRECHE END-----------////////////////////////////////////////////////


////////////////////////////////////////////////-----------SHIFT CRECHE START-----------////////////////////////////////////////////////

/**
 * Function to clear data for Source Creche
 * @returns
 */
function clearComboDataCrShfSrc() {
	$('#sel_dt_shf_src').html('');
	$('#sel_dt_shf_src').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_shf_src').html('');
	$('#sel_bk_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_shf_src').html('');
	$('#sel_gp_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_shf_src').html('');
	$('#sel_vl_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
	$('#sel_cr_shf_src').html('');
	$('#sel_cr_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');	
	
	$('#sel_dt_shf_des').html('');
	$('#sel_dt_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_shf_des').html('');
	$('#sel_bk_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_shf_des').html('');
	$('#sel_gp_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_shf_des').html('');
	$('#sel_vl_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	
	$('#txt_remarks_shf_des').val('');
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistShfSrc() {
	//console.log("here in popComboDistShf...");
	clearComboDataCrShfSrc();
	$('#sel_dt_shf_src').html('');
	$('#sel_dt_shf_src').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTShfSrc();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTShfSrc() {
	var inputArray = objStDtBkGpVlCr;
	//console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
			outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
		}
	}
	return outputArray;
}


/**
 * District change event
 * @param e
 * @returns
 */
$('#sel_dt_shf_src').on("change", function(e) {
	$("#lblCrchPrjPrg").text('');
	$("#sel_prj_prog_des").val('select');
	$('#sel_bk_shf_src').html('');	
	$('#sel_bk_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_shf_src').html('');
	$('#sel_gp_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_shf_src').html('');
	$('#sel_vl_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_shf_src').html('');
	$('#sel_cr_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_bk = GetUniqueBKShfSrc();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKShfSrc() {
	var inputArray = objStDtBkGpVlCr;
	var dt_code = $("#sel_dt_shf_src option:selected").val();	
	//console.log(dt_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2] == dt_code){
			if ((jQuery.inArray(inputArray[i][4]+"^"+inputArray[i][5], outputArray)) == -1){
				outputArray.push(inputArray[i][4]+"^"+inputArray[i][5]);
			}
		}
	}
	return outputArray;
}


/**
 * Block change event
 * @param e
 * @returns
 */
$('#sel_bk_shf_src').on("change", function(e) {
	$("#lblCrchPrjPrg").text('');
	$("#sel_prj_prog_des").val('select');
	$('#sel_gp_shf_src').html('');
	$('#sel_gp_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_shf_src').html('');
	$('#sel_vl_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_shf_src').html('');
	$('#sel_cr_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_gp = GetUniqueGPShfSrc();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPShfSrc() {
	var inputArray = objStDtBkGpVlCr;
	var bk_code = $("#sel_bk_shf_src option:selected").val();
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == bk_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
			}
		}
	}
	return outputArray;
}


/**
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_shf_src').on("change", function(e) {
	$("#lblCrchPrjPrg").text('');
	$("#sel_prj_prog_des").val('select');
	$('#sel_vl_shf_src').html('');
	$('#sel_vl_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_shf_src').html('');
	$('#sel_cr_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueVLShfSrc();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLShfSrc() {
	var inputArray = objStDtBkGpVlCr;
	var gp_code = $("#sel_gp_shf_src option:selected").val();	
	//console.log(gp_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == gp_code){
			if ((jQuery.inArray(inputArray[i][8]+"^"+inputArray[i][9], outputArray)) == -1){
				outputArray.push(inputArray[i][8]+"^"+inputArray[i][9]);
			}
		}
	}
	return outputArray;
}


/**
 * Village change event
 * @param e
 * @returns
 */
$('#sel_vl_shf_src').on("change", function(e) {
	$("#lblCrchPrjPrg").text('');
	$("#sel_prj_prog_des").val('select');
	$('#sel_cr_shf_src').html('');
	$('#sel_cr_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_cr = GetUniqueCRShfSrc();
	for (var i = 0; i < arr_cr.length; i++) {
		var data = arr_cr[i].split("^");
		$('#sel_cr_shf_src').append('<option value="'+data[0]+'" name="'+data[2]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCRShfSrc() {
	var inputArray = objStDtBkGpVlCr;
	var vl_code = $("#sel_vl_shf_src option:selected").val();	
	//console.log(vl_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][8] == vl_code){
			if ((jQuery.inArray(inputArray[i][10]+"^"+inputArray[i][11]+"^"+inputArray[i][12], outputArray)) == -1){
				outputArray.push(inputArray[i][10]+"^"+inputArray[i][11]+"^"+inputArray[i][12]);
			}
		}
	}
	return outputArray;
}


/**
 * Creche change event
 * @param e
 * @returns
 */
$('#sel_cr_shf_src').on("change", function(e) {
	$("#lblCrchPrjPrg").text($("#sel_cr_shf_src option:selected").attr("name"));
	$("#sel_prj_prog_des").val($("#sel_cr_shf_src option:selected").attr("name"));
	
	popComboDistShfDes();
});


/**
 * Function to clear data for Destination Creche
 * @returns
 */
function clearComboDataCrShfDes() {
	$('#sel_dt_shf_des').html('');
	$('#sel_dt_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_shf_des').html('');
	$('#sel_bk_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_shf_des').html('');
	$('#sel_gp_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_shf_des').html('');
	$('#sel_vl_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistShfDes() {
	//console.log("here in popComboDistShf...");
	clearComboDataCrShfDes();
	$('#sel_dt_shf_des').html('');
	$('#sel_dt_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTShfDes();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTShfDes() {
	var inputArray = objStDtBkGpVlCr;
	//console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
			outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
		}
	}
	return outputArray;
}


/**
 * District change event
 * @param e
 * @returns
 */
$('#sel_dt_shf_des').on("change", function(e) {
	$('#sel_bk_shf_des').html('');	
	$('#sel_bk_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_shf_des').html('');
	$('#sel_gp_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_shf_des').html('');
	$('#sel_vl_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	var arr_bk = GetUniqueBKShfDes();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKShfDes() {
	var inputArray = objStDtBkGpVlCr;
	var dt_code = $("#sel_dt_shf_des option:selected").val();	
	//console.log(dt_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2] == dt_code){
			if ((jQuery.inArray(inputArray[i][4]+"^"+inputArray[i][5], outputArray)) == -1){
				outputArray.push(inputArray[i][4]+"^"+inputArray[i][5]);
			}
		}
	}
	return outputArray;
}


/**
 * Block change event
 * @param e
 * @returns
 */
$('#sel_bk_shf_des').on("change", function(e) {
	$('#sel_gp_shf_des').html('');
	$('#sel_gp_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_shf_des').html('');
	$('#sel_vl_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	var arr_gp = GetUniqueGPShfDes();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPShfDes() {
	var inputArray = objStDtBkGpVlCr;
	var bk_code = $("#sel_bk_shf_des option:selected").val();
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == bk_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
			}
		}
	}
	return outputArray;
}


/**
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_shf_des').on("change", function(e) {
	//console.log("here...");
	$('#sel_vl_shf_des').html('');
	$('#sel_vl_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	var arr_vl = GetUniqueVLShfDes();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLShfDes() {
	var inputArray = objStDtBkGpVlCr;
	var gp_code = $("#sel_gp_shf_des option:selected").val();
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == gp_code){
			if ((jQuery.inArray(inputArray[i][8]+"^"+inputArray[i][9], outputArray)) == -1){
				outputArray.push(inputArray[i][8]+"^"+inputArray[i][9]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to shift Existing Creche
 * @returns
 */
function shiftCreche() {
	if($("#sel_dt_shf_src option:selected").val() == "select") {
		//bootbox.alert("Please select a Source District.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Source District."
		});
		hideModal();
		return;
	}
	if($("#sel_bk_shf_src option:selected").val() == "select") {
		//bootbox.alert("Please select a Source Block.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Source Block."
		});
		hideModal();
		return;
	}
	if($("#sel_gp_shf_src option:selected").val() == "select") {
		//bootbox.alert("Please select a Source GP.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Source GP."
		});
		hideModal();
		return;
	}
	if($("#sel_vl_shf_src option:selected").val() == "select") {
		//bootbox.alert("Please select a Source Village.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Source Village."
		});
		hideModal();
		return;
	}
	if($("#sel_cr_shf_src option:selected").val() == "select") {
		//bootbox.alert("Please select a Source Creche.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Source Creche."
		});
		hideModal();
		return;
	}
	if($("#sel_dt_shf_des option:selected").val() == "select") {
		//bootbox.alert("Please select a Destination District.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Destination District."
		});
		hideModal();
		return;
	}
	if($("#sel_bk_shf_des option:selected").val() == "select") {
		//bootbox.alert("Please select a Destination Block.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Destination Block."
		});
		hideModal();
		return;
	}
	if($("#sel_gp_shf_des option:selected").val() == "select") {
		//bootbox.alert("Please select a Destination GP.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Destination GP."
		});
		hideModal();
		return;
	}
	if($("#sel_vl_shf_des option:selected").val() == "select") {
		//bootbox.alert("Please select a Destination Village.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Destination Village."
		});
		hideModal();
		return;
	}
	if($("#sel_prj_prog_des option:selected").val() == "select") {
		//bootbox.alert("Please select a Destination Project/Programme.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a Destination Project/Programme."
		});
		hideModal();
		return;
	}
	
	if($("#txt_remarks_shf_des").val() == "") {
		//bootbox.alert("Please select a remarks.");
		bootbox.alert({
		    size: "small",
		    message: "Please select a remarks."
		});
		hideModal();
		return;
	}
	
	if($("#sel_vl_shf_src option:selected").val() == $("#sel_vl_shf_des option:selected").val()) {
		//bootbox.alert("Source & destination village should not be same.");
		bootbox.alert({
		    size: "small",
		    message: "Source & destination village should not be same."
		});
		hideModal();
		return;
	}
	
	bootbox.confirm({
		size: "small",
		title: "Shift Creche",
		message: "Do you want to shift the Creche?", 
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
	    		 showModal();
	    		 
	    		 var json_param_set = {};	    		 
	    		 json_param_set["opt_type"] = "S";
    			 json_param_set["sel_dt_shf_des"] = $("#sel_dt_shf_des option:selected").val();
    			 json_param_set["sel_bk_shf_des"] = $("#sel_bk_shf_des option:selected").val();
    			 json_param_set["sel_gp_shf_des"] = $("#sel_gp_shf_des option:selected").val();
    			 json_param_set["sel_vl_shf_des"] = $("#sel_vl_shf_des option:selected").val();
    			 json_param_set["sel_cr_shf_src"] = $("#sel_cr_shf_src option:selected").val();
    			 //json_param_set["txt_cr_shf_src_name"] = "N/A";
    			 json_param_set["sel_prj_prog_shf_des"] = $("#sel_prj_prog_des option:selected").val(); //# 02.02.2022
    			 json_param_set["txt_remarks_shf_des"] = $("#txt_remarks_shf_des").val();
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 //console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../shift.Creche',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Creche shifted successfully.", 
    							 callback: function(){
    								 popStDtBkGpVlCr('shf');	
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
	});
}


////////////////////////////////////////////////-----------SHIFT CRECHE END-----------////////////////////////////////////////////////
