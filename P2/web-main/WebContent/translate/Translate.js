var STR_GLOBAL_LANGUAGE="eng";

function SetLanguageGlbl(val) {
	$.ajax({
		url: "set.curlang",
		  type: "get", //send it through get method
		  data: {
			  lng: val,
		  },
		  success: function(response) {
			  //alert(response);
			  if (response == "N/A") {
				return;
			  } else {
				  STR_GLOBAL_LANGUAGE = response;
				  //alert("Change Global - " + STR_GLOBAL_LANGUAGE);
			  }
		  },
		  error: function(xhr) {
			  alert("Unable To set data.");
			  return;
		  }
	});	
} //# End SetLanguageGlbl

function CallLangTranslate(strCurlang) {
	//alert("Enter CallLangTranslate " + strCurlang );
	STR_GLOBAL_LANGUAGE=strCurlang;
	var translate = new Translate();
    var currentLng = strCurlang;
    var attributeName = 'data-tag';
    translate.init(attributeName, currentLng);
    translate.process(); 
} //# End 


function Translate(){
	this.init=function(attribute, lng){
        this.attribute = attribute;
        this.lng = lng;    
    }
	
	this.process = function(){
		_self = this;
		var xmlhttp;
		if (window.XMLHttpRequest) { 
			xmlhttp=new XMLHttpRequest();
		} else { 
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				if (xmlhttp.responseText == "N/A") {
					alert("No Response!!!");
				} else {
					var LngObject = JSON.parse(xmlhttp.responseText);
	                console.log(LngObject["dist"]);
	                var allDom = document.getElementsByTagName("*");
	                for(var i =0; i < allDom.length; i++){
	                    var elem = allDom[i];
	                    var key = elem.getAttribute(_self.attribute);
	                     
	                    if(key != null) {
	                         console.log(key);
	                         elem.innerHTML = LngObject[key]  ;
	                    }
	                }
				}	    	 				
		    }
		};
		xmlhttp.open("GET", "translate/" + this.lng+".json", true);
		xmlhttp.send();
	}
}