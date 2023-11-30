var objStDtBkGpVlCrCh;

/**
 * Page Ready Function
 * @returns
 */
$(document).ready(function() {
	showModal();
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	popStDtBkGpVlCrCh();	
});

/**
 * Function to populate ST/DT/BK/GP/VL/CR/CH
 * @param type
 * @returns
 */
function popStDtBkGpVlCrCh() {
	showModal();
	$.ajax({
		url: "../../pop.DtBkGpVlCrCh",
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
				objStDtBkGpVlCrCh  = eval ("("+ response +")");
				//console.log(objStDtBkGpVlCrCh);
				popComboDistChldShfSrc();
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
 * Function to clear data for Source Child
 * @returns
 */
function clearComboDataChldShfSrc() {	
	$('#sel_dt_ch_shf_src').html('');
	$('#sel_dt_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_ch_shf_src').html('');
	$('#sel_bk_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_ch_shf_src').html('');
	$('#sel_gp_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_ch_shf_src').html('');
	$('#sel_vl_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
	$('#sel_cr_ch_shf_src').html('');
	$('#sel_cr_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	
	$('#sel_dt_ch_shf_des').html('');
	$('#sel_dt_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_ch_shf_des').html('');
	$('#sel_bk_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_ch_shf_des').html('');
	$('#sel_gp_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_ch_shf_des').html('');
	$('#sel_vl_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistChldShfSrc() {
	//console.log("here in popComboDistChldShfSrc...");
	clearComboDataChldShfSrc();
	$('#sel_dt_ch_shf_src').html('');
	$('#sel_dt_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTChldShfSrc();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}

/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
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
$('#sel_dt_ch_shf_src').on("change", function(e) {
	$('#sel_bk_ch_shf_src').html('');	
	$('#sel_bk_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_ch_shf_src').html('');
	$('#sel_gp_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_ch_shf_src').html('');
	$('#sel_vl_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_src').html('');
	$('#sel_cr_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	var arr_bk = GetUniqueBKChldShfSrc();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
	var dt_code = $("#sel_dt_ch_shf_src option:selected").val()	
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
$('#sel_bk_ch_shf_src').on("change", function(e) {
	$('#sel_gp_ch_shf_src').html('');
	$('#sel_gp_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_ch_shf_src').html('');
	$('#sel_vl_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_src').html('');
	$('#sel_cr_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	var arr_gp = GetUniqueGPChldShfSrc();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
	var bk_code = $("#sel_bk_ch_shf_src option:selected").val()	
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
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_ch_shf_src').on("change", function(e) {
	$('#sel_vl_ch_shf_src').html('');
	$('#sel_vl_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_src').html('');
	$('#sel_cr_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	var arr_vl = GetUniqueVLChldShfSrc();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
	var gp_code = $("#sel_gp_ch_shf_src option:selected").val()	
	//console.log(gp_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == gp_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
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
$('#sel_vl_ch_shf_src').on("change", function(e) {
	$('#sel_cr_ch_shf_src').html('');
	$('#sel_cr_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	var arr_cr = GetUniqueCRChldShfSrc();
	for (var i = 0; i < arr_cr.length; i++) {
		var data = arr_cr[i].split("^");
		$('#sel_cr_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCRChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
	var vl_code = $("#sel_vl_ch_shf_src option:selected").val()	
	//console.log(vl_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == vl_code){
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
$('#sel_cr_ch_shf_src').on("change", function(e) {
	$('#sel_ch_ch_shf_src').html('');
	$('#sel_ch_ch_shf_src').append('<option disabled="disabled" selected="true" value="select">Select Child</option>');
	var arr_cr = GetUniqueCHChldShfSrc();
	for (var i = 0; i < arr_cr.length; i++) {
		var data = arr_cr[i].split("^");
		$('#sel_ch_ch_shf_src').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Child
 * @returns
 */
function GetUniqueCHChldShfSrc() {
	var inputArray = objStDtBkGpVlCrCh;
	var cr_code = $("#sel_cr_ch_shf_src option:selected").val()	
	//console.log(cr_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][8] == cr_code){
			if ((jQuery.inArray(inputArray[i][10]+"^"+inputArray[i][12], outputArray)) == -1){
				outputArray.push(inputArray[i][10]+"^"+inputArray[i][12]);
			}
		}
	}
	return outputArray;
}

/**
 * Child change event
 * @param e
 * @returns
 */
$('#sel_ch_ch_shf_src').on("change", function(e) {
	popComboDistChldShfDes();
});


/**
 * Function to clear data for Source Child
 * @returns
 */
function clearComboDataChldShfDes() {	     
	$('#sel_dt_ch_shf_des').html('');
	$('#sel_dt_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk_ch_shf_des').html('');
	$('#sel_bk_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp_ch_shf_des').html('');
	$('#sel_gp_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl_ch_shf_des').html('');
	$('#sel_vl_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
}

/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDistChldShfDes() {
	//console.log("here in popComboDistShf...");
	clearComboDataChldShfDes();
	$('#sel_dt_ch_shf_des').html('');
	$('#sel_dt_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDTChldShfDes();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt_ch_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
}

/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDTChldShfDes() {
	var inputArray = objStDtBkGpVlCrCh;
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
$('#sel_dt_ch_shf_des').on("change", function(e) {
	$('#sel_bk_ch_shf_des').html('');	
	$('#sel_bk_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp_ch_shf_des').html('');
	$('#sel_gp_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_ch_shf_des').html('');
	$('#sel_vl_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_bk = GetUniqueBKChldShfDes();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk_ch_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBKChldShfDes() {
	var inputArray = objStDtBkGpVlCrCh;
	var dt_code = $("#sel_dt_ch_shf_des option:selected").val()	
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
$('#sel_bk_ch_shf_des').on("change", function(e) {
	$('#sel_gp_ch_shf_des').html('');
	$('#sel_gp_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl_ch_shf_des').html('');
	$('#sel_vl_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_gp = GetUniqueGPChldShfDes();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp_ch_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGPChldShfDes() {
	var inputArray = objStDtBkGpVlCrCh;
	var bk_code = $("#sel_bk_ch_shf_des option:selected").val()	
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
 * GP change event
 * @param e
 * @returns
 */
$('#sel_gp_ch_shf_des').on("change", function(e) {
	//console.log("here...");
	$('#sel_vl_ch_shf_des').html('');
	$('#sel_vl_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueVLChldShfDes();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl_ch_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVLChldShfDes() {
	var inputArray = objStDtBkGpVlCrCh;
	var gp_code = $("#sel_gp_ch_shf_des option:selected").val()	
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == gp_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][7], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][7]);
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
$('#sel_vl_ch_shf_des').on("change", function(e) {
	//console.log("here...");
	$('#sel_cr_ch_shf_des').html('');
	$('#sel_cr_ch_shf_des').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueCrChldShfDes();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_cr_ch_shf_des').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});

/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCrChldShfDes() {
	var inputArray = objStDtBkGpVlCrCh;
	var vl_code = $("#sel_vl_ch_shf_des option:selected").val()	
	//console.log(vl_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == vl_code){
			if ((jQuery.inArray(inputArray[i][8]+"^"+inputArray[i][9], outputArray)) == -1){
				outputArray.push(inputArray[i][8]+"^"+inputArray[i][9]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to shift Child
 * @returns
 */
function shiftChild() {
	if($("#sel_dt_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Source District.");
		hideModal();
		return;
	}
	if($("#sel_bk_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Source Block.");
		hideModal();
		return;
	}
	if($("#sel_gp_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Source GP.");
		hideModal();
		return;
	}
	if($("#sel_vl_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Source Village.");
		hideModal();
		return;
	}
	if($("#sel_cr_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Source Creche.");
		hideModal();
		return;
	}
	if($("#sel_ch_ch_shf_src option:selected").val() == "select") {
		bootbox.alert("Please select a Child.");
		hideModal();
		return;
	}
	
	
	if($("#sel_dt_ch_shf_des option:selected").val() == "select") {
		bootbox.alert("Please select a Destination District.");
		hideModal();
		return;
	}
	if($("#sel_bk_ch_shf_des option:selected").val() == "select") {
		bootbox.alert("Please select a Destination Block.");
		hideModal();
		return;
	}
	if($("#sel_gp_ch_shf_des option:selected").val() == "select") {
		bootbox.alert("Please select a Destination GP.");
		hideModal();
		return;
	}
	if($("#sel_vl_ch_shf_des option:selected").val() == "select") {
		bootbox.alert("Please select a Destination Village.");
		hideModal();
		return;
	}
	if($("#sel_cr_ch_shf_des option:selected").val() == "select") {
		bootbox.alert("Please select a Destination Creche.");
		hideModal();
		return;
	}
	
	if($("#sel_cr_ch_shf_src option:selected").val() == $("#sel_cr_ch_shf_des option:selected").val()) {
		bootbox.alert("Source & destination Creche should not be same.");
		hideModal();
		return;
	}
	
	bootbox.confirm({
		size: "small",
		title: "Shift Child",
		message: "Do you want to shift the Child?", 
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
    			 json_param_set["sel_dt_ch_shf_des"] = $("#sel_dt_ch_shf_des option:selected").val();
    			 json_param_set["sel_bk_ch_shf_des"] = $("#sel_bk_ch_shf_des option:selected").val();
    			 json_param_set["sel_gp_ch_shf_des"] = $("#sel_gp_ch_shf_des option:selected").val();
    			 json_param_set["sel_vl_ch_shf_des"] = $("#sel_vl_ch_shf_des option:selected").val();
    			 json_param_set["sel_cr_ch_shf_des"] = $("#sel_cr_ch_shf_des option:selected").val();
    			 json_param_set["sel_ch_ch_shf_src"] = $("#sel_ch_ch_shf_src option:selected").val();
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 //console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../shift.Child',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Child shifted successfully.", 
    							 callback: function(){
    								 popStDtBkGpVlCrCh();
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







