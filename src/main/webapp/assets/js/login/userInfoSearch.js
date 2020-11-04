/**
 * 
 */

var USIC = {
	global : {

	},
	
	idSearch:function(){
		 var $active = $('.wizard .nav-tabs li.active');
	     nextTab($active);
	     
	},
	
	pwSearch:function(){
		var $active = $('.wizard .nav-tabs li.active');
	    nextTab($active);
	    
		$("#idSearch").css("display", "none");
		$("#pwSearch").css("display", "block");
	},
	
	emailCert:function(){
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(!re.test($("#email").val())){
			swal("Email 형식이 맞지 않습니다.", "", "error");
			return false;
		}
		var data = {
				EMAIL : $("#email").val()
		};
		
		$.ajax({
			url : '../login/idSearch',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				console.log(rs);
				if(rs.SC == "SUCCESS"){
					console.log("인증번호 발송 성공");
				}
				
				if(rs.SC == "FAILED"){
					swal("Email이 없습니다. Email을 확인해주세요.", "", "error");
					return false;
				}
				
			},
			beforeSend:function(){
				$('.wrap-loading').removeClass('display-none');
			},
			complete:function(){
				$('.wrap-loading').addClass('display-none');
			}
		});
		
	}
}
