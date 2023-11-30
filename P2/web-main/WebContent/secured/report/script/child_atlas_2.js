	

$(document).ready(function(){
	popDtBkCr();
});

/**
 * Function to populate District Block Creche
 * @returns
 */
function popDtBkCr() {	
	showModal();	
	$.ajax({
		url: "../../pop.DtBkCr",
		type: "GET",
		dataType: 'json',	//specify the response type, here return type is a JSON Object
		data: {
			//dt_code: dt_code, 
		},
		success: function(response) {
			if (response == "N/A") {
				alert("Unable to get Data!");
				hideModal();
				return;
			} else {
				//jsonDtBkCrData = response;
				//console.log(jsonDtBkCrData);
				//popCombo('DT');
				
				objStDtBkCr = response;
				//console.log(objStDtBkCr);
				popCombo('DT');
			}
		},
		error: function(xhr) {			
			alert("Unable to get Data!");
			hideModal();
			return;
		}
	});//End of Ajax request
}


/**
 * Function to populate District/Block/Creche Combo
 * @param level
 * @returns
 */
function popCombo(level) {
	//console.log("here in popCombo2..."+level);
	if(level == 'DT') {
		$('#sel_dt').html('');
		//$('#sel_dt').append('<option value="select">Select District</option>');
		var arr_dt = GetUniqueDT();
		
		for (var i = 0; i < arr_dt.length; i++) {
			var data = arr_dt[i].split("^");
			$('#sel_dt').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }		
		popCombo('BK');
	} else if(level == 'BK') {
		$('#sel_bk').html('');	
		//$('#sel_bk').append('<option value="select">Select Block</option>');
		var arr_bk = GetUniqueBK();
		for (var i = 0; i < arr_bk.length; i++) {
			var data = arr_bk[i].split("^");
			$('#sel_bk').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }
		popCombo('Proj');
	} else if(level == 'Proj') {
		$('#sel_pjtprg').html('');
		//$('#sel_cr').append('<option value="select">Select Creche</option>');
		var arr_proj = GetUniqueProj();
		for (var i = 0; i < arr_proj.length; i++) {
			var data = arr_proj[i].split("^");
			$('#sel_pjtprg').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }
		popCombo('CR');
		
	} else if(level == 'CR') {
		$('#sel_cr').html('');
		
		var sel_dt = $("#sel_dt option:selected").val(); // Dist Code
		var sel_bk = $("#sel_bk option:selected").val(); // Block Code
		var sel_pjtprg = $("#sel_pjtprg option:selected").val(); // Project Code
		
		//$('#sel_cr').append('<option value="select">Select Creche</option>');
		var arr_cr = GetUniqueCR();
		
		//console.log("CR LIST : "+arr_cr);
		
		for (var i = 0; i < arr_cr.length; i++) {
			var data = arr_cr[i].split("^");
			// if Dist, Block, Project Chacking
			if (data[0] == sel_dt && data[1] == sel_bk && data[2] == sel_pjtprg){
				$('#sel_cr').append('<option value="'+data[3]+'">'+data[4]+'</option>');
			}
			//$('#sel_cr').append('<option value="'+data[0]+'">'+data[1]+'</option>');
	    }
		hideModal();
	}	
}


/**
 * Function to get unique District
 * @returns
 */
function GetUniqueDT() {
	var inputArray = objStDtBkCr;
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
 * Function to get unique Block
 * @returns
 */
function GetUniqueBK() {
	var inputArray = objStDtBkCr;
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
 * Function to get unique Creche
 * @returns
 */
function GetUniqueProj() {
	var inputArray = objStDtBkCr;
	var bk_code = $("#sel_bk option:selected").val();	
	//console.log(bk_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][4] == bk_code){
			if ((jQuery.inArray(inputArray[i][6]+"^"+inputArray[i][6], outputArray)) == -1){
				outputArray.push(inputArray[i][6]+"^"+inputArray[i][6]);
			}
		}
	}
	return outputArray;
}

/**
 * Function to get unique Creche
 * @returns
 */
function GetUniqueCR() {
	var inputArray = objStDtBkCr;
	var proj_code = $("#sel_pjtprg option:selected").val();	
	//console.log("Pj Code : "+proj_code);
	var outputArray = [];
	for (var i = 0; i < inputArray.length; i++){
		if(inputArray[i][6] == proj_code){
			// Dt Code, Bk Code, Prj Code, CR Code, CR Name
			if ((jQuery.inArray(inputArray[i][2]+"^"+inputArray[i][4]+"^"+inputArray[i][6]+"^"+inputArray[i][7]+"^"+inputArray[i][8], outputArray)) == -1){
				outputArray.push(inputArray[i][2]+"^"+inputArray[i][4]+"^"+inputArray[i][6]+"^"+inputArray[i][7]+"^"+inputArray[i][8]);
			}
		}
	}
	return outputArray;
}


/**
 * Function to populate Nutritional Data
 * @returns
 */
function prepareNutriDataNew(){
	showModal();
	
	var lvl = "c";
	var code = $("#sel_cr option:selected" ).val();
	$.ajax({
		url: "../../nutri.getDataNew",
		type: "get",
		data: {
			lvl : lvl,
			code : code,
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				alert("Data not available.");
				$("#normal").text("0");
				$("#moderate").text("0");
				$("#severe").text("0");
				$("#total").text("0");
				hideModal();
				return;
			} else {
				var obj_response  = eval ("("+ response +")");
				//console.log(obj_response);
				
				var tableData = '';
				tableData += '<table id="tbl_child_nutri2" border=1 class="display tbl_child_atlas2" cellspacing="0" width="100%">';
				tableData += '<thead>';
				for (var i = 0; i < 2; i++) {					
					tableData += '<tr>';
					if(i == 0) {
						for (var j = 0; j < obj_response[i].length; j++) {
							if(j == 0) {
								tableData += '<th rowspan="2">Child ID</th>';
							} 
							else if(j == 1) {
								tableData += '<th rowspan="2">Child Name</th>';
							}
							else {
								tableData += '<th colspan="3">'+getShortMonthYear(obj_response[i][j].substring(0, obj_response[i][j].indexOf("$")))+'</th>';
								j = j+2;
							}						
						}
					} else if(i == 1) {
						for (var j = 0; j < 12; j++) {
							tableData += '<th>U</th>';
							tableData += '<th>S</th>';
							tableData += '<th>W</th>';
						}
					}					
					tableData += '</tr>';
				}
				tableData += '</thead>';
				tableData += '<tbody>';
				for (var i = 0; i < obj_response.length; i++) {	
					tableData += '<tr>';
					for (var j = 0; j < obj_response[i].length; j++) {
						if(j == 0 || j == 1) {
							tableData += '<td>'+ obj_response[i][j]+'</td>';
						} else {
							var mnth_yr = obj_response[i][j].substring(0, obj_response[i][j].indexOf("$"));
							var child_color = obj_response[i][j].substring(obj_response[i][j].indexOf("$")+1, obj_response[i][j].indexOf("#"));
							var data_val = obj_response[i][j].substring(obj_response[i][j].indexOf("#")+1, obj_response[i][j].length);
							
							if(data_val == 'NA') {
								tableData += '<td class="txt_cntr">-</td>';
							} else {
								if(child_color == 'Green') {
									tableData += '<td class="txt_cntr set_bg_col_green">'+data_val+'</td>';
								} else if(child_color == 'Yellow') {
									tableData += '<td class="txt_cntr set_bg_col_yellow">'+data_val+'</td>';
								} else if(child_color == 'Red') {
									tableData += '<td class="txt_cntr set_bg_col_red">'+data_val+'</td>';
								} else if(child_color == 'White') {
									tableData += '<td class="txt_cntr set_bg_col_white">'+data_val+'</td>';
								} else {
									tableData += '<td class="txt_cntr">'+data_val+'</td>';
								}
							}														
						}	
					}
					tableData += '</tr>';
				}				
				tableData += '</tbody>';
				tableData += '</table>';			
				//console.log(tableData);
				
				$('#nutri2').html(tableData);
				
				var table = $('#tbl_child_nutri2').DataTable( {
					"scrollY": "200px",
					"scrollX": true,
					"scrollCollapse": true,
			        "paging": false,
			        "searching": false,
			        "info": false,
			        "columnDefs": [
			        	{
			        		//1st, 2nd, 3rd, 4th, 5th, 6th month set as hide
			        		"targets": [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],
			                "visible": false,
			                "searchable": false,
			            },
			            { "width": "10px", "targets": 0 },
			            { "width": "220px", "targets": 1 },
			            { "width": "3px", "targets": [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37] },
			        ], 
			        //fixedColumns: true,
			        "fixedColumns":   {
			            "leftColumns": 2
			        }
			    });
				table.columns.adjust().draw();
				$("#div_back").show();
				$("#div_default").show();
				nutriCountNew(obj_response);
				
				//Row Click event
				/*$('.DTFC_Cloned tbody tr').on('click', function () {
					//alert("here clicked2...");
					$(".DTFC_Cloned tbody tr").removeClass('row_selected');
					$("#tbl_child_nutri2 tbody tr").removeClass('row_selected');
					$(this).addClass('row_selected');
					var data = table.row( this ).data();
					var childCode = data[0];
					var childName = data[1];					
					console.log(childCode+"..."+childName);	
				});*/
				
				$('#tbl_child_atlas2 tbody tr').on('click', function () {
				     $(this).addClass('row_selected');
				});
				$('.DTFC_Cloned tbody tr').on('click', function () {
				     $(this).addClass('row_selected');
				});
				
				$(".tbl_child_atlas2 tbody tr").on('click',function(event) {
					//alert("here clicked...");
					$(".DTFC_Cloned tbody tr").removeClass('row_selected');
					$(".tbl_child_atlas2 tbody tr").removeClass('row_selected');
					$(this).addClass('row_selected');
					var data = table.row( this ).data();
					var childCode = data[0];
					var childName = data[1];					
					//console.log(childCode+"..."+childName);	
					$("#child_code").val(childCode);
					$("#child_name").val(childName);
						
					/*document.getElementById("child_code").value = childCode;
			  		document.getElementById("child_name").value = childName;
			  		document.getElementById("refresh").disabled = false;
			  		document.getElementById("sort_age").disabled = false;
			  		
			  		document.getElementById("imageView").src = "";
			  		document.getElementById("imgDiv").style.display = "none";
			  		document.getElementById("info").innerHTML = "";
			  		
			  		document.getElementById("WFA_legend").style.display = "none";
			  		document.getElementById("wfa_head").style.display = "none";
			  		document.getElementById("wfa_large").style.display = "none";
			  		
			  		document.getElementById("HFA_legend").style.display = "none";
			  		document.getElementById("hfa_head").style.display = "none";
			  		document.getElementById("hfa_large").style.display = "none";
			  		
			  		document.getElementById("WFL_legend").style.display = "none";
			  		document.getElementById("wfl_head").style.display = "none";
			  		document.getElementById("wfl_large").style.display = "none";
			  		
			  		document.getElementById("WFA_chart_div").innerHTML = "";
			  		document.getElementById("HFA_chart_div").innerHTML = "";
			  		document.getElementById("WFL_chart_div").innerHTML = "";*/
			  		
			  		childInfo(childCode, childName);
				});				
				//hideModal();
			}
		},
		error: function(xhr) {
			alert("Data not available.");
			hideModal();
			return;
		}
	});
}


/**
 * Function to get Month name in short
 * @param str_val
 * @returns
 */
function getShortMonthYear(str_val) {
	var mnth_yr = str_val.split('-');
	var mnth = mnth_yr[0];
	var yr = mnth_yr[1];
	
	if(mnth == "January"){
		return "Jan"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "February"){
		return "Feb"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "March"){
		return "Mar"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "April"){
		return "Apr"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "May"){
		return "May"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "June"){
		return "Jun"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "July"){
		return "Jul"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "August"){
		return "Aug"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "September"){
		return "Sep"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "October"){
		return "Oct"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "November"){
		return "Nov"+"-"+yr.substring(2, yr.length);
	} else if(mnth == "December"){
		return "Dec"+"-"+yr.substring(2, yr.length);
	}
}


var bck_count = 0;
$("#btn_back").click(function() {
	//console.log("here...");
    var table = $('#tbl_child_nutri2').DataTable();
    
    if(bck_count == 0) {
    	//4th Month
        table.column(11).visible(true);
        table.column(12).visible(true);
        table.column(13).visible(true);
        //5th Month
        table.column(14).visible(true);
        table.column(15).visible(true);
        table.column(16).visible(true);
        //6th Month
        table.column(17).visible(true);
        table.column(18).visible(true);
        table.column(19).visible(true);
        //7th Month
        table.column(29).visible(false);
        table.column(30).visible(false);
        table.column(31).visible(false);
        //8th Month
        table.column(32).visible(false);
        table.column(33).visible(false);
        table.column(34).visible(false);
        //9th Month
        table.column(35).visible(false);
        table.column(36).visible(false);
        table.column(37).visible(false);
        
        table.columns.adjust().draw();
    } else if(bck_count == 1) {
    	//1st Month
    	table.column(2).visible(true);
    	table.column(3).visible(true);
    	table.column(4).visible(true);
    	//2nd Month
    	table.column(5).visible(true);
    	table.column(6).visible(true);
    	table.column(7).visible(true);
    	//3rd Month
    	table.column(8).visible(true);
    	table.column(9).visible(true);
    	table.column(10).visible(true);
    	//4th Month
    	table.column(20).visible(false);
    	table.column(21).visible(false);
    	table.column(22).visible(false);
    	//5th Month
    	table.column(23).visible(false);
    	table.column(24).visible(false);
    	table.column(25).visible(false);
    	//6th Month
    	table.column(26).visible(false);
    	table.column(27).visible(false);
    	table.column(28).visible(false);
    	
    	table.columns.adjust().draw();
    	
        $("#btn_back").attr("disabled", true);
    }
    bck_count++; 
    $("#btn_default").removeAttr("disabled");
});

$("#btn_default").click(function() {
	//console.log("here...");
    var table = $('#tbl_child_nutri2').DataTable();
    //1st Month
    table.column(2).visible(false);
    table.column(3).visible(false);
    table.column(4).visible(false);
    //2nd Month
    table.column(5).visible(false);
    table.column(6).visible(false);
    table.column(7).visible(false);
    //3rd Month
    table.column(8).visible(false);
    table.column(9).visible(false);
    table.column(10).visible(false);
    //4th Month
    table.column(11).visible(false);
    table.column(12).visible(false);
    table.column(13).visible(false);
    //5th Month
    table.column(14).visible(false);
    table.column(15).visible(false);
    table.column(16).visible(false);
    //6th Month
    table.column(17).visible(false);
    table.column(18).visible(false);
    table.column(19).visible(false);
    //7th Month
    table.column(20).visible(true);
    table.column(21).visible(true);
    table.column(22).visible(true);
    //8th Month
    table.column(23).visible(true);
    table.column(24).visible(true);
    table.column(25).visible(true);
    //9th Month
    table.column(26).visible(true);
    table.column(27).visible(true);
    table.column(28).visible(true);
    //10th Month
    table.column(29).visible(true);
    table.column(30).visible(true);
    table.column(31).visible(true);
    //11th Month
    table.column(32).visible(true);
    table.column(33).visible(true);
    table.column(34).visible(true);
    //12th Month
    table.column(35).visible(true);
    table.column(36).visible(true);
    table.column(37).visible(true);
    
    table.columns.adjust().draw();
    
    bck_count = 0;
    $("#btn_back").removeAttr("disabled");
    $("#btn_default").attr("disabled", true);
});


/**
 * Function to show Weight for Age (WAZ) count
 * @returns
 */
function nutriCountNew(obj_response) {
	//console.log(obj_response);
	var waz_normal = 0;
	var waz_moderate = 0;
	var waz_severe = 0;
	for (var i = 0; i < obj_response.length; i++) {	
		for (var j = 0; j < obj_response[i].length; j++) {
			//For WAZ
			if(j == 35){
				var child_color = obj_response[i][j].substring(obj_response[i][j].indexOf("$")+1, obj_response[i][j].indexOf("#"));
				//console.log(child_color);
				if(child_color == 'Green') {
					waz_normal++;
				} else if(child_color == 'Yellow') {
					waz_moderate++;
				} else if(child_color == 'Red') {
					waz_severe++;
				}
			}
		}
	}
	$("#normal").text(waz_normal);
	$("#moderate").text(waz_moderate);
	$("#severe").text(waz_severe);
	$("#total").text(obj_response.length);
	hideModal();
}

/**
 * Function to show Information corner
 * @param code
 * @param name
 * @returns
 */
function childInfo(code, name){
	showModal();
	//$('#loading_bg, #loading').show();
	//console.log(code+"-"+name);
	code = code.replace(" (G/D)", ""); //# 03.11.2021
	var xmlhttp;
	if (window.XMLHttpRequest) { 
		xmlhttp=new XMLHttpRequest();
	} else { 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		//alert(xmlhttp.readyState+"---"+xmlhttp.status);
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			if (xmlhttp.responseText == "N/A") {
				alert("No information Found!!!");
				//$('#loading_bg, #loading').hide();
				hideModal();
			} else {
				document.getElementById("info").style.display = "block";
				var obj = eval ("("+ xmlhttp.responseText +")");
				
				document.getElementById("imgDiv").style.display = "block";
				document.getElementById("file_id").value = obj[0][14];
				
				$("#imageView").rotate(0);
				document.getElementById("cntr").value = 0;
				
				//console.log(obj[0][14]);
				document.getElementById("imageView").src = "../../survey.image?id=" + obj[0][14]+"&rand="+Math.random();
				//document.getElementById("imageView").src = "../../images/ghost.jpg";
				checkImgDimension();
				
				var table = "";
				table += "<table style='background-color: transparent; width: 100%; height: 240px; border-collapse: collapse; padding: 5px 0px 5px 0px;'>";
				table += "<tr><td align='center' colspan='2' style='text-decoration: underline; font-size: 8pt; color: #570000; font-weight: bold;'>Information Corner</td></tr>";
				table += "<tr><td colspan='2' style='border-bottom: 1px solid #000000;'></td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Father\'s Name :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify; text-transform: capitalize;'>"+obj[0][23]+" </td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Mother\'s Name :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify; text-transform: capitalize;'>"+obj[0][0]+" </td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Child\'s Name :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify; text-transform: capitalize;'>"+obj[0][1]+"</td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Child\'s DoB :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify; text-transform: capitalize;'>"+obj[0][24]+"</td></tr>";
				table +="<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Gender :</td><td id='gender' align='center' style='text-transform: capitalize; font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][2]+"</td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Age in Month <small>(Weight)</small> :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][3]+"</td></tr>";
				table += "<tr><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Birth weight (in kg) :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][4]+"</td></tr>";
				/*table += "<tr'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Last Visit Date :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][5]+"</td></tr>";*/
				table += "<tr'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Weight (in kg) :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][6]+"</td></tr>";
				if(obj[0][20] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
				} else if(obj[0][20] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
				} else if(obj[0][20] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
				}				
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Nutrition Status :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'></td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Underweight :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][7]+"</td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Wasting :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][8]+"</td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Stunting :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][9]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>*Min. Acceptable weight (kg) :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][10]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Creche Name :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][11]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Age in Month (Height)</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][26]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Height Date</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][15]+"</td></tr>";
				if(obj[0][19] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				} else if(obj[0][19] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				} else if(obj[0][19] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				}				
				
				if(obj[0][21] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WHZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][17]+"</td></tr>";
				} else if(obj[0][21] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WHZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][17]+"</td></tr>";
				} else if(obj[0][21] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WHZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][17]+"</td></tr>";
				}
				if(obj[0][22] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>HAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][18]+"</td></tr>";
				} else if(obj[0][22] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>HAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][18]+"</td></tr>";
				} else if(obj[0][22] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>HAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][18]+"</td></tr>";
				}
				document.getElementById("mother_cr").value=obj[0][11];
				table += "</table>";
				/*if (obj[0][14] != '-') {*/
					//table=table+"<label style='font-size: 8pt;'>*Note: Doesn't mean median; further improvement scope is there.</label>";
					table=table+"<label style='font-size: 8pt;'>*Note: Minimum weight to attain normalcy.</label>";
				/*}*/
					
				//console.log(table);
				//document.getElementById("info").innerHTML = table;
				$("#info").html(table);
				
				//popChart(1, code, name);
				
				chart_count = obj[0][13];
				if (obj[0][13] == 1) {
					showModal();
					popChart(1, code, name);
					$("#ch1").show();
					//$("#arow_right").hide();
					hideModal();
				} else {
					showModal();
					popChart(1, code, name);
					$("#ch1").show();
					popChart(2, code, name);
					$("#ch2").show();
					popChart(3, code, name);
					$("#ch3").show();
					//$("#arow_right").show();
					hideModal();
				}				
				
			}
	    }
	};
	xmlhttp.open("GET", "../../childInfo.getData?child_code="+code, true);
	xmlhttp.send();	
}


/**
 * Function to rotate Image
 */
function rotateImage() {
	//var fileId = file_Id;
	var fileId = document.getElementById("file_id").value;
	
	/*if(!fileId.contains("/")) {
		return;
	}*/
	var cntr = parseInt(document.getElementById("cntr").value);
	
	cntr = cntr + 90;
	$("#imageView").rotate(cntr);
	document.getElementById("cntr").value = cntr;
	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp=new XMLHttpRequest();
	} else {
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			if (xmlhttp.responseText == "Error") {
				//alert("Problem In Image Rotation!!!");
			}
	    }
	};
	xmlhttp.open("GET", "../../rotate.image?fileId="+fileId, true);
	xmlhttp.send();
}

function checkImgDimension() {
	//alert("test");
    $("#imageView").load(function() {
    	//alert($(this).width());
        // Calculate aspect ratio and store it in HTML data- attribute
        var aspectRatio = $(this).width()/$(this).height();
        $(this).data("aspect-ratio", aspectRatio);
        	//alert(aspectRatio);
        // Conditional statement
        if(aspectRatio > 1) {
        	//alert("land" + aspectRatio);
            // Image is landscape
            $(this).css({
                width: "164",
                height: "auto",
                position: "relative",
            	top: "40px"
            });
        } else if (aspectRatio < 1) {
        	//alert("port" + aspectRatio);
            // Image is portrait
        	//if(document.getElementById("imgDivThumb").innerHTML=="" || document.getElementById("imgDivThumb").style.display == 'none'){
        		//alert('if');
        		$(this).css({
                    width: "auto",
                	height: "164",
                	marginBottom: "0px",
                	position: "relative",
                	top: "5px"
                });
        		/*}else if(document.getElementById("imgDivThumb").innerHTML!="" || document.getElementById("imgDivThumb").style.display == 'block'){
        		//alert('else');
        		$(this).css({
                    width: "180",
                	height: "auto",
                	marginBottom: "10px",
                	position: "relative",
                	top: "0px"
                });
        	}*/
            
        } else if(aspectRatio == 1){
        	//alert("square" + aspectRatio);
            // Image is square
            $(this).css({
                width: "180",
                height: "300",
                position: "relative",
            	top: "50px"
            });            
        }
    });
}


/**
 * Function to populate Charts
 * @param mode
 * @param code
 * @param name
 * @returns
 */
function popChart(mode, code, name){
	//console.log("here in popChart..."+mode);
	$('#loading_bg, #loading').show();
	//alert("In childWeightForAge....."+mode+"-"+code+"-"+name);
	var xmlhttp;
	if (window.XMLHttpRequest) { 
		xmlhttp=new XMLHttpRequest();
	} else { 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			if (xmlhttp.responseText == "N/A") {
				//alert("Data not available.");
			} else {
				if (mode == "1") {
					//Weight for Age Chart
					document.getElementById("WFA_legend").style.display = "block";
			  		document.getElementById("wfa_head").style.display = "block";
			  		document.getElementById("wfa_large").style.display = "block";
			  		
					objWeightForAge = xmlhttp.responseText;
					try {								
						drawWeightForAgeChart(objWeightForAge,name);
					} catch(err){
						hideModal();
						alert(err.message);
					}
				} else if (mode == "2") {
					document.getElementById("WFL_legend").style.display = "block";
					document.getElementById("wfl_head").style.display = "block";
					document.getElementById("wfl_large").style.display = "block";
					objWeightForLength = xmlhttp.responseText;
					try {								
						drawWeightForLength(objWeightForLength,name);
					} catch(err){
						hideModal();
						alert(err.message);
					}
				} else if (mode == "3") {
					document.getElementById("HFA_legend").style.display = "block";
					document.getElementById("hfa_head").style.display = "block";
					document.getElementById("hfa_large").style.display = "block";
					objHeightForAge = xmlhttp.responseText;
					try {								
						drawHeightForAgeChart(objHeightForAge,name);
					} catch(err){
						hideModal();
						alert(err.message);
					}
				}
				
			}	    	 				
	    }
	};
	xmlhttp.open("GET", "../../childChart.getData?mode="+mode+"&child_code="+code, true);
	xmlhttp.send();
}


/**
 * Draw Weight for Age Chart
 * @param objWeightForAge
 * @param name
 * @returns
 */
function drawWeightForAgeChart(objWeightForAge, name){
	//console.log("here in drawWeightForAgeChart...");
	//showModal();
		
	var data = new google.visualization.DataTable();
   	data.addColumn('number', 'Age');
   	data.addColumn('number', '3SD');
   	data.addColumn('number', '2SD');
   	data.addColumn('number', '1SD');
   	data.addColumn('number', 'Normal');
   	data.addColumn('number', '-1SD');
   	data.addColumn('number', 'Moderate(<-2SD to -3SD)');
   	data.addColumn('number', 'Severe(<-3SD)');
   	data.addColumn('number', name);
   	data.addColumn({'type': 'string', 'role': 'tooltip', 'p': {'html': true}});
   	
   	var data_tmp = eval ("(" + objWeightForAge + ")")
   	data.addRows(data_tmp);
   
   	var view = null;
   	view = new google.visualization.DataView(data);
   	view.setColumns([{
   		type: 'number',
      	label: data.getColumnLabel(0),
      	calc: function () {return 0;}
    }, 1, {
    	type: 'number',
      	label: data.getColumnLabel(2),
      	calc: function () {return 0;}
    }, 3, 4, 5, {
    	type: 'number',
      	label: data.getColumnLabel(6),
      	calc: function () {return 0;}
    }, {
    	type: 'number',
      	label: data.getColumnLabel(7),
      	calc: function () {return 0;}
    }, 8]);
   	
   	var options = {
   			tooltip: {isHtml: true},
   			title: '',
   			curveType: 'function',
   			animation: {duration: 2000, easing: 'linear'},
   			vAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Weight(In Kg.)"},
   			hAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Age(In Month)"},
   			legend: {alignment: 'end', position: 'top'},
   			explorer: {actions: ['dragToZoom', 'rightClickToReset']},
   			crosshair: {trigger: 'both', color: 'black',  opacity: 0.2},
   			chartArea: {
   				left: 45,
   				top: 40,
   				width: '85%',
   				height: '60%'
   			},
   			/*trendlines: {7: {type: 'polynomial', degree: 3, visibleInLegend: false}},*/
   			series: {
   				0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
   				1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
   				4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}
   			}		
    };

	function placeMarker(dataTable) {
		var top = document.getElementById("WFA_chart_div").offsetTop + 95;
		var left = document.getElementById("WFA_chart_div").getBoundingClientRect().left;	
	
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		//alert(Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top - 3);
		//alert(Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 1))) + top - 3);
		//console.log(top)
		
		/*document.querySelector('.sd3WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top + 183 + "px";
		document.querySelector('.sd3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd2WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top + 184 + "px";
		document.querySelector('.sd2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd1WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top + 182 + "px";
		document.querySelector('.sd1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sdmWFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top + 184 + "px";
		document.querySelector('.sdmWFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-1WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top + 184 + "px";
		document.querySelector('.sd-1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-2WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top + 184 + "px";
		document.querySelector('.sd-2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-3WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top + 185 + "px";
		document.querySelector('.sd-3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";*/
		
		document.querySelector('.sd3WFA').style.top = "321px";
		document.querySelector('.sd3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd2WFA').style.top = "350px";
		document.querySelector('.sd2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd1WFA').style.top = "366px";
		document.querySelector('.sd1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sdmWFA').style.top = "383px";
		document.querySelector('.sdmWFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-1WFA').style.top = "399px";
		document.querySelector('.sd-1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-2WFA').style.top = "415px";
		document.querySelector('.sd-2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-3WFA').style.top = "434px";
		document.querySelector('.sd-3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
    };
      	
  	var chart = new google.visualization.ComboChart(document.getElementById('WFA_chart_div'));
	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
		google.visualization.events.removeListener(runOnce);
        chart.draw(data, options);
    });
    chart.draw(view, options);
    //hideModal();
}


/**
 * Draw Weight for Length Chart
 * @param objWeightForLength
 * @param name
 * @returns
 */
function drawWeightForLength(objWeightForLength,name){	
	//console.log("here in drawWeightForLength...");
	//showModal();
	
	var data = new google.visualization.DataTable();
   	data.addColumn('number', 'Age');
   	data.addColumn('number', '3SD');
   	data.addColumn('number', '2SD');
   	data.addColumn('number', '1SD');
   	data.addColumn('number', 'Normal');
   	data.addColumn('number', '-1SD');
   	data.addColumn('number', 'Moderate(<-2SD to -3SD)');
   	data.addColumn('number', 'Severe(<-3SD)');
   	data.addColumn('number', name);
   	data.addColumn({'type': 'string', 'role': 'tooltip', 'p': {'html': true}});
   	
   	var data_tmp = eval ("(" + objWeightForLength + ")")
   	data.addRows(data_tmp);
   
   	var view = null;
   	view = new google.visualization.DataView(data);
   	view.setColumns([{
   		type: 'number',
      	label: data.getColumnLabel(0),
      	calc: function () {return 0;}
    }, 1, {
    	type: 'number',
      	label: data.getColumnLabel(2),
      	calc: function () {return 0;}
    }, 3, 4, 5, {
    	type: 'number',
      	label: data.getColumnLabel(6),
      	calc: function () {return 0;}
    }, {
    	type: 'number',
      	label: data.getColumnLabel(7),
      	calc: function () {return 0;}
    }, 8]);
   	
   	var options = {
   			tooltip: {isHtml: true},
   			title: 'Weight for Length / Height',
   			curveType: 'function',
   			animation: {duration: 2000, easing: 'linear'},
   			vAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Weight(In Kg.)"},
   			hAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Height / Length (In Cm.)"},
   			legend: {alignment: 'end', position: 'top'},
   			explorer: {actions: ['dragToZoom', 'rightClickToReset']},
   			crosshair: {trigger: 'both', color: 'black',  opacity: 0.2},
   			chartArea: {
   				left: 45,
   				top: 40,
   				width: '85%',
   				height: '60%'
   			},
   			/*trendlines: {7: {type: 'polynomial', degree: 3, visibleInLegend: false}},*/
   			series: {
   				0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
   				1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
   				4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}
   			}		
    };

	function placeMarker(dataTable) {
		var top = document.getElementById("WFL_chart_div").offsetTop + 95;
		var left = document.getElementById("WFL_chart_div").getBoundingClientRect().left;
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		/*document.querySelector('.sd3WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top + 185 + "px";
		document.querySelector('.sd3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sd2WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top + 185 + "px";
		document.querySelector('.sd2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sd1WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top + 185 + "px";
		document.querySelector('.sd1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sdmWFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top + 190 + "px";
		document.querySelector('.sdmWFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sd-1WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top + 187 + "px";
		document.querySelector('.sd-1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sd-2WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top + 187 + "px";
		document.querySelector('.sd-2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";
		document.querySelector('.sd-3WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top + 187 + "px";
		document.querySelector('.sd-3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 3 + "px";*/
		
		document.querySelector('.sd3WFL').style.top = "327px";
		document.querySelector('.sd3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd2WFL').style.top = "346px";
		document.querySelector('.sd2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd1WFL').style.top = "358px";
		document.querySelector('.sd1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sdmWFL').style.top = "371px";
		document.querySelector('.sdmWFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-1WFL').style.top = "383px";
		document.querySelector('.sd-1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-2WFL').style.top = "397px";
		document.querySelector('.sd-2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-3WFL').style.top = "412px";
		document.querySelector('.sd-3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
	};
      	
  	var chart = new google.visualization.ComboChart(document.getElementById('WFL_chart_div'));
	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
		google.visualization.events.removeListener(runOnce);
        chart.draw(data, options);
    });
    chart.draw(view, options);
    //hideModal();
}


/**
 * Draw Height for Age Chart
 * @param objHeightForAge
 * @param name
 * @returns
 */
function drawHeightForAgeChart(objHeightForAge,name){	
	console.log("here in drawHeightForAgeChart...");
	//showModal();
	
	var data = new google.visualization.DataTable();
   	data.addColumn('number', 'Age');
   	data.addColumn('number', '3SD');
   	data.addColumn('number', '2SD');
   	data.addColumn('number', '1SD');
   	data.addColumn('number', 'Normal');
   	data.addColumn('number', '-1SD');
   	data.addColumn('number', 'Moderate(<-2SD to -3SD)');
   	data.addColumn('number', 'Severe(<-3SD)');
   	data.addColumn('number', name);
   	data.addColumn({'type': 'string', 'role': 'tooltip', 'p': {'html': true}});
   	
   	var data_tmp = eval ("(" + objHeightForAge + ")")
   	data.addRows(data_tmp);
   
   	var view = null;
   	view = new google.visualization.DataView(data);
   	view.setColumns([{
   		type: 'number',
      	label: data.getColumnLabel(0),
      	calc: function () {return 0;}
    }, 1, {
    	type: 'number',
      	label: data.getColumnLabel(2),
      	calc: function () {return 0;}
    }, 3, 4, 5, {
    	type: 'number',
      	label: data.getColumnLabel(6),
      	calc: function () {return 0;}
    }, {
    	type: 'number',
      	label: data.getColumnLabel(7),
      	calc: function () {return 0;}
    }, 8]);
   	
   	var options = {
   			tooltip: {isHtml: true},
   			title: 'Length / Height for Age',
   			curveType: 'function',
   			animation: {duration: 2000, easing: 'linear'},
   			vAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Length / Height (In Cm.)"},
   			hAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Age(In Month)"},
   			legend: {alignment: 'end', position: 'top'},
   			explorer: {actions: ['dragToZoom', 'rightClickToReset']},
   			crosshair: {trigger: 'both', color: 'black',  opacity: 0.2},
   			chartArea: {
   				left: 45,
   				top: 40,
   				width: '85%',
   				height: '60%'
   			},
   			/*trendlines: {7: {type: 'polynomial', degree: 3, visibleInLegend: false}},*/
   			series: {
   				0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
   				1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
   				4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
   				5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
   				7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}
   			}		
    };

	function placeMarker(dataTable) {
		var top = document.getElementById("HFA_chart_div").offsetTop + 95;
		var left = document.getElementById("HFA_chart_div").getBoundingClientRect().left;
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		/*document.querySelector('.sd3HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top + 172 + "px";
		document.querySelector('.sd3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd2HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top + 172 + "px";
		document.querySelector('.sd2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd1HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top + 172 + "px";
		document.querySelector('.sd1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sdmHFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top + 172 + "px";
		document.querySelector('.sdmHFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-1HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top + 172 + "px";
		document.querySelector('.sd-1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-2HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top + 172 + "px";
		document.querySelector('.sd-2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-3HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top + 172 + "px";
		document.querySelector('.sd-3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";*/
		
		document.querySelector('.sd3HFA').style.top = "332px";
		document.querySelector('.sd3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd2HFA').style.top = "343px";
		document.querySelector('.sd2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd1HFA').style.top = "351px";
		document.querySelector('.sd1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sdmHFA').style.top = "361px";
		document.querySelector('.sdmHFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-1HFA').style.top = "371px";
		document.querySelector('.sd-1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-2HFA').style.top = "384px";
		document.querySelector('.sd-2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
		document.querySelector('.sd-3HFA').style.top = "399px";
		document.querySelector('.sd-3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 3 + "px";
	};
      	
  	var chart = new google.visualization.ComboChart(document.getElementById('HFA_chart_div'));
	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
		google.visualization.events.removeListener(runOnce);
        chart.draw(data, options);
    });
    chart.draw(view, options);
    //hideModal();
}


/**
 * Function to enlarge chart
 * @param mode
 * @param file_id
 * @param gender
 * @returns
 */
function enlarge_chart(mode,file_id,gender){
	var child_code = document.getElementById("child_code").value;
	var child_name = document.getElementById("child_name").value;
	var mode_value = null;
	if (mode == '1') {
		mode_value = "WFA";
	} else if (mode == '2') {
		mode_value = "WFL";
	} else if (mode == '3') {
		mode_value = "HFA";		
	}
	window.open("enlargeChart.jsp?mode="+mode+"&mode_value="+mode_value+"&child_code="+child_code +"&child_name="+child_name+"&gender="+gender+"&file_id="+file_id,"_blank","top=10, left=10, width=800, height=530");
}