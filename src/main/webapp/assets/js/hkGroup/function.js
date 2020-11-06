/**
 * 
 */
var FUCN = {
	global : {

	},

	urlBoard : function() {
		$(".liActive").removeClass("liActive");
		$("#board").attr("class", "liActive");

		location.href="/hkGroup/board";
	},
	
	noticeWriter: function(){
		var title = $("#title").val();
		var writer = $("#writer").val();
		var content = $("#summernote").val();
		
		if(title == null || title == ""){
			swal("제목을 입력해주세요.", "", "error");
			return false;
		}
		
		if(content == null || content == ""){
			swal("내용을 입력해주세요.", "", "error");
			return false;
		}
		
		var data = {
			TITLE : title,
			WRITER : writer,
			CONTENT : content
		}
		
		$.ajax({
			url : '../hkGroup/ajaxGetWrite',
			type : 'post',
			dataType : 'json',
			data: data,
			success:function(rs){
				location.href='/hkGroup/board';
			},
			error:function(){
				swal("내부 오류가 발생했습니다.", "", "error");
			}
		});
		
	},
	

}