<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>달력 만들기</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../assets/js/hkGroup/config.js"></script>
</head>
<style>
	#custom_set_date > tr > td {
	    text-align: center;
	    border: 2px solid black;
	    height: 50px;
	    width: 50px;
	}
	
	.select_day{
		background-color: black;
		color: orange;
	}
	
	.gitCommitDay{
		background-color: black;
		color: orange;
	}
	
	.cal_week > tr > th {
		text-align:center;
	}
	
	
</style>
<body>
    <div id="calendarForm"></div>
</body>
<script>



(function () {
	//calendarMaker($("#calendarForm"), new Date(), gitDate);
})();

function testfn(){
	calendarMaker($("#calendarForm"), new Date());
}

function gitDatePull(){
    var owner = $("#gitOwner").val();
	var repos = $("#gitRepos").val();
    
	console.log(owner);
	console.log(repos);
    $.ajax({
    	type: 'GET',
    	url : "https://api.github.com/repos/"+owner+"/"+repos+"/commits?per_page=100",
    	dataType: "json",
    	success: function(response){
    		var array = response;
			var max = array.length;
			console.log(array[0]);
			//날짜 채우기
			for(j = 0 ; j <= max ; j++){
				var cal = array[j].commit.author.date;
				var result = cal.split('T', 1);
				
				var gitDate = result.toString();
				var gitDt = gitDate.split('-');
			}
			
    	},
    	error:function(){
    		console.log("error");
    	}
    });
}

var nowDate = new Date();
function calendarMaker(target, date) {
	
    if (date == null || date == undefined) {
        date = new Date();
    }
    nowDate = date;
    if ($(target).length > 0) {
        var year = nowDate.getFullYear();
        var month = nowDate.getMonth() + 1;
        $(target).empty().append(assembly(year, month));
    } else {
        console.error("custom_calendar Target is empty!!!");
        return;
    }

    var thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1);
    var thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, 0);
	
    
    

    var tag = "<tr>";
    var cnt = 0;
    //빈 공백 만들어주기
     for (i = 0; i < thisMonth.getDay(); i++) {
        tag += "<td></td>";
        cnt++;
     }
    
    //날짜 채우기
    for (i = 1; i <= thisLastDay.getDate(); i++) {
        if (cnt % 7 == 0) { tag += "<tr>"; }
		var flag = false;
		
        for(var j = 0 ; j < CONF.global.gitDate.length ; j++){
        	var gitDate = CONF.global.gitDate[j].toString();
        	var result = gitDate.split('T', 1);
        	var gitDt = result.toString().split('-');
        	
        	if(year == gitDt[0] && month == gitDt[1] && i == gitDt[2]){
        		flag = true;
        		break;
        	}
        }
        
        if(flag){
           	tag += "<td id="+ i +" class='gitCommitDay'>" + i + "</td>";
        } else{
           	tag += "<td id="+i+">" + i + "</td>";	
        }
        //tag += "<td id="+i+">" + i + "</td>";
        cnt++;
        if (cnt % 7 == 0) {
            tag += "</tr>";
        }
    }
    
    
    $(target).find("#custom_set_date").append(tag);
    calMoveEvtFn();

    function assembly(year, month) {
        var calendar_html_code =
            "<table class='custom_calendar_table' style='width:100%'>" +
            "<thead class='cal_date'>" +
            "<th><button type='button' class='prev'><</button></th>" +
            "<th colspan='5' style='text-align: center;'><p><span>" + year + "</span>년 <span>" + month + "</span>월</p></th>" +
            "<th style='text-align: right;'><button type='button' class='next'>></button></th>" +
            "</thead>" +
            "<thead  class='cal_week'>" +
            "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
            "</thead>" +
            "<tbody id='custom_set_date'>" +
            "</tbody>" +
            "</table>";
        return calendar_html_code;
    }

    function calMoveEvtFn() {
        //전달 클릭
        $(".custom_calendar_table").on("click", ".prev", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() - 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //다음날 클릭
        $(".custom_calendar_table").on("click", ".next", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
    }
}
</script>
</html>