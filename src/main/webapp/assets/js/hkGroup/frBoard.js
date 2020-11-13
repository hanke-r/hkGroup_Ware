/**
 *  2020.11.11
 *  자유게시판 스크립트
 *  by. Hanker
 */

var FRBD = {
	global : {
			
	},
		
	
	frBoardMain: function(){
		$(".liActive").removeClass("liActive");
			
		location.href="/frBoard/frBoardMain";
	},
	
	frWriter: function(){
		
		if($("#title").val() == null || $("#title").val() == ""){
			swal("제목을 입력해주세요.", "", "error");
			return false;
		}
		
		if($("#summernote").val() == null || $("#summernote").val() == ""){
			swal("내용을 입력해주세요.", "", "error");
			return false;
		}
		
		var data = {
				TITLE : $("#title").val(),
				WRITER : $("#writer").val(),
				CONTENT : $("#summernote").val()
		}
		
		$.ajax({
			url : '../frBoard/frbWrt',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				location.href="/frBoard/frBoardMain";
			}
		});
	},
	
	frbUpdView: function(cont){
		$("#title").attr("readonly", false);
		$("#frbViewContent").css("display", "none");
		
		var html = 
			'<label for="content">내용</label>'
		+ 	'<textarea class="form-control" rows="5" name="content" id="summernote"></textarea>';
		$("#frbContent").append(html);
		
		$("#update").css("display", "none");
		$("#list").css("display", "none");
		
		$("#updateChk").show();
		$("#back").show();
		
		$('#summernote').summernote({
			height: 300,                 // 에디터 높이
			minHeight: null,             // 최소 높이
			maxHeight: null,             // 최대 높이
			focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			lang: "ko-KR",					// 한글 설정
			placeholder: cont	//placeholder 설정
		});
	},
	
	frbUpdate: function(frno){
		var data ={
				FRNO : frno,
				TITLE : $("#title").val(),
				CONTENT : $("#summernote").val()
		}
		
		$.ajax({
			url : '../frBoard/frbUpdate',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				location.href="/frBoard/frBoardView?frno="+frno;
			}
		});
	},
	
	doCretRple: function(frno){
		var data = {
				FRNO : frno,
				RETITLE : $("#re_title").val()
		};
		
		$.ajax({
			url : '../frBoard/doReple',
			type: 'post',
			dataType: 'json',
			data : data,
			success:function(rs){
				
				var freeBoardNum = rs.SC.frno;
				
				$("#re_title").val("");
				
				FRBD.viewReple(freeBoardNum);
			}
		});
	},
	
	viewReple: function(fbnum){
		var data ={
				FRNO : fbnum
		}
		
		$.ajax({
			url : '../frBoard/viewReple',
			type : 'post',
			dataType : 'json',
			data :data,
			success:function(rs){
				console.log(rs.SC.length);
				var html = "";
				$("#reView").html("");
				for(var i = 0; i < rs.SC.length ; i++){
					html
						= '<b>'+ rs.SC[i].ref_writer +' = ' + rs.SC[i].ref_content + '         ' + rs.SC[i].regdate + '</b></br>';
					
					$("#reView").append(html);
				}
				
			}
		});
	}
}