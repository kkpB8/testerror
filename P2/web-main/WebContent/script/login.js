$(document).ready(function() {
	showModal();
	popUploadedFiles();
});


/**
 * Function to populate Uploaded File List
 * @returns
 */
function popUploadedFiles() {
	showModal();
	$("#div_download_link").html("");
	
	$.ajax({
		  url: "../../pop.FileList",
		  type: "get",
		  data: {
			  
		  },
		  success: function(response) {
			  //console.log(response);			 
			  if (response == "N/A") {
				  //bootbox.alert("Unable to get data.");
				  drawTableChartData(null);
				  hideModal();
				  return;
			  } else {
				  var obj_response  = eval ("("+ response +")");
				  drawTableChartData(obj_response);
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
 * Function to draw Table Chart Data for Uploaded File List
 * @returns
 */
function drawTableChartData(obj_response) {
	var tableData = "";
	tableData += "<table id='tbl_data_archive' class='display loginTable' cellspacing='0' width='100%'>";
		tableData += "<thead>";
			tableData += "<tr>"
				tableData += "<th>File ID</th>";
				tableData += "<th>Uploaded by</th>";
				tableData += "<th>Uploaded on</th>";
				tableData += "<th>File Name</th>";
				tableData += "<th>Description</th>";
			tableData += "</tr>"
		tableData += "</thead>";
			
		
		if(obj_response == null) {
			tableData += "<tbody>";
				tableData += "<tr>";
		   			tableData += "<td>-</td>";
		   			tableData += "<td>-</td>";
		   			tableData += "<td>-</td>";
		   			tableData += "<td>-</td>";
		   			tableData += "<td>-</td>";
			    tableData += "</tr>";
			 tableData += "</tbody>";			
		} else {
			tableData += "<tbody>";
			for (var i = 0; i < obj_response.length; i++) {
				tableData += "<tr>";
				   	for (var j = 0; j < obj_response[i].length; j++) {
				   		if(j == 4) {
				   			tableData += "<td><a style='cursor:pointer;' onclick='downloadFile(&#39;"+obj_response[i][0]+"&#39;, &#39;"+obj_response[i][3]+"&#39;, &#39;"+obj_response[i][4]+"&#39;)'>"+obj_response[i][4].replace("N/A", "-")+"</a></td>";
				   		} else {
				   			tableData += "<td>"+obj_response[i][j].replace("N/A", "-")+"</td>";
				   		}
				   	}
			    tableData += "</tr>";
			 }
			 tableData += "</tbody>";
		}
		tableData += "</table>";
		//console.log(tableData);
		
		$('#div_download_link').html(tableData);
		
		$('#tbl_data_archive').DataTable({
			"scrollY": "200px",
			"scrollX": false,
			"scrollCollapse": true,        
			"paging": false,
			"searching": false,
			"info": false,
			//2D array - first inner array as the page length values and the second inner array as the displayed options
			//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
			//"lengthMenu": [[-1], ["All"]],
			//"ordering": false
			/* Disable initial sort */
			"order": [],
			//Hide 1st column, here District/Block/GP/Village/Creche Code
			"columnDefs": [
				{
					"targets": [ 0, 3 ],
					"visible": false,
					"searchable": false ,
					
				},
				
				{
					//Align as center for all columns except 1st column
					//"targets": [2, 3, 4, 5, 6, 7 ],
					//"className": "text-center"
				}
			],
			"columns": [
			    { "width": "0%" },
			    { "width": "30%" },
			    { "width": "30%" },
			    { "width": "0%" },
			    { "width": "40%" }
			  ],
			//DataTables initialisation finished
			"fnInitComplete": function (oSettings, json) {
				hideModal();
			}
		});
			
		//Draw Table Chart
		var table = $('#tbl_data_archive').DataTable();
		
		//For adjustment of Table row automatically
		table.columns.adjust().draw();	
		//hideModal();
	//}	 
}

/**
 * Function to download the uploaded files 
 * @param fileId
 * @param fileName
 * @param upldDate
 * @param catgId
 */
function downloadFile(file_id, file_name, file_desc){
	//console.log(file_id+"..."+file_name+"..."+file_desc);
	var submitForm = document.createElement("FORM");
	document.body.appendChild(submitForm);
	submitForm.method = "POST";	
	createNewFormElement(submitForm, "file_id", file_id);
	createNewFormElement(submitForm, "file_name", file_name);
	submitForm.action= "../../download.UploadedFile";	
	submitForm.submit();
}

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