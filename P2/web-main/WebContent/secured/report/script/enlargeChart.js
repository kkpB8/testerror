var objWeightForAge = null;
var objHeightForAge = null;
var objWeightForLength = null;
  
  function enlargedChart(mode, code, name, gender, file_id){
	  console.log(mode+"..."+code+"..."+name+"..."+gender+"..."+file_id);
	  var ch_name = null;	
	  if (mode == "1") {
		  ch_name = "Weight for Age";
		} else if (mode == "2") {
			ch_name = "Weight for Length / Heigth";			
		} else if (mode == "3") {
			ch_name = "Length / Height for Age";
		}
	  if (gender == "Male") {
		  gender = "Boy";
	  } else{
		  gender = "Girl";
	  }
	  
	  //alert("here...");
	  //document.getElementById("ch_gender").innerHTML = name + " ("+gender+") : "+ch_name+ " - Birth to 2 years."
	  
	  //document.getElementById("imageView").src = "../survey.image?id=" + file_id +"&rand="+Math.random();
	  
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
						document.getElementById("header").style.display = "block";
						document.getElementById("header2").style.display = "none";
						document.getElementById("header3").style.display = "none";
						document.getElementById("WFA_legend").style.display = "block";
						objWeightForAge = xmlhttp.responseText;
						try {								
							enlargeWeightForAgeChart(objWeightForAge,name);
						} catch(err){
							alert(err.message);
						}
					} else if (mode == "2") {
						document.getElementById("header").style.display = "none";
						document.getElementById("header2").style.display = "block";
						document.getElementById("header3").style.display = "none";
						document.getElementById("WFL_legend").style.display = "block";
						objWeightForLength = xmlhttp.responseText;
						try {								
							enlargeWeightForLength(objWeightForLength,name);
						} catch(err){
							alert(err.message);
						}
					} else if (mode == "3") {
						document.getElementById("header").style.display = "none";
						document.getElementById("header2").style.display = "none";
						document.getElementById("header3").style.display = "block";
						document.getElementById("HFA_legend").style.display = "block";
						objHeightForAge = xmlhttp.responseText;
						try {								
							enlargeHeightForAgeChart(objHeightForAge,name);
						} catch(err){
							alert(err.message);
						}						
					}
				}	    	 				
		    }
		};
		xmlhttp.open("GET", "../../childChart.getData?mode="+mode+"&child_code="+code, true);
		xmlhttp.send();
	}



function enlargeWeightForAgeChart(objWeightForAge,name){	
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
        title: 'Wt for Age',
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
		    width: '80%',
		    height: '70%'
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
		var top = document.getElementById("WFA_chart_div").offsetTop + 98;
		var left = document.getElementById("WFA_chart_div").getBoundingClientRect().left;		
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		
		//alert("len : "+dataTable.getValue(dataLen, 7) +"  -- "+ top);
		
		document.querySelector('.sd3WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top - 8 + "px";
		document.querySelector('.sd3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sd2WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top - 8 + "px";
		document.querySelector('.sd2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sd1WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top - 8 + "px";
		document.querySelector('.sd1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sdmWFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top - 8 + "px";
		document.querySelector('.sdmWFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sd-1WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top - 8 + "px";
		document.querySelector('.sd-1WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sd-2WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top - 8 + "px";
		document.querySelector('.sd-2WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px";
		document.querySelector('.sd-3WFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top - 8 + "px";
		document.querySelector('.sd-3WFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 10 + "px"
		
		
		document.querySelector('.pic1').style.top = top + 40 + "px";;
		document.querySelector('.pic1').style.left = 120 + "px";
      	};
      	
      	var chart = new google.visualization.ComboChart(document.getElementById('WFA_chart_div'));
    	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
    	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
               		google.visualization.events.removeListener(runOnce);
               		chart.draw(data, options);
        });
        chart.draw(view, options);
	
}

function enlargeWeightForLength(objWeightForLength,name){	
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
        title: 'Wt for L/H',
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
		    width: '80%',
		    height: '70%'
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
		var top = document.getElementById("WFL_chart_div").offsetTop;
		var left = document.getElementById("WFL_chart_div").offsetLeft;	
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		
		document.querySelector('.sd3WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top + 87 + "px";
		document.querySelector('.sd3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sd2WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top + 87 + "px";
		document.querySelector('.sd2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sd1WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top + 87 + "px";
		document.querySelector('.sd1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sdmWFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top + 87 + "px";
		document.querySelector('.sdmWFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sd-1WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top + 87 + "px";
		document.querySelector('.sd-1WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sd-2WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top + 87 + "px";
		document.querySelector('.sd-2WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.sd-3WFL').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top + 87 + "px";
		document.querySelector('.sd-3WFL').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0))) + left + 65 + "px";
		document.querySelector('.pic1').style.top = top + 140 + "px";;
		document.querySelector('.pic1').style.left = 120 + "px";
      	};
      	
      	var chart = new google.visualization.ComboChart(document.getElementById('WFL_chart_div'));
    	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
    	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
               		google.visualization.events.removeListener(runOnce);
               		chart.draw(data, options);
        });
        chart.draw(view, options);
}

function enlargeHeightForAgeChart(objHeightForAge,name){	
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
        title: 'L/H for Age',
	  	curveType: 'function',
		animation: {duration: 2000, easing: 'linear'},
		vAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Height / Length (In Cm.)"},
		hAxis: {gridlines: {color: '#FFFFFF'}, format:'0', title: "Age(In Month)"},
   	  	legend: {alignment: 'end', position: 'top'},
		explorer: {actions: ['dragToZoom', 'rightClickToReset']},
		crosshair: {trigger: 'both', color: 'black',  opacity: 0.2},
		chartArea: {
		    left: 45,
		    top: 40,
		    width: '80%',
		    height: '70%'
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
		var top = document.getElementById("HFA_chart_div").offsetTop;
		var left = document.getElementById("HFA_chart_div").offsetLeft;		
		var cli = chart.getChartLayoutInterface();
		var chartArea = cli.getChartAreaBoundingBox();
		var dataLen = data.getNumberOfRows() - 1;
		//alert("len : "+dataTable.getValue(dataLen, 1) + "  ---  "+top);
		document.querySelector('.sd3HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 1))) + top + 87 + "px";
		document.querySelector('.sd3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sd2HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 2))) + top + 87 + "px";
		document.querySelector('.sd2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sd1HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 3))) + top + 87 + "px";
		document.querySelector('.sd1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sdmHFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 4))) + top + 87 + "px";
		document.querySelector('.sdmHFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sd-1HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 5))) + top + 87 + "px";
		document.querySelector('.sd-1HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sd-2HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 6))) + top + 87 + "px";
		document.querySelector('.sd-2HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		document.querySelector('.sd-3HFA').style.top = Math.floor(cli.getYLocation(dataTable.getValue(dataLen, 7))) + top + 87 + "px";
		document.querySelector('.sd-3HFA').style.left = Math.floor(cli.getXLocation(dataTable.getValue(dataLen, 0)))+ left + 65 + "px";
		//document.querySelector('.pic1').style.top = 180 + "px";;
		document.querySelector('.pic1').style.top = top + 140 + "px";;
		document.querySelector('.pic1').style.left = 120 + "px";
      	};
      	
      	var chart = new google.visualization.ComboChart(document.getElementById('HFA_chart_div'));
    	google.visualization.events.addListener(chart, 'ready',  placeMarker.bind(chart, data));
    	var runOnce = google.visualization.events.addListener(chart, 'ready', function () {
               		google.visualization.events.removeListener(runOnce);
               		chart.draw(data, options);
        });
        chart.draw(view, options);
	
}

