/**
 * 
 */
var FUCN = {
	global : {
		
	},

	urlBoard : function() {
		$(".liActive").removeClass("liActive");

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
				location.href="/hkGroup/board";
			},
			error:function(){
				swal("내부 오류가 발생했습니다.", "", "error");
			}
		});
		
	},
	
	doCretRple: function(nbno){
		var data = {
				NBNO : nbno,
				RETITLE : $("#re_title").val()
		};
		
		$.ajax({
			url : '../hkGroup/doReple',
			type: 'post',
			dataType: 'json',
			data : data,
			success:function(rs){
				
				var noticeBoardNum = rs.SC.nbno;
				
				$("#re_title").val("");
				
				FUCN.viewReple(noticeBoardNum);
			}
		});
	},
	
	viewReple: function(noticeBoardNum){
		
		var data ={
				NBNO : noticeBoardNum
		}
		
		$.ajax({
			url : '../hkGroup/viewReple',
			type : 'post',
			dataType : 'json',
			data :data,
			success:function(rs){
				var html = "";
				$("#reView").html("");
				for(var i = 0; i < rs.SC.length ; i++){
					html
						= '<b>'+ rs.SC[i].rewriter +' = ' + rs.SC[i].recontent + '         ' + rs.SC[i].regdate + '</b></br>';
					
					$("#reView").append(html);
				}
				
			}
		});
	},
	
	noticeModify: function(){
		$("#title").attr("readonly", false);
		$("#nbContentView").css("display", "none");
		
		var html = 
				'<label for="content">내용</label>'
			+	'<textarea class="form-control" rows="5" name="content" id="summernote"></textarea>';
		$("#boardContent").append(html);
		
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
		});
	},
	
	nbUpdate: function(nbno){
		var data={
				NBNO : nbno,
				TITLE : $("#title").val(),
				CONTENT : $("#summernote").val()
		}
		
		$.ajax({
			url : '../hkGroup/nbUpdate',
			type : 'post',
			dataType: 'json',
			data : data,
			success:function(rs){
				location.href="/hkGroup/boardView?nbno="+nbno;
			}
		});
	},
	

	fileDownload: function(nfno, fileName, path){
		var data={
				NFNO : nfno,
				FILENAME: fileName,
				PATH : path
		}
		
		$.ajax({
			url: '../hkGroup/fileDown',
			type: 'get',
			data: data,
			success:function(rs){
				location.href="/hkGroup/fileDown?NFNO="+nfno+"&FILENAME="+fileName+"&PATH="+path;
			}
		});
	},
	
	

}