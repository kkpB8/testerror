var cur_mnth_yr = $('#cur_date').val().substring(0, 7);
var objStDtBk;

/**
 * Page Ready Function
 * @returns
 */
$(document).ready(function(){
	showModal();
	//console.log(cur_mnth_yr);
	$("#sel_mnth_yr").val(cur_mnth_yr);
	$('.from').datepicker({
		autoclose: true,	
	    minViewMode: 1,
	    format: 'yyyy-mm',
	}).on('changeDate', function(selected){
		startDate = new Date(selected.date.valueOf());
	    startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
	});
	
	$("#sel_mnth_yr_start").val(cur_mnth_yr);
	$('.from').datepicker({
		autoclose: true,	
	    minViewMode: 1,
	    format: 'yyyy-mm',
	}).on('changeDate', function(selected){
		startDate = new Date(selected.date.valueOf());
	    startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
	    //test();
	});
	
	var sel_prjprg = $("#sel_prjprg option:selected").val();
	if(sel_prjprg == 'All'){
		$("#bulkReportDiv").show();
	}
	else{
		$("#bulkReportDiv").hide();
	}
	
	popReportType();
	popBulkReportType();
	popDist();
});


function test() {
	var d = new Date("January 14, 2012");
	console.log(d.toLocaleDateString());
	d.setMonth(d.getMonth() - 3);
	console.log(d.toLocaleDateString());
}

/**
 * On Change Function to Project/Program 
 */
$("#sel_prjprg").change(function(){
	showModal();
		popReportType();
	hideModal();
	
	//If Project/Program == All then Bluk Report Din ON/OFF
	var sel_prjprg = $("#sel_prjprg option:selected").val();
	if(sel_prjprg == 'All'){
		$("#bulkReportDiv").show();
	}
	else{
		$("#bulkReportDiv").hide();
	}	
});


/**
 * Function to populate Report type
 * @returns
 */
function popReportType(){
	var sel_prjprg = $("#sel_prjprg option:selected").val();
	$('#sel_rept_type').html('');
	$.ajax({
		  url: "../../pop.ReportType",
		  type: "get",
		  data: {
			  
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get Report type.");
					hideModal();
					return;
				} else {
					var obj_response = eval ("("+ response +")");
					$('#sel_rept_type').append('<option value="select">Select Report</option>');
					$.each(obj_response, function(i) {
						$('#sel_rept_type').append('<option value="'+obj_response[i][0]+'">'+obj_response[i][1]+'</option>');
					});
					//If Project/Program = Not All then 
					if(sel_prjprg !== 'All'){
							$('#sel_rept_type option[value=01]').hide();
							$('#sel_rept_type option[value=02]').hide();
					}
					//$("#sel_mnth_yr").attr("disabled", "disabled"); 
					hideModal();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get Report type.");
			  hideModal();
			  return;
		  }
	});
}


/**
 * on change function of Month-Year selection
 * @returns
 */
$('#sel_period').on('change', function() {	
	var sel_period = this.value;
	//console.log(sel_period);
	/*if(sel_period == 'by_month') {
		$("#sel_mnth_yr").removeAttr("disabled"); 
	} else if(sel_period == 'till_month') {
		$("#sel_mnth_yr").attr("disabled", "disabled");
		$("#sel_mnth_yr").val(cur_mnth_yr);
	}*/
});


/**
 * Click event of Add to List button
 * @returns
 */
$("#btn_dwnld").click(function() {
	if($('#sel_rept_type option:selected').val() == "select") {
		bootbox.alert("Please select a Report type.");
		hideModal();
		return;
	}
	
	var param_set = {};
	param_set["proj_type"] = $('#sel_prjprg option:selected').val();
	param_set["user_type"] = $('#user_type').val();
	param_set["map_id"] = $('#map_id').val();
	param_set["rept_type"] = $('#sel_rept_type option:selected').val();
	//param_set["sel_period"] = $('#sel_period option:selected').val();
	if($('#sel_rept_type option:selected').val() == "19") {
		param_set["sel_period"] = "N/A";
		param_set["sel_catg"] = $('#sel_catg option:selected').val();
	} else {
		param_set["sel_period"] = $('#sel_period option:selected').val();
		param_set["sel_catg"] = "N/A";
	}
	//param_set["sel_mnth_yr"] = $('#sel_mnth_yr').val();
	if($('#sel_rept_type option:selected').val() == "19") {
		param_set["sel_mnth_yr"] = "N/A";
		param_set["sel_mnth_yr_start"] = $('#sel_mnth_yr_start').val();
	} else {
		param_set["sel_mnth_yr"] = $('#sel_mnth_yr').val();
		param_set["sel_mnth_yr_start"] = "N/A";
	}
	//console.log(param_set);
	
	var submitForm = document.createElement("FORM");
	document.body.appendChild(submitForm);
	submitForm.method = "POST";
	createNewFormElement(submitForm, "json_data", JSON.stringify(param_set));
	submitForm.action= "../../download.Report";	
	submitForm.submit();
});


/**
 * Function to create FormElement
 */
function createNewFormElement(inputForm, elementName, elementValue){
	var input = document.createElement("input");
	input.type = "hidden";
	input.id = elementName;
	input.name = elementName;
	input.value = elementValue;
	inputForm.appendChild(input);
}


/**
 * Function to change Report type
 * @returns
 */
function changeReport() {
	var sel_rept_type = $('#sel_rept_type option:selected').val();
	
	if(sel_rept_type == "19") {
		$("#div_rept1").hide();
		$("#div_rept2").show();
		$("#sel_mnth_yr_start").val(cur_mnth_yr);
	} else {
		$("#div_rept1").show();
		$("#div_rept2").hide();
	}
}


/**
 * Function to download All Anthropometry Data
 * @returns
 */
function downloadAllAnthroData() {
	var submitForm = document.createElement("FORM");
	document.body.appendChild(submitForm);
	submitForm.method = "POST";
	//createNewFormElement(submitForm, "json_data", JSON.stringify(param_set));
	submitForm.action= "../../download.AllAnthroData";	
	submitForm.submit();
}

//######## 02.12.2020      ######################################################



/**
 * Function to populate Report type for Bulk Report
 * @returns
 */
function popBulkReportType(){
	$('#selRptTypeBulk').html('');
	$.ajax({
		  url: "../../pop.ReportTypeBulk",
		  type: "get",
		  data: {
			  
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get Report type.");
					hideModal();
					return;
				} else {
					var obj_response = eval ("("+ response +")");
					$('#selRptTypeBulk').append('<option value="select">Select Report</option>');
					$.each(obj_response, function(i) {
						$('#selRptTypeBulk').append('<option value="'+obj_response[i][0]+'">'+obj_response[i][1]+'</option>');
					});
					hideModal();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get Bulk Report type.");
			  hideModal();
			  return;
		  }
	});
} //# End popBulkReportType

/**
 * Function to populate for District
 * @returns
 */
function popDist(){
	$('#selDist').html('');
	$.ajax({
		  url: "../../pop.combo.data",
		  type: "get",
		  data: {
			  type: "selDist",
			  code: "",
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get District.");
					hideModal();
					return;
				} else {
					objStDtBk = eval ("("+ response +")");
					
					var arr_dt = GetUniqueDT();
					
					for (var i = 0; i < arr_dt.length; i++) {
						var data = arr_dt[i].split("^");
						$('#selDist').append('<option value="'+data[0]+'">'+data[1]+'</option>');
				    }
					
					hideModal();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get District.");
			  hideModal();
			  return;
		  }
	});
} //# End popDist

/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDT() {
	var inputArray = objStDtBk;
	console.log(inputArray);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){		
		if ((jQuery.inArray(inputArray[i][0]+"^"+inputArray[i][1], outputArray)) == -1){
			outputArray.push(inputArray[i][0]+"^"+inputArray[i][1]);
		}
	}
	return outputArray;
}

/**
 * Click event for Bulk Report 
 * @returns
 */
$("#btnBulkDwnld").click(function() {
	if($('#selRptTypeBulk option:selected').val() == "select") {
		bootbox.alert("Please select a Report type.");
		hideModal();
		return;
	}
	
	var param_set = {};
	param_set["selRptTypeBulk"] = $('#selRptTypeBulk option:selected').val();
	param_set["selDist"] = $('#selDist option:selected').val();
	param_set["selYear"] = $('#selYear option:selected').val();
	
	
	var submitForm = document.createElement("FORM");
	document.body.appendChild(submitForm);
	submitForm.method = "POST";
	createNewFormElement(submitForm, "json_data", JSON.stringify(param_set));
	submitForm.action= "../../download.BulkReport";	
	submitForm.submit();
});