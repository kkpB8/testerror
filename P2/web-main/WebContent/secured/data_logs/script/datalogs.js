$(document).ready(function() {	
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
});


/**
 * Function to show Data Logs
 * @returns
 */
function prepareDataLogs() {
	//console.log("here in showDataLogs...");
	
	showModal();
	$.ajax({
		url: "../../pop.DataLogs",
		type: "get",
		data: {
			sel_mnth_yr : $("#sel_mnth_yr").val()
		},
		success: function(response) {
			//console.log(response);			 
			if (response == "N/A") {
				bootbox.alert("Unable to get data.");
				hideModal();
				return;
			} else {
				var obj_response = eval ("("+ response +")");
				drawDataLogsTableChart(obj_response);
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
 * Function to draw Table Chart for Data Logs
 * @param obj_response
 * @returns
 */
function drawDataLogsTableChart(obj_response) {
	//console.log(obj_response);	
	var tbl_data = '';
	tbl_data += '<table id="tbl_data_logs" class="display dataLogTable" cellspacing="0" style="width:100%">';	
		tbl_data += '<thead>';
		for (var i = 0; i < obj_response.length; i++) {
			if(i > 0){
				break;
			}
			tbl_data += '<tr>';
			for (var j = 0; j < obj_response[i].length; j++) {
				tbl_data += '<th>'+obj_response[i][j]+'</th>';
			}
			tbl_data += '</tr>';
		}	
		tbl_data += '</thead>';
		
		tbl_data += '<tbody>';
		for (var x = 1; x < obj_response.length; x++) {
			tbl_data += '<tr>';
			for (var y = 0; y < obj_response[i].length; y++) {
				tbl_data += '<td>'+obj_response[x][y].replace('N/A', '-')+'</td>';
			}
			tbl_data += '</tr>';
		}
		tbl_data += '</tbody>';
	tbl_data += '</table>';
	//console.log(tbl_data);
	$('#div_data').html(tbl_data);
	
	var table = $('#tbl_data_logs').DataTable({
		scrollY:        "300px",
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        fixedColumns:   {
        	leftColumns: 2
        }
    });	
	hideModal();
}