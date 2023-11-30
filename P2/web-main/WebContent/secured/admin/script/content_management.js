/**
 * Function to upload file
 */
function uploadFile() {
	showModal();
	var fileName = "";
	var fileDesc = document.getElementById("file_desc").value;
	try {
		fileName = document.getElementById("upload_file").files.item(0).name;
	} catch (e) {
		alert("Please select file.");
		hideModal();
		return;
	}
	//validation
	if (fileDesc.trim() == "") {
		alert("Please give some description.");
		hideModal();
		return;
	}
	var fileSize = document.getElementById('upload_file').files[0].size;
	//File extension checking and upload
	if (!(fileName.endsWith(".pdf")
			|| fileName.endsWith(".png")
				|| fileName.endsWith(".jpg")
					|| fileName.endsWith(".jpeg")
						|| fileName.endsWith(".ppt")
							|| fileName.endsWith(".pptx"))) {
		alert("Only pdf/png/jpg/jpeg/ppt/pptx file is accepted.");
		document.getElementById("upload_file").value = "";
		hideModal();
	   return;
	}	
	//Check File size
	if (fileSize > 1024*1024*4) {
		alert("File size must be less than 4 Mb.");
	  	document.getElementById("upload_file").value = "";
	  	hideModal();
	   return;
	}	
	//With any file upload 
	var formData = new FormData();
	formData.append("fileDesc", fileDesc);
	formData.append("upload_file", document.getElementById("upload_file").files[0]);
	 
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", "../../upload.File");
	xmlhttp.send(formData);
	xmlhttp.onload = function(e) {    	
        if (this.readyState == 4 & this.status == 200) {
           //When response is "Error"
           if (this.responseText == "Error") {
			   alert("Unable to upload the file");
			   hideModal();
			   return;
           } 
           //When response is "Done"
           else if (this.responseText == "Done"){
        	   alert(fileName.substring(0, fileName.indexOf("."))+" file successfully uploaded.");
        	   document.getElementById("file_desc").value = "";
        	   document.getElementById("upload_file").value = "";
        	   hideModal();
        	   return;
           }
        }
    };
}

/**
 * Function to reset page
 */
function reset(){
	document.getElementById("file_desc").value = "";
	   document.getElementById("upload_file").value = "";
}