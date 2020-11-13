/**
 *  2020.11.09
 *  문의사항 스크립트
 *  by. Hanker
 */

var QUES = {
	global : {
		
	},
	
	qsBoardMain: function (){
		$(".liActive").removeClass("liActive");
		
		location.href="/question/qsBoardMain";
	},
	
	
	inqWrite: function(){
		var data = {
				TITLE : $("#title").val(),
				WRITER : $("#writer").val(),
				EMAIL : $("#email").val(),
				CONTENT : $("#summernote").val()
		}
		
		$.ajax({
			url : '../question/inqWrite',
			type : 'post',
			dataType : 'json',
			data : data,
			success: function(rs){
				console.log(rs);
				
				QUES.qsBoardMain();
			}
		});
	},
	
	
}