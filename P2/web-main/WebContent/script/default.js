/**
 * Function to open Map
 */
function showMap(map_id, map_name, map_rltd) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		    if (xmlhttp.responseText == "Done") {
				window.open("../gmap/map.jsp?map_id="+map_id+"&map_name="+map_name+"&map_rltd="+map_rltd, "_blank");
		    }                                                     
		}
	};
	xmlhttp.open("GET", "../../map.getCoordinates?map_id="+map_id, true);
	xmlhttp.send();
}