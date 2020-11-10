/**
 *  2020.11.09
 *  형상관리 스크립트
 *  by. Hanker
 */

var CONF = {
	global : {

	},
	
	
	confManage: function(){
		$(".liActive").removeClass("liActive");
		
		location.href="/config/listView";
	},
	
	gitCommitMsg: function(){
		var owner = $("#owner").val();
		var repos = $("#repos").val();
		
		var pageNo = 0;
		var auth = window.btoa("");
		$.ajax({
			type : "GET",
			headers : {
				Authorization : "Basic " + auth,
			},
			url : "https://api.github.com/repos/"+owner+"/"+repos+"/commits?page="+pageNo,
			dataType : "json",
			success : function(response) {
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
			},
			error : function(e) {
				console.log("error");
			}
		});
	}
	
	
}