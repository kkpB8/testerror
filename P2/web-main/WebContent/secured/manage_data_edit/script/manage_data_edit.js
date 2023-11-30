//# New Data Edit File 05082020

var GLOBAL_data;
var GLOBAL_LOGIN_USER_ID, GLOBAL_MAP_ID;
var G_BACK_TBL=1, G_BACK_YEAR=1111, G_BACK_FORM=0, G_BACK_MNTH=0; 

$(document).ready(function() {	
	GLOBAL_LOGIN_USER_ID = $("#hdUserId").val();
	GLOBAL_MAP_ID = $("#hdMapId").val();
	
	GetEditRequestPendingSummary($('#sel_yr').val());
	
});


/**
 * # To Get Summary For Pending Edit Request
 * @param year
 * @returns
 */

function GetEditRequestPendingSummary(year) {
	$('#div_data').html('');
	showModal();
	$.ajax({
		  url: "../../pop.EditApprovePendSummryAll",
		  type: "get",
		  data: {
			  sel_yr: year,
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  	bootbox.alert("Unable to get data.");
					hideModal();
					return;
				} else {
					var obj_response  = eval ("("+ response +")");
					var aStrFormId=[]; //# Form Id Store
					var aStrMonthId=[]; //# Month Id Store
					
					//# Header Part Start ######################################################
					var tableData = "<table id='tblEditApprove' border='1' >";
					tableData += "<thead><tr id=''>";
					tableData += "<th>Month/Forms</th>";
					//# Loop every Column except 1st
					for (var C = 1; C < obj_response[0].length; C++) {
						var a = obj_response[0][C].split("^")
						aStrFormId[C-1]=a[0];
						tableData += "<th>" + a[1] + "</th>";
				    }
					//console.log(obj_response);
					//tableData += "<th>Total</th>";
					tableData += "</tr></thead>";

					//# End Header Part ###############################################################
					
					//# Start Data Part
					tableData += "<tbody>";
					//# Loop Every Row except 1st for Heading
					for ( var R = 1; R < obj_response.length; R++) {
						//# New Row
						tableData += "<tr id= ''>";	
						var RwTot=0;
						//# Loop column
						for ( var C = 0; C < obj_response[0].length-1; C++) {
							if(obj_response[R][C]=="N/A"){
								tableData += "<td></td>";
							}else{
									//# Month Column
									if(C==0){
										var a = obj_response[R][C].split("^")
										aStrMonthId[R-1]=a[0];
										tableData += "<td>" + a[1] + "</td>";
									}
									
									
									if(C>0){
										//# Calculate Row Total
										RwTot += parseInt(obj_response[R][C]);
										//# Value with LINK
										tableData += "<td><b><a title='Click for detail information'  href='#' onclick='FetchLinkData(\""
																			+aStrFormId[C-1]+"\",\""+aStrMonthId[R-1]+"\",\""+year
																			+"\");'>" + obj_response[R][C] 
																			+ "</a></b></td>";
									}
								}
						} //# End Loop Column
						
						//# Row Total (Last Total Column)
						tableData += "<td><b><a title='Click for detail information'  href='#' onclick='FetchLinkData(\""
																			+aStrFormId.length+"\",\""+aStrMonthId[R-1]+"\",\""+year
																			+"\");'>"+(RwTot=="0"?"":RwTot)+"</a></b></td>";
						tableData += "</tr>";
					} //# End Row
					
					
					//# Append One More ROW For Total Column  ############################
					tableData += "<tr id= ''>";
					for ( var C = 0; C < obj_response[0].length-1; C++) {
						if(C==0){
							tableData += "<td>Total</td>";
						}else{
							
							var ColTot=0;
							for ( var R = 1; R < obj_response.length; R++) {
								if(obj_response[R][C] != "N/A"){
									ColTot += parseInt(obj_response[R][C]);
								}
							}
							
							//tableData += "<td><b><a title='Click for detail information'  href='#'>Coming Soon</a></b></td>";
							tableData += "<td><b><a title='Click for detail information'  href='#' onclick='FetchLinkData(\""
																	+aStrFormId[C-1]+"\",\"\",\""+year
																	+"\");'>"+(ColTot=="0"?"":ColTot)+"</a></b></td>";
						}
					}
					//tableData += "<td bgcolor='red'></td>";
					tableData += "</tr>";					
					//# Append One More ROW For Total Column  ############################	
					
					
					tableData += "</tbody>";
					tableData += "</table>"

					$('#div_data').append(tableData);
					
					hideModal();
				}
		  },
		  error: function(xhr) {
			  bootbox.alert("Unable to get data.");
			  hideModal();
			  return;
		  }
	});	
	
} //# End GetEditRequestPendingSummary

//# Year change
$('#sel_yr').on("change", function(e) {
	GetEditRequestPendingSummary($('#sel_yr').val());	
});


//# Fetch Link CLick Data
function FetchLinkData(formid, mnthid, yr) {
	//# For BAck Button
	$('#aLnkBack').show();
	G_BACK_TBL = 2; //# For Table 2 display
	G_BACK_YEAR = yr;
	G_BACK_FORM = formid
	G_BACK_MNTH = mnthid;
	
	
	var table;
	//console.log ("Form:"+formid + ", Month: " + mnthid + ", Year: " + yr);
	//# Div clear 
	$('#div_data').html('');
	$('#divYr').hide();
	showModal();
	
	var tableData = "<table id='tblApproveDetail' border='1' ></table>";
	$('#div_data').append(tableData);
	
	
	//if table exists destroy it
	if ($.fn.dataTable.isDataTable('#tblApproveDetail')) {
	   table = $('#tblApproveDetail').DataTable().clear();
	   table.destroy();
	}
	
	
	//# Create DataTable	
    $('#tblApproveDetail').DataTable({
	    'ajax':  '../../pop.EditApprovePendingDetail?formid=' //# Data Fetch
	    + formid+'&mnthid='+ mnthid+'&year='+ yr,
	    searching: true,
	    scrollY:   "50vh",
	    columns:
	    	[
	    		//#  Hidden Column
	    		{ title: "hideMnthYr" ,"visible": false, "searchable": false},
	    		{ title: "hideFrmId" ,"visible": false, "searchable": false},
	    		{ title: "hideRecUpdDt" ,"visible": false, "searchable": false},
	    		{ title: "hideCrechCd" ,"visible": false, "searchable": false},
	    		{ title: "hideChldCpl" ,"visible": false, "searchable": false},
	    		
	    		//# Displayed Column
	    		//# Sl No column for Link
				{ title: "Sl. No." ,"width": "5%",
					render: function(data, type, row) 
		    		{
						//console.log(row);
						//# "Z^Z" = Value separator
						//# formid = Search Form Id
						return "<a href='#'  onClick='prepareData(\""
				    		  +row[0]+"^"+row[1]+"^"+row[2]+"^"+row[3]+"^"+row[4]+"^"+row[9]+"^"+formid
				    		  +"\")'>"+data+"</a>";
		    		}
	    		},
				{ title: "District" ,"width": "5%",},
				{ title: "Block" ,"width": "5%",},
				{ title: "Creche" ,"width": "5%",},
				{ title: "Form Name" ,"width": "5%",},
				{ title: "Edit request uploaded on" ,"width": "5%",},
				{ title: "User Name" ,"width": "5%",},
    	],
    	language: {
            searchPlaceholder: "Search By Any Parameter"
        }, 
    	"fnInitComplete": function (oSettings, json) {
            //alert('DataTables has finished its initialisation.');
            hideModal();
    	},
	     
	 });
	

	//hideModal();	
	
	
} //# End FetchLinkData


/**
 * Function to show Data for Approve/Rejectc lock
 * @returns
 */
function prepareData(val) {
	//console.log("here in prepareData..."+val);
	
	GLOBAL_data = val.split("^")
	
	//# For Back Button
	$('#aLnkBack').show();
	G_BACK_TBL = 3; //# For Table 2 display
	//G_BACK_FORM = GLOBAL_data[6];	
	
	/*
	 	1. var_mnth_yr - takes month year.
		2. var_form_id - takes form id.
		3. var_dttime - takes uploaded date time.
		4. var_code - takes household code/ child code/ creche code.
		5. var_sl_no - takes household couple no/ week no.
	 */
	
	showModal();	
	
	$.ajax({
		url: "../../pop.DataManage",
		type: "get",
		data: {			
			mnth_yr : GLOBAL_data[0],
			form_id : GLOBAL_data[1],			
			dttm : GLOBAL_data[2],
			code : GLOBAL_data[3],
			sl_no : GLOBAL_data[4],			
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get data.");
				hideModal();
				return;
			} else {
				var obj_response = eval ("("+ response +")");
				//console.log(obj_response);
				if(obj_response.length == 1) {
					bootbox.alert("Unable to get data.");
					$('#div_data').html("");
					hideModal();
					return;
				}				
				//drawDataManageTableChartNew(obj_response);
				drawDataManageTableChart(obj_response);
			}
		},
		error: function(xhr) {
			bootbox.alert("Unable to get data.");
			hideModal();
			return;
		}
	});
}

var table;

/**
 * Function to draw Table Chart for Manage Data
 * @param obj_response
 * @returns
 */
function drawDataManageTableChart(obj_response) {
	//console.log(obj_response);
	var obj_transpose_data = transpose(obj_response);
	
	//# Form Name
	$('#hdFormNm').text("Form Name: " + GLOBAL_data[5]);
	
	var tbl_data = '';
	tbl_data += '<table id="tbl_data_manage" class="display data_manage_table" cellspacing="0" style="width:100%">';	
		tbl_data += '<thead>';
		for (var i = 0; i < obj_transpose_data.length; i++) {
			if(i > 0){
				break;
			}
			tbl_data += '<tr>';
			for (var j = 0; j < obj_transpose_data[i].length; j++) {
				tbl_data += '<th>'+obj_transpose_data[i][j]+'</th>';
			}
			tbl_data += '</tr>';
		}	
		tbl_data += '</thead>';
		
		tbl_data += '<tbody>';
		//# Ignore display 1st row
		for (var x = 2; x < obj_transpose_data.length; x++) {
			tbl_data += '<tr>';
			for (var y = 0; y < obj_transpose_data[i].length; y++) {
				if(y == 1) {
					//tbl_data += '<td class="set_text_green">'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
					tbl_data += '<td class="">'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
				} 
				else if(y == 2) {
					if(obj_transpose_data[x][1].replace('N/A', '-') != obj_transpose_data[x][2].replace('N/A', '-')){
						//tbl_data += '<td class="set_text_red"><b>'+obj_transpose_data[x][y].replace('N/A', '-');
						//# Ignore Upload date and Remarks column
						if(x>2 && x<obj_transpose_data.length-1){
							tbl_data += '<td class="">'+obj_transpose_data[x][y].replace('N/A', '-')
							+'	<i class="fa fa-info-circle" aria-hidden="true"></i></td>';
						}else{
							tbl_data += '<td class="">'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
						}
						
					}else{
						//tbl_data += '<td class="set_text_red">'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
						tbl_data += '<td class="">'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
					}
				}
				else {
					tbl_data += '<td>'+obj_transpose_data[x][y].replace('N/A', '-')+'</td>';
				}
			}
			tbl_data += '</tr>';
			if(x == (obj_transpose_data.length-1)) {
				tbl_data += '<tr>';
					tbl_data += '<td></td>';
					tbl_data += '<td></td>';
					tbl_data += '<td>'+
									'<input type="submit" id="appbtn" class="approveBtn" onClick="manageData(&#39;A&#39;)" value="Approve">'+
									'<input type="submit" id="rejbtn" class="rejectBtn" onClick="manageData(&#39;R&#39;)" value="Reject">'+
									'<input type="text" id="txtReject" placeholder="Reason for rejection" class="botomTextBox"  value="" >'+
								'</td>';
				tbl_data += '</tr>';
			}
		}
		tbl_data += '</tbody>';
	tbl_data += '</table>';
	//console.log(tbl_data);
	$('#div_data').html(tbl_data);
	
	table = $('#tbl_data_manage').DataTable({
		scrollY:        "58vh",
        //scrollX:        true,
        scrollCollapse: true,
        paging: false,
        "bInfo" : false,
        "searchable": false,
        "bFilter": false,
        "ordering": false,
       /* "columnDefs": [
            {
                "targets": [],
                "visible": false,
                "searchable": false,
                "orderable": false
                
            }
        ],*/
        "order": [],
        
    });	
	
	hideModal();
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
 * Function to Manage Data Edit
 * @param type
 * @returns
 */
function manageData(type){
	
	/*
	 ### Global Variable
		mnth_yr : GLOBAL_data[0],
		form_id : GLOBAL_data[1],			
		dttm : GLOBAL_data[2],
		code : GLOBAL_data[3],
		sl_no : GLOBAL_data[4], 
		 
		The Procedure will update the Edited Dataset (Approve/Reject).
		
		Parameters used:
	
		1. var_mnth_yr - takes month year.
		2. var_form_id - takes form id.
		3. var_dttime - takes uploaded date time.
		4. var_code - takes household code/ child code/ creche code.
		5. var_sl_no - takes household couple no/ week no.
		6. var_ed_cur_stat - takes 'A' for Approval and 'R' for Rejection.
		7. var_edit_user - takes the user name who approves or rejects the dataset.
		8. var_ed_cur_dt - takes the date and time of approval or rejection.
		9. var_remarks - takes remarks of the user mainly for rejection of the dataset.

	*/
	
	bootbox.confirm({
	    message: "Do you want to "+(type=="A"?"Approve":"Reject")+" data ?",
	    size: 'small',
	    buttons: {
	        confirm: {
	            label: 'Yes',
	            className: 'btn-success'
	        },
	        cancel: {
	            label: 'No',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {
	        if(result == true){
	        	//# Reject without remarks
	        	if (type=="R" && $('#txtReject').val().trim()=="") {
	        		bootbox.alert({
	        		    message: "Please enter reason for rejection!",
	        		    size: 'small'
	        		});	        		
	        		return;
	        	}
	        	
	        	var mng_type = type;
	        	var upload_date = table.row(0).data()[2];
	        	if(upload_date.length>19){
	        		upload_date = upload_date.substring(0, 19).trim();
	        	}
	        	
	        	    
	            $.ajax({
	        		url: "../../manage.DataEdit",
	        		type: "post",
	        		data: {			
	        			mnth_yr : GLOBAL_data[0],
	        			form_id : GLOBAL_data[1],			
	        			dttm : GLOBAL_data[2],
	        			code : GLOBAL_data[3],
	        			sl_no : GLOBAL_data[4],
	        			ed_cur_stat: mng_type,
	        			edit_user : GLOBAL_LOGIN_USER_ID,			
	        			ed_cur_dt : upload_date,
	        			remarks : $('#txtReject').val(),
	        			
	        		},
	        		success: function(response) {
	        			//console.log(response);			 
	        			if (response == "N/A") {
	        				bootbox.alert("Unable to update data.");
	        				hideModal();
	        				return;
	        			} else {
	        				//console.log(response);
	        				if (response == "1") {
	        					bootbox.alert("Data updated successfully.");
	        					//clearComboData();
	        					//popStDtBkGpVlCrForm();
	        					//# Form Name
	        					$('#hdFormNm').text("");
	        					$('#div_data').html("");
	        					//prepareData(GLOBAL_data[0]+"^"+GLOBAL_data[1]+"^"+GLOBAL_data[2]+"^"+GLOBAL_data[3]+"^"+GLOBAL_data[4]);
	        					var my = GLOBAL_data[0].split('-')
	        					//# Search Form ID (back to prev page)
	        					FetchLinkData(GLOBAL_data[6], my[1], my[0])
	        					
	        					hideModal();
	        					return;
	        				} else {
	        					bootbox.alert("Unable to update data.");
	        					hideModal();
	        					return;
	        				}
	        			}
	        		},
	        		error: function(xhr) {
	        			bootbox.alert("Unable to update data.");
	        			hideModal();
	        			return;
	        		}
	        	});
	            hideModal();
	        }else{
	        	hideModal();
	        	return;
	        }
	    } //# End Callback
	}); //# End Bootbox msg part	
	
}


$("#aLnkBack" ).click(function() {
	$('#hdFormNm').text("");
	if (G_BACK_TBL==2) {
		$('#divYr').show();
		GetEditRequestPendingSummary(G_BACK_YEAR);
		$("#aLnkBack").hide();
		G_BACK_TBL=1;
	}
	if (G_BACK_TBL==3) {
		$('#divYr').hide();
		FetchLinkData(G_BACK_FORM, G_BACK_MNTH, G_BACK_YEAR);
	}
	console.log("Table: " +G_BACK_TBL);
	
});

function rejectChk() {
	
	if($('#txtReject').val() == ""){
		$("#rejbtn").prop("disabled", true);
	}else{
		$("#rejbtn").prop("disabled", false);
	}	
}






