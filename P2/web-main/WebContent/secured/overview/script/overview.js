var objStDtBkGpVlCr;
var ovr_lvl_code = '1';
var sel_ovr_sub_grp = '1';
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
		$("#div_rd_st_ovr").show();
		$("#div_rd_dt_ovr").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
		
	}
	else if(user_role == "st_user") {
		sel_fltr_level = 'ST';
		$("#div_rd_st_ovr").show();
		$("#div_rd_dt_ovr").show();
		$("#rdb_st").prop('checked', true);
		$("#div_dt").hide();
		$("#div_bk").hide();
		$("#div_gp").hide();
	}
	else if(user_role == "dt_user") {
		sel_fltr_level = 'DT';
		$("#div_rd_st_ovr").hide();
		$("#div_rd_dt_ovr").show();
		$("#rdb_dt").prop('checked', true);
		$("#div_dt").show();
		$("#div_bk").hide();
		$("#div_gp").hide();
	} 
	else if(user_role == "bk_user") {
		sel_fltr_level = 'BK';
		$("#div_rd_st_ovr").hide();
		$("#div_rd_dt_ovr").hide();
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
	//$("#sel_mnth_yr").val("2019-09");
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
					objStDtBkGpVlCr = eval ("("+ response +")");
					popSubGroup();					
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
 * Function to populate Sub-group
 * @returns
 */
function popSubGroup() {
	//showModal();
	$.ajax({
		url: "../../pop.OverviewSubGroup",
		type: "get",
		data: {
			type : ovr_lvl_code			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get Sub-group.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				
				var ovr_sub_grp_ul = $('#ovr_sub_grp_ul');
				$.each(obj_response, function(i) {
				    var li = $('<li/>')
				        .addClass('ovr_sub_grp_ul_li')
				        .css('cursor', 'pointer')
				    	.attr('id', obj_response[i][0])
				    	.attr('title', obj_response[i][1])
				    	.text(obj_response[i][1])
				        .appendTo(ovr_sub_grp_ul);				    
				});
				$('#ovr_sub_grp_ul li:first').addClass('active');
				$("#ovr_sub_grp_ul li.active").css('background-color', '#006c90');
				popComboDist();
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
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
	} else if(sel_radio == "district") {
		$('#div_dt').show();
		$('#div_bk').hide();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "DT";
		$("#1").removeClass('li_disabled');
		$("#2").removeClass('li_disabled');
		$("#3").removeClass('li_disabled');
		$("#4").removeClass('li_disabled');
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');		
	} else if(sel_radio == "block") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').hide();
		$('#div_vl').hide();
		$('#div_cr').hide();
		sel_fltr_level = "BK";
		$("#1").removeClass('li_disabled');
		$("#2").removeClass('li_disabled');
		$("#3").removeClass('li_disabled');
		$("#4").removeClass('li_disabled');
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
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
		$("#1").removeClass('li_disabled');
		$("#2").removeClass('li_disabled');
		$("#3").removeClass('li_disabled');
		$("#4").removeClass('li_disabled');
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
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
		$("#1").removeClass('li_disabled');
		$("#2").removeClass('li_disabled');
		$("#3").removeClass('li_enabled');
		$("#4").removeClass('li_disabled');		
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_disabled');
		$("#4").addClass('li_enabled');	
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
			//$("#sel_bk").trigger("change");
			$("#sel_gp").trigger("change");
		}
	} else if(sel_radio == "creche") {
		$('#div_dt').show();
		$('#div_bk').show();
		$('#div_gp').show();
		$('#div_vl').show();
		$('#div_cr').show();
		sel_fltr_level = "CR";
		$("#1").removeClass('li_disabled');
		$("#2").removeClass('li_disabled');
		$("#3").removeClass('li_enabled');
		$("#4").removeClass('li_disabled');		
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_disabled');
		$("#4").addClass('li_enabled');
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
	$("#div_functional").html("");
	$("#div_children").html("");
	$("#div_anthro").html("");
	$("#div_monthly").html("");
	$("#div_filter_details").html("");
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
	console.log(objStDtBkGpVlCr);
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
	var vl_code = $("#sel_vl option:selected").val();	
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
	/*console.log(sel_fltr_level);
	if(sel_fltr_level == "VL" || sel_fltr_level == "CR") {
		bootbox.alert("Child Anthropometry is not applicable for Village & Creche level.");
		hideModal();
		return;
	}*/	
	popIndicator();
});


/**
 * Function to click on sub menu
 */
$("#ovr_sub_grp_ul").on("click", "li", function() {	
	//console.log(this.id+"..."+$("#"+this.id).text());
	
	//Remove the active class
	$(".ovr_sub_grp_ul_li").css('background-color', '#63adc5');
	$(".ovr_sub_grp_ul_li").removeClass('active');
	//Add the active class
	$("#"+this.id).addClass("active");	
	$("#"+this.id).css('background-color', '#006c90');
	sel_ovr_sub_grp = this.id;
	
	//Functional Creches
	if(sel_ovr_sub_grp == "1") {
		$('#div_functional').show();
		$('#div_children').hide();
		$('#div_anthro').hide();
		$('#div_monthly').hide();
		$("#rdb_vl").prop("disabled", false);
		$("#rdb_cr").prop("disabled", false);
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
	}
	//Children in Creches
	else if(sel_ovr_sub_grp == "2") {
		$('#div_functional').hide();
		$('#div_children').show();
		$('#div_anthro').hide();
		$('#div_monthly').hide();
		$("#rdb_vl").prop("disabled", false);
		$("#rdb_cr").prop("disabled", false);
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
	}
	//Child Anthropometry
	else if(sel_ovr_sub_grp == "3") {
		$('#div_functional').hide();
		$('#div_children').hide();
		$('#div_anthro').show();
		$('#div_monthly').hide();
		$("#rdb_vl").prop("disabled", true);
		$("#rdb_cr").prop("disabled", true);
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
	}
	//Monthly Status
	else if(sel_ovr_sub_grp == "4") {
		$('#div_functional').hide();
		$('#div_children').hide();
		$('#div_anthro').hide();
		$('#div_monthly').show();
		$("#rdb_vl").prop("disabled", false);
		$("#rdb_cr").prop("disabled", false);
		$("#1").addClass('li_enabled');
		$("#2").addClass('li_enabled');
		$("#3").addClass('li_enabled');
		$("#4").addClass('li_enabled');
	}	
	clearComboData();	
	$('#div_dt').hide();
	$('#div_bk').hide();
	$('#div_gp').hide();
	$('#div_vl').hide();
	$('#div_cr').hide();
	//sel_fltr_level = "ST";
	//$("#rdb_st").prop('checked', true);
	popComboDist();
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
	$.ajax({
		url: "../../pop.OverviewIndicator",
		type: "get",
		data: {
			sel_fltr_level : sel_fltr_level,
			sel_ovr_sub_grp : sel_ovr_sub_grp
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
			    
			    var div_data = '<div id="div_outer" >';
			    
			    //var max = 3;
			    var max;
			    var cls_col;
			    //Functional Creches
			    if(sel_ovr_sub_grp == "1") {
			    	max = 3;
			    	cls_col = 'col-sm-4';
			    }
			    //Children in Creches
			    else if(sel_ovr_sub_grp == "2") {
			    	max = 3;
			    	cls_col = 'col-sm-4';
			    } 
			    //Child Anthropometry
			    else if(sel_ovr_sub_grp == "3") {
			    	max = 1;
			    	cls_col = 'col-sm-12';
			    } 
			    //Monthly Status
			    else if(sel_ovr_sub_grp == "4") {
			    	max = 6;
			    	cls_col = 'col-sm-2';
			    } else {
			    	max = 3;
			    	cls_col = 'col-sm-4';
			    }
		        var count = 1;
		        $.each(obj_response, function(i) {
		        	if (count > max) {
		        		div_data += "</div>";
		                div_data += "<div id='div_inner' >";
		                count = 1;
		            }	
		        	div_data += "<div id='div_"+obj_response[i][0]+"' class='"+cls_col+"' style='border: 1px solid #1fc4da;'></div>";
		            count++;
		            prepareChart('div_'+obj_response[i][0], obj_response[i][0], obj_response[i][1], obj_response[i][2], obj_response[i][4]);
				});
			    
			    div_data += "</div>";
			    if(sel_ovr_sub_grp == "1") {
			    	$("#div_functional").html(div_data);
			    }
			    else if(sel_ovr_sub_grp == "2") {
			    	$("#div_children").html(div_data);
			    }
			    else if(sel_ovr_sub_grp == "3") {
			    	$("#div_anthro").html(div_data);
			    }
			    else if(sel_ovr_sub_grp == "4") {
			    	$("#div_monthly").html(div_data);
			    }			    
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
 * Function to prepare Chart Data
 * @returns
 */
function prepareChart(div_id, indi_id, indi_name, chart_type, indi_options) {
	//console.log("here in prepareChart..."+indi_id+"..."+chart_type);
	//# Type of Creche Category 27.01.2022
	var sel_creche_catg = $('#sel_catg :selected').val();
	
	var sel_fltr_level_code;
	if(sel_fltr_level == "ST") {
		sel_fltr_level_code = null;
	}
	else if(sel_fltr_level == "DT") {
		sel_fltr_level_code = $("#sel_dt option:selected").val();
	}
	else if(sel_fltr_level == "BK") {
		sel_fltr_level_code = $("#sel_bk option:selected").val();
	}
	else if(sel_fltr_level == "GP") {
		sel_fltr_level_code = $("#sel_gp option:selected").val();
	}
	else if(sel_fltr_level == "VL") {
		sel_fltr_level_code = $("#sel_vl option:selected").val();
	}
	else if(sel_fltr_level == "CR") {
		sel_fltr_level_code = $("#sel_cr option:selected").val();
	}
	
	var sel_period = $("#sel_period option:selected").val();
	//alert(sel_period);
	
	//showModal();
	$.ajax({
		url: "../../pop.ChartOverview",
		type: "get",
		data: {			
			sel_fltr_level : sel_fltr_level,
			sel_fltr_level_code : sel_fltr_level_code,
			sel_ovr_sub_grp : sel_ovr_sub_grp,
			indi_id : indi_id,			
			sel_mnth_yr : $("#sel_mnth_yr").val(),
			sel_period : sel_period,
			sel_creche_catg : sel_creche_catg //# 27.01.2022
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				//bootbox.alert("Unable to get Chart Data.");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				
				if(chart_type == "Number Widget") {
					//drawWidget(div_id, indi_id, indi_name, obj_response);
					drawWidget2(div_id, indi_id, indi_name, obj_response);
				} else if(chart_type == "Info") {
					//console.log("here...");
					drawInfo(div_id, indi_id, indi_name, obj_response);					
				}
				else if(chart_type == "Column Chart") {
					var arr_option = indi_options.split('$');
					var catg_data = [''];
					var arr_data_set = [];
					var chart_heading = indi_name;
					
					for (var i = 0; i < arr_option.length; i++) {
						var json_data = {};
						json_data['name'] = arr_option[i];
						json_data['data'] = [parseInt(obj_response[0][i])];
						//console.log(json_data);
						arr_data_set[i] = json_data;
					}
					drawColumnChart(div_id, indi_name, catg_data, arr_data_set, chart_heading);					
				}
				else if(chart_type == "Stacked Bar Chart") {
					var catg_data = [];
					var arr_option = indi_options.split('$');
					var arr_data_set = [];
					var chart_heading = indi_name;
					for (var i = 0; i < arr_option.length; i++) {
						var json_data = {};
						json_data['name'] = arr_option[i];
						
						var start_col = parseInt(obj_response[0].length) - parseInt(arr_option.length); 
						var arr_data = [];
						for (var j = 0; j < obj_response.length; j++) {
							catg_data[j] = obj_response[j][1];
							//Chart dataset starts from 3rd column
							arr_data[j] = parseInt(obj_response[j][i+2]);
						}
						json_data['data'] = arr_data;
						//json_data['index'] = (arr_option.length - i);
						//console.log(arr_data);
						//console.log(json_data);
						arr_data_set[i] = json_data;
					}
					//console.log(arr_data_set);
					//console.log(catg_data);
					drawStackedBarChart(div_id, indi_name, catg_data, arr_data_set, chart_heading);
				}
				else if(chart_type == "Table Widget") {
					var arr_option = indi_options.split('$');
					var chart_heading = "";
					
					drawTableChart(div_id, indi_id, indi_name, arr_option, obj_response, chart_heading);
				} else if(chart_type == "Pie Chart") {
					var arr_option = indi_options.split('$');
					var catg_data = [];
					var arr_data_set = [];
					var chart_heading = indi_name;
					for (var i = 0; i < arr_option.length; i++) {
						catg_data[i] = arr_option[i]
						var json_data = {};
						json_data['name'] = arr_option[i];
						json_data['y'] = parseInt(obj_response[0][i]);
						//json_data['tt'] = '0.0%';
						arr_data_set[i] = json_data;
					}
					drawPieChart(div_id, indi_name, catg_data, arr_data_set, chart_heading);
				}
				//hideModal();
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get Chart Data.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to draw Information
 * @param div_id
 * @param indi_id
 * @param indi_name
 * @param obj_response
 * @returns
 */
function drawInfo(div_id, indi_id, indi_name, obj_response) {
	//console.log(div_id);
	//console.log(indi_id);
	//console.log(indi_name);
	//console.log(obj_response);
	
	var obj_transpose_data = transpose(obj_response);
	
	var str_tbl = '';
	str_tbl += '<div class="tblFuncBox">';	
		str_tbl += '<table id="tbl_func_cr" class="tbl_func_cr">';
		for (var i = 0; i < obj_transpose_data.length; i++) {
			str_tbl += '<tr>';
			for (var j = 0; j < obj_transpose_data[i].length; j++) {
				str_tbl += '<td>'+obj_transpose_data[i][j]+'</td>';
			}
			str_tbl += '</tr>';
		}
		str_tbl += '</table';
	str_tbl += '</div>';
	
	$('#'+div_id).html(str_tbl);
}


/**
 * Function to transpose a 2D Array
 * @param a
 * @returns
 */
function transpose(a) {
	// Calculate the width and height of the Array
	var w = a.length || 0;
	var h = a[0] instanceof Array ? a[0].length : 0;

	// In case it is a zero matrix, no transpose routine needed.
	if(h == 0 || w == 0) {
		return []; 
	}

	/**
	* @var {Number} i Counter
	* @var {Number} j Counter
	* @var {Array} t Transposed data is stored in this array.
	*/
	var i, j, t = [];

	// Loop through every item in the outer array (height)
	for(i = 0; i < h; i++) {
		// Insert a new row (array)
	    t[i] = [];
	    // Loop through every item per item in outer array (width)
	    for(j = 0; j < w; j++) {
	    	//Save transposed data.
	    	t[i][j] = a[j][i];
	    }
	}
	return t;
}


/**
 * Function to draw Pie Chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param arr_data_set
 * @param chart_heading
 * @returns
 */
function drawPieChart(div_id, indi_name, catg_data, arr_data_set, chart_heading) {
	//console.log(catg_data);
	//console.log(arr_data_set);
	
	showModal();
	$('#lbl_indi').html(indi_name);
	Highcharts.chart(div_id, {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: chart_heading,
	        style: {
	            color: '#000000',
	            fontWeight: 'bold',
	            fontSize: '12px'
	        }
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    legend:{	    	
	    	//enabled: true,
            //floating: true,
            //align: 'bottom',
	    	//verticalAlign:'middle',
            //width: 200,
            //itemWidth: 100
        },
	    plotOptions: {
	        pie: {
	        	size: 230,
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	            	enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                distance: '-30%',
	                style: {
	                	color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'black',
	                    textShadow: false,
	                    textOutline: false,
	                    fontFamily: 'Roboto,sans-serif',
	                    fontSize: 10,
	                    fontWeight: 'normal',
	                    whiteSpace:'normal'
	                }
	            },
	            showInLegend: true
	        }
	    },
	    series: [{
	        name: 'Value',
	        colorByPoint: true,
	        data: arr_data_set,
	        /*cursor: 'pointer',
            //Handling click event
            point: {
                events: {
                    click: function () {
                        alert('Category: ' + this.name + ', value: ' + this.y);
                    }
                }
            }*/
	    }],
	    //colors: ['#2836AF', '#04C034', '#BB36E6', '#46303B', '#B52121'],
	    colors: ['#f79646', '#88c7d9', '#8064a2', '#8B4B62','#EA9674','#F7E29C','#0F6A8B','#46698D','#FCBC80','#836890','#C36894','#EB6896','#BB6F6B'],
	    credits: {
	        enabled: false
	    },
	    exporting: { 
	    	enabled: false,
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


function drawWidget2(div_id, indi_id, indi_name, obj_response) {
	//console.log(indi_id);
	//console.log(indi_name);
	var WidgetChartTitle="";
	
	var font_size;
	
	//Functional Creches
	if(indi_id == "0001") {
		$('#'+div_id).css({
			'min-width': '160px',
			'max-width': '300px',
			'height': '386px',
			'margin': '0 auto',
			//'border': '1px solid black'
		});
		font_size = '15px';
	} 
	//Children in Creches
	else if(indi_id == "0004" || indi_id == "0005" || indi_id == "0006") {
		$('#'+div_id).css({
			'min-width': '160px',
			'max-width': '300px',
			'height': '385px',
			'margin': '0 auto',
			//'border': '1px solid black'
		});
		font_size = '15px';
		WidgetChartTitle = indi_name;// + " : "+ obj_response[0][0]; //# 05.10.2020
	} 
	//Monthly Status
	else {
		$('#'+div_id).css({
			'min-width': '160px',
			'max-width': '300px',
			'height': '185px',
			'margin': '0 auto',
			//'border': '1px solid black'
		});
		font_size = '12px';
	}
		
	//console.log(getWidgetCaption(indi_name, obj_response[0][0]));
	Highcharts.chart({
		chart: {
            renderTo: div_id,
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
	                    fontSize: font_size,
	                    color: "#000",
	                    fontWeight: "normal"
	                }
	            }
	        }
	    },
	    tooltip: {
	        enabled: false
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
	            name: getWidgetCaption(indi_name, obj_response[0][0]),
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
	    },
	    
	    tooltip: {
	        headerFormat:
	            //'<span style="color:{point.color}">\u2022</span> ' +
	            //'<span style="font-size: 14px"> {point.point.name}</span><br/>',
	        	'<span style="font-size: 14px"> {}</span><br/>',
	            pointFormat: '{point.description} : <span style="font-size: 14px; text-align: center; font-weight: bold;">'+obj_response[0][0]+'</span>'
	        	
	    },
	    */
	    title: {
	        //text: '<span style="font-size:12px;text-align:center;">'+ WidgetChartTitle +'</span>',
	    	text:  WidgetChartTitle,
	    	margin:50
	    	
	    },
	    credits: {
	        enabled: false
	    },
	    exporting: {
	    	enabled: false
	    }
	});
}


/**
 * Function to draw Widget
 * @param div_id
 * @param indi_id
 * @param indi_name
 * @param obj_response
 * @returns
 */
function drawWidget(div_id, indi_id, indi_name, obj_response) {
	//console.log(div_id+"..."+indi_id+"..."+indi_name+"..."+obj_response);
	var dv = $('<div>')
		    .addClass('circle')
		    .css('width', '200px')
		    .css('height', '200px')
		    .css('border-radius', '250px')
		    .css('font-size', '20px')
		    .css('color', 'black')
		    .css('line-height', '25px')
		    .css('text-align', 'center')
		    .css('background', '#86c25e')
			.attr('id', "circle_"+indi_id)
			.attr('title', indi_name)
			.appendTo('#'+div_id);
	
	var p = $('<p>')
			.css('width', '160px')
		    .css('height', '150px')
			.text(indi_name+" "+obj_response[0][0])
			.appendTo(dv);
	
}


/**
 * Function to get Widget Caption
 * @param indi_name
 * @param data_val
 * @returns
 */
function getWidgetCaption(indi_name, data_val) {
	if(indi_name == "No. of Functional Creches") {
		return "No. of Functional Creches : <b>"+data_val+"</b>";		
		//return '<div style="width: 50px;"><h4 style="text-align: center;">No. of Functional Creches<br>'+data_val+'</h4></div>';		
	} else if(indi_name == "No. of Children as per HH Listing") {
		return "HH Listing Children : <b>"+data_val+"</b>";
	} else if(indi_name == "Total Enrolment in Creche") {
		//return "Creche Enrolment : <b>"+data_val+"</b>";
		return "Creche Admitted : <b>"+data_val+"</b>";
	} else if(indi_name == "Current Level of Enrolment in Creches (Total Enrolment minus Graduated Children)") {
		return "Present Admitted : <b>"+data_val+"</b>";
	} else if(indi_name == "No. of red flag children") {
		return "No. Red Flag : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of Severely underweight children") {
		return "SUW % : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of Severely wasted children") {
		return "SWC % : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of one-month growth faltered children") {
		return "1M GFC % : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of Severely stunted children") {
		return "SSC % : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of children with red colour MUAC") {
		return "Red MUAC % : <b>"+data_val+"</b>";
	} else if(indi_name == "No. of children with disability") {
		return "No. Disabled : <b>"+data_val+"</b>";
	} else if(indi_name == "No. of children with long-term illness") {
		return "No. LT Illness : <b>"+data_val+"</b>";
	} else if(indi_name == "No. of children with long-term illness in family") {
		return "LT Illness in family : <b>"+data_val+"</b>";
	} else if(indi_name == "Percentage of two months or more growth faltered children") {
		return "2M GFC % : <b>"+data_val+"</b>";
	} else if(indi_name == "No. of children with illness") {
		return "No. Illness : <b>"+data_val+"</b>";
	}
}


/**
 * Function to draw Column Chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param chart_data_set
 * @param chart_heading
 * @returns
 */
function drawColumnChart(div_id, indi_name, catg_data, chart_data_set, chart_heading) {
	//console.log(catg_data);
	//console.log(chart_data_set);	
	//showModal();
		
	Highcharts.chart({
		chart: {
			renderTo: div_id,
            type: 'column',
	        //width: '200px'
            //Highchart initialisation finished
            events: {
                load: function(event) {
                	hideModal();
                }
            }        
        },
	    title: {
	        text: chart_heading,
	        style: {
	            color: '#000000',
	            fontWeight: 'bold',
	            fontSize: '12px'
	        }
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
	    	followPointer:true,
	        headerFormat: '<b>{point.x}</b><br/>',
	        pointFormat: '{series.name}: {point.y}'
	    },
	    legend: {
	        verticalAlign: 'bottom',
	        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	    },
	    plotOptions: {
	        column: {
	            dataLabels: {
	                enabled: false,
	                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'black'
	            }
	        },
	        series: {
	        	//Column width
                pointWidth: 20
	        }
	    },
	    colors: ['#f79646', '#4bacc6', '#8064a2', '#8B4B62','#BB6F6B','#EA9674','#FCBC80','#F7E29C', '#0F6A8B', '#46698D', '#836890', '#C36894', '#EB6896', '#AA19CE', 'A57EAF', '#2D6EDC', '#4FC071', '#A2C04F'],
	    credits: {
	        enabled: false
	    },
	    series : chart_data_set,
	    credits: {
	        enabled: false
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
	});
	//hideModal();
}


/**
 * Function to draw Table Chart
 * @param div_id
 * @param indi_id
 * @param indi_name
 * @param indi_options
 * @param obj_response
 * @param chart_heading
 * @returns
 */
function drawTableChart(div_id, indi_id, indi_name, indi_options, obj_response, chart_heading) {
	//showModal();
	//console.log("Total Columns..."+indi_options.length);
	//console.log("Dataset Columns..."+obj_response[0].length);
	var start_col = parseInt(obj_response[0].length) - parseInt(indi_options.length); 
	
	var tableData = "";
	tableData += "<table id='tbl_data_"+indi_id+"' class='display overview_child_anthro_table' cellspacing='0' width='100%'>";
		tableData += "<thead>";
			tableData += "<tr>"
			for (var i = 0; i < indi_options.length; i++) {
				tableData += "<th>"+indi_options[i]+"</th>";
			}
			tableData += "</tr>"
	    tableData += "</thead>";
	    
	    tableData += "<tbody>";
	    for (var i = 0; i < obj_response.length; i++) {
	    	tableData += "<tr>";
	    	for (var j = start_col; j < obj_response[i].length; j++) {
	    		tableData += "<td>"+obj_response[i][j]+"</td>";	    	
	    	}	    	
	    	tableData += "</tr>";
	    }
	    tableData += "</tbody>";
	tableData += "</table>";
	//console.log(tableData);
	$('#'+div_id).html(tableData);
	
	$('#tbl_data_'+indi_id).DataTable({		
		"scrollY": "200px",
		"scrollX": true,
        "scrollCollapse": true,        
        "paging": false,
        "searching": false,
        "info": false,
        //2D array - first inner array as the page length values and the second inner array as the displayed options
        //"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "lengthMenu": [[-1], ["All"]],
        //"ordering": false
        /* Disable initial sort */
        "order": [],
        //Hide 1st column, here District/Block/GP/Village/Creche Code
        "columnDefs": [
        	{
        		"targets": [ 0 ],
                "visible": false,
                "searchable": false                
            },
        	{
        		//Align as center for all columns except 1st column
                "targets": [2, 3, 4, 5, 6, 7 ],
                "className": "text-center"
        	}
        ],
        //DataTables initialisation finished
        "fnInitComplete": function (oSettings, json) {
            hideModal();
        }
   });
	
	//Draw Table Chart
	var table = $('#tbl_data_'+indi_id).DataTable();
	
	//For adjustment of Table row automatically
	table.columns.adjust().draw();	
	//hideModal();
}


/**
 * Function to draw stacked bar chart
 * @param div_id
 * @param indi_name
 * @param catg_data
 * @param chart_data_set
 */
function drawStackedBarChart(div_id, indi_name, catg_data, chart_data_set, chart_heading) {
	//console.log(catg_data);
	//console.log(chart_data_set);
	//showModal();
		
	Highcharts.chart({
		chart: {
            renderTo: div_id,
            type: 'bar',
	        //width: '200px'
            //Highchart initialisation finished
            events: {
            	load: function(event) {
            		hideModal();
                }
            }        
        },
	    title: {
	        text: chart_heading,
	        style: {
	            color: '#000000',
	            fontWeight: 'bold',
	            fontSize: '12px'
	        }
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
	    	followPointer:true,
	        headerFormat: '<b>{point.x}</b><br/>',
	        pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
	    },
	    plotOptions: {
	        bar: {
	            stacking: 'normal',
	            dataLabels: {
	                enabled: false,
	                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'black'
	            }
	        }
	    },
	    colors: ['#f79646', '#88c7d9', '#8064a2', '#b65708', '#276a7c', '#534167', '#8B4B62','#BB6F6B','#EA9674','#FCBC80','#F7E29C', '#0F6A8B', '#46698D', '#836890', '#C36894', '#EB6896', '#AA19CE', 'A57EAF', '#2D6EDC', '#4FC071', '#A2C04F'],
	    credits: {
	        enabled: false
	    },
	    series : chart_data_set,
	    credits: {
	        enabled: false
	    },
	    exporting: { 
	    	enabled: false,
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
	//hideModal();
}