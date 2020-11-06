/**
 * 
 */
var FUCN = {
	global : {

	},

	urlBoard : function() {
		$(".liActive").removeClass("liActive");
		$("#board").attr("class", "liActive");

		$.ajax({
			url : '../hkGroup/board',
			type : 'post',
			dataType : 'json',
			success : function(rs) {
				location.href = "/hkGroup/board";
			}
		});
	},
	
	

}