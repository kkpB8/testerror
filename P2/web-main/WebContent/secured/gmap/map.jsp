<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>|| Map ||</title>    
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <link href="css/bootstrap.css" rel="stylesheet">
   	<link href="style/map.css" rel="stylesheet">
    <link href="css/jqueryslidemenu.css" rel="stylesheet">
    <link href="css/jquery-ui.css" rel="stylesheet" >
    
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jqueryslidemenu.js"></script>
	<script type="text/javascript" src="js/jquery-mousewheel.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="script/utility.js"></script>
  	
  	<script>
    $(function() {
    	$("#divQueryDataViewer").dialog({
       		autoOpen: false,
       		width: 220, 
       		modal: true,
       		position: {of: queryDataVal} 
        });
		$("#tableLayer").accordion({
    		active: false,
    		collapsible: true,
    		heightStyle: "content"
    	});
    });
    </script>
  </head>
  
  <body style="overflow-x:hidden;">
  	<!-- loading -->
	<div id = "loading_bg"></div>
	<p id="loading"><span>L </span><span>o </span><span>a </span><span>d </span><span>i </span><span>n </span><span>g</span></p>
	<!-- loading -->	
    <input type="hidden" id="lati" value='<%=request.getSession().getAttribute("lati").toString()%>' />
    <input type="hidden" id="longi" value='<%=request.getSession().getAttribute("longi").toString()%>' />
    <input type="hidden" id="zoom" value='<%=request.getSession().getAttribute("zoom").toString()%>' />
    <input type="hidden" id="map_id" value='<%=request.getParameter("map_id")%>' />
    <input type="hidden" id="map_name" value='<%=request.getParameter("map_name")%>' />
	<!-- For Menu -->
		<%@ include file="../gmap/menu.jsp" %>
	<!-- For Menu -->
	<!-- Query Starts -->
		 <div id="divQueryDataViewer" title="Data" style="display: none;">
		<table id="sampleDataViewer">
			<tr>
				<td>	
					<span id="tex_t">Choose Value:	</span>	
				</td>
			
				<td>
					<select id="indicatorDataSelector"> 
					
				  	</select>
				</td>
			</tr>
			<tr>
				<td>
				<input type="button" value="Select" id="btnSelectData" onclick="setQueryData()">
				</td>
			</tr>
		</table>
	</div>	
    <table id="legends" class="tborder" style="width: 100%; border-collapse: collapse;">
    	<tr>
    		<td colspan="2">
    			<div id="mapName">
				</div>
    		</td>
    	</tr>
    	</table>
 <!-- Query End -->
			<div class="container-fluid" style="padding:0px;">
		        <div class="row">
		            <div class="container">
		                <div class="col-sm-12 map_content" style="padding:0px;">
		                    <div class="row">
		                    	<div class="col-sm-3 page-element" id="left_panel">
		                    	<!-- Map Layer starts -->
		                    		<div id="tableLayer" class="accordion"></div>
		                    	<!-- Map Layer Ends -->
		                    	<!-- Searching starts -->
		                    		 <div id="tableSearch" class="" style="display: none">
										<table id="searchTab">
			 						<tr>
					  					<td>
					  						Layer:
					  					</td>
				  						<td>
					  						<select id="searchLayer" onchange="popSearchObjectNames();"></select>
					  					</td>
					  				</tr>
					  				<tr></tr>
					  				<tr></tr>
					  				<tr>
					  					<td>
					  						Name:
					  					</td>
					  					<td>
					  						<select id="searchObject"></select>
					  					</td>
					  				</tr>
								</table>
								<table id="searchTab1">
			 						<tr>
				  						<td colspan="2" style="text-align: center;">
					  						<input type="button" id="searchMap" value="Search" onclick="searchObject();">
					  					</td> 
					  				</tr> 				
			 					</table>
	 				</div>
	 				<!-- Searching Ends -->
	 				<!-- Query starts -->
	 				<div id="tableQuery" class="page-element" style="display: none;">
	 				<fieldset>
			 			<table id="queryTab">
			 				<tr>
			  					<td>
			  						Layer:
			  					</td>
		  						<td>
			  						<select id="queryLayer" onchange="popQueryGroup();"></select>
			  					</td>
			  				</tr>
			  				
			  				<tr>
					  			<td>
					  				Group:
					  			</td>
					  			<td>
					  				<select id="queryGroup" onchange="popQueryCategory();">
					  					
					  				</select>
					  			</td>
					  		</tr>
					  		
					  		<tr>
					  			<td>
					  				Category:
					  			</td>
					  			<td>
					  				<select id="queryCategory" onchange="popQueryPeriods();">
					  					
					  				</select>
					  			</td>
					  		</tr>
					  		
					  		<tr>
					  			<td>
					  				Indicator:
					  			</td>
					  			<td>
					  				<select id="queryIndicator" onchange="popQueryRange();">
					  					
					  				</select>
					  				<input type="hidden" id="queryRangeOrder">
					  				<input type="hidden" id="queryIndiType">
					  			</td>
					  		</tr>
					  		<tr id="queryTabPeriod" style="visibility: collapse;" onchange="popQueryRange();">
					  			<td>
					  				Period:
					  			</td>
					  			<td>
					  				<select id="queryPeriod">
					  					
					  				</select>
					  			</td>
					  		</tr>
					  		<tr>
					  			<td colspan="2">
					  				<hr>
					  			</td>
					  			
				  			</tr> 
					  		<tr>
					  			<td colspan="2" id="queryDataSource">
					  			</td>
					  		</tr>			  			
					  		<tr>
					  			<td colspan="2" id="queryDataRange">
					  			</td>
					  		</tr>
					  		<tr>
					  			<td colspan="2">
					  				<hr>
					  			</td>
					  		</tr>
					  		<tr>
					  			<td colspan="2"><table><tr>
						  			<td>
						  				<select id="queryDataOper"> 
						  				</select> 
						  			</td>
						  			<td>
						  				<input type="text" placeholder="Enter value" id="queryDataVal" style="width: 80px">
						  			</td>
						  			<td>
						  				<input type="button" value="..." id="btnBrowse" onclick="viewQueryIndiSampleData();">
						  			</td>
						  		</tr></table></td>
					  		</tr>  
					  		<tr>
					  			<td colspan="2" style="text-align: center;">
					  				<input type="button" id="btnQueryDisplay" value="Execute Query" onclick="queryMap()" >
					  			</td>
					  		</tr> 
					  		<tr>
					  			<td colspan="2">
					  				<hr>
					  			</td>
					  		</tr>
					  		<tr>
					  			<td colspan="2">
					  				<div id="queryInfoDiv">
					  				</div>
					  			</td>
					  		</tr>
			 			</table>
	 				</fieldset>
	 			</div>
	 			<!-- Query Ends -->
	 			<!-- Distance Starts -->
	 			<div id="tableDistance" class="page-element" style="display: none">
					 <fieldset>	  				
					 	<br />
		  				<table id="distanceTab">
		  					<tr>
					  			<td>
					  				<input id="distanceViewer" type="text" value="0" readonly="readonly"> 
					  			</td>
					  			<td>
					  				<select id="distanceUnit" onchange="convertDistance();">
					  					<option value="km" selected="selected">Km.</option>
					  					<option value="mtr">Mtr.</option>
					  					<!-- <option>Miles</option> -->
					  				</select>
					  			</td>
					  			<td>
					  				<input type="button" id="resetDistance" value="Reset" onclick="resetValue();">
					  			</td>
					  		</tr>
		  				</table>
		  				<fieldset id="fldSet2">
		  				<table id="distanceTab2">
		  				<tr>
		  					<td>
		  						Measure Aerial distance between two or multiple points on the map.
		  					</td>
		  				</tr>
							</table>
		  				</fieldset>
		  			</fieldset> 
				 </div>
				 <div id="tableBuffer" class="page-element" style="display: none">
				 	<fieldset>	  	
				 		<table id="bufferTab">	
				 			<tr>
				 				<td>
				 					I want to draw 
		  							<input type="number" id="bufferRadius" style="width: 80px;" /> mtr. 
				 				</td>
				 			</tr>
				 			<tr>
				 			</tr>
				 			<tr>
				 				<td>
				 					radius circle centering all  <br>
		  							<select id="bufferLayer" style="width: 120px;"> </select><br>
				 				</td>
				 			</tr>
				 		</table>		
		  				<br />
		  				<table>
		  					<tr>
		  						<td><input id="bufferDrawCol" type="color" value="#800000" style="width: 30px;" ></td>
		  						<td><input type="button" value="Display" onclick="drawBufferCircle()" /></td>
		  					</tr>
		  				</table>
		  			</fieldset>
				 </div>
				 <!-- Distance End -->
               	</div>
               			<!-- map panel starts  -->		
               	<div class="col-sm-9 right_panel">
               		<div id="map"></div>
				<div id="dvPanel"></div> 
				<!-- map panel End  -->	
                 	</div>
                 </div>
             </div>
         </div>
     </div>
</div>				
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHkJu5eVq6KurtwazFIiHlObNBjlQ6jS4&callback=initMap"
    async defer> </script>
    
  </body>
</html>
