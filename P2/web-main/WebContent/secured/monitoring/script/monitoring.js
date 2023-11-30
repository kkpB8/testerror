var objStDtBkGpVlCr;
var sel_mtr_level = '2';
var sel_mtr_grp;
var sel_mtr_sub_grp;
var sel_fltr_level;
var user_role = $("#hdUserRole").val();
var map_id = $("#hdUserId").val();
var user_dt = $("#hdUserDt").val();
var user_bk = $("#hdUserBk").val();

/**
 * Page Ready Function
 * @returnsc
 */
$(document).ready(function() {
	showModal();
	
	if(user_role == "super_user") {
		sel_fltr_level = 'ST';
		$("#div_rd_st_mtr").show();
		$("#div_rd_dt_mtr").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
	}
	else if(user_role == "st_user") {
		sel_fltr_level = 'ST';
		$("#div_rd_st_mtr").show();
		$("#div_rd_dt_mtr").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
	}
	else if(user_role == "dt_user") {
		sel_fltr_level = 'DT';
		$("#div_rd_st_mtr").hide();
		$("#div_rd_dt_mtr").show();
		$("#rdb_dt").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").hide();
		$("#div_gp").hide();
	} 
	else if(user_role == "bk_user") {
		sel_fltr_level = 'BK';
		$("#div_rd_st_mtr").hide();
		$("#div_rd_dt_mtr").hide();
		$("#rdb_bk").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").show();
		$("#div_gp").hide();
	}
	else if(user_role == "gp_user") {
		sel_fltr_level = 'GP';
		$("#div_rd_st_ovr").hide();
		$("#div_rd_dt_ovr").hide();
		$("#div_rd_bk_ovr").hide();
		$("#rdb_gp").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").show();
		$("#div_gp").show();
	}
	
	var cur_mnth_yr = $('#cur_date').val().substring(0, 7);
	$("#sel_mnth_yr").val(cur_mnth_yr);
	$('.from').datepicker({
		autoclose: true,	
	    minViewMode: 1,
	    format: 'yyyy-mm',
	}).on('changeDate', function(selected){
		startDate = new Date(selected.date.valueOf());
	    startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
	});
	
	
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
					popGroup();
					//popSubGroup();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get data.");
			  hideModal();
			  return;
		  }
	});
});


/**
 * Function to populate Group
 * @returns
 */
function popGroup() {
	//showModal();
	$.ajax({
		url: "../../pop.MonitoringGroup",
		type: "get",
		data: {
			type : sel_mtr_level			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get Group.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				
				$('#mtr_grp_ul').html("");
				var mtr_grp_ul = $('#mtr_grp_ul');
				$.each(obj_response, function(i) {
				    var li = $('<li/>')
				        .addClass('mtr_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(mtr_grp_ul);				    
				});
				$('#mtr_grp_ul li:first').addClass('active');
				sel_mtr_grp = $('#mtr_grp_ul').find("li.active").attr("id");
				//console.log(sel_mtr_grp);
				if(sel_mtr_grp == "5") {
					$("#rdb_vl").prop("disabled", true);
					$("#rdb_cr").prop("disabled", true);
				} else {
					$("#rdb_vl").prop("disabled", false);
					$("#rdb_cr").prop("disabled", false);
				}
				popSubGroup();
				initClickEvent('group');
				//hideModal();
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get Sub-group.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to populate Sub-group
 * @returns
 */
function popSubGroup() {
	//showModal();
	$.ajax({
		url: "../../pop.MonitoringSubGroup",
		type: "get",
		data: {
			type : sel_mtr_grp			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get Sub-group.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				//console.log(obj_response);
				
				$('#mtr_sub_grp_ul').html("");
				var mtr_sub_grp_ul = $('#mtr_sub_grp_ul');
				$.each(obj_response, function(i) {
					if(i == 0){
						var li = $('<li/>')
				        .addClass('mtr_sub_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(mtr_sub_grp_ul);
					}
				    /*var li = $('<li/>')
				        .addClass('mtr_sub_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(mtr_sub_grp_ul);*/				    
				});
				$('#mtr_sub_grp_ul li:first').addClass('active');
				sel_mtr_sub_grp = $('#mtr_sub_grp_ul').find("li.active").attr("id");
				popComboDist();
				initClickEvent('sub_group');
				//hideModal();
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get Sub-group.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to show/hide Combo
 * @returns
 */
function showHideCombo(sel_radio) {
	//console.log(sel_radio);
	if(sel_radio == "state") {
		$('#div_dt').hide();
		$('#div_bk').hide();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "ST";
		$("#5").removeClass('li_disabled');
	} else if(sel_radio == "district") {
		$('#div_dt').show();
		$('#div_bk').hide();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "DT";	
		$("#5").removeClass('li_disabled');
	} else if(sel_radio == "block") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "BK";
		$("#5").removeClass('li_disabled');
		if(user_role == "dt_user") {
			$("#sel_dt").trigger("change");
		}
	} else if(sel_radio == "gp") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').show();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "GP";
		$("#5").removeClass('li_disabled');
		if(user_role == "dt_user") {
			$("#sel_dt").trigger("change");
			$("#sel_bk").trigger("change");
		}
		else if(user_role == "bk_user") {
			$("#sel_bk").trigger("change");
		}
	} else if(sel_radio == "village") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').show();
		$('#div_vl').show();
		$('#div_cr').hide();
		sel_fltr_level = "VL";
		$("#5").addClass('li_disabled');
		if(user_role == "dt_user") {
			$("#sel_dt").trigger("change");
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
		}
		else if(user_role == "bk_user") {
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
		}
	} else if(sel_radio == "creche") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').show();
		$('#div_vl').show();
		$('#div_cr').show();
		sel_fltr_level = "CR";
		$("#5").addClass('li_disabled');
		if(user_role == "dt_user") {
			$("#sel_dt").trigger("change");
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
			$("#sel_vl").trigger("change");
		}
		else if(user_role == "bk_user") {
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
			$("#sel_vl").trigger("change");
		}
	}	
	$("#div_filter_details").html("");
	$("#div_chart").html("");
	$("#indi_ul").html("");
}


/**
 * Function to clear Combo Box data
 * @returns
 */
function clearComboData() {
	$('#sel_dt').html('');
	$('#sel_dt').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	$('#sel_bk').html('');
	$('#sel_bk').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');	
	$('#sel_gp').html('');
	$('#sel_gp').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');	
	$('#sel_vl').html('');
	$('#sel_vl').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');	
	$('#sel_cr').html('');
	$('#sel_cr').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');	
}


/**
 * Function to populate Combo Box data for District
 * @returns
 */
function popComboDist() {
	//console.log("here in popComboDist...");
	clearComboData();
	$('#sel_dt').html('');
	$('#sel_dt').append('<option disabled="disabled" selected="true" value="select">Select District</option>');
	var arr_dt = GetUniqueDT();
	for (var i = 0; i < arr_dt.length; i++) {
		var data = arr_dt[i].split("^");
		$('#sel_dt').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
	if(user_role == "dt_user") {
		$("select#sel_dt").prop('selectedIndex', 1);
	} else if(user_role == "bk_user") {
		$("select#sel_dt").prop('selectedIndex', 1);
		$("#sel_dt").trigger("change");		
		$("select#sel_bk").prop('selectedIndex', 1);
	}
	popIndicator();
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDT() {
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
$('#sel_dt').on("change", function(e) {
	$('#sel_bk').html('');	
	$('#sel_bk').append('<option disabled="disabled" selected="true" value="select">Select Block</option>');
	$('#sel_gp').html('');
	$('#sel_gp').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl').html('');
	$('#sel_vl').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr').html('');
	$('#sel_cr').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_bk = GetUniqueBK();
	for (var i = 0; i < arr_bk.length; i++) {
		var data = arr_bk[i].split("^");
		$('#sel_bk').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Block
 * @returns
 */
function GetUniqueBK() {
	var inputArray = objStDtBkGpVlCr;
	var dt_code = $("#sel_dt option:selected").val()	
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
$('#sel_bk').on("change", function(e) {
	$('#sel_gp').html('');
	$('#sel_gp').append('<option disabled="disabled" selected="true" value="select">Select GP</option>');
	$('#sel_vl').html('');
	$('#sel_vl').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr').html('');
	$('#sel_cr').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_gp = GetUniqueGP();
	for (var i = 0; i < arr_gp.length; i++) {
		var data = arr_gp[i].split("^");
		$('#sel_gp').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique GP
 * @returns
 */
function GetUniqueGP() {
	var inputArray = objStDtBkGpVlCr;
	var bk_code = $("#sel_bk option:selected").val()	
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
$('#sel_gp').on("change", function(e) {
	$('#sel_vl').html('');
	$('#sel_vl').append('<option disabled="disabled" selected="true" value="select">Select Village</option>');
	$('#sel_cr').html('');
	$('#sel_cr').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_vl = GetUniqueVL();
	for (var i = 0; i < arr_vl.length; i++) {
		var data = arr_vl[i].split("^");
		$('#sel_vl').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Village
 * @returns
 */
function GetUniqueVL() {
	var inputArray = objStDtBkGpVlCr;
	var gp_code = $("#sel_gp option:selected").val()	
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
$('#sel_vl').on("change", function(e) {
	$('#sel_cr').html('');
	$('#sel_cr').append('<option disabled="disabled" selected="true" value="select">Select Creche</option>');
	var arr_cr = GetUniqueCR();
	for (var i = 0; i < arr_cr.length; i++) {
		var data = arr_cr[i].split("^");
		$('#sel_cr').append('<option value="'+data[0]+'">'+data[1]+'</option>');
    }
});


/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCR() {
	var inputArray = objStDtBkGpVlCr;
	var vl_code = $("#sel_vl option:selected").val()	
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
 * Creche change event
 * @param e
 * @returns
 */
$('#sel_cr').on("change", function(e) {
	
});


/**
 * Overview submit button
 * @param e
 * @returns
 */
$('#btn_submit_ovr').on("click", function(e) {
	popIndicator();
});


/**
 * Function to populate Indicator
 * @returns
 */
function popIndicator() {
	//console.log("here in popIndicator..."+sel_ovr_sub_grp+"..."+sel_fltr_level);
	
	showModal();	
	if(sel_fltr_level == "ST") {
		$("#div_filter_details").html("<span><b>State :</b> Odisha</span>");
	}
	else if(sel_fltr_level == "DT") {
		if($("#sel_dt option:selected").val() == "select") {
			bootbox.alert("Please select a District.");
			hideModal();
			return;
		} else {
			$("#div_filter_details").html("<span><b>District :</b> "+$("#sel_dt option:selected").text()+"</span> "+
										  "<span><b>State :</b> Odisha</span>");
		}
	}
	else if(sel_fltr_level == "BK") {
		if($("#sel_bk option:selected").val() == "select") {
			bootbox.alert("Please select a Block.");
			hideModal();
			return;
		} else {
			$("#div_filter_details").html("<span><b>Block :</b> "+$("#sel_bk option:selected").text()+"</span> "+
										  "<span><b>District :</b> "+$("#sel_dt option:selected").text()+"</span> "+
			  							  "<span><b>State :</b> Odisha</span>");
		}
	}
	else if(sel_fltr_level == "GP") {
		if($("#sel_gp option:selected").val() == "select") {
			bootbox.alert("Please select a GP.");
			hideModal();
			return;
		} else {
			$("#div_filter_details").html("<span><b>GP :</b> "+$("#sel_gp option:selected").text()+"</span> "+
										  "<span><b>Block :</b> "+$("#sel_bk option:selected").text()+"</span> "+
					  					  "<span><b>District :</b> "+$("#sel_dt option:selected").text()+"</span> "+
					  					  "<span><b>State :<b> Odisha</span>");
		}
	}
	else if(sel_fltr_level == "VL") {
		if($("#sel_vl option:selected").val() == "select") {
			bootbox.alert("Please select a Village.");
			hideModal();
			return;
		} else {
			$("#div_filter_details").html("<span><b>Village :</b> "+$("#sel_vl option:selected").text()+"</span> "+
										  "<span><b>GP :</b> "+$("#sel_gp option:selected").text()+"</span> "+
					  					  "<span><b>Block :</b> "+$("#sel_bk option:selected").text()+"</span> "+
					  					  "<span><b>District :</b> "+$("#sel_dt option:selected").text()+"</span> "+
					  					  "<span><b>State :</b> Odisha</span>");
		}
	}
	else if(sel_fltr_level == "CR") {
		if($("#sel_cr option:selected").val() == "select") {
			bootbox.alert("Please select a Creche.");
			hideModal();
			return;
		} else {
			$("#div_filter_details").html("<span><b>Creche :</b> "+$("#sel_cr option:selected").text()+"</span> "+
										  "<span><b>Village :</b> "+$("#sel_vl option:selected").text()+"</span> "+
					  					  "<span><b>GP :</b> "+$("#sel_gp option:selected").text()+"</span> "+
					  					  "<span><b>Block :</b> "+$("#sel_bk option:selected").text()+"</span> "+
					  					  "<span><b>District :</b> "+$("#sel_dt option:selected").text()+"</span> "+
					  					  "<span><b>State :</b> Odisha</span>");
		}
	}
	
	//showModal();
	//console.log("Group..."+sel_mtr_grp+"----------Sub Group..."+sel_mtr_sub_grp);
	
	$.ajax({
		url: "../../pop.MonitoringIndicator",
		type: "get",
		data: {
			sel_fltr_level : sel_fltr_level,
			sel_mtr_grp : sel_mtr_grp,
			sel_mtr_sub_grp : sel_mtr_sub_grp,
		},
		success: function(response) {
			//console.log(response);		
			//console.log(sel_ovr_sub_grp);
			if (response == "N/A") {
				bootbox.alert("Unable to get Indicator.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				//console.log(obj_response);
				
				$('#indi_ul').html('');
				var indiList = $('#indi_ul');
				$.each(obj_response, function(i) {
					//alert(">>>>"+i);
				    var li = $('<li/>')
				    	.addClass('indi_ul_li')
				        .css('cursor', 'pointer')
				        .css('margin-left','-8%')
				        .css('width','288px')
				    	.attr('id', 'indi_ul_li~'+obj_response[i][0]+'~'+obj_response[i][2]+'~'+obj_response[i][4]+'~'+obj_response[i][5]+'~'+obj_response[i][6])
				    	.attr('title', obj_response[i][1])
				        .appendTo(indiList);
				    var aaa = $('<a/>')
				    	.attr('id', 'indi_ul_li_a~'+obj_response[i][0]+'~'+obj_response[i][2]+'~'+obj_response[i][4]+'~'+obj_response[i][5]+'~'+obj_response[i][6])
				        .text(obj_response[i][1])
				        .appendTo(li);
				});
				$('#indi_ul li:first').addClass('active');
				
				initClickEvent('indicator');
				popChartData();
				//hideModal();
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get Indicator.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to initialize event for dynamic control
 * @param type
 * @returns
 */
function initClickEvent(type) {
	//console.log("here in initClickEvent..."+type);
	
	if(type == 'group') {
		$("#mtr_grp_ul li").on("click", function() {	
			showModal();
			$('#mtr_grp_ul li').removeClass('active');
			$(this).addClass('active');
			
			var grp_code = $('#mtr_grp_ul').find("li.active").attr("id");
			sel_mtr_grp = grp_code;
			
			if(sel_mtr_grp == "5") {
				$("#rdb_vl").prop("disabled", true);
				$("#rdb_cr").prop("disabled", true);
			} else {
				$("#rdb_vl").prop("disabled", false);
				$("#rdb_cr").prop("disabled", false);
			}
			popSubGroup();
		});
	}
	else if(type == 'sub_group') {
		$("#mtr_sub_grp_ul li").on("click", function() {	
			showModal();
			$('#mtr_sub_grp_ul li').removeClass('active');
			$(this).addClass('active');
			
			var sub_grp_code = $('#mtr_sub_grp_ul').find("li.active").attr("id");
			sel_mtr_sub_grp = sub_grp_code;
			popIndicator();
		});
	}	
	else if(type == 'indicator') {
		$('#indi_ul li').on('click', function() {
			//console.log("here clicked on indicator...");
			showModal();
			$('#indi_ul li').removeClass('active');	
			$(this).addClass('active');
			
			$('#lbl_indi').html('');
			$('#div_chart').html('');
			popChartData();
		});
	}
}


/**
 * Function to populate Chart Data
 * @returns
 */
function popChartData() {
	//console.log("here in popChartData...");
	//# Type of Creche Category 02.03.2022
	var sel_creche_catg = $('#sel_catg :selected').val();
	
	showModal();
	var grp_code = sel_mtr_grp;
	var sub_grp_code = sel_mtr_sub_grp;	
	var filter_type = sel_fltr_level;
	var filter_code;
	if(filter_type == 'ST') {
		filter_code = '21';
	} else if(filter_type == 'DT') {
		filter_code = $('#sel_dt :selected').val();
	} else if(filter_type == 'BK') {
		filter_code = $('#sel_bk :selected').val();
	} else if(filter_type == 'GP') {
		filter_code = $('#sel_gp :selected').val();
	} else if(filter_type == 'VL') {
		filter_code = $('#sel_vl :selected').val();
	} else if(filter_type == 'CR') {
		filter_code = $('#sel_cr :selected').val();
	}
	
	var sel_indi = $('#indi_ul').find("li.active").attr("id").split('~');
	//console.log(sel_indi);
	
	//Indicator code
	var indi_code = sel_indi[1];
	//Indicator Chart type
	var indi_chart_type = sel_indi[2];
	//Indicator Options
	var indi_options = sel_indi[3];
	//Indicator is clickable or not
	var indi_click = sel_indi[4];
	//Indicator color
	var indi_color = sel_indi[5];
	//console.log(JSON.parse("[" + indi_color + "]"));
	var color_code = indi_color.split('$');		
	//console.log(color_code);
	//Indicator Name
	var indi_name = $('#indi_ul').find("li.active").attr("title");	

	var param_set = {};
	param_set["filter_level"] = sel_fltr_level;
	param_set["filter_code"] = filter_code;
	param_set["grp_code"] = grp_code;
	param_set["sub_grp_code"] = sub_grp_code;
	param_set["indi_code"] = indi_code;
	param_set["indi_chart_type"] = indi_chart_type;
	param_set["indi_name"] = indi_name;
	param_set["sel_mnth_yr"] = $("#sel_mnth_yr").val();
	param_set["sel_period"] = $("#sel_period option:selected").val();
	param_set["indi_click"] = indi_click;
	param_set["indi_color"] = indi_color;
	param_set["sel_creche_catg"] = sel_creche_catg; //# 02.03.2022
	
	//console.log(JSON.stringify(param_set));
	
	//Ajax Request
	$.ajax({
		url:"../../pop.ChartMonitoring",
		type:"GET",
		data:{
			json_data: JSON.stringify(param_set)
		},
		success: function(response) {
			if (response == "N/A") {
				alert("Unable to populate chart.");
				$("#div_chart").html("");
				hideModal();
				return;
			} else {
				var obj_response = eval ("("+ response +")");
				//console.log(obj_response);
				var div_id = 'div_chart';
				//console.log("Chart Type..."+indi_chart_type);
									
				//For Table Chart
				if (indi_chart_type == 'Table Widget') {
					//console.log("here in Table Widget...");
					var arr_option = indi_options.split('$');	
					var chart_heading = "";
						
					try {
						drawTableChart(div_id, indi_code, indi_name, chart_heading, arr_option, obj_response);
					} catch(err) {
						alert(err.message);
						hideModal();
					}												
				}
				//For Stacked Bar Chart
				else if (indi_chart_type == 'Stacked Bar Chart') {					
					//console.log("here in Stacked Bar Chart...");
					
					/*var colorCode;
					//For Red, Yellow, Green					
					if(grp_code == "002" && indi_code == "00004") {
						colorCode = ['#FF4646','#F2FE67','#34DC8C'];
					} else {
						colorCode = ['#8B4B62','#BB6F6B','#EA9674','#FCBC80','#F7E29C', '#0F6A8B', '#46698D', '#836890', '#C36894', '#EB6896'];
					}*/
					
					//New 2D Array after discarding NULL value					
					var obj_response2 = [[]];
					var index = 0;
					for (var i = 0; i < obj_response.length; i++) {
						if(obj_response[i][2] != "N/A") {
							var arr_temp = [];
							for (var j = 0; j < obj_response[i].length; j++) {
								arr_temp[j] = obj_response[i][j];
							}
							obj_response2[index] = arr_temp;
							index++;
						}												
					}
					//console.log("Testing: "+  obj_response2)
					
					//Column Chart Category
					var col_catg = "[";						
					for (var x = 0; x < obj_response2.length; x++) {
						//col_catg += "'"+obj_response2[x][0].replace('ZZ', 'Total').replace(/ /g, '&nbsp;')+"', ";
						if(obj_response2[x][0].includes("$")==true){
							var a = obj_response2[x][0].replace('ZZ', 'Total').replace(/ /g, '&nbsp;');
							var b =a.split("$");
							col_catg += "'"+b[0]+ "<br><center>"+b[1]+"</center>"+"', "; //# 17092020
						}else{
							col_catg += "'"+obj_response2[x][0].replace('ZZ', 'Total').replace(/ /g, '&nbsp;')+"', ";
						}
						
					}
					col_catg = col_catg.substring(0, (col_catg.length-2))+"]";
					col_catg = eval ("(" +col_catg+ ")");
					
					//console.log("Column Category..."+col_catg);
												
					//Column Name Category
					var temp_name = obj_response2[0][1].split("$");
					var col_name = [];
					for (var x = 0; x < temp_name.length; x++) {
						col_name[x] = temp_name[x].replace(/ /g, '&nbsp;') ;
					}
					//console.log("Column Name..."+col_name);
												
					var col_data = [];						
					for (var i = 0; i < col_name.length; i++) {
						var jsonData = {};
						jsonData["name"] = col_name[i];
						jsonData["color"] = color_code[i];
						var temp_data = [];
						for (var j = 0; j < obj_response2.length; j++) {
							//var temp_ans = obj_response2[j][2].split("$");
							var temp_ans = obj_response2[j][3].split("$"); //# 10092020
							for (var k = 0; k < temp_ans.length; k++) {
								if (i == k) {
									//temp_data[j] = parseInt(temp_ans[k]);
									temp_data[j] = parseFloat(temp_ans[k]);
									//console.log(temp_data[j]);
									break;
								}
							}
							jsonData["data"] = temp_data;
						}	
						col_data[i] = jsonData;
					}						
					//console.log(col_data);
						
					var col_tooltip = [[]];
					for (var j = 0; j < obj_response2.length; j++) {
						//var temp_tooltip = obj_response2[j][3].split("$");
						var temp_tooltip = obj_response2[j][2].split("$");  //# 10092020
						col_tooltip[j] = temp_tooltip;
					}
					//console.log("Tooltip:" + col_tooltip);
						
					try {
						arr_col_catg = col_catg;
						arr_col_data = col_data;
						arr_col_tooltip = col_tooltip;
						arr_legend_name = temp_name;
						drawColumnStackChart(div_id, col_catg, col_data, col_tooltip, temp_name, indi_name);
						hideModal();
					} catch (err) {
						alert(err.message)
						hideModal();
					}
				}
				//For Column Bar Chart
				else if (indi_chart_type == 'Column') {	
					//console.log("here in column chart...");
					//New 2D Array after discarding NULL value					
					var obj_response2 = [[]];
					var index = 0;
					for (var i = 0; i < obj_response.length; i++) {
						if(obj_response[i][1] != "N/A") {
							var arr_temp = [];
							for (var j = 0; j < obj_response[i].length; j++) {
								arr_temp[j] = obj_response[i][j];
							}
							obj_response2[index] = arr_temp;
							index++;
						}												
					}
					
					
					var arr_option = indi_options.split('$');
					var catg_data = [];
					var arr_data_set = [];
					var tt_data_set = [];
					var chart_heading = indi_name;
					for (var i = 0; i < arr_option.length; i++) {
						var json_data = {};
						var temp_data = [];
						var temp_data_tt = [];
						json_data['name'] = arr_option[i];
						for (var j = 0; j < obj_response2.length; j++) {
							//catg_data[j] = obj_response2[j][0];
							//# 30092020
							if(obj_response2[j][0].includes("$")==true){
								var a = obj_response2[j][0].split("$");
								catg_data[j] = a[0]+ "<br><center>"+a[1]+"</center>";
							}else{
								catg_data[j] = obj_response2[j][0];
							}
							
							//# Interchange Absolute & Percentage  23092020
							temp_data[j] = parseFloat(obj_response2[j][2]);
							temp_data_tt[j] = obj_response2[j][1];
						}						
						json_data['data'] = temp_data;
						json_data['color'] = color_code[i];
						//console.log(json_data);
						arr_data_set[i] = json_data;
						tt_data_set[i] = temp_data_tt;
					}
					console.log(catg_data);
					console.log(arr_data_set);
					drawColumnChart(div_id, indi_name, catg_data, arr_data_set, tt_data_set, chart_heading);
				}
			}
		},
		error: function (error) {
			 alert("Unable to populate chart data.");
			 hideModal();
			 return;
		}
	});	
}


/**
 * Function to draw Column Chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param chart_data_set
 */
function drawColumnChart(div_id, indi_name, catg_data, chart_data_set, tt_data_set, chart_heading) {
	showModal();
	//console.log(catg_data);
	//console.log(chart_data_set);
	
	//$('#div_sel_qtn').html(indi_name);
	Highcharts.chart(div_id, {
	    chart: {
	        type: 'column',
	        height: "50%",
	    },
	    title: {
	    	enabled : true,	
        	useHTML: true,
        	//text: "<a style='text-decoration:underline; cursor:pointer;' onclick='enlargeChart(&#39;column_chart&#39;);'>Click to enlarge the chart<a>",
        	text: indi_name,
	        //overflow: 'allow',
	        align: 'left',
	        x: 30,
	        y: 10,
	        useHTML: true,
	        style: {
	            fontFamily: 'Roboto,sans-serif',
	        	fontSize:'14px',
	        	whiteSpace:'normal',
	        	color: 'black',
	        	fontWeight: 'bold'
	        },
	    },
	    xAxis: {
	    	categories: catg_data
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: ''
	        },
	    },
	    tooltip: {
	    	/*followPointer:true,
	        headerFormat: '<b>{point.x}</b><br/>',
	        //pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
	        pointFormat: '{series.name}: {point.y}'*/
	    	
	    	followPointer:true,
	    	useHTML: true,
	    	formatter: function () {
	    		//return 	'<b>'+catg_data[this.point.index].substr(0,catg_data[this.point.index].indexOf('<br>'))+'</b><br/>'+ //# 29092020
	    		return	this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.point.index]+'</b>';
	        }	
	    },
	    legend: {
	        verticalAlign: 'bottom',
	        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	    },
	    plotOptions: {
	        column: {
	            dataLabels: {
	                //enabled: false,
	                //color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'black'
	                enabled: true,
	                style: {
	                    //color: '#fff',
	                	color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'black',
	                    textShadow: false,
	                    fontFamily: 'Roboto,sans-serif',
	                    fontSize: 10,
	                    fontWeight: 'bold',
	                    whiteSpace:'normal'
	                  }
	            }
	        },
	        series: {
	        	//Column width
                pointWidth: 20
	        }
	    },
	    //colors: ['#2836AF', '#04C034', '#BB36E6', '#46303B', '#B52121'],
	    //colors: ['#8B4B62','#BB6F6B','#EA9674','#FCBC80','#F7E29C', '#0F6A8B', '#46698D', '#836890', '#C36894', '#EB6896', '#AA19CE', 'A57EAF', '#2D6EDC', '#4FC071', '#A2C04F'],
	    credits: {
	        enabled: false
	    },
	    series : chart_data_set,
	    exporting: { 
	    	//enabled: false
	    	buttons: {
	            contextButton: {
	                menuItems: [
	                	"viewFullscreen", 
	                	"printChart", 
	                	//"separator", 
	                	//"downloadPNG", 
	                	"downloadJPEG", 
	                	"downloadPDF", 
	                	//"downloadSVG"
	                ]
	            }
	        }
	    }
	});
	hideModal();
}


/**
 * Function to draw Table chart
 * @param div_id
 * @param indi_code
 * @param indi_name
 * @param chart_heading
 * @param arr_option
 * @param obj_response
 * @returns
 */
function drawTableChart(div_id, indi_code, indi_name, chart_heading, arr_option, obj_response) {
	//console.log(arr_option);
	//console.log(obj_response);
	
	showModal();
	$('#lbl_indi').html(indi_name);
	var tableData = "";
	tableData += "<table id='tbl_data_"+indi_code+"' class='display tbl_monitoring' cellspacing='0' width='100%' style='border-left: 1px solid black;border-right: 1px solid black;'>";
		tableData += "<thead>";
			tableData += "<tr>";
				for (var i = 0; i < arr_option.length; i++) {
					tableData += "<th>"+arr_option[i]+"</th>";
				}
			tableData += "</tr>"
	    tableData += "</thead>";
	    
	    tableData += "<tbody>";
	    for (var i = 0; i < obj_response.length; i++) {
	    	tableData += "<tr>";
	    	for (var j = 0; j < obj_response[i].length; j++) {
	    		tableData += "<td class='text_left'>"+obj_response[i][j]+"</td>";	    	
	    	}	    	
	    	tableData += "</tr>";
	    }
	    tableData += "</tbody>";
	tableData += "</table>";
	//console.log(tableData);
	$('#'+div_id).html(tableData);
	
	$('#tbl_data_'+indi_code).DataTable({		
		"scrollY": "300px",
		"scrollX": "300px",
        "scrollCollapse": true,
        //responsive: true,
        "paging": false,
        "searching": false,
        //2D array - first inner array as the page length values and the second inner array as the displayed options
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        //"ordering": false
        /* Disable initial sort */
        "order": [],
        //Disable "showing 1 to * of * entries"
        "bInfo" : false,
        "columnDefs": [
            {
                "targets": [],
                "visible": false,
                "searchable": false
            }
        ]
    });
	//Draw Table Chart
	var table = $('#tbl_data_'+indi_code).DataTable();
	//For adjustment of Table row automatically
	table.columns.adjust().draw();
	hideModal();
}


/**
 * Function to populate Column Stack Chart
 * @param div_id
 * @param col_catg
 * @param col_data
 * @returns
 */
function drawColumnStackChart(div_id, col_catg, col_data, col_tooltip, legend_name, indi_name) {
	//console.log(div_id+"..."+col_catg+"..."+col_data+"..."+col_tooltip);
	//$("#lbl_indi").text(indi_name);
	var options = {
		//colors: ['#8B4B62','#BB6F6B','#EA9674','#FCBC80','#F7E29C', '#0F6A8B', '#46698D', '#836890', '#C36894', '#EB6896'],
	    chart: {
	    	renderTo: div_id,
	        type: 'column',
	        //Chart Background color
	        backgroundColor:"#FFFFFF",
	        style: {
	            fontFamily: 'Roboto,sans-serif'
	        },
	        //height: chrtHt,
	        height: "50%",
	        //height: chart_height,
	        // Edit chart spacing
            spacingBottom: 80,
	        //spacingBottom: getChartHeight(col_catg),
            /*spacingTop: 10,
            spacingLeft: 0,
            spacingRight: 30*/
	        //marginBottom: 70
	    },
	    title: {
	    	enabled : true,	
        	useHTML: true,
        	//text: "<a style='text-decoration:underline; cursor:pointer;' onclick='enlargeChart(&#39;stack_chart&#39;);'>Click to enlarge the chart<a>",
        	text: indi_name,
	        //overflow: 'allow',
	        align: 'left',
	        x: 30,
	        y: 10,
	        useHTML: true,
	        style: {
	            fontFamily: 'Roboto,sans-serif',
	        	fontSize:'14px',
	        	whiteSpace:'normal',
	        	color: 'black',
	        	fontWeight: 'bold'
	        },
	    },
	    xAxis: {
	        categories: col_catg,
	    	title: {
	        	text: null
	        },
	        labels: {
	        	useHTML: true,
	        	//enabled: false,
	        	enabled: true,
	        	align: 'center',
	            style:{
	              	color: '#000000',	              	
	              	fontSize: 12,
	            },	            
	            formatter: function () {	                
	            	var text = this.value;	            	
				    //var formatted_text = text.length > 8 ? text.substring(0, 8) + '...' : text;	            	
	            	//var formatted_text = text.length > 8 ? text.substring(0, text.indexOf("&nbsp")) + '...' : text;	            	
	            	//var formatted_text = text.length > 15 ? text.substring(0, 15) + '...' : text;
	            	var formatted_text = text;
	            	
	            	return '<div style="overflow:hidden" title="' + text + '">' + formatted_text + '</div>';
	            },
	            //rotation: -45,
	            //autoRotation: [-10, -20, -30, -40, -50, -60, -70, -80, -90]
	            //autoRotationLimit: 40			   
	        }
	    },
	    yAxis: {
	        min: 0,
	        title: {
	        	text: null
	        },
	        reversedStacks: false,
	        stackLabels: {
	            //enabled: true,
	            /*style: {
	                fontWeight: 'bold',
	                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
	            }*/
	        }
	    },
	    legend: {
	    	enabled: true,
	    	useHTML: true,
	    	//maxHeight: 80,
	        align: 'left',
	        verticalAlign: 'bottom',
	        x: 40,
	        y: 60,
	        //y: getLegendY(col_catg),
	        //floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	        borderColor: '#CCC',
	        borderWidth: 1,
	        shadow: false
	    },
	    tooltip: {
	    	useHTML: true,
	        //headerFormat: '<b>{point.x}</b><br/>',
	        //pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
	        //pointFormat: '{series.name}: {point.y}<br/>{series.options.tooltip}'
	    		    	
	    	formatter: function() {
                tt_val = this.series.name + ' : ' +
                    	//this.x  +': <b>'+ /*this.y+' '+*/
            			// this.x.name.substr(0,this.x.name.indexOf('<br>')) +': <b>'+ //# 30092020                
                    	data.chart_data.custom_tooltip[this.point.index][this.series.index]+'</b>';
                return tt_val;
            }
	    },
	    credits: {
	        enabled: false
	    },
	    plotOptions: {
	        column: {
	            //stacking: 'normal',
	        	stacking: 'percent',
	            dataLabels: {
	                enabled: true,
	                style: {
	                    //color: '#fff',
	                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
	                    textShadow: false,
	                    fontFamily: 'Roboto,sans-serif',
	                    fontSize: 10,
	                    fontWeight: 'bold',
	                    whiteSpace:'normal'
	                  }
	                //color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
	            },
	            pointWidth: 25,
	            minPointLength: 1
	        }
	    },
	    exporting: { 
	    	//enabled: false
	    	buttons: {
	            contextButton: {
	                menuItems: [
	                	"viewFullscreen", 
	                	"printChart", 
	                	//"separator", 
	                	//"downloadPNG", 
	                	"downloadJPEG", 
	                	"downloadPDF", 
	                	//"downloadSVG"
	                ]
	            }
	        }
	    }
	};
	//console.log(col_catg +" ---"+ col_tooltip);
	//For Custom Tooltip
	var data = {
			  chart_data: {
			    col_options: col_catg,
			    values: col_data,
			    custom_tooltip: col_tooltip,
			    //showInLegend: false,
			  }
			};
	options.xAxis.categories = data.chart_data.col_options;
	options.series = data.chart_data.values;
	//options.series[0].showInLegend = false;

	Highcharts.chart(div_id, options);
	
	var form = document.getElementById(div_id);
	form.style.display = '';
	form.scrollIntoView();
}
