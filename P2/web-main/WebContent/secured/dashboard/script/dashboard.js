var objStDtBkGpVlCr;
var sel_dsh_level = '3';
var sel_dsh_grp;
var sel_dsh_sub_grp;
var sel_fltr_level;
var user_role = $("#hdUserRole").val();
var map_id = $("#hdUserId").val();
var user_dt = $("#hdUserDt").val();
var user_bk = $("#hdUserBk").val();

/**
 * Page Ready Function
 * @returns
 */
$(document).ready(function() {
	showModal();
	if(user_role == "super_user") {
		sel_fltr_level = 'ST';
		$("#div_rd_st_dsh").show();
		$("#div_rd_dt_dsh").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
	}
	else if(user_role == "st_user") {
		sel_fltr_level = 'ST';
		$("#div_rd_st_dsh").show();
		$("#div_rd_dt_dsh").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
	}
	else if(user_role == "dt_user") {
		sel_fltr_level = 'DT';
		$("#div_rd_st_dsh").hide();
		$("#div_rd_dt_dsh").show();
		$("#rdb_dt").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").hide();
		$("#div_gp").hide();
	} 
	else if(user_role == "bk_user") {
		sel_fltr_level = 'BK';
		$("#div_rd_st_dsh").hide();
		$("#div_rd_dt_dsh").hide();
		$("#rdb_bk").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").show();
		$("#div_gp").hide();
	}
	else if(user_role == "gp_user") {
		sel_fltr_level = 'GP';
		$("#div_rd_st_dsh").hide();
		$("#div_rd_dt_dsh").hide();
		$("#div_rd_bk_dsh").hide();
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
		url: "../../pop.DashboardGroup",
		type: "get",
		data: {
			type : sel_dsh_level			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get Group.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				
				$('#dsh_grp_ul').html("");
				var dsh_grp_ul = $('#dsh_grp_ul');
				$.each(obj_response, function(i) {
				    var li = $('<li/>')
				        .addClass('dsh_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(dsh_grp_ul);				    
				});
				$('#dsh_grp_ul li:first').addClass('active');
				sel_dsh_grp = $('#dsh_grp_ul').find("li.active").attr("id");
				console.log("Test: " + sel_dsh_grp);
				popSubGroup();
				initClickEvent('group');
				//hideModal();
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get Group.");
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
		url: "../../pop.DashboardSubGroup",
		type: "get",
		data: {
			type : sel_dsh_grp			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get Sub-group.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				
				$('#dsh_sub_grp_ul').html("");
				var dsh_sub_grp_ul = $('#dsh_sub_grp_ul');
				$.each(obj_response, function(i) {
				    var li = $('<li/>')
				        .addClass('dsh_sub_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(dsh_sub_grp_ul);				    
				});
				$('#dsh_sub_grp_ul li:first').addClass('active');
				sel_dsh_sub_grp = $('#dsh_sub_grp_ul').find("li.active").attr("id");
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
	} else if(sel_radio == "district") {
		$('#div_dt').show();
		$('#div_bk').hide();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "DT";	
	} else if(sel_radio == "block") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "BK";
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
		if(user_role == "dt_user") {
			$("#sel_dt").trigger("change");
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
		}
		else if(user_role == "bk_user") {
			$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
		}
		else if(user_role == "gp_user") {
			$("#sel_gp").trigger("change");
		}
	} else if(sel_radio == "creche") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').show();
		$('#div_vl').show();
		$('#div_cr').show();
		sel_fltr_level = "CR";
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
		else if(user_role == "gp_user") {
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
	} else if(user_role == "gp_user") {
		$("select#sel_dt").prop('selectedIndex', 1);
		$("#sel_dt").trigger("change");		
		$("select#sel_bk").prop('selectedIndex', 1);
		$("#sel_bk").trigger("change");
		$("select#sel_gp").prop('selectedIndex', 1);
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
	//console.log("Group..."+sel_dsh_grp+"----------Sub Group..."+sel_dsh_sub_grp);
	$.ajax({
		url: "../../pop.DashboardIndicator",
		type: "get",
		data: {
			sel_fltr_level : sel_fltr_level,
			sel_dsh_grp : sel_dsh_grp,
			sel_dsh_sub_grp : sel_dsh_sub_grp
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
		$("#dsh_grp_ul li").on("click", function() {	
			showModal();
			$('#dsh_grp_ul li').removeClass('active');
			$(this).addClass('active');
			
			//console.log(this.id+"..."+$('#dsh_grp_ul').find("li.active").attr("id"));
			var grp_code = $('#dsh_grp_ul').find("li.active").attr("id");
			sel_dsh_grp = grp_code;
			popSubGroup();
		});
	}
	else if(type == 'sub_group') {
		$("#dsh_sub_grp_ul li").on("click", function() {	
			showModal();
			$('#dsh_sub_grp_ul li').removeClass('active');
			$(this).addClass('active');
			
			var sub_grp_code = $('#dsh_sub_grp_ul').find("li.active").attr("id");
			sel_dsh_sub_grp = sub_grp_code;
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
	var sel_creche_catg = $('#sel_catg :selected').val();
	showModal();
	var grp_code = sel_dsh_grp;
	var sub_grp_code = sel_dsh_sub_grp;	
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
	param_set["sel_creche_catg"] = sel_creche_catg; //# 08.03.2022
	//console.log(JSON.stringify(param_set));
	
	//Ajax Request
	$.ajax({
		url:"../../pop.ChartDashboard",
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
				
				//For Stacked Bar Chart
				if (indi_chart_type == 'Stacked Bar Chart') {					
					//console.log("here in Stacked Bar Chart...");
					var catg_data = [];
					var arr_option = indi_options.split('$');
					var arr_data_set = [];
					var tt_data_set = [];
					var chart_heading = indi_name;
					for (var i = 0; i < arr_option.length; i++) {
						var json_data = {};
						json_data['name'] = arr_option[i];
						json_data["color"] = color_code[i];
						
						var temp_data = [];
						var temp_data_tt = [];
						for (var j = 0; j < obj_response.length; j++) {
							//catg_data[j] = obj_response[j][0];
							//# Break Total Value 06.10.2020
							if(obj_response[j][0].includes("$")==true){
								var a =obj_response[j][0].split("$");
								catg_data[j] = a[0]+ "<br><center>"+a[1]+"</center>";
							}else{
								catg_data[j] = obj_response[j][0];
							}
							
							//Chart dataset starts from 2nd column
							//temp_data[j] = parseInt(obj_response[j][i+1]);
							//# 06.10.2020
							temp_data[j] = parseFloat(obj_response[j][i+1+arr_option.length]);
							//Tooltip dataset starts from 4th column
							//temp_data_tt[j] = obj_response[j][i+1+arr_option.length];
							//# 06.10.2020
							temp_data_tt[j] = obj_response[j][i+1];
						}
						json_data['data'] = temp_data;
						//console.log(temp_data);
						//console.log(json_data);
						arr_data_set[i] = json_data;
						tt_data_set[i] = temp_data_tt;
					}
					//console.log(arr_data_set);
					drawColumnStackedChart(div_id, indi_name, catg_data, arr_data_set, tt_data_set, chart_heading);
				}
				//For Column Chart
				else if (indi_chart_type == 'Column') {
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
						for (var j = 0; j < obj_response.length; j++) {
							catg_data[j] = obj_response[j][0];	
							temp_data[j] = parseInt(obj_response[j][1]);
							temp_data_tt[j] = obj_response[j][2];
						}						
						json_data['data'] = temp_data;
						json_data['color'] = color_code[i];
						//console.log(json_data);
						arr_data_set[i] = json_data;
						tt_data_set[i] = temp_data_tt;
					}
					//console.log(catg_data);
					//console.log(arr_data_set);
					drawColumnChart(div_id, indi_name, catg_data, arr_data_set, tt_data_set, chart_heading);
				}
				//For Line Chart
				else if (indi_chart_type == 'Line Chart') {
					console.log("Star Line");
					var catg_data = [];
					var arr_option = indi_options.split('$');
					var arr_data_set = [];
					var tt_data_set = [];
					//var chart_heading = indi_name;
					for (var k = 0; k < obj_response.length; k++) {
						//catg_data[k] = obj_response[k][0];
						//# Changes in 29.12.2020
						if(obj_response[k][0].includes("$")==true){
							var a =obj_response[k][0].split("$");
							catg_data[k] = a[0]+ "<br><center>"+a[1]+"</center>";
						}else{
							catg_data[k] = obj_response[k][0];
						}
					}
					
					var arr_data_set = [];
					for (var i = 0; i < arr_option.length; i++) {
						var json_data = {};
						json_data['name'] = arr_option[i];
						var arr_data = [];
						var temp_data_tt = [];
						for (var j = 0; j < obj_response.length; j++) {
							/*arr_data[j] = parseInt(obj_response[j][i+1]);
							temp_data_tt[j] = obj_response[j][i+1+arr_option.length];*/
							//# 29.12.2020
							arr_data[j] = parseFloat(obj_response[j][i+1 + arr_option.length]);
							temp_data_tt[j] = obj_response[j][i+1];
						}
						json_data['data'] = arr_data;
						json_data['color'] = color_code[i];
						arr_data_set[i] = json_data;
						tt_data_set[i] = temp_data_tt;
					}
					//console.log(catg_data);
					//console.log(arr_data_set);
					//console.log(tt_data_set);
					drawLineChart(div_id, indi_name, catg_data, arr_data_set, tt_data_set);
				}
				else if(indi_chart_type == "Number") {
					drawWidget(div_id, indi_name, obj_response);
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
 * Function to draw stacked column chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param chart_data_set
 */
function drawColumnStackedChart(div_id, indi_name, catg_data, chart_data_set, tt_data_set, chart_heading) {
	//console.log("here in drawColumnStackedChartNew...");
	showModal();
	//console.log(chart_data_set);
	
	//$('#div_sel_qtn').html(indi_name);
	Highcharts.chart(div_id, {
	    chart: {
	        type: 'column',
	        height: "50%"
	    },
	    title: {
	        text: chart_heading,
	        align: 'left',
	        x: 30,
	        y: 10,
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
	        reversedStacks: false,
	        stackLabels: {
	            enabled: false,
	            style: {
	                fontWeight: 'bold',
	                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
	            }
	        }
	    },
	    legend: {
	        //align: 'right',
	        //x: -30,
	        verticalAlign: 'bottom',
	        //y: 25,
	        //floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	        //borderColor: '#CCC',
	        //borderWidth: 1,
	        //shadow: false
	    },
	    tooltip: {
	    	/*followPointer:true,
	        headerFormat: '<b>{point.x}</b><br/>',
	        pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'*/
	    	
	    	followPointer:true,
	    	useHTML: true,
	    	formatter: function () {
	    		//return 	'<b>'+catg_data[this.point.index]+'</b><br/>'+
	    		return	this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.point.index]+'</b>';
	        }
	    },
	    plotOptions: {
	        column: {
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
	            pointWidth: 40, //# width of the column irrespective of the chart size
	            minPointLength: 1
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
 * Function to draw Column Chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param chart_data_set
 */
function drawColumnChart(div_id, indi_name, catg_data, chart_data_set, tt_data_set, chart_heading) {
	showModal();
	//console.log("column");
	//console.log(chart_data_set);
	
	//$('#div_sel_qtn').html(indi_name);
	Highcharts.chart(div_id, {
	    chart: {
	        type: 'column',
	        height: "50%"
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
	    		return 	'<b>'+catg_data[this.point.index]+'</b><br/>'+
	    				this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.point.index]+'</b>';
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
 * Function to draw Line Chart
 * @param div_id
 * @param catg_data
 * @param arr_data_set
 * @returns
 */
function drawLineChart(div_id, indi_name, catg_data, arr_data_set, tt_data_set) {
	//console.log(catg_data);
	//console.log(arr_data_set);
	//console.log(tt_data_set);
	console.log(indi_name)
	showModal();
	$('#'+div_id).highcharts({
        chart: {
        	type: 'spline',
        	height: "50%"
        },        
        title: {
            text: indi_name,
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
        subtitle: {
            text: '',
        },
        tooltip: {
        	shared: true,
        	//followPointer:true,
	    	useHTML: true,
        	
        	/*headerFormat: '<b>{series.name}</b><br>',
	        //pointFormat: '{point.x:%e. %b}: {point.y:.2f} m'
	        pointFormat: '{point.x:%e-%m-%Y}: {point.y:.0f}'*/

        	/*pointFormatter: function () {
	    		return 	this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.index]+'</b>';
	        }*/
        
	        /*pointFormatter: function () {
	    		return this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.index]+'</b><br>';
	        }*/
	    	
	    	/*pointFormatter: function () {
	    		return this.series.name+' : '+'<b>'+tt_data_set[this.series.index][this.index]+'</b><br>';
	        }*/
	    	
	    	formatter: function () {
	    		return this.points.reduce(function (s, point) {
	    			//console.log(tt_data_set[point.series.index][point.point.index]);
	    			return	s +
	    			 		'<br/>' +
	    					point.series.name + ':  <b>'+tt_data_set[point.series.index][point.point.index]+'</b>';
	            }, '<b>'+this.x.toString().substr(0, 6)+'</b>');
	        }
	    	 
	    	/* 
	    	headerFormat: '<small>{point.key}</small><table>',
	        pointFormat: '<tr><td >{series.name}: </td>' +
	             '<td style="text-align: right"><b>{'+tt_data_set[this.series.index][this.index]+'} </b></td></tr>',
	        footerFormat: '</table>'
	    	*/
        },        
        //Handling click event
        /*plotOptions: {
            series: {
                cursor: 'pointer',
                point: {
                    events: {
                        click: function () {
                            alert('Category: ' + this.category + ', value: ' + this.y);
                        }
                    }
                }
            }
        },*/
        xAxis: {
            categories: catg_data
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        legend: {
            //layout: 'vertical',
            //align: 'right',
            verticalAlign: 'bottom',
            borderWidth: 0
        },
        colors: ['#8B4B62','#EA9674','#F7E29C','#0F6A8B','#46698D','#FCBC80','#836890','#C36894','#EB6896','#BB6F6B'],
        credits: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            stickyTracking: false
	        }
	    },
	    series: arr_data_set,
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
 * Function to draw Number Widget
 * @param div_id
 * @param indi_id
 * @param indi_name
 * @param obj_response
 * @returns
 */
function drawWidget(div_id, indi_name, obj_response) {
	//console.log(indi_id);
	//console.log(indi_name);
	var font_size;
	
	/*$('#'+div_id).css({
		'min-width': '160px',
		'max-width': '400px',
		'height': '285px',
		'margin': '0 auto',
		//'border': '1px solid black'
	});
	font_size = '20px';*/
		
	//console.log(getWidgetCaption(indi_name, obj_response[0][0]));
	Highcharts.chart({
		chart: {
            renderTo: div_id,
            height: "50%",
            //Highchart initialisation finished
            events: {
                load: function(event) {
                	hideModal();
                }
            }        
        },
	    plotOptions: {
	        venn: {
	            dataLabels: {
	                enabled: true,
	                align: "center",
	                style: {
	                    textOutline: false,
	                    width: 150,
	                    fontSize: "20px",
	                    color: "#000",
	                    fontWeight: "normal"
	                }
	            }
	        }
	    },
	    tooltip: {
	        enabled: true
	    },
	    series: [{
	        type: 'venn',
	        name: null,
	        opacity: 1.0,
	        borderWidth: 1,
	        /*data: [{
	            //sets: [indi_name+'<br>'+obj_response[0][0]],
	        	sets: [getWidgetCaption(indi_name, obj_response[0][0])],
	            value: 4,
	            color: "#86c25e"
	        }]*/
	        
	        data: [{
	            sets: [''],
	            value: 4,
	            name: obj_response[0][0],
	            description: indi_name,
	            color: "#86c25e"
	        }],
	        /*style: {
	            color: 'red',
	        }*/
	    }],
	    /*tooltip: {
	        headerFormat:
	            //'<span style="color:{point.color}">\u2022</span> ' +
	            '<span style="font-size: 14px"> {point.point.name}</span><br/>',
	        pointFormat: '{point.description}'
	    },*/
	    
	    tooltip: {
	        headerFormat:
	            //'<span style="color:{point.color}">\u2022</span> ' +
	            //'<span style="font-size: 14px"> {point.point.name}</span><br/>',
	        	'<span style="font-size: 14px"> {}</span><br/>',
	            pointFormat: '{point.description} : <span style="font-size: 14px; text-align: center; font-weight: bold;">'+obj_response[0][0]+'</span>'
	        	
	    },
	    
	    title: {
	        text: indi_name,
	        align: 'center',
	        x: 30,
	        y: 10,
	        style: {
	            fontFamily: 'Roboto,sans-serif',
	        	fontSize:'14px',
	        	whiteSpace:'normal',
	        	color: 'black',
	        	fontWeight: 'bold'
	        }
	    },
	    credits: {
	        enabled: false
	    },
	    exporting: {
	    	enabled: false
	    }
	});
}
