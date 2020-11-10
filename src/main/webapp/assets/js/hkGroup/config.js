/**
 *  2020.11.09
 *  형상관리 스크립트
 *  by. Hanker
 */

var CONF = {
	global : {
		number: 0,
	},
	
	
	confManage: function(){
		$(".liActive").removeClass("liActive");
		
		location.href="/config/listView";
	},
	
	gitCommitMsg: function(i){
		var owner = $("#owner").val();
		var repos = $("#repos").val();
		
		var pageNo = 1 + i;
		var auth = window.btoa("");
		$.ajax({
			type : "GET",
			headers : {
				Authorization : "Basic " + auth,
			},
			url : "https://api.github.com/repos/"+owner+"/"+repos+"/commits?per_page=100&page="+pageNo,
			dataType : "json",
			success : function(response) {
				console.log(response.length);
				console.log(pageNo);
				var array = response;
				var max = array.length;
				for (var i = 0; i < array.length; i++) {
					var cal = array[i].commit.author.date;
					var result = cal.split('T', 1);
					$(".confContainer").append(
											"<div class='commitCon'><b class='fntSize'> "
												+ max
												+ ". "
												+ array[i].commit.message
												+ "</b></div><div style='color: orange;margin-left: 87%;'>"
												+ array[i].commit.author.date
												+ "</div>");
					max = max - 1;
				}
				
				if(array.length == 100 && pageNo > 1){
					$(".confFooter").append(
							'<button type="button" class="btn btn-primary" id="prevBtn" onclick="CONF.gitPrev();>이전</button>'
						  + '<button type="button" class="btn btn-default" id="nextBtn" onclick="CONF.gitNext();">다음</button>'	
						  +	'<button type="button" class="btn btn-danger" id="commitCalc" data-toggle="modal" data-target="#gitModal">Commit 확인</button>'
					);
				} else if(array.length < 100 && pageNo > 1){
					$(".confFooter").append(
							'<button type="button" class="btn btn-primary" id="prevBtn" onclick="CONF.gitPrev();>이전</button>'
						+	'<button type="button" class="btn btn-danger" id="commitCalc" data-toggle="modal" data-target="#gitModal">Commit 확인</button>'
					);
				} else if(array.length == 100 && pageNo == 1){
					$(".confFooter").append(
							'<button type="button" class="btn btn-default" id="nextBtn" onclick="CONF.gitNext();>다음</button>'
						+	'<button type="button" class="btn btn-danger" id="commitCalc" data-toggle="modal" data-target="#gitModal">Commit 확인</button>'
					);
				} else if(array.length <= 100 && pageNo == 1){
					$(".confFooter").append(
							'<button type="button" class="btn btn-danger" id="commitCalc" data-toggle="modal" data-target="#gitModal">Commit 확인</button>'
					);
				}
			},
			error : function(e) {
				console.log("error");
			}
		});
	},
	
	gitNext: function(){
		CONF.global.number = CONF.global.number + 1; 
		CONF.gitCommitMsg(CONF.global.number);
	},
	
	gitPrev: function(){
		CONF.global.number = CONF.global.number - 1;
		CONF.gitCommitMsg(CONF.global.number);
	},
	
	
}