$(document).ready(function (){
	var str = location.href;
	
	var patt1 = new RegExp("overview.jsp");
	var patt2 = new RegExp("dashboard.jsp");
	var patt3 = new RegExp("usermng_tablet.jsp");
	var patt4 = new RegExp("usermng_web.jsp");
	var patt5 = new RegExp("report.jsp");
	var patt6 = new RegExp("child_atlas_2.jsp");
	var patt7 = new RegExp("monitoring.jsp");
	var patt9 = new RegExp("datalogs.jsp");	
	var patt10 = new RegExp("creche_management.jsp");
	var patt11 = new RegExp("content_management.jsp");
	var patt12 = new RegExp("add_geography.jsp");
	var patt13 = new RegExp("add_new_question.jsp");
	var patt14 = new RegExp("childshifting.jsp");
	var patt15 = new RegExp("data_edit_history.jsp");
	var patt16 = new RegExp("manage_data_edit.jsp");
	
	
	var res1 = patt1.test(str);	
	var res2 = patt2.test(str);
	var res3 = patt3.test(str);
	var res4 = patt4.test(str);
	var res5 = patt5.test(str);
	var res6 = patt6.test(str);
	var res7 = patt7.test(str);
	var res9 = patt9.test(str);	
	var res10 = patt10.test(str);
	var res11 = patt11.test(str);
	var res12 = patt12.test(str);
	var res13 = patt13.test(str);
	var res14 = patt14.test(str);
	var res15 = patt15.test(str);
	var res16 = patt16.test(str);
	
	$('.nav li a').each(function () {
		//alert(str);
		if(res1){
			$("li.active").removeClass("active");
			$("a#overview").parent().addClass("active");
		} else if(res2) {
			$("li.active").removeClass("active");
			$("a#dashboard").parent().addClass("active");
		} else if(res3 || res4){
			$("li.active").removeClass("active");
			$("a#admin").parent().addClass("active");
		} else if(res5 || res6){
			$("li.active").removeClass("active");
			$("a#report").parent().addClass("active");
		} else if(res7){
			$("li.active").removeClass("active");
			$("a#monitoring").parent().addClass("active");
		} else if(res9){
			$("li.active").removeClass("active");
			$("a#data_logs").parent().addClass("active");
		} else if(res10 || res11 || res12 || res13 || res14){
			$("li.active").removeClass("active");
			$("a#admin").parent().addClass("active");
		} else if(res15){
			$("li.active").removeClass("active");
			$("a#data_edit_history").parent().addClass("active");
		} else if(res16){
			$("li.active").removeClass("active");
			$("a#manage_data_edit").parent().addClass("active");
		} 			
	});
	
	//dropdown menu
	$('ul.nav li.dropdown').hover(function() {
  	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
  	}, function() {
  	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
 	});
	
});

function showModal(){
	//alert("here");
	//console.log("here");
	$('body').loadingModal('show');
	$('body').loadingModal({
		text: 'Getting the system ready for you. Please wait...',
		opacity: '0.5',
		animation: 'wave'
	});
}

function hideModal(){
	$('body').loadingModal('hide');
}