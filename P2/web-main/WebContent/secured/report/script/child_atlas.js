var objNutriTable = null;
var objWeightForAge = null;
var objHeightForAge = null;
var objWeightForLength = null;
var table = null;
var jatakIdData = null;
var chart_count = 1;

var jsonDtBkCrData = {};

var objStDtBkCr;


$(document).ready(function(){
	//showModal();
	//hideModal();
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
		popCombo('CR');
	} else if(level == 'CR') {
		$('#sel_cr').html('');
		//$('#sel_cr').append('<option value="select">Select Creche</option>');
		var arr_cr = GetUniqueCR();
		for (var i = 0; i < arr_cr.length; i++) {
			var data = arr_cr[i].split("^");
			$('#sel_cr').append('<option value="'+data[0]+'">'+data[1]+'</option>');
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
function GetUniqueCR() {
	var inputArray = objStDtBkCr;
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
 * Function to populate District/Block/Creche Combo
 * @param level
 * @returns
 */
/*function popCombo_old(level) {	
	//alert("here in popCombo..."+level);
	if(level == 'DT') {
		//showModal();
		$('#sel_dt').html('');
		$.each(jsonDtBkCrData, function(key, value) {
			$('#sel_dt').append('<option value='+jsonDtBkCrData[key]['dt_code']+'>'+jsonDtBkCrData[key]['dt_name']+'</option>');
//			if (role_hidden == 'district_user') {
//				if(map_id_hidden == jsonDtBkCrData[key]['dt_code']) {
//					$('#sel_dt_imei').append('<option value='+jsonDtBkCrData[key]['dt_code']+'>'+jsonDtBkCrData[key]['dt_name']+'</option>');
//					return false;
//				}				
//			} else {
//				$('#sel_dt_imei').append('<option value='+jsonDtBkCrData[key]['dt_code']+'>'+jsonDtBkCrData[key]['dt_name']+'</option>');
//			}
		});//End foreach loop for total dataset
		$("#sel_dt").prop('selectedIndex',0);
		popCombo('BK');
		//return false;
	} else if(level == 'BK') {
		//showModal();
		$.each(jsonDtBkCrData, function(key, value) {
			//console.log(value);
			var dt_code = $('#sel_dt option:selected').val();
			$.each(value, function(dt_key, dt_value) {				
				//console.log(dt_code+"---"+jsonData[key]['dt_code']);
				if(dt_code == jsonDtBkCrData[key]['dt_code']) {
					if(dt_key == 'bk_details') {						
						//console.log("here BK matched*****************...");
						$('#sel_bk').html('');
						$.each(dt_value, function(bk_key, bk_value) {
							//console.log(bk_key, bk_value);
							$('#sel_bk').append('<option value='+bk_value['bk_code']+'>'+bk_value['bk_name']+'</option>');
						});//End foreach loop for Block dataset	
						$("#sel_bk").prop('selectedIndex',0);
						popCombo('CR');
						return false;
					}//End of Block details checking
				}//End of DT code checking									
			});//End foreach loop for District dataset
		});//End foreach loop for total dataset			
	} else if(level == 'CR') {
		//showModal();		
		$.each(jsonDtBkCrData, function(key, value) {
			//console.log(value);
			var dt_code = $('#sel_dt option:selected').val();
			$.each(value, function(dt_key, dt_value) {				
				//console.log(dt_code+"---"+jsonData[key]['dt_code']);
				if(dt_code == jsonDtBkCrData[key]['dt_code']) {
					if(dt_key == 'bk_details') {						
						var bk_code = $('#sel_bk option:selected').val();
						//console.log(bk_code);
						$.each(dt_value, function(bk_key, bk_value) {
							//console.log(bk_key, bk_value);
							if(bk_code == bk_value['bk_code']) {
								//console.log(bk_key, bk_value);
								$('#sel_cr').html('');
								$.each(bk_value['cr_details'], function(cr_key, cr_value) {
									//console.log(cr_key, cr_value);
									$('#sel_cr').append('<option value='+cr_value['cr_code']+'>'+cr_value['cr_name']+'</option>');
								});//End foreach loop for Creche dataset
								$("#sel_cr_imei").prop('selectedIndex',0);								
								//hideModal();
								//return false;
								prepareNutriData();
							}//End of BK code checking	
						});//End foreach loop for Block dataset					
					}//End of Block details checking
				}//End of DT code checking									
			});//End foreach loop for District dataset
		});//End foreach loop for total dataset
	}
}*/


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
				//$("normal").html("0");
				//$("moderate").html("0");
				//$("severe").html("0");
				//$("over").html("0");
				//$("total").html("0");
				hideModal();
				return;
			} else {
				//nutriCount(lvl,code);
				
				//document.getElementById("tble_header_div").style.display = "block";
				//document.getElementById("childStats").style.display = "table";
				
				var obj_response  = eval ("("+ response +")");
				//console.log(obj_response);
				
				var tableData = '';
				tableData += '<table id="tbl_child_nutri" border=1 class="display zui-table tbl_child_atlas" cellspacing="0" width="100%">';
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
				
				$('#nutri').html(tableData);
				
				var table = $('#tbl_child_nutri').DataTable( {
					"scrollY": "200px",
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
			            { "width": "22px", "targets": 1 },
			            { "width": "3px", "targets": [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37] },
			        ], 
			        //fixedColumns: true
			    });
				table.columns.adjust().draw();
				$("#div_back").show();
				$("#div_default").show();
				
				//Row Click event
				$("#tbl_child_nutri tbody tr").on('click',function(event) {
					$("#tbl_child_nutri tbody tr").removeClass('row_selected');		
					$(this).addClass('row_selected');
					var data = table.row( this ).data();
					var childCode = data[0];
					var childName = data[1];					
					//console.log(childCode+"..."+childName);					
						
					document.getElementById("child_code").value = childCode;
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
			  		document.getElementById("WFL_chart_div").innerHTML = "";
			  		
			  		childInfo(childCode, childName);
				});
				hideModal();
			}
		},
		error: function(xhr) {
			alert("Data not available.");
			hideModal();
			return;
		}
	});
}


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
    var table = $('#tbl_child_nutri').DataTable();
    
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
    var table = $('#tbl_child_nutri').DataTable();
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
 * Function to prepare Nutrition Data
 * @returns
 */
function prepareNutriData() {
	//console.log("here in prepareNutriData...");
	//$('#loading_bg, #loading').show();
	showModal();

	document.getElementById("ch1").style.display = "none";
	document.getElementById("ch2").style.display = "none";
	document.getElementById("ch3").style.display = "none";
	
	jatakIdData = null;
	var lvl = "";
	var code = "";
	//var awc_Code = document.getElementById('awc').value;
	//var sec_code = document.getElementById('sector').value;
	/*if (awc_Code == "Select") {
		alert("Please select AWC.");
		return;
	}*/
	
	/*if (awc_Code == "s") { //when awc is select "All"
		lvl = "s";
		code = sec_code;
	} else {
		lvl = "i";
		code = awc_Code;
	}*/
	
	lvl = "c";
	code = $("#sel_cr option:selected" ).val();
	
	document.getElementById("nutri").innerHTML = "";
	document.getElementById("imgDiv").style.display = "none";
	document.getElementById("info").innerHTML = "";
	document.getElementById("tble_header_div").style.display = "none";
	
	document.getElementById("WFA_legend").style.display = "none";
	document.getElementById("wfa_head").style.display = "none";
	document.getElementById("wfa_large").style.display = "none";
	//document.getElementById("WFL_legend").style.display = "none";
	//document.getElementById("HFA_legend").style.display = "none";
	
	//document.getElementById("WFA_chart_div").innerHTML = "";
	//document.getElementById("HFA_chart_div").innerHTML = "";
	//document.getElementById("WFL_chart_div").innerHTML = "";
	
	var xmlhttp;
	if (window.XMLHttpRequest) { 
		xmlhttp=new XMLHttpRequest();
	} else { 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			if (xmlhttp.responseText == "N/A") {
				document.getElementById("normal").innerHTML = "0";
				document.getElementById("moderate").innerHTML = "0";
				document.getElementById("severe").innerHTML = "0";
				//document.getElementById("over").innerHTML = "0";
				document.getElementById("total").innerHTML = "Total : 0";
				alert("Data not available.");
				//$('#loading_bg, #loading').hide();
				hideModal();				
			} else {
				nutriCount(lvl,code);
				//document.getElementById("nutri").style.display = "block";
				document.getElementById("tble_header_div").style.display = "block";
				document.getElementById("childStats").style.display = "table";
				objNutriTable = xmlhttp.responseText;
				//console.log(objNutriTable);
				var chartData = objNutriTable.substring(0, objNutriTable.lastIndexOf("~"));
				jatakIdData = eval ("(" + objNutriTable.substring(objNutriTable.lastIndexOf("~")+1, objNutriTable.length) + ")");
				try {								
					drawTableChart(chartData);
					//$('#loading_bg, #loading').hide();
				} catch(err){
					alert(err.message);
				}
			}	    	 				
	    }
	};
	xmlhttp.open("GET", "../../nutri.getData?lvl="+lvl+"&code="+code, true);
	xmlhttp.send();
	
}

function drawTableChart(objNutriTable){
	//console.log(objNutriTable);	
	var data = new google.visualization.DataTable();
      
   	data.addColumn('string', 'Child ID');
   	data.addColumn('number', 'Child&#39;s Name');
   	data.addColumn('date', 'Last visit DT.');
   	data.addColumn('number', '<a title=\'Underweight Status\' style="color:black;">U</a>');
   	data.addColumn('number', '<a title=\'Wasting Status\'  style="color:black;">W</a>');
   	data.addColumn('number', '<a title=\'Stunting Status\'  style="color:black;">S</a>');
   	//data.addColumn('number', 'L/H for Age');
   	//data.addColumn('number', 'Wt for L/H');
   	
   	var data_tmp = eval ("(" + objNutriTable + ")");
   	
   	//reformatting dates inside the json array
   	for(var j=0; j< data_tmp.length;j++) {
   		var dateNow = data_tmp[j][2];
   		var dateSplitted = dateNow.toString().split("/");
   		data_tmp[j][2] = new Date(dateSplitted[0],dateSplitted[2]-1,dateSplitted[1]);
   	}
   	
   	data.addRows(data_tmp);
   	var className = {tableRow:'tableClass',alternatingRowStyle:true,oddTableRow:'oddTableClass',selectedTableRow:'selectedTableClass'};
   	//var dateFormatter = new google.visualization.DateFormat({formatType: 'medium'});
   	var dateFormatter = new google.visualization.DateFormat({pattern: "dd/MM/yyyy"});
   	dateFormatter.format(data,2);
   	   	
    table = new google.visualization.Table(document.getElementById('nutri'));
    
    var iconFormatter = function() {
        //do nothing
    }    
    
    iconFormatter.prototype.format = function(dt, column) {
    	for (var i = 0; i < dt.getNumberOfRows(); i++) {
    		var formattedValue = dt.getValue(i, column);
    		if(formattedValue == "5") {
    			dt.setFormattedValue(i, column, "<img src='../../images/uws.png' alt='UWS'>");
    		}
    	}
    }
 
    var iFormatter = new iconFormatter();
    iFormatter.format(data, 3);
    iFormatter.format(data, 4);
    iFormatter.format(data, 5);
    
    var formatter = new google.visualization.ColorFormat();
	//formatter.addRange(0, 1, 'black', '#7AC68F');//Normal
    formatter.addRange(3, 4, 'black', '#34DC8C');//Normal
	//formatter.addRange(1, 2, 'black', '#E5E288');//Moderate
	formatter.addRange(2, 3, 'black', '#F2FE67');//Moderate
 	//formatter.addRange(2, 3, 'black', '#FFA89D');//Severe
	formatter.addRange(1, 2, 'black', '#FF4646');//Severe
	formatter.addRange(4, 5, 'black', '#6a9da9');//Overweight/Obese/Tall
	//formatter.addRange(5, 6, 'black', '#FFFFFF');//Dead Child

	formatter.format(data, 1); // Apply formatter to 2 column
 	//formatter.format(data, 3); // Apply formatter to 2 column
	//formatter.format(data, 4); // Apply formatter to 3 column
	//formatter.format(data, 5); // Apply formatter to 4 column

	function setWidth () {
		$('.google-visualization-table-th:contains(Child ID)').css('width', '15%');
		$('.google-visualization-table-th:contains(Child ID)').css('text-align', 'center');
        $('.google-visualization-table-th:contains(Child&#39;s Name)').css('width', '30%');      
        $('.google-visualization-table-th:contains(Child\'s Name)').css('text-align', 'center');
        $('.google-visualization-table-th:contains(Last visit DT.)').css('width', '20%');
        $('.google-visualization-table-th:contains(Last visit DT.)').css('text-align', 'center');
		$('.google-visualization-table-th:contains(U)').css('width', '15%');
		$('.google-visualization-table-th:contains(U)').css('text-align', 'center');
		$('.google-visualization-table-th:contains(W)').css('width', '15%');
		$('.google-visualization-table-th:contains(W)').css('text-align', 'center');
		$('.google-visualization-table-th:contains(S)').css('width', '15%');
		$('.google-visualization-table-th:contains(S)').css('text-align', 'center');
		//$('.google-visualization-table-th:contains(Stunt -ing)').css('width', '12%');   
		//$('.google-visualization-table-th:contains(Wast -ing)').css('width', '11%');   
    }
	
    google.visualization.events.addListener(table, 'ready', setWidth);
    google.visualization.events.addListener(table, 'sort', setWidth);
    table.draw(data, {allowHtml: true, showRowNumber: false, cssClassNames:className});
	google.visualization.events.addListener(table, 'select', selectHandler);

	function selectHandler() {		
		var childCode = data.getValue(table.getSelection()[0].row, 0);
  		for (var int = 0; int < jatakIdData.length; int++) {
			if (jatakIdData[int][1] == childCode) {
				childCode = jatakIdData[int][0];
				break;
			}
		}
  		
  		//var childName = data.getValue(table.getSelection()[0].row, 1);
  		var childName = data.getFormattedValue(table.getSelection()[0].row, 1);
  		document.getElementById("child_code").value = childCode;
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
  		document.getElementById("WFL_chart_div").innerHTML = "";
  		
  		childInfo(childCode, childName);  		
  		//childWeightForAge('1',childCode, childName);  		
  		//childWeightForAge('2',childCode, childName);  		
  		//childWeightForAge('3',childCode, childName);
	}
}

function nutriCount(lvl,code){
	//console.log("here in nutriCount...");
	$('#loading_bg, #loading').show();
	
	//document.getElementById("normal").innerHTML = "0";
	//document.getElementById("moderate").innerHTML = "0";
	//document.getElementById("severe").innerHTML = "0";
	//document.getElementById("over").innerHTML = "0";
	//document.getElementById("total").innerHTML = "Total : 0";
      
	var xmlhttp;
	if (window.XMLHttpRequest) { 
		xmlhttp=new XMLHttpRequest();
	} else { 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			if (xmlhttp.responseText == "N/A") {
				alert("Data not found.");
				//$('#loading_bg, #loading').hide();
				hideModal();
			} else {
				var obj = eval ("("+ xmlhttp.responseText +")");
				document.getElementById("normal").innerHTML = obj[0][0];
				document.getElementById("moderate").innerHTML = obj[0][1];
				document.getElementById("severe").innerHTML = obj[0][2];
				//document.getElementById("over").innerHTML = obj[0][3];
				document.getElementById("total").innerHTML = "Total : "+obj[0][3];
				//$('#loading_bg, #loading').hide();
				hideModal();
			}
	    }
	};
	xmlhttp.open("GET", "../../nutri.count?lvl="+lvl+"&code="+code, true);
	xmlhttp.send();
}

function childInfo(code, name){
	showModal();
	//$('#loading_bg, #loading').show();
	//alert(code+"-"+name);
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
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Nutrition Status :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'></td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Underweight :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][7]+"</td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Wasting :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][8]+"</td></tr>";
				//table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;background:#f1d7e4;'>Stunting :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;background:#f1d7e4;'>"+obj[0][9]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Min. Acceptable weight (kg) :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][10]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Creche Name :</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][11]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Age in Months (Height)</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][26]+"</td></tr>";
				table += "<tr class='info_row_1'><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>Height Date</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][15]+"</td></tr>";
				if(obj[0][19] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				} else if(obj[0][19] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				} else if(obj[0][19] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>MUAC</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][12]+"</td></tr>";
				}				
				if(obj[0][20] == "Red") {
					table += "<tr bgcolor=#FF4646><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
				} else if(obj[0][20] == "Green") {
					table += "<tr bgcolor=#34DC8C><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
				} else if(obj[0][20] == "Yellow") {
					table += "<tr bgcolor=#F2FE67><td align='left' style='font-size: 8pt; font-weight: bold; color: #333333; padding-left: 5px;'>WAZ Status</td><td align='center' style='font-size: 8pt; color: #333333; text-align: justify;'>"+obj[0][16]+"</td></tr>";
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
					table=table+"<label style='font-size: 8pt;'>*Note: Doesn't mean median; further improvement scope is there.</label>";
				/*}*/
				
					
					
					
				//console.log(table);
				document.getElementById("info").innerHTML = table;
				
				popChart(1, code, name);	
				chart_count = obj[0][13];
				if (obj[0][13] == 1) {
					$('#loading_bg, #loading').show();
					//popChart(1, code, name);
					$("#ch1").show();
					$("#arow_right").hide();
					$('#loading_bg, #loading').hide();
				} else {
					$('#loading_bg, #loading').show();
					//popChart(1, code, name);
					//popChart(2, code, name);
					//popChart(3, code, name);
					$("#ch1").show();
					$("#arow_right").show();
					$('#loading_bg, #loading').hide();
				}
				
				$("#arow_right").click(function(){
					document.getElementById("WFL_chart_div").innerHTML = "";
					popChart(2, code, name);	
					//alert("ssdsd");
					$("#ch1").hide();
					$("#ch2").show();
					})
				$("#arow_right_2").click(function(){
					document.getElementById("HFA_chart_div").innerHTML = "";
					popChart(3, code, name);	
					//alert("ssdsd");
					$("#ch2").hide();
					$("#ch3").show();
					})
				$("#arow_left_2").click(function(){
					document.getElementById("WFA_chart_div").innerHTML = "";
					popChart(1, code, name);	
					//alert("ssdsd");
					$("#ch2").hide();
					$("#ch1").show();
					})

				$("#arow_left_3").click(function(){
					document.getElementById("WFL_chart_div").innerHTML = "";
					popChart(2, code, name);	
					//alert("ssdsd");
					$("#ch3").hide();
					$("#ch2").show();
					})
				//childWeightForAge(obj[0][13], code, name);				
			}
			
	    }
	};
	xmlhttp.open("GET", "../../childInfo.getData?child_code="+code, true);
	xmlhttp.send();	
}


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
						//$('#loading_bg, #loading').hide();
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


function drawWeightForAgeChart(objWeightForAge,name){
	//$('#loading_bg, #loading').show();
	showModal();
	//alert(objWeightForAge+"---"+name);
	
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
		series: {0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
			1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
			4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}}
		
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
    //$('#loading_bg, #loading').hide();
    hideModal();
}


function drawWeightForLength(objWeightForLength,name){	
	$('#loading_bg, #loading').show();
	
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
		series: {0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
			1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
			4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}}
		
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
        
        //$('#loading_bg, #loading').hide();	
        hideModal();
}


function drawHeightForAgeChart(objHeightForAge,name){	
	//$('#loading_bg, #loading').show();
	showModal();
	
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
		series: {0:{color: 'red', visibleInLegend: false, type: "line", enableInteractivity: false},
			1:{color: '#9ebd46', visibleInLegend: false, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			2:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			3:{color: '#8aa245', visibleInLegend: true, type: "line", enableInteractivity: false},
			4:{color: '#e4cc60', visibleInLegend: false, type: "line", enableInteractivity: false},
			5:{color: '#f3df80', visibleInLegend: true, lineWidth: 1, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			6:{color: '#ec7d48', visibleInLegend: true, lineWidth: 0, type: "area", enableInteractivity: false, areaOpacity: 1.0},
			7:{color: 'blue', visibleInLegend: false, type: "line", lineWidth: 0, pointSize: 5}}
		
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
        
        //$('#loading_bg, #loading').hide();
        hideModal();
}


function refresh(){
	var code = document.getElementById("child_code").value;
	var name = document.getElementById("child_name").value;
	table.setSelection();
	
	document.getElementById("imgDiv").style.display = "none";
	document.getElementById("info").innerHTML = "";
	
	document.getElementById("WFA_legend").style.display = "none";
	document.getElementById("WFL_legend").style.display = "none";
	document.getElementById("wfa_head").style.display = "none";
	document.getElementById("wfa_large").style.display = "none";
	document.getElementById("HFA_legend").style.display = "none";
	
	document.getElementById("WFA_chart_div").innerHTML = "";
	document.getElementById("WFL_chart_div").innerHTML = "";
	document.getElementById("HFA_chart_div").innerHTML = "";
	
	prepareNutriData()
}

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

function gen_report(){
	var child_code = document.getElementById("child_code").value;
	var child_name = document.getElementById("child_name").value;
	//alert(child_code);
	if (child_code == ""||document.getElementById("info").innerHTML == "") {
		alert("Please select a child.");
		return;
	}
	
	window.open("report_child.jsp?child_code="+child_code+"&child_name="+child_name+"&modeCount="+chart_count,"_blank");
}

function genCohotReport() {
	var sec_name = "";
	var aw_name = "";
	var child_code = "";
	
	sec_name = document.getElementById('sector').options[document.getElementById('sector').selectedIndex].text;
	aw_name = document.getElementById('mother_awc').value;
	child_code = document.getElementById("child_code").value;
	
	if (child_code == ""||document.getElementById("info").innerHTML == "") {
		
		alert("Please select a child.");
		return;
	}
	
	var submitForm = document.createElement("FORM");
	document.body.appendChild(submitForm);
	submitForm.method = "POST";
	//alert(sec_name + "   "+ aw_name + "   "+child_code);
	
	createNewFormElement(submitForm, "sec_name", sec_name);
	createNewFormElement(submitForm, "aw_name", aw_name);
	createNewFormElement(submitForm, "child_code", child_code);
	
	submitForm.action= "../cohort.report";
	
	submitForm.submit();
}


function createNewFormElement(inputForm, elementName, elementValue){
	var input = document.createElement("input");
	input.type = "hidden";
	input.id = elementName;
	input.name = elementName;
	input.value = elementValue;
	inputForm.appendChild(input);
}

/**
 * Function to rotate Image
 */
function rotateImage() {
	//var fileId = file_Id;
	var fileId = document.getElementById("file_id").value;
	
	if(!fileId.contains("/")) {
		return;
	}
	var cntr = parseInt(document.getElementById("cntr").value);
	
	cntr = cntr + 90;
	$("#imageView").rotate(cntr);
	document.getElementById("cntr").value = cntr;
	
	
	
	/*var width= document.getElementById("imageView").width;
	var height= document.getElementById("imageView").height;
	alert(width);
	alert(height);
	if(height>width){
		alert(height+"..........."+ width);
		document.getElementById("imageView").style.height="164px";
		document.getElementById("imageView").style.width="auto";
		
	} else if(height<width){
		alert(height+"....."+123 +"......"+ width);
		document.getElementById("imageView").style.height="164px";
		document.getElementById("imageView").style.width="auto";
	}*/
	
	
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
