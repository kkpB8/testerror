var objDtBkVl;


/**
 * Page Ready Function
 * @returns
 */
$(document).ready(function() {
	showModal();
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	$("#div_dt_geo").hide();
	$("#div_bk_geo").hide();
	$("#div_gp_geo").hide();
	$("#div_vl_geo").hide();
	
	popDTBKVl();
});


/**
 * Function to populate DT/BK/VL
 * @returns
 */
function popDTBKVl() {
	$.ajax({
		  url: "../../pop.DtBkVl",
		  type: "get",
		  data: {
			  type	:	'vl'
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get data.");
					hideModal();
					return;
				} else {
					objDtBkVl  = eval ("("+ response +")");
					//console.log(objDtBkVl);
					
					popComboDist();
					hideModal();
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
 * Function to show/hide Combo Box
 * @returns
 */
function showHideCombo() {
	var sel_level = $("#sel_level_geo option:selected").val();
	if(sel_level == "select") {
		bootbox.alert("Please select a Level.");
		$("#div_dt_geo").hide();
		$("#div_bk_geo").hide();
		$("#div_gp_geo").hide();
		$("#div_vl_geo").hide();		
	} else if(sel_level == "DT") {
		$("#div_dt_geo").show();
		$("#div_bk_geo").hide();
		$("#div_gp_geo").hide();
		$("#div_vl_geo").hide();		
	} else if(sel_level == "BK") {
		$("#div_dt_geo").show();
		$("#div_bk_geo").show();
		$("#div_gp_geo").hide();
		$("#div_vl_geo").hide();
	} else if(sel_level == "GP") {
		$("#div_dt_geo").show();
		$("#div_bk_geo").show();
		$("#div_gp_geo").show();
		$("#div_vl_geo").hide();
	} else if(sel_level == "VL") {
		$("#div_dt_geo").show();
		$("#div_bk_geo").show();
		$("#div_gp_geo").show();
		$("#div_vl_geo").show();
	}
	popComboDist();
}

/**
 * Function to clear data for Add Geography
 * @returns
 */
function clearComboData() {
	$('#sel_dt_geo').html('');
	$('#sel_dt_geo').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_geo').html('');
	$('#sel_bk_geo').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#txt_gp_geo').val('');
	$('#sel_vl_geo').html('');
	$('#sel_vl_geo').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDist() {
	//console.log("here in popComboDist...");
	clearComboData();
	$('#sel_dt_geo').html('');
	$('#sel_dt_geo').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDT();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_geo').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDT() {
	var inputArray = objDtBkVl;
	//console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][0]+"^"+inputArray[i][1], outputArray)) == -1){
			outputArray.push(inputArray[i][0]+"^"+inputArray[i][1]);
		}
	}
	return outputArray;
}


/**
 * District change event
 * @param e
 * @returns
 */
$('#sel_dt_geo').on("change", function(e) {
	$('#sel_bk_geo').html('');	
	$('#sel_bk_geo').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#txt_gp_geo').val('');
	$('#sel_vl_geo').html('');
	$('#sel_vl_geo').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	
	var arr_bk = GetUniqueBK();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_geo').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBK() {
	var inputArray = objDtBkVl;
	var dt_code = $("#sel_dt_geo option:selected").val()	
	//console.log(dt_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][0] == dt_code){
			if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][3], outputArray)) == -1){
				outputArray.push(inputArray[i][2]+"^"+inputArray[i][3]);
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
$('#sel_bk_geo').on("change", function(e) {
	$('#txt_gp_geo').val('');
	$('#sel_vl_geo').html('');
	$('#sel_vl_geo').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	
	var arr_vl = GetUniqueVL();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_geo').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVL() {
	var inputArray = objDtBkVl;
	var bk_code = $("#sel_bk_geo option:selected").val()	
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][2] == bk_code){
			if ((jQuery.inArray(inputArray[i][4]+"^"+inputArray[i][5], outputArray)) == -1){
				outputArray.push(inputArray[i][4]+"^"+inputArray[i][5]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to add Geography
 * @returns
 */
function addGeography() {
	var sel_level = $("#sel_level_geo option:selected").val();
	if(sel_level == "select") {
		bootbox.alert("Please select a Level.");
		hideModal();	    			    	
		return;		
	} else if(sel_level == "DT") {
		if($("#sel_dt_geo option:selected").val() == "select") {
			bootbox.alert("Please select a District.");
			hideModal();
			return;
		}				
	} else if(sel_level == "BK") {
		if($("#sel_dt_geo option:selected").val() == "select") {
			bootbox.alert("Please select a District.");
			hideModal();
			return;
		}
		if($("#sel_bk_geo option:selected").val() == "select") {
			bootbox.alert("Please select a Block.");
			hideModal();
			return;
		}
	} else if(sel_level == "GP") {
		if($("#sel_dt_geo option:selected").val() == "select") {
			bootbox.alert("Please select a District.");
			hideModal();
			return;
		}
		if($("#sel_bk_geo option:selected").val() == "select") {
			bootbox.alert("Please select a Block.");
			hideModal();
			return;
		}
		if($("#sel_gp_geo").val() == "") {
			bootbox.alert("Please enter GP Name.");
			hideModal();
			return;
		}
	} else if(sel_level == "VL") {
		if($("#sel_dt_geo option:selected").val() == "select") {
			bootbox.alert("Please select a District.");
			hideModal();
			return;
		}
		if($("#sel_bk_geo option:selected").val() == "select") {
			bootbox.alert("Please select a Block.");
			hideModal();
			return;
		}
		if($("#sel_gp_geo").val() == "") {
			bootbox.alert("Please enter GP Name.");
			hideModal();
			return;
		}
		if($("#sel_vl_geo option:selected").val() == "select") {
			bootbox.alert("Please select a Village.");
			hideModal();
			return;
		}
	}
	
	bootbox.confirm({
		size: "small",
		title: "Add Geography",
		message: "Do you want to add the data?", 
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
	    		 json_param_set["sel_level"] = sel_level;
	    		 if(sel_level == "DT") {
	    			 json_param_set["sel_dt"] = $("#sel_dt_geo option:selected").val();
	    			 json_param_set["sel_bk"] = "N/A";
	    			 json_param_set["sel_gp"] = "N/A";
	    			 json_param_set["sel_vl"] = "N/A";
	    		 }
	    		 else if(sel_level == "BK") {
	    			 json_param_set["sel_dt"] = $("#sel_dt_geo option:selected").val();
	    			 json_param_set["sel_bk"] = $("#sel_bk_geo option:selected").val();
	    			 json_param_set["sel_gp"] = "N/A";
	    			 json_param_set["sel_vl"] = "N/A";
	    		 }
	    		 else if(sel_level == "GP") {
	    			 json_param_set["sel_dt"] = $("#sel_dt_geo option:selected").val();
	    			 json_param_set["sel_bk"] = $("#sel_bk_geo option:selected").val();
	    			 json_param_set["sel_gp"] = $("#txt_gp_geo").val();
	    			 json_param_set["sel_vl"] = "N/A";
	    		 }
	    		 else if(sel_level == "VL") {
	    			 json_param_set["sel_dt"] = $("#sel_dt_geo option:selected").val();
	    			 json_param_set["sel_bk"] = $("#sel_bk_geo option:selected").val();
	    			 json_param_set["sel_gp"] = $("#txt_gp_geo").val();
	    			 json_param_set["sel_vl"] = $("#sel_vl_geo option:selected").val();
	    		 }
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 //console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../add.Geography',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Data added successfully.", 
    							 callback: function(){
    								 popDTBKVl();
    							 }
    						 });    						 
    						 hideModal();
    						 return;
    					 } else if (obj_response.status == "0") {
    						 bootbox.alert({
    							 message: "Data already added.", 
    							 callback: function(){
    								 popDTBKVl();
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
 * Function to clear all Data
 * @returns
 */
function clearData() {
	$("select#sel_level_geo").prop('selectedIndex', 0);
	clearComboData();
}
