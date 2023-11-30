$(document).ready(function() {
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	$("#chk_dont_know").prop("disabled", true);
	$("#div_condition").hide();
	popForm();	
});


/**
 * Function to populate Forms
 * @returns
 */
function popForm() {
	showModal();
	$.ajax({
		  url: "../../pop.Forms",
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
					var obj_response  = eval ("("+ response +")");
					$('#sel_form').append('<option disabled="disabled" selected="true" value="select">Select Form</option>');
					for (var i = 0; i < obj_response.length; i++) {
						$('#sel_form').append('<option value="'+obj_response[i][0]+'">'+obj_response[i][1]+'</option>');
				    }
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
 * Function to populate Question Format
 * @returns
 */
function popQtnFormat() {
	var sel_qtn_type = $("#sel_qtn_type option:selected").val();
	//console.log(sel_qtn_type);	
	
	$('#sel_qtn_format').html("");
	$('#sel_qtn_format').append('<option disabled="disabled" selected="true" value="select">Select Format</option>');
	
	if(sel_qtn_type == "number") {
		$("#chk_dont_know").prop("disabled", true);
		$('#sel_qtn_format').append('<option value="whole number">Whole Number</option>');
		$('#sel_qtn_format').append('<option value="decimal">Decimal</option>');
	}
	else if(sel_qtn_type == "drop_down") {
		$("#chk_dont_know").prop("disabled", false);
		$('#sel_qtn_format').append('<option value="yes^no">Yes / No</option>');
	}
	else if(sel_qtn_type == "radio_button") {
		$("#chk_dont_know").prop("disabled", false);
		$('#sel_qtn_format').append('<option value="yes^no">Yes / No</option>');
	}
	else if(sel_qtn_type == "text") {
		$("#chk_dont_know").prop("disabled", true);
		$('#sel_qtn_format').append('<option value="single line">Single line</option>');
		$('#sel_qtn_format').append('<option value="multiple line">Multiple line</option>');
		$('#sel_qtn_format').append('<option value="web link">Web Link</option>');
		$('#sel_qtn_format').append('<option value="email">Email</option>');
	}
	else if(sel_qtn_type == "date") {
		$("#chk_dont_know").prop("disabled", true);
		$('#sel_qtn_format').append('<option value="dd/mm/yy">dd/mm/yy</option>');
		$('#sel_qtn_format').append('<option value="dd/mm/yyyy">dd/mm/yyyy</option>');
	}
	else if(sel_qtn_type == "multi_check_box") {
		
	}
	else if(sel_qtn_type == "unit") {
		$("#chk_dont_know").prop("disabled", true);
		$('#sel_qtn_format').append('<option value="whole number">Whole Number</option>');
		$('#sel_qtn_format').append('<option value="decimal">Decimal</option>');
	}
}


/**
 * Function to show Conditional Visibility
 * @returns
 */
function showVisibilityCondition() {
	//console.log("here...showVisibilityCondition");
	if($("#chk_vsbl_cnd").prop('checked') == true){
		$("#div_condition").show();
	} else {
		$("#div_condition").hide();
	}
}


/**
 * Function to populate condition w.r.t previous Question Type
 * @returns
 */
function popConditionForPrevQtn() {
	var sel_prev_qtn_type = $("#sel_prev_qtn_type option:selected").val();
	//console.log(sel_prev_qtn_type);	
	
	$('#sel_prev_condition_type').html("");
	$('#sel_prev_condition_type').append('<option disabled="disabled" selected="true" value="select">Select Condition</option>');
	
	if(sel_prev_qtn_type == "number") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
		$('#sel_prev_condition_type').append('<option value="equal to">equal to</option>');
		$('#sel_prev_condition_type').append('<option value="not equal_to">not equal to</option>');
		$('#sel_prev_condition_type').append('<option value="greater than">greater than</option>');
		$('#sel_prev_condition_type').append('<option value="less than">less than</option>');
		$('#sel_prev_condition_type').append('<option value="is">is</option>');
		$('#sel_prev_condition_type').append('<option value="is not">is not</option>');
	}
	else if(sel_prev_qtn_type == "drop_down") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
		$('#sel_prev_condition_type').append('<option value="is">is</option>');
		$('#sel_prev_condition_type').append('<option value="is not">is not</option>');
	}
	else if(sel_prev_qtn_type == "radio_button") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
		$('#sel_prev_condition_type').append('<option value="is">is</option>');
		$('#sel_prev_condition_type').append('<option value="is not">is not</option>');
	}
	else if(sel_prev_qtn_type == "text") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
		$('#sel_prev_condition_type').append('<option value="contains text">contains text</option>');
		$('#sel_prev_condition_type').append('<option value="does not contains text">does not contains text</option>');
	}
	else if(sel_prev_qtn_type == "date") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
		$('#sel_prev_condition_type').append('<option value="before">before</option>');
		$('#sel_prev_condition_type').append('<option value="after">after</option>');
		$('#sel_prev_condition_type').append('<option value="is">is</option>');
		$('#sel_prev_condition_type').append('<option value="is not">is not</option>');
	}
	else if(sel_prev_qtn_type == "multi_check_box") {
		
	}
	else if(sel_prev_qtn_type == "unit") {
		$('#sel_prev_condition_type').append('<option value="answered">answered</option>');
		$('#sel_prev_condition_type').append('<option value="not answered">not answered</option>');
	}
}


/**
 * Function to show/hide conditional value
 * @returns
 */
function showConditionalVal() {
	var sel_prev_condition_type = $("#sel_prev_condition_type option:selected").val();
	//console.log(sel_prev_condition_type);	
	
	$('#txt_cnd_val').val("");
	
	if(sel_prev_condition_type == "equal to") {
		$("#txt_cnd_val").prop("disabled", false); 
	}
	else if(sel_prev_condition_type == "not equal to") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "greater than") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "less than") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "is") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "is not") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "contains text") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else if(sel_prev_condition_type == "does not contains text") {
		$("#txt_cnd_val").prop("disabled", false);
	}
	else {
		$("#txt_cnd_val").prop("disabled", true);
	}	
}


/**
 * Function to add Question
 * @returns
 */
function addQuestion() {
	//console.log("here in addQuestion...");
	
	var sel_form = $("#sel_form option:selected").val();
	var sel_qtn_type = $("#sel_qtn_type option:selected").val();
	var chk_mandatory;
	if($("#chk_mandatory").prop('checked') == true){
		chk_mandatory = "1";
	} else {
		chk_mandatory = "0";
	}
	var chk_dont_know;
	if($("#chk_dont_know").prop('checked') == true){
		chk_dont_know = "1";
	} else {
		chk_dont_know = "0";
	}
	var txt_qtn = $("#txt_qtn").val();
	var sel_qtn_format = $("#sel_qtn_format option:selected").val();
	var chk_always;
	if($("#chk_always").prop('checked') == true){
		chk_always = "1";
	} else {
		chk_always = "0";
	}
	var sel_prev_qtn_type = "N/A";
	var sel_prev_condition_type = "N/A";
	var txt_cnd_val = "N/A";
	
	if($("#chk_vsbl_cnd").prop('checked') == true){
		sel_prev_qtn_type = $("#sel_prev_qtn_type option:selected").val();
		sel_prev_condition_type = $("#sel_prev_condition_type option:selected").val();
		txt_cnd_val = $("#txt_cnd_val").val();		
	} else {
		sel_prev_qtn_type = "N/A";
		sel_prev_condition_type = "N/A";
		txt_cnd_val = "N/A";
	}
	
	bootbox.confirm({
		size: "small",
		title: "Add Question",
		message: "Do you want to save the question?", 
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
	    		 json_param_set["sel_form"] = sel_form;
    			 json_param_set["sel_qtn_type"] = sel_qtn_type;
    			 json_param_set["chk_mandatory"] = chk_mandatory;
    			 json_param_set["chk_dont_know"] = chk_dont_know;
    			 json_param_set["txt_qtn"] = txt_qtn;
    			 json_param_set["sel_qtn_format"] = sel_qtn_format;
    			 json_param_set["chk_always"] = chk_always;
    			 json_param_set["sel_prev_qtn_type"] = sel_prev_qtn_type;
    			 json_param_set["sel_prev_condition_type"] = sel_prev_condition_type;
    			 json_param_set["txt_cnd_val"] = txt_cnd_val;    			 
    			 json_param_set["login_user"] = GLOBAL_LOGIN_USER_ID;
	
    			 console.log(json_param_set);
    			 //Send Request to server
    			 $.ajax({
    				 type: 'POST',
    				 url: '../../add.Question',
    				 data: {
    					 json_param_set: JSON.stringify(json_param_set),
    					 //anm_counter: counter,
    				 },
    				 success: function(response){
    					 //console.log(response);
    					 var obj_response = JSON.parse(response);
    					 if (obj_response.status == "1") {
    						 bootbox.alert({
    							 message: "Thank you !!!<br>Your question added successfully.", 
    							 callback: function(){
    								 clearData();
    							 }
    						 });    						 
    						 hideModal();
    						 return;
    					 } else {
    						 bootbox.alert('Question addition failed.');
    						 hideModal();
    						 return;
    					 }
    				 },
    				 error: function(xhr) {
    					 bootbox.alert('Question addition failed.');
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
 * Function to clear Data
 * @returns
 */
function clearData() {
	//console.log("here in clearData...");
	
	$("select#sel_form").prop('selectedIndex', 0);
	$("select#sel_qtn_type").prop('selectedIndex', 0);
	$('#chk_mandatory').prop('checked', false);
	$('#chk_dont_know').prop('checked', false);
	$("#chk_dont_know").prop("disabled", true);
	$("#div_condition").hide();
	$("#txt_qtn").val("");
	$('#sel_qtn_format').html("");
	$('#sel_qtn_format').append('<option disabled="disabled" selected="true" value="select">Select Format</option>');
	$('#chk_always').prop('checked', false);
	$('#chk_vsbl_cnd').prop('checked', false);
	$("select#sel_prev_qtn_type").prop('selectedIndex', 0);
	$('#sel_prev_condition_type').html("");
	$('#sel_prev_condition_type').append('<option disabled="disabled" selected="true" value="select">Select Condition</option>');
	$("#txt_cnd_val").val("");
	
}
