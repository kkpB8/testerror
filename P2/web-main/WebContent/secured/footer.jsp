<%--<div class="row footer">
   <div class="col-sm-6 ">
   		<!--visitor count-->                                       
     		<div class="visitor">You are Visitor Number :   <%= session.getAttribute("Hits").toString() %></div>
		<!--visitor count-->
   </div>
   <div class="col-sm-6 ">
    	<div class="riddhi" title="">
      	</div>
   </div>
</div>--%>
<footer>
  <div class="container-fluid">
    
    <div class="col-md-6 col-sm-6 col-xs-12">
         <p class="visitorcount">You are Visitor Number : <%= session.getAttribute("Hits").toString() %></p> 
    </div>
    
    <div class="col-md-6 col-sm-6 col-xs-12">
	<div class="copyright">
     	 </div>
    </div>
  </div>
</footer>
